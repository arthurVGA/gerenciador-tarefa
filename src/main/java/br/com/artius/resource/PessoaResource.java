package br.com.artius.resource;

import br.com.artius.domain.Pessoa;
import br.com.artius.dto.PessoaDTO;
import br.com.artius.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    public final PessoaService service;

    public PessoaResource(final PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pessoa> adicionar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                                .body(service.salvar(pessoa));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable  Long id, @RequestBody Pessoa pessoa) {
        pessoa.id(id);
        return ResponseEntity.ok(service.salvar(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarTodas() {
        return ResponseEntity.ok(service.buscarTodas());
    }
    @GetMapping("/gastos")
    public ResponseEntity<Optional<PessoaDTO>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable  Long id) {
        service.deletarPorId(id);
    }
}
