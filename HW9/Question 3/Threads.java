package javaWork;

import java.util.*;
import java.io.*;
import java.net.*;
 
public class Threads{
 
    public static void main(String[] args) throws Throwable{
        economy myeconomy = new economy();
 
        Thread t1 = new Thread(new producer(myeconomy));
        Thread t2 = new Thread(new consumer(myeconomy));
 
        t2.start();
        t1.start();
        
        t2.join();
        t1.join();
    }
}
 
class producer implements Runnable{
    economy e;
 
    producer(economy e){
        this.e = e;
    }
 
    public void run(){
        try{
            e.producer();
        }catch(Throwable t){
        	t.printStackTrace();
        }
    }
}
 
class consumer implements Runnable{
    economy e;
 
    consumer(economy e){
        this.e = e;
    }
 
    public void run(){
        try{
            e.consumer();
        }catch(Throwable t){
        	t.printStackTrace();
        }
    }
}
 
class economy{
    boolean product = false;
 
    public synchronized void producer() throws Throwable{
        System.out.println("Running producer");
        while(true){
            if(product == true){
                try{
                    System.out.println("Producer: Too much product exists. Gonna wait...");
                    wait();
                }catch(Throwable t){
                	t.printStackTrace();
                }
            }
            System.out.println("Producer: Making more product now.");
            product = true;
            notifyAll();
            Thread.sleep(1000);
            System.out.println("Producer ending");
 
        }
    }
 
    public synchronized void consumer() throws Throwable{
        System.out.println("Running Consumer");
        while(true){
            if(product == false){
                try{
                    System.out.println("Consumer: No products available to consume. Gonna wait...");
                    wait();
                }catch(Throwable t){
                	t.printStackTrace();
                }
            }
 
            System.out.println("Consumder: Now consuming product");
            product = false;
            notifyAll();
            Thread.sleep(1000);
            System.out.println("Consumer ending");
        }
    }
}