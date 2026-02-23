package com.gerenciador.tarefas.model;


import jakarta.persistence.*;

@Entity // tranforma em tabelas
@Table(name = "tarefas") // deifni o nome da tabela no banco de dados
public class Tarefa {

    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera o id automaticamente
    private long id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING) // armazena o valor do enum como string no banco de dados
    private StatusTarefa status;

    public Tarefa() { // um construtor vazio é necessário para o JPA
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }


}

