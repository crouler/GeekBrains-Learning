public class MyArrayDataExeption extends Exception{

    private int i;
    private int j;

    public MyArrayDataExeption(String message, int i, int j){
        super(message + " index i = " + i +", index j = " + j);
        this.i = i;
        this.j = j;
    }


}
