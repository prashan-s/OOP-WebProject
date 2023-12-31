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


window.addEventListener("load", function () {
	
	  const currentGrid = localStorage.getItem("currentGrid");
	  console.log(currentGrid);
	  if (currentGrid) {
		  // Call the corresponding function to display the grid
		  if (currentGrid === "User") {
		    showCustomerGrid("manageCustomers");
		  } else if (currentGrid === "Movie") {
		    showMovieGrid("manageMovies");
		  } else if (currentGrid === "TvSeries") {
		    showTvSeriesGrid("manageTvSeriess");
		  } else if (currentGrid === "TvSeriesEpisodes") {
		    showTvSeriesEpisodesGrid("manageTvSeriesEpisodess");
		  } else if (currentGrid === "SubscriptionPlan") {
		    showSubscriptionPlanGrid("manageSubscriptionPlans");
		  }
	  }  
		

  // Call collapseSubLists on page load
  const navigationBar = document.getElementById("adminNavigationBar");
  collapseSubLists(navigationBar);

  // Call the hideAlert function when the page is loaded
  var alerts = document.querySelectorAll(".alert-success, .alert-danger");
  alerts.forEach(function (alert) {
    alert.style.opacity = "1";
  });

  hideAlert();
});

function toggleNavigation() {
  const overlay = document.getElementById("overlay");
  const navigationBar = document.getElementById("adminNavigationBar");

  navigationBar.classList.toggle("closed");

  if (navigationBar.classList.contains("closed")) {
    if (overlay) {
      overlay.removeEventListener("click", closeOverlay);
      document.body.removeChild(overlay);
    }
  } else {
    if (!overlay) {
      const newOverlay = createOverlay();
      newOverlay.addEventListener("click", closeOverlay);
      document.body.appendChild(newOverlay);
      newOverlay.classList.add("show");
    }
  }
}

function createOverlay() {
  const overlay = document.createElement("div");
  overlay.id = "overlay";
  overlay.classList.add("overlay");
  return overlay;
}

function closeOverlay() {
  const overlay = document.getElementById("overlay");
  const navigationBar = document.getElementById("adminNavigationBar");

  if (overlay) {
    overlay.removeEventListener("click", closeOverlay);
    document.body.removeChild(overlay);
  }

  if (navigationBar) {
    navigationBar.classList.add("closed");
  }
}

function collapseSubLists(navigationBar) {
  const subLists = navigationBar.getElementsByClassName("sub-list");

  for (let i = 0; i < subLists.length; i++) {
    const subList = subLists[i];
    subList.classList.add("closed");
  }
}

function toggleSubList(mainItem) {
  const subList = mainItem.querySelector(".sub-list");
  subList.classList.toggle("closed");
}

function showStaffGrid(id) {
  hideGrids();
  deselectHeading();

  const selectedHeading = document.getElementById(id);
  selectedHeading.classList.add("selected");

  const manageStaff = document.getElementById("manageStaff");
  manageStaff.classList.remove("hide");

  closeOverlay();
}

function showCustomerGrid(id) {
  hideGrids();
  deselectHeading();

  const selectedHeading = document.getElementById(id);
  selectedHeading.classList.add("selected");

  const manageCustomer = document.getElementById("managecustomer");
  manageCustomer.classList.remove("hide");

  closeOverlay();
  localStorage.setItem("currentGrid", "User");
  submitFormWithLocalStorageCheck('getUserDataButton', 'formUserGetSubmitted');
}

function showMovieGrid(id) {
  hideGrids();
  deselectHeading();

  const selectedHeading = document.getElementById(id);
  selectedHeading.classList.add("selected");

  const manageMovie = document.getElementById("manageMovie");
  manageMovie.classList.remove("hide");

  closeOverlay();
  localStorage.setItem("currentGrid", "Movie");
  submitFormWithLocalStorageCheck('getMovieDataButton', 'formUserGetSubmitted');
}

function showTvSeriesGrid(id) {
  hideGrids();
  deselectHeading();

  const selectedHeading = document.getElementById(id);
  selectedHeading.classList.add("selected");

  const manageTvSeries = document.getElementById("manageTvSeries");
  manageTvSeries.classList.remove("hide");

  closeOverlay();
  localStorage.setItem("currentGrid", "TvSeries");
  submitFormWithLocalStorageCheck('getTvSeriesDataButton', 'formMovieGetSubmitted');
}

