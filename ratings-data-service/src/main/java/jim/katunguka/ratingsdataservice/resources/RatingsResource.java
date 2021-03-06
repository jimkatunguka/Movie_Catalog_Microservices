package jim.katunguka.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jim.katunguka.ratingsdataservice.models.Rating;
import jim.katunguka.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@RequestMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		// List<Rating> ratings = Arrays.asList(new Rating("550", 4), new Rating("500",
		// 3));
		UserRating userRating = new UserRating();
		// userRating.setUserRating(ratings);
		userRating.initData(userId);
		return userRating;

	}

}
