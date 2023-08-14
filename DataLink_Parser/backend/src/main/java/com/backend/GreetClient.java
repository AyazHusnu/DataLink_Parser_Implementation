package com.backend;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import protocomp.GreeterGrpc;
import protocomp.TrackResponse;
import protocomp.TrackMessage;

public class GreetClient {
   private static final Logger logger = Logger.getLogger(GreetClient.class.getName());
   private final GreeterGrpc.GreeterBlockingStub blockingStub;
   
   public GreetClient(Channel channel) {
      blockingStub = GreeterGrpc.newBlockingStub(channel);
   }
 
   public void makeGreeting(Track track1) {

      logger.info("Sending greeting to server: ");

      TrackMessage request = TrackMessage.newBuilder()
                              .setTrackID(track1.get_trackID())
                              .setTrackHeading(track1.get_trackHeading())
                              .setTrackSpeed(track1.get_trackSpeed())
                              .setTrackLatitude(track1.get_trackLatitude())
                              .setTrackLongitude(track1.get_trackLongitude())
                              .build();
      
      logger.info("Sending to server: " + request);

      TrackResponse response;

      try {
         response = blockingStub.greet(request);
      } 
      catch (StatusRuntimeException e) {
         logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
         return;
      }

      logger.info("Got following from the server: " + response.getMessage());
   }

   /* public static void main(String[] args) throws Exception {

      String greeting = "Hello";
      String serverAddress = "localhost:50051";

	   ManagedChannel channel = ManagedChannelBuilder.forTarget(serverAddress)
         .usePlaintext()
         .build();

      try {
         GreetClient client = new GreetClient(channel);
         client.makeGreeting();
      } 
      finally {
         channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
      }
   } */
}