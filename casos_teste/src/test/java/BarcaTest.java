package com.casos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarcaTest {
    
    @BeforeEach
    private Barca barca = new Barca();

    // assento não existe
    @teste
    public void assentoInvalido() {
        int result = barca.ocupaLugar("F20A21");
        Assertions.assertEquals(0, result);
    }

    // fila não exite
    @teste
    public void filaInvalida() {
        int result = barca.ocupaLugar("F70A12");
        Assertions.assertEquals(0, result);
    }

    // entrada incorreta
    @teste
    public void entradaInvalida() {
        int result = barca.ocupaLugar("A12F02");
        Assertions.assertEquals(0, result);
    }


    // primeiros 100 assento livre
    @teste
    public void filaSub20Livre() {
        int result = barca.ocupaLugar("F01A01");
        Assertions.assertEquals(3, result);
    }

     // primeiros 100 assento ocupado
    @teste
    public void filaSub20Ocupado() {
        barca.ocupaLugar("F01A01");
        int result = barca.ocupaLugar("F01A01");
        Assertions.assertEquals(1, result);
    }

    // primeiros 100 fila desrrespeita distribuicao de peso
    @teste
    public void filaPos20Livre() {
        int result = barca.ocupaLugar("F21A01");
        Assertions.assertEquals(2, result);
    }
    
    // primeiros 200 assento livre
    @teste
    public void filaPos40Livre() {
        popular100();
        int result = barca.ocupaLugar("F40A01");
        Assertions.assertEquals(3, result);
    }

    // primeiros 200 assento ocupado
    @teste
    public void filPos40Ocupado() {
        popular100();
        barca.ocupaLugar("F41A01");
        int result = barca.ocupaLugar("F41A01");
        Assertions.assertEquals(1, result);
    }

    // primeiros 200 desrrespeita balanceamento de peso
    @teste
    public void filaSub40Livre() {
        popular100();
        int result = barca.ocupaLugar("F30A01");
        Assertions.assertEquals(2, result);
    }

    // demais passageiros assento livre
    @teste
    public void assentoLivre() {
        popular200();
        int result = barca.ocupaLugar("F30A01");
        Assertions.assertEquals(3, result);
    }

    // demais passageiros assento ocupado
    @teste
    public void assentoOcupado() {
        popular200();
        barca.ocupaLugar("F30A01");
        int result = barca.ocupaLugar("F30A01");
        Assertions.assertEquals(1, result);
    }



    // métodos auxiliares
    private void popular100() {
        for (int i=1; i<=5; i++) {
            for (int j=1; j<=20; j++) {
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
    }

    private void popular200() {
        for (int i=1; i<=10; i++) {
            for (int j=1; j<=20; j++) {
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
    }

}
