package br.com.artius.service;

import br.com.artius.domain.Pessoa;
import br.com.artius.dto.PessoaDTO;
import br.com.artius.mapper.PessoaMapper;
import br.com.artius.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private final PessoaRepository repository;
    @Autowired
    private final PessoaMapper mapper;

    public PessoaService(final PessoaRepository repository, final PessoaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> buscarTodas() {
        return repository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    public Optional<PessoaDTO> buscarPorNome(String nome) {
        Optional<Pessoa> pessoa = repository.findByNome(nome);
        return mapper.pessoaParaPessoaDTO(pessoa);
    }
}