function showTvSeriesEpisodesGrid(id) {
  hideGrids();
  deselectHeading();

  const selectedHeading = document.getElementById(id);
  selectedHeading.classList.add("selected");

  const manageTvSeriesEpisodes = document.getElementById("manageTvSeriesEpisodes");
  manageTvSeriesEpisodes.classList.remove("hide");

  closeOverlay();
  localStorage.setItem("currentGrid", "TvSeriesEpisodes");
  submitFormWithLocalStorageCheck('getTvSeriesEpisodesDataButton', 'formTvSeriesEpisodesGetSubmitted');
}

function showSubscriptionPlanGrid(id) {
  hideGrids();
  deselectHeading();

  const selectedHeading = document.getElementById(id);
  selectedHeading.classList.add("selected");

  const manageSubscriptionPlan = document.getElementById("manageSubscriptionPlans");
  manageSubscriptionPlan.classList.remove("hide");

  closeOverlay();
  localStorage.setItem("currentGrid", "SubscriptionPlan");
  submitFormWithLocalStorageCheck('getSubscriptionPlanDataButton', 'formSubscriptionPlanGetSubmitted');
}

function hideGrids() {
  const containers = document.getElementsByClassName("container-section");

  for (let i = 0; i < containers.length; i++) {
    containers[i].classList.add("hide");
  }
}

function submitFormWithLocalStorageCheck(btnId, storageKey) {
        if (!localStorage.getItem(storageKey)) {
            //document.getElementById(formId).submit();
            const getFormSubmitBtn = document.getElementById(btnId);
	    	getFormSubmitBtn.click();
            localStorage.setItem(storageKey, 'true');
        }else {
            // Optionally, you can remove the localStorage item to reset it for future page loads
            localStorage.removeItem(storageKey);
        }
    }

function deselectHeading() {
  const admingHeadings = document.getElementsByClassName("adming-heading");

  for (let i = 0; i < admingHeadings.length; i++) {
    admingHeadings[i].classList.remove("selected");
  }
}

function showAddMemberForm() {
  const updateMemberForm = document.getElementById("updateMemberForm");
  if (updateMemberForm.classList.contains("show")) {
    updateMemberForm.classList.remove("show");
  }

  const addMemberForm = document.getElementById("addMemberForm");
  addMemberForm.classList.toggle("show");
}

function showAddCustomerForm() {
  const updateCustomerForm = document.getElementById("updateCustomerForm");
  if (updateCustomerForm.classList.contains("show")) {
    updateCustomerForm.classList.remove("show");
  }

  const addCustomerForm = document.getElementById("addCustomerForm");
  addCustomerForm.classList.toggle("show");
}

function showAddMovieForm() {
  const updateMovieForm = document.getElementById("updateMovieForm");
  if (updateMovieForm.classList.contains("show")) {
    updateMovieForm.classList.remove("show");
  }

  const manageMovie = document.getElementById("addMovieForm");
  manageMovie.classList.toggle("show");
}

function showAddTvSeriesForm() {
  const updateTvSeriesForm = document.getElementById("updateTvSeriesForm");
  if (updateTvSeriesForm.classList.contains("show")) {
    updateTvSeriesForm.classList.remove("show");
  }

  const addTvSeriesForm = document.getElementById("addTvSeriesForm");
  addTvSeriesForm.classList.toggle("show");
}

function showAddTvSeriesEpisodesForm() {
  const updateTvSeriesEpisodesForm = document.getElementById("updateTvSeriesEpisodesForm");
  if (updateTvSeriesEpisodesForm.classList.contains("show")) {
    updateTvSeriesEpisodesForm.classList.remove("show");
  }

  const addTvSeriesEpisodesForm = document.getElementById("addTvSeriesEpisodesForm");
  addTvSeriesEpisodesForm.classList.toggle("show");
}

function showAddSubscriptionPlansForm() {
  const updateSubscriptionPlanForm = document.getElementById("updateSubscriptionPlansForm");
  if (updateSubscriptionPlanForm.classList.contains("show")) {
    updateSubscriptionPlanForm.classList.remove("show");
  }

  const addSubscriptionPlanForm = document.getElementById("addSubscriptionPlansForm");
  addSubscriptionPlanForm.classList.toggle("show");
}

