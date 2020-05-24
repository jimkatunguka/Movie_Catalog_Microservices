package jim.katunguka.movieinfoservice.models;

public class MovieSummary {
	private int id;
	private String title;
	private String overview;
	private String imdb_id;

	public MovieSummary() {

	}

	public MovieSummary(int id, String title, String overview, String imdb_id) {
		super();
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.imdb_id = imdb_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

}
