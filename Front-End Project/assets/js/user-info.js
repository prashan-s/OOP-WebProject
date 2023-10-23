window.addEventListener("load", function () {
  // Get the URL parameter 'type'
  const urlParams = new URLSearchParams(window.location.search);
  const updateType = urlParams.get("type");

  console.log(updateType);
  if (updateType === "yourinfo") {
    changeComponent("info", "infoContainer");
  } else if (updateType === "privacy") {
    changeComponent("privacy", "privacyContainer");
  } else if (updateType === "paymentmethod") {
    changeComponent("payment", "paymentContainer");
  }

  hideAlert();
});

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

function changeComponent(btnId, containerId) {
  const btn = document.getElementById(btnId);
  const allButtons = document.getElementsByClassName("component-btn");
  const container = document.getElementById(containerId);
  const allContainers = document.getElementsByClassName("card-container");

  // Hide all containers
  for (let i = 0; i < allContainers.length; i++) {
    allContainers[i].style.display = "none";
  }

  // Remove background color from all buttons
  for (let i = 0; i < allButtons.length; i++) {
    allButtons[i].classList.remove("clicked");
  }

  // Show the selected container
  container.style.display = "block";
  btn.classList.add("clicked");
}

function showUpdatedYourInfoForm() {
  const updateYourInfoForm = document.getElementById("updateYourInfoForm");
  updateYourInfoForm.classList.remove("hide");
  updateYourInfoForm.classList.add("show");

  debugger;
  firstName = document.getElementById("firstName").textContent;
  lastName = document.getElementById("lastName").textContent;
  email = document.getElementById("email").textContent;
  contactNo = document.getElementById("contactNo").textContent;
  gender = document.getElementById("genderHiddenValue").textContent;
  dob = document.getElementById("dob").textContent;
  address = document.getElementById("address").textContent;
  userID = document.getElementById("userID").textContent;

  document.getElementById("txtYourInfoFirstname").value = firstName;
  document.getElementById("txtYourInfoLastname").value = lastName;
  document.getElementById("txtYourInfoEmail").value = email;
  document.getElementById("txtYourInfoMobileNo").value = contactNo;
  document.getElementById("txtYourInfoGender").value = gender;
  document.getElementById("txtYourInfoBirthday").value = dob;
  document.getElementById("txtYourInfoAddress").value = address;
  document.getElementById("hiddenUserId").value = userID;
}

function updatePaymentMethod(rowId) {
  // Get the row data
  var row = document.getElementById(rowId);
  var id = row.querySelector("td:nth-child(1)").textContent;
  var CardNo = row.querySelector("td:nth-child(2)").textContent;
  var ExpDate = row.querySelector("td:nth-child(3)").textContent;
  var CVV = row.querySelector("td:nth-child(4)").textContent;
  var Country = row.querySelector("td:nth-child(5)").textContent;
  var Status = row.querySelector("td:nth-child(7)").textContent;

  // Set the row data in the form fields
  document.getElementById("hiddenPaymentId").value = id;
  document.getElementById("txtUpdateCardNo").value = CardNo;
  document.getElementById("txtUpdateExpDate").value = ExpDate;
  document.getElementById("txtUpdateCVV").value = CVV;
  document.getElementById("txtUpdateCountry").value = Country;
  document.getElementById("txtStatus").value = Status;
  // Populate other form fields as needed

  // Show the member form
  showUpdateCardUpdateForm();
}

function showUpdateCardUpdateForm() {
  const updateMemberForm = document.getElementById("updateYourCardInfoForm");
  updateMemberForm.classList.remove("hide");
  updateMemberForm.classList.add("show");
}

function confirmDelete(event) {
  if (confirm("Are you sure you want to delete this record?")) {
    event.target.parentElement.submit();
  } else {
    event.preventDefault(); // Prevent the default form submission
  }
}

function validateForm() {
  var newPassword = document.getElementById("txtNewPass").value;
  var confirmPassword = document.getElementById("txtConfirmPass").value;

  if (newPassword !== confirmPassword) {
    alert("New password and confirm password must match.");
    return false; // Prevent form submission
  }

  return true; // Allow form submission
}

// Get the overlay background element
var overlays = document.querySelectorAll(".update-form");

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
