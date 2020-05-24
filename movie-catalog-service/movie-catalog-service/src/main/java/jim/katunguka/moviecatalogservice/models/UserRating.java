package jim.katunguka.moviecatalogservice.models;

import java.util.Arrays;
import java.util.List;

public class UserRating {
	private List<Rating> useRating;
	private String userId;

	public UserRating(List<Rating> useRating) {
		super();
		this.useRating = useRating;
	}

	public UserRating() {
		super();
	}

	public List<Rating> getUserRating() {
		return useRating;
	}

	public void setUserRating(List<Rating> useRating) {
		this.useRating = useRating;
	}

	public void initData(String userId) {
		this.setUserId(userId);
		this.setUserRating(Arrays.asList(new Rating("500", 3), new Rating("550", 4)));

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
