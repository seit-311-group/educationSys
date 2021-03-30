package cn.sysu.circuitQA.utils;

import cn.sysu.circuitQA.gRPCclient.KGClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

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
