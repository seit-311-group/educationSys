package cn.sysu.circuitQA;

import cn.sysu.circuitQA.gRPCclient.KGClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class grpcTest {
    @Test
    public void kgtest() throws InterruptedException {
        String target = "172.18.218.31:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        try {
            KGClient client = new KGClient(channel);
            String ans = client.KG("电阻");
            System.out.println(ans);
        } finally {
            channel.shutdownNow().awaitTermination(50, TimeUnit.SECONDS);
        }
    }
    @Test
    public void hwtest() throws InterruptedException {
        String target = "172.18.218.31:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        try {
            KGClient client = new KGClient(channel);
            client.greet("电阻");
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
