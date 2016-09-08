//package com.tiy.chatappandroid;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class ChatClient{
//
//    final String HOST_ADDRESS = "127.0.0.1";
//
//    final int PORT_NUMBER = 8005;
//
//    PrintWriter outputToServer;
//
//    Socket clientConnection;
//
//    BufferedReader inputFromServer;
//
//
//    public void runClient(){
//        try{
//            clientConnection = new Socket(HOST_ADDRESS,PORT_NUMBER);
//
//            System.out.println("connection established...");
//
//            outputToServer = new PrintWriter(clientConnection.getOutputStream(), true);
//            inputFromServer = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
//
//
//
//
//
//
//
//
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }
//    }
//
//}