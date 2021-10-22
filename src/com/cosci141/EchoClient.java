/**
 * Albert Toscano and Dorothy Nguyen
 * October 1, 2021
 * CECS 326 - Operating Systems
 * Project 1: Warm up of Interprocess Communication
 *
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
package com.cosci141;

import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args){
        try{
            Socket sock = new Socket("127.0.0.1", 6017);                // It makes connection to server socket

            System.out.println("Connected to the server.");
            PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader
                    (new InputStreamReader(sock.getInputStream()));                 // to read the buffer
            BufferedReader stdIn = new BufferedReader
                    (new InputStreamReader(System.in));                            // to read the user's input
            String userInput;
            while ((userInput = stdIn.readLine()) != null && !userInput.equals("end")){
                pw.println(userInput);
                System.out.println(in.readLine());                                 // It writes the quote to the socket

            }
            sock.close();                                                         // It closes the socket connection
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }
}