function showUpdatedMemberForm() {
  const addMemberForm = document.getElementById("addMemberForm");
  if (addMemberForm.classList.contains("show")) {
    addMemberForm.classList.remove("show");
  }

  const updateMemberForm = document.getElementById("updateMemberForm");
  updateMemberForm.classList.remove("hide");
  updateMemberForm.classList.add("show");
}

function showUpdatedCustomerForm() {
  const addCustomerForm = document.getElementById("addCustomerForm");
  if (addCustomerForm.classList.contains("show")) {
    addCustomerForm.classList.remove("show");
  }

  const updateCustomerForm = document.getElementById("updateCustomerForm");
  updateCustomerForm.classList.remove("hide");
  updateCustomerForm.classList.add("show");
}

function showUpdatedMovieForm() {
  const addMovieForm = document.getElementById("addMovieForm");
  if (addMovieForm.classList.contains("show")) {
    addMovieForm.classList.remove("show");
  }

  const updateMovieForm = document.getElementById("updateMovieForm");
  updateMovieForm.classList.remove("hide");
  updateMovieForm.classList.add("show");
}

function showUpdatedTvSeriesForm() {
  const addTvSeriesForm = document.getElementById("addTvSeriesForm");
  if (addTvSeriesForm.classList.contains("show")) {
    addTvSeriesForm.classList.remove("show");
  }

  const updateTvSeriesForm = document.getElementById("updateTvSeriesForm");
  updateTvSeriesForm.classList.remove("hide");
  updateTvSeriesForm.classList.add("show");
}

function showUpdatedTvSeriesEpisodesForm() {
  const addTvSeriesEpisodesForm = document.getElementById("addTvSeriesEpisodesForm");
  if (addTvSeriesEpisodesForm.classList.contains("show")) {
    addTvSeriesEpisodesForm.classList.remove("show");
  }

  const updateTvSeriesEpisodesForm = document.getElementById("updateTvSeriesEpisodesForm");
  updateTvSeriesEpisodesForm.classList.remove("hide");
  updateTvSeriesEpisodesForm.classList.add("show");
}

function showUpdatedSubscriptionPlanForm() {
  const addTvSeriesEpisodesForm = document.getElementById("addSubscriptionPlansForm");
  if (addTvSeriesEpisodesForm.classList.contains("show")) {
    addTvSeriesEpisodesForm.classList.remove("show");
  }

  const updateTvSeriesEpisodesForm = document.getElementById("updateSubscriptionPlansForm");
  updateTvSeriesEpisodesForm.classList.remove("hide");
  updateTvSeriesEpisodesForm.classList.add("show");
}

function editUpdateMemberRow(rowId) {
  // Get the row data
  var row = document.getElementById(rowId);
  var id = row.querySelector("td:nth-child(1)").textContent;
  var firstName = row.querySelector("td:nth-child(2)").textContent;
  var lastName = row.querySelector("td:nth-child(3)").textContent;
  var email = row.querySelector("td:nth-child(4)").textContent;
  var role = row.querySelector("td:nth-child(5)").textContent;
  var mobileNo = row.querySelector("td:nth-child(6)").textContent;
  var gender = row.querySelector("td:nth-child(7)").textContent;
  var username = row.querySelector("td:nth-child(9)").textContent;
  var password = row.querySelector("td:nth-child(10)").textContent;
  var roleID = row.querySelector("td:nth-child(11)").textContent;
  var status = row.querySelector("td:nth-child(12)").textContent;

  // Set the row data in the form fields
  document.getElementById("editMemberRowId").value = id;
  document.getElementById("txtMemberUpdateFirstname").value = firstName;
  document.getElementById("txtMemberUpdateLastname").value = lastName;
  document.getElementById("txtMemberUpdateEmail").value = email;
  document.getElementById("txtMemberUpdateMobileNo").value = mobileNo;
  document.getElementById("txtMemberUpdateGender").value = gender;
  document.getElementById("txtMemberUpdateUsername").value = username;
  document.getElementById("txtMemberUpdatePassword").value = password;
  document.getElementById("txtMemberUpdateRole").value = roleID;
  document.getElementById("txtMemberUpdateStatus").value = status;
  // Populate other form fields as needed

  // Show the member form
  showUpdatedMemberForm();
}

