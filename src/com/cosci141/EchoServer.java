/**
 * Albert Toscano and Dorothy Nguyen
 * October 1, 2021
 * CECS 326 - Operating Systems
 * Project 1: Warm up of Interprocess Communication
 *
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result.
 */
package com.cosci141;

import java.net.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class EchoServer {
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();                                        // to get the initial time in milliseconds
        try{
            ServerSocket sock = new ServerSocket(6017);                                 // The server listens to port 6013
            System.out.println("Server is listening on port " + 6017);

            /* now listen for connections*/
            Socket client = sock.accept();                                                  // The server begins listening to the port
            System.out.println("New client connected.");

            InputStream in = client.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));             // to read the buffer
            PrintWriter pout1 = new PrintWriter(client.getOutputStream(), true);   // It allows the server to write to the socket
            String line;
            while((line = bin.readLine()) != null || in.read() != -1){                      // While the user is connected echo message
                line = line.replace("client", "user");                   // Replacing client for user
                line = line.replace("server", "client");                 // Replacing server for client
                line = line.replace("user", "server");                   // Replacing user for server
                pout1.println(line);                                                        // It writes the quote to the socket

            }
            System.out.println("Client disconnected");
            long end_time = System.currentTimeMillis();                                     // To get the current time in milliseconds
            NumberFormat formatter = new DecimalFormat("#0.000");                   // Format to get three decimal places
            System.out.println("Runtime: " + formatter.format                               // Display runtime
                    ((end_time - start_time) / 1000d) + " seconds");
            client.close();                                                                 /* close the socket */
        }
        catch (IOException ioe){
            System.err.println(ioe);
        }

    }
}
