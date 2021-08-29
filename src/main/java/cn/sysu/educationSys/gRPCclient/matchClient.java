package cn.sysu.educationSys.gRPCclient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.match.*;

import java.util.concurrent.TimeUnit;


public class matchClient {

  private final MatchGrpc.MatchBlockingStub matchblockingStub;


  /** Construct client for accessing HelloWorld server using the existing channel. */
  public matchClient(Channel channel) {
    matchblockingStub = MatchGrpc.newBlockingStub(channel);
  }

  /** Say hello to server. */
  public void greet(String name) {
    HelloRequest request = HelloRequest.newBuilder().setName(name).build();
    HelloReply response;
    try {
      response = matchblockingStub.sayHello(request);
      System.out.println(response.getMessage());
    } catch (StatusRuntimeException e) {
      return;
    }
  }
  //match
  public int match(String[] sents, String query) {
    QueryRequest.Builder builder = QueryRequest.newBuilder();
    for (String sent : sents) {
      builder.addSentences(sent);
    }
//    builder.addAllSentences(Arrays.asList(sents));
    QueryRequest request = builder.setQuery(query).build();
    QueryReply response;
    try {
      response = matchblockingStub.sentenceMatch(request);
    } catch (StatusRuntimeException e) {
      return -1;
    }
    return response.getResult();
  }

  /**
   * Greet server. If provided, the first element of {@code args} is the name to use in the
   * greeting. The second argument is the target server.
   */
  public static void main(String[] args) throws Exception {
    String user = "hjy";
    // Access a service running on the local machine on port 50051
    String target = "localhost:50051";
    // Allow passing in the user and target strings as command line arguments
    if (args.length > 0) {
      if ("--help".equals(args[0])) {
        System.err.println("Usage: [name [target]]");
        System.err.println("");
        System.err.println("  name    The name you wish to be greeted by. Defaults to " + user);
        System.err.println("  target  The server to connect to. Defaults to " + target);
        System.exit(1);
      }
      user = args[0];
    }
    if (args.length > 1) {
      target = args[1];
    }

    ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
            .usePlaintext()
            .build();
    try {
      matchClient client = new matchClient(channel);
//      client.greet(user);
      String[] sents = {"什么是过渡过程呢","过渡过程的意义",};
      int i = client.match(sents, "过渡过程是什么");
      System.out.println(i);
    } finally {
      // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
      // resources the channel should be shut down when it will no longer be used. If it may be used
      // again leave it running.
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