function editUpdateCustomerRow(rowId) {
  // Get the row data
  var row = document.getElementById(rowId);
  var id = row.querySelector("td:nth-child(1)").textContent;
  var name = row.querySelector("td:nth-child(2)").textContent;
  var email = row.querySelector("td:nth-child(3)").textContent;
  var mobileNumber = row.querySelector("td:nth-child(4)").textContent;
  var dob = row.querySelector("td:nth-child(5)").textContent;
  var status = row.querySelector("td:nth-child(9)").textContent;
  debugger;
  var isActive;
	
	if (status == 'true') {
		isActive = 1;
	} else {
		isActive = 0;
	}

  // Set the row data in the form fields
  document.getElementById("editCustomerRowId").value = id;
  document.getElementById("txtCustomerUpdateName").value = name;
  document.getElementById("txtCustomerUpdateEmail").value = email;
  document.getElementById("txtCustomerUpdateMobileNo").value = mobileNumber;
  document.getElementById("txtCustomerUpdateDateofBirth").value = dob;
  document.getElementById("txtCustomerUpdateStatus").value = isActive;
  
  // Trigger the 'change' event to update the select element
	var selectElement = document.getElementById("txtCustomerUpdateStatus");
	var event = new Event("change", { bubbles: true });
	selectElement.dispatchEvent(event);

  // Populate other form fields as needed

  // Show the customer form
  showUpdatedCustomerForm();
}

function editUpdateMovieRow(rowId) {
  // Get the row data
  var row = document.getElementById(rowId);
  var id = row.querySelector("td:nth-child(1)").textContent;
  var MovieName = row.querySelector("td:nth-child(2)").textContent;
  var MovieDescription = row.querySelector("td:nth-child(3)").textContent;
  var MovieYear = row.querySelector("td:nth-child(4)").textContent;
  var MovieDuration = row.querySelector("td:nth-child(5)").textContent;
  var MovieQuality = row.querySelector("td:nth-child(6)").textContent;
  var MovieUrl = row.querySelector("td:nth-child(8)").textContent;
  //var status = row.querySelector("td:nth-child(9)").textContent;
//debugger;
	//ar isActive;
	
	//if (status == 'true') {
		//isActive = 1;
	//} else {
		//isActive = 0;
	//}
	
  // Set the row data in the form fields
  document.getElementById("editMovieRowId").value = id;
  document.getElementById("txtUpdateMovieName").value = MovieName;
  document.getElementById("txtUpdateMovieDescription").value = MovieDescription;
  document.getElementById("txtUpdateMovieYear").value = MovieYear;
  document.getElementById("txtUpdateMovieDuration").value = MovieDuration;
  document.getElementById("txtUpdateMovieQuality").value = MovieQuality;
  document.getElementById("txtUpdateMovieUrl").value = MovieUrl;
  //document.getElementById("txtUpdateMovieStatus").value = isActive;
  
  //var selectElement = document.getElementById("txtUpdateMovieStatus");
	//var event = new Event("change", { bubbles: true });
	//selectElement.dispatchEvent(event);
	
  // Populate other form fields as needed

  // Show the Movie form
  showUpdatedMovieForm();
}

function editUpdateTvSeriesRow(rowId) {
  // Get the row data
  var row = document.getElementById(rowId);
  var id = row.querySelector("td:nth-child(1)").textContent;
  var TvSeriesName = row.querySelector("td:nth-child(2)").textContent;

  // Set the row data in the form fields
  document.getElementById("editTvSeriesRowId").value = id;
  document.getElementById("txtUpdateTvSeriesName").value = TvSeriesName;
  
  // Show the TvSeries form
  showUpdatedTvSeriesForm();
}

