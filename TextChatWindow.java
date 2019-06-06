import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextChatWindow extends JFrame {
    public TextChatWindow(){
        setTitle("WeChat )))");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,200,500,400);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.lightGray);
        JPanel panel = new JPanel(new GridLayout(1,5));
        JButton button = new JButton(" Send MSG ");

        JTextField textField = new JTextField();

        add(textArea, BorderLayout.CENTER);
        panel.add(textField);
        panel.add(button);

        add(panel, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText()!= null) {            // почему-то не срабатывает условие, можно отправить пустую строку
                    textArea.append(textField.getText() + "\n");
                    textField.setText(null);
                    textField.grabFocus();
                }
            }
        });
        setVisible(true);
    }
    }

