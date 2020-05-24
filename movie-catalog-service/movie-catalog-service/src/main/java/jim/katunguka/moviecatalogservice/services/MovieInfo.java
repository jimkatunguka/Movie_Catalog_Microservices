package jim.katunguka.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import jim.katunguka.moviecatalogservice.models.CatalogItem;
import jim.katunguka.moviecatalogservice.models.Movie;
import jim.katunguka.moviecatalogservice.models.Rating;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		// for each movie id, call info-service and get details
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		// put them all together
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}

	private CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("movie name not found", "", rating.getRating());
	}

}
