package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public synchronized static ThreadSafeSingleton getInstance(){
        if (instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

}

