# DataLink_Parser_Implementation
DataLink_Parser_Implementation

We worked on parsing, interpreting, and visualizing a sample Tactical Data signal of the J.3.2 Air Track message type from Datalink 16's J-series messages received by the Link 16 terminal. 
We developed a simulator that generates a sample 64-bit J.3.2 Air Track message and sends this data to a specific TCP port. 
Additionally, we implemented a backend component that listens to the data coming from the simulator, parses, and interprets this data.
As part of the project, we developed the user interface using JavaFX on the frontend. 
Using gRPC, we made method calls from the frontend for each received and processed data on the backend, then displayed the data on the screen.
