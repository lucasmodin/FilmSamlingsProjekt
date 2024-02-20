import java.util.Scanner;
public class Movie {
    private String title = "";
    private String director = "";
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre = "";
    private int rating;

    public Movie(String title, String director, int yearCreated,
                 boolean isInColor, int lengthInMinutes, String genre, int rating) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean getIsinColor() {
        return isInColor;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getGenre() {
        return genre;
    }
    public int getRating(){
        return rating;
    }

    public String toString() {
        return "Title: " + getTitle() +
                ", Director: " + director +
                ", Year: " + yearCreated +
                ", Color: " + (isInColor ? "Yes" : "No") +
                ", Length: " + lengthInMinutes + " minutes" +
                ", Genre: " + genre +
                ", Rating " + rating;
    }

}