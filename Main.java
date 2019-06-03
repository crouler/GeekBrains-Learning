import java.util.*;

public class Main {

    //1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    // Посчитать сколько раз встречается каждое слово.

    //2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    // В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
    // искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
    // (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.




    public static void main(String[] args){

            // Первое задание***************

        final String [] arr = {"один","два","три","четыре","пять","шесть","семь","восемь","девять","десять"};
        ArrayList<String> listik = new ArrayList<>();
        ListIterator<String> iter = listik.listIterator();      // два итератора для двойного цикла
        Iterator<String> iter2 = listik.iterator();
        listik.ensureCapacity(20);

        for (int i = 0; i < 20; i++) {
            listik.add(arr[(int) Math.round(Math.random() * 9)]);
        }
        System.out.println("Исходный List элементов ");
        System.out.println(listik);

        Collections.sort(listik);
        System.out.println("Сортированный List элементов ");
        System.out.println(listik);

        Set setCifer = new HashSet(listik);         // обрезаем повторяющиеся элементы
        System.out.println(setCifer + " кол-во неповторяющихся элементов - "+setCifer.size());


        int freq = 0;
        for (int i = 0; i < listik.size()-1; i++) {

            if( listik.get(i+1)== listik.get(i)){           // подсчет повторов элемента списка
                freq +=1;
            }
            else {System.out.println("'"+listik.get(i)+"'"+ " встречается " + (freq+1) + " раз; "); freq = 0; }
            if(i==listik.size()-2){
                System.out.println("'"+listik.get(i)+"'"+ " встречается " + (freq+1) + " раз;");        // вывод последнего элемента списка
            }

        }

        // Второе задание**********************

    PhoneBook book = new PhoneBook();       // создание справочника
        book.putSub("Vasya", 9263332211L);
        book.putSub("Vasya", 9263332212L);
        book.putSub("Vasiliy", 9263332213L);

        book.getSub("Vasya");




    }

}













