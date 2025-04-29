package com.intergrarh.banco_sangue.repository;

import com.intergrarh.banco_sangue.model.TipoSanguineo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoSanguineoRepository extends JpaRepository<TipoSanguineo, Long> {
    Optional<TipoSanguineo> findByTipo(String tipo);
}
