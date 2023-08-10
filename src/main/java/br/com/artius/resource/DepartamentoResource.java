package br.com.artius.resource;

import br.com.artius.domain.Departamento;
import br.com.artius.dto.DepartamentoDTO;
import br.com.artius.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoResource {
    @Autowired
    private final DepartamentoService service;

    public DepartamentoResource(final DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Departamento> adicionar(@RequestBody Departamento departamento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(departamento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizar(@RequestParam Long id, @RequestBody Departamento departamento) {
        departamento.id(id);
        return ResponseEntity.ok(service.salvar(departamento));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> buscarTodas() {
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Departamento>> buscarPorId(@RequestParam Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@RequestParam Long id) {
        service.deletarPorId(id);
    }


}
