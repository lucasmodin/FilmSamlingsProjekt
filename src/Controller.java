import java.util.ArrayList;

public class Controller {

    private MovieCollection movieCollection;


    //Constructor der initialisere en ny instans af MovieCollection class.
    public Controller() {
        this.movieCollection = new MovieCollection();
    }

    // Metode til at få adgang til filmelisten fra MovieCollection.
    public ArrayList<Movie> getMovieList() {
        return movieCollection.getMovieList();

    }

    // Metode til at tilføje en ny film ved at kalde metoden i MovieCollection
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre, int rating) {
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);
    }

    // Metode til at udskrive hele filmkollektionen ved at kalde metoden i MovieCollection.
    public String printCollection() {
        return movieCollection.printCollection();
    }

    // Metode til at fjerne en film fra samlingen ved at kalde metoden i MovieCollection.
    public void removeMovie(String title) {
        movieCollection.removeMovie(title);

    }

    // Metode til at kontrollere, om filmlisten ikke er tom ved at kalde metoden i MovieCollection.
    public boolean isMovieListNotEmpty() {
        return movieCollection.isMovieListNotEmpty();

    }

    // Metode til at søge gennem filmkollektionen ved at kalde metoden i MovieCollection.
    public ArrayList<Movie> searchTroughMovieList(String title) {
        return movieCollection.searchTroughMovieList(title);
    }


}

