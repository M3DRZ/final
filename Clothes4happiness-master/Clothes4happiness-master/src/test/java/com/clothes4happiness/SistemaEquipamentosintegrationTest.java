package com.clothes4happiness;

// SistemaEquipamentosIntegrationTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaEquipamentosintegrationTest {

    @Test
    public void testCadastroEListagemDeEquipamentos() {
        SistemaEquipamentos sistema = new SistemaEquipamentos();
        sistema.cadastrarEquipamento("Martelo", "Ferramenta de construção");
        sistema.cadastrarEquipamento("Chave de fenda", "Ferramenta de ajuste");

        assertEquals(2, sistema.listarEquipamentos().size());
        assertEquals("Martelo", sistema.listarEquipamentos().get(0).getNome());
    }

    @Test
    public void testEmprestimoEquipamento() {
        SistemaEquipamentos sistema = new SistemaEquipamentos();
        sistema.cadastrarEquipamento("Martelo", "Ferramenta de construção");
        sistema.realizarEmprestimo(1, "João");

        assertTrue(sistema.verificarEmprestimo(1));
    }
}

