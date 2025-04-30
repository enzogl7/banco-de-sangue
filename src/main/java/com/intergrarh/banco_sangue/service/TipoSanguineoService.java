package com.intergrarh.banco_sangue.service;

import com.intergrarh.banco_sangue.model.TipoSanguineo;
import com.intergrarh.banco_sangue.repository.TipoSanguineoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoSanguineoService {
    @Autowired
    private TipoSanguineoRepository tipoSanguineoRepository;

    public Optional<TipoSanguineo> findByTipo(String tipo) {
        return tipoSanguineoRepository.findByTipo(tipo);
    }

    public List<TipoSanguineo> findAll() {
        return tipoSanguineoRepository.findAll();
    }
}
