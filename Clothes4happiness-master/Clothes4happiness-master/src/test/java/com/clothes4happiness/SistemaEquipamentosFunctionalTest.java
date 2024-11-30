package com.clothes4happiness;

// SistemaEquipamentosFunctionalTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaEquipamentosFunctionalTest {

    @Test
    public void testFluxoCompletoDeCadastroEEmprestimo() {
        SistemaEquipamentos sistema = new SistemaEquipamentos();

        // Cadastro de Equipamentos
        Equipamento equipamento = sistema.cadastrarEquipamento("Furadeira", "Equipamento elétrico");
        assertNotNull(equipamento);

        // Listagem
        assertEquals(1, sistema.listarEquipamentos().size());

        // Empréstimo
        sistema.realizarEmprestimo(equipamento.getId(), "Maria");
        assertTrue(sistema.verificarEmprestimo(equipamento.getId()));
    }

    @Test
    public void testEmprestimoDeEquipamentoIndisponivel() {
        SistemaEquipamentos sistema = new SistemaEquipamentos();
        sistema.cadastrarEquipamento("Martelo", "Ferramenta de construção");
        sistema.realizarEmprestimo(1, "João");

        assertThrows(IllegalArgumentException.class, () -> {
            sistema.realizarEmprestimo(1, "Maria");
        });
    }
}

