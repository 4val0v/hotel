document.addEventListener("DOMContentLoaded", function() {
    var doc = document;
    $.ajax({
        type: 'GET',
        dataType: "json",
        url: 'http://practice.relex.ru:81/api/feedback',
        success: function (data, json) {
            var fdbck = doc.getElementById("feedback");

            $.each(data, function () {
                var message = doc.createElement('div'),
                    msg_theme = doc.createElement('div'),
                    msg_content = doc.createElement('div'),
                    msg_email = doc.createElement('a');

                message.setAttribute('class', 'message');
                msg_theme.setAttribute('class', 'theme');
                msg_content.setAttribute('class', 'content');
                msg_email.setAttribute('class', 'email');

                msg_theme.innerHTML = '<div><h3>Theme: ' + this.theme + '</h3></div>';
                msg_content.innerHTML = '<div><p>' + this.message + '</p></div>';
                msg_email.innerHTML = '<div><p>Email: ' + this.email + '</p></div>';

                message.appendChild(msg_theme);
                message.appendChild(msg_content);
                message.appendChild(msg_email);
                fdbck.appendChild(message);
                fdbck.appendChild(doc.createElement('hr'));
            })
        },
        error: function() {
            alert("ERROR");
        }
    })
});

