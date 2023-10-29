<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!--
    - #HEADER
-->

<header class="header" data-header>
  <div class="container">

    <div class="overlay" data-overlay></div>

    <a href="${pageContext.request.contextPath}/index.jsp" class="logo">
      <img src="${pageContext.request.contextPath}/assets/images/logo.svg" alt="Filmlane logo">
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
        onclick="toggleSignInSignUpCardForm('sign-up-form', 'sign-in-form', 'toggle')">Sign in</button>

    </div>

    <button class="menu-open-btn" data-menu-open-btn>
      <ion-icon name="reorder-two"></ion-icon>
    </button>

    <nav class="navbar" data-navbar>

      <div class="navbar-top">

        <a href="${pageContext.request.contextPath}/index.jsp" class="logo">
          <img src="${pageContext.request.contextPath}/assets/images/logo.svg" alt="Filmlane logo">
        </a>

        <button class="menu-close-btn" data-menu-close-btn>
          <ion-icon name="close-outline"></ion-icon>
        </button>

      </div>

      <ul class="navbar-list">

        <li>
          <a href="${pageContext.request.contextPath}/index.jsp" class="navbar-link">Home</a>
        </li>

        <li>
          <a href="${pageContext.request.contextPath}/pages/movies.jsp" class="navbar-link">Movies</a>
        </li>

        <li>
          <a href="${pageContext.request.contextPath}/pages/tv-series.jsp" class="navbar-link">Tv Series</a>
        </li>

        <li>
          <a href="${pageContext.request.contextPath}/pages/favourites.jsp" class="navbar-link">Favourites</a>
        </li>

        <li>
          <a href="${pageContext.request.contextPath}/pages/about.jsp" class="navbar-link">About</a>
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