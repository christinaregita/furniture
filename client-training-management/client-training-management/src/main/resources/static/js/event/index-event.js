let event = new Object();
let id = 0;
let ids = 0;
let userId = 0;

//FOR PAGINATION
let totalRecords = 0;
let records = [];
let displayRecords = [];
let recPerPage = 6;
let page = 1;
let totalPages = 0;

$(document).ready(() => {
    getUserId();
    
    getEventCard();

    $("#register").click(e => {
        regis();
    });

    $("#createForm").click(e => {
//        e.preventDefault();
        validationForm(create);
    });

    $("#editForm").click(e => {
//        e.preventDefault();
        validationForm(update);
    });
});

function getEventCard() {
    $.ajax({
          url: '/catalog/get-all',
          type: 'GET',
          async: true,
          dataType: 'json',
          success: function (data) {
                      records = data;
                      console.log(records);
                      totalRecords = records.length;
                      totalPages = Math.ceil(totalRecords / recPerPage);
                      apply_pagination();
          }
    });
}

function generate_card() {
      let div;
      let eventDate;
      $('#cardEvent').html('');
      for (var i = 0; i < displayRecords.length; i++) {
            
            eventDate = moment(displayRecords[i].schedule.date).format('ddd, MMMM Do, YYYY');
            div=(`<div class="col">
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal" onclick="getById('${displayRecords[i].id}')">
                                <div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="css/images/event1.png" alt="..." />
                            </a>
                            
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">
                                    <label>${displayRecords[i].name}</label></div>
                                <div class="portfolio-caption-subheading text-muted">
                                    <label>${displayRecords[i].category.name}</label></div>
                                <div class="portfolio-caption-subsubheading text-muted">
                                    <label>${eventDate}</label></div>       
                            </div>
                        </div>
                            
                            `);
            $('#cardEvent').append(div);
      }
}

function apply_pagination() {
      $("#catalogPage").twbsPagination({
            totalPages: totalPages,
            visiblePages: 6,
            onPageClick: function (event, page) {
                  displayRecordsIndex = Math.max(page - 1, 0) * recPerPage;
                  endRec = (displayRecordsIndex) + recPerPage;
                 
                  displayRecords = records.slice(displayRecordsIndex, endRec);
                  generate_card();
            }
      });
}

function getById(id) {
    $.ajax({
        url: `/catalog/${id}`,
        type: 'GET',
        success: (res) => {
            setText(res);
            }
        });
    return id;
    }

function getByIdUpdate(id) {
    $.ajax({
        url: `/catalog/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
//            setText(res);
        }
    });
}

function create() {
    event = {
        id: 14,
        name: $("#event-name").val(),
        description: $("#event-desc").val(),
        trainer: $("#event-trainer").val(),
        quota: $("#event-quota").val(),
//        applicant: $("#event-applicant").val(),
        requirement: $("#event-req").val(),
        point: $("#event-point").val(),
        categoryId: $("#event-categoryId").val(),
        date: $("#event-date").val(),
        startTime: $("#event-start").val(),
        endTime: $("#event-end").val(),
        location: $("#event-loc").val(),
        isOnline: $("#event-isOnline").val()

//        statusEvent: {
//            id: $("#province-id").val(),
//            name: $("#province-id").val()
//        }

    };
    $.ajax({
        url: "/catalog",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(event),
        success: (res) => {
            $("#create-event").modal("hide");
//            window.location.reload();
            table.ajax.reload();
            successAlert("Event Created");
        },
        error: (err) => {
            errorAlert("Event failed created");
        }
    });
}

function update() {
    event = {
//        id: id,
        name: $("#event_Name").val(),
        description: $("#event_desc").val(),
        trainer: $("#event_trainer").val(),
        quota: $("#event_quota").val(),
//        applicant: $("#applicant").val(),
        requirement: $("#event_req").val(),
        point: $("#event_point").val(),
        category: {
            id: $("#category_Id").val()
        },
        schedule: {
            scheduleId: ids,
            date: $("#event_Date").val(),
            startTime: $("#event_Start").val(),
            endTime: $("#event_End").val(),
            location: $("#event_Loc").val(),
            isOnline: $("#eventIsOn").val()
        },
        statusEvent: {
            id: 1
        }
    };

    id = ids;
    $.ajax({
        url: `/catalog/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(event),
        success: (res) => {
            $("#update-event").modal("hide");
//            window.location.reload();
            table.ajax.reload();
            successAlert("Event Updated");
//            toggleValidation();
        },
        error: (err) => {
            errorAlert("Event failed updated");
        }
    });
}


