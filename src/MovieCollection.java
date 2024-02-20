import java.util.ArrayList;


public class MovieCollection {
    private ArrayList<Movie> movieList;

private int count;


    public MovieCollection(){

        this.movieList = new ArrayList<>();
        this.count = 0;

    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre, int rating){
            movieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating));
            count++;

    }

    //metode til at printe kollektionen. Hvis der er en film, så printer den alle attributterne.
    public void printCollection() {
        for (Movie movie : movieList) {
            if (movie != null) {
                System.out.println(movie);
            }
        }

    }
    public void removeMovie(String title){
        for (Movie movie : movieList){
            if (movie.getTitle().equals(title)) {
                movieList.remove(movie);
                count--;
                return; //return statement for at komme ud af metoden når titlen er fundet.
            } else {
                System.out.println("Movie with title " + title + " was not found in the collection" );
            }
        }

    }

    public void changeMovie (String title, String newTitle, String newDirector, int newYearCreated, boolean newIsinColor, int newLengthInMinutes, String newGenre, int newRating) {
        for (Movie movie : movieList){
            if (movie.getTitle().equals(title)) {
                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYearCreated(newYearCreated);
                movie.setIsinColor(newIsinColor);
                movie.setGenre(newGenre);
                movie.setRating(newRating);
                return;
            }
        }
        System.out.println("Error! no movie by that title found.");
    }
}
