package br.com.artius.mapper;

import br.com.artius.domain.Pessoa;
import br.com.artius.domain.Tarefa;
import br.com.artius.dto.PessoaDTO;
import br.com.artius.repository.PessoaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    public Optional<PessoaDTO> pessoaParaPessoaDTO(Optional<Pessoa> optPessoa) {
        if(optPessoa.isEmpty())
            return Optional.empty();
        Pessoa pessoa = optPessoa.get();

        double totalTempoTarefa = 0d;
        List<Tarefa> tarefas = pessoa.tarefas();
        for(Tarefa tarefa : tarefas)
            totalTempoTarefa += tarefa.duracao();

        return Optional.of(new PessoaDTO(pessoa.nome(), totalTempoTarefa/tarefas.size()));
    }

}
