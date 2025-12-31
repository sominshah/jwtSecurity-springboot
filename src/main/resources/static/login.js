$(document).ready(function ()
{
         const token = localStorage.getItem("jwt_token");
        if (token) {
            // User already logged in
            window.location.replace("/home.html");
        }


    $("#loginForm").submit(function (e) {
        e.preventDefault();
        $("#errorMsg").addClass("d-none").text("");
        const loginPayload = {
            username: $("#username").val().trim(),
            password: $("#password").val().trim()
        };

        $.ajax({
            url: "/login",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(loginPayload),
            success: function (response) {
                                 // Store JWT securely
                                 console.log("Storing Token: "+response)
                                localStorage.setItem("jwt_token", response);
                                // Redirect to home
                                window.location.href = "/home.html";
                                            },
            error: function (xhr)
            {
                if (xhr.status === 400) {
                    // Business validation error
                    $("#errorMsg")
                        .removeClass("d-none")
                        .text(xhr.responseText);
                } else if (xhr.status === 401) {
                    $("#errorMsg")
                        .removeClass("d-none")
                        .text("Invalid password.");
                } else {
                    $("#errorMsg")
                        .removeClass("d-none")
                        .text("Something went wrong. Please try again.");
                }
            }
        });
    });

});
