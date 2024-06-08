public class Recursion1 {
    public static void main(String[] args) {
       int num = 6;
       String binary = binaryConv(num);

       System.out.print("THe binary number is  : " + binary);
    }
    public static String binaryConv( int num){
        String binary = "";
        int remain = 0 ;

        if( num > 0 ){
        remain = num % 2 ;
        binary+= remain;
        return  binaryConv( num / 2 ) + binary;
        }
        return binary;
    }
}
