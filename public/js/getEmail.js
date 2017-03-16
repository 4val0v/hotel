function getEmail() {
    var address = {};
    address.email = $('#email_newsletter_2').val();
    addressJsn = JSON.stringify(address);
    console.log(address);
    console.log(addressJsn);
    $.ajax({
        type: 'POST',
        url: 'http://practice.relex.ru:81/api/',
        contentType: 'application/json',
        data: addressJsn,
        success: function () {
           // alert("SUCCESS");
            window.location.href = "index.html";
        },
        error: function () {
           // alert("ERROR");
        }
    })
}
