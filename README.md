# Tactical Data Parsing and Visualization Project

This project focuses on parsing, interpreting, and visualizing a sample Tactical Data signal of the J.3.2 Air Track message type from Datalink 16's J-series messages received by the Link 16 terminal.

## Project Definition

- We developed a simulator that generates a sample 64-bit J.3.2 Air Track message and sends this data to a specific TCP port.
- Additionally, we implemented a backend component that listens to the data coming from the simulator, parses, and interprets this data.
- As part of the project, we developed the user interface using JavaFX on the frontend. 
- Using gRPC, we made method calls from the frontend for each received and processed data on the backend, then displayed the data on the screen.

## Installation and Usage

To get started with this project, follow these steps:

1. Clone this repository to your local machine:

```bash
  git clone https://github.com/AyazHusnu/DataLink_Parser_Implementation
```
2. We didn't include the JavaFX library in the project due to its size. You'll need to download it manually based on your operating system:
```bash
  https://download2.gluonhq.com/openjfx/17.0.8/openjfx-17.0.8_linux-x64_bin-sdk.zip
```
3. Extract the downloaded zip file. Then, you need to specify this extracted directory within the "launch.json" as shown in the example below:
```bash
  "vmArgs": "--module-path \"/home/ayaz/Downloads/openjfx-17.0.8_linux-x64_bin-sdk/javafx-sdk-17.0.8/lib\" --add-modules javafx.controls,javafx.fxml"

```
4. To open the GUI, you need to run the "App.java" in the frontend side.
Then, you will see that our interface and gRPC server are up and running

5. To get ready for listening to the J.3.2 Air Track data from the simulator, you need to run the "ServerRun.java" file.
After running it, you will see that the server has started listening and is ready to interpret each incoming data and make remote produce calls from frontend.

6. To transmit different J.3.2 type Link 16 signals to port 5000 on the backend at 5-second intervals, you need to run the "SimulatorRun.java" file.
In the graphical user interface, you will see that data from the same aircraft is updated, and data from different aircraft is added.





