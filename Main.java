public class Main {

    static final int SIZE = 1000000;
    static final int halfSIZE = SIZE/2;

    public static float[] initArr(){
        float [] arr = new float[SIZE];
        for (int i = 0; i <arr.length ; i++) {
            arr[1] = 1;
        }
        return  arr;
    }

    private static void straightCalcVoid(float[] arr){
        long a = System.currentTimeMillis();
        float [] arr1 = new float[arr.length];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Прямое вычисление " + (System.currentTimeMillis() - a)+" милсек");
    }

    private void formulaCalculation(float [] array){

        // index - элемент с которого будет начат пересчет половины массива 0 или halfSIZE

        for (int i = 0; i < (array.length); i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private void mergeFunc(float [] arr,float [] mass, int key){
        System.arraycopy(mass,0,arr,(key*halfSIZE),halfSIZE); // если функция работает в 1 раз, то произойдет заполнение 1 половины массива arr
        key+=1;

    }


    private void outPut(long startTime){
        System.out.println("Время выполнения парралельной операции "+ (System.currentTimeMillis() - startTime) +" милсек");
    }




    public static void main(String[] args) {

                                    // 1 расчет___________________________

        straightCalcVoid(initArr());


                                    // 2 расчет___________________________

        float [] arr = new float[SIZE];                  // инициализация массива интов после 1го  расчета
        long startTime = System.currentTimeMillis();     // момент начала вычислений
        Object sync = new Object();                      // объект дл синхронизации
        int key = 0;

        float [] arr1 = new float[halfSIZE];
        float [] arr2 = new float[halfSIZE];

        System.arraycopy(initArr(),0, arr1, 0,halfSIZE);          // инициализация массивов float - заполнение единицами
        System.arraycopy(initArr(),halfSIZE, arr2, 0,halfSIZE);         // инициализация массивов float - заполнение единицами
        Main o = new Main();

        Thread thread1 = new Thread(() -> {
            o.formulaCalculation(arr1);

            synchronized (sync){
                o.mergeFunc(arr,arr1,key);
            }

        });


        Thread thread2 = new Thread(()->{
            o.formulaCalculation(arr2);

            synchronized (sync){
                o.mergeFunc(arr,arr2,key);
            }

        });

        thread1.start();
        thread2.start();

        //if(key==2)
        o.outPut(startTime);

    }
}
