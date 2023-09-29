package com.casos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


// limites 
// n de passageiros:
// on-point <=100 -> 100
// off-point <100 -> 101

// on-point <=200 -> 200
// off-point <=200 -> 201

// alterar os testes para parametrizados
// cobertura de código depois de pronto

public class BarcaTest {
    private BarcaRight barca = null;
    
    @BeforeEach
    void setUp(){
        barca = new BarcaRight();
    }

    @ParameterizedTest
    @MethodSource
    void primeiros100(String assento, int Res) {
        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> primeiros100() {
        return Stream.of(Arguments.of("F02A11", 3),
                         Arguments.of("F41A02", 2),
                         Arguments.of("F30A02", 2));
    }

    @ParameterizedTest
    @MethodSource
    void primeiros200(String assento, int Res) {
        popular100();
        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> primeiros200() {
        return Stream.of(Arguments.of("F41A01", 3),
                         Arguments.of("F12A03", 2),
                         Arguments.of("F31A03", 2));
    }

    @ParameterizedTest
    @MethodSource
    void todosDemais(String assento, int Res) {
        popular200();
        barca.ocupaLugarSemVerificacao(30, 10);
        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> todosDemais() {
        return Stream.of(Arguments.of("F31A10", 3),
                         Arguments.of("F31A11", 1));
    }

    @ParameterizedTest
    @MethodSource
    void limiteNpassageiros(int assentosOcupados, String assento, int Res) {
        popularn(assentosOcupados);

        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> limiteNpassageiros() {
        return Stream.of(Arguments.of(99, "F01A01", 1),
                         Arguments.of(100, "F01A01", 2),
                         Arguments.of(199, "F30A01", 2),
                         Arguments.of(200, "F30A01", 3)            
                         );
    }

    @ParameterizedTest
    @MethodSource
    void limiteNfileira(int assentosOcupados, String assento, int Res) {
        popularn(assentosOcupados);

        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> limiteNfileira() {
        return Stream.of(Arguments.of(50, "F20A01", 3),
                         Arguments.of(50, "F21A01", 2),
                         Arguments.of(150, "F40A01", 3),
                         Arguments.of(150, "F39A01", 2)
                         );
    }
    

    
    // métodos auxiliares
    private void popular100() {
        for (int i=0; i<5; i++) {
            for (int j=0; j<20; j++) {
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
    }

    private void popular200() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<20; j++) {
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
    }

    private void popularn(int n) {
        for (int i=0; i<(n/20); i++) {
            for (int j=0; j<20; j++) {
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        for (int i=0; i<(n-n/20); i++) {
            barca.ocupaLugarSemVerificacao((n/20) + 1, i);
        }
    }



}
