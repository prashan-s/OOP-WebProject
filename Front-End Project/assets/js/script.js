'use strict';

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


function toggleSignInCardForm() {

  const signUpForm = document.getElementById("sign-up-form");
  if (!signUpForm.classList.contains('hide')) {
    signUpForm.classList.add("hide");
  }

  const signInForm = document.getElementById("sign-in-form");
  if (signInForm.classList.contains('hide')) {
    signInForm.classList.remove("hide");
  } else {
    signInForm.classList.add("hide");
  }
}

function toggleSignUpCardForm() {
  
  const signInForm = document.getElementById("sign-in-form");
  if (!signInForm.classList.contains('hide')) {
    signInForm.classList.add("hide");
  }

  const signUpForm = document.getElementById("sign-up-form");
  if (signUpForm.classList.contains('hide')) {
    signUpForm.classList.remove("hide");
  } else {
    signUpForm.classList.add("hide");
  }
}