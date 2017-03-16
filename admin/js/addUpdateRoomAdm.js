document.addEventListener("DOMContentLoaded",function(){

    var doc = document;
    var roomId = document.location.href.match(/id=([^&]+)/)[1];
    var roomfacilcm = doc.getElementById('room-facil-cm'),
    roomfacilck = doc.getElementById('room-facil-ck'),
    roomfacildvd = doc.getElementById('room-facil-dvd'),
    roomfacilwifi = doc.getElementById('room-facil-wifi'),
    roomfacilhd = doc.getElementById('room-facil-hd'),
    roomfacilac = doc.getElementById('room-facil-ac'),
    roomfacilsb = doc.getElementById('room-facil-sb'),
    roomfaciltow = doc.getElementById('room-facil-tow'),
    roomfaciltv = doc.getElementById('room-facil-tv'),
    roomfacilwc = doc.getElementById('room-facil-wc'),
    roomfacilov = doc.getElementById('room-facil-ov'),
    roomfacilbks = doc.getElementById('room-facil-bks');

    var map = [
        {obj: roomfacilcm,    en: 0},
        {obj: roomfacilck,    en: 1},
        {obj: roomfacildvd,   en: 2},
        {obj: roomfacilwifi,  en: 3},
        {obj: roomfacilhd,    en: 4},
        {obj: roomfacilac,    en: 5},
        {obj: roomfacilsb,    en: 6},
        {obj: roomfaciltow,   en: 7},
        {obj: roomfaciltv,    en: 8},
        {obj: roomfacilov,    en: 9},
        {obj: roomfacilwc,    en: 10},
        {obj: roomfacilbks, en: 11}                            
    ];

    if (roomId > 0) {
        $.ajax({
            type:'GET',
            contentType: 'application/json',
            dataType: 'json',
/*            url: 'http://localhost/practice-web/rooms/idd?id=' + roomId,*/
            url: 'http://practice.relex.ru:81/api/rooms/idd?id=' + roomId,
            success: function(data, json){
                         doc.getElementById('room-number').innerHTML = data.id;
                         doc.getElementById('room-short-description').value = data.shortDescription;
                         doc.getElementById('room-full-description').value = data.fullDescription;
                         var map = new Object();
                         map['COFFEE_MACHINE'] = roomfacilcm;
                         map['CARDKEY'] = roomfacilck;
                         map['DVD_PLAYER'] = roomfacildvd;
                         map['WIFI'] = roomfacilwifi;
                         map['HAIRDRYER'] = roomfacilhd;
                         map['AIR_CONDITIONING'] = roomfacilac;
                         map['SAFEBOX'] = roomfacilsb;
                         map['TOWELS'] = roomfaciltow;
                         map['TV'] = roomfaciltv;
                         map['OVEN'] = roomfacilov;
                         map['WC'] = roomfacilwc;
                         map['BADKINGSIZE'] = roomfacilbks;
                         function get(k) {
                             return map[k];
                         }
                         $.each(data.facilities, function(){
                            get(this).checked = true;
                         });
                         doc.getElementById('room-rating-pos').value = data.ratingPosition;
                         doc.getElementById('room-rating-comf').value = data.ratingComfort;
                         doc.getElementById('room-rating-pr').value = data.ratingPrice;
                         doc.getElementById('room-rating-qual').value = data.ratingQuality;
                         doc.getElementById('room-persons').value = data.persons;
                         doc.getElementById('room-rooms').value = data.numberOfRooms;
                         doc.getElementById('room-price').value = data.price;
                         doc.getElementById('room-booked').checked = data.isBooked;
                         doc.getElementById('room-shown').checked = data.isShown;
                         doc.getElementById('room-has-breakfast').checked = data.hasBreakfast;
                     }
        });
    } else {
        $.each(map, function(){
           this.obj.disabled = true;
        });
    }

    $('#room-button-submit').click(function() {

        if (roomId > 0) {
            var facilityString = '', facilityStringWithComma = '';
            $.each(map, function(){
               if (this.obj.checked) {
                   facilityString = facilityStringWithComma;
                   facilityString += '' + this.en;
                   facilityStringWithComma = facilityString + ',';
               }
            });
            var jsonData = '{' +
                            ' "id":' + doc.getElementById('room-number').innerHTML + ',' +
                            ' "shortDescription": "' + doc.getElementById('room-short-description').value + '",' +
                            ' "fullDescription": "' + doc.getElementById('room-full-description').value + '",' +
                            ' "persons":' + doc.getElementById('room-persons').value + ',' +
                            ' "numberOfRooms":' + doc.getElementById('room-rooms').value + ',' +
                            ' "price":' + doc.getElementById('room-price').value + ',' +
                            ' "isBooked":' + doc.getElementById('room-booked').checked + ',' +
                            ' "isShown":' + doc.getElementById('room-shown').checked + ',' +
                            ' "hasBreakfast":' + doc.getElementById('room-has-breakfast').checked + ',' +
                            ' "ratingPosition":' + doc.getElementById('room-rating-pos').value + ',' +
                            ' "ratingComfort":' + doc.getElementById('room-rating-comf').value + ',' +
                            ' "ratingPrice":' + doc.getElementById('room-rating-pr').value + ',' +
                            ' "ratingQuality":' + doc.getElementById('room-rating-qual').value + ',' +
                            ' "facilities": [' + facilityString + ']' +
                        '}'
            $.ajax({
                type:'POST',
                contentType: 'application/json',
                dataType: 'json',
                data: jsonData,
/*                url: 'http://localhost/practice-web/api/rooms/update',*/
                url: 'http://practice.relex.ru:81/api/api_rooms/update',
                success: function(data, json){}
            });
        } else {
            var jsonData = '{' +
                            ' "name": "Some name",' +
                            ' "shortDescription": "' + doc.getElementById('room-short-description').value + '",' +
                            ' "fullDescription": "' + doc.getElementById('room-full-description').value + '",' +
                            ' "persons":' + doc.getElementById('room-persons').value + ',' +
                            ' "numberOfRooms":' + doc.getElementById('room-rooms').value + ',' +
                            ' "price":' + doc.getElementById('room-price').value + ',' +
                            ' "isBooked":' + doc.getElementById('room-booked').checked + ',' +
                            ' "isShown":' + doc.getElementById('room-shown').checked + ',' +
                            ' "hasBreakfast":' + doc.getElementById('room-has-breakfast').checked + ',' +
                            ' "ratingPosition":' + doc.getElementById('room-rating-pos').value + ',' +
                            ' "ratingComfort":' + doc.getElementById('room-rating-comf').value + ',' +
                            ' "ratingPrice":' + doc.getElementById('room-rating-pr').value + ',' +
                            ' "ratingQuality":' + doc.getElementById('room-rating-qual').value + ',' +
                            ' "urlPhoto1": "Some url for photo 1"' +
                        '}'
            $.ajax({
                type:'POST',
                contentType: 'application/json',
                dataType: 'json',
                data: jsonData,
/*                url: 'http://localhost/practice-web/api/rooms/add',*/
                url: 'http://practice.relex.ru:81/api/api_rooms/add',
/*                success: function(data, json){*/
                success: function(data){
                             alert(data);
/*                             alert(json);*/
                         }
            });
        }
    });
});