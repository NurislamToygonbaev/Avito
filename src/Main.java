import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        User[] userArray = new User[100];
        int count = 0, counter = 0, counterForBook = 0, counterForDevice = 0;
        boolean isRunning = true;
        while (isRunning){
            methodMenu();
            String buttonRegister = new Scanner(System.in).nextLine();
            switch (buttonRegister.toLowerCase()){
                case "1"-> {
                    User userNew = new User();
                    userNew.menuRegister();
                    userArray[count++] = userNew;
                }
                case "2"->{
                    if (count > 0) {
                        User user = new User();
                        user.menuLogin(userArray, counter, counterForBook, counterForDevice);
                    } else System.err.println("create Account 🆕");
                }
                case "3"-> isRunning = false;
                default -> System.err.println("Incorrect choice ❌");
            }
        }
    }
    private static void methodMenu() {
        System.out.println(STR."""
                                
                🟢 1. Register
                🟢 2. Login
                🔴 3. Exit
                                
                """);
        System.out.print("---->> ");
    }
}