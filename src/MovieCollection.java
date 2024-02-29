//importere ArrayList
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movieList;
    private int count;

    // Constructor, initialiserer en tom liste af film og sætter antallet af film til 0.
    public MovieCollection() {

        this.movieList = new ArrayList<>();
        count = 0;

    }
    // Metode til at tilføje en ny film til samlingen med atributterne fra Movie class som parametre.
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre, int rating) {
        movieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating));
        count++;
    }

    // Metode til at udskrive hele filmkollektionen som en String.
    //Deklarer en String, herefter bruger vi et for-each loop til at iterere igennem filmlisten. For hver film vi finder, tilføjer vi den til listen.
    public String printCollection() {
        String result= "";
        for (Movie movie : movieList) {
            if (movie != null) {
                result += movie.toString() + "\n";
            }
        }
        if (!result.isEmpty()) {
            return result;
        }else {
            return "You havent added any movies yet.";
        }

    }
    // Metode til at fjerne en film fra samlingen med parameteren titel.
    //Bruger et for-each loop til at iterere igennem filmlisten. Hvis vi finder en film der passer med den søgte titel, fjerner vi den fra listen med metoden .remove()
    //Til sidst skal vi bruge et 'break' statement for at komme ud af loopet.
    public void removeMovie(String title) {
        for (Movie movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movieList.remove(movie);
                count--;
                break;
            }

        } System.out.println("Movie with title " + title + " was not found in the collection");
    }

    // Metode til at søge gennem filmkollektionen og returnere en ArrayList over matchende film med parameteren title.
    //Deklarer tom Arrayliste for tilføje søgte film
    public ArrayList<Movie> searchTroughMovieList(String title){
     ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movieList) {
            if(movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(movie);
            }
        } return result;
    }

    // Metode til at kontrollere, om filmkollektionen ikke er tom.
    public boolean isMovieListNotEmpty () {
        return !movieList.isEmpty();
    }

    // Metode til at få adgang til selve listen af film i kollektionen.
    public ArrayList<Movie> getMovieList(){
        return movieList;
    }

}








