

//Importere vores libraries
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class userInterface {

    //opretter et objekt af controller class, der fungerer som instans a controller class.
    Controller controller = new Controller();

    //opretter scanner objekt til bruger input
    Scanner input = new Scanner(System.in);


    //Metode til opstart af program. Oprettet do-while loop, så efter man er hoppet ud af hvert menu-punkt, kommer man tilbage til menuen.

    public void startProgram() {
        int navigator = 0;
        final int SENTINEL = -1;
        do {
            System.out.println("Welcome to your personal Movie Collection Library. " +
                    "\n ---- Enter '1' if you would like to add movies to your collection. " +
                    "\n ---- Enter '2' if you would like to change the movies in your collection " +
                    "\n ---- Enter '3' if you would like to search trough your library " +
                    "\n ---- Enter '4' if you would like to delete movies from your library " +
                    "\n ---- Enter '-1' to end the program"
            );

            //oprettet try-catch som metoder til at fange inputMismatchExceptions, istedet for at skrive det ind hver gang (se nederst i userInterface for kode)
            navigator = readIntWithValidation("Please select a menu option by entering the corresponding number \n", -1, 4);

            if (navigator == 1) {
                addMovie();

            } else if (navigator == 2) {
                editMovie();

            } else if (navigator == 3) {
                searchTroughMovieList();

            } else if (navigator == 4) {
                deleteMovie();

            }
        } while (navigator != SENTINEL);
    }


    //denne metode tilføjer en film. Jeg har valgt at indsætte et while(true) loop, for at brugeren hele tiden ikke ryger ud i hovedmenuen efter at tilføje en film.
    private void addMovie() {

        while (true) {

            System.out.println("Enter details for Movie: ");

            System.out.print("Title: ");
            String title = input.nextLine();

            System.out.print("Director: ");
            String director = input.nextLine();

            int yearCreated = validateUserInput("Year created: ");


//istedet for at bruge et if-else statement til at skrive yes eller no, kan vi deklarere en string til input.nextLine, og den bliver kun true, hvis brugeren inputter yes.
            System.out.print("Is in Color (yes/no): ");
            String yesOrNo = input.nextLine();
            boolean isInColor = yesOrNo.equalsIgnoreCase("yes");

            int lengthInMinutes = validateUserInput("Length in minutes: ");

            System.out.print("Genre: ");
            String genre = input.nextLine();

            //her bruger jeg min try-catch metode med 'validation' i det at brugeren skal indtast en int mellem 1-10 (se bunden af userInterface klasse for metode)
            int rating = readIntWithValidation("Enter the rating between 1/10: ", 1,10);

//her tilføjes filmen med alle de argumenter som brugeren har indtastet. Den referer til 'addmovie' metoden i controlleren
            controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);

            System.out.println("Your movie has been added" +
                    "\n Updated collection: " +
                    "\n" + controller.printCollection());


            System.out.println("Would you like to return to the main menu? if yes - enter 'yes': " +
                    "Enter 'no' to keep staying in the menu choice");
            String userChoice = input.nextLine();

            if (userChoice.equalsIgnoreCase("yes")) {
                break;
            }

        }

    }

//Metode til at søge efter en film. For koden bagved, se movieCollection class.
    //Jeg har brugt en metode til at checke om vores filmliste er tom (se movieCollection for metode) hvis der ikke er tilføjet nogle film, beder den brugeren om at tilføje nogle film først.
    private void searchTroughMovieList() {
        if (controller.isMovieListNotEmpty()) {
            System.out.println("What movie would you like to search for? Enter a title or a letter in the title: ");
            String title = input.nextLine();
            System.out.println(controller.searchTroughMovieList(title).toString());
        } else {
            System.out.println("Error, your movie list is empty. Please add some movies.");
        }

    }

