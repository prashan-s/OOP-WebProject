package com.bs.interfaces;
import java.util.List;
import com.bs.model.Movie;

public interface IMovieDAO {

	List<Movie>selectMovie(int movie_id);
	public void insertMovie(Movie movie);
	public boolean updateMovie(Movie movie);
	ublic boolean deleteMovie(int movie_id);
}