/**
 * filter the test with a specific flag
 * @param fill
 */
function filterFlag(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("flag");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[7];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

/**
 * filter the completed test
 * @param fill
 */
function filterComplete(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("completed");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[5];
    if (td) {
      if (td.innerHTML.toUpperCase().includes(filter)) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

/**
 * filter the missing test
 * @param fill
 */
function filterMissTest(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("missTest");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[6];
      if (td) {
        if(filter == ""){tr[i].style.display = "";}
        else if(filter == "1" && td.innerHTML.toUpperCase() == "0")
        {
          tr[i].style.display = "";
        } 
        else if(filter == "2" && td.innerHTML.toUpperCase() != "0"){
          tr[i].style.display = "";
        }
        else {
          tr[i].style.display = "none";
        }
      }
    }
  }

/**
 * Search the test from home page
 */
function searchTestFunction() {
  let input, filter, table, tr, td, i;
  input = document.getElementById("name");
  filter = input.value.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

/**
 * Search the previous test of a patient
 */
function searchPreviousTestFunction() {
  let input, filter, table, tr, td, i;
  input = document.getElementById("name");
  filter = input.value.toUpperCase();
  table = document.getElementById("previousTestTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}


$(document).ready(function () {
  $("#1").click(function () {
    $("#red").click(function () {
      document.getElementById("b1").className = "badge red";
    });
  });
});

/**
 * format the date to correct form
 * @param v the input date
 * @returns {string} the date with correct form
 */
function formateDate(v){
  let date = v.split(" ")
  let dateArray = date[0].split("-")
  console.log(dateArray);
  return (dateArray[0]+dateArray[1]+dateArray[2])
}

/**
 * Sort test by date
 */
function sortByDate(){
  
  var tbody = document.querySelector("#testTable tbody")
  var rows = [].slice.call(tbody.querySelectorAll("tr"));

  rows.sort(function(a,b) {
    return formateDate(a.cells[3].innerHTML) - formateDate(b.cells[3].innerHTML)
  })

  rows.forEach(function(c) {
      tbody.appendChild(c)
  })
}