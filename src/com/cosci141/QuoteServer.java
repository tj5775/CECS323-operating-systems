/**
 * Albert Toscano and Dorothy Nguyen
 * October 1, 2021
 * CECS 326 - Operating Systems
 * Project 1: Warm up of Interprocess Communication
 *
 * Quote server listening to port 6017.
 *
 */
package com.cosci141;
import java.net.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class QuoteServer {
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();                                        // to get the initial time in milliseconds
        try{
            ServerSocket sock = new ServerSocket(6017);                                 // The server listens to port 6013
            System.out.println("Server is listening on port " + 6017);

            /* Array of quotes of the day*/
            String[] quoteDay = {"\"Programmer: A machine that turns coffee into code.\"",
                                "\"Computers are fast; programmers keep them slow.\"",
                                "\"Always code as if the person who ends up maintaining your code will be a violent psychopath who knows where you live.\"",
                                "\"There are two ways to write error-free programs; only the third works.\"",
                                "\"If debugging is the process of removing bugs, then programming must be the process of putting them in.\""};
            Random random = new Random();                                                       // Creating a random variable


            /* now listen for connections*/
            while (true){
                Socket client = sock.accept();                                                  // The server begins listening to the port
                System.out.println("New client connected.");
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);    // It allows the server to write to the socket
                int randomIndex = random.nextInt(quoteDay.length);                              // Random number from 0 o the length of quoteDay - 1
                String quote = "Quote of the day -  " + quoteDay[randomIndex];                  // It gets a random quote of the day
                pout.println(quote);                                                            // It writes the quote to the socket
                long end_time = System.currentTimeMillis();                                     // To get the current time in milliseconds
                NumberFormat formatter = new DecimalFormat("#0.000");                   // Format to get three decimal places
                System.out.println("Runtime: " + formatter.format                               // Display runtime
                        ((end_time - start_time) / 1000d) + " seconds");

                /* close the socket and resume */
                /* listening for connections */
                client.close();
            }
        }
        catch (IOException ioe){
            System.err.println(ioe);
        }

    }
}
