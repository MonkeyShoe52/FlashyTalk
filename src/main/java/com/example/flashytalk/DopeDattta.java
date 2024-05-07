package com.example.flashytalk;

public class DopeDattta { Object[] objects = new Object[100];


    int spotVar = 0;




    public synchronized boolean put(Object obj) {
        if(spotVar<100){
            objects[spotVar]= obj;
            spotVar=spotVar+1;
        }else{
            spotVar = 0;
            objects[spotVar]= obj;
            spotVar=spotVar+1;
        }
        return false;
    }
    public synchronized Object get() {
        if(spotVar>0){
            Object value = objects[spotVar-1];
            objects[spotVar-1] = null;
            spotVar = spotVar-1;
            return value;
        }else{
            spotVar = 100;
            Object value = objects[spotVar-1];
            objects[spotVar-1] = null;
            spotVar = spotVar-1;
            return value;
        }
    }
}
