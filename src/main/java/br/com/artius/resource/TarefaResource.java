package br.com.artius.resource;

import br.com.artius.domain.Tarefa;
import br.com.artius.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TarefaResource {

    @Autowired
    public final TarefaService service;

    public TarefaResource(final TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarefa> adicionar(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(tarefa));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@RequestParam Long id, @RequestBody Tarefa tarefa) {
        tarefa.id(id);
        return ResponseEntity.ok(service.salvar(tarefa));
    }
    @PutMapping("/alocar/{id}")
    public ResponseEntity<Tarefa> alocarTarefa(@RequestParam Long id, @RequestBody Tarefa tarefa) {
        tarefa.id(id);
        return ResponseEntity.ok(service.salvar(tarefa));
    }
    @GetMapping
    public ResponseEntity<List<Tarefa>> buscarTodas() {
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tarefa>> buscarPorId(@RequestParam Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@RequestParam Long id) {
        service.deletarPorId(id);
    }
}
