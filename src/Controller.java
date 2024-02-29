import java.util.ArrayList;

public class Controller {

    private MovieCollection movieCollection;


    public Controller() {
        this.movieCollection = new MovieCollection();


    }

    public ArrayList<Movie> getMovieList (){
        return movieCollection.getMovieList();
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre, int rating) {
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);
       }
    public String printCollection() {
        return movieCollection.printCollection();
       }
    public void removeMovie(String title) {
        movieCollection.removeMovie(title);

    }
    public void changeMovie(String title, String newTitle, String newDirector, int newYearCreated,
                            boolean newIsinColor, int newLengthInMinutes, String newGenre, int newRating) {
        movieCollection.changeMovie(title, newTitle, newDirector, newYearCreated, newIsinColor, newLengthInMinutes, newGenre, newRating);

    }

    public boolean isMovieListNotEmpty(){
        return movieCollection.isMovieListNotEmpty();

    }
    public ArrayList<Movie> searchTroughMovieList(String title){
        return movieCollection.searchTroughMovieList(title);
    }




    }

