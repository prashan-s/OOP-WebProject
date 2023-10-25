package com.bs.interfaces;
import java.util.List;
import com.bs.model.Movie;

public interface IMovieDAO {

	List<Movie>selectMovie(int movie_id);
	public boolean insertMovie(Movie movie);
	public boolean updateMovie(Movie movie);
	public boolean deleteMovie(int movie_id);
}