window.addEventListener("load", function () {
	submitFormWithLocalStorageCheck("getMovieBtn", "getMovies");
});


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
    
    function openMoviePage() {
    window.location.href = "./movie-details.jsp";
}
