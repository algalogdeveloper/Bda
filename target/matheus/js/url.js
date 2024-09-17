jQuery(document).ready(function () {
    jQuery(".link").click(function () {
        window.location = jQuery(this).attr("data-url");
        return false;
    });
});