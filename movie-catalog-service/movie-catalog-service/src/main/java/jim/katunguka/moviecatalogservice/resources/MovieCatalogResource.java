package jim.katunguka.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import jim.katunguka.moviecatalogservice.models.CatalogItem;
import jim.katunguka.moviecatalogservice.models.UserRating;
import jim.katunguka.moviecatalogservice.services.MovieInfo;
import jim.katunguka.moviecatalogservice.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	MovieInfo movieInfo;

	@Autowired
	UserRatingInfo userRatingInfo;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
//	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating = userRatingInfo.getUserRating(userId);
		return userRating.getUserRating().stream().map(rating -> movieInfo.getCatalogItem(rating))
				.collect(Collectors.toList());
	}

//	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
//	private UserRating getUserRating(@PathVariable("userId") String userId) {
//		return restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);
//	}
//
//	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
//	private CatalogItem getCatalogItem(Rating rating) {
//		// for each movie id, call info-service and get details
//		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//		// put them all together
//		return new CatalogItem(movie.getName(), "desc", rating.getRating());
//	}

//	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
//		return Arrays.asList(new CatalogItem("No Movie", "We currently are sorting the movies!", 0));
//	}

//	private UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
//		UserRating userRating = new UserRating();
//		userRating.setUserId(userId);
//		userRating.setUserRating(Arrays.asList(new Rating("0", 0)));
//		return userRating;
//
//	}
//
//	private CatalogItem getFallbackCatalogItem(Rating rating) {
//		return new CatalogItem("movie name not found", "", rating.getRating());
//	}

//		Movie movie = webClientBuilder.build().get().uri("http://localhost:8081/movies/" + rating.getMovieId())
//			.retrieve().bodyToMono(Movie.class) // gets you an asynchronous object in the future
//			.block();

}
