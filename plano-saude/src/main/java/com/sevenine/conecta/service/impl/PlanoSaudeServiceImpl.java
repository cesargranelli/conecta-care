package com.sevenine.conecta.service.impl;

import com.sevenine.conecta.controller.data.request.PlanoSaudeRequest;
import com.sevenine.conecta.controller.data.response.PlanoSaudeCadastroResponse;
import com.sevenine.conecta.controller.data.response.PlanoSaudeResponse;
import com.sevenine.conecta.exception.DadosNaoEncontradosException;
import com.sevenine.conecta.repository.PlanoSaudeRepository;
import com.sevenine.conecta.repository.data.PlanoSaude;
import com.sevenine.conecta.service.PlanoSaudeService;
import com.sevenine.conecta.service.converter.PlanoSaudeServiceConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class PlanoSaudeServiceImpl implements PlanoSaudeService {

    private final PlanoSaudeServiceConverter converter;
    private final PlanoSaudeRepository repository;

    @Override
    public PlanoSaudeCadastroResponse cadastrar(PlanoSaudeRequest request) {
        PlanoSaude planoSaude = converter.toEntity(request);
        return converter.toResponse(repository.save(planoSaude).getId());
    }

    @Override
    public void alterar(PlanoSaudeRequest request) {
        Optional<PlanoSaude> planoSaudeOptional = repository.findById(request.getId());
        if (planoSaudeOptional.isPresent()) {
            planoSaudeOptional.get().atualizarPlanoSaude(converter.toEntity(request));
            repository.flush();
        }
    }

    @Override
    public PlanoSaudeResponse consultar(Long id) {
        try {
            return converter.toResponse(repository.getOne(id));
        } catch (EntityNotFoundException e) {
            throw new DadosNaoEncontradosException(
                    "Plano de Saúde não encontrado", HttpStatus.NOT_FOUND
            );
        }
    }

    @Override
    public List<PlanoSaudeResponse> listarMatriz() {
        List<PlanoSaude> planosSaude = repository.findAll();
        return converter.toResponseList(filtrarPlanoSaudeMatriz(planosSaude));
    }

    private List<PlanoSaude> filtrarPlanoSaudeMatriz(List<PlanoSaude> planosSaude) {
        return planosSaude.stream().filter(planoSaude -> isNull(planoSaude.getPlanoSaudeMatriz())).collect(Collectors.toList());
    }

}
