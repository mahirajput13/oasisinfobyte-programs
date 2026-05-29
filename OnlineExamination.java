import java.util.Scanner;

public class OnlineExamination {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username = "admin";
        String password = "1234";

        int choice;

        System.out.println("===== ONLINE EXAMINATION SYSTEM =====");

        // Login
        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {

            System.out.println("\nLogin Successful!");

            do {

                System.out.println("\n----- MENU -----");
                System.out.println("1. Update Profile");
                System.out.println("2. Change Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Logout");

                System.out.print("Enter Choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter New Username: ");
                        username = sc.nextLine();

                        System.out.println("Profile Updated Successfully.");
                        break;

                    case 2:

                        System.out.print("Enter New Password: ");
                        password = sc.nextLine();

                        System.out.println("Password Changed Successfully.");
                        break;

                    case 3:

                        startExam(sc);
                        break;

                    case 4:

                        System.out.println("Logout Successful.");
                        break;

                    default:

                        System.out.println("Invalid Choice.");
                }

            } while (choice != 4);

        } else {

            System.out.println("Invalid Username or Password.");
        }

        sc.close();
    }

    public static void startExam(Scanner sc) {

        int score = 0;
        int answer;

        System.out.println("\n===== EXAM STARTED =====");
        System.out.println("You have limited time to complete the exam.\n");

        // Question 1
        System.out.println("1. Which language is platform independent?");
        System.out.println("1. C");
        System.out.println("2. Java");
        System.out.println("3. Python");
        System.out.println("4. C++");

        System.out.print("Enter Answer: ");
        answer = sc.nextInt();

        if (answer == 2) {
            score++;
        }

        // Question 2
        System.out.println("\n2. Which keyword is used for inheritance in Java?");
        System.out.println("1. implement");
        System.out.println("2. extends");
        System.out.println("3. inherit");
        System.out.println("4. super");

        System.out.print("Enter Answer: ");
        answer = sc.nextInt();

        if (answer == 2) {
            score++;
        }

        // Question 3
        System.out.println("\n3. Which method is the starting point of Java program?");
        System.out.println("1. start()");
        System.out.println("2. run()");
        System.out.println("3. main()");
        System.out.println("4. init()");

        System.out.print("Enter Answer: ");
        answer = sc.nextInt();

        if (answer == 3) {
            score++;
        }

        System.out.println("\n===== EXAM FINISHED =====");
        System.out.println("Your Score: " + score + "/3");

        if (score >= 2) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}