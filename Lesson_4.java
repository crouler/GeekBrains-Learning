import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {


    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
//        initMap();printMap();
//        while (true) {
//            humanTurn();
//            printMap();
//            if (checkWin(DOT_X, DOTS_TO_WIN)) {                     // add var DOTS_TO_WIN
//                System.out.println("Победил человек");
//                break;
//            }
//            if (isMapFull()) {
//                System.out.println("Ничья");
//                break;
//            }
//            aiTurn();
//            printMap();
//            if (checkWin(DOT_O, DOTS_TO_WIN)) {                     // add var DOTS_TO_WIN
//                System.out.println("Победил Искуственный Интеллект");
//                break;
//            }
//            if (isMapFull()) {
//                System.out.println("Ничья");
//                break;
//            }
//        }

//        System.out.println("Игра закончена");
    }


// ПРОВЕРКА ДИАГОНАЛИ ВВЕРХ ВПРАВО ВНИЗ

    public static int countDotsDownDiagonal(char symb, int DOTS_TO_WIN, int record, int field, char map[][]){
        int count = 0;
        for (int k = 0; k < DOTS_TO_WIN; k++) {
            if (map[record+k][field+k] == symb) count++;
        }

        return count;
    }


// ПРОВЕРКА ДИАГОНАЛИ ВВЕРХ ВПРАВО

    public static int countDotsUpDiagonal(char symb, int DOTS_TO_WIN, int record, int field, char map[][]){
        int count = 0;
        for (int k = 0; k < DOTS_TO_WIN; k++) {
            if (map[record+k][field-k] == symb) count++;
        }

        return count;
    }


//ПРОВЕРКА ЛИННИИ ВНИЗ

    public static int countDotsDown(char symb, int DOTS_TO_WIN, int record, int field, char map[][]){
        int count = 0;
        for (int k = 0; k < DOTS_TO_WIN; k++) {
            if (map[record][field+k] == symb) count++;
        }
        return count;
    }


// ПРОВЕРКА ЛИННИ ВПРАВО

    public static int countDotsRight(char symb, int DOTS_TO_WIN, int record, int field, char map[][]){
        int count = 0;
        for (int k = 0; k < DOTS_TO_WIN; k++) {
            if (map[record+k ][field] == symb) count++;
        }
        return count;
    }




    public static boolean checkWin(char symb, int DOTS_TO_WIN) {
//        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;

        int tempSum = 0;
        int count = 0;


        for (int i = 0; i < SIZE; i++) {                           // диагональ право-вверх
            for (int j = 0; j < SIZE; j++) {                    // условия проверены
                // проверка условия доступности полей в напр сканирования
                if (i <= SIZE - DOTS_TO_WIN && j <= SIZE - DOTS_TO_WIN)  {
                    tempSum = countDotsDownDiagonal(symb,DOTS_TO_WIN,i,j,map);
                    if (tempSum == DOTS_TO_WIN) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }

                if(i <=SIZE - DOTS_TO_WIN && j+2 > DOTS_TO_WIN){
                    tempSum = countDotsUpDiagonal(symb,DOTS_TO_WIN,i,j,map);
                    if (tempSum == DOTS_TO_WIN) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }

                if( j <= SIZE - DOTS_TO_WIN){
                    tempSum = countDotsDown(symb,DOTS_TO_WIN,i,j,map);
                    if (tempSum == DOTS_TO_WIN) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }

                if( i <= SIZE - DOTS_TO_WIN){
                    tempSum = countDotsRight(symb,DOTS_TO_WIN,i,j,map);
                    if (tempSum == DOTS_TO_WIN) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }



            }

        }
        return false;
    }


    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
