public class Exception {
    public static void main(String[] args) {

        try{
            int a = 10, b = 0, c;
            c = a / b;
            System.out.println(c);
        }catch (ArithmeticException ex){
            System.out.println(ex);
            System.out.println("ZERO SY DIVIDE NHI KRNY KA NAA...");
        }
        System.out.println("This is after the exception...");

        try{
            String str = null;
            System.out.println(str.toLowerCase());
        }catch (NullPointerException ex ){
            System.out.println("String khaali hai melay babuu");
        }
        System.out.println("After the try-catch block.");
    }
}
