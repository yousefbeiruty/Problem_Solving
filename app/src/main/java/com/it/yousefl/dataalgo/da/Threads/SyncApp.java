package com.it.yousefl.dataalgo.da.Threads;

public class SyncApp {

    static class Printer {
//      synchronized   void printDocuments(int numOfCopies, String docName) {
void printDocuments(int numOfCopies, String docName) {
            for (int i = 1; i <= numOfCopies; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(">>Printing Document " + docName + " " + i);
            }
        }
    }

    static class MyThread extends Thread {
        Printer printer;

        MyThread(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            synchronized (printer){
                printer.printDocuments(10, "JonsProfile");
            }
        }
    }

    static class YourThread extends Thread {
        Printer printer;

        YourThread(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            synchronized (printer) {
                printer.printDocuments(10, "FionasProfile");
            }
        }
    }

    //main is representing main thread
    public static void main(String[] args) {
        System.out.println("===Application Started====");


        //We have only one single object of Printer
        Printer printer = new Printer();
      //  printer.printDocuments(10, "IshantsProfile.pdf");

        //Scenario is that we have multiple threads working on the same time Printer Object
        //If Multiple Threads are going to work on the same single object We Must Synchronized them
        MyThread myThread = new MyThread(printer);//MyThread is having reference to the Printer object
        YourThread yourThread=new YourThread(printer);//YourThread is having reference to the Printer object
        myThread.start();
//        try {
//            myThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        yourThread.start();

        System.out.println("===Application Finished====");

    }
}
