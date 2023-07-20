package com.simulator;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

import com.simulator.exceptions.EmptyFileException;
import com.simulator.exceptions.NotSixtyFourBitDataException;
import com.simulator.exceptions.NullLineException;

public class FileReader {

    File file;
    Scanner scanner;

    public FileReader(String filename) {
        try {
        file = new File(filename);
        scanner = new Scanner(file);} 
        catch (FileNotFoundException e) {
            System.out.println("\nERROR: Indicated file has not found!\n");
        }
    }

    public List<String> readData() throws Exception {

        /* 
        control 64-bit data
        control if the data exists in form of 1's and 0's
        control if the file is empty
        */
    
        List<String> dataList = new ArrayList<String>();
        boolean fileEmpty = true;


        while (scanner.hasNextLine()) {
            fileEmpty = false;

            String data = scanner.nextLine();

            if (data.equals("")) {
                throw new NullLineException("Empty line detected!");
            }

            else if (data.length() != 64 || !data.matches("[0-1]+")) {
                throw new NotSixtyFourBitDataException("Not 64-bit data!");
            }

            dataList.add(data);
          }

        if (fileEmpty == true) {
            throw new EmptyFileException("File is empty!");
        }

        return dataList;
    }
}