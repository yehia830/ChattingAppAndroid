package com.tiy.chatappandroid;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{
    ArrayAdapter<String> items;

    ListView list;
    EditText text;
    Button sendButton;
    String chatLine = null;
    String serverResponse = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        sendButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);




    }

    @Override
    public void onClick(View v) {
        String item = text.getText().toString();
        items.add(item);
        text.setText("");
        startClient(item);
        items.add(serverResponse);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View views, int location, long id) {
        String item = items.getItem(location);
        items.remove(item);
        return true;
    }

    public void startClient(String chatString) {

//        Scanner inputScanner = new Scanner(System.in);
        try {
            // connect the server to the port
            Socket clientSocket = new Socket("10.0.0.138", 8005);

            // input and output stream
            PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //convo....
            String userMessage = chatLine;
            outputToServer.println(userMessage);
            serverResponse = ("Server says: " + inputFromServer.readLine());
            System.out.println("The server says:" + serverResponse);

            System.out.println("Connection closing...");
            clientSocket.close();


        } catch (IOException clientException) {
            clientException.printStackTrace();
        }

    }

}