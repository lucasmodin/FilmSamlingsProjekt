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

        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);

        //Act
        int actualSize = movieCollection.getMovieList().size();
        int expectedSize = 1;

        //Assert
        assertEquals(expectedSize, actualSize);


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

    @Test
    void deleteMovie() {

        //Arrange
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        MovieCollection filmListe = new MovieCollection();
        filmListe.addMovie("Die Hard", "Michael Bay", 1999, true, 92, "Action", 9);

        //Act
        filmListe.removeMovie("Die Hard");
        int actualSize = filmListe.getMovieList().size();
        int expectedSize = 0;

        //Assert
        assertEquals(expectedSize, actualSize);
    }
}