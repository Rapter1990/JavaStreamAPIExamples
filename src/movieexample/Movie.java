
package movieexample;

import java.time.LocalDate;
import java.util.List;

public class Movie {

	private String name;
	private List<String> cast;
	private LocalDate dateOfRelease;
	private String director;
	private Genre genre;
	private int rating;
	private long grossEarning;

	public Movie(String name, String directorName) {
		this.name = name;
		this.director = directorName;
	}

	public String getName() {
		return name;
	}

	public String getDirectorName() {
		return director;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	public void setDateOfRelease(LocalDate date) {
		this.dateOfRelease = date;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getDateOfRelease() {
		return dateOfRelease;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", dateOfRelease=" + dateOfRelease + "]";
	}

	public Genre getGenre() {
		return genre;
	}

	public List<String> getCast() {
		return cast;
	}

	public int getRating() {
		return rating;
	}

	public long getGrossEarning() {
		return grossEarning;
	}

	public void setGrossEarning(long grossEarning) {
		this.grossEarning = grossEarning;
	}

}
