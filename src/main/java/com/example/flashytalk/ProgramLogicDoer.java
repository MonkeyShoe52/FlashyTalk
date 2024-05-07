package com.example.flashytalk;

import com.example.flashytalk.DopeDattta;

public class ProgramLogicDoer implements Runnable{

    DopeDattta inData;
    public ProgramLogicDoer(DopeDattta inData) {
        this.inData = inData;
    }


    public void run() {
        Object inMessage1 = inData.get();
        while (true) {
            if (inMessage1 != null) {
                System.out.println(inMessage1);
            }
            inMessage1 = inData.get();
        }
    }
}

