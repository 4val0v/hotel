$(document).ready(function() {

    var localURL = "http://localhost/api/ordermanager/";
    var remoteURL = "http://practice.relex.ru:81/api/ordermanager/";
    var id;
    var phone;
    var name;

    $("#tbl-manager").DataTable({
        responsive: true
    });

    $("#btn-search").prop("disabled", true);

    /**
     * Check form fields for change state of button "Поиск"
     */
    $("#search-form").keyup(function() {
        $("#btn-search").prop("disabled", true);
        id = $("#orderId").val().trim();
        phone = $("#phone").val().trim();
        name = $("#name").val().trim();
        if ((id != "" || phone != "" || name != "")) {
            $("#btn-search").prop("disabled", false);
        }
    });


    /**
     * Get all orders and insert it to table. Button "Получить все записи"
     */
    $("#btn-getAll").click(function () {
        $.ajax({
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            url: remoteURL,
            // url: localURL,
            success: function (data) {
                console.log("SUCCESS: ", data);
                CreateManagerTable(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                alert("Ошибка");
            }
        })
    });

    /**
     *  Get orders from search and insert it to table. Button "Поиск"
     */
    $("#btn-search").click(function() {
        if (!/\D/.test(id)) {
            var searchURL = remoteURL + "?id=" + id + "&phone=" + phone + "&name=" + name;
            // var searchURL = localURL + "?id=" + id + "&phone=" + phone + "&name=" + name;
            searchURL = searchURL.replace("+", "%2B");
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: searchURL,
                dataType: "json",
                success: function (data) {
                    console.log("SUCCESS: ", data);
                    if (data.length != 0) {
                        CreateManagerTable(data);
                    }
                    else {
                        alert("Ничего не найдено")
                    }
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                    alert("Ошибка");
                }
            })
        }
        else {alert("№ брони может состоять только из цифр")}
        document.getElementById("search-form").reset();
        $("#btn-search").prop("disabled", true);
    });

    /**
     * Create table from json object
     * @param data - json object
     */
    function CreateManagerTable(data) {
        // $("#tbl-manager td").parent().remove();
        $("#tbl-manager").DataTable().clear();
        for (var i = 0; i < data.length; i++) {
            $("#tbl-manager").DataTable().row.add([
                data[i].id,
                data[i].roomDto.id,
                data[i].statusType,
                data[i].dateCheckIn,
                data[i].dateCheckOut,
                data[i].greetingName,
                data[i].mail,
                data[i].phone,
                data[i].countAdults,
                data[i].countChildren
                ]).draw();
        }
    }
});











