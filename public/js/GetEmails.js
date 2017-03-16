document.addEventListener("DOMContentLoaded", function() {
    var doc = document;
    $.ajax({
        type: 'GET',
        dataType: "json",
        url: 'http://practice.relex.ru:81/api/emails',
        success: function (data) {
            var email_list = doc.getElementById('email_list');

            var emailList = doc.createElement('div'),
                email_button = doc.createElement('span');

            var str = '';

            $.each(data, function() {
                var email = doc.createElement('div'),
                    email_address = doc.createElement('span');
                email_address.innerHTML = '<a href=mailto:' + this.email + '>' + this.email + '</a>';
                email.appendChild(email_address);
                emailList.appendChild(email);

                str = str + this.email.toString() + ', ';
            });
            email_button.innerHTML = '<button href="mailto:' + str + '">Написать всем</button>';
            emailList.appendChild(email_button);
        },
        error: function () {
            alert("ERROR");
        }
    })
});
