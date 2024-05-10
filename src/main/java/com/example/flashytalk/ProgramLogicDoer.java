package com.example.flashytalk;

import com.example.flashytalk.DopeDattta;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProgramLogicDoer implements Runnable{

    DopeDattta inData;
    boolean serverMode;
    ObjectOutputStream objOut;
    ClientController theController;
    static ArrayList<ObjectOutputStream> manyOuts = new ArrayList<ObjectOutputStream>();

    public ProgramLogicDoer(DopeDattta inData, ClientController theController)  {
        this.inData = inData;
        manyOuts.add(objOut);
        this.theController = theController;

    }



    public void run() {
        Object inMessage1 = inData.get();
        while (true) {
            if (inMessage1 != null) {
                if (theController != null) {
                    // add the message to your JavaFX Control that displays many messages
                    theController.Client.getItems().add(inMessage1);
                } else {
                    System.out.println(inMessage1);
                }
                try {
                    if (serverMode) {
                        for (ObjectOutputStream eachOut: manyOuts) {
                            eachOut.writeObject("Mr. H overheard: " + inMessage1);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            inMessage1 = inData.get();
        }
    }
}

