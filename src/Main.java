//importere scanner
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Opretter scanner objekt
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the movie collection:");
        int collectionSize = input.nextInt();
        //vi opretter et movieCollection objekt med collectionSize inputted som argument.
        MovieCollection movieCollection = new MovieCollection(collectionSize);

//for loop der looper igennem antal film man gerne vil tilføje til sin kollektion
        for (int i = 0; i < collectionSize; i++) {
            System.out.println("Enter details for Movie " + (i + 1) + ":");
            System.out.print("Title: ");
            input.nextLine(); //indsat for at fjerne scanner bug. Da vi prøvede uden, ville den bare give en tom string i kollektionen
            String title = input.nextLine();

            System.out.print("Director: ");
            String director = input.nextLine();


            System.out.print("Year Created: ");
            int yearCreated = input.nextInt();

            input.nextLine(); //indsat igen for at fjerne scanner bug.

            System.out.print("Is in Color (true/false): ");
            boolean isInColor = input.nextBoolean();

            System.out.print("Length in Minutes: ");

            int lengthInMinutes = input.nextInt();

            System.out.print("Genre: ");
            input.nextLine(); //endnu dummy scanner for at fjerne scanner bug.
            String genre = input.nextLine();

            //Når alt er indtastet, vil inputtet blive tilføjet til movieCollection klassen i addMovie metoden.
            movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        }
        //metode til at printe kollektionen, når loopet er kørt færdigt.
        movieCollection.printCollection();
        input.close();


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
