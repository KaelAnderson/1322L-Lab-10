package com.company;

import java.util.Scanner;

public class Main {
    public static int time (String inputTime) throws InvalidTimeException{
        String[] stringArr = inputTime.split(":",3);
        int[] intArr = new int[3];
        for(int i = 0; i < 3; i++){
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        if(intArr[0] > 23){
            throw new InvalidTimeException("Hour must be below 24");
        }
        if(intArr[0] < 0){
            throw new InvalidTimeException("Hour must be above -1");
        }
        if(intArr[1] > 59){
            throw new InvalidTimeException("Minutes must be less than 60");
        }
        if(intArr[1] < 0){
            throw new InvalidTimeException("Minutes must be more than -1");
        }
        if(intArr[2] > 59){
            throw new InvalidTimeException("Seconds must be less than 60");
        }
        if(intArr[2] < -1){
            throw new InvalidTimeException("Seconds must be more than -1");
        }
        return ((intArr[0]*60*60) + (intArr[1]*60) + intArr[2]);
    }





    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1;
        int num2;

    try {
        System.out.print("Enter time 1 in 24hr format as follows (HH:MM:SS)\n");
        String attempt1 = scan.nextLine();
        if (attempt1.length() != 8){
            throw new InvalidTimeException("Enter a valid time");
        } else {
            num1 = time(attempt1);
        }
        System.out.print("Enter time 2 in 24hr format as follows (HH:MM:SS)\n");
        String attempt2 = scan.nextLine();
        if (attempt2.length() != 8){
            throw new InvalidTimeException("Enter a valid time");
        } else {
            num2 = time(attempt2);
        }
        System.out.print("Difference in seconds: " + Math.abs(num1-num2));
        }catch (InvalidTimeException e){
            System.out.print(e);
        }
    }
}
