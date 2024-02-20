//importere scanner

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MovieCollection movieCollection = new MovieCollection();

        //Tilføjet en navigator og sentinel. Navigatoren bruger vi til at 'navigere' igennem vores program og tager datatypen Int. Sentinel er vores stopklods for while loops.
        int navigator = 0;
        int sentinel = 0;

        //Opretter scanner objekt
        Scanner input = new Scanner(System.in);

        //Opsætter et while loop for vores brugermenu.
        while (navigator != -1) {
            System.out.println("Welcome to your personal Movie Collection Library. " +
                    "\n Enter 1 if you would like to add movies to your collection. " +
                    "\n Enter 2 if you would like to change the movies in your collection " +
                    "\n Enter 3 if you would like to take a look at your library " +
                    "\n Enter 4 if you would like to delete movies from your library "
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
                    movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);

                    System.out.println("Your movie has been added - Type '-1' if your collection is done, or enter 0 to add more to the collection");
                    sentinel = input.nextInt();
                    input.nextLine();
                }

                System.out.println("Your collection now looks like this");
                movieCollection.printCollection();

                System.out.println("You have now added your desired movies. Enter '0' if you would like to go back to the main menu");
                navigator = input.nextInt();
                }else if (navigator == 2) {

                     System.out.println("What movie would you like to change?");
                     movieCollection.printCollection();
                     String title = input.nextLine();

                     movieCollection.changeMovie(title);


                } else if (navigator == 3) {

                System.out.println("");


                }

                    else if (navigator == 4) {

                System.out.println("What movie would you like to remove?");
                movieCollection.printCollection();
                String remove = input.nextLine();
                movieCollection.removeMovie(remove);
                movieCollection.printCollection();

                System.out.println("You have now removed the movie " + remove + " from your collection " +
                        "\n enter '4' if you would like to remove another movie, or enter '0' to get back to the main menu");

                navigator = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Invalid input. Try again");
                navigator = input.nextInt();
                input.nextLine();
            }




        }














       /*MovieCollection movieCollection = new MovieCollection();

       movieCollection.addMovie(input);
       movieCollection.printCollection();*/


        /*Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the movie");
        String title = input.nextLine();
        System.out.println("Enter the director of the movie");
        String director = input.nextLine();
        System.out.println("Enter the year of production");
        int yearCreated = input.nextInt();
        System.out.println("Is the movie in color or not? Write true if yes, false if not");
        boolean isInColor = input.nextBoolean();
        System.out.println("How long is the movie in whole minutes?");
        int lengthInMinutes = input.nextInt();
        System.out.println("Lastly, what genre is the movie?");
        String genre = input.next();*/




/*MovieCollection filmSamling = new MovieCollection();
filmSamling.addMovie(input);
filmSamling.printCollection();*/






    }
}
