package com.appsenseca.pageobjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by joserran on 10/8/2015.
 */
public class AccessProperties {
     public static String getUserName(String FileName) {

         String[] accessArgs = new String[2];
         try {
             Scanner in = new Scanner(new File(FileName));
             accessArgs[0] = in.next();
             accessArgs[1] = in.next();
             in.close();
         }
         catch(FileNotFoundException e) {
            System.out.println("File not found" + e);
         }

         return accessArgs[0];
    }

    public static String getUserPassword(String FileName) {

        String[] accessArgs = new String[2];
        try {
            Scanner in = new Scanner(new File(FileName));
            accessArgs[0] = in.next();
            accessArgs[1] = in.next();
            in.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found" + e);
        }

        return accessArgs[1];
    }

}
