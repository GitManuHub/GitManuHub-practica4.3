//This is the class with the main method;

package reviews.main;

import reviews.data.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Management mgmt = new Management();
        Scanner sc = new Scanner(System.in);
        String option, login, password;
        User loggedUser;

        mgmt.initialize();

        do {
            System.out.println("Enter your login: ");
            login = sc.nextLine();
            System.out.println("Enter your password: ");
            password = sc.nextLine();
            loggedUser = mgmt.login(login, password);
        } while (loggedUser == null);

        do {

            System.out.println("What do you want to do? (Enter the number of the option)\n\t1. View my reviews" +
                    "\n\t2. See all business\n\t3. See top rated business\n\t4. Edit my review\n\t0. Exit");
            option = sc.nextLine();

            switch (option) {
                case "1":
                    mgmt.showReviews(login);
                    System.out.println();
                    break;
                case "2":
                    mgmt.sortBusinessesByName();
                    break;
                case "3":
                    String businessType = "";
                    do {
                        System.out.println("Enter the business you want to see:\n\t1. Restaurants" +
                                "\n\t2. Hairdressers\n\t3. Garage");
                        businessType = sc.nextLine();
                    } while (!(businessType.equals("1")  || businessType.equals("2") || businessType.equals("3")));

                    mgmt.sortBusinessesByRating(Integer.parseInt(businessType));
                    break;
                case "4":
                    String businessNumber;
                    mgmt.sortBusinessesByName();
                    do {
                        System.out.println("Enter the number of the business you want to change your review from: ");
                        businessNumber = sc.nextLine();
                    } while (!(businessNumber.equals("1") || businessNumber.equals("2") || businessNumber.equals("3")
                            || businessNumber.equals("4") || businessNumber.equals("5") || businessNumber.equals("6")));

                    int position = Integer.parseInt(businessNumber) - 1;

                    Review r = mgmt.findReview(loggedUser, mgmt.getBusinesses()[position]);

                    if (r == null) {
                        System.out.println("You have made no reviews of this business.\n");
                    } else {
                        System.out.println("This is your review of this business\n" + r + "\n");
                        System.out.println("Enter the new comment for this review: ");
                        String newComment = sc.nextLine();
                        System.out.println("Enter the new rating for this review: ");
                        int newRating = sc.nextInt();
                        sc.nextLine();

                        Management.changeReview(r, newComment, newRating);
                    }

                    break;
                case "0":
                    System.out.println("See you soon!");
                    break;
                default:
                    System.out.println("That is not a valid option");
                    break;
            }

        } while (!option.equals("0"));
    }
}
