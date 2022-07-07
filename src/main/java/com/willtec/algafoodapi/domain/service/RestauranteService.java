package com.willtec.algafoodapi.domain.service;


import com.willtec.algafoodapi.domain.model.Restaurante;
import com.willtec.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> buscarRestaurantes(){
        return restauranteRepository.findAll();
    }

    public Restaurante salvar(Restaurante restaurante){

        return null;
    }
}
