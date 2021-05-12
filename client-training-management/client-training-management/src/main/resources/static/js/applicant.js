$(document).ready(() => {
//    $("#approval-row").click(e => {
//        console.log('ganti');
//    });
//    document.querySelectorAll(".approval-btn").addEventListener('click', ()=>{
//        console.log("ganti")
//    })
});

function getApplicant(eventId) {
    table = $('#applicantTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: `/catalog/applicant/${eventId}/get-all`,
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "registrationId", name: "No", autoWidth: true
            },
            {
                data: "applicantName", name: "Employee Name", autoWidth: true
            },
            {
                data: "applicantJob", name: "Employee Job", autoWidth: true
            },
            {
                data: "applicantDept", name: "Employee Dept", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return`
                    <div id='approval-btn'>
                        <button class='btn btn-sm btn-primary'
                                onclick="approval('${row.registrationId}',2)">
                                <i class="fas fa-user-check"></i>
                            </button>
                        <button class='btn btn-sm btn-danger' 
                                onclick="approval('${row.registrationId}',3)">
                                <i class="fas fa-user-times"></i>
                            </button>
                    </div>
                        `;
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
            .order([0, 'asc'])
            .draw();
}

function approval(regId, statusId) {
    $.ajax({
        url: `registration/${regId}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({id: statusId}),
        success: (res) => {
            $("#approval-btn").html( res.statusRegistration.id === 2? "Approved" : "Rejected")
        }
    });
}