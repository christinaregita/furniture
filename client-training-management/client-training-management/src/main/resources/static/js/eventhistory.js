let table = null;

$(document).ready(() => {
    getAll();
});

function getAll() {
    table = $('#history').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/eventhistory/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "id", name: "No", autoWidth: true
            },
            {
                data: "name", name: "Event", autoWidth: false, width:"50%"
            },
            {
                data: "schedule.date", name: "Tanggal", autoWidth: true,
                render: function (data) {
                    return moment(data).format('ddd, D MMMM YYYY');
                }
            },
            {
                data: "statusEvent.name", name: "Status", autoWidth: true
            },
            {
                data: "statusEvent.name", name: "action", autoWidth: true,
                render: (data, type, row, meta) => {
                    if (data === 'Done') {
                        return`
                        <p class="test-btn"><a href="/eventhistory/presence/${row.id}">
                        <i class="fa fa-list-ol" aria-hidden="true"></i> presence</a>
                        </p>
                        `;
                    } else {
                        return "";
                    }
                }
            }
        ]
    });
    table.on('order.dt search.dt', function () {
        table.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    table
            .order([2, 'asc'])
            .draw();

}