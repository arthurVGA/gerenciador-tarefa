package br.com.artius.dto;

public class DepartamentoDTO {
    private Long id;
    private Integer quantidadePessoas;
    private Integer quantidadeTarefas;

    public DepartamentoDTO(final Long id, final Integer quantidadePessoas, final Integer quantidadeTarefas) {
        this.id = id;
        this.quantidadePessoas = quantidadePessoas;
        this.quantidadeTarefas = quantidadeTarefas;
    }

    public DepartamentoDTO() { }

    public Long id() {
        return id;
    }

    public void id(final Long id) {
        this.id = id;
    }

    public Integer quantidadePessoas() {
        return quantidadePessoas;
    }

    public void quantidadePessoas(final Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public Integer quantidadeTarefas() {
        return quantidadeTarefas;
    }

    public void quantidadeTarefas(final Integer quantidadeTarefas) {
        this.quantidadeTarefas = quantidadeTarefas;
    }
}