function editUpdateTvSeriesEpisodesRow(rowId) {
  // Get the row data
  debugger;
  var row = document.getElementById(rowId);
  var id = row.querySelector("td:nth-child(1)").textContent;
  var TvSeriesSeason = row.querySelector("td:nth-child(3)").textContent;
  var TvSeriesEpisode = row.querySelector("td:nth-child(4)").textContent;
  var TvSeriesEpisodeDescription = row.querySelector("td:nth-child(5)").textContent;
  var TvSeriesEpisodeYear = row.querySelector("td:nth-child(6)").textContent;
  var TvSeriesEpisodesDuration = row.querySelector("td:nth-child(7)").textContent;
  var TvSeriesEpisodesQuality = row.querySelector("td:nth-child(8)").textContent;
  var TvSeriesEpisodesUrl = row.querySelector("td:nth-child(9)").textContent;
  var status = row.querySelector("td:nth-child(10)").textContent;
  
  var isActive;
	
	if (status == 'Active') {
		isActive = 1;
	} else {
		isActive = 0;
	}

  // Set the row data in the form fields
  document.getElementById("editTvSeriesEpisodeRowId").value = id;
  document.getElementById("txtUpdateTvSeriesSeason").value = TvSeriesSeason;
  document.getElementById("txtUpdateTvSeriesEpisode").value = TvSeriesEpisode;
  document.getElementById("txtUpdateTvSeriesEpisodeDescription").value = TvSeriesEpisodeDescription;
  document.getElementById("txtUpdateTvSeriesEpisodeYear").value = TvSeriesEpisodeYear;
  document.getElementById("txtUpdateTvSeriesEpisodeDuration").value = TvSeriesEpisodesDuration;
  document.getElementById("txtUpdateTvSeriesEpisodeQuality").value = TvSeriesEpisodesQuality;
  document.getElementById("txtUpdateTvSeriesEpisodeUrl").value = TvSeriesEpisodesUrl;
  document.getElementById("txtUpdateTvSeriesEpisodeStatus").value = isActive;
  
  var selectElement = document.getElementById("txtUpdateTvSeriesEpisodeStatus");
	var event = new Event("change", { bubbles: true });
	selectElement.dispatchEvent(event);
  // Populate other form fields as needed

  // Show the TvSeries form
  showUpdatedTvSeriesEpisodesForm();
}

function editUpdateSubscriptionPlanRow(rowId) {
  // Get the row data
  debugger;
  var row = document.getElementById(rowId);
  var id = row.querySelector("td:nth-child(1)").textContent;
  var SubscriptionPlanName = row.querySelector("td:nth-child(2)").textContent;
  var SubscriptionPlanDuration = row.querySelector("td:nth-child(3)").textContent;
  var SubscriptionPlanAmount = row.querySelector("td:nth-child(4)").textContent;

  // Set the row data in the form fields
  document.getElementById("editSubscriptionPlansRowId").value = id;
  document.getElementById("txtUpdateSubscriptionPlansName").value = SubscriptionPlanName;
  document.getElementById("txtUpdateSubscriptionPlansDuration").value = SubscriptionPlanDuration;
  document.getElementById("txtUpdateSubscriptionPlansAmount").value = SubscriptionPlanAmount;
  
  // Show the TvSeries form
  showUpdatedSubscriptionPlanForm();
}

// Attach event listeners to main items
const mainItems = document.getElementsByClassName("main-list");
for (let i = 0; i < mainItems.length; i++) {
  const mainItem = mainItems[i];
  mainItem.addEventListener("click", function (event) {
    if (!event.target.closest(".sub-list")) {
      toggleSubList(mainItem);
    }
  });
}

function confirmDelete(event, btnId) {
  if (confirm("Are you sure you want to delete this record?")) {
	  document.getElementById(btnId).click();
  }
}

// Function to hide the alert after 3 seconds
function hideAlert() {
  setTimeout(function () {
    var alerts = document.querySelectorAll(".alert-success, .alert-danger");
    alerts.forEach(function (alert) {
      alert.style.opacity = "0";
      setTimeout(function () {
        alert.style.display = "none";
      }, 500); // Wait for the transition to complete before hiding the element
    });
  }, 3000);
}

// Get the overlay background element
var overlays = document.querySelectorAll(".add-form, .update-form");

// Add a click event listener to the overlay
overlays.forEach(function (overlay) {
  overlay.addEventListener("click", function (event) {
    // Check if the clicked element is the overlay itself (not its children)
    if (event.target === overlay) {
      // Hide the "Add Member" card
      overlay.classList.remove("show");
    }
  });
});
