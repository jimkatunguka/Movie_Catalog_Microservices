package jim.katunguka.ratingsdataservice.models;

import java.util.List;

public class UserRating {
	private List<Rating> useRating;

	public List<Rating> getUserRating() {
		return useRating;
	}

	public void setUserRating(List<Rating> useRating) {
		this.useRating = useRating;
	}

}
