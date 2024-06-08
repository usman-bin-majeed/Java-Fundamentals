import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num  = 0;

        do{
            try{
                System.out.println("Entee the number : ");
                num = input.nextInt();
                switch (num){
                    case 0 :
                        System.out.println("THis is case 0.");
                        break;
                    case 1 :
                        System.out.println("This is case 1.");
                        break;
                    case 2 :
                        System.out.println("THis is case 2.");
                        break;
                }
            }catch (InputMismatchException ex){
                System.out.println("This is an arithematic exception.");
            }


            finally{
                System.out.println("Finally block");
            }
        }while( num != 0);

        System.out.println("THis is outside the loop.");


    }

}
