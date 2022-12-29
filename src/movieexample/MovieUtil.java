package movieexample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieUtil {

	private static List<Movie> movies = new ArrayList<>();

	public static List<Movie> getMovieData() {

		// casino royale, Rating 4
		Movie casinoRoyale = new Movie("Casino Royale", "Martin Campbell");

		List<String> starCast = new ArrayList<>();
		starCast.add("Daniel Craig");
		starCast.add("Eva Green");

		casinoRoyale.setCast(starCast);
		casinoRoyale.setGenre(Genre.ACTION);
		casinoRoyale.setRating(4);
		casinoRoyale.setDateOfRelease(LocalDate.of(2006, 11, 14));
		casinoRoyale.setGrossEarning(606_099_584);

		// Avengers, Rating 5
		Movie avengers = new Movie("Avengers:Endgame", "Anthony Russo");

		List<String> avengersStarCast = new ArrayList<>();
		avengersStarCast.add("Robert Downey Jr.");
		avengersStarCast.add("Chris Evans");
		avengersStarCast.add("Mark Ruffalo");
		avengersStarCast.add("Chris Hemsworth");

		avengers.setCast(avengersStarCast);
		avengers.setGenre(Genre.SUPERHERO);
		avengers.setRating(5);
		avengers.setDateOfRelease(LocalDate.of(2019, 04, 26));
		avengers.setGrossEarning(3_000_000_000L);

		// Johnny English, Rating 4
		Movie johnyEnglish = new Movie("Johnny English", "Peter Howitt");

		List<String> johnyEnglishStarCast = new ArrayList<>();
		johnyEnglishStarCast.add("Rowan Atkinson");

		johnyEnglish.setCast(johnyEnglishStarCast);
		johnyEnglish.setGenre(Genre.COMEDY);
		johnyEnglish.setRating(4);
		johnyEnglish.setDateOfRelease(LocalDate.of(2003, 04, 11));
		johnyEnglish.setGrossEarning(159_000_000);

		// The Departed, Rating 5
		Movie departed = new Movie("The Departed", "Martin Scorsese");

		List<String> departedStarCast = new ArrayList<>();
		departedStarCast.add("Leonardo DiCaprio");
		departedStarCast.add("Matt Damon");
		departedStarCast.add("Jack Nicholson");

		departed.setCast(departedStarCast);
		departed.setGenre(Genre.CRIME);
		departed.setRating(5);
		departed.setDateOfRelease(LocalDate.of(2006, 9, 26));
		departed.setGrossEarning(291_000_000);

		// The grudge, Rating 3
		Movie grudge = new Movie("The Grudge", "Nicolas Pesce");

		List<String> grudgeStarCast = new ArrayList<>();
		grudgeStarCast.add("John Cho");
		grudgeStarCast.add("Andrea Riseborough");

		grudge.setCast(grudgeStarCast);
		grudge.setGenre(Genre.HORROR);
		grudge.setRating(3);
		grudge.setDateOfRelease(LocalDate.of(2020, 1, 3));
		grudge.setGrossEarning(50_000_000);

		// The wolf of wall street, Rating 5
		Movie wows = new Movie("The Wolf Of Wall Street", "Martin Scorsese");

		List<String> wowfStarCast = new ArrayList<>();
		wowfStarCast.add("Leonardo DiCaprio");
		wowfStarCast.add("Jonah Hill");
		wowfStarCast.add("Margot Robbie");

		wows.setCast(wowfStarCast);
		wows.setGenre(Genre.CRIME);
		wows.setRating(5);
		wows.setDateOfRelease(LocalDate.of(2013, 12, 25));
		wows.setGrossEarning(392_000_000);

		// Once upon a time in hollywood, Rating 5
		Movie onceHollywood = new Movie("Once upon a time in Hollywood", "Quentin Tarantino");

		List<String> onceHollyWoodStarCast = new ArrayList<>();
		onceHollyWoodStarCast.add("Leonardo DiCaprio");
		onceHollyWoodStarCast.add("Brad Pitt");
		onceHollyWoodStarCast.add("Margot Robbie");

		onceHollywood.setCast(onceHollyWoodStarCast);
		onceHollywood.setGenre(Genre.COMEDY);
		onceHollywood.setRating(5);
		onceHollywood.setDateOfRelease(LocalDate.of(2019, 7, 26));
		onceHollywood.setGrossEarning(374_000_000);

		// Fight club, Rating 5
		Movie fightClub = new Movie("Fight Club", "David Fincher");

		List<String> fightClubStarCast = new ArrayList<>();
		fightClubStarCast.add("Brad Pitt");
		fightClubStarCast.add("Edward Norton");

		fightClub.setCast(fightClubStarCast);
		fightClub.setGenre(Genre.ACTION);
		fightClub.setRating(5);
		fightClub.setDateOfRelease(LocalDate.of(1999, 10, 10));
		fightClub.setGrossEarning(101_000_000);

		// Bad Boys For Life ,Rating 3
		Movie badBoys = new Movie("Bad Boys For Life", "Adil El Arbi");

		List<String> badBoysStarCast = new ArrayList<>();
		badBoysStarCast.add("Will Smith");
		badBoysStarCast.add("Martin Lawrence");

		badBoys.setCast(badBoysStarCast);
		badBoys.setGenre(Genre.ACTION);
		badBoys.setRating(3);
		badBoys.setDateOfRelease(LocalDate.of(2020, 01, 17));
		badBoys.setGrossEarning(291_000_000);

		//Rocky two
		Movie rockyTwo = new Movie("Rocky Two", "Sylvester Stallone");
		List<String> rockyTwoCast = new ArrayList<>();
		rockyTwoCast.add("Sylvester Stallone");
		rockyTwoCast.add("Carl Weathers");
		rockyTwo.setCast(rockyTwoCast);
		rockyTwo.setGenre(Genre.ACTION);
		rockyTwo.setRating(4);
		rockyTwo.setDateOfRelease(LocalDate.of(1979, 06, 15));
		rockyTwo.setGrossEarning(200_000_000);

		//Rocky
		Movie rockyOne = new Movie("Rocky", "John G. Avildsen");
		List<String> rockyOneCast = new ArrayList<>();
		rockyOneCast.add("Sylvester Stallone");
		rockyOneCast.add("Carl Weathers");
		rockyOne.setCast(rockyOneCast);
		rockyOne.setGenre(Genre.ACTION);
		rockyOne.setRating(4);
		rockyOne.setDateOfRelease(LocalDate.of(1976, 12, 03));
		rockyOne.setGrossEarning(225_000_000);

		//Rocky three
		Movie rockyThree = new Movie("Rocky Three", "Sylvester Stallone");
		List<String> rockyThreeCast = new ArrayList<>();
		rockyThreeCast.add("Sylvester Stallone");
		rockyThreeCast.add("Carl Weathers");
		rockyThree.setCast(rockyThreeCast);
		rockyThree.setGenre(Genre.ACTION);
		rockyThree.setRating(4);
		rockyThree.setDateOfRelease(LocalDate.of(1982, 05, 28));
		rockyThree.setGrossEarning(270_000_000);

		movies.add(casinoRoyale);
		movies.add(avengers);
		movies.add(johnyEnglish);
		movies.add(departed);
		movies.add(grudge);
		movies.add(wows);
		movies.add(onceHollywood);
		movies.add(fightClub);
		movies.add(badBoys);
		movies.add(rockyTwo);
		movies.add(rockyOne);
		movies.add(rockyThree);

		return movies;
	}
}
