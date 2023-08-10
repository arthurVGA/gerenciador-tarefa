package br.com.artius.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    @OneToMany(mappedBy="pessoa")
    private List<Tarefa> tarefas;

    public Pessoa(final Long id, final String nome, final Departamento departamento, final List<Tarefa> tarefas) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.tarefas = tarefas;
    }

    public Pessoa() { }

    public Long id() {
        return id;
    }

    public void id(final Long id) {
        this.id = id;
    }

    public String nome() {
        return nome;
    }

    public void nome(final String nome) {
        this.nome = nome;
    }

    public Departamento departamento() {
        return departamento;
    }

    public void departamento(final Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Tarefa> tarefas() {
        return tarefas;
    }

    public void tarefas(final List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
