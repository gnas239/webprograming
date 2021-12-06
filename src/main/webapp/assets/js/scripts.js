$(document).ready(function () {
    $("#menu").load("leftside-menu.html");
    $("#content").load("user.html");
    $(document).on("click", "#users", function () {
        $("#content").load("user.html");
    });
    $(document).on("click", "#products", function () {
        $("#content").load("product.html");
    });
    $(document).on("click", "#orders", function () {
        $("#content").load("orders.html");
    });
});
