let table = null;

$(document).ready(() => {
    getEventTable();
});

function getEventTable() {
    table = $('#catalogadmin').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: `/catalog/get-all`,
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "id", name: "No", autoWidth: true
            },
            {
                data: "name", name: "Event Name", autoWidth: true
            },
            {
                data: "category.name", name: "Category", autoWidth: true
            },
//            {
//                data: "description", name: "Description", autoWidth: false, width: "300%"
//            },
//            {
//                data: "requirement", name: "Requirement", autoWidth: true
//            },
            {
                data: "point", name: "Point", autoWidth: true
            },
            {
                data: "trainer", name: "Trainer", autoWidth: true
            },
            {
                data: "schedule.date", name: "Date", autoWidth: false, width:"15%",
                render: (data, type, row, meta) => {
                    return moment(data).format('ddd, D MMM YY');
                }
            },
            {
                data: "schedule.startTime", name: "Time", autoWidth: false, width:"15%",
                render: (data, type, row, meta) => {
                    startTime = moment(row.schedule.date + " " + data).format('HH:mm');
                    endTime = moment(row.schedule.date + " " + row.schedule.endTime).format('HH:mm')
                    return startTime + " - " + endTime;
                }
            },
//            {
//                data: "schedule.location", name: "Location", autoWidth: false, width: "5%"
//            },
            {
                data: "quota", name: "Quota", autoWidth: true
            },
            {
                data: "countPendingApp", name: "Pending Applicants", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return`
                        <button 
                            id="viewDetails" 
                            type="button" 
                            class="btn btn-info"
                            data-toggle="modal" 
                            data-target="#portfolioModal"
                            onclick="getById('${row.id}')">
                            <i class="far fa-eye"></i>    
                        </button>
                        <button 
                            class='btn btn-primary'
                            data-toggle="modal" 
                            data-target="#update-event"
                            onclick="getByIdUpdate('${row.id}')"> 
                            <i class="fas fa-edit"></i>
                        </button>
                        <button 
                            class='btn btn-danger'
                            onclick="softDelete('${row.id}')">
                            <i class='fas fa-trash'></i>
                        </button>
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
            .order([1, 'asc'])
            .draw();

}


