package Lesson_8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartNewGameWindow extends JFrame {            // наследуемся от JFrame - будет окно

    private final GameWindow gameWindow;                    // определяем переменную доступна в этом классе и наследниках, можно использовать в инкогнито класссах
    private final int WIN_HEIGHT = 230;                     // высота
    private final int WIN_WIDTH = 350;                      // ширина
    private final int MIN_WIN_LEN = 3;                      // минимальная победная серия
    private final int MIN_FIELD_SIZE = 3;                   // минимальная размерность игрового поля
    private final int MAX_WIN_LEN = 10;                     // макс длина победной серии
    private final int MAX_FIELD_SIZE = 10;                  // макс размерность игрового поля
    private final String STR_WIN_LEN = "Winning length: ";      // будущий заголовок при определении слайдера
    private final String STR_FIELD_SIZE = "Field size: ";       // будущая заголовок при определении слайдера

    private JRadioButton jrbHumVsAi = new JRadioButton("Human vs Ai", true);    // радиокнопка выбора режима игры Человек против АИ / true - будет выбрана по умолчанию
    private JRadioButton jrbHumVsHum = new JRadioButton("Human vs Human");      // радиокнопка выбора режима игры Человек против Человека
    private ButtonGroup gameMode = new ButtonGroup();                               // определение группы кнопок (логическая группа кнопок нужна для того, чтобы ограничить выбор до одного варианта внутри группы)

    private JSlider slFieldSize;                // определение слайдера выбора размера игрового поля
    private JSlider slWinLength;                // определение слайдера выбора дины победной серии

    public StartNewGameWindow(GameWindow gameWindow) {      // конструктор класса StartNewGameWindow
        this.gameWindow = gameWindow;

        setSize(WIN_WIDTH, WIN_HEIGHT);                     // задание размерности окна StartNewGameWindow

        Rectangle gameWindowBounds = gameWindow.getBounds(); // передаем в объект rectangle границы окна gameWindow

        int posX = (int) (gameWindowBounds.getCenterX() - WIN_WIDTH/2);     // у прямоугольника RectAngle вызывается метод поиска центра по Х и идет смещение влево на половиину ширины окна gameWindow
        int posY = (int) (gameWindowBounds.getCenterY() - WIN_HEIGHT/2);   // то же по У. Идет поиск точки при построении окно StartNewGameWindow окаажется в центрае окна StartNewGameWindow

        setLocation(posX, posY);                        // помещение окна в координаты, при размещении в которые, окно настроек gameWindow окажется в центре окна StartNewGameWindow
        setTitle("New game parameters:");

        setLayout(new GridLayout(10,1));        // разметка оокна Game Window на 10 строк
        addGameControlsMode();                           // вызов метода -> размещение панели кнопок выбора режима игры ( Ч-Ч, Ч-АИ)
        addGameControlsFieldWinLenght();                 // вызов метода размещения слайдеров размерности игрового поля и длины победной серии

        JButton btnStartGame = new JButton("Start a game");     // определение кнопки старта игры
        btnStartGame.addActionListener(new ActionListener() {       // прослушивание событий кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGameClick();                                // при нажатии вызов метода нажатия кнопки старта игры
            }
        });
        add(btnStartGame);                                          // добавлние кнопки "Start Game" в окно

    }

    void btnStartGameClick() {
        int gameMode;                                           // определение переменной метода
        if(jrbHumVsAi.isSelected()) {                           // если выбрана радио-кнопка то
            gameMode = Map.MODE_H_V_A;                          // установить в переменную 0 или 1
        } else {
            gameMode = Map.MODE_H_V_H;                          // установить в переменную 0 или 1
        }

        int fieldSize = slFieldSize.getValue();                 // установить в новую переменную размерность игрового поля
        int winLen = slWinLength.getValue();                    // установить в переменную длину победной серии
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);    // запуск метода startNewGame класса "окна" GameWindow
        setVisible(false);                                          // закрытие окна (настроек)

    }



    void addGameControlsMode() {                    // метод добавления кнопок
        add(new JLabel("Choose gaming mode: "));    // заголовок группы кнопок
        gameMode.add(jrbHumVsAi);                       // добавление кнопки в логическую группу
        gameMode.add(jrbHumVsHum);                      // добавление кнопки в логическую группу
        add(jrbHumVsAi);                                // добавление кнопки StartNewGameWindow (класс в котором вызывается и определен данный метод)
        add(jrbHumVsHum);                               // добавление кнопки
    }

    private void addGameControlsFieldWinLenght() {      // метод добавление слайдеров
        add(new JLabel("Choose field size:"));      // заголовок слайдера
        final JLabel lblFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);    // определение заголовка слайдера "текущ знач + мин знач размера игрового поля"
        add(lblFieldSize);                                                              // добавление подзаголовка в окно

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);      // добавление слайдера с границами минимального и макс значения размерности игрового поля
        slFieldSize.addChangeListener(new ChangeListener() {                            // связь передвижения бегунка слайдера со значением размерности поля
            @Override
            public void stateChanged(ChangeEvent e) {                                   //
                int currentFildSize = slFieldSize.getValue();                           // привязка положения слайдера к int переменной
                lblFieldSize.setText(STR_FIELD_SIZE + currentFildSize);                 // изменение заголовка слайдера при изменении int переменной текущего значения размерности игрового поля
                slWinLength.setMaximum(currentFildSize);                                // ограничение макс значения размерности длиной победной серии (определяемой ниже)
            }
        });

        add(slFieldSize);                                                       // добавление в окно заголовка с меняющимся текщим значениев

        add(new JLabel("Choose winning length:"));                          // заголовок 2го слайдера
        final JLabel lblWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);     // подзаголовок 2го слайдера "Winning length: " + 3 (мин знач победной серии)
        add(lblWinLen);                                                         // добавлене подзаголовка в окно

        slWinLength = new JSlider(MIN_WIN_LEN, MAX_WIN_LEN, MIN_WIN_LEN);       // задание слайдера
        slWinLength.addChangeListener(new ChangeListener() {                    // переопределение медода прослушивания слайдера
            @Override
            public void stateChanged(ChangeEvent e) {                           //
                lblWinLen.setText(STR_WIN_LEN + slWinLength.getValue());        // пишет в заголовок название устанавливаемого параметра и считываемое со слайдера значение длины победной серии
            }
        });
        add(slWinLength);                                   // добавление слайдера длины победной серии в окно (там где вызывается метод)
    }

}
