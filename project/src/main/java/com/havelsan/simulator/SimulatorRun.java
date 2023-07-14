package com.havelsan.simulator;

import java.io.IOException;
import java.util.List;

import com.havelsan.exceptions.EmptyFileException;
import com.havelsan.exceptions.NotSixtyFourBitDataException;
import com.havelsan.exceptions.NullLineException;

public class SimulatorRun {
    public static void main(String[] args) throws IOException, NullPointerException{
        
        /*
         * Read file names from the console
         */
        Client client = new Client();

        String fileName = "project\\src\\main\\java\\com\\havelsan\\binary_data\\data_1.txt";
        
        
        try {
            
            FileReader file = new FileReader(fileName);
            List<String> ls = file.readData();

            for (int i = 0; i < ls.size(); i++) {
                client.startConnection("127.0.0.1", 5000);

                String msg = ls.get(i);
                client.sendMessage(msg);
                
                client.stopConnection();
            }

        }
        catch (NullLineException e){
            System.out.println("\nERROR: Empty line has been detected in the related file!\n");
        }
        catch (EmptyFileException e) {
            System.out.println("\nERROR: File is empty! Fill the file and try it again!\n");
        } 
        catch (NotSixtyFourBitDataException e) {
            System.out.println("\nERROR: File read contains data not 64-bit!\n");
        }
        catch (NullPointerException e) {
            // Not found file is trying to read!
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
