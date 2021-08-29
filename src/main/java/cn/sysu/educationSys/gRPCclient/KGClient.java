package cn.sysu.educationSys.gRPCclient;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.helloworld.*;


public class KGClient {

    private final GreeterGrpc.GreeterBlockingStub KG4QAblockingStub;

    public KGClient(Channel channel) {
        KG4QAblockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void greet(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = KG4QAblockingStub.sayHello(request);
            System.out.println(response.getMessage());
        } catch (StatusRuntimeException e) {
            return;
        }
    }

    public String KG(String word) {
        circuitRequest.Builder builder = circuitRequest.newBuilder();

        circuitRequest request = builder.setName(word).build();
        circuitReply response;
        try {
            response = KG4QAblockingStub.kG(request);
        } catch (StatusRuntimeException e) {
            return "错误";
        }
        return response.getMessage();
    }
}
