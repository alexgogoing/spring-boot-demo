package org.example.demo.mvc.controller;

import org.example.demo.component.MyThread;
import org.example.demo.mvc.service.AddressService;
import org.example.demo.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private MyThread myThread;

    @Autowired
    private AddressService addressService;

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Object addAddress(Address obj){
//        return addressService.addAddress(obj);
//    }

    @RequestMapping(value = "/startGetIp", method = RequestMethod.GET)
    public String getIp(){
        myThread.start();
        return IpUtil.getInternetIp();
    }
}