//Metode til at fjerne film fra listen. Igen while loop, til hvis folk vil fjerne flere film. Koden bag metoden kan ses i movieCollection.
    private void deleteMovie() {

        while (true) {
            System.out.println("What movie would you like to remove? " +
                    "\n enter the movies title to remove it from the collection.");

            System.out.println(controller.printCollection());
            ;
            String removedMovie = input.nextLine();

            controller.removeMovie(removedMovie);

            System.out.println(controller.printCollection());
            System.out.println("You have now removed the movie " + removedMovie + " from your collection ");
            System.out.println("Would you like to return to the main menu? if yes - enter 'yes': " +
                    "Enter 'no' to keep staying in the menu choice");
            String userChoice = input.nextLine();
            if (userChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }

//Metode til at ændre på film i listen. Metoden checker som det første om listen er tom.
    //Jeg genbruger søgemetoden, for så at tilføje de søgte værdier i en Arraylist, jeg har kaldt searchResults.
    private void editMovie() {

        if (controller.isMovieListNotEmpty()) {
            System.out.println("Search for the title you want to edit");
            String title = input.nextLine();
            ArrayList<Movie> searchResults = controller.searchTroughMovieList(title);

            //Hvis søgningen ikke giver nogle resultater, giver programmet en besked om at titlen ikke blev fundet.

            if (searchResults.isEmpty()) {
                System.out.println("Error! no movies by title " + title + " found");
                return;
            } else {

                //Her bruger jeg et for loop til at printe titlen på hver film på index 'i' samt give dem en nummeret plads.
                for (int i = 0; i < searchResults.size(); i++) {
                    System.out.println((i + 1) + ". " + searchResults.get(i).getTitle());
                }
            }

//Den nummeret plads værdi 'matchNumber' bruges til at vælge film objektet. Igen brugt try-catch metode til at fange InputMismatchException.
            String message = "What match number do you want to edit? Enter the number: ";

            int matchNumber = readIntWithValidation(message,1, searchResults.size());

                Movie movieToEdit = controller.getMovieList().get(matchNumber - 1);


                //Her prompter vi brugeren for hvad der skal ændres i film objektet
                System.out.println("What do you want to change? Please choose from the menu below: " +
                        "\n 1. Title " +
                        "\n 2. Director " +
                        "\n 3. Year Created " +
                        "\n 4. Is in color " +
                        "\n 5. Length in minutes " +
                        "\n 6. Genre " +
                        "\n 7. Rating " +
                        "\n Input the number of the option you want to change: ");
                int userChoice = input.nextInt();
                input.nextLine();

//Forskellige setter-metoder til at ændre hvad en brugeren har valgt i menuen.
                if (userChoice == 1) {
                    System.out.println("You've selected to change the title. Please input a new title: ");
                    String newTitle = input.nextLine();
                    movieToEdit.setTitle(newTitle);
                    System.out.println(movieToEdit);


                } else if (userChoice == 2) {
                    System.out.println("You've selected to change the director. Please input a new director: ");
                    String newDirector = input.nextLine();
                    movieToEdit.setDirector(newDirector);
                    System.out.println(movieToEdit);


                } else if (userChoice == 3) {
                    System.out.println("You've selected to change the year created. Please input a new year created: ");
                    int newYearCreated = input.nextInt();
                    input.nextLine();
                    movieToEdit.setYearCreated(newYearCreated);
                    System.out.println(movieToEdit);


                } else if (userChoice == 4) {
                    System.out.println("You've selected to change is in color. Please input if the new movie is in color 'yes/no': ");
                    String yesOrNo = input.nextLine();
                    boolean newIsInColor = yesOrNo.equalsIgnoreCase("yes");
                    movieToEdit.setIsinColor(newIsInColor);
                    System.out.println(movieToEdit);


                } else if (userChoice == 5) {
                    System.out.println("You've selected to change the length in minutes. Please input the new length in minutes: ");
                    int newLengthInMinutes = input.nextInt();
                    input.nextLine();
                    movieToEdit.setLengthInMinutes(newLengthInMinutes);
                    System.out.println(movieToEdit);


                } else if (userChoice == 6) {
                    System.out.println("You've selected to change the genre. Please input a new genre: ");
                    String newGenre = input.nextLine();
                    movieToEdit.setGenre(newGenre);
                    System.out.println(movieToEdit);


                } else if (userChoice == 7) {
                    System.out.println("You've selected to change the rating. Please input the new rating: ");
                    int newRating = input.nextInt();
                    input.nextLine();
                    movieToEdit.setRating(newRating);
                    System.out.println(movieToEdit);


                } else {
                    System.out.println("Error! please input a number between 1 & 7");

                }
            } else {
            System.out.println("Error! you haven't added any movies. Please add some movies.");
        }

    }


//Try catch metode til at fange InputMismatchException. Vi tilskriver den parameteren String prompt, så der kan udskrives en prompte string.
    //Herefter deklarer vi en int 'userInput' og en boolean 'flagdown'.
    //Samtidig bruger vi et while-loop med conditionen (!flagdown), så metoden bliver ved med genstarte indtil brugeren har indtastet en int værdi.
    //Når der bliver givet en int, vil flagdown blive true, hvilket gør vi bryder ud af while loopet.
    private int validateUserInput (String prompt) {
        int userInput = 0;
        boolean flagdown = false;

        while (!flagdown) {
            try {
                System.out.print(prompt);
                userInput = input.nextInt();
                input.nextLine();
                flagdown = true;

            } catch (InputMismatchException ime){
                System.out.println("Error! Please input a valid number!");
                input.nextLine();

            }
        } return userInput;
    }


    //Try catch metode til at fange InputMismatchException. Vi tilskriver den parameteren String prompt, int min og int max. Dette bruges i situationer når en bruger skal indtaste en int med en min. og max. værdi.
    //Herefter deklarer vi en int 'userInput' og en boolean 'flagdown'.
    //Samtidig bruger vi et while-loop med conditionen (!flagdown), så metoden bliver ved med genstarte indtil brugeren har indtastet en int værdi.
    //Når der bliver givet en int, vil flagdown blive true, hvilket gør vi bryder ud af while loopet.
    private int readIntWithValidation (String prompt, int min, int max) {
        int userInput = 0;
        boolean flagdown = false;

        while (!flagdown) {
            try {
                System.out.print(prompt);
                userInput = input.nextInt();
                input.nextLine();

                if(userInput>= min && userInput <= max){
                    flagdown = true;
                } else {
                    System.out.println("Error! Please input a number between " + min + " and " + max);
                }

            } catch (InputMismatchException ime){
                System.out.println("Error! Please input a valid number!");
                input.nextLine();
            }
        } return userInput;
    }
}

















