package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String buyCheck = "";
        String name = "";
        int raffleNum = 0;
        do{
            System.out.println("Would you like to ask for a ticket or purchase a ticket? Enter B to buy or C to check: ");
            buyCheck = inputNext();
            buyCheck = buyCheck.toUpperCase();
            System.out.println(buyCheck);
        }while(!buyCheck.equals("B")&&!buyCheck.equals("C"));
        switch(buyCheck){
            case "B":
                System.out.println("Please enter your name: ");
                name = inputNext();
                raffleNum = getRaffleNum();
                System.out.println("Your raffle number is "+raffleNum);
                raffleDict.put(name,raffleNum);



        }



    }

    private static int getRaffleNum() {
        int raffleNum;
        Random random = new Random();
        raffleNum = random.nextInt(1000);
        return raffleNum;
    }

    public static String inputNext(){
        String input = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            input = bufferedReader.readLine();
        }catch(Exception e){
            System.out.println("Error with the buffered string reader");
        }

        return input;
    }
    public static int inputNextint(){
        int input = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(bufferedReader.readLine());
        }catch(Exception e){
            System.out.println("Error with the buffered int reader");
        }
        return input;
    }

    public static Map<String,Integer> raffleDict = new HashMap <String, Integer>();


}
