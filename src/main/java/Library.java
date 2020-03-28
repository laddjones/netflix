import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represents a Library
 * @author Ladd Jones
 * @version 1.0 Nov. 6 2015
 */
public class Library {
    private List<Movie> movieCollection;

    /**
    * constructor for Library
    * @param movieCollection your collection of movies
    */
    public Library(List<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    /**
    * list movies alphabetically
    * @return copy representing a list of movies
    */
    public List<Movie> listAlphabetically() {
        Comparator<Movie> alphaCompar = new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                return (a.getName().compareTo(b.getName()));
            }
        };
        List<Movie> copy = new ArrayList<>(movieCollection);
        Collections.sort(copy, alphaCompar);
        return copy;
    }

    /**
    * list movies by genre
    * @param genre  represents sest of genres of a movie
    * @return copyMovieWithGenre representing a list of movies
    */
    public List<Movie> moviesWithGenre(Set<Genre> genre) {
        List<Movie> copyMovieWithGenre = new ArrayList<>();
        for (Genre elements: genre) {
            for (int i = 0; i < movieCollection.size(); i++) {
                if (movieCollection.get(i).getGenre().contains(elements)) {
                    copyMovieWithGenre.add(movieCollection.get(i));
                }
            }
        }
        return copyMovieWithGenre;
    }

    /**
    * list movies by year range
    * @param startingYear the starting year
    * @param endingYear the ending year you want
    * @return finalCopy representing a list of movies
    */
    public List<Movie> listByYearRange(int startingYear, int endingYear) {
        Comparator<Movie> alphaCompar = new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                return Integer.compare(a.getYearReleased(),
                    b.getYearReleased());
            }
        };
        List<Movie> copy = new ArrayList<>(movieCollection);
        Collections.sort(copy, alphaCompar);
        List<Movie> finalCopy = new ArrayList<>(copy);
        for (Movie element: copy) {
            if ((element.getYearReleased() >= startingYear)
                && (element.getYearReleased() < endingYear)) {
                finalCopy.add(element);
            }
        }
        return finalCopy;
    }

    /**
    * list movies from lowest to highest rating
    * @return copy representing a list of movies
    */
    public List<Movie> listByLowestRating() {
        Comparator<Movie> alphaCompar = new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                return Double.compare(a.getRating(), b.getRating());
            }
        };
        List<Movie> copy = new ArrayList<>(movieCollection);
        Collections.sort(copy, alphaCompar);
        return copy;
    }

    /**
    * list movies by highest to lowest rating
    * @return copy representing a list of movies
    */
    public List<Movie> listByHighestRating() {
        Comparator<Movie> alphaCompar = new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                return Double.compare(b.getRating(), a.getRating());
            }
        };
        List<Movie> copy = new ArrayList<>(movieCollection);
        Collections.sort(copy, alphaCompar);
        return copy;
    }
}
