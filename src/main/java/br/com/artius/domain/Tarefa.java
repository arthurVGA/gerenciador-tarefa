package br.com.artius.domain;

import jakarta.persistence.*;

import java.time.Instant;


@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Instant prazo;
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    private Integer duracao;

    @ManyToOne
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;
    private Boolean finalizada;

    public Tarefa(final Long id, final String titulo, final String descricao, final Instant prazo, final Departamento departamento, final Integer duracao, final Pessoa pessoa, final Boolean finalizada) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.departamento = departamento;
        this.duracao = duracao;
        this.pessoa = pessoa;
        this.finalizada = finalizada;
    }

    public Tarefa() { }

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

    public String descricao() {
        return descricao;
    }

    public void descricao(final String descricao) {
        this.descricao = descricao;
    }

    public Instant prazo() {
        return prazo;
    }

    public void prazo(final Instant prazo) {
        this.prazo = prazo;
    }

    public Departamento departamento() {
        return departamento;
    }

    public void departamento(final Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer duracao() {
        return duracao;
    }

    public void duracao(final Integer duracao) {
        this.duracao = duracao;
    }

    public Pessoa pessoa() {
        return pessoa;
    }

    public void pessoa(final Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean finalizada() {
        return finalizada;
    }

    public void finalizada(final Boolean finalizada) {
        this.finalizada = finalizada;
    }
}
