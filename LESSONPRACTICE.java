import java.util.Scanner;

public class LESSONPRACTICE {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter coffee price: ");
            double price = scanner.nextDouble();

            System.out.println("Enter quantity: ");
            int quantity = scanner.nextInt();

            System.out.println("Add-ons? ");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            int option = scanner.nextInt();

            switch(option) {
                case 1 -> {
                    while(true) {
                        System.out.println("[1] Pearls");
                        System.out.println("[2] B");
                    }
                }
                case 2 -> {
                    break;
                }
            }
        }
    }
}