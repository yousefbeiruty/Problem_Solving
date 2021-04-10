package com.it.yousefl.dataalgo.da.Threads;


public class App {

//    public static class MyTask{
//
//        void executeTask(){
//            for (int document = 1; document <=10 ; document++) {
//                System.out.println("@@ Print Document #"+document+" Printer2");
//            }
//        }
//    }

    //MyTask Is A Thread
//    public static class MyTask extends Thread {
//
//        @Override
//        public void run() {
//            for (int document = 1; document <= 10; document++) {
//                System.out.println("@@ Print Document #" + document + " Printer2");
//            }
//        }
//    }

    static class CA {

    }

    //  public static class MyTask extends CA, Thread { -->Error | Multiple Inheritance isn't supported in Java
    public static class MyTask extends CA implements Runnable {
        @Override
        public void run() {
            for (int document = 1; document <= 10; document++) {
                System.out.println("@@ Print Document #" + document + " Printer2");
            }
        }
    }

    public static class YourTask extends CA implements Runnable {
        @Override
        public void run() {
            for (int document = 1; document <= 10; document++) {
                System.out.println("** Print Document #" + document + " Printer3");
            }
        }
    }

    //main method represents main thread
    public static void main(String[] args) {
        //What ever we write in here will be executed by main thread
        //Threads always execute the jobs in a sequence
        //Execution Context

        //Job1
        System.out.println("===Application Started===");

        //Job2
        // MyTask task = new MyTask();//Child Thread / Worker Thread
        // task.executeTask();
        //  task.start();//-->start shall internally execute  run method

        Runnable r = new MyTask();
        Thread task = new Thread(r);
        task.setDaemon(true);
        task.start();

//        Thread yourTas=new Thread(new YourTask());
//        yourTas.start();
        new Thread(new YourTask()).start();


        //Till Job2 is not finished, below written jobs are waiting  and are not executed
        //In case Job2 is a long running operation, i.e. several documents are suppose to be printed
        //In such a use case OS/JVM shall give a message that app is not responding
        //Some sluggish behaviour in app can be observed -->App seems to hang


        //Now, main and MyTask are executing both parallely or concurrently !!

        //Job3
        //Some code to print the documents
        for (int document = 1; document <= 10; document++) {
            System.out.println("^^ Print Document #" + document + " Printer1");
        }

        //Job4
        System.out.println("===Application Finished===");

    }
}
