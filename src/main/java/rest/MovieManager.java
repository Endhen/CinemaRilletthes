package rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import bll.BLL;
import bo.services.Genre;
import bo.services.LanguageVersion;
import bo.services.Movie;


@Path("/movie")
public class MovieManager {
	private BLL<Movie> BLL;

	public MovieManager() {
		this.BLL = new BLL<> (Movie.class);
	}
	
	@GET 
	public List<Movie> getMovies() {
		
		List<Genre>  genres = Arrays.asList(
				new Genre("Drame"), 
				new Genre("Action"));
		
		Movie movie = new Movie(
				"Super Film", 
				"Image cover", 
				2.4f, 
				genres, 
				"Synopsis lorem ipsum", 
				120, 
				false, 
				new LanguageVersion("VOSTFR"));
		
		BLL.insert(movie);
		
		return BLL.findAll();
	}
	
	@GET @Path("/{id : \\d+}")
	public Movie getMovie(@PathParam("id") int id) {
		return BLL.findById(id);
	}
	
//	@POST
//	public Movie addMovie(
//			@FormParam("title") String title,
//			@FormParam("content") String content,
//			@FormParam("color") String color) {
//		
//		Movie note = new Movie(title, content, color, LocalDate.now(), LocalDate.now());
//		BLL.insert(note);
//		
//		return note;
//	}
	
//	@PUT @Path("/{id : \\d+}")
//	public void updateMovie(
//			@PathParam("id") int id,
//			@FormParam("title") String title,
//			@FormParam("content") String content,
//			@FormParam("color") String color) {
//		
//		Note movie = BLL.findById(id);
//		note
//			.setTitle(title)
//			.setContent(content)
//			.setColor(color)
//			.setLastUpdate(LocalDate.now());
//		
//		BLL.update(note);
//	}
	
	@DELETE @Path("/{id : \\d+}")
	public Movie deleteMovie(@PathParam("id") int id) {
		Movie movie = BLL.findById(id);
		
		BLL.delete(movie);
		return movie;
	}
}

