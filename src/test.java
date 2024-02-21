           //dette er en test klasse, hvor jeg prøver at lave main klassen lidt om, og gøre den mere overskuelig.
           //Work in progress!!!
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner input = new Scanner(System.in);
        MenuConstants userMenu = new MenuConstants();

        int navigator;

        do {
            int sentinel = 0;
            System.out.println(userMenu.getWelcomeMessage());
            System.out.println(userMenu.getMenu());
            navigator = input.nextInt();
            input.nextLine();

            switch (navigator) {

                case 1:
                    while (sentinel != -1) {
                        System.out.println("Enter details for Movie: ");

                        System.out.print("Title: ");

                        String title = input.nextLine();

                        System.out.print("Director: ");

                        String director = input.nextLine();

                        System.out.print("Year Created: ");

                        int yearCreated = input.nextInt();

                        System.out.print("Is in Color (true/false): ");

                        boolean isInColor = input.nextBoolean();

                        System.out.print("Length in Minutes: ");

                        int lengthInMinutes = input.nextInt();

                        System.out.print("Genre: ");

                        input.nextLine(); //dummy scanner for at 'æde' scanner bug.

                        String genre = input.nextLine();

                        while (true) {
                            System.out.println("Enter the rating between 1 and 10: ");
                            int rating = input.nextInt();
                            if (rating <= 10 && rating >= 1) {
                                controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);
                                break;
                            } else {
                                System.out.println("Error! rating should be between 1 and 10. Please try again");
                            }
                        }
                        System.out.println("Your movie has been added - Type '-1' if your collection is done, or enter 0 to add more to the collection");
                        sentinel = input.nextInt();
                        input.nextLine();
                    }
                    break;

                case 2:
                    while (sentinel != -1) {
                        if (controller.isMovieListNotEmpty()) {
                            System.out.println("What movie would you like to change?" +
                                    "\n Please enter the title of the movie you would like to edit");
                            controller.printCollection();
                            String title = input.nextLine();
                            System.out.println("You have selected the movie " + title);
                            System.out.print("Now enter the new movies title: ");
                            String newTitle = input.nextLine();
                            System.out.print("Now enter the new movies director: ");
                            String newDirector = input.nextLine();
                            System.out.print("Now enter the new movies release year: ");
                            int newYearReleased = input.nextInt();
                            input.nextLine();
                            System.out.print("Now, is the new movie in color or not? true/false: ");
                            boolean newIsinColor = input.nextBoolean();
                            System.out.print("Now enter the new movies length in whole minutes: ");
                            int newMovieLength = input.nextInt();
                            input.nextLine();
                            System.out.print("Now enter the new movies genre: ");
                            String newGenre = input.nextLine();
                            while (true) {
                                System.out.println("Now enter the new movies rating between 1 and 10: ");
                                int newRating = input.nextInt();
                                if (newRating <= 10 && newRating >= 1) {
                                    controller.changeMovie(title, newTitle, newDirector, newYearReleased, newIsinColor, newMovieLength, newGenre, newRating);
                                    break;
                                } else {
                                    System.out.println("Error! rating should be between 1 and 10. Please try again");
                                }
                            }
                            System.out.println("Your movie " + title + " has been changed to " + newTitle +
                                    " Type '-1' if your collection is done, or enter 0 to add more to the collection");
                            sentinel = input.nextInt();
                            input.nextLine();

                        } else {
                            System.out.println("Error! You haven't added any movies to your collection. Please add some movies." +
                                    "\n If you want to add a movie, please enter '1': ");
                            navigator = input.nextInt();
                            input.nextLine();
                        }


                    }break;

                case 3:





                    break;

                case 4:

                    break;


            }


        } while (navigator != -1);
        input.close();
    }
}
