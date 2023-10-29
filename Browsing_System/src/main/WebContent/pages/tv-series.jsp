<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Free Guy 2021</title>

    <!--
      - favicon
    -->
    <link rel="shortcut icon" href="/favicon.svg" type="image/svg+xml"/>

    <!--
      - custom css link
    -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/tv-series.css"/>

    <!--
      - google font link
    -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"/>
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
    <div class="movie-compartment">
        <!--
          - #MOVIE DETAIL
        -->

        <section class="movie-detail">
            <div class="movie-heading">
                <p class="detail-subtitle">Recommended</p>
            </div>
            <form action="${pageContext.request.contextPath}/TVSeriesServlet" method="post">
                <input type="submit" name="action" value="submit-getallseries">
            </form>
            <div class="movie-container">
                <c:forEach items="${seriesList}" var="item">
                    <div class="movie-detail-container">
                        <figure class="movie-detail-banner">
                            <img src="${item.tvs_img_url}" alt="${item.title}"/>
                            <button class="play-btn" onclick="openMoviePage()">
                                <ion-icon name="play-circle-outline"></ion-icon>
                            </button>
                        </figure>

                        <div class="date-time">
                            <div>
                                <ion-icon name="calendar-outline"></ion-icon>
                                <time datetime="${item.row_created_datetime}">${item.row_created_datetime}</time>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div class="movie-container">

    </div>
    </section>
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
<script src="${pageContext.request.contextPath}/assets/js/tv-series.js"></script>
<!--
  - ionicon link
-->
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>