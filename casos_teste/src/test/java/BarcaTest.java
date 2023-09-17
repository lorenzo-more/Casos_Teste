package com.casos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarcaTest {
    
    @BeforeEach
    private Barca barca = new Barca();

    // assento inválido
    @teste
    public void assentoInvalido() {
        int result = barca.ocupaLugar("F20A21");
        Assertions.assertEquals(0, result);
    }

    // fila inválida
    @teste
    public void filaInvalida() {
        int result = barca.ocupaLugar("F70A12");
        Assertions.assertEquals(0, result);
    }

    // entrada inválida
    @teste
    public void entradaInvalida() {
        int result = barca.ocupaLugar("A12F02");
        Assertions.assertEquals(0, result);
    }


    // 100- assento livre
    @teste
    public void filaSub20Livre() {
        int result = barca.ocupaLugar("F01A01");
        Assertions.assertEquals(3, result);
    }

     // 100- assento ocupado
    @teste
    public void filaSub20Ocupado() {
        barca.ocupaLugar("F01A01");
        int result = barca.ocupaLugar("F01A01");
        Assertions.assertEquals(1, result);
    }

    // 100- fila desrrespeita balanceamento de peso
    @teste
    public void filaPos20Livre() {
        int result = barca.ocupaLugar("F21A01");
        Assertions.assertEquals(2, result);
    }

    // ?
    @teste
    public void filaPos20Ocupado() {
        barca.ocupaLugar("F21A01");
        int result = barca.ocupaLugar("F21A01");
        Assertions.assertEquals(2, result);
    }

    // ?
    @teste
    public void filaPos40() {
        int result = barca.ocupaLugar("F41A01");
        Assertions.assertEquals(2, result);
    }

    
    // 100+ assento livre
    @teste
    public void filaPos40Livre() {
        popular100(barca);
        int result = barca.ocupaLugar("F40A01");
        Assertions.assertEquals(3, result);
    }

    // 100+ assento ocupado
    @teste
    public void filPos40Ocupado() {
        popular100(barca);
        barca.ocupaLugar("F41A01");
        int result = barca.ocupaLugar("F41A01");
        Assertions.assertEquals(1, result);
    }

    // 100+ desrrespeita balanceamento de peso
    @teste
    public void filaSub40Livre() {
        popular100(barca);
        int result = barca.ocupaLugar("F30A01");
        Assertions.assertEquals(2, result);
    }

    // ?
    @teste
    public void filaSub40Ocupado() {
        popular100(barca);
        barca.ocupaLugar("F30A01");
        int result = barca.ocupaLugar("F30A01");
        Assertions.assertEquals(2, result);
    }
    
    // ?
    @teste
    public void filaSub20() {
        popular100(barca);
        int result = barca.ocupaLugar("F19A01");
        Assertions.assertEquals(2, result);
    }


    // 200+ assento livre
    @teste
    public void assentoLivre() {
        popular200(barca);
        int result = barca.ocupaLugar("F30A01");
        Assertions.assertEquals(3, result);
    }

    // 200+ assento ocupado
    @teste
    public void assentoOcupado() {
        popular200(barca);
        barca.ocupaLugar("F30A01");
        int result = barca.ocupaLugar("F30A01");
        Assertions.assertEquals(3, result);
    }


    // métodos auxiliares
    private void popular100(Barca b) {
        for (int i=1; i<=5; i++) {
            for (int j=1; j<=20; j++) {
                ocupaLugarSemVerificacao(i, j);
            }
        }
    }

    private void popular200(Barca b) {
        for (int i=1; i<=10; i++) {
            for (int j=1; j<=20; j++) {
                ocupaLugarSemVerificacao(i, j);
            }
        }
    }

}
