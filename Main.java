import static java.lang.Integer.parseInt;

public class Main {

    public static int[] arrSumElements(String[][] arr, int maxArrIjDim) {

        int [] sum = {0,0};                 // массив, чтобы передать параметр возникновения Exeption при выводе результата
        int[] errPosition = {0, 0};

        try {
            if (arr.length != maxArrIjDim)      // проверка зармерности по индексу I
                throw new MyArraySizeExeption("Колличество строк массива не соответствует размерности массива равной", arr.length);

            for (int i = 0; i < arr.length; i++) {
                errPosition[0] = i;

                if (arr[i].length != maxArrIjDim) {     // проверка зармерности по индексу J
                    throw new MyArraySizeExeption("Индекс строки не соответствующей размерности", i);
                }

                for (int j = 0; j < arr[i].length; j++) {
                    errPosition[1] = j;
                    try {
                        if (parseInt(arr[i][j]) % 1 != 0) ;
                    }
                    catch (NumberFormatException e){
                        sum[1] = 1;                                 // в каждом catch проставляю в мессив флаг вычисления с ошибкой
                        throw new MyArrayDataExeption("Элемент массива не соотвуюет INT числу:",i,j);
                    }
                    sum[0] += parseInt(arr[i][j]);
                }

            }
        }


        catch (MyArrayDataExeption e){
            sum[1] = 1;                                 // в каждом catch проставляю в мессив флаг вычисления с ошибкой
            System.out.println(e.getMessage());
        }
        catch(MyArraySizeExeption e) {
            sum[1] = 1;                                 // в каждом catch проставляю в мессив флаг вычисления с ошибкой
            System.out.println(e.getMessage() );
        }
        finally{
                System.out.println("Файлы закрыты, память освобождена. Этот блок для закремления материала.");
            }


            return sum;
        }



        public static void main (String[]args){

            String[] s1 = {"1", "2", "3", "4"};
            String[] s2 = {"1", "2", "3", "4"};
            String[] s3 = {"1", "2", "3", "4"};
            String[] s4 = {"1", "к", "3", "4"};
            String[] s5 = {"1", "2", "3", "4", "5"};

            String[][] strArr = {s1, s2, s5, s1};

            int[] sum = arrSumElements(strArr, 4);

            if (sum[1] == 1){
                System.out.println("Вычисления с ошибкой!!! Сумма эелементов массива до возникновения ошибки = " + sum[0]);
            }
            else System.out.println("Сумма эелементов массива = " + sum[0]);



            System.out.println("Программа успешно отработала до конца!!!");
        }
    }

