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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/movies.css" />

  <!-- 
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet" />
</head>


<body id="#top">
  <!-- 
    - #HEADER
  -->

  <div id="header"></div>

  <script>
    // Fetch the HTML content of your component
    fetch("${pageContext.request.contextPath}/components/header.jsp")
      .then((response) => response.text())
      .then((html) => {
        // Inject the HTML content into your container
        document.getElementById("header").innerHTML = html;
      });
  </script>

  <main>
    <div>



    </div>>
    <div class="movie-compartment">
      <!-- 
        - #MOVIE DETAIL
      -->


      <section class="movie-detail">
        <div class="movie-heading">
          <p class="detail-subtitle">Recommended</p>
        </div>

        <%--@Teran Refer this--%>
        <form action="${pageContext.request.contextPath}/MovieServlet" method="post" style="display:none">
          <input type="submit" name="action" value="submit-getMovies" id="getMovieBtn">
        </form>

        <div class="movie-container">
          <c:forEach items="${movieData}" var="movie">
            <div class="movie-detail-container">
              <figure class="movie-detail-banner">
                <img src="${movie.movie_img_url}" alt="${movie.title}" />
                <button class="play-btn" onclick="openMoviePage()">
                  <ion-icon name="play-circle-outline"></ion-icon>
                </button>
              </figure>

              <div class="date-time">
                <div>
                  <ion-icon name="calendar-outline"></ion-icon>
                  <time datetime="${movie.year}">${movie.year}</time>
                </div>
                <div>
                  <ion-icon name="time-outline"></ion-icon>
                  <time datetime="PT${movie.duration}M">${movie.duration} min</time>
                </div>
              </div>
            </div>
          </c:forEach>


        </div>
      </section>

<%--      <section class="movie-detail recently-updated">--%>
<%--        <div class="movie-heading">--%>
<%--          <p class="detail-subtitle">Recently Updated</p>--%>
<%--        </div>--%>
<%--        <div class="movie-container">--%>
<%--          <div class="movie-detail-container">--%>
<%--            <figure class="movie-detail-banner">--%>
<%--              <img src="${pageContext.request.contextPath}/assets/images/movie-4.png" alt="Free guy movie poster" />--%>
<%--              <button class="play-btn" onclick="openMoviePage()">--%>
<%--                <ion-icon name="play-circle-outline"></ion-icon>--%>
<%--              </button>--%>
<%--            </figure>--%>

<%--            <div class="date-time">--%>
<%--              <div>--%>
<%--                <ion-icon name="calendar-outline"></ion-icon>--%>
<%--                <time datetime="2021">2021</time>--%>
<%--              </div>--%>
<%--              <div>--%>
<%--                <ion-icon name="time-outline"></ion-icon>--%>
<%--                <time datetime="PT115M">115 min</time>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--          <div class="movie-detail-container">--%>
<%--            <figure class="movie-detail-banner">--%>
<%--              <img src="${pageContext.request.contextPath}/assets/images/movie-4.png" alt="Free guy movie poster" />--%>
<%--              <button class="play-btn" onclick="openMoviePage()">--%>
<%--                <ion-icon name="play-circle-outline"></ion-icon>--%>
<%--              </button>--%>
<%--            </figure>--%>

<%--            <div class="date-time">--%>
<%--              <div>--%>
<%--                <ion-icon name="calendar-outline"></ion-icon>--%>
<%--                <time datetime="2021">2021</time>--%>
<%--              </div>--%>
<%--              <div>--%>
<%--                <ion-icon name="time-outline"></ion-icon>--%>
<%--                <time datetime="PT115M">115 min</time>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--          <div class="movie-detail-container">--%>
<%--            <figure class="movie-detail-banner">--%>
<%--              <img src="${pageContext.request.contextPath}/assets/images/movie-4.png" alt="Free guy movie poster" />--%>
<%--              <button class="play-btn" onclick="openMoviePage()">--%>
<%--                <ion-icon name="play-circle-outline"></ion-icon>--%>
<%--              </button>--%>
<%--            </figure>--%>

<%--            <div class="date-time">--%>
<%--              <div>--%>
<%--                <ion-icon name="calendar-outline"></ion-icon>--%>
<%--                <time datetime="2021">2021</time>--%>
<%--              </div>--%>
<%--              <div>--%>
<%--                <ion-icon name="time-outline"></ion-icon>--%>
<%--                <time datetime="PT115M">115 min</time>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--          <div class="movie-detail-container">--%>
<%--            <figure class="movie-detail-banner">--%>
<%--              <img src="${pageContext.request.contextPath}/assets/images/movie-4.png" alt="Free guy movie poster" />--%>
<%--              <button class="play-btn" onclick="openMoviePage()">--%>
<%--                <ion-icon name="play-circle-outline"></ion-icon>--%>
<%--              </button>--%>
<%--            </figure>--%>

