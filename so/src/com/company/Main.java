package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();

        long l = Long.parseLong("2971215073");

        //PARA EXECUTAR SEQUENCIALMENTE
        primo(l);
        //PARA EXECUTAR EM THREAD
        //primo2(2971215073);

        long tempoFinal = System.currentTimeMillis();
        System.out.println("Executou em: " + (tempoFinal - tempoInicial)/1000F);
    }


    public static void primo2(long n){ // EM THREAD
        Thread[] threads = new Thread[10000]; // ALTERA A QUANTIDADE DE THREADS
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    int contador = 0;

                    for (int i = 2; i <= n; i++){
                        if (n % i == 0){
                            contador++;
                        }
                    }
                    if (contador > 2){
                        System.out.println(n + " não é primo !");
                    }else{
                        System.out.println(n + " é primo!");
                    }
                }
            });
            threads[i].start();
        }
    }


    public static void primo(long n){
        int contador = 0;

        for (int i = 2; i <= n; i++){
            try{
                if (n % i == 0){
                    contador++;
                }
            }catch (ArithmeticException e){
                System.out.println("erro");
            };

        }
        if (contador > 2){
            System.out.println(n + " não é primo !");
        }else{
            System.out.println(n + " é primo!");
        }

    }
}
