package jim.katunguka.ratingsdataservice.models;

import java.util.Arrays;
import java.util.List;

public class UserRating {
	private List<Rating> userRating;
	private String userId;

	public UserRating(List<Rating> useRating) {
		super();
		this.userRating = useRating;
	}

	public UserRating() {
		super();
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> useRating) {
		this.userRating = useRating;
	}

	public void initData(String userId) {
		this.userId = userId;
		this.setUserRating(Arrays.asList(new Rating("500", 3), new Rating("550", 4)));

	}
}
