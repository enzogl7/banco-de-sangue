// INICIALIZACOES
$(document).ready(function () {
    $('#infoDropdown').tooltip({
        trigger: 'hover',
        delay: { "show": 500, "hide": 100 }
    });
    $('html, body').animate({ scrollTop: 0 }, 'fast');
});
$('.custom-file-input').on('change', function (e) {
    var fileName = e.target.files[0].name;
    $(this).next('.custom-file-label').html(fileName);
});
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})
$(window).scroll(function() {
    if ($(this).scrollTop() > 100) {
        $('#btnVoltarTopo').fadeIn();
    } else {
        $('#btnVoltarTopo').fadeOut();
    }
});

$('#btnVoltarTopo').click(function() {
    $('html, body').animate({scrollTop: 0}, 800);
    return false;
});

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
        beforeSend: function () {
            $("#loadingOverlay").show();
        },
        success: function(response) {
            $("#loadingOverlay").hide();
            $("#containerResultados").show();
            $("#btnEnviarOutroJson").show();
            $('html, body').animate({
                scrollTop: $("#containerResultados").offset().top
            }, 800);
            montarGraficoCandidatosEstado(response.candidatosPorEstado);
            montarGraficoPercentualObesosPorSexo(response.percentualObesosPorSexo);
            montarGraficoImcMedioPorFaixaEtaria(response.imcMedioPorFaixaEtaria);
            montarGraficoMediaIdadePorTipoSanguineo(response.mediaIdadePorTipoSanguineo);
            montarGraficoQtdeDoadoresPorTipoSanguineo(response.doadoresPorTipoSanguineo);
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

function montarGraficoCandidatosEstado(dados) {
    const estados = Object.keys(dados);
    const valores = Object.values(dados);
    const ctx = document.getElementById('graficoCandidatosEstado').getContext('2d');

    new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: estados,
            datasets: [{
                label: 'Número de Candidatos',
                data: valores,
                backgroundColor: ["#4FD1C5", "#2C7A7B", "#81E6D9", "#319795", "#38B2AC",
                    "#63B3ED", "#3182CE", "#2B6CB0", "#4299E1", "#4A5568",
                    "#718096", "#A0AEC0", "#E53E3E", "#F56565", "#C53030",
                    "#ED8936", "#DD6B20", "#F6AD55", "#D69E2E", "#ECC94B",
                    "#48BB78", "#38A169", "#276749", "#68D391", "#9F7AEA",
                    "#805AD5", "#B794F4"],
                borderRadius: 6,
                barThickness: 24
            }]
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Quantidade de candidatos em cada estado do Brasil'
            }
        }
    });
}

function montarGraficoPercentualObesosPorSexo(dados) {
    const sexo = Object.keys(dados);
    const valores = Object.values(dados);
    const ctx = document.getElementById('graficoObesidadeSexo').getContext('2d');

    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: sexo,
            datasets: [{
                label: 'Porcentagem',
                data: valores,
                backgroundColor: ["#1F8A70", "#414f55"],
                borderRadius: 6,
                barThickness: 24
            }]
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Percentual de obesos entre homens e mulheres'
            }
        }
    });
}

function montarGraficoImcMedioPorFaixaEtaria(dados) {
    const faixaEtaria = Object.keys(dados);
    const valores = Object.values(dados).map(v => Math.round(v));
    const ctx = document.getElementById('graficoImcPorIdade').getContext('2d');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: faixaEtaria,
            datasets: [{
                label: 'IMC médio',
                data: valores,
                backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
                borderRadius: 6,
                barThickness: 24
            }]
        },
        options: {
            title: {
                display: true,
                text: 'IMC médio por faixa etária'
            }
        }
    });
}

function montarGraficoMediaIdadePorTipoSanguineo(dados) {
    const tipoSanguineo = Object.keys(dados);
    const valores = Object.values(dados);
    const ctx = document.getElementById('graficoIdadePorSangue').getContext('2d');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: tipoSanguineo,
            datasets: [{
                label: 'Média de idade',
                data: valores,
                backgroundColor: ["#2A9D8F", "#E76F51", "#F4A261", "#264653", "#E9C46A", "#F1C40F", "#D35400", "#16A085"],
                borderRadius: 6,
                barThickness: 24
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Média de idade por tipo sanguíneo'
            }
        }
    });
}

function montarGraficoQtdeDoadoresPorTipoSanguineo(dados) {
    const tipoSanguineoDoadores = Object.keys(dados);
    const valores = Object.values(dados);
    const ctx = document.getElementById('graficoDoadoresSanguineos').getContext('2d');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: tipoSanguineoDoadores,
            datasets: [{
                label: 'Quantidade de doadores',
                data: valores,
                backgroundColor: ["#6366F1", "#EC4899", "#10B981","#F59E0B","#EF4444","#8B5CF6","#F97316", "#34D399"],
                borderRadius: 6,
                barThickness: 24
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Quantidade de doadores por tipo sanguíneo'
            }
        }
    });
}


