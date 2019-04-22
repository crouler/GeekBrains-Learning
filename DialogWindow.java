package Lesson_7;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogWindow extends  JFrame{

    JTextField jtfName = new JTextField(), jtfSurname = new JTextField(), jtfFamily = new JTextField();
    JTextArea jtArea = new JTextArea();
    java.lang.String strFio;


    public  DialogWindow(JTextArea jta) {



    setTitle("Dialog Window");
    JPanel jpanel01 = new JPanel(new GridLayout(3,1));
    JPanel jpanel02 = new JPanel(new GridLayout(1,3));

    JPanel jpanel03 = new JPanel(new GridLayout(1,1));
    JPanel jpanel04 = new JPanel(new GridLayout(1,1));

    JButton jbt1 = new JButton("");
    JButton jbt2 = new JButton("Ввести данные");
    JButton jbt3 = new JButton("");

        jpanel01.add(jpanel03);
        jpanel01.add(jbt2);
        jpanel01.add(jpanel04);

        jpanel02.add(jtfName);
        jpanel02.add(jtfSurname);
        jpanel02.add(jtfFamily);


        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent actionEvent){
               strFio = (jtfFamily.getText() + "\n " + jtfName.getText() + "\n " + jtfSurname.getText());

               setVisible(false);

               jta.setVisible(true);
               jta.setRows(3);
               jta.setText(strFio);

            }
        });

    add(jpanel02, BorderLayout.NORTH);
    add(jpanel01, BorderLayout.SOUTH);
    //
    setBounds(600, 200, 400, 400);
    setVisible(true);

}


}


