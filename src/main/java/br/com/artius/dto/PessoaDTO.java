package br.com.artius.dto;

public class PessoaDTO {
    private String nome;
    private Double mediaPorTarefa;

    public PessoaDTO(final String nome, final Double mediaPorTarefa) {
        this.nome = nome;
        this.mediaPorTarefa = mediaPorTarefa;
    }

    public PessoaDTO() { }

    public String nome() {
        return nome;
    }

    public void nome(final String nome) {
        this.nome = nome;
    }

    public Double mediaPorTarefa() {
        return mediaPorTarefa;
    }

    public void mediaPorTarefa(final Double mediaPorTarefa) {
        this.mediaPorTarefa = mediaPorTarefa;
    }
}
