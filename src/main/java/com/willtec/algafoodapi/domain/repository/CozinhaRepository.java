package com.willtec.algafoodapi.domain.repository;

import com.willtec.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CozinhaRepository extends JpaRepository<Cozinha,Long> {
}
