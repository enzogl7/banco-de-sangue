$(document).ready(function () {
    $('#infoDropdown').tooltip({
        trigger: 'hover',
        delay: { "show": 500, "hide": 100 }
    });
});

$('.custom-file-input').on('change', function (e) {
    var fileName = e.target.files[0].name;
    $(this).next('.custom-file-label').html(fileName);
});
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})
