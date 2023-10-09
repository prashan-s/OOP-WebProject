
import com.bs.interfaces.IMovieDAO;
import com.bs.model.Movie;
import com.bs.utility.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDAO implements IMovieDAO {
	
    private static final String SELECT_MOVIE_BY_ID = "SELECT title, description, year, duration, quality, "
    												+ "watch_count, movie_img_url, movie_stream_url, action_category, "
    												+ "adventure_category, comedy_category, scify_category, horror_category, "
    												+ "romance_category, science_category, crime_category, thriller_category, "
    												+ "is_active, created_admin_name, row_created_datetime FROM movie;\r\n"
    												+ "where id =?";
    
    private static final String INSERT_MOVIE = "INSERT INTO movie (title, description, year, duration,quality, watch_count, "
    															+ "movie_img_url, movie_stream_url, action_category, adventure_category, "
    															+ "comedy_category, scify_category, horror_category, romance_category, "
    															+ "science_category, crime_category, thriller_category, created_admin_name)"
    										 + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
    private static final String UPDATE_MOVIE ="UPDATE movie set title=?, description=?, year=?, duration=?, quality=?, watch_count=?, "
    														+ "movie_img_url=?, movie_stream_url=?, action_category=?, adventure_category=?, "
    														+ "comedy_category=?, scify_category=?, horror_category=?, romance_category=?, "
    														+ "science_category=?, crime_category=?, thriller_category=?, created_admin_name=?;";
    	 
    private static final String DELETE_MOVIE ="UPDATE movie set is_active=0 WHERE movie_id = ?;";
    
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	
	
	//select movieDetails
	public  List<Movie> selectMovie(int movie_id){
		
		ArrayList<Movie> movies = new ArrayList<>();
	
		try {
			con = DBConnection.getConnection();	
			stmt = con.prepareStatement(null);
			String sql = "select * from movie where movie_id='"+movie_id+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int retuernedMovie_id = rs.getInt("movie_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int year = rs.getInt("year");
				int duration = rs.getInt("duration");
				String quality = rs.getString("quality");
				int watch_count = rs.getInt("watch_count");
				String movie_img_url = rs.getString("movie_img_url");
				String movie_stream_url = rs.getString("movie_stream_url");
				boolean action_category= rs.getBoolean("action_category");
				boolean adventure_category = rs.getBoolean("watch_count");
				boolean comedy_category = rs.getBoolean("comedy_category");
				boolean scify_category = rs.getBoolean("scify_category");
				boolean horror_category = rs.getBoolean("horror_category");
				boolean romance_category = rs.getBoolean("romance_category");
				boolean science_category = rs.getBoolean("science_category");
				boolean crime_category = rs.getBoolean("crime_category");
				boolean thriller_category = rs.getBoolean("thriller_category");
				boolean is_active = rs.getBoolean("is_active");
				String created_admin_name = rs.getString("created_admin_name");
				Date row_created_datetime = rs.getDate("row_created_datetime");
				
				Movie movie = new Movie(retuernedMovie_id, title, description, year, duration, quality,
						watch_count, movie_img_url, movie_stream_url, action_category,
						adventure_category, comedy_category, scify_category, horror_category,
						romance_category, science_category, crime_category, thriller_category,
						is_active, created_admin_name, row_created_datetime);
				
				movies.add(movie);	
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return movies;
		
	}
	
	//inserting a new movie
	public void insertMovie(Movie movie) {
		System.out.println(INSERT_MOVIE);
		
		try {
			con = DBConnection.getConnection();	
			PreparedStatement stmt = con.prepareStatement(INSERT_MOVIE);	
			
			stmt.setString(1, movie.getTitle());
			stmt.setString(2,movie.getDescription());
			stmt.setInt(3, movie.getYear());
			stmt.setInt(4,movie.getDuration());
			stmt.setString(5, movie.getQuality());
			stmt.setInt(6,movie.getWatch_count());
			stmt.setString(7, movie.getMovie_img_url());
			stmt.setString(8, movie.getMovie_stream_url());
			stmt.setBoolean(9, movie.isAction_category());
			stmt.setBoolean(10, movie.isAdventure_category());
			stmt.setBoolean(11, movie.isComedy_category());
			stmt.setBoolean(12, movie.isScify_category());
			stmt.setBoolean(13, movie.isHorror_category());
			stmt.setBoolean(14, movie.isRomance_category());
			stmt.setBoolean(15, movie.isScience_category());
			stmt.setBoolean(16, movie.isCrime_category());
			stmt.setBoolean(17, movie.isThriller_category());
			stmt.setString(18, movie.getCreated_admin_name());
			
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//update movie
	public boolean updateMovie(Movie movie) {
		
		boolean rowUpdate;
		try {
			con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_MOVIE);
			
			stmt.setString(1, movie.getTitle());
			stmt.setString(2,movie.getDescription());
			stmt.setInt(3, movie.getYear());
			stmt.setInt(4,movie.getDuration());
			stmt.setString(5, movie.getQuality());
			stmt.setInt(6,movie.getWatch_count());
			stmt.setString(7, movie.getMovie_img_url());
			stmt.setString(8, movie.getMovie_stream_url());
			stmt.setBoolean(9, movie.isAction_category());
			stmt.setBoolean(10, movie.isAdventure_category());
			stmt.setBoolean(11, movie.isComedy_category());
			stmt.setBoolean(12, movie.isScify_category());
			stmt.setBoolean(13, movie.isHorror_category());
			stmt.setBoolean(14, movie.isRomance_category());
			stmt.setBoolean(15, movie.isScience_category());
			stmt.setBoolean(16, movie.isCrime_category());
			stmt.setBoolean(17, movie.isThriller_category());
			stmt.setString(18, movie.getCreated_admin_name());
			
			rowUpdate = stmt.executeUpdate() > 0;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowUpdate;
		
	}
	
	//delete movie
	public boolean deleteMovie(int movie_id) {
		
		boolean rawDelete;
		try {
			con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_MOVIE);
			
			stmt.setInt(1, movie_id);
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		
		}
	
//	
//	public void insertMovie(String title, String description, int year, int duration, String quality,
//			int watch_count, String movie_img_url, String movie_stream_url, boolean action_category,
//			boolean adventure_category, boolean comedy_category, boolean scify_category, boolean horror_category,
//			boolean romance_category, boolean science_category, boolean crime_category, boolean thriller_category,
//			String created_admin_name) {
//	
//	//boolean isSuccess = false;
//	
//	try {
//	con = DBConnection.getConnection();	
//	stmt = con.createStatement();
//	
//	String sql = "INSERT INTO movie (title, description, year, duration, quality, watch_count, movie_img_url, movie_stream_url, action_category, adventure_category, comedy_category, scify_category, horror_category, romance_category, science_category, crime_category, thriller_category, created_admin_name)"
//	     + "VALUES('"+title+"', '"+description+"','"+year+"', '"+duration+"', '"+quality+"','"+watch_count+"','"+ movie_img_url+"','"+movie_stream_url+"','"+action_category+"','"+adventure_category+"','"+comedy_category+"','"+scify_category+"','"+horror_category+"','"+romance_category+"','"+science_category+"','"+crime_category+"','"+thriller_category+"','"+created_admin_name +"')";
//	
//	rs = stmt.executeQuery(sql);
//		
//	}catch(Exception e) {
//	e.printStackTrace();
//}


}
	
	


 	
	
