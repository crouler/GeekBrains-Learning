

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
        Socket socket;
        Scanner scaner = new Scanner(System.in);
        String strOut = new String("");
        try (ServerSocket serverSocket = new ServerSocket(1234)) {  // запуск try  с ресурсами, которые автом будут закрыты при выходе из try
            System.out.println("Сервер запущен, ждёт подключения...");
            socket = serverSocket.accept();                             // сокет передается серверу - будет ожидаться соединение с клиентом
            System.out.println("Клиент подключился");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); // создание потоков, которые помещаются в объект DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(()->{
                try{
                    while(true){
                        String tmp1Str = dataInputStream.readUTF();
                        if(tmp1Str.equals("/exit")){
                            System.out.println("Client: isGone/Ушел");
                            break;
                        }
                        System.out.println("Client: "+tmp1Str);
                    }

                }
                catch(IOException e){
                    e.printStackTrace();

                }

            }).start();

            while (true) {
                strOut = scaner.nextLine();                                                  //  доб считывание консоли
//                String strFromClient = dataInputStream.readUTF();                           // считывание входящего потока в строку
//                if (strFromClient.equalsIgnoreCase("/end")) {                    // проверка end команды независимо от регистра
//                    //outPutStream.writeUTF("/end");                                      // add мной
//                    break;
//                }
                if(strOut.equals("/exit")){
                    dataOutputStream.writeUTF(strOut);
                    System.out.println("Server: "+strOut);
                    System.exit(0);
                }

                if(!strOut.equals("")){
                    dataOutputStream.writeUTF(strOut);
                    System.out.println("Server: "+strOut);
                }
                //System.out.println("log: " + LocalDate.now() + " " + strFromClient);        // ведение лога в консоли
                //outPutStream.writeUTF("echo: " + strFromClient);                        // эхо в ответ на сообщение
                //outPutStream.writeUTF( strOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




