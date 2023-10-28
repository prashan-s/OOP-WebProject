'use strict';

window.onload = function () {
  setInterval(setDateTimeNow, 1000);
};

$(document).ready(function () {
  $('.fade').slick({
    dots: true,
    arrows: true,
    infinite: true,
    speed: 500,
    fade: true,
    cssEase: 'linear',
    autoplay: true,
    autoplaySpeed: 2000,
  });
});


/**
 * navbar variables
 */

const navOpenBtn = document.querySelector("[data-menu-open-btn]");
const navCloseBtn = document.querySelector("[data-menu-close-btn]");
const navbar = document.querySelector("[data-navbar]");
const overlay = document.querySelector("[data-overlay]");

const navElemArr = [navOpenBtn, navCloseBtn, overlay];

for (let i = 0; i < navElemArr.length; i++) {

  navElemArr[i].addEventListener("click", function () {

    navbar.classList.toggle("active");
    overlay.classList.toggle("active");
    document.body.classList.toggle("active");

  });

}



/**
 * header sticky
 */

const header = document.querySelector("[data-header]");

window.addEventListener("scroll", function () {

  window.scrollY >= 10 ? header.classList.add("active") : header.classList.remove("active");

});



/**
 * go top
 */

const goTopBtn = document.querySelector("[data-go-top]");

window.addEventListener("scroll", function () {

  window.scrollY >= 500 ? goTopBtn.classList.add("active") : goTopBtn.classList.remove("active");

});


function toggleSignInSignUpCardForm(formHide, formShow, method) {

  const signUpForm = document.getElementById(formHide);
  if (!signUpForm.classList.contains('hide')) {
    signUpForm.classList.add("hide");
  }

  if (method === 'toggle') {
    const signInForm = document.getElementById(formShow);
    if (signInForm.classList.contains('hide')) {
      signInForm.classList.remove("hide");
    } else {
      signInForm.classList.add("hide");
    }
  }

}

function setDateTimeNow() {
  var dateTime = new Date();
  var time = dateTime.toLocaleTimeString("en-US", {
    hour12: false,
    hour: "numeric",
    minute: "numeric",
  });

  var options = {
    weekday: "short",
    month: "short",
    day: "numeric",
    year: "numeric",
  };
  var formattedDate = dateTime.toLocaleDateString("en-US", options);

  document.getElementById("time").innerText = time;
  document.getElementById("date").innerText = formattedDate;
}