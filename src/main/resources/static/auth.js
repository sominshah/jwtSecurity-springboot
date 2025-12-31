$.ajaxSetup({
    beforeSend: function (xhr) {
        const token = localStorage.getItem("jwt_token");
        if (token) {
            xhr.setRequestHeader("Authorization", "Bearer " + token);
        }
    },
        statusCode: {
            401: function () {
                localStorage.removeItem("jwt_token");
                window.location.replace("/login.html");
            }
        }
});
