package br.com.artius.mapper;

import br.com.artius.domain.Departamento;
import br.com.artius.dto.DepartamentoDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartamentoMapper {

    public DepartamentoDTO departamentoParadepartamentoDTO(Departamento departamento) {
        return new DepartamentoDTO(
                departamento.id(),
                departamento.pessoas().size(),
                departamento.tarefas().size());
    }
    public List<DepartamentoDTO> departamentosParadepartamentoDTOs(List<Departamento> departamentos) {
        return departamentos
                .stream()
                .map(this::departamentoParadepartamentoDTO)
                .collect(Collectors.toList());
    }
}
