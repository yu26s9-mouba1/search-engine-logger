package com.pluralsight;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class SearchEngineLogger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        logActivity("Launch");

        while (true){

            System.out.println("Enter a search term (X to exi)");
            String searchTerm = scanner.nextLine();

            if (searchTerm.equalsIgnoreCase("x")){
                logActivity("exit");
                break;

            }else{
                logActivity("search: " + searchTerm);
            }

        }
         scanner.close();

    }

    public static void logActivity(String message){
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timeStamp = dateTime.format(formatter);


            FileWriter fw = new FileWriter("logs.txt", true);
            fw.write(timeStamp + " " + message + "\n");
            fw.close();
        }catch (IOException e){
            System.out.println("Error writing to log file");
        }


    }


}
