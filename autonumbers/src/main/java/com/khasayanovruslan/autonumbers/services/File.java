package com.khasayanovruslan.autonumbers.services;

import java.io.*;

public class File {

    public static void appendAutonumber(String filePath, StringBuilder autonumber) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            fileWriter.write(String.valueOf(autonumber)+" ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean findAutonumber(String autonumber) {
        boolean found = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("autonumbers.txt"));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.contains(autonumber))
                        found = true;
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            System.out.println("Error opening file!");;
        }

        return found;
    }
}


