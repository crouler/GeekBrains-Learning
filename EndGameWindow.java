package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameWindow extends JFrame {

    private int heigth = 350;                     // высота
    private int width = 230;                      // ширина

    public EndGameWindow (int playerSymbol){

        String winner = new String("");

        if (playerSymbol==3){ winner = "Ro-Bot";}
        if (playerSymbol==1 ){winner = "Player 1";}
        if (playerSymbol==2 ){winner = "Player 2";}

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(heigth, width);

        setLocation(404, 463);
        setTitle("Game over");

            JButton btnBrandAnewGame = new JButton("В этом раунде победил игрок "+ winner);
            add(btnBrandAnewGame);

        btnBrandAnewGame.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
            }
        });





    }


}
