package MainLesson3;
import java.math.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;



public class Lesson3_Random {               // задаем случайное число

    public static int randVal() {
        Random rand = new Random();
        int rV = rand.nextInt(9);
        System.out.println("посказка   "+ rV);
        return rV;

    }

    public static int numbersOfTrys() {             // запрос кол-ва попыток
        Scanner sc = new Scanner(System.in);        // определение сканера для ввода числа с клавы
        System.out.println("ВВедите число попыток ");
        int tryNum = sc.nextInt();                  // ввод числа попыток угадывания
        return tryNum;
    }

    ;

    public static int enterValue() {                 // запрос на ввод числа от пользователя
        System.out.println("Введите число от 0 до 9");
        Scanner sc = new Scanner(System.in);
        int fingerToSky = sc.nextInt();
        //System.out.println(fingerToSky);
        return fingerToSky;

    };


    public static void guessNumber(int randVal, int tryNum){
        //int trys = numbersOfTrys();

        do {
            int a = enterValue();                   // попытка угадать
            tryNum--;                               // вычитаем попытку
            if (randVal > a) {
                System.out.println("Задайте число побольше )");
            }
            else {
                if(randVal < a) {
                    System.out.println("Задайте число поменьше ))");}

                else {System.out.println(" Вы угадали !!! ))");break;};
            };

        }
        while (tryNum > 0 );
        };


    public static void main(String[] args){
         guessNumber(randVal(),numbersOfTrys());

        //Scanner sc = new Scanner(System.in);
        //  int a = sc.nextInt();                   // считывает число
       //  String s = sc.nextLine();               //считывает всю строку
       //  String c = sc.next();                   //считвыет строку до первого пробела

    }


}