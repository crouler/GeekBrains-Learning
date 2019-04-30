package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel{

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    int[][] field;
    int fieldSizeX;
    int fieldSizeY;

    int winLen;

    int cellHeight;
    int cellWidth;

    int tmpCellX;                           // общие переменные выбранной ячейка поля
    int tmpCellY;
    boolean humanVShuman;
    boolean humanVSai;

    public static final int p1 = 1;                             // символы игроков в матрице
    public static final int p2 = 2;
    public static final int ai = 3;
    public int playerSymbol = 0;

    public EndGameWindow endGameWindow;



    boolean isInitialized = false;                          // начальное пложение флага

    Map() {
        setBackground(Color.ORANGE);                        // задание фонового цвета
        addMouseListener(new MouseAdapter() {               // ? определение слушателя мыши ?
            @Override
            public void mouseReleased(MouseEvent e) {       // переопределение отпускания нажатой кнопки мыши ()
                update(e);                                  // ? передача события в метод ? выполнение метода в момент отпускания кнопки

            }
        });
    }

    void update(MouseEvent e) {                             // определение метода обработки события кнопки мыши

            int cellX = e.getX() / cellWidth;                   // получение координаты Х в размерности клеток игрового поля
            int cellY = e.getY() / cellHeight;                  // получение координаты У в размерности клеток игрового поля
            System.out.println("x: " + cellX + " y: " + cellY); // печать координат ХУ (координаты клеток игрового поля в которое ткнули ЛКМ)
            tmpCellX = cellX;
            tmpCellY = cellY;

        if (humanVSai){                                     // режим человек - AI
            playerSymbol = p1;

            field[tmpCellX][tmpCellY] = playerSymbol;                      // 1 - это ход игрока


            if (checkWinMap(playerSymbol,winLen)) {
                System.out.println("Победил игрок " + playerSymbol);
                endGameWindow = new EndGameWindow(playerSymbol);
                endGameWindow.setVisible(true);
//                System.exit(0);
            }

            if (voidCellsMap(field) == false) {
                System.out.println("Ничья");
                System.exit(0);
            }   // проверка заполнения игрового поля

            aiTurnMap();

            if (checkWinMap(ai,winLen)) {
            System.out.println("Победил Ro-Bot ");

            endGameWindow = new EndGameWindow(ai);
            endGameWindow.setVisible(true);
            //System.exit(0);

            }

            if (voidCellsMap(field) == false) {
                System.out.println("Ничья");
                System.exit(0);
            }   // проверка заполнения игрового поля

            repaint();
        }

        if(humanVShuman) {                                      // режим человек - человек


            repaint();                                          // перерисовка игрового поля
        }

    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {   // определение метода задания игрового поля по входным параметрам
        this.fieldSizeX = fieldSizeX;               //
        this.fieldSizeY = fieldSizeY;               //
        this.winLen = winLen;                       //
        field = new int[fieldSizeY][fieldSizeX];                                // задание массива игрового поля

        for (int i = 0; i < fieldSizeY; i++) {                                  // заполнение нулями для проверки победы, наличия свободных полей
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j]=0;

            }

        }
        //System.out.println("Game mode = "+ mode);
        if (mode == 0) {humanVSai = true; humanVShuman = false;}
        else {humanVSai = false; humanVShuman = true;}
        //System.out.println("Game mode humanVSai = "+ humanVSai +"Game mode humanVShuman = "+ humanVShuman);
        isInitialized = true;                                                   // установка флага "новая игра начата"
        repaint();                                                              // перерисовка окна с новыми параметрами
    }

    @Override
    protected void paintComponent(Graphics g){                                  // переопределение метода
        super.paintComponent(g);                                                // обращение к методу родителя
        render(g);                                                              // ? переопределение/ передача в метожд метода родительского класса ?

    }

    void render(Graphics g) {                   // определение метода
        if(!isInitialized) {                  // если фраг  не поднят ( не нажата кнопка старта игры, нет переменных с настроеками) -> выход из метода
            return;
        }

        int panelWindth = getWidth();               // инициализация переменной ширны игрового поля
        int panelHeight = getHeight();              // инициализация переменной высоты игрового поля

        cellHeight = panelHeight/fieldSizeX;        // вычисление ширины клетки поля
        cellWidth = panelWindth/fieldSizeY;         // вычисление высоты клетки поля

        for (int i = 0; i < fieldSizeY; i++) {      //
            int y = i * cellHeight;
            g.drawLine(0,y,panelWindth,y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x,0,x, panelHeight);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == p1){
                    g.drawLine(i*cellWidth, j*cellHeight,i*cellWidth+cellWidth, j*cellHeight+cellHeight);
                    g.drawLine(i*cellWidth+cellWidth,j*cellHeight,i*cellWidth,j*cellHeight+cellHeight);

                }
                if (field[i][j] == ai){
                    g.drawOval(i*cellWidth, j*cellHeight,cellWidth, cellHeight);

                }
    //                if (field[i][j] == ai && ){                                           // заглушка на ход р2
    //                    g.drawOval(i*cellWidth, j*cellHeight,cellWidth, cellHeight);
    //
    //                }
            }
        }





    }

    boolean voidCellsMap(int [][] field){
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == 0) { return true; }

            }

        }
        return false;
    }

     void aiTurnMap() {                       // ход компа
        int x, y;
        Random rand = new Random();
        do {
            x = rand.nextInt(fieldSizeX);
            y = rand.nextInt(fieldSizeY);
        } while (!isCellValidMap(x, y));
        //System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        field[y][x] = ai;
    }

    boolean isCellValidMap(int x, int y) {                       // принадлежность координат игровому полю
        if (x < 0 || x >= fieldSizeX || y < 0 || y >= fieldSizeY) return false;
        if (field[y][x] == 0) return true;
        return false;
    }

    boolean checkWinMap(int symbol, int winLen) {

        int tempSum = 0;
//        int count = 0;


        for (int i = 0; i < fieldSizeX; i++) {                           // диагональ право-вверх
            for (int j = 0; j < fieldSizeY; j++) {                    // условия проверены
                // проверка условия доступности полей в напр сканирования
                if (i <= fieldSizeX - winLen && j <= fieldSizeY - winLen)  {
                    tempSum = countDotsDownDiagonalMap(symbol,winLen,i,j);
                    if (tempSum == winLen) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }

                if(i <=fieldSizeX - winLen && j+2 > winLen){
                    tempSum = countDotsUpDiagonalMap(symbol,winLen,i,j);
                    if (tempSum == winLen) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }

                if( j <= fieldSizeY - winLen){
                    tempSum = countDotsDownMap(symbol,winLen,i,j);
                    if (tempSum == winLen) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }

                if( i <= fieldSizeX - winLen){
                    tempSum = countDotsRightMap(symbol,winLen,i,j);
                    if (tempSum == winLen) return true;
                    else {tempSum = 0;}
                    // проверка победы внутри цикла до обнуления переменной
                }



            }

        }
        return false;
    }


    // ПРОВЕРКА ДИАГОНАЛИ ВВЕРХ ВПРАВО ВНИЗ (поиск победной серии DOTS_TO_WIN)

    int countDotsDownDiagonalMap(int symbol, int winLen, int i, int j){
        int count = 0;
        for (int k = 0; k < winLen; k++)
            if (field[i + k][j + k] == symbol) {
                count++;
            }

        return count;
    }


// ПРОВЕРКА ДИАГОНАЛИ ВВЕРХ ВПРАВО (поиск победной серии DOTS_TO_WIN)

    int countDotsUpDiagonalMap(int symbol, int winLen, int i, int j){
        int count = 0;
        for (int k = 0; k < winLen; k++) {
            if (field[i+k][j-k] == symbol) count++;
        }

        return count;
    }


//ПРОВЕРКА ЛИННИИ ВНИЗ

    int countDotsDownMap(int symbol, int winLen, int i, int j){
        int count = 0;
        for (int k = 0; k < winLen; k++) {
            if (field[i][j+k] == symbol) count++;
        }
        return count;
    }


// ПРОВЕРКА ЛИННИ ВПРАВО

    int countDotsRightMap(int symbol, int winLen, int i, int j){
        int count = 0;
        for (int k = 0; k < winLen; k++) {
            if (field[i+k ][j] == symbol) count++;
        }
        return count;
    }



}








