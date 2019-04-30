package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_HEIGHT = 555;      // высота
    private static final int WIN_WIDTH = 507;       // ширина
    private static final int POS_X = 200;           // левый верхний угол положение по Х
    private static final int POS_Y = 200;           // левый верхний угол положение по У

    private static StartNewGameWindow startNewGameWindow;       // определение экземпляра окна настроек
    private static Map field;                                   // определение панели игрового поля

    public GameWindow() {

        setTitle("TicTacToe");                                      // заголовок окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    // выход при закрытии окна
        setBounds(POS_X, POS_Y, WIN_WIDTH, WIN_HEIGHT);             // устнановить GameWindow в точке
        JButton btnStartGame = new JButton("Start new game");   // задание кнопки
        JButton btnExit = new JButton("Exit");                  // задание кнопки

        JPanel bottomPanel = new JPanel(new GridLayout(1,2));   // задание панели

        bottomPanel.add(btnStartGame);                  // помещение кнопки на панель
        bottomPanel.add(btnExit);                       // помещение кнопки на панель

        add(bottomPanel, BorderLayout.SOUTH);           // размещение панели с кнопками внизу окна

        startNewGameWindow = new StartNewGameWindow(this);      // создание и инициализация окна (с помощью this передан уже поределенный в соседнем классе экземпляр)
        field = new Map();                                      // создание экз класса Мар - игрового поля
        add(field, BorderLayout.CENTER);                        // помещение field в центр окна StartNewGameWindow

        btnExit.addActionListener(new ActionListener() {         // опредениее действия по нажатию кнопки exit
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);                         // выход из программы к кодом 0 - штатное закрытие программы
            }
        });

        btnStartGame.addActionListener(new ActionListener() {  // опредениее действия по нажатию кнопки Start - открытие окна startNewGameWindow
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);   }     // открытие окна startNewGameWindow
        });

        setResizable(false);   // измение окна  StartNewGameWindow - запрещено
        setVisible(true);      // видимость окна  StartNewGameWindow - включено
    }


    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {   //  определение метода запуска игры
        field.startNewGame(mode, fieldSizeX, fieldSizeY, winLen);               // задание игрового поля с параметрами, полученными  startNewGame на входе

    }
}
