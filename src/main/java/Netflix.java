import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


/**
 * Your Netflix journey begins here!
 *
 * @author Jayanth
 * @author Srijan
 * @author Ladd Jones
 * @version 1.0
 */
public class Netflix {

    private static Scanner in;
    private static PopulateNetflix popPop;
    private static Random rand;
    private static Library library;
    private static List<Movie> list;

    /**
     * Main method for Netflix. This produces the high-end login screen
     * for our Netflix service that took a team of experienced
     * UI designers to create.
     * @throws Exception throws exception
     * @param args command-line arguments for the program.
     */
    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        popPop = new PopulateNetflix();
        library = new Library(popPop.getNetflixPopulation());

        Map<String, List<Movie>> userWatchLists = new HashMap<>();

        Set<Genre> comedyEnum = new HashSet<Genre>();
        comedyEnum.add(Genre.COMEDY);
        List<Movie> taylorsMovies = library.moviesWithGenre(comedyEnum);
        Library taylorsLibrary = new Library(taylorsMovies);
        taylorsMovies = taylorsLibrary.listAlphabetically();
        userWatchLists.put("Taylor", taylorsMovies);

        Set<Genre> enumActionAdventure = new HashSet<Genre>();
        enumActionAdventure.add(Genre.ACTION);
        enumActionAdventure.add(Genre.ADVENTURE);
        List<Movie> georgesMovies
            = library.moviesWithGenre(enumActionAdventure);
        Library georgesLibrary = new Library(georgesMovies);
        georgesMovies = georgesLibrary.listByHighestRating();
        userWatchLists.put("George", georgesMovies);

        List<Movie> sarahsMovies = library.listByYearRange(1980, 2000);
        userWatchLists.put("Sarah", sarahsMovies);





        boolean running = true;
        System.out.println("Welcome to your very own Netflix service!");
        while (running) {
            System.out.println("\nNow, who's watching tonight? [q to exit]");

            String response = in.nextLine();
            if (response.equals("q")) {
                System.out.println("Thanks for watching!");
                running = false;
            } else if (userWatchLists.containsKey(response)) {

                List<Movie> watchList = userWatchLists.get(response);


                int numMovies = -1;
                while (numMovies < 1) {
                    System.out.println("How many movies would you like"
                        + " to watch? (1 - 10)");
                    try {
                        numMovies = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please try again");
                    }
                }

                System.out.println("\nHere you go!\n");

                if (numMovies > watchList.size()) {
                    numMovies = watchList.size();
                }
                for (Movie m : watchList.subList(0, numMovies)) {
                    System.out.println(m);
                }
            } else {
                System.out.println("\nNetflix does not "
                    + "recognize that input\n");
            }
        }
    }
}
