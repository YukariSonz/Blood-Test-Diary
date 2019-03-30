/**
 * define the nav bar
 */
const sideNav = document.querySelector('.sidenav');
M.Sidenav.init(sideNav, {});
//Modal
$(document).ready(function () {
  $(".modal").modal();
});
$(".dropdown-trigger").dropdown({coverTrigger: false});