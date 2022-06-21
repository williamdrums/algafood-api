package com.willtec.algafoodapi.domain.service;

import com.willtec.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.willtec.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.willtec.algafoodapi.domain.model.Cozinha;
import com.willtec.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void delete(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe  um cadastro de cozinha  com código %d", cozinhaId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de codigo %d não pode ser removida pois está em uso", cozinhaId)
            );
        }

    }
}
