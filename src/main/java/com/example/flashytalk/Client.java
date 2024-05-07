package com.example.flashytalk;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to the server");
        Socket newSocket = new Socket("10.37.157.240",3256);
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

        objOut.writeObject("What we doing");
        objOut.writeObject("Yo?");

        System.out.println("Done sending messages");
    }
}
