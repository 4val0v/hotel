$(document).ready(function() {

    var orders = {};
    var orderStatus = ["HOLD", "ORDERED", "CLOSED"];
    var localURL = "http://localhost:81/api/ordermanager/";
    var remoteURL = "http://practice.relex.ru:81/api/ordermanager/";

    refreshTable();
    setInterval(refreshTable, 60000);

    /**
     * Accept new order. Button "Забронировать"
     */
    $("#tbl-newOrders").on("click", ".btn-success", function () {
        var btnId = this.id;
        var orderId = extractOrderIdFromBtn(btnId);
        var currentOrder = findOrderBeforeUpdate(orderId);
        currentOrder.statusType = orderStatus[1];
        $.ajax({
            type: "POST",
            contentType: "application/json",
            // url:  remoteURL + orderId,
            url:  localURL + orderId,
            dataType: "json",
            data: JSON.stringify(currentOrder),
            success: function (data) {
                console.log(data);
                $("#row" + orderId,"#tbl-newOrders").remove();
            },
            error: function (e) {
                console.log("ERROR: ", e);
                alert("Ошибка");
            }
        });
    })

    /**
     * Cancel new order. Button "Отклонить"
     */
    $("#tbl-newOrders").on("click", ".btn-danger", function () {
        var btnId = this.id;
        var orderId = extractOrderIdFromBtn(btnId);
        $.ajax({
            type: "DELETE",
            // url:  remoteURL + orderId,
            url: localURL + orderId,
            dataType: "text",
            success: function (data) {
                console.log("SUCCESS: ", data);
                $("#row" + orderId,"#tbl-newOrders").remove();
            },
            error: function (e) {
                console.log("ERROR: ", e);
                alert("Ошибка");
            }
        })
    })

    /**
     * Create table from json object
     * @param data - Json object
     * @constructor - create table and 2 buttons in every rows
     */
    function CreateTableNewOrders(data) {
        $("#tbl-newOrders td").parent().remove();
        var tbl = document.getElementById("tbl-newOrders");
        for (var i = 0; i < data.length; i++) {
            var row = tbl.insertRow(-1);
            row.setAttribute("id", "row" + data[i].id);
            row.insertCell(0).innerHTML = data[i].id;
            row.insertCell(1).innerHTML = data[i].roomDto.id;
            row.insertCell(2).innerHTML = data[i].dateCheckIn;
            row.insertCell(3).innerHTML = data[i].dateCheckOut;
            row.insertCell(4).innerHTML = data[i].greetingName;
            row.insertCell(5).innerHTML = data[i].phone;
            var sButton = document.createElement("button");
            sButton.setAttribute("type", "button");
            sButton.setAttribute("class", "btn btn-outline btn-success");
            sButton.setAttribute("id", "sb" + data[i].id);
            sButton.innerHTML = "Забронировать";
            var cButton = document.createElement("button");
            cButton.setAttribute("type", "button");
            cButton.setAttribute("class", "btn btn-outline btn-danger");
            cButton.setAttribute("id", "cb" + data[i].id);
            cButton.innerHTML = "Отклонить";
            row.insertCell(6).appendChild(sButton);
            row.insertCell(7).appendChild(cButton);
        }
    }

    /**
     * Get json object for table
     */
    function refreshTable() {
        $.ajax({
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            // url: remoteURL + "getOrdersByStatus/" + "?random=" + new Date().getTime(),
            url: localURL + "getOrdersByStatus/" + "?random=" + new Date().getTime(),
            success: function (data) {
                console.log("SUCCESS: ", data);
                orders = data;
                CreateTableNewOrders(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                alert("Ошибка");
            }
        })
    }

    /**
     * Extract id order from button id
     * @param btnId - idButton + idOrder
     * @returns {string} - idOrder
     */
    function extractOrderIdFromBtn(btnId) {
        return btnId.substring(btnId.search(/[0-9]/), btnId.length);
    }

    /**
     * Find order which was updated
     * @param id - idOrder
     * @returns {*} - order for json
     */
    function findOrderBeforeUpdate(id) {
        for (var i = 0; i < orders.length; i++) {
            if (orders[i].id == id) {
                return orders[i];
            }
        }

    }
});
