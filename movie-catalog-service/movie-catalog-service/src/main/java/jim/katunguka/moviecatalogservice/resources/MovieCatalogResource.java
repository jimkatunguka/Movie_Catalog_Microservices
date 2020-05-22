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
import jim.katunguka.moviecatalogservice.models.Movie;
import jim.katunguka.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId,
				UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {
			// for each movie id, call info-service and get details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
					Movie.class);
			// put them all together
			return new CatalogItem(movie.getName(), "desc", rating.getRating());
		}).collect(Collectors.toList());
	}

//		Movie movie = webClientBuilder.build().get().uri("http://localhost:8081/movies/" + rating.getMovieId())
//			.retrieve().bodyToMono(Movie.class) // gets you an asynchronous object in the future
//			.block();

}
