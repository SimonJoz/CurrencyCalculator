$(document).ready(function () {
    $('#getRate').on('click', function () {
        this.disabled = true;
        this.form.submit();
    });

    let width = 0;
    let element = $(".progress-bar");
    let id = setInterval(function () {
        element.width(width + "%");
        if (width <= 100) {
            element.text(width + "%");
        }
        if (width >= 101) {
            clearInterval(id);
        }
        width++;
    }, 80);


    setTimeout(function () {
        $("#infoMsg").hide()
    }, 9000);

});