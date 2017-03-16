var facility_mapper_styles = {
"TOWELS":"icon_set_2_icon-103",
"WC":"icon-toilet",
"SAFEBOX":"icon_set_2_icon-106",
"BADKINGSIZE":"icon_set_2_icon-104",
"AIR_CONDITIONING":"icon-air",
"CARDKEY":"icon_set_1_icon-35",
"HAIRDRYER":"icon_set_1_icon-100",
"DVD_PLAYER":"icon-video-alt-1",
"COFFEE_MACHINE":"icon_set_1_icon-59",
"TV":"icon_set_2_icon-116",
"OVEN":"icon-layers",
};
var facility_mapper_desc = {
"TOWELS":"Towels",
"WC":"WC",
"SAFEBOX":"Safe",
"BADKINGSIZE":"King size bad",
"AIR_CONDITIONING":"Air conditioning",
"CARDKEY":"Keycard",
"HAIRDRYER":"Hairdryer",
"DVD_PLAYER":"DVD player",
"COFFEE_MACHINE":"Coffee machine",
"TV":"TV",
"OVEN":"Oven",
};
var id = document.location.href.match(/id=([^&]+)/)[1];

document.addEventListener("DOMContentLoaded",function(){
    var content_room = document.getElementById('content_room'),
        room = document.createElement('div');
    room.setAttribute('id','room');
    $.ajax({
        type:'GET',
        contentType: "application/json",
        url: 'http://practice.relex.ru:81/api/rooms/id?id='+id ,
        success: function(data, json){
                var facilities = '';
                var facilities_desc = '';
                var date = new Date(); 
            $.each(data.facilities, function(){
                        facilities += '<li><span class="'+facility_mapper_styles[this]+'"></span>'+facility_mapper_desc[this]+'</li>\n'
                        facilities_desc += facility_mapper_desc[this] + '<br/>'
                    });
                room.innerHTML = '<div class="room_name">'+
                '<h2>'+data.name+'</h2>'+
            '</div>'+
            '<hr>'+
            '<div id="room_booking">'+
                    'TODO: insert form for booking'+
            '</div>'+
            '<div class="room_info">'+
                '<div class="room_facilities">'+
                '<ul>'+facilities+'</ul>'+
                '</div>'+
                '<hr>'+
                '<div class="room_desc_name">'+
                    '<h3>Decripption</h3>'+
                '</div>'+
                '<div class="room_description">'+
                    '<span class="full_decription">'+data.fullDescription+'</span>'+
                    '<span class="room_facilities">'+
                    '<h3>Room facilities</h3>'+
                        '<p>'+facilities_desc+'</p>'+
                    '</span>'+
                    '<div class="room_prices">'+
                    '<h3>Room Prices</h3>'+
                            '<p>Begin: <input id="date_begin" type="date" name="dateBegin"'+
                                'value="'+date.getFullYear()+'-'+(date.getMonth()+1)+'-0'+date.getDate()+'">'+
                                'End: <input id="date_end" type="date" name="dateEnd" value="'+date.getFullYear()+'-'+(date.getMonth()+1)+'-0'+(date.getDate()+1)+'">'+
                            '</p>'+
                            '<input id="submit" type="submit" value="Рассчитать" onclick="getCoast()"> <input id="result_coast"name="coast" type="text">'+
                    '</div>'+
                '</div>'+
            '</div>';
            content_room.appendChild(room);
    }
    
})
});
function getCoast(){
    var dateBegin = document.getElementById('date_begin');
    var dateEnd = document.getElementById('date_end');
    $.ajax({
       type:'GET',
        contentType: "application/json",
        url: 'http://practice.relex.ru:81/api/rooms/coast?dateBegin='+dateBegin.value+'&dateEnd='+dateEnd.value+'&id='+id,
        success: function(data, json){
            var input_result = document.getElementById('result_coast');
            input_result.setAttribute("value",data.coast)
        }
    })
        }
