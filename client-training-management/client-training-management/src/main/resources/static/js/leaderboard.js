let table = null;

$(document).ready(() => {
    getAll();
});

function getAll() {
    table = $('#leadTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/leaderboard/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "employeeId", name: "Employee Id", autoWidth: true
            },
            {
                data: "employeeName", name: "Employee Name", autoWidth: true
            },
            {
                data: "point", name: "Point", autoWidth: true
            },
        ]
    });
    table.on('order.dt search.dt', function () {
        table.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    table
    .order( [ 2, 'desc' ] )
    .draw();

}