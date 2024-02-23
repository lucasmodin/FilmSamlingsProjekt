

//OBS! Main klassen er meget rodet. planlægger at rydde op snarest :))
//OBS! der kan være en fejl hvis man prøver at vælge menu punkt 2 eller 3 uden at have indtastet en film. Jeg har ikke tilføjet exceptions endnu.
//importere scanner

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        int navigator;
        Scanner input = new Scanner(System.in);

        do {
            int sentinel = 0;

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

                    input.nextLine();

                    String genre = input.nextLine();


                    System.out.println("Enter the rating between 1 and 10: ");
                    int rating = input.nextInt();
                    controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);
                    System.out.println("Your movie has been added - Type '-1' if your collection is done, or enter 0 to add more to the collection");
                    sentinel = input.nextInt();
                    input.nextLine();
                }

                System.out.println("Your collection now looks like this");

                System.out.println(controller.printCollection());

                System.out.println("You have now added your desired movies. Enter '0' if you would like to go back to the main menu");
                navigator = input.nextInt();
                input.nextLine();

                //
                }else if (navigator == 2) {

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
                                " Type '-1' if your collection is done, or enter 0 to keep the collection");
                        sentinel = input.nextInt();
                        input.nextLine();

                    }
                }

                } else if (navigator == 3) {
                    if (controller.isMovieListNotEmpty()) {
                        System.out.println("What movie would you like to search for? Enter a title or a letter in the title: ");
                        String title = input.nextLine();
                        System.out.println(controller.searchTroughMovieList(title));
                    }
                    else {
                        System.out.println("Error, your movie list is empty. Please add some movies.");
                    }
                }

             else if (navigator == 4) {

                System.out.println("What movie would you like to remove? " +
                        "\n enter the movies title to remove it from the collection.");

                System.out.println(controller.printCollection());;
                String remove = input.nextLine();

                controller.removeMovie(remove);

                System.out.println(controller.printCollection());


                System.out.println("You have now removed the movie " + remove + " from your collection " +
                        "\n enter '4' if you would like to remove another movie, or enter '0' to get back to the main menu");

                navigator = input.nextInt();
                input.nextLine();
            }

        } while (navigator != -1);

    }
}