<%--            <div class="date-time">--%>
<%--              <div>--%>
<%--                <ion-icon name="calendar-outline"></ion-icon>--%>
<%--                <time datetime="2021">2021</time>--%>
<%--              </div>--%>
<%--              <div>--%>
<%--                <ion-icon name="time-outline"></ion-icon>--%>
<%--                <time datetime="PT115M">115 min</time>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </section>--%>

      <!-- 
        - #TV SERIES
      -->

      <!-- <section class="tv-series">
        <div class="container">

          <p class="section-subtitle">Best TV Series</p>

          <h2 class="h2 section-title">World Best TV Series</h2>

          <ul class="movies-list">

            <li>
              <div class="movie-card">

                <a href="./movie-details.html">
                  <figure class="card-banner">
                    <img src="${pageContext.request.contextPath}/assets/images/series-1.png" alt="Moon Knight movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title">Moon Knight</h3>
                  </a>

                  <time datetime="2022">2022</time>
                </div>

                <div class="card-meta">
                  <div class="badge badge-outline">2K</div>

                  <div class="duration">
                    <ion-icon name="time-outline"></ion-icon>

                    <time datetime="PT47M">47 min</time>
                  </div>

                  <div class="rating">
                    <ion-icon name="star"></ion-icon>

                    <data>8.6</data>
                  </div>
                </div>

              </div>
            </li>

            <li>
              <div class="movie-card">

                <a href="./movie-details.html">
                  <figure class="card-banner">
                    <img src="${pageContext.request.contextPath}/assets/images/series-2.png" alt="Halo movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title">Halo</h3>
                  </a>

                  <time datetime="2022">2022</time>
                </div>

                <div class="card-meta">
                  <div class="badge badge-outline">2K</div>

                  <div class="duration">
                    <ion-icon name="time-outline"></ion-icon>

                    <time datetime="PT59M">59 min</time>
                  </div>

                  <div class="rating">
                    <ion-icon name="star"></ion-icon>

                    <data>8.8</data>
                  </div>
                </div>

              </div>
            </li>

            <li>
              <div class="movie-card">

                <a href="./movie-details.html">
                  <figure class="card-banner">
                    <img src="${pageContext.request.contextPath}/assets/images/series-3.png" alt="Vikings: Valhalla movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title">Vikings: Valhalla</h3>
                  </a>

                  <time datetime="2022">2022</time>
                </div>

                <div class="card-meta">
                  <div class="badge badge-outline">2K</div>

                  <div class="duration">
                    <ion-icon name="time-outline"></ion-icon>

                    <time datetime="PT51M">51 min</time>
                  </div>

                  <div class="rating">
                    <ion-icon name="star"></ion-icon>

                    <data>8.3</data>
                  </div>
                </div>

              </div>
            </li>

            <li>
              <div class="movie-card">

                <a href="./movie-details.html">
                  <figure class="card-banner">
                    <img src="${pageContext.request.contextPath}/assets/images/series-4.png" alt="Money Heist movie poster">
                  </figure>
                </a>

                <div class="title-wrapper">
                  <a href="./movie-details.html">
                    <h3 class="card-title">Money Heist</h3>
                  </a>

                  <time datetime="2017">2017</time>
                </div>

                <div class="card-meta">
                  <div class="badge badge-outline">4K</div>

                  <div class="duration">
                    <ion-icon name="time-outline"></ion-icon>

                    <time datetime="PT70M">70 min</time>
                  </div>

                  <div class="rating">
                    <ion-icon name="star"></ion-icon>

                    <data>8.3</data>
                  </div>
                </div>

              </div>
            </li>

          </ul>

        </div>
      </section> -->
    </div>
  </main>

  <!-- 
    - #FOOTER
  -->

  <div id="footer"></div>

  <script>
    // Fetch the HTML content of your component
    fetch("${pageContext.request.contextPath}/components/footer.jsp")
      .then((response) => response.text())
      .then((html) => {
        // Inject the HTML content into your container
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
  <script src="${pageContext.request.contextPath}/assets/js/script.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/movies.js"></script>
  <!-- 
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>