package br.com.artius.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Departamento {
    @Id
    private Long id;
    private String titulo;
    @OneToMany(mappedBy = "departamento")
    private List<Pessoa> pessoas;
    @OneToMany(mappedBy = "departamento")
    private List<Tarefa> tarefas;

    public Departamento(final Long id, final String titulo, final List<Pessoa> pessoas, final List<Tarefa> tarefas) {
        this.id = id;
        this.titulo = titulo;
        this.pessoas = pessoas;
        this.tarefas = tarefas;
    }

    public Departamento() { }

    public Long id() {
        return id;
    }

    public void id(final Long id) {
        this.id = id;
    }

    public String titulo() {
        return titulo;
    }

    public void titulo(final String titulo) {
        this.titulo = titulo;
    }

    public List<Pessoa> pessoas() {
        return pessoas;
    }

    public void pessoas(final List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Tarefa> tarefas() {
        return tarefas;
    }

    public void tarefas(final List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
