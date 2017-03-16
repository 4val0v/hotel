var facility_mapper = {
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
document.addEventListener("DOMContentLoaded",function(){
    var doc = document;
    $.ajax({
        type:'GET',
        contentType: "application/json",
        url: 'http://practice.relex.ru:81/api/rooms/' ,
        success: function(data, json){
        var rooms = doc.getElementById('content_rooms');   
    $.each(data, function(){
                if(this.shown == 1){
                var room = doc.createElement('div'),
                        room_img = doc.createElement('div'),
                        room_info = doc.createElement('div'),
                    facilities = '';
                    room_img.setAttribute('class','room_img');
                    room.setAttribute('class','room');
                    room_info.setAttribute('class', 'room_info')
                    $.each(this.facilities, function(){
                        facilities += '<li class="'+facility_mapper[this]+'"></li>\n'
                    });
                    room_img.innerHTML='<img src="'+this.urlPhoto1+'">';
                    var breakfast = 'not included';
                    if(this.hasBreakfast){
                        breakfast = 'included'
                    }
                    room_info.innerHTML='<span class="name"><h2><a href="room_detail.html?id='+this.id+'">'+this.name+'</a></h2>'+
                        '</span><span class="description"><h4>'+this.shortDescription+'</h4></span>'+
                        '<hr>'+
                        '<div class="facilities"><ul>'+facilities+'</ul></div>'+
                        '<hr>'+
                        '<span class="price">'+
                        '<p>From <strong>$'+this.price+'</strong>/nignt</p>'+
                        '<h6>Breakfast '+breakfast+'</h6>'+
                        '</span>';
                    room.appendChild(room_img);
                    room.appendChild(room_info);
                    rooms.appendChild(doc.createElement('hr'));
                    rooms.appendChild(room);
                }
                
            });
    }
    });
});