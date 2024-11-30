package com.clothes4happiness;

// SistemaEquipamentosTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaEquipamentoTest {

    @Test
    public void testCadastroEquipamentoValido() {
        SistemaEquipamentos sistema = new SistemaEquipamentos();
        Equipamento equipamento = sistema.cadastrarEquipamento("Martelo", "Ferramenta de construção");
        assertEquals("Martelo", equipamento.getNome());
        assertEquals("Ferramenta de construção", equipamento.getDescricao());
    }

    @Test
    public void testCadastroEquipamentoInvalido() {
        SistemaEquipamentos sistema = new SistemaEquipamentos();
        assertThrows(IllegalArgumentException.class, () -> {
            sistema.cadastrarEquipamento("", "");
        });
    }

    @Test
    public void testListarEquipamentos() {
        SistemaEquipamentos sistema = new SistemaEquipamentos();
        sistema.cadastrarEquipamento("Martelo", "Ferramenta de construção");
        sistema.cadastrarEquipamento("Chave de fenda", "Ferramenta de ajuste");
        assertEquals(2, sistema.listarEquipamentos().size());
    }
}

