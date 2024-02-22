
public class Controller {
    //deklarerer et moviecollection objekt.
    MovieCollection movieCollection;


    public Controller() {
        this.movieCollection = new MovieCollection();
        //i vores constructor instanciere vi vores movieCollection objekt.

    }
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre, int rating) {
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre, rating);
        //I addMovie metoden kalder vi på addMovie metoden i movieCollection klassen. Her giver vi metoden samme parametre som i movieCollection.
    }
    public void printCollection() { 
        movieCollection.printCollection();
        //Igen kalder vi bare på metoden inde i movieCollection klassen.
    }
    public void removeMovie(String title) {
        movieCollection.removeMovie(title);
        //igen kaldt på en metode fra movieCollection klassen
    }
    public void changeMovie(String title, String newTitle, String newDirector, int newYearCreated,
                            boolean newIsinColor, int newLengthInMinutes, String newGenre, int newRating) {
        movieCollection.changeMovie(title, newTitle, newDirector, newYearCreated, newIsinColor, newLengthInMinutes, newGenre, newRating);
        //igen kaldt på en metode fra movieCollection. Igen giver vi samme parametre.
        //Vi kan nu kalde disse metoder fra vores Main klasse.
    }

    }
