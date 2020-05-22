package jim.katunguka.moviecatalogservice.models;

import java.util.List;

public class UserRating {

	public UserRating(List<Rating> useRating) {
		super();
		this.useRating = useRating;
	}

	public UserRating() {
		super();
	}

	private List<Rating> useRating;

	public List<Rating> getUserRating() {
		return useRating;
	}

	public void setUserRating(List<Rating> useRating) {
		this.useRating = useRating;
	}

}
