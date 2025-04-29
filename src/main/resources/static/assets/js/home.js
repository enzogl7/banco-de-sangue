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

// FUNCOES
function habilitarInputs() {
    var jsonInput = document.getElementById("jsonInput");
    var jsonFile = document.getElementById("jsonFile");

    if (jsonInput.value.trim() !== "") {
        jsonFile.disabled = true;
    } else {
        jsonFile.disabled = false;
    }

    if (jsonFile.files.length > 0) {
        jsonInput.disabled = true;
    } else {
        jsonInput.disabled = false;
    }
}

function enviarJson() {
    var jsonInput = $("#jsonInput").val();
    var jsonArquivo = $("#jsonFile")[0];
    var formData = new FormData();

    if (jsonArquivo.files.length > 0) {
        formData.append("jsonFile", jsonArquivo.files[0]);
    } else if (jsonInput) {
        formData.append("json", jsonInput);
    }

    if (!jsonInput.trim() && !jsonArquivo) {
        Swal.fire({
            icon: "warning",
            title: "Ops!",
            text: "Preencha ao menos um dos campos!",
        });
        return;
    }

    $.ajax({
        url: '/processarjson',
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        success: function(response) {
            $("#containerResultados").show();
            console.log(response)
        },
        error: function(xhr, status, error) {
            Swal.fire({
                icon: "error",
                title: "Erro!",
                text: "Ocorreu um erro ao processar os dados do JSON.",
            });
        }
    });
}
