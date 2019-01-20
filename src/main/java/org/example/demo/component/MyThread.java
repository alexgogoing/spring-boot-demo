package org.example.demo.component;

import org.example.demo.mvc.service.AddressService;
import org.example.demo.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyThread extends Thread{

    @Autowired
    private AddressService addressService;

    //轮询发生次数
    private int num = 0;

    //轮询间隔
    private static final int interval = 5 * 60 * 1000;

    private static String currentIp = null;

    @Override
    public void run() {
        while(true){
            if(currentIp == null){
                String ip = addressService.getRecentIp();
                if(ip != null){
                    currentIp = ip.trim();
                }else{
                    try {
                        throw new Error("addressService getRecentIp No Result");
                    } catch (Error e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
            System.out.println("任务执行" + num + "次");
            String remoteIp = IpUtil.getInternetIp().trim();
            try {
                if(currentIp != remoteIp){
                    //send email
                }
                sleep(interval);
                num++;
                if(num == 1){
                    System.out.println("任务执行终了");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            } catch(Error e){
                e.printStackTrace();
                break;
            }
        }
    }

}
