document.addEventListener("DOMContentLoaded",function(){
    var doc = document;
    $.ajax({
        type:'GET',
        contentType: "application/json",
        url: 'http://localhost:81/api/getstats' ,
        success: function(data){
            var statsRoom = doc.getElementById('statsRoom_panel');
            $.each(data, function(){

                    var roomsNumber = doc.createElement('p'),
                    ordersNumber = doc.createElement('p');

                    roomsNumber.setAttribute('class','roomsNumber');
                    roomsNumber.setAttribute('class','ordersNumber');

                    roomsNumber.innerHTML='<div>'+this.ordersNumber+'/'+this.roomsNumber+'</div>';
                    statsRoom.appendChild(roomsNumber);

            });

            var statsGuest = doc.getElementById('statsGuest_panel');
            $.each(data, function(){

                var guestsNumber = doc.createElement('p'),
                    placesNumber = doc.createElement('p');

                guestsNumber.setAttribute('class','guestsNumber');
                placesNumber.setAttribute('class','placesNumber');

                guestsNumber.innerHTML='<div>'+this.guestsNumber+'/'+this.placesNumber+'</div>';
                statsGuest.appendChild(guestsNumber);

            });

            var statsRate = doc.getElementById('statsRate_panel');
            $.each(data, function(){

                var avgRating = doc.createElement('p');

                avgRating.setAttribute('class','avgRating');

                avgRating.innerHTML='<div>'+this.avgRating.toFixed(2)+'</div>';
                statsRate.appendChild(avgRating);

            });

            var statsFeedback = doc.getElementById('statsFeedback_panel');
            $.each(data, function(){

                var feedback = doc.createElement('p');

                feedback.setAttribute('class','feedbackNumber');

                feedback.innerHTML='<div>'+this.feedbackNumber+'</div>';
                statsFeedback.appendChild(feedback);

            });



        }
    });
});








































//document.addEventListener("DOMContentLoaded", function() {
//    var doc = document;
//    $.ajax({
//        type: 'GET',
//        dataType: "json",
//        url: 'http://localhost/api/stat/',
//        success: function (data, json) {
//            var statistic = doc.getElementById("stat");
//
//            $.each(data, function () {
//                var stats = doc.createElement('div'),
//                    stat_rooms = doc.createElement('div'),
//                    stat_orders = doc.createElement('div'),
//                    stat_places = doc.createElement('div'),
//                    stat_guests = doc.createElement('div');
//                    stat_rating = doc.createElement('div');
//
//                stats.setAttribute('class', 'stats');
//                stat_rooms.setAttribute('class', 'rooms');
//                stat_orders.setAttribute('class', 'orders');
//                stat_places.setAttribute('class', 'places');
//                stat_guests.setAttribute('class', 'guests');
//                stat_rating.setAttribute('class', 'rating');
//
//                stat_rooms.innerHTML = '<div><p>this.rooms<p></div>';
//                stat_orders.innerHTML = '<div><p>this.orders</p></div>';
//                stat_places.innerHTML = '<div><p>this.places</p></div>';
//                stat_guests.innerHTML = '<div><p>this.guests</p></div>';
//                stat_rating.innerHTML = '<div><p>this.rating</p></div>';
//
//                stats.appendChild(stat_rooms);
//                stats.appendChild(stat_orders);
//                stats.appendChild(stat_places);
//                stats.appendChild(stat_guests);
//                stats.appendChild(stat_rating);
//                stat.appendChild(doc.createElement('hr'));
//                stat.appendChild(statistic);
//            })
//        }
//    })
//});
