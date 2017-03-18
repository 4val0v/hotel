document.addEventListener("DOMContentLoaded", function() {
    var doc = document;
    $.ajax({
        type: 'GET',
        dataType: "json",
        url: 'http://localhost:81/api/main/fdbck',
        success: function (data) {

            var feedbacks = doc.getElementById('feedbacks');

            $.each(data, function() {
                var message = doc.createElement('div'),
                    msg = doc.createElement('div'),
                    msg_img = doc.createElement('div'),
                   msg_separator = doc.createElement('div');
                message.setAttribute('class', 'box_overlay');
                msg.innerHTML = '<div class="comment"><p>' + this.message + '</p></div>';
                msg_img.innerHTML = '<div style="float: left"><img src="img/avatar1.jpg" alt="" class="img-circle"></div>';
                msg_separator.innerHTML = '<div style=" width:100%; height:10px; clear:both;"></div>';
                message.appendChild(msg_img);
                message.appendChild(msg);
                feedbacks.appendChild(msg_separator);
                feedbacks.appendChild(message);
            })
        },
        error: function() { alert("ERROR") }
    })
});
