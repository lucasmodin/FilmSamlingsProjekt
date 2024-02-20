import java.util.Scanner;
public class MovieCollection {
    //opretter en Movie attribute array
    private Movie[] movieList;
private int count;

//Constructor der tager parameteren size
    public MovieCollection(int size){
        this.movieList = new Movie[size];
        this.count = 0;

    }


    //metode til at tilføje film. Hvis count er større end længden, får brugeren et output der siger at kollektionen er fuld.
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre){
        if (count < movieList.length) {
            movieList[count++] = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        } else {
            System.out.println("Movie collection is full. Cannot add more movies.");
        }
    }
    //metode til at printe kollektionen. Hvis der er en film, så printer den alle attributterne.
    public void printCollection() {
        for (Movie movie : movieList) {
            if (movie != null) {
                System.out.println(movie);
            }
        }

    }

}
