package Lesson_7;
/*

 *
 *  @autor Belmas Pavel

 *  @version 22/04/19 18:30
 *
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowExercise7 extends JFrame {
    DialogWindow window;
    public final JTextArea jta = new JTextArea();



    public MyWindowExercise7() {



        setTitle("Window One");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JPanel jpanel = new JPanel(new GridLayout(1,2));
            JPanel jp02 = new JPanel(new GridLayout(1,3));
            JPanel jp03 = new JPanel();
            JPanel jp04 = new JPanel();
            JPanel jp05 = new JPanel();
            JTextArea jtaSrevice = new JTextArea();
            JTextArea jtaSrevice2 = new JTextArea();

            jta.setEditable(false);
            jta.setVisible(false);
            jtaSrevice.setRows(5);
            jtaSrevice2.setRows(5);

        JButton jbt1 = new JButton("Заполнить анкету");

        JButton jbt2 = new JButton("Cancel");

        jp05.add(jtaSrevice);
        jpanel.add(jbt1);
        jpanel.add(jbt2);
        jp02.add(jp03);
        jp02.add(jta);
        jp02.add(jp04);

        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
                jta.setVisible(false);
                new DialogWindow(jta);

            }
        });

        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                dispose();
                Runtime.getRuntime().exit(1);
            }

        });

        add(jp05, BorderLayout.NORTH);
        add(jp02,BorderLayout.CENTER);
       // add(jp05, BorderLayout.CENTER);
        add(jpanel, BorderLayout.SOUTH);

        setBounds(500, 300, 400, 400);
        setVisible(true);

    }



}




class MainClassWindows{
        public static void main(String[] args){
//            String name = new String("");
//            String surname = new String("");
//            String family = new String();
//            name = "";
//            surname = "";
//            family = "";

            new MyWindowExercise7();
//            new DialogWindow();



        }
}






