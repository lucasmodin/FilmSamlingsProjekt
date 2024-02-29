//importere ArrayList
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movieList;
    private int count;
    public MovieCollection() {

        this.movieList = new ArrayList<>();
        count = 0;

    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre, int rating) {
        movieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating));
        count++;
    }


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
    public void removeMovie(String title) {
        for (Movie movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movieList.remove(movie);
                count--;
                break;
            }

        } System.out.println("Movie with title " + title + " was not found in the collection");
    }



    public void changeMovie (String title, String newTitle, String newDirector, int newYearCreated, boolean newIsinColor, int newLengthInMinutes, String newGenre, int newRating) {
        for (Movie movie : movieList){
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYearCreated(newYearCreated);
                movie.setIsinColor(newIsinColor);
                movie.setLengthInMinutes(newLengthInMinutes);
                movie.setGenre(newGenre);
                movie.setRating(newRating);
                break;  }
            else {
                System.out.println("Error! no movie by that title found.");
            }
        }
    }


    public ArrayList<Movie> searchTroughMovieList(String title){
     ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movieList) {
            if(movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(movie);
            }
        } return result;
    }

    public boolean isMovieListNotEmpty () {
        return !movieList.isEmpty();
    }
    public ArrayList<Movie> getMovieList(){
        return movieList;
    }

}








