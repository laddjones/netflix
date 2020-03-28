import java.util.Set;

/**
 * Represents a Movie
 * @author Ladd Jones
 * @version 1.0 Nov. 6 2015
 */
public class Movie {
    private String name;
    private double rating;
    private int yearReleased;
    private Set<Genre> genreCollection;


    /**
    * Constructor for Movie
    * @param name the name of the movie
    * @param rating the reating of the movie
    * @param yearReleased the year the movie was produced
    * @param genreCollection the collection of genres
    */
    public Movie(String name, double rating, int yearReleased,
        Set<Genre> genreCollection) {
        this.name = name;
        this.rating = rating;
        this.yearReleased = yearReleased;
        this.genreCollection = genreCollection;
    }

    /**
    * Method getse the name
    * @return name returns the name
    */
    public String getName() {
        return name;
    }

    /**
    * Method getse the rating
    * @return rating returns the rating
    */
    public double getRating() {
        return rating;
    }

    /**
    * Method getse the year released
    * @return yearReleased returns the year released
    */
    public int getYearReleased() {
        return yearReleased;
    }

    /**
    * Method getse the genre
    * @return genreCollection returns the genre
    */
    public Set<Genre> getGenre() {
        return genreCollection;
    }


    /**
    * Method creates the hashcode for an object
    * @return theHashCode the hash code for the object
    */
    public int hashCode() {
        int theHashCode = (name.hashCode() + ((int) rating) + yearReleased);
        return theHashCode;
    }

    /**
    * Method overrides the equals method
    * @param obj the object you want to compare
    * @return boolean whether or not the two are equal
    */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Movie)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Movie movieObj = (Movie) obj;
        return (movieObj.getName().equals(this.getName())
            && movieObj.getRating() == this.getRating()
            && movieObj.getYearReleased() == this.getYearReleased());
    }

    @Override
    public String toString() {
        return "The name of the movie is: " + name + " ---- The rating is: "
            + rating + "\n" + "The year the movie was released was: "
            + yearReleased + " ---- Genre: " + genreCollection + "\n"
            + "___________________________________________";
    }
}
