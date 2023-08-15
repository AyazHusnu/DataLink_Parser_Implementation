package com.frontend;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.frontend.GreetServer.GreeterImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import protocomp.GreeterGrpc;
import protocomp.TrackResponse;
import protocomp.TrackMessage;

public class App extends Application {

    private static VBox vbox;
    private static final Logger logger = Logger.getLogger(GreetServer.class.getName());
    private Server server;
    @Override
    public void start(Stage primaryStage) {

        vbox = new VBox(10); // 10: Differentiates the distance between labels.
        vbox.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
        
        Scene scene = new Scene(vbox, 600, 600);

        primaryStage.setTitle("GUI");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start a new thread to read input and update the GUI
        /* new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                Track track = initializeTrackFromConsole();
                updateLabels(track);
            }
        }).start(); */
    }

    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void greet(TrackMessage req, StreamObserver<TrackResponse> responseObserver) {
           logger.info("Got request from client: ");
           System.out.println(req.toString());
           TrackResponse reply = TrackResponse.newBuilder()
           .setMessage("got it")
           .build();
           Track track = new Track((int)req.getTrackID(), 
           (int)req.getTrackHeading(),(int)req.getTrackSpeed(),(short)req.getTrackLatitude(),(short) req.getTrackLongitude());
           App.updateLabels(track);
           responseObserver.onNext(reply);
           responseObserver.onCompleted();
        }
     }
     
   private void start2() throws IOException {
      
      int port = 50051;

      server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();
       
      logger.info("Server started, listening on " + port);
 
      Runtime.getRuntime().addShutdownHook(new Thread() {
         @Override
         public void run() {
            System.err.println("Shutting down gRPC server");
            try {
               server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
               e.printStackTrace(System.err);
            }
         }
      });
   }
    public static void updateLabels(Track track) {
        // Update the GUI on the JavaFX Application Thread using Platform.runLater
        Platform.runLater(() -> {
            Label trackLabel = new Label();
            trackLabel.setText("Track ID: " + track.get_trackID() +
                               "\nTrack Heading: " + track.get_trackHeading() +
                               "\nTrack Speed: " + track.get_trackSpeed() +
                               "\nTrack Latitude: " + track.get_trackLatitude() +
                               "\nTrack Longitude: " + track.get_trackLongitude());
            vbox.getChildren().addAll(trackLabel);
        });
    }

    /* public Track initializeTrackFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Track ID: ");
        int trackID = scanner.nextInt();

        System.out.println("Enter Track Heading: ");
        int trackHeading = scanner.nextInt();

        System.out.println("Enter Track Speed: ");
        int trackSpeed = scanner.nextInt();

        System.out.println("Enter Track Latitude: ");
        short trackLatitude = scanner.nextShort();

        System.out.println("Enter Track Longitude: ");
        short trackLongitude = scanner.nextShort();

        // Create the track object
        Track track = new Track(trackID, trackHeading, trackSpeed, trackLatitude, trackLongitude);
        return track;
    } */

    public static void main(String[] args) throws IOException {
        final App greetServer = new App();
        new Thread(() -> {
            try {
                greetServer.start2(); // Sunucuyu başlat
                greetServer.server.awaitTermination(); // Sunucunun sonlandırılmasını beklet
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        launch(args);
    }
}