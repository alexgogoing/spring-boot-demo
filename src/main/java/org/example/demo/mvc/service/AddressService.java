package org.example.demo.mvc.service;

import org.example.demo.mvc.dao.AddressRepository;
import org.example.demo.mvc.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("addressService")
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Object addAddress(Address obj){
        Object result = addressRepository.save(obj);
        Map resMap = new HashMap<String, String>();
        resMap.put("status", 0);
        resMap.put("message", "success");
        resMap.put("data", result);
        return resMap;
    }

    public String getRecentIp(){
        List<Address> result = addressRepository.getLatestOne();
        if(result.size() > 0){
            return result.get(0).getIp();
        }else{
            return null;
        }
    }

}
