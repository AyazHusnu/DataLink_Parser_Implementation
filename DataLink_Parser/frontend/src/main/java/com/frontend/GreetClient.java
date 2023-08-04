package com.frontend;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import protocomp.GreeterGrpc;
import protocomp.TrackRequest;
import protocomp.TrackMessage;

public class GreetClient {
   private static final Logger logger = Logger.getLogger(GreetClient.class.getName());
   private final GreeterGrpc.GreeterBlockingStub blockingStub;
   
   public GreetClient(Channel channel) {
      blockingStub = GreeterGrpc.newBlockingStub(channel);
   }
 
   public void makeGreeting(String greeting) {

      logger.info("Sending greeting to server: " + greeting);

      TrackRequest request = TrackRequest.newBuilder()
      .setMessage("Update Tracks")
      .build();
      
      logger.info("Sending to server: " + request);

      TrackMessage response;

      try {
         response = blockingStub.greet(request);
      } 
      catch (StatusRuntimeException e) {
         logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
         return;
      }

      logger.info("Got following from the server: " + response.getTrackID());
   }

   public static void main(String[] args) throws Exception {

      String greeting = "Hello";
      String serverAddress = "localhost:50051";

	   ManagedChannel channel = ManagedChannelBuilder.forTarget(serverAddress)
         .usePlaintext()
         .build();

      try {
         GreetClient client = new GreetClient(channel);
         client.makeGreeting(greeting);
      } 
      finally {
         channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
      }
   }
}