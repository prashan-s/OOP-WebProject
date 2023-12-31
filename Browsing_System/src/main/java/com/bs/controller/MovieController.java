package com.bs.controller;

import java.util.List;
import com.bs.dao.MovieDAO;

import com.bs.model.Movie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MovieController {

	RequestDispatcher dispatcher;
	HttpServletRequest request;
	HttpServletResponse response;
	MovieDAO dao;

	public MovieController() {

	}

	public MovieController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dispatcher = request.getRequestDispatcher("./pages/movies.jsp");
		this.dao = new MovieDAO();

	}

	public void doAction(String action) {
		String jspPage = "./pages/movie-details.jsp";
		Integer movieId = -1;
		boolean showMovieIdForm = true;
		boolean showDetails = false;
		boolean showEditForm = false;
		boolean showUpdateStatus = false;
		boolean showAddForm = false;
		boolean showInsertStatus = false;
		boolean showDeleteStatus = false;
		String message;
		System.out.println("Movie Controller Action" + action);
		switch (action) {

			case "submit":
				jspPage = "./pages/movie-details.jsp";
				showMovieIdForm = false;
				showDetails = true;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

				movieId = Integer.parseInt(this.request.getParameter("movieId"));
				this.selectMovie(movieId);

				Cookie cookie = new Cookie("movieId", Integer.toString(movieId));
				this.response.addCookie(cookie);
				break;
			case "submit-getMovies-dashboard":
				jspPage = "./index.jsp";
				showMovieIdForm = false;
				showDetails = true;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

				this.setAllMovies();
				break;
			case "submit-getMovies":
				jspPage = "./pages/movies.jsp";
				showMovieIdForm = false;
				showDetails = true;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = false;
				showDeleteStatus = false;

				this.setAllMovies();
//
//				Cookie cookie = new Cookie("movieId", Integer.toString(movieId));
//				this.response.addCookie(cookie);
				break;

			case "Delete":

				jspPage = "./pages/admin-portal.jsp";
				showMovieIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = true;
				showDeleteStatus = false;

				movieId = Integer.parseInt(request.getParameter("movieId"));

				System.out.println("Movie ID" + movieId);
				if (movieId == null){
					movieId = 1;
				}

				System.out.println("Movie ID" + movieId);
				boolean deleteStatus = deleteMovieByAdmin(movieId);

				if (deleteStatus) {
					message = "Deleted Successfully!";
				} else {
					message = "Delete Failed!";
				}

				request.setAttribute("xmessage", message);
				break;

			case "xAdd":

				jspPage = "./pages/admin-portal.jsp";
				showMovieIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = true;
				showInsertStatus = false;
				showDeleteStatus = false;

				movieId = getValueForId("movieId");

				this.selectMovie(movieId);

				break;

			case "Add":
				
				jspPage = "./pages/admin-portal.jsp";
				showMovieIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = true;
				showDeleteStatus = false;


				Movie m1 = new Movie();

				m1.setTitle(request.getParameter("title"));
				m1.setDescription(request.getParameter("description"));
				m1.setYear(Integer.parseInt(request.getParameter("year")));
				m1.setDuration(Integer.parseInt(request.getParameter("duration")));
				m1.setQuality(request.getParameter("quality"));
				m1.setWatch_count(0);
				m1.setMovie_stream_url(request.getParameter("movie_stream_url"));

				m1.setMovie_img_url("");
				m1.setAction_category(true);
				m1.setAdventure_category(false);
				m1.setComedy_category(false);
				m1.setScify_category(false);
				m1.setHorror_category(false);
				m1.setRomance_category(false);
				m1.setScience_category(false);
				m1.setCrime_category(false);
				m1.setThriller_category(false);

				try {
//					m1.setAction_category(Boolean.parseBoolean(request.getParameter("action_category")));
//					m1.setAdventure_category(Boolean.parseBoolean(request.getParameter("adventure_category")));
//					m1.setComedy_category(Boolean.parseBoolean(request.getParameter("comedy_category")));
//					m1.setScify_category(Boolean.parseBoolean(request.getParameter("scify_category")));
//					m1.setHorror_category(Boolean.parseBoolean(request.getParameter("horror_category")));
//					m1.setRomance_category(Boolean.parseBoolean(request.getParameter("romance_category")));
//					m1.setScience_category(Boolean.parseBoolean(request.getParameter("science_category")));
//					m1.setCrime_category(Boolean.parseBoolean(request.getParameter("crime_category")));
//					m1.setThriller_category(Boolean.parseBoolean(request.getParameter("thriller_category")));
				}catch (Exception ex){

				}
				m1.setCreated_admin_name(request.getParameter("created_admin_name"));

				boolean insertStatus = insertMovieByAdmin(m1);

				System.out.println(insertStatus);
				message = "Inserted Successfully!";
				System.out.println(message);

				if (insertStatus == false) {
					message = "Insert Failed!, Retry....";
					System.out.println("Edit Form Show:" + showAddForm);
				}

				request.setAttribute("xmessage", message);
				System.out.println("Inserted   " + insertStatus);

				break;

			case "Update":

				jspPage = "./pages/admin-portal.jsp";
				showMovieIdForm = false;
				showDetails = false;
				showEditForm = false;
				showUpdateStatus = false;
				showAddForm = false;
				showInsertStatus = true;
				showDeleteStatus = false;

				movieId = Integer.parseInt(request.getParameter("movieId"));

				if (movieId == null){
					movieId = 1;
				}
				Movie m1x = new Movie();
				m1x.setMovie_id(movieId);
				m1x.setTitle(request.getParameter("title"));
				m1x.setDescription(request.getParameter("description"));
				m1x.setYear(Integer.parseInt(request.getParameter("year")));
				m1x.setDuration(Integer.parseInt(request.getParameter("duration")));
				m1x.setQuality(request.getParameter("quality"));
				m1x.setWatch_count(0);
				m1x.setMovie_stream_url(request.getParameter("movie_stream_url"));

				m1x.setMovie_img_url("Test Image");
				m1x.setAdventure_category(false);
				m1x.setComedy_category(false);
				m1x.setScify_category(false);
				m1x.setHorror_category(false);
				m1x.setRomance_category(false);
				m1x.setScience_category(false);
				m1x.setCrime_category(false);
				m1x.setThriller_category(false);

				try {
//					m1.setAction_category(Boolean.parseBoolean(request.getParameter("action_category")));
//					m1.setAdventure_category(Boolean.parseBoolean(request.getParameter("adventure_category")));
//					m1.setComedy_category(Boolean.parseBoolean(request.getParameter("comedy_category")));
//					m1.setScify_category(Boolean.parseBoolean(request.getParameter("scify_category")));
//					m1.setHorror_category(Boolean.parseBoolean(request.getParameter("horror_category")));
//					m1.setRomance_category(Boolean.parseBoolean(request.getParameter("romance_category")));
//					m1.setScience_category(Boolean.parseBoolean(request.getParameter("science_category")));
//					m1.setCrime_category(Boolean.parseBoolean(request.getParameter("crime_category")));
//					m1.setThriller_category(Boolean.parseBoolean(request.getParameter("thriller_category")));
				}catch (Exception ex){

				}
				m1x.setCreated_admin_name(request.getParameter("created_admin_name"));

				boolean insertStatusx = updateMovieByAdmin(m1x);

				System.out.println(insertStatusx);
				message = "Inserted Successfully!";
				System.out.println(message);

				if (insertStatusx == false) {
					message = "Insert Failed!, Retry....";
					System.out.println("Edit Form Show:" + showAddForm);
				}

				request.setAttribute("xmessage", message);
				System.out.println("Updated   " + insertStatusx);


		}

		System.out.println("Watiting to Dispatch: " + jspPage);
		try {

			System.out.println("showUpdateStatus " + showUpdateStatus);

			request.setAttribute("showMovieIdForm", showMovieIdForm);
			request.setAttribute("showDetails", showDetails);
			request.setAttribute("showEditForm", showEditForm);
			request.setAttribute("showUpdateStatus", showUpdateStatus);
			request.setAttribute("showAddForm", showAddForm);
			request.setAttribute("showInsertStatus", showInsertStatus);
			request.setAttribute("showDeleteStatus", showDeleteStatus);

			this.dispatcher = request.getRequestDispatcher(jspPage);
			dispatcher.forward(request, response);

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	private int getValueForId(String key) {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		int movieId = -1;
		if (cookies != null) {

			for (Cookie ck : cookies) {
				if (ck.getName().equals(key)) {
					movieId = Integer.parseInt(ck.getValue());
					System.out.println("Cookie movirId:" + movieId);

					break;
				}
			}
		} else {
			System.out.println("No cookies found!");
		}

		if (movieId < 0) {
			try {
				movieId = Integer.parseInt(this.request.getParameter("movieId"));
			} catch (Exception ex) {
				System.out.println("Error with movie ID");
			}
		}
		return movieId;
	}

	public void selectMovie(int movieId) {

		try {
			List<Movie> movies = new MovieDAO().selectMovie(movieId);
			System.out.println("movies : " + movies.getFirst().getTitle());
			request.setAttribute("movies", movies);// attribute name, objectName
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectAllMovies() {

		try {
			List<Movie> movies = new MovieDAO().selectAllMovies();
			request.setAttribute("movieData", movies);// attribute name, objectName
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.dispatcher = request.getRequestDispatcher("./pages/admin-portal.jsp");
			this.dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAllMovies() {

		try {
			List<Movie> movies = new MovieDAO().selectAllMovies();
			System.out.println("movies : " + movies.getFirst().getTitle());
			request.setAttribute("movieData", movies);// attribute name, objectName
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateMovieByAdmin(Movie movie) {
		boolean updateStatus = true;
		try {
			updateStatus = dao.updateMovie(movie);
			request.setAttribute("isSuccessUpdate", updateStatus);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return updateStatus;

	}

	public boolean insertMovieByAdmin(Movie movie) {
		boolean insertStatus = false;
		try {
			insertStatus = dao.insertMovie(movie);
			request.setAttribute("isSuccessInsert", insertStatus);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return insertStatus;
	}

	public boolean deleteMovieByAdmin(int movieId) {
		boolean deleteStatus = false;
		try {

			deleteStatus = dao.deleteMovie(movieId);
			request.setAttribute("isSuccessDelete", deleteStatus);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return deleteStatus;
	}

}
