package com.willtec.algafoodapi.domain.service;


import com.willtec.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.willtec.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.willtec.algafoodapi.domain.model.Restaurante;
import com.willtec.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> buscarRestaurantes() {
        return restauranteRepository.findAll();
    }

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public void delete(Long restauranteId) {
        try {
            restauranteRepository.deleteById(restauranteId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe  um cadastro de cozinha  com código %d", restauranteId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cozinha de codigo %d não pode ser removida pois está em uso", restauranteId));
        }

    }
}
