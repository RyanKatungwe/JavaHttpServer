/**
 *  http server
 */


package org.oak;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {
    private static int requestCount = 0;
    private static final int PORT = 50000;

    public static void startServer(){
        try{
            ServerSocket httpServer = new ServerSocket(PORT);
            System.out.println("Server listening on port" + PORT);
            Socket client = new httpServer.accept();
            new Thread(() -> handle(client)).start();

        } catch(IOException error){
            error.printStackTrace();
        }
    }

    public static void handle(Socket client){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());

            String line;
            while ((line = in.readLine()) != null){
                out.println(line);
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }
    public static void incrementRequestcount(){
        requestCount = requestCount + 1;
    }
}
