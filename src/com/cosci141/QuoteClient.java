/**
 * Albert Toscano and Dorothy Nguyen
 * October 1, 2021
 * CECS 326 - Operating Systems
 * Project 1: Warm up of Interprocess Communication
 *
 * Modified DateClient so that it requests a quote
 * from the quote server.
 */
package com.cosci141;

import java.io.*;
import java.net.*;


public class QuoteClient {

    public static void main(String[] args){
        try{
            Socket sock = new Socket("127.0.0.1", 6017);                // It makes connection to server socket
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));   // to read the buffer

            /* read the date from the socket */
            String line;
            while((line = bin.readLine()) != null){
               System.out.println(line);
            }
            sock.close();                                                         // It closes the socket connection
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }
}
