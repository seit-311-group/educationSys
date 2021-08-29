package cn.sysu.educationSys.utils;

import cn.sysu.educationSys.gRPCclient.KGClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class KGUtil {
    public static String[] extend(String word) throws InterruptedException {
        String target = "172.18.218.31:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        try {
            KGClient client = new KGClient(channel);
            String ans = client.KG(word);
            return ans.split(" ");
        }finally {
            channel.shutdownNow().awaitTermination(50, TimeUnit.SECONDS);
        }
    }
}
