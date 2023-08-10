package br.com.artius.service;

import br.com.artius.domain.Departamento;
import br.com.artius.dto.DepartamentoDTO;
import br.com.artius.mapper.DepartamentoMapper;
import br.com.artius.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private final DepartamentoRepository repository;
    @Autowired
    private final DepartamentoMapper mapper;

    public DepartamentoService(final DepartamentoRepository repository, final DepartamentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Departamento salvar(Departamento departamento) {
        return repository.save(departamento);
    }

    public List<DepartamentoDTO> buscarTodas() {
        List<Departamento> departamentos = repository.findAll();
        return mapper.departamentosParadepartamentoDTOs(departamentos);
    }

    public Optional<Departamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
