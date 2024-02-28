import org.junit.jupiter.api.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addMovie() {
        //Arrange
         String title = "Die Hard";
         String director = "Michael Bay";
         int yearCreated = 1999;
         boolean isInColor = true;
         int lengthInMinutes = 92;
         String genre = "Action";
         int rating = 9;

        ArrayList<Movie> movieArrayList = new ArrayList<>();
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);

        //Act
        ArrayList<Movie>  actualList = movieCollection.getMovieList();
        ArrayList<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating));

        //Assert
        assertEquals(expectedList.toString(), actualList.toString());

    }

    @Test
    void getMovieList() {
        //Arrange
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        MovieCollection filmliste = new MovieCollection();
        filmliste.addMovie("Die Hard", "Michael Bay", 1999, true, 92, "Action", 9);


        //Act
        ArrayList<Movie> actualList = filmliste.getMovieList();
        ArrayList<Movie> expectedList = new ArrayList<>();
        expectedList.add(new Movie("Die Hard", "Michael Bay", 1999, true, 92, "Action", 9));

        //Assert
        assertEquals(expectedList.toString(), actualList.toString());

    }
}