function softDelete(id) {

    questionAlert("Are you sure?", "Do you want to cancel this event?", "Yes, cancel it", function () {
        $.ajax({
            url: `/catalog/${id}`,
            type: 'DELETE',

            success: (res) => {
                window.location.reload();
                successAlert("Event success cancelled");
            },
            error: (err) => {
                errorAlert("Event failed cancelled");
            }
        });
    });
}


function setForm(data) {
//    $("#eventId").val(data.id);
    ids = data.id;
    $("#event_Name").val(data.name);
    $("#event_desc").val(data.description);
    $("#event_trainer").val(data.trainer);
    $("#event_quota").val(data.quota);
//    $("#applicant").val(data.applicant);
    $("#event_req").val(data.requirement);
    $("#event_point").val(data.point);
    $("#category_Id").val(data.category.id);
//    $("#scheduleId").val(data.schedule.scheduleId);
    $("#event_Date").val(data.schedule.date);
    $("#event_Start").val(data.schedule.startTime);
    $("#event_End").val(data.schedule.endTime);
    $("#event_Loc").val(data.schedule.location);
//    $("#eventIsOn").val(data.schedule.isOnline);
//    $("#statusEventId").val(data.statusEvent.id);
}

function setText(data) {
    id = data.id;
    $("#viewApplicantLink").attr("href", `/catalog/applicant/${id}`);
    $("#eventId").text(data.id);
    $("#eventName").text(data.name);
    $("#description").text(data.description);
    $("#trainer").text(data.trainer);
    $("#quota").text(data.quota);
    $("#applicant").text(data.applicant);
    $("#requirement").text(data.requirement);
    $("#point").text(data.point);
    $("#categoryId").text(data.category.id);
    $("#categoryName").text(data.category.name);
    $("#scheduleId").text(data.schedule.scheduleId);
    $("#eventDateTime").text(moment(data.schedule.date+" "+data.schedule.startTime).format('dddd, D MMMM YYYY, HH:mm'));
//    $("#eventStart").text(data.schedule.startTime);
    $("#eventEndTime").text(moment(data.schedule.date+" "+data.schedule.endTime).format('HH:mm'));
    $("#eventLoc").text(data.schedule.location);
    $("#eventIsOn").text(data.schedule.isOnline);
    $("#statusEventId").text(data.statusEvent.id);
}


function regis() {
    registration = {
//        id: 6,
        employee: {
            id: userId
        },
        event: {
            id: id
        }
    };
    $.ajax({
        url: "/registration",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(registration),
        success: (res) => {
            $("#portfolioModal").modal("hide");
            successAlert("Registration success");
        },
        error: (err) => {
            errorAlert("Registration failed");
        }
    });
}

function getUserId() {
    $.ajax({
        url: "/userId",
        type: 'GET',
//        contentType: 'application/json',
//        data: JSON.stringify(registration),
        success: (res) => {
            userId = res;
        },
        error: (err) => {
        }
    });
}

//FUNCTION TO CLEAR VALIDATION AFTER CLOSING MODAL
function toggleValidation() {
    var element = document.querySelector(".was-validated");
    
    if(element!==null){
        element.classList.toggle("was-validated");
    }
}