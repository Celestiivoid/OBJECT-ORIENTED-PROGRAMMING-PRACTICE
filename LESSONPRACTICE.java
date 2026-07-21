
import java.util.Scanner;

public class LESSONPRACTICE {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);

        String repeat = "yes";

        while (repeat.equalsIgnoreCase("yes")){
            System.out.println("\n=== SIMPLE CALCULATOR ===");
             
            System.out.println("Enter first number: ");
            Double digit1 = scanner.nextDouble();

            System.out.println("Operator: ");
            String operator = scanner.next();

            System.out.println("Enter second number: ");
            Double digit2 = scanner.nextDouble();

            if (operator.equals("+")){
                Double plus = digit1 + digit2;
                System.out.println("\nAnswer: " + plus);
            }
            else if (operator.equals("-")){
                Double minus = digit1 - digit2;
                System.out.println("\nAnswer: " + minus);
            }
            else if (operator.equals("*")){
                Double times = digit1 * digit2;
                System.out.println("\nAnswer: " + times);
            }
            else if (operator.equals("/")){
                Double divide = digit1 / digit2;
                if (digit2.equals(0.0)){
                    System.out.println("\nCannot divide by zero.");
                }
                else {
                    System.out.println("\nAnswer: " + divide);
                }
            }
            else {
                System.out.println("\nInvalid operator. Please try again.");
            }
            System.out.println("\nDo you want to calculate again? (yes/no)");
            repeat = scanner.next();
            
        }
    } 
}