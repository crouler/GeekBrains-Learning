import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

    //1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    // Посчитать сколько раз встречается каждое слово.




    public static void main(String[] args){


        final String [] arr = {"один","два","три","четыре","пять","шесть","семь","восемь","девять","десять"};
        ArrayList<String> listik = new ArrayList<>();
        ListIterator<String> iter = listik.listIterator();      // два итератора для двойного цикла
        Iterator<String> iter2 = listik.iterator();
        listik.ensureCapacity(20);

        for (int i = 0; i < 20; i++) {
            listik.add(arr[(int) Math.round(Math.random() * 9)]);
        }
        System.out.println(listik);

        int [] frequecy = new int[arr.length];      //частота одной цифры
        String [] printed = new String[arr.length];     // метка для отпечатаных чисел
        ArrayList<String> toPrint = new ArrayList<>(arr.length);

        while(iter.hasNext()){
            while (iter2.hasNext()){
                String tmp = iter2.next();
                if (iter.equals(tmp)){
                    frequecy[iter.nextIndex()-1] += 1;
                }
            }
            if(!iter.equals(printed)){
                System.out.print(iter + " повторений - " + frequecy[iter.nextIndex()-1] + ", ");
            }

            printed[iter.nextIndex()-1] =  iter.toString();

        }

    }

}













