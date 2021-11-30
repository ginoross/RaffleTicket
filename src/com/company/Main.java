package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String buyCheck = "";
        String name = "";
        int raffleNum = 0;
        int numOfTickets = 0;
        boolean quit = false;
        Object checkInt = numOfTickets;
        while (!quit) {
            buyCheck = mainMenu();

            quit = isQuit(buyCheck, quit);

        }


    }

    private static boolean isQuit(String buyCheck, boolean quit) {
        int raffleNum;
        int numOfTickets;
        String name;
        switch (buyCheck) {
            case "B":
                System.out.println("Please enter your name: ");
                name = inputNext();
                System.out.println("Please enter how many tickets you want to buy: ");
                numOfTickets = inputNextInt();
                raffleDictAppend(name, numOfTickets);
                printTickets(name, "You have these raffle tickets: ");
                System.out.println("You owe me " +numOfTickets+" quid bruv");
                break;
            case "C":
                name = getRaffleName();
                printTickets(name, "You have a raffle tickets with these numbers: ");
                raffleNum = getRaffleNum(name);
                checkPrime(raffleNum);
                break;
            case "Q":
                quit = true;

        }
        return quit;
    }

    private static void checkPrime(int raffleNum) {
        int finalRaffleNum = raffleNum;
        if (IntStream.range(2, raffleNum).noneMatch(x -> finalRaffleNum % x == 0)) {
            System.out.println("You win");
            return;
        } else {
            System.out.println("You lose");
            return;
        }
    }

    private static int getRaffleNum(String name) {
        int raffleNum;
        System.out.println("Please enter the number you would like to check: ");
        raffleNum = inputNextInt();
        if (!raffleDict.get(name).contains(raffleNum)) {
            do {
                System.out.println("Please enter a valid number you want to check: ");
                raffleNum = inputNextInt();
            } while (!raffleDict.get(name).contains(raffleNum));
        }
        return raffleNum;
    }

    private static String getRaffleName() {
        String name;
        System.out.println("Please enter your name: ");
        name = inputNext();
        if (!raffleDict.containsKey(name)) {
            do {
                System.out.println("Please enter a valid name: ");
                name = inputNext();
            } while (!raffleDict.containsKey(name));
        }
        return name;
    }

    private static void printTickets(String name, String s) {
        for (Map.Entry<String, List<Integer>> entry : raffleDict.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println(s + entry.getValue());
            }
        }
    }

    private static void raffleDictAppend(String name, int numOfTickets) {
        int raffleNum;
        for (int i = 0; i < numOfTickets; i++) {
            raffleNum = getRaffleNum();
            if (raffleDict.containsKey(name)) {
                raffleDict.get(name).add(raffleNum);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(raffleNum);
                raffleDict.put(name, list);
            }
        }
    }

    private static String mainMenu() {
        String buyCheck;
        do {
            System.out.println("Would you like to ask for a ticket or purchase a ticket? Enter B to buy, C to check or Q to quit: ");
            buyCheck = inputNext();
            buyCheck = buyCheck.toUpperCase();
        } while (!buyCheck.equals("B") && !buyCheck.equals("C") && !buyCheck.equals("Q"));
        return buyCheck;
    }

    private static int getRaffleNum() {
        int raffleNum;
        Random random = new Random();
        raffleNum = random.nextInt(1000);
        return raffleNum;
    }

    public static String inputNext() {
        String input = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            input = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println("Error with the buffered string reader");
        }

        return input;
    }

    public static int inputNextInt() {
        int input = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            System.out.println("Error with the buffered int reader, try entering a number");
        }
        return input;
    }

    public static Map<String, List<Integer>> raffleDict = new HashMap<String, List<Integer>>();


}
