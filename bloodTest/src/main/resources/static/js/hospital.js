/**
 * Search hostpital in the hospital table
 */
function searchHospitalFunction() {
    let input, filter, table, tr, td, i;
    input = document.getElementById("name");
    filter = input.value.toUpperCase();
    table = document.getElementById("hospitalTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[1];
      if (td) {
        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }


  var map;

/**
 * initialize google map, define the initial point
 */
  function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
      center: {
        lat: 51.508530,
        lng: -0.076132
      }, //London
      zoom: 10
    });
    //var geocoder = new google.maps.Geocoder();
    //document.getElementById('showHospital').addEventListener('click',function(){
    //  geocodeAddress(geocoder,map);
    //});
  }

/**
 * Plot hospital locaiton in the map
 * @param address address of hospital
 */
function buttonHelper(address) {
    geocodeAddress(map, address, "red");
  }


/**
 * Plot an address in the google map with a specific color
 * @param resultsMap the map
 * @param address define the address of marker
 * @param color define color of marker
 */
function geocodeAddress(resultsMap, address, color) {

      new google.maps.Size(18, 34),
          new google.maps.Point(0,0),
          new google.maps.Point(10, 34);

    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({
      'address': address
    }, function (results, status) {
      if (status === 'OK') {
        resultsMap.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
          map: resultsMap,
          position: results[0].geometry.location,
            icon: {
                url: "http://maps.google.com/mapfiles/ms/icons/"+color+"-dot.png"
            }

        });
        resultsMap.setZoom(15);
      } else {
        alert('Not successful for the following reason: ' + status);
      }
    });
  }


/**
 * Plot patient location in the map
 */
function searchPatientLocation(){
    let input;

    input = document.getElementById("patient_location");
    filter = input.value.toLowerCase();

    geocodeAddress(map, filter,"blue");
  }


