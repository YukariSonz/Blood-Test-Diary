/**
 * define the password field
 */
$("#password").on("focusout", function (e) {
    if ($(this).val() != $("#confirm_password").val()) {
        $("#confirm_password").removeClass("valid").addClass("invalid");
    } else {
        $("#confirm_password").removeClass("invalid").addClass("valid");
    }
});

/**
 * define the confirm password field
 */
$("#confirm_password").on("keyup", function (e) {
    if ($("#password").val() != $(this).val()) {
        $(this).removeClass("valid").addClass("invalid");
    } else {
        $(this).removeClass("invalid").addClass("valid");
    }
});

var password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password");

/**
 * Check if password and confirm password is same
 */
function validatePassword(){
  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords do not match");
  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;