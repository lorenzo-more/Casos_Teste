package com.casos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarcaTest {
    
    @BeforeEach
    private Barca barca = new Barca();

    // entradas inválidas
    @teste
    public void assentoInvalido() {
        int result = barca.ocupaLugar("F20A21");
        Assertions.assertEquals(0, result);
    }

    @teste
    public void filaInvalida() {
        int result = barca.ocupaLugar("F70A12");
        Assertions.assertEquals(0, result);
    }

    @teste
    public void entradaInvalida() {
        int result = barca.ocupaLugar("A12F02");
        Assertions.assertEquals(0, result);
    }

    
}
