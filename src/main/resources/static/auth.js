$.ajaxSetup({
    beforeSend: function (xhr) {
        const token = localStorage.getItem("jwt_token");
        if (token) {
            xhr.setRequestHeader("Authorization", "Bearer " + token);
        }
    }
});
