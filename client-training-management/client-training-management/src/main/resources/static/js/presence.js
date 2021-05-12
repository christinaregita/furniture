let table = null;
//
//$(document).ready(() => {
//    getAll();
//
//    getUserId();
//});

function getAll(id) {
    table = $('#presence').DataTable({
        filter: true,
        orderMulti: true,

        ajax: {
            url: `/eventhistory/presence/get-all/${id}`,
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "presenceId", name: "No", autoWidth: true
            },
            {
                data: "approvedName", name: "Employee Name", autoWidth: true
            },
            {
                data: "approvedDept", name: "Department", autoWidth: true
            },
            {
                data: "statusPresence", name: "Status", autoWidth: true
            },
            {
                data: "presenceId", name: "Status", autoWidth: true
            },
        ],
        'columnDefs': [
            {
                'targets': 4,
                'checkboxes': {
                    'selectRow': true
                }
            }
        ],
        'select': {
            'style': 'multi'
        },
    });
    table.on('order.dt search.dt', function () {
        table.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    table
            .order([1, 'asc'])
            .draw();



}


function presenceYes(id) {
    $.ajax({
        url: `yes/${id}`,
        type: 'PUT',
//        contentType: 'application/json',
//        data: JSON.stringify({id: statusId}),
        success: (res) => {
            table.ajax.reload();
            successAlert("Success");
        },
        error: (err) => {
            errorAlert("Failed");
        }
    });
}


function presenceNo(id) {
    $.ajax({
        url: `no/${id}`,
        type: 'PUT',
//        contentType: 'application/json',
//        data: JSON.stringify({id: statusId}),
        success: (res) => {
            table.ajax.reload();
            successAlert("Success");
        },
        error: (err) => {
            errorAlert("Success");
        }
    });
}

function submitPresenceYes() {
    questionAlert("Are you sure?", "Do you want to submit?", "Yes, submit", function () {
            var rows_selected = table.column(4).checkboxes.selected();
            var i;
            for (i = 0; i < rows_selected.length; i++) {
                presenceYes(rows_selected[i]);
            }
        });
}

function submitPresenceNo() {
    questionAlert("Are you sure?", "Do you want to submit?", "Yes, submit", function () {
        var rows_selected = table.column(4).checkboxes.selected();
        var i;
        for (i = 0; i < rows_selected.length; i++) {
            presenceNo(rows_selected[i]);
        }
    });
}