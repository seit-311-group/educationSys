package cn.sysu.educationSys.utils;

import org.springframework.stereotype.Component;

@Component
public class FunctionSim {

    // 使用两个线程来判断
    public double calSimilarity(String E1, String E2){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        return 0.0;
    }


}
