document.addEventListener("DOMContentLoaded", function() {
    var doc = document;
    $.ajax({
        type: 'GET',
        dataType: "json",
        url: 'http://localhost:81/api/main/',
        success: function (data) {
            var top_five = doc.getElementById('top-five');

            $.each(data, function () {
                if (this.isShown == 1) {
                    var room = doc.createElement('div'),
                        room_img = doc.createElement('div'),
                        room_price = doc.createElement('div'),
                        room_info = doc.createElement('div'),
                        room_separator = doc.createElement('div');

                    room.setAttribute('class', 'room');
                    room_img.setAttribute('class', 'room_img');
                    room_price.setAttribute('class', 'room_price');
                    room_price.setAttribute('style', 'width: 15%; float:left; align: center; text-align: center');
                    room_info.setAttribute('class', 'room_info');
                    room_info.setAttribute('style', 'width:45%;float:left');
                    room_separator.setAttribute('class', 'room_separator');

                    room_img.innerHTML = '<img src="img/room_list_1.jpg" style="width:40%;float:left">';
                    room_price.innerHTML = '<a href="room_detail.html?id=' + this.id + ' class="btn_slider ls-l" style="align: center; text-align: center; top:62%; left:50%; margin: 45% -20%;" data-ls="durationin:2000;delayin:1300;easingin:easeOutElastic;"><h1 align="center">' + this.price + '$</h1><span>per night</span></a>';
                    room_info.innerHTML = '<span class="name"><h2>' + this.name + '</h2>' +
                        '</span><p>' + this.shortDescription + '</p>';
                    room_separator.innerHTML = '<div style=" width:100%; height:10px; clear:both;"></div>';

                    room.appendChild(room_img);
                    room.appendChild(room_price);
                    room.appendChild(room_info);
                    top_five.appendChild(room_separator);
                    top_five.appendChild(room);
                    top_five.appendChild(room_separator);
                }
            })
        },
        error: function(){
            alert("ERROR");
        }
    })
});