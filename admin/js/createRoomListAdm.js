$(document).ready(function() {
    $('#dataTables-example tbody').on('click', 'tr', function () {
        var table = $('#dataTables-example').DataTable();
        var data = table.row( this ).data();
        location.replace('http://practice.relex.ru:81/admin/room-details-adm.html?id=' + data[0]);
    } );
});

document.addEventListener("DOMContentLoaded",function(){
    var doc = document;
/*    var t = $('#dataTables-example').DataTable();*/

    $.ajax({
        type:'GET',
/*        url: 'http://localhost/practice-web/rooms/' ,*/
        url: 'http://practice.relex.ru:81/api/rooms/' ,
        success: function(data, json){
        var rooms = doc.getElementById('content_rooms');
    $.each(data, function(){
                    var t = $('#dataTables-example').DataTable();
                    var booked = 'not booked';
                    if(this.isBooked){
                        booked = 'booked'
                    }
                    var shown = 'not shown';
                    if(this.isShown){
                        shown = 'shown'
                    }
                    t.row.add( [
                        '' + this.id,
                        this.name,
                        this.shortDescription,
                        '' + this.price,
                        booked,
                        shown,
                        this.ratingAvg
                    ] ).draw( false );
            });                                                    
    }
    });

    $('#room-mode-button').on('click', function() {
        this.checked = this.checked ? false : true;
        $('#dataTables-example tbody').off();
        if (this.checked) {
            this.innerHTML = 'Mode Select';
            $('#room-delete-button').css('visibility', 'visible');
            $('#dataTables-example tbody').on( 'click', 'tr', function () {
                $(this).toggleClass('active');
            } );
        } else {
            this.innerHTML = 'Mode Edit';
            $('#room-delete-button').css('visibility', 'hidden');
            $('#dataTables-example tbody').on('click', 'tr', function () {
                var t = $('#dataTables-example').DataTable();
                var data = t.row( this ).data();
                location.replace('http://practice.relex.ru:81/admin/room-details-adm.html?id=' + data[0]);
            } );
        }
    });

    $('#room-delete-button').on('click', function() {
        var t = $('#dataTables-example').DataTable();
        $.each(t.rows('.active').data(), function() {
            $.ajax({
                type:'GET',
/*                url: 'http://localhost/practice-web/api/rooms/remove?id=' + this[0],*/
                url: 'http://practice.relex.ru:81/api/api_rooms/remove?id=' + this[0],
                success: function(data){
                    alert(data);
                },
                error: function(textStatus) { 
                    alert("Error: " + textStatus.status + ", " +
                          "Text: " + textStatus.responseText); 
                }
            });
        });
    });

    $('#room-add-button').on('click', function() {
        location.replace('http://practice.relex.ru:81/admin/room-details-adm.html?id=0');
    });
});
