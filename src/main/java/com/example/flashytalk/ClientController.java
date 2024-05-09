package com.example.flashytalk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientController {
    @FXML
    public ListView Client;
    public ListView Server;
    public TextField Texting;
    public Button Enter;
    DopeDattta queue;
    ObjectOutputStream objOut;
    ObjectInputStream objIn;

    public void initialize() throws Exception {
        System.out.println("Connecting to the server");
        Socket newSocket = new Socket("10.37.157.240", 3256);
        Socket actualSocket = newSocket;
        OutputStream out = newSocket.getOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        DopeDattta queue = new DopeDattta();
        DataReader myDataReader = new DataReader(actualSocket, queue);
        ProgramLogicDoer myProgramLogicDoer = new ProgramLogicDoer(queue);
        Thread dataReadThread = new Thread(myDataReader);
        Thread programLogicThread = new Thread(myProgramLogicDoer);
        dataReadThread.start();
        programLogicThread.start();
    }


        public void Entertext() throws Exception{
            String message = Enter().getText();
            Enter().clear();
            objOut.writeObject(message);


        }
    }


