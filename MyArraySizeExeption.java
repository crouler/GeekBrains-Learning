public class MyArraySizeExeption extends Exception{

    private int arrDim;

    public MyArraySizeExeption(String message, int arrDim){
        super(message + ", " + arrDim);
        this.arrDim = arrDim;

    }

}
