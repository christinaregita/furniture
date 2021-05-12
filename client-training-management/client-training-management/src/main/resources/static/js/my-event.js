let table = null;
let userId = 0;
let id = 0;
$(document).ready(() => {

    getUserId();
});

function getById(id) {
    
    table = $('#my-event').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: `/myevent/${id}`,
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "id", name: "id", autoWidth: true
            },
            {
                data: "eventName", name: "eventName", autoWidth: true
            },
            {
                data: "date", name: "Date", autoWidth: true,
                render: function (data) {
                    return moment(data).format('ddd, D MMM YY');
                }
            },
            {
                data: "startTime", name: "start", autoWidth: true,
                render: (data, type, row, meta) => {
                    return moment(row.date + " " + data).format('HH:mm');
                }
            },
            {
                data: "status", name: "Status", autoWidth: true
            },
            {
                data: "point", name: "point", autoWidth: true
            },
        ]
    });
    table.on('order.dt search.dt', function () {
        table.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    table
            .order([2, 'desc'])
            .draw();

}

function getUserId() {
    $.ajax({
        url: "/userId",
        type: 'GET',
//        contentType: 'application/json',
//        data: JSON.stringify(registration),
        success: (res) => {
//            $("#modal-id").modal("hide");
            console.log(res);
            userId = res;
            getById(res);
        },
        error: (err) => {
        }
    });
}
