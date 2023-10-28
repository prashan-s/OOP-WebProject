<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Free Guy 2021</title>

  <!-- 
    - favicon
  -->
  <link rel="shortcut icon" href="/favicon.svg" type="image/svg+xml" />

  <!-- 
    - custom css link
  -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-portal.css" />

  <!-- 
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/packages/materialize/css/materialize.css" />

  <!-- Materialize Compiled and minified JavaScript -->
  <script src="${pageContext.request.contextPath}/assets/packages/materialize/js/materialize.min.js"></script>
</head>

<body id="#top">
  <!-- 
    - #HEADER
-->

  <header class="header" data-header>
    <div class="container">
      <div class="overlay" data-overlay></div>

      <ul class="admin-drawer-btn">
        <i class="fa-solid fa-bars" id="hamburger" onclick="toggleNavigation()"></i>
      </ul>

      <a href="../index.jsp" class="logo">
        <img src="../assets/images/logo.svg" alt="Filmlane logo" />
      </a>

      <div class="header-actions">
        <button class="search-btn">
          <ion-icon name="search-outline"></ion-icon>
        </button>

        <div class="lang-wrapper">
          <label for="language">
            <ion-icon name="globe-outline"></ion-icon>
          </label>

          <select name="language" id="language">
            <option value="en">EN</option>
            <option value="au">AU</option>
            <option value="ar">AR</option>
            <option value="tu">TU</option>
          </select>
        </div>

        <button class="btn btn-primary" id="btnSignIn"
          onclick="toggleSignInSignUpCardForm('sign-up-form', 'sign-in-form', 'toggle')">
          Sign in
        </button>
      </div>

      <button class="menu-open-btn" data-menu-open-btn>
        <ion-icon name="reorder-two"></ion-icon>
      </button>

      <nav class="navbar" data-navbar>
        <div class="navbar-top">
          <a href="../index.jsp" class="logo">
            <img src="../assets/images/logo.svg" alt="Filmlane logo" />
          </a>

          <button class="menu-close-btn" data-menu-close-btn>
            <ion-icon name="close-outline"></ion-icon>
          </button>
        </div>

        <ul class="navbar-list">
          <li>
            <a href="../index.jsp" class="navbar-link">Home</a>
          </li>

          <li>
            <a href="./movies.html" class="navbar-link">Movies</a>
          </li>

          <li>
            <a href="./tv-series.html" class="navbar-link">Tv Series</a>
          </li>

          <li>
            <a href="./favourites.html" class="navbar-link">Favourites</a>
          </li>

          <li>
            <a href="./about.html" class="navbar-link">About</a>
          </li>
        </ul>

        <ul class="navbar-social-list">
          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-twitter"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-facebook"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-pinterest"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-instagram"></ion-icon>
            </a>
          </li>

          <li>
            <a href="#" class="navbar-social-link">
              <ion-icon name="logo-youtube"></ion-icon>
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </header>

  <!-- Navigation Bar CLosed -->

  <div class="admin-navigation-bar closed" id="adminNavigationBar">
    <div class="admin-header-section">
      <div class="admin-navigation-icons">
        <div class="admin-logo">
          <i class="fa-solid fa-circle-user"></i>
        </div>
        <!-- Toggle Navigation -->
        <div class="toggle-icon" onclick="toggleNavigation()">
          <i class="fa-solid fa-bars" id="hamburger" style="display: none"></i>
          <i class="fa-solid fa-xmark" id="close"></i>
        </div>
      </div>
      <div class="admin-info-heading">
        <!-- <br/></br> -->
        <h5>System Administrator</h5>
      </div>
    </div>
    <div class="admin-user-access-section">
      <h5>Navigation</h5>
      <li class="main-list">
        <div class="main-list-heading">
          <h6>Manage Users</h6>
          <i class="fa-solid fa-angle-down"></i>
        </div>
        <ul class="sub-list">
          <!-- Manage Staff option -->
          <li onclick="showStaffGrid(this.id)" id="manageStaffs" class="adming-heading selected">
            Manage Staff
          </li>
          <!-- Manage Customers option -->
          <li onclick="showCustomerGrid(this.id)" id="manageCustomers" class="adming-heading">
            Manage Customers
          </li>
        </ul>
      </li>
      <li class="main-list">
        <div class="main-list-heading">
          <h6>Manage Content</h6>
          <i class="fa-solid fa-angle-down"></i>
        </div>
        <ul class="sub-list">
          <!-- Manage Movies option -->
          <li onclick="showMovieGrid(this.id)" id="manageMovies" class="adming-heading">
            Manage Movies
          </li>
          <!-- Manage TvSeriess option -->
          <li onclick="showTvSeriesGrid(this.id)" id="manageTvSeriess" class="adming-heading">
            Manage Tv Series
          </li>
          <li onclick="showTvSeriesEpisodesGrid(this.id)" id="manageTvSeriesEpisodess" class="adming-heading">
            Manage Tv Series Episodes
          </li>
          <li onclick="showSubscriptionPlanGrid(this.id)" id="manageSubscriptionPlanss" class="adming-heading">
            Manage Subscription Plans
          </li>
        </ul>
      </li>
    </div>
  </div>

  <!-- Manage Staff -->

  <main>

    <div class="manage-staff-container-section container-section" id="manageStaff">
      <div class="manage-staff-heading">
        <div class="manage-staff-title">
          <h4>Add / Edit / Delete Staff Members</h4>
        </div>
        <div class="add-member-btn">
          <input type="button" value="Add a Member" onclick="showAddMemberForm()" />
        </div>
      </div>
      <div class="manage-staff-grid">
        <!-- Add a Staff Member -->
        <div class="add-new-staff-member add-form" id="addMemberForm">
          <div class="card">
            <div class="card-heading">
              <p>Add a Staff Member</p>
            </div>
            <form action="../php/admin_portal_staff_member_add_process.php" method="post">
              <label for="txtMemberFirstname">First Name</label> <br />
              <input type="text" name="firstname" id="txtMemberFirstname" required />
              <br />
              <label for="txtMemberLastname">Last Name</label> <br />
              <input type="text" name="lastname" id="txtMemberLastname" required />
              <br />
              <label for="txtMemberEmail">Email</label> <br />
              <input type="text" name="email" id="txtMemberEmail" required />
              <br />
              <label for="txtMemberRole">Role</label> <br />
              <select name="role" id="txtMemberRole" required>
                <option value="" selected>-- Select a Role --</option>
              </select>
              <br />
              <label for="txtMemberGender">Gender</label> <br />
              <select name="gender" id="txtMemberGender" required>
                <option value="" selected>-- Select a Gender --</option>
                <option value="M">Male</option>
                <br />
                <option value="F">Female</option>
                <br />
                <option value="O">Other</option>
                <br />
              </select>
              <label for="txtMemberUsername">User Name</label> <br />
              <input type="text" name="username" id="txtMemberUsername" required />
              <br />
              <label for="txtMemberPassword">Password</label> <br />
              <input type="password" name="password" id="txtMemberPassword" required />
              <br />
              <label for="txtMemberMobileNo">Mobile Number</label> <br />
              <input type="text" name="mobileno" id="txtMemberMobileNo" required />
              <br />
              <input type="submit" class="submit-btn" value="Add" />
            </form>
          </div>
        </div>
        <!-- Update a Staff Member -->
        <div class="update-staff-member update-form" id="updateMemberForm">
          <div class="card">
            <div class="card-heading">
              <p>Update Staff Member</p>
            </div>
            <form action="../php/admin_portal_staff_member_update_process.php" method="post">
              <label for="txtMemberUpdateFirstname">First Name</label> <br />
              <input type="text" name="firstname" id="txtMemberUpdateFirstname" required />
              <br />
              <label for="txtMemberUpdateLastname">Last Name</label> <br />
              <input type="text" name="lastname" id="txtMemberUpdateLastname" required />
              <br />
              <label for="txtMemberUpdateEmail">Email</label> <br />
              <input type="text" name="email" id="txtMemberUpdateEmail" required />
              <br />
              <label for="txtMemberUpdateRole">Role</label> <br />
              <select name="role" id="txtMemberUpdateRole" required>
                <option value="" selected>-- Select a Role --</option>
              </select>
              <br />
              <label for="txtMemberUpdateGender">Gender</label> <br />
              <select name="gender" id="txtMemberUpdateGender" required>
                <option value="" selected>-- Select a Gender --</option>
                <option value="M">Male</option>
                <br />
                <option value="F">Female</option>
                <br />
                <option value="O">Other</option>
                <br />
              </select>
              <label for="txtMemberUpdateUsername">User Name</label> <br />
              <input type="text" name="username" id="txtMemberUpdateUsername" required />
              <br />
              <label for="txtMemberUpdatePassword">Password</label> <br />
              <input type="password" name="password" id="txtMemberUpdatePassword" required />
              <br />
              <label for="txtMemberUpdateMobileNo">Mobile Number</label> <br />
              <input type="text" name="mobileno" id="txtMemberUpdateMobileNo" required />
              <br />
              <label for="txtMemberUpdateStatus">Active / InActive</label>
              <br />
              <select name="status" id="txtMemberUpdateStatus" required>
                <option value="" selected>-- Select a Role --</option>
                <option value="1">Active</option>
                <option value="0">InActive</option>
              </select>
              <input type="hidden" name="rowid" id="editMemberRowId" />
              <input type="submit" class="submit-btn" value="Update" />
            </form>
          </div>
        </div>
        <div class="table-card">
          <table class="striped">
            <thead>
              <tr>
                <th class="hide">ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile Number</th>
                <th>Date of birth</th>
                <th>Premium User</th>
                <th>Active / InActive</th>
                <th class="tbl-edit"></th>
                <th class="tbl-delete"></th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Manage Customer -->

    <div class="manage-customer-container-section container-section hide" id="managecustomer">
      <div class="manage-customer-heading">
        <div class="manage-customer-title">
          <h4>Add / Edit / Delete Customers</h4>
        </div>
        <div class="add-customer-btn">
          <input type="button" value="Add a Customer" onclick="showAddCustomerForm()" />
        </div>
      </div>
      <div class="manage-customer-grid">
        <div class="add-new-customer add-form" id="addCustomerForm">
          <div class="card">
            <div class="card-heading">
              <p>Add a Customer</p>
            </div>
            <form action="${pageContext.request.contextPath}/UserServlet" method="post">
              <label for="txtCustomerName">Name</label> <br />
              <input type="text" name="userName" id="txtCustomerName" required />
              <br />
              <label for="txtCustomerEmail">Email</label> <br />
              <input type="text" name="email" id="txtCustomerEmail" required />
              <br />
              <label for="txtCustomerMobileNumber">Mobile Number</label> <br />
              <input type="text" name="mobile" id="txtCustomerMobileNumber" required />
              <br />
              <label for="txtCustomerDob">Date of Birth</label> <br />
              <input type="date" name="dob" id="txtCustomerDob" required />
              <br />
              <input type="submit" name="action" class="submit-btn" value="Add" />
            </form>
          </div>
        </div>
        <div class="update-customer update-form" id="updateCustomerForm">
          <div class="card">
            <div class="card-heading">
              <p>Update Customer</p>
            </div>
            <form action="../php/admin_portal_customer_update_process.php" method="post">
              <label for="txtCustomerUpdateName">Name</label> <br />
              <input type="text" name="name" id="txtCustomerUpdateName" required />
              <br />
              <label for="txtCustomerUpdateEmail">Email</label> <br />
              <input type="text" name="email" id="txtCustomerUpdateEmail" required />
              <br />
              <label for="txtCustomerUpdateMobileNo">Mobile Number</label>
              <br />
              <input type="text" name="mobileno" id="txtCustomerUpdateMobileNo" required />
              <br />
              <label for="txtCustomerUpdateDateofBirth">Date of Birth</label>
              <br />
              <input type="text" name="dob" id="txtCustomerUpdateDateofBirth" required />
              <br />
              <label for="txtCustomerUpdatePremiumUser">Premium User</label>
              <br />
              <select name="premium" id="txtCustomerUpdatePremiumUser" required>
                <option value="1">Yes</option>
                <option value="0">No</option>
              </select>
              <br />
              <label for="txtCustomerUpdateStatus">Active / InActive</label>
              <br />
              <select name="status" id="txtCustomerUpdateStatus" required>
                <option value="1">Active</option>
                <option value="0">InActive</option>
              </select>
              <input type="hidden" name="rowid" id="editCustomerRowId" />
              <input type="submit" class="submit-btn" value="Update" />
            </form>
          </div>
        </div>
        <div class="table-card">
          <form id="userGetForm" action="${pageContext.request.contextPath}/UserServlet" method="GET">
	        	<input type="submit" id="getUserDataButton" style="display: none">
		      </form>
          <table class="striped">
            <thead>
              <tr>
                <th class="hide">ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile Number</th>
                <th>Date of birth</th>
                <th>Premium User</th>
                <th class="hide">Premium User Status</th>
                <th>Active / InActive</th>
                <th class="hide">Active / InActive Status</th>
                <th class="tbl-edit"></th>
                <th class="tbl-delete"></th>
              </tr>
            </thead>
            <tbody>
	            <c:forEach items="${users}" var="user">
		            <tr id="user_${user.userId}">
		              <td class="hide">${user.userId}</td>
	                  <td>${user.name}</td>
	                  <td>${user.email}</td>
	                  <td>${user.mobileNo}</td>
	                  <td>${user.dob}</td>
	                  <td>${user.isPremiumUser}</td>
	                  <td class="hide">${user.premiumUser}</td>
	                  <td>${user.isActiveStatus}</td>
	                  <td class="hide">${user.isActive}</td>
	                  <td class="tbl-edit"></td>
	                  <td class="tbl-delete"></td>
	                  <td>
	                  	<i class="fa-solid fa-pen-to-square update-icon" onclick="editUpdateCustomerRow('user_${user.userId}')"></i>
	                  </td>
                      <td>
	                      <form action="../php/admin_portal_customer_delete_process.php" method="post">
		                      <input type="hidden" name="user_id" value="${user.userId}">
		                      <i class="fa-solid fa-trash-can delete-icon" onclick="confirmDelete(event)"></i>';
		                      <input type="submit" style="display: none;">
	                      </form>
                      </td>
		          	</tr>
		        </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Manage Movie -->

    <div class="manage-Movie-container-section container-section hide" id="manageMovie">
      <div class="manage-Movie-heading">
        <div class="manage-Movie-title">
          <h4>Add / Edit / Delete Movies</h4>
        </div>
        <div class="add-Movie-btn">
          <input type="button" value="Add a Movie" onclick="showAddMovieForm()" />
        </div>
      </div>
      <div class="manage-Movie-grid">
        <div class="add-new-Movie add-form" id="addMovieForm">
          <div class="card">
            <div class="card-heading">
              <p>Add a Movie</p>
            </div>
            <form action="../php/admin_portal_Movie_add_process.php" method="post" enctype="multipart/form-data">
              <label for="lblMovieName">Title</label> <br />
              <input type="text" name="txtMovieName" id="txtMovieName" required />
              <br />
              <label for="lblMovieDescription">Description</label> <br />
              <input type="text" name="txtMovieDescription" id="txtMovieDescription" required />
              <br />
              <label for="lblMovieYear">Year</label> <br />
              <input type="text" name="txtMovieYear" id="txtMovieYear" required />
              <br />
              <label for="lblMovieDuration">Duration (Min)</label> <br />
              <input type="text" name="txtMovieDuration" id="txtMovieDuration" required />
              <br />
              <label for="lblMovieQuality">Quality</label>
              <br />
              <input type="text" name="txtMovieQuality" id="txtMovieQuality" required />
              <br />
              <label for="lblMovieImage">Image</label>
              <br />
              <input type="file" name="fileMovieimage" id="fileMovieImage" accept="image/*" required />
              <br />
              <label for="lblMovieUrl">Stream URL</label> <br />
              <input type="text" name="txtMovieUrl" id="txtMovieUrl" required />
              <br />
              <label for="lblMovieCategory">Category</label> <br />
              <input type="text" name="txtMovieCategory" id="txtMovieCategory" required />
              <br />
              <input type="submit" class="submit-btn" value="Add" />
            </form>
          </div>
        </div>
        <div class="update-Movie update-form" id="updateMovieForm">
          <div class="card">
            <div class="card-heading">
              <p>Update Movie</p>
            </div>
            <form action="../php/admin_portal_Movie_update_process.php" method="post">
              <label for="lblUpdateMovieName">Title</label> <br />
              <input type="text" name="txtUpdateMovieName" id="txtUpdateMovieName" required />
              <br />
              <label for="lblUpdateMovieDescription">Description</label>
              <br />
              <input type="text" name="txtUpdateMovieDescription" id="txtUpdateMovieDescription" required />
              <br />
              <label for="lblUpdateMovieYear">Year</label> <br />
              <input type="text" name="txtUpdateMovieYear" id="txtUpdateMovieYear" required />
              <br />
              <label for="lblUpdateMovieDuration">Duration (Mins)</label> <br />
              <input type="text" name="txtUpdateMovieDuration" id="txtUpdateMovieDuration" required />
              <br />
              <label for="lblUpdateMovieQuality">Quality</label>
              <br />
              <input type="text" name="txtUpdateMovieQuality" id="txtUpdateMovieQuality" required />
              <br />
              <label for="lblUpdateMovieImage">Image</label>
              <br />
              <input type="file" name="fileUpdateMovieimage" id="fileUpdateMovieimage" accept="image/*" required />
              <br />
              <label for="lblUpdateMovieUrl">Stream URL</label> <br />
              <input type="text" name="txtUpdateMovieUrl" id="txtUpdateMovieUrl" required />
              <br />
              <label for="lblUpdateMovieCategory">Category</label> <br />
              <input type="text" name="txtUpdateMovieCategory" id="txtUpdateMovieCategory" required />
              <br />
              <label for="lblUpdateMovieStatus">Active / InActive</label> <br />
              <select name="txtUpdateMovieStatus" id="txtUpdateMovieStatus" required>
                <option value=""></option>
                <option value="1">Active</option>
                <option value="0">InActive</option>
              </select>
              <input type="hidden" name="rowid" id="editMovieRowId" />
              <br />
              <input type="submit" class="submit-btn" value="Update" />
            </form>
          </div>
        </div>
        <div class="table-card">
	        <form id="movieGetForm" action="${pageContext.request.contextPath}/MovieServlet" method="GET">
	        	<input type="submit" id="getMovieDataButton" style="display: none">
		      </form>
          <table id="movieTable">
            <thead>
              <tr>
                <th class="hide">Movie ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Year</th>
                <th>Duration (Min)</th>
                <th>Quality</th>
                <th>Thumbnail</th>
                <th>Stream Url</th>
                <th>Category</th>
                <th class="hide">Status</th>
                <th>Active / InActive</th>
                <th class="tbl-edit"></th>
                <th class="tbl-delete"></th>
              </tr>
            </thead>
            <tbody>
	            <c:forEach items="${movieData}" var="movie">
		            <tr id="movie_${movie.movie_id}">
		              <td class="hide">${movie.movie_id}</td>
	                  <td>${movie.title}</td>
	                  <td>${movie.description}</td>
	                  <td>${movie.year}</td>
	                  <td>${movie.duration}</td>
	                  <td>${movie.quality}</td>
	                  <td>${movie.movie_img_url}</td>
	                  <td>${movie.movie_stream_url}</td>
	                  <td>${movie.action_category}</td>
	                  <td class="hide">${movie.is_active}</td>
	                  <td>${movie.is_active}</td>
	                  <td>
	                  	<i class="fa-solid fa-pen-to-square update-icon" onclick="editUpdateMovieRow('movie_${movie.movie_id}')"></i>
	                  </td>
                      <td>
	                      <form action="../php/admin_portal_customer_delete_process.php" method="post">
		                      <input type="hidden" name="movie_id" value="${movie.movie_id}">
		                      <i class="fa-solid fa-trash-can delete-icon" onclick="confirmDelete(event)"></i>';
		                      <input type="submit" style="display: none;">
	                      </form>
                      </td>
		          </tr>
			        </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Manage TvSeries -->

    <div class="manage-TvSeries-container-section container-section hide" id="manageTvSeries">
      <div class="manage-TvSeries-heading">
        <div class="manage-TvSeries-title">
          <h4>Add / Edit / Delete Tv Series</h4>
        </div>
        <div class="add-TvSeries-btn">
          <input type="button" value="Add a TvSeries" onclick="showAddTvSeriesForm()" />
        </div>
      </div>
      <div class="manage-TvSeries-grid">
        <div class="add-new-TvSeries add-form" id="addTvSeriesForm">
          <div class="card">
            <div class="card-heading">
              <p>Add a TvSeries</p>
            </div>
            <form action="../php/admin_portal_TvSeries_add_process.php" method="post" enctype="multipart/form-data">
              <label for="txtTvSeriesName">TvSeries Name</label> <br />
              <input type="text" name="TvSeriesname" id="txtTvSeriesName" required />
              <br />
              <label for="txtTvSeriesDescription">TvSeries Description</label> <br />
              <input type="text" name="TvSeriesdescription" id="txtTvSeriesDescription" required />
              <br />
              <label for="txtTvSeriesStartingDate">Starting Date</label> <br />
              <input type="date" name="startingdate" id="txtTvSeriesStartingDate" required />
              <br />
              <label for="txtTvSeriesEndingDate">Ending Date</label> <br />
              <input type="date" name="endingdate" id="txtTvSeriesEndingDate" required />
              <br />
              <label for="txtTvSeriesPercentage">TvSeries Percentage</label> <br />
              <input type="text" name="percentage" id="txtTvSeriesPercentage" required />
              <br />
              <label for="imgTvSeriesImage">TvSeries Image</label> <br />
              <input type="file" name="TvSeriesimage" id="imgTvSeriesImage" accept="image/*" required />
              <br />
              <input type="submit" class="submit-btn" value="Add" />
            </form>
          </div>
        </div>
        <div class="update-TvSeries update-form" id="updateTvSeriesForm">
          <div class="card">
            <div class="card-heading">
              <p>Update Tv Series</p>
            </div>
            <form action="../php/admin_portal_TvSeries_update_process.php" method="post">
              <label for="txtUpdateTvSeriesName">TvSeries Name</label> <br />
              <input type="text" name="TvSeriesname" id="txtUpdateTvSeriesName" required />
              <br />
              <label for="txtUpdateTvSeriesDescription">TvSeries Description</label>
              <br />
              <input type="text" name="TvSeriesdescription" id="txtUpdateTvSeriesDescription" required />
              <br />
              <label for="txtUpdateTvSeriesStartingDate">Starting Date</label>
              <br />
              <input type="date" name="startingdate" id="txtUpdateTvSeriesStartingDate" required />
              <br />
              <label for="txtUpdateTvSeriesEndingDate">Ending Date</label> <br />
              <input type="date" name="endingdate" id="txtUpdateTvSeriesEndingDate" required />
              <br />
              <label for="txtUpdateTvSeriesPercentage">TvSeries Percentage</label>
              <br />
              <input type="text" name="percentage" id="txtUpdateTvSeriesPercentage" required />
              <br />
              <label for="txtUpdateTvSeriesStatus">Active / InActive</label> <br />
              <select name="status" id="txtUpdateTvSeriesStatus" required>
                <option value=""></option>
                <option value="1">Active</option>
                <option value="0">InActive</option>
              </select>
              <input type="hidden" name="rowid" id="editTvSeriesRowId" />
              <input type="submit" class="submit-btn" value="Update" />
            </form>
          </div>
        </div>
        <div class="table-card">
          <form id="tvSeriesGetForm" action="${pageContext.request.contextPath}/TVSeriesServlet" method="GET">
          	<input type="submit" id="getTvSeriesDataButton" style="display: none">
	      </form>
          <table id="tvSeriesTable">
            <!-- <caption>Statement Summary</caption> -->
            <thead>
              <tr>
                <th class="hide">ID</th>
                <th>TvSeries Name</th>
                <th>TvSeries Iamge</th>
                <th>Active / InActive</th>
                <th class="tbl-edit"></th>
                <th class="tbl-delete"></th>
              </tr>
            </thead>
            <tbody>
	            <c:forEach items="${seriesList}" var="series">
		            <tr>
		              <td class="hide">${series.tvs_id}</td>
	                  <td>${series.title}</td>
	                  <td>${series.tvs_img_url}</td>
	                  <td>${series.active}</td>
	                  <td class="tbl-edit"></td>
	                  <td class="tbl-delete"></td>
			          </tr>
			        </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Manage TvSeries Episodes -->

    <div class="manage-TvSeriesEpisodes-container-section container-section hide" id="manageTvSeriesEpisodes">
      <div class="manage-TvSeriesEpisodes-heading">
        <div class="manage-TvSeriesEpisodes-title">
          <h4>Add / Edit / Delete Tv Series Episodes</h4>
        </div>
        <div class="add-TvSeriesEpisodes-btn">
          <input type="button" value="Add a Tv Series Episodes" onclick="showAddTvSeriesEpisodesForm()" />
        </div>
      </div>
      <div class="manage-TvSeriesEpisodes-grid">
        <div class="add-new-TvSeriesEpisodes add-form" id="addTvSeriesEpisodesForm">
          <div class="card">
            <div class="card-heading">
              <p>Add a TvSeriesEpisodes</p>
            </div>
            <form action="../php/admin_portal_TvSeriesEpisodes_add_process.php" method="post"
              enctype="multipart/form-data">
              <label for="txtTvSeriesEpisodesName">Tv Series Episodes Name</label> <br />
              <input type="text" name="TvSeriesEpisodesname" id="txtTvSeriesEpisodesName" required />
              <br />
              <label for="txtTvSeriesEpisodesDescription">Tv Series Episodes Description</label> <br />
              <input type="text" name="TvSeriesEpisodesdescription" id="txtTvSeriesEpisodesDescription" required />
              <br />
              <label for="txtTvSeriesEpisodesStartingDate">Starting Date</label> <br />
              <input type="date" name="startingdate" id="txtTvSeriesEpisodesStartingDate" required />
              <br />
              <label for="txtTvSeriesEpisodesEndingDate">Ending Date</label> <br />
              <input type="date" name="endingdate" id="txtTvSeriesEpisodesEndingDate" required />
              <br />
              <label for="txtTvSeriesEpisodesPercentage">TvSeriesEpisodes Percentage</label> <br />
              <input type="text" name="percentage" id="txtTvSeriesEpisodesPercentage" required />
              <br />
              <label for="imgTvSeriesEpisodesImage">TvSeriesEpisodes Image</label> <br />
              <input type="file" name="TvSeriesEpisodesimage" id="imgTvSeriesEpisodesImage" accept="image/*" required />
              <br />
              <input type="submit" class="submit-btn" value="Add" />
            </form>
          </div>
        </div>
        <div class="update-TvSeriesEpisodes update-form" id="updateTvSeriesEpisodesForm">
          <div class="card">
            <div class="card-heading">
              <p>Update Tv Series Episodes</p>
            </div>
            <form action="../php/admin_portal_TvSeriesEpisodes_update_process.php" method="post">
              <label for="txtUpdateTvSeriesEpisodesName">TvSeriesEpisodes Name</label> <br />
              <input type="text" name="TvSeriesEpisodesname" id="txtUpdateTvSeriesEpisodesName" required />
              <br />
              <label for="txtUpdateTvSeriesEpisodesDescription">TvSeriesEpisodes Description</label>
              <br />
              <input type="text" name="TvSeriesEpisodesdescription" id="txtUpdateTvSeriesEpisodesDescription"
                required />
              <br />
              <label for="txtUpdateTvSeriesEpisodesStartingDate">Starting Date</label>
              <br />
              <input type="date" name="startingdate" id="txtUpdateTvSeriesEpisodesStartingDate" required />
              <br />
              <label for="txtUpdateTvSeriesEpisodesEndingDate">Ending Date</label> <br />
              <input type="date" name="endingdate" id="txtUpdateTvSeriesEpisodesEndingDate" required />
              <br />
              <label for="txtUpdateTvSeriesEpisodesPercentage">TvSeriesEpisodes Percentage</label>
              <br />
              <input type="text" name="percentage" id="txtUpdateTvSeriesEpisodesPercentage" required />
              <br />
              <label for="txtUpdateTvSeriesEpisodesStatus">Active / InActive</label> <br />
              <select name="status" id="txtUpdateTvSeriesEpisodesStatus" required>
                <option value=""></option>
                <option value="1">Active</option>
                <option value="0">InActive</option>
              </select>
              <input type="hidden" name="rowid" id="editTvSeriesEpisodesRowId" />
              <input type="submit" class="submit-btn" value="Update" />
            </form>
          </div>
        </div>
        <div class="table-card">
          <form id="tvSeriesEpisodesGetForm" action="${pageContext.request.contextPath}/TVSeriesDetailsServlet" method="GET">
          	<input type="submit" id="getTvSeriesEpisodesDataButton" style="display: none">
	      </form>
          <table>
            <!-- <caption>Statement Summary</caption> -->
            <thead>
              <tr>
                <th class="hide">ID</th>
                <th>Tv Series TVS ID</th>
                <th>Tv Series Season</th>
                <th>Tv Series Episode</th>
                <th>Description</th>
                <th>Year</th>
                <th>Duration</th>
                <th>Quality</th>
                <th>Image Url</th>
                <th>Active / InActive</th>
                <th class="hide">Active / InActive Status</th>
                <th class="tbl-edit"></th>
                <th class="tbl-delete"></th>
              </tr>
            </thead>
            <tbody>
	            <c:forEach items="${allTVSeriesEpisodesList}" var="TvSeriesEpisode">
		            <tr>
		              <td class="hide">${TvSeriesEpisode.tvsDetailId}</td>
	                  <td>${TvSeriesEpisode.tvsId}</td>
	                  <td>${TvSeriesEpisode.season}</td>
	                  <td>${TvSeriesEpisode.episode}</td>
	                  <td>${TvSeriesEpisode.description}</td>
	                  <td>${TvSeriesEpisode.year}</td>
	                  <td>${TvSeriesEpisode.duration}</td>
	                  <td>${TvSeriesEpisode.quality}</td>
	                  <td>${TvSeriesEpisode.tvsStreamUrl}</td>
	                  <td>${TvSeriesEpisode.isActiveStatus}</td>
	                  <td class="hide">${TvSeriesEpisode.isActive}</td>
	                  <td class="tbl-edit"></td>
	                  <td class="tbl-delete"></td>
		            </tr>
		        </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Manage Subscription Plans -->

    <div class="manage-SubscriptionPlans-container-section container-section hide" id="manageSubscriptionPlans">
      <div class="manage-SubscriptionPlans-heading">
        <div class="manage-SubscriptionPlans-title">
          <h4>Add / Edit / Delete Subscription Plans</h4>
        </div>
        <div class="add-SubscriptionPlans-btn">
          <input type="button" value="Add a Tv Series Episodes" onclick="showAddSubscriptionPlansForm()" />
        </div>
      </div>
      <div class="manage-SubscriptionPlans-grid">
        <div class="add-new-SubscriptionPlans add-form" id="addSubscriptionPlansForm">
          <div class="card">
            <div class="card-heading">
              <p>Add a SubscriptionPlans</p>
            </div>
            <form action="../php/admin_portal_SubscriptionPlans_add_process.php" method="post"
              enctype="multipart/form-data">
              <label for="txtSubscriptionPlansName">Tv Series Episodes Name</label> <br />
              <input type="text" name="SubscriptionPlansname" id="txtSubscriptionPlansName" required />
              <br />
              <label for="txtSubscriptionPlansDescription">Tv Series Episodes Description</label> <br />
              <input type="text" name="SubscriptionPlansdescription" id="txtSubscriptionPlansDescription" required />
              <br />
              <label for="txtSubscriptionPlansStartingDate">Starting Date</label> <br />
              <input type="date" name="startingdate" id="txtSubscriptionPlansStartingDate" required />
              <br />
              <label for="txtSubscriptionPlansEndingDate">Ending Date</label> <br />
              <input type="date" name="endingdate" id="txtSubscriptionPlansEndingDate" required />
              <br />
              <label for="txtSubscriptionPlansPercentage">SubscriptionPlans Percentage</label> <br />
              <input type="text" name="percentage" id="txtSubscriptionPlansPercentage" required />
              <br />
              <label for="imgSubscriptionPlansImage">SubscriptionPlans Image</label> <br />
              <input type="file" name="SubscriptionPlansimage" id="imgSubscriptionPlansImage" accept="image/*" required />
              <br />
              <input type="submit" class="submit-btn" value="Add" />
            </form>
          </div>
        </div>
        <div class="update-SubscriptionPlans update-form" id="updateSubscriptionPlansForm">
          <div class="card">
            <div class="card-heading">
              <p>Update Subscription Plans</p>
            </div>
            <form action="../php/admin_portal_SubscriptionPlans_update_process.php" method="post">
              <label for="txtUpdateSubscriptionPlansName">SubscriptionPlans Name</label> <br />
              <input type="text" name="SubscriptionPlansname" id="txtUpdateSubscriptionPlansName" required />
              <br />
              <label for="txtUpdateSubscriptionPlansDescription">SubscriptionPlans Description</label>
              <br />
              <input type="text" name="SubscriptionPlansdescription" id="txtUpdateSubscriptionPlansDescription"
                required />
              <br />
              <label for="txtUpdateSubscriptionPlansStartingDate">Starting Date</label>
              <br />
              <input type="date" name="startingdate" id="txtUpdateSubscriptionPlansStartingDate" required />
              <br />
              <label for="txtUpdateSubscriptionPlansEndingDate">Ending Date</label> <br />
              <input type="date" name="endingdate" id="txtUpdateSubscriptionPlansEndingDate" required />
              <br />
              <label for="txtUpdateSubscriptionPlansPercentage">SubscriptionPlans Percentage</label>
              <br />
              <input type="text" name="percentage" id="txtUpdateSubscriptionPlansPercentage" required />
              <br />
              <label for="txtUpdateSubscriptionPlansStatus">Active / InActive</label> <br />
              <select name="status" id="txtUpdateSubscriptionPlansStatus" required>
                <option value=""></option>
                <option value="1">Active</option>
                <option value="0">InActive</option>
              </select>
              <input type="hidden" name="rowid" id="editSubscriptionPlansRowId" />
              <input type="submit" class="submit-btn" value="Update" />
            </form>
          </div>
        </div>
        <div class="table-card">
          <form id="subscriptionPlanGetForm" action="${pageContext.request.contextPath}/SubscriptionPlanServlet" method="GET">
          	<input type="submit" id="getSubscriptionPlanDataButton" style="display: none">
	      </form>
          <table>
            <!-- <caption>Statement Summary</caption> -->
            <thead>
              <tr>
                <th class="hide">ID</th>
                <th>Subscription Plan Name</th>
                <th>Duration (Months)</th>
                <th>Amount (LKR)</th>
                <th>Active / InActive</th>
                <th class="hide">Status</th>
                <th class="tbl-edit"></th>
                <th class="tbl-delete"></th>
              </tr>
            </thead>
            <tbody>
	            <c:forEach items="${subscriptionPlans}" var="subscriptionPlan">
		            <tr>
		              <td class="hide">${subscriptionPlan.planId}</td>
	                  <td>${subscriptionPlan.description}</td>
	                  <td>${subscriptionPlan.duration}</td>
	                  <td>${subscriptionPlan.amount}</td>
	                  <td>${subscriptionPlan.isActive}</td>
	                  <td class="hide">${subscriptionPlan.isActive}</td>
	                  <td class="tbl-edit"></td>
	                  <td class="tbl-delete"></td>
		            </tr>
		        </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

  </main>

  <!-- 
    - #FOOTER
  -->

  <div id="footer"></div>

  <script>
	//Construct the path dynamically by appending the context path
	  var contextPath = "${pageContext.request.contextPath}";
	  var footerPath = contextPath + "/components/footer.html";
	  
    // Fetch the HTML content of your component
    fetch(footerPath)
      .then((response) => response.text())
      .then((html) => {
        // Inject the HTML content into your container-section
        document.getElementById("footer").innerHTML = html;
      });
  </script>

  <!-- 
    - #GO TO TOP
  -->

  <a href="#top" class="go-top" data-go-top>
    <ion-icon name="chevron-up"></ion-icon>
  </a>

  <!-- 
    - custom js link
  -->
  <script src="${pageContext.request.contextPath}/assets/js/admin-portal.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/script.js"></script>
  <!-- 
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
  document.addEventListener('DOMContentLoaded', function() {
	    //var elems = document.querySelectorAll('select');
	    //var instances = M.FormSelect.init(elems);
	    
	    var select = document.querySelectorAll('select');
	    var instances = M.FormSelect.init(select);
	  });

</script>

</body>

</html>