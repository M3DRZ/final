package com.clothes4happiness;

// SistemaEquipamentos.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaEquipamentos {
    private List<Equipamento> equipamentos;
    private Map<Integer, String> emprestimos;

    public SistemaEquipamentos() {
        this.equipamentos = new ArrayList<>();
        this.emprestimos = new HashMap<>();
    }

    public Equipamento cadastrarEquipamento(String nome, String descricao) {
        if (nome == null || nome.isEmpty() || descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Nome e descrição são obrigatórios.");
        }
        Equipamento equipamento = new Equipamento(equipamentos.size() + 1, nome, descricao);
        equipamentos.add(equipamento);
        return equipamento;
    }

    public List<Equipamento> listarEquipamentos() {
        return new ArrayList<>(equipamentos);
    }

    public void realizarEmprestimo(int equipamentoId, String colaborador) {
        if (equipamentoId <= 0 || equipamentoId > equipamentos.size()) {
            throw new IllegalArgumentException("Equipamento não encontrado.");
        }
        if (emprestimos.containsKey(equipamentoId)) {
            throw new IllegalArgumentException("Equipamento já emprestado.");
        }
        emprestimos.put(equipamentoId, colaborador);
    }

    public boolean verificarEmprestimo(int equipamentoId) {
        return emprestimos.containsKey(equipamentoId);
    }
}

// Equipamento.java
class Equipamento {
    private int id;
    private String nome;
    private String descricao;

    public Equipamento(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
