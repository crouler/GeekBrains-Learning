import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public Map<String, List<Long>> phBook = new HashMap<>();



    public void putSub(String name, long number){
        this.phBook = phBook;
        if(phBook.containsKey(name)) {
            phBook.get(name).add(number);
        }
        else { List<Long> tmpList = new ArrayList<>(); tmpList.add(number);
            phBook.put(name,tmpList);}
    }

    public  void getSub(String name){
        System.out.println( " номера абонента " + name + phBook.get(name));



    }
}
