package com.company;

public class Main {

    //задание 3
    public static  float mathEx (int a, int b,  int c, int d){
        float result = (a * ((b + (c/d))));
        return result;
    }

    // задание 4
   public static boolean summaBetween10_20 (int a, int b){
        boolean result;
        int c = a + b;
       if  ( c == 10 || c == 20 || c < 20 && c > 10) { result = true;
           System.out.println("сумма принадлежит интервалу от 10 до 20  ");
           }
            else result = false;
            return result;
    }
    // задание 5
    public static boolean positiveORnegative (int i1){
       boolean result;
       if (i1>0 || i1 ==0 ) result = true;
       else result = false;
       return result;

    }

    // задание 6
    public static boolean negativeValue(int i1){
        boolean result;
        if (i1 < 0) result = true;
        else result = false;
        return result;
    }



    // задание 7

    public static String hello (String name){
        String result = "Hello, " + name + "!";
        return result;
    }



    // задание 8

    public static boolean bissextileYear (int year) {
        boolean bsxtl = false;
        boolean key1;
        boolean key2;
        boolean key3;


        if ((year % 4) == 0) key1 = true;       // кратно 4
        else key1 = false;

        if ((year % 100) == 0) key2 = true;     // кратно 100
        else key2 = false;

        if ((year % 400) == 0) key3 = true;     // кратно 400
        else key3 = false;


        if (key2 == true && key3 == true) bsxtl = true;     // все года кратные 400 - високосные
        else {
                if ( key2 == true) bsxtl = false;           // все года кратные 100 - невисокосные
                else {
                        if (key1 == true) bsxtl = true;      // все года кратные 4 - високосные
                        else bsxtl = false;                    // все оставшиеся - невисокосные
                };
        };

        return bsxtl;

    }



    public static void main(String[] args) {
 // Задание 2
//        int a = 7;
//        short b = 31000;
//        long c = 10000034505L;
//        char d = 'C';
//        byte e = 15;
//
//        boolean f = true;
//        String str = "Hello World!";
//
//        float fl = 111.111f;
//        double dbl = 123.123;

//        System.out.println(a);
//        System.out.println(str);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(e);
//        System.out.println(f);
//        System.out.println(fl);
//        System.out.println(dbl);
// Окончание задания2

        // задание 3
    float var;
    var = mathEx(2, 1,8,2);
        System.out.println(var);


        // задание 4

    boolean interval;
    interval = summaBetween10_20(5,2);
        System.out.println("Сумма принадлежит интервалу от 10 до 20 - " + interval );


        // задание 5

    boolean pORn = positiveORnegative(-3);
        if (pORn == true)  System.out.println("Передано положительное число  " );
        else System.out.println("Передано отрицательное число  " );


        // задание 6

   System.out.println("Передано отрицательное число  " + negativeValue(-4));


        // задание 7
   String meeting = hello("nikName");
    System.out.println(meeting);


        // задание 8

        boolean bsxtlYear = bissextileYear( 123);
        System.out.println("Заданный год високосный - " +bsxtlYear);
//        int year;
//        year = 5%3;
//        System.out.println(year);






    }



}
