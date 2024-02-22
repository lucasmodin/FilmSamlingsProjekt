//importere ArrayList
import java.util.ArrayList;

public class MovieCollection {
    //deklarerer ArrayList, der tager Movie constructoren, som argumenter.
    private ArrayList<Movie> movieList;

    private int count;


    public MovieCollection() {
        //I constructoren opretter vi Arraylisten.
        this.movieList = new ArrayList<>();
        count = 0;

    }

    //i AddMovie metoden giver vi den alle parameterne 'title' osv.
    // Herunder bruger vi arraylist bibliotekets funktion .add til at tilføje vores parametre som argumenter i Main klassen.
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre, int rating) {
        movieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating));
        count++;

    }

    //metode til at printe kollektionen. Vi laver et for each loop for at iterere igennem Arraylisten, og hvis 'movie' ikke er lig med 'null', så printer den listen.
    public void printCollection() {
        for (Movie movie : movieList) {
            if (movie != null) {
                System.out.println(movie);
            }
        }

    }

    //I removeMovie metoden laver vi et for-each loop til iterere igennem arraylisten. Den er givet parameteren 'title'
    //Herunder bruger getTitle metoden til at sige, at hvis indtastet titel er lig med titel i listen, så fjern den.
    public void removeMovie(String title) {
        for (Movie movie : movieList) {
            if (movie.getTitle().equals(title)) {
                movieList.remove(movie);
                count--;
                return; //return statement for at komme ud af metoden når titlen er fundet. Ellers får vi en concurrentModificationException.
            }

        } System.out.println("Movie with title " + title + " was not found in the collection");
    }


//Metode til at ændre en film i listen. Her får den parameterne title, der er den søgte titel, samt alle andre parametre med 'new' foran.
    //Meningen med dette er, at når brugeren indtaster en titel personen vil ændre, så bruger vi 'set' metoderne til at ændre værdierne i listen.
    public void changeMovie (String title, String newTitle, String newDirector, int newYearCreated, boolean newIsinColor, int newLengthInMinutes, String newGenre, int newRating) {
        for (Movie movie : movieList){
            if (movie.getTitle().equals(title)) {
                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYearCreated(newYearCreated);
                movie.setIsinColor(newIsinColor);
                movie.setGenre(newGenre);
                movie.setRating(newRating);
                return; //igen return statement for at komme ud af loopet, ellers får vi concurrentModificationException.
            }
        }
        System.out.println("Error! no movie by that title found.");
    }


    public void searchTroughArray(){


    }

    public boolean isMovieListNotEmpty () {
        return !movieList.isEmpty();
    }

}








