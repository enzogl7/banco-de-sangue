package com.intergrarh.banco_sangue.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.intergrarh.banco_sangue.model.Candidato;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

@Service
public class CandidatoService {
    private final DecimalFormat formato = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));

    private int calcularIdade(String dataNasc) {
        String[] partesData = dataNasc.split("/");
        int anoNascimento = Integer.parseInt(partesData[2]);
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        return anoAtual - anoNascimento;
    }

    public List<Candidato> extrairCandidatos(JsonNode rootNode) {
        List<Candidato> candidatos = new ArrayList<>();
        if (rootNode.isArray()) {
            for (JsonNode candidatoNode : rootNode) {
                Candidato candidato = new Candidato(
                        candidatoNode.get("nome").asText(),
                        candidatoNode.get("sexo").asText(),
                        candidatoNode.get("estado").asText(),
                        candidatoNode.get("peso").asDouble(),
                        candidatoNode.get("altura").asDouble(),
                        candidatoNode.get("data_nasc").asText(),
                        candidatoNode.get("tipo_sanguineo").asText());
                candidatos.add(candidato);
            }
        }
        return candidatos;
    }

    public Map<String, Integer> calcularCandidatosPorEstado(List<Candidato> candidatos) {
        Map<String, Integer> candidatosPorEstado = new HashMap<>();
        for (Candidato candidato : candidatos) {
            candidatosPorEstado.put(candidato.getEstado(), candidatosPorEstado.getOrDefault(candidato.getEstado(), 0) + 1);
        }
        return candidatosPorEstado;
    }

    public Map<String, Double> calcularImcMedioPorFaixaEtaria(List<Candidato> candidatos) {
        Map<String, List<Double>> imcPorFaixaEtaria = new LinkedHashMap<>();

        for (int i = 0; i <= 70; i += 10) {
            String faixa = i + " a " + (i + 10);
            imcPorFaixaEtaria.put(faixa, new ArrayList<>());
        }

        for (Candidato candidato : candidatos) {
            int idade = calcularIdade(candidato.getDataNasc());
            int faixaInicio = Math.min((idade / 10) * 10, 70);
            String faixa = faixaInicio + " a " + (faixaInicio + 10);
            double imc = candidato.getPeso() / (candidato.getAltura() * candidato.getAltura());
            imcPorFaixaEtaria.get(faixa).add(imc);
        }

        Map<String, Double> imcMedioPorFaixa = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : imcPorFaixaEtaria.entrySet()) {
            List<Double> imcs = entry.getValue();
            if (!imcs.isEmpty()) {
                double media = imcs.stream().mapToDouble(Double::doubleValue).average().orElse(0);
                BigDecimal mediaFormatada = new BigDecimal(media).setScale(2, RoundingMode.HALF_UP);
                imcMedioPorFaixa.put(entry.getKey(), mediaFormatada.doubleValue());
            } else {
                imcMedioPorFaixa.put(entry.getKey(), 0.0);
            }
        }

        return imcMedioPorFaixa;
    }

    public Map<String, Double> calcularPercentualObesosPorSexo(List<Candidato> candidatos) {
        Map<String, Integer> obesosPorSexo = new HashMap<>();
        Map<String, Integer> totalPorSexo = new HashMap<>();

        for (Candidato candidato : candidatos) {
            double imc = candidato.getPeso() / (candidato.getAltura() * candidato.getAltura());
            if (imc > 30) {
                obesosPorSexo.put(candidato.getSexo(), obesosPorSexo.getOrDefault(candidato.getSexo(), 0) + 1);
            }
            totalPorSexo.put(candidato.getSexo(), totalPorSexo.getOrDefault(candidato.getSexo(), 0) + 1);
        }

        Map<String, Double> percentualObesosPorSexo = new HashMap<>();
        for (String sexo : obesosPorSexo.keySet()) {
            double percentual = (double) obesosPorSexo.get(sexo) / totalPorSexo.get(sexo) * 100;
            percentualObesosPorSexo.put(sexo, Double.valueOf(formato.format(percentual)));
        }

        return percentualObesosPorSexo;
    }

    public Map<String, Double> calcularMediaIdadePorTipoSanguineo(List<Candidato> candidatos) {
        Map<String, List<Integer>> idadesPorTipoSanguineo = new HashMap<>();
        for (Candidato candidato : candidatos) {
            int idade = calcularIdade(candidato.getDataNasc());
            idadesPorTipoSanguineo.computeIfAbsent(candidato.getTipoSanguineo(), k -> new ArrayList<>()).add(idade);
        }

        Map<String, Double> mediaIdadePorTipoSanguineo = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : idadesPorTipoSanguineo.entrySet()) {
            double somaIdades = 0;
            for (int idade : entry.getValue()) {
                somaIdades += idade;
            }
            double valorfinal =  somaIdades / entry.getValue().size();
            mediaIdadePorTipoSanguineo.put(entry.getKey(), Double.valueOf(formato.format(valorfinal)));
        }

        return mediaIdadePorTipoSanguineo;
    }

    public Map<String, Integer> calcularDoadoresPorTipoSanguineo(List<Candidato> candidatos) {
        Map<String, Integer> doadoresPorTipoSanguineo = new HashMap<>();

        for (Candidato candidato : candidatos) {
            int idade = calcularIdade(candidato.getDataNasc());
            double peso = candidato.getPeso();

            if (idade >= 16 && idade <= 69 && peso > 50) {
                String tipoSanguineo = candidato.getTipoSanguineo();
                doadoresPorTipoSanguineo.put(tipoSanguineo, doadoresPorTipoSanguineo.getOrDefault(tipoSanguineo, 0) + 1);
            }
        }

        return doadoresPorTipoSanguineo;
    }
}
