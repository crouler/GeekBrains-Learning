


public class Lesson_6 {
    public static void main(String[] args) {

        String str1 = " Предложение один    Теперь предложение два     Предложение три";
        System.out.println(str1);

        String str2 = str1.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);
        int count = 0;          // счетчик сдвига длины строки при вставке 2 симв на место 1
        for(int i = 2; i < str2.length(); i++) {
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я') {
                //stringBuilder.setCharAt(i-1, '.');
                stringBuilder.insert(i-1+count, ".");
                count+=1;
            }

        }
        stringBuilder.insert(str2.length()+count, "."); // точка в конце строки

        System.out.println(stringBuilder.toString());



    }







}

