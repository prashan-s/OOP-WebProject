<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Filmlane - Best movie collections</title>

  <!-- 
    - favicon
  -->
  <link rel="shortcut icon" href="./favicon.svg" type="image/svg+xml">

  <!-- 
    - custom css link
  -->
  <link rel="stylesheet" href="./assets/css/style.css">

  <!-- 
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

  <!-- 
    - slick carousel
  -->
  <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
  <link rel="stylesheet" type="text/css" href="./assets/css/slick-theme.css" />

  <!-- Sementic Compiled and minified CSS -->
  <link rel="stylesheet" href="./assets/packages/sementic/semantic.css">

</head>

<body id="top">

  <!-- 
    - #HEADER
  -->

  <div id="header"></div>

  <script>

    // Fetch the HTML content of your component
    fetch('./components/headerIndex.html')
      .then(response => response.text())
      .then(html => {
        // Inject the HTML content into your container
        document.getElementById('header').innerHTML = html;
      });

  </script>

  <main>
    <article>

      <!-- 
        - #CAROUSEL
      -->

      <div class="carousel fade">
        <div><img src="./assets/images/hero-bg.jpg"></div>
        <div><img src="./assets/images/hero-bg1.jpg"></div>
        <div><img src="./assets/images/hero-bg2.jpg"></div>
      </div>

      <!-- 
        - #HERO
      -->

      <section class="hero">
        <div class="container">

          <div class="hero-content">

            <p class="hero-subtitle">Filmlane</p>

            <h1 class="h1 hero-title">
              Unlimited <strong>Movie</strong>, TVs Shows, & More.
            </h1>

            <div class="meta-wrapper">

              <div class="badge-wrapper">
                <div class="badge badge-fill">PG 18</div>

                <div class="badge badge-outline">HD</div>
              </div>

              <div class="ganre-wrapper">
                <a href="#">Romance,</a>

                <a href="#">Drama</a>
              </div>

              <div class="date-time">

                <div>
                  <ion-icon name="calendar-outline"></ion-icon>

                  <time datetime="2022">2022</time>
                </div>

                <div>
                  <ion-icon name="time-outline"></ion-icon>

                  <time datetime="PT128M">128 min</time>
                </div>

              </div>

            </div>

            <button class="btn btn-primary">
              <ion-icon name="play"></ion-icon>

              <span>Watch now</span>
            </button>

          </div>

        </div>

        <div class="sign-in card hide" id="sign-in-form">
          <form class="ui form" action="UserServlet" method="post">
            <div class="sign-card-heading-section">
              <div class="form-close-icon">
                <ion-icon name="close-outline" class="close-icon"
                  onclick="toggleSignInSignUpCardForm('sign-in-form', 'sign-up-form', 'close')"></ion-icon>
              </div>
              <div class="sign-in-heading">
                <h1>Sign In</h1>
              </div>
            </div>
            <div class="sign-in-field">
              <div class="field">
                <label>Username</label>
                <input type="text" name="userName" placeholder="Username">
              </div>
              <div class="field">
                <label>Password</label>
                <input type="password" name="password" placeholder="Password">
              </div>
              <input class="ui button sign-in-btn" type="submit" value="Sign In" ></input>
            </div>
          </form>
          <div class="dont-have-an-account">
            <h4>Don't have an account?</h4>
            <button class="signup-url"
              onclick="toggleSignInSignUpCardForm('sign-in-form', 'sign-up-form', 'toggle')">Sign Up</button>
          </div>
        </div>

        <div class="sign-up card hide" id="sign-up-form">
          <form class="ui form" action="#" method="post">
            <div class="form-close-icon">
              <ion-icon name="close-outline" class="close-icon"
                onclick="toggleSignInSignUpCardForm('sign-up-form', 'sign-in-form', 'close')"></ion-icon>
            </div>
            <h1 class="sign-up-heading">Sign Up</h1>
            <div class="sign-up-field">
              <div class="field">
                <label>Username</label>
                <input type="text" name="username" placeholder="Username">
              </div>
              <div class="field">
                <label>Email</label>
                <input type="email" name="email" placeholder="Email">
              </div>
              <div class="field">
                <label>Mobile Number</label>
                <input type="number" name="mobileno" placeholder="Mobile Number">
              </div>
              <div class="field">
                <label>Password</label>
                <input type="password" name="password" placeholder="Password">
              </div>
              <div class="field">
                <label>Confirm Password</label>
                <input type="password" name="confirmpassword" placeholder="Confirm Password">
              </div>
              <input class="ui button sign-up-btn" type="submit" value="Sign Up"></input>
            </div>
          </form>
          <div class="dont-have-an-account">
            <h4>Already have an account?</h4>
            <button class="signup-url"
              onclick="toggleSignInSignUpCardForm('sign-up-form', 'sign-in-form', 'toggle')">Sign In</button>
          </div>
        </div>
      </section>


      <!-- 
        - #TRENDING
      -->

      <section class="upcoming">
        <div class="container">

          <div class="flex-wrapper">

            <div class="title-wrapper">
              <p class="section-subtitle">Online Streaming</p>

              <h2 class="h2 section-title">Trending</h2>
            </div>

            <ul class="filter-list">

              <li>
                <button class="filter-btn">Movies</button>
              </li>

              <li>
                <button class="filter-btn">TV Shows</button>
              </li>

              <li>
                <button class="filter-btn">Anime</button>
              </li>

            </ul>

          </div>

			<form action="${pageContext.request.contextPath}/UserServlet" method="get" style="display: none">
		        <input type="text" id="search" name="search" />
		        <button type="submit">Search</button>
		    </form>
          <ul class="movies-list  has-scrollbar">
			<c:forEach items="${movies}" var="movie">
	            <li>
	                <div class="movie-card">
	                    <a href="./pages/movie-details.jsp">
	                        <figure class="card-banner">
	                            <img src="${movie.image}" alt="${movie.title} movie poster">
	                        </figure>
	                    </a>
	                    <div class="title-wrapper">
	                        <a href="./pages/movie-details.jsp">
	                            <h3 class="card-title">${movie.title}</h3>
	                        </a>
	                        <time datetime="${movie.year}">${movie.year}</time>
	                    </div>
	                    <div class="card-meta">
	                        <div class="badge badge-outline">${movie.badge}</div>
	                        <div class="duration">
	                            <ion-icon name="time-outline"></ion-icon>
	                            <time datetime="${movie.duration}">${movie.duration}</time>
	                        </div>
	                        <div class="rating">
	                            <ion-icon name="star"></ion-icon>
	                            <data>${movie.rating}</data>
	                        </div>
	                    </div>
	                </div>
	            </li>
        	</c:forEach>
          </ul>

        </div>
      </section>


      <!-- 
        - #UPCOMING MOVIES
      -->

      <section class="upcoming">
        <div class="container">

          <div class="flex-wrapper">

            <div class="title-wrapper">
              <p class="section-subtitle">Online Streaming</p>

              <h2 class="h2 section-title">Upcoming Movies</h2>
            </div>

            <ul class="filter-list">

              <li>
                <button class="filter-btn">Movies</button>
              </li>

              <li>
                <button class="filter-btn">TV Shows</button>
              </li>

              <li>
                <button class="filter-btn">Anime</button>
              </li>

            </ul>

          </div>

		<form action="${pageContext.request.contextPath}/UserServlet" method="get" style="display: none">
	        <input type="text" id="search" name="search" />
	        <button type="submit">Search</button>
	    </form>
          <ul class="movies-list  has-scrollbar">
            <c:forEach items="${movies}" var="movie">
	            <li>
	                <div class="movie-card">
	                    <a href="./pages/movie-details.jsp">
	                        <figure class="card-banner">
	                            <img src="${movie.image}" alt="${movie.title} movie poster">
	                        </figure>
	                    </a>
	                    <div class="title-wrapper">
	                        <a href="./pages/movie-details.jsp">
	                            <h3 class="card-title">${movie.title}</h3>
	                        </a>
	                        <time datetime="${movie.year}">${movie.year}</time>
	                    </div>
	                    <div class="card-meta">
	                        <div class="badge badge-outline">${movie.badge}</div>
	                        <div class="duration">
	                            <ion-icon name="time-outline"></ion-icon>
	                            <time datetime="${movie.duration}">${movie.duration}</time>
	                        </div>
	                        <div class="rating">
	                            <ion-icon name="star"></ion-icon>
	                            <data>${movie.rating}</data>
	                        </div>
	                    </div>
	                </div>
	            </li>
        	</c:forEach>
          </ul>

        </div>
      </section>


      <!-- 
        - #UPCOMING TV SERIES
      -->

      <section class="upcoming">
        <div class="container">

          <div class="flex-wrapper">

            <div class="title-wrapper">
              <p class="section-subtitle">Online Streaming</p>

              <h2 class="h2 section-title">Upcoming TV Series</h2>
            </div>

            <ul class="filter-list">

              <li>
                <button class="filter-btn">Movies</button>
              </li>

              <li>
                <button class="filter-btn">TV Shows</button>
              </li>

              <li>
                <button class="filter-btn">Anime</button>
              </li>

            </ul>

          </div>

			<form action="${pageContext.request.contextPath}/UserServlet" method="get" style="display: none">
		        <input type="text" id="search" name="search" />
		        <button type="submit">Search</button>
		    </form>
          <ul class="movies-list  has-scrollbar">
			<c:forEach items="${movies}" var="movie">
	            <li>
	                <div class="movie-card">
	                    <a href="./pages/movie-details.jsp">
	                        <figure class="card-banner">
	                            <img src="${movie.image}" alt="${movie.title} movie poster">
	                        </figure>
	                    </a>
	                    <div class="title-wrapper">
	                        <a href="./pages/movie-details.jsp">
	                            <h3 class="card-title">${movie.title}</h3>
	                        </a>
	                        <time datetime="${movie.year}">${movie.year}</time>
	                    </div>
	                    <div class="card-meta">
	                        <div class="badge badge-outline">${movie.badge}</div>
	                        <div class="duration">
	                            <ion-icon name="time-outline"></ion-icon>
	                            <time datetime="${movie.duration}">${movie.duration}</time>
	                        </div>
	                        <div class="rating">
	                            <ion-icon name="star"></ion-icon>
	                            <data>${movie.rating}</data>
	                        </div>
	                    </div>
	                </div>
	            </li>
        	</c:forEach>
          </ul>

        </div>
      </section>
    </article>
  </main>

  <!-- 
    - #FOOTER
  -->

  <div id="footer"></div>

  <script>

    // Fetch the HTML content of your component
    fetch('./components/footerIndex.html')
      .then(response => response.text())
      .then(html => {
        // Inject the HTML content into your container
        document.getElementById('footer').innerHTML = html;
      });

  </script>

  <!-- 
    - #GO TO TOP
  -->

  <a href="#top" class="go-top" data-go-top>
    <ion-icon name="chevron-up"></ion-icon>
  </a>



  <!-- 
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
    integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>

  <!-- 
    - slick carousel
  -->
  <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
  <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

  <!-- Semantic Compiled and minified JavaScript -->
  <script src="./assets/packages/sementic/semantic.min.js"></script>

  <!-- 
    - custom js link
  -->
  <script src="./assets/js/script.js"></script>
</body>

</html>