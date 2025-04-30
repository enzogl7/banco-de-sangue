package com.intergrarh.banco_sangue.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intergrarh.banco_sangue.model.Candidato;
import com.intergrarh.banco_sangue.service.CandidatoService;
import com.intergrarh.banco_sangue.service.TipoSanguineoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProcessamentoController {

    @Autowired
    private CandidatoService candidatoService;
    @Autowired
    private TipoSanguineoService tipoSanguineoService;

    @PostMapping("/processarjson")
    public ResponseEntity<Map<String, Object>> processarJson(@RequestParam(required = false) String json, @RequestParam(required = false) MultipartFile jsonFile) throws IOException {
            String jsonData = null;
            if (jsonFile != null && !jsonFile.isEmpty()) {
                jsonData = new String(jsonFile.getBytes(), StandardCharsets.UTF_8);
            }
            if (json != null && !json.isEmpty()) {
                jsonData = json;
            }
            if (jsonData != null) {

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(jsonData);
                List<Candidato> candidatos = candidatoService.extrairCandidatos(rootNode);

                Map<String, Integer> candidatosPorEstado = candidatoService.calcularCandidatosPorEstado(candidatos);
                Map<String, Double> imcMedioPorFaixaEtaria = candidatoService.calcularImcMedioPorFaixaEtaria(candidatos);
                Map<String, Double> percentualObesosPorSexo = candidatoService.calcularPercentualObesosPorSexo(candidatos);
                Map<String, Integer> mediaIdadePorTipoSanguineo = candidatoService.calcularMediaIdadePorTipoSanguineo(candidatos);
                Map<String, Integer> doadoresPorTipoSanguineo = candidatoService.calcularDoadoresPorTipoSanguineo(candidatos, tipoSanguineoService.findAll());

                Map<String, Object> jsonResultado = new LinkedHashMap<>();
                jsonResultado.put("candidatosPorEstado", candidatosPorEstado);
                jsonResultado.put("imcMedioPorFaixaEtaria", imcMedioPorFaixaEtaria);
                jsonResultado.put("percentualObesosPorSexo", percentualObesosPorSexo);
                jsonResultado.put("mediaIdadePorTipoSanguineo", mediaIdadePorTipoSanguineo);
                jsonResultado.put("doadoresPorTipoSanguineo", doadoresPorTipoSanguineo);
                return ResponseEntity.ok(jsonResultado);
            }

            return ResponseEntity.badRequest().build();

    }

}
