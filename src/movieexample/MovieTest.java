package movieexample;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieTest {

    public static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {

        // Exercise 1 - Which movies were released in 2020
        int year = 2020;
        movieRelasedInYear(year);

        // Exercise 2 - List horror movies
        Genre genre = Genre.HORROR;
        movieListByGenre(genre);

        // Exercise 3 - List Comedy movies released in 2019
        int yearCondition = 2019;
        listMovies(yearCondition,genre);

        // Exercise 4 - Get all movies where Brad Pitt is an actor
        String actor = "Brad Pitt";
        getAllMoviesByActor(actor);

        // Exercise 5 - Get all movies with Brad Pitt but not with Leonardo DiCaprio
        String notequalActor = "Leonardo DiCaprio";
        getAllMoviesByActorWithoutAnotherActor(actor,notequalActor);

        // Exercise 6 - Get top rated movies (5 stars)
        int star = 5;
        getTopRatedMovies(star);

        // Exercise 7 - Get top rated movies in 2020
        getTopRatedMoviesByYear(year,star);

        // Exercise 8 - Group movies by genre
        groupMoviesByGenre();

        List<String> movies  = getActionMovieNames();
        System.out.println("\nExercise 9 - Names of Action Movies: "+movies);

        // Exercise 9 - Names of Action Movies: [Casino Royale, Fight Club, Bad Boys For Life, Rocky Two, Rocky, Rocky Three]

        List<String> actionMoviesSortedByName  = getActionMovieNamesSorted();
        System.out.println("\nExercise 10 - Names of Action movies sorted: "+actionMoviesSortedByName);

        // Exercise 10 - Names of Action movies sorted: [Bad Boys For Life, Casino Royale, Fight Club, Rocky, Rocky Three, Rocky Two]

        List<Movie> actionMoviesByReleaseDate  = getActionMovieSortedByReleaseDate();
        System.out.println("\nExercise 11 - Action movies sorted by release date: "+actionMoviesByReleaseDate);

        // Exercise 11 - Action movies sorted by release date: [Movie [name=Rocky, dateOfRelease=1976-12-03], Movie [name=Rocky Two, dateOfRelease=1979-06-15], Movie [name=Rocky Three, dateOfRelease=1982-05-28], Movie [name=Fight Club, dateOfRelease=1999-10-10], Movie [name=Casino Royale, dateOfRelease=2006-11-14], Movie [name=Bad Boys For Life, dateOfRelease=2020-01-17]]

        List<String > directors = getDirectorNamesOfMoviesAfter2000();
        System.out.println("\nExercise 12 - Names of directors that have released movies "
                + "after year 2000: " +directors);

        // Exercise 12 - Names of directors that have released movies after year 2000: [Martin Campbell, Anthony Russo, Peter Howitt, Martin Scorsese, Nicolas Pesce, Quentin Tarantino, Adil El Arbi]

        // Exersise 13 : Show First Rocky Movie
        findFirstRockyMovie();

        // Exersise 14 : Show statement if Will Smith is a cast of any movie in 2020
        willSmithMovie2020();

        //Exercise 15 - Find the highest grossing movie.
        Optional<Movie> highestEarningMovie = highestGrossingMovie();
        System.out.println("Exercise 15 - Find the highest grossing movie : " + highestEarningMovie);

        // Exercise 15 - Find the highest grossing movie : Optional[Movie [name=Avengers:Endgame, dateOfRelease=2019-04-26]]

        //Exercise 16 - find the lowest grossing movie in the year 2020
        Optional<Movie> lowestEarningMovieIn2020 = lowestGrossingMovieIn2020();
        System.out.println("Exercise 16 - find the lowest grossing movie in the year 2020 : " + lowestEarningMovieIn2020);

        // Exercise 16 - find the lowest grossing movie in the year 2020 : Optional[Movie [name=The Grudge, dateOfRelease=2020-01-03]]

        //Exercise 17 - Total money - films made by Martin Scorsese
        long sum = sumGrossMoviesByMartinScorsese();
        System.out.println("Exercise 17 - Total money - films made by Martin Scorsese : " + sum);

        // Exercise 17 - Total money - films made by Martin Scorsese : 683000000

        //Exercise 18 - How many movies released in last 5 years ?
        long noLastFiveYears = noOfMoviesInLastFiveYears();
        System.out.println("Exercise 18 - How many movies released in last 5 years ? : " + noLastFiveYears);

        // Exercise 18 - How many movies released in last 5 years ? : 4

        //Exercise 19 - group movies by genre
        Map<Genre,List<Movie>> movieByGenre = groupByGenre();
        System.out.println("Exercise 19 - group movies by genre : " + movieByGenre);

        // Exercise 19 - group movies by genre : {SUPERHERO=[Movie [name=Avengers:Endgame, dateOfRelease=2019-04-26]], COMEDY=[Movie [name=Johnny English, dateOfRelease=2003-04-11], Movie [name=Once upon a time in Hollywood, dateOfRelease=2019-07-26]], HORROR=[Movie [name=The Grudge, dateOfRelease=2020-01-03]], ACTION=[Movie [name=Casino Royale, dateOfRelease=2006-11-14], Movie [name=Fight Club, dateOfRelease=1999-10-10], Movie [name=Bad Boys For Life, dateOfRelease=2020-01-17], Movie [name=Rocky Two, dateOfRelease=1979-06-15], Movie [name=Rocky, dateOfRelease=1976-12-03], Movie [name=Rocky Three, dateOfRelease=1982-05-28]], CRIME=[Movie [name=The Departed, dateOfRelease=2006-09-26], Movie [name=The Wolf Of Wall Street, dateOfRelease=2013-12-25]]}

        //Exercise 20 - Find the number of movies released in each year
        Map<Integer,Long> groupByYearCount = totalMoviesReleasesInEachYear();
        System.out.println("Exercise 20 - Find the number of movies released in each year : " + groupByYearCount);

        // Exercise 20 - Find the number of movies released in each year : {2003=1, 2019=2, 2020=2, 2006=2, 1976=1, 1979=1, 2013=1, 1982=1, 1999=1}

        //Exercise 21 - Find the gross earning of movies classified by genre
        Map<Genre,Long> grossByGenre =  grossEarningByGenre();
        System.out.println("Exercise 21 - Find the gross earning of movies classified by genre : " + grossByGenre);

        // Exercise 21 - Find the gross earning of movies classified by genre : {SUPERHERO=3000000000, COMEDY=533000000, HORROR=50000000, ACTION=1693099584, CRIME=683000000}

        //Exercise 22 - Group movies with rating >= 4
        Map<Integer,List<Movie>> groupByRating = groupByFourAndAboveRating();
        System.out.println("Exercise 22 - Group movies with rating >= 4 : " + groupByRating);

        // Exercise 22 - Group movies with rating >= 4 : {4=[Movie [name=Casino Royale, dateOfRelease=2006-11-14], Movie [name=Johnny English, dateOfRelease=2003-04-11], Movie [name=Rocky Two, dateOfRelease=1979-06-15], Movie [name=Rocky, dateOfRelease=1976-12-03], Movie [name=Rocky Three, dateOfRelease=1982-05-28]], 5=[Movie [name=Avengers:Endgame, dateOfRelease=2019-04-26], Movie [name=The Departed, dateOfRelease=2006-09-26], Movie [name=The Wolf Of Wall Street, dateOfRelease=2013-12-25], Movie [name=Once upon a time in Hollywood, dateOfRelease=2019-07-26], Movie [name=Fight Club, dateOfRelease=1999-10-10]]}

        //Exercise 23 - Group movies with rating >= 4 but only names of movies.
        Map<Integer,List<String>> byRatingMovieName = movieNamesGroupedByRating();
        System.out.println("Exercise 23 - Group movies with rating >= 4 but only names of movies : " + byRatingMovieName);

        // Exercise 23 - Group movies with rating >= 4 but only names of movies : {4=[Casino Royale, Johnny English, Rocky Two, Rocky, Rocky Three], 5=[Avengers:Endgame, The Departed, The Wolf Of Wall Street, Once upon a time in Hollywood, Fight Club]}

        //Exercise 24: Find list of stars who have acted in Martin Scorsese movies
        List<String> starCast = starsInMartinMovies();
        System.out.println("Exercise 24: Find list of stars who have acted in Martin Scorsese movies : " + starCast);

        // Exercise 24: Find list of stars who have acted in Martin Scorsese movies : [Leonardo DiCaprio, Matt Damon, Jack Nicholson, Leonardo DiCaprio, Jonah Hill, Margot Robbie]

        //Exercise 25: Find unique list of stars who have acted in Martin Scorsese movies
        Set<String> starCastUnique = uniqueStarsInMartinMovies();
        System.out.println("Exercise 25: Find unique list of stars who have acted in Martin Scorsese movies : " + starCastUnique);

        // Exercise 25: Find unique list of stars who have acted in Martin Scorsese movies : [Jonah Hill, Leonardo DiCaprio, Matt Damon, Jack Nicholson, Margot Robbie]

    }

    public static List<String> starsInMartinMovies() {
        return movies.stream()
                .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
                .flatMap(movie -> movie.getCast().stream())
                .collect(Collectors.toList());
    }

    public static Set<String> uniqueStarsInMartinMovies() {
        return movies.stream()
                .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
                .flatMap(movie -> movie.getCast().stream())
                .collect(Collectors.toSet());
    }


    public static Map<Genre, Long> grossEarningByGenre() {
        return movies.stream()
                .collect(Collectors.groupingBy(
                                Movie::getGenre,
                                Collectors.summingLong(Movie::getGrossEarning)
                        )
                );
    }

    public static Map<Genre,List<Movie>> groupByGenre() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
    }

    public static Map<Integer, Long> totalMoviesReleasesInEachYear() {
        return movies.stream()
                .collect(Collectors.groupingBy((Movie movie) ->
                                        movie.getDateOfRelease().getYear(),
                                Collectors.counting()
                        )
                );
    }

    public static Map<Integer, List<Movie>> groupByFourAndAboveRating() {
        return movies.stream()
                .filter( movie -> movie.getRating() >=4)
                .collect(Collectors.groupingBy(Movie::getRating));
    }

    public static Map<Integer, List<String>> movieNamesGroupedByRating() {
        return movies.stream()
                .filter(movie -> movie.getRating()>=4)
                .collect(Collectors.groupingBy
                        (
                                Movie::getRating,
                                Collectors.mapping(Movie::getName, Collectors.toList())
                        )
                );
    }


    private static long noOfMoviesInLastFiveYears() {

        LocalDate lastFiveYears = LocalDate.now().minusYears(5);

        return movies.stream()
                .filter(movie -> movie.getDateOfRelease().isAfter(lastFiveYears))
                .count();
    }

    public static Optional<Movie> highestGrossingMovie() {

        Comparator<Movie> byGrossEarning = Comparator.comparing(Movie::getGrossEarning);

        return movies.stream()
                .max(byGrossEarning);
    }

    public static Optional<Movie> lowestGrossingMovieIn2020() {

        Comparator<Movie> byGrossEarning = Comparator.comparing(Movie::getGrossEarning);

        return movies.stream()
                .filter(movie -> movie.getDateOfRelease().getYear() == 2020)
                .min(byGrossEarning);
    }

    public static long sumGrossMoviesByMartinScorsese() {

        return movies.stream()
                .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
                .mapToLong(movie -> movie.getGrossEarning())
                .sum();
    }

    public static void findFirstRockyMovie() {

        Comparator<Movie> byReleaseDate = Comparator.comparing(Movie::getDateOfRelease);

        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getName().contains("Rocky"))
                .sorted(byReleaseDate)
                .findFirst();

        System.out.println(movie.orElseThrow());
        // Movie [name=Rocky, dateOfRelease=1976-12-03]

    }

    public static void willSmithMovie2020() {
        boolean willSmithMovie2020 =
                movies.stream()
                        .filter(movie -> movie.getDateOfRelease().getYear() == 2020)
                        .anyMatch(movie -> movie.getCast().contains("Will Smith"));

        System.out.println(willSmithMovie2020);
        // true
    }


    //exercise 9 - Using map
    public static List<String> getActionMovieNames() {

        return movies.stream()
                .filter(movie -> movie.getGenre().equals(Genre.ACTION))
                .map(movie -> movie.getName())
                .collect(Collectors.toList());
    }

    //exercise 10- using sorted- sort action movies by name
    public static List<String> getActionMovieNamesSorted() {

        return movies.stream()
                .filter(movie -> movie.getGenre().equals(Genre.ACTION))
                .map(movie -> movie.getName())
                .sorted()
                .collect(Collectors.toList());
    }

    //exercise 11- using sorted- sort action movies by release date

    public static List<Movie> getActionMovieSortedByReleaseDate() {

        Comparator<Movie> byReleaseDate = Comparator.comparing(Movie::getDateOfRelease);

        return movies.stream()
                .filter(movie -> movie.getGenre().equals(Genre.ACTION))
                .sorted(byReleaseDate)
                .collect(Collectors.toList());
    }

    //exercise 12 - Retrieve the names of directors that have released movie after year 2000
    public static List<String> getDirectorNamesOfMoviesAfter2000() {

        return movies.stream()
                .filter(movie -> movie.getDateOfRelease().getYear() > 2000)
                .map(movie -> movie.getDirectorName())
                .distinct()
                .collect(Collectors.toList());
    }

    private static void groupMoviesByGenre() {

        Map<Genre,List<Movie>> movieByGenre = new HashMap<>();
        movies.stream().forEach(
                movie -> movieByGenre.computeIfAbsent(
                            movie.getGenre(), k -> new ArrayList<Movie>()
                         ).add(movie)
        );

        System.out.println("\nExercise 8 - groupMoviesByGenre : "+movieByGenre);

        // Exercise 8 - groupMoviesByGenre : {SUPERHERO=[Movie [name=Avengers:Endgame, dateOfRelease=2019-04-26]], COMEDY=[Movie [name=Johnny English, dateOfRelease=2003-04-11], Movie [name=Once upon a time in Hollywood, dateOfRelease=2019-07-26]], HORROR=[Movie [name=The Grudge, dateOfRelease=2020-01-03]], ACTION=[Movie [name=Casino Royale, dateOfRelease=2006-11-14], Movie [name=Fight Club, dateOfRelease=1999-10-10], Movie [name=Bad Boys For Life, dateOfRelease=2020-01-17], Movie [name=Rocky Two, dateOfRelease=1979-06-15], Movie [name=Rocky, dateOfRelease=1976-12-03], Movie [name=Rocky Three, dateOfRelease=1982-05-28]], CRIME=[Movie [name=The Departed, dateOfRelease=2006-09-26], Movie [name=The Wolf Of Wall Street, dateOfRelease=2013-12-25]]}

    }

    private static void getTopRatedMoviesByYear(int year, int star) {

        List<Movie> topRated2020 = getMovies(movieWithRating(star).and(movieReleasedInYear(year)));

        System.out.println("\nExercise 7 -Top rated in 2020 : " +topRated2020);

        // Exercise 7 -Top rated in 2020 : []

    }

    private static void getTopRatedMovies(int star) {
        Predicate<Movie> topRated = movieWithRating(star);

        List<Movie> topRatedMovies = getMovies(topRated);
        System.out.println("\nExercise 6 - Get top rated movies : "+topRatedMovies);

        // Exercise 6 - Get top rated movies : [Movie [name=Avengers:Endgame, dateOfRelease=2019-04-26], Movie [name=The Departed, dateOfRelease=2006-09-26], Movie [name=The Wolf Of Wall Street, dateOfRelease=2013-12-25], Movie [name=Once upon a time in Hollywood, dateOfRelease=2019-07-26], Movie [name=Fight Club, dateOfRelease=1999-10-10]]

    }

    private static void getAllMoviesByActorWithoutAnotherActor(String actor,String notequalActor) {

        Predicate<Movie> moviesWithBradPitt = movieByStarCast(actor);
        Predicate<Movie> moviesWithLeo = movieByStarCast(notequalActor);

        List<Movie> moviesWithBradAndNoLeo = getMovies(moviesWithLeo.negate().and(moviesWithBradPitt));
        System.out.println("\nExercise 5 - Brad without Leo moves : "+moviesWithBradAndNoLeo);

        // Exercise 5 - Brad without Leo moves : [Movie [name=Fight Club, dateOfRelease=1999-10-10]]

    }

    private static void getAllMoviesByActor(String actor) {
        Predicate<Movie> moviesWithBradPitt = movieByStarCast(actor);

        List<Movie> movieListBradPitt= getMovies(moviesWithBradPitt);
        System.out.println("\nExercise 4 - Brad Pitt stars in the following : "+movieListBradPitt);

        // Exercise 4 - Brad Pitt stars in the following : [Movie [name=Once upon a time in Hollywood, dateOfRelease=2019-07-26], Movie [name=Fight Club, dateOfRelease=1999-10-10]]

    }

    private static void listMovies(int yearCondition, Genre genre) {

        Predicate<Movie> horrorInYear = movieReleasedInYear(yearCondition).and(movieByGenre(genre));

        List<Movie> horrorMoviesIn2019 = getMovies(horrorInYear);
        System.out.println("\nExercise 3 - Horror movies in the year 2019: "+horrorMoviesIn2019);

        // Exercise 3 - Horror movies in the year 2019: []
    }


    private static void movieListByGenre(Genre genre) {
        Predicate<Movie> horrorMovies = movieByGenre(genre);

        List<Movie> getHorrorMovies = getMovies(horrorMovies);
        System.out.println("\nExercise 2 - Horror movies: " +getHorrorMovies);

        // Exercise 2 - Horror movies: [Movie [name=The Grudge, dateOfRelease=2020-01-03]]
    }

    private static void movieRelasedInYear(int year) {

        Predicate<Movie> movieReleasedInYear2020 = movieReleasedInYear(year);

        List<Movie> getMoviesInYear = getMovies(movieReleasedInYear2020);
        System.out.println("\nExercise 1 - Movies released in Year "+ year + ": " + getMoviesInYear);

        // Exercise 1 - Movies released in Year 2020: [Movie [name=The Grudge, dateOfRelease=2020-01-03], Movie [name=Bad Boys For Life, dateOfRelease=2020-01-17]]
    }

    private static List<Movie> getMovies(Predicate<Movie> movieFilter) {
        return movies.stream().filter(movieFilter).collect(Collectors.toList());
    }

    private static Predicate<Movie> movieReleasedInYear(int year){
        return movie -> movie.getDateOfRelease().getYear() == year;
    }

    private static Predicate<Movie> movieByGenre(Genre genre){
        return movie -> movie.getGenre() == genre;
    }

    private static Predicate<Movie> movieByStarCast(String star){
        return movie -> movie.getCast().contains(star);
    }

    private static Predicate<Movie> movieWithRating(int rating){
        return movie -> movie.getRating() == rating;
    }



}
