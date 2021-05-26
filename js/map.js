var map;
var m;

function initMap()
    var coord = {lat: -34.397, lng: -150.644}
    var map = new google.maps.Map(document.getElementById('map'), {
        center: coord,
        zoom: 8
    });


/* 
var markers;
var bounds;

function plotMarkers()
{
    markers = [];
    bounds = new google.maps.LatLngBounds();

    m.forEach(function (marker) {
        var position = new google.maps.LatLng(marker.coord.lat, marker.coord.lon);
        markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
        );

        bounds.extend(position);
    });

    map.fitBounds(bounds);
}
*/