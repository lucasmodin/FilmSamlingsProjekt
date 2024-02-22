public class MenuConstants {
    private final int ADD_MOVIE = 1;
    private final int CHANGE_MOVIE = 2;
    private final int VIEW_LIBRARY = 3;
    private final int DELETE_MOVIE = 4;
    private final int EXIT = -1;
    private final String WELCOME = "Welcome to your personal Movie Collection Library. ";
    private final String MENU =
            " Enter " + ADD_MOVIE + " if you would like to add movies to your collection \n"+
            " Enter " + CHANGE_MOVIE + " if you would like to change the movies in your collection \n" +
            " Enter " + VIEW_LIBRARY + " if you would like to take a look at your library \n" +
            " Enter " + DELETE_MOVIE + " if you would like to delete movies from your library \n" +
            " Enter " + EXIT         + " to end the program";

    private final String INVALID_MESSAGE = "";
    private final String EXIT_MESSAGE = "Exiting the program...";


    //getter metpder for at returnere

    public int getAddMovie(){
        return ADD_MOVIE;
    }
    public int getChangeMovie(){
        return CHANGE_MOVIE;
    }
    public int getViewLibrary(){
        return VIEW_LIBRARY;
    }
    public int getDeleteMovie(){
        return DELETE_MOVIE;
    }
    public int getExit(){
        return EXIT;
    }

    public String getWelcomeMessage(){
        return WELCOME;
    }
    public String getMenu(){
        return MENU;
    }
    public String getInvalidMessage(){
        return INVALID_MESSAGE;
    }
    public String getExitMessage(){
        return EXIT_MESSAGE;
    }






    }


