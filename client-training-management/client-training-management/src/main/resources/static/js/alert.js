//VALIDATING FORM
function validationForm(action) {
    var forms = document.querySelectorAll('.needs-validation');

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
            .forEach(function (form) {
                    if (form.checkValidity()) {
                        action();
                    };
                    form.classList.add('was-validated');
                });
}

function successAlert(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
//        didOpen: (toast) => {
//            toast.addEventListener('mouseenter', Swal.stopTimer)
//            toast.addEventListener('mouseleave', Swal.resumeTimer)
//        }
    })

    Toast.fire({
        icon: 'success',
        title: message
    });
}

function errorAlert(message) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    Toast.fire({
        icon: 'error',
        title: message
    });
}

function questionAlert(title, text, textConfirmButton, deleteFunction) {
    Swal.fire({
        title: title,
        text: text,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: textConfirmButton,
        cancelButtonText: 'Back'
    }).then((result) => {
        if (result.isConfirmed) {
            deleteFunction();
        }
    });
}

//LOGIN
//function login() {
//    const Toast = Swal.mixin({
//        toast: true,
//        position: 'top-end',
//        showConfirmButton: false,
//        timer: 3000,
//        timerProgressBar: true,
//        didOpen: (toast) => {
//            toast.addEventListener('mouseenter', Swal.stopTimer)
//            toast.addEventListener('mouseleave', Swal.resumeTimer)
//        }
//    })
//
//    Toast.fire({
//        icon: 'success',
//        title: 'Signed in successfully'
//    });
//}

//LOGOUT
$(document).on('click', '#logoutButton', function (e) {
    e.preventDefault();
    let link = $(this).attr('href');
    console.log("logout");
    Swal.fire({
        title: 'Are you sure?',
//            text: "You won't be able to revert this!",
        toast: true,
        icon: 'warning',
        position: 'top-end',
//        width: '350px',
//                height:'900px',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location = link;
        }
    });
});

