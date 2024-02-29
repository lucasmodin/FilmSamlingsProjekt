import java.util.Scanner;

public class userInterface {
    Controller controller = new Controller();
    Scanner input = new Scanner(System.in);

    public void startProgram() {
        int navigator = 0;
        final int SENTINEL = -1;
        do {
            System.out.println("Welcome to your personal Movie Collection Library. " +
                    "\n Enter '1' if you would like to add movies to your collection. " +
                    "\n Enter '2' if you would like to change the movies in your collection " +
                    "\n Enter '3' if you would like to search trough your library " +
                    "\n Enter '4' if you would like to delete movies from your library " +
                    "\n Enter '-1' to end the program"
            );
            navigator = input.nextInt();
            input.nextLine();

            if (navigator == 1) {
                addMovie();

            } else if (navigator == 2) {
                changeMovie();

            } else if (navigator == 3) {
                searchTroughMovieList();

            } else if (navigator == 4) {
                deleteMovie();

            }
        } while (navigator != SENTINEL);
    }

    private void addMovie() {
        while (true) {
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

            input.nextLine();

            String genre = input.nextLine();


            System.out.println("Enter the rating between 1 and 10: ");
            int rating = input.nextInt();
            input.nextLine();

            controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);
            System.out.println("Your movie has been added");

            System.out.println("Would you like to return to the main menu? if yes - enter 'yes': " +
                    "Enter 'no' to keep staying in the menu choice");
            String userChoice = input.nextLine();

            if (userChoice.equalsIgnoreCase("yes")) {
                break;
            }

        }

    }

    private void changeMovie() {

        while (true) {
            if (controller.isMovieListNotEmpty()) {
                System.out.println("What movie would you like to change?" +
                        "\n Please enter the title of the movie you would like to edit");
                System.out.println(controller.printCollection());
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
                System.out.println("Your movie " + title + " has been changed to " + newTitle);

            }
            System.out.println("Would you like to return to the main menu? if yes - enter 'yes': " +
                    "Enter 'no' to keep staying in the menu choice");
            String userChoice = input.nextLine();

            if (userChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }

        private void searchTroughMovieList () {
            if (controller.isMovieListNotEmpty()) {
                System.out.println("What movie would you like to search for? Enter a title or a letter in the title: ");
                String title = input.nextLine();
                System.out.println(controller.searchTroughMovieList(title).toString());
            } else {
                System.out.println("Error, your movie list is empty. Please add some movies.");
            }

        }
        private void deleteMovie() {

            while (true) {
                System.out.println("What movie would you like to remove? " +
                        "\n enter the movies title to remove it from the collection.");

                System.out.println(controller.printCollection());
                ;
                String remove = input.nextLine();

                controller.removeMovie(remove);

                System.out.println(controller.printCollection());
                System.out.println("You have now removed the movie " + remove + " from your collection ");
                System.out.println("Would you like to return to the main menu? if yes - enter 'yes': " +
                        "Enter 'no' to keep staying in the menu choice");
                String userChoice = input.nextLine();
                if (userChoice.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

    /*public boolean returnToMainMenu() {

        String userInput;

        System.out.println("Would you like to return to the main menu? if yes - enter 'yes': " +
                "Enter 'no' to keep staying in the menu choice");
        userInput = input.next();

        if (userInput.equalsIgnoreCase("yes")) {
            System.out.println("Returning to main menu...");
            return true;

        } else if (userInput.equalsIgnoreCase("no")) {
            System.out.println("Continuing... ");
            return false;

        } else {
            System.out.println("Error - input invalid. please try again");
        } return returnToMainMenu();
    }*/


    }






