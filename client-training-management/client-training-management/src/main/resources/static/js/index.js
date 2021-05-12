$(document).ready(() => {
    getUserName();
});

function getUserName() {
    console.log("test");
    $.ajax({
        url: '/profile/name',
        type: 'GET',
        success: (res) => {
            $("#welcomeProfile").text(res);
        }
    });
}