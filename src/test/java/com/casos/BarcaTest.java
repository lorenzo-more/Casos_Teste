package com.casos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class BarcaTest {
    private BarcaRight barca = null;
    
    @BeforeEach
    void setUp(){
        barca = new BarcaRight();
    }


    @ParameterizedTest
    @MethodSource
    void entradasInvalidas(String assento, int Res) {
        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> entradasInvalidas() {
        return Stream.of(Arguments.of("F00A11", 0),
                         Arguments.of("F70A11", 0),
                         Arguments.of("F10A00", 0),
                         Arguments.of("F30A40", 0),
                         Arguments.of("A02F03", 0));
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
    void limitesEntradaInvalida(int ocupados, String assento, int Res) {
        popularn(ocupados);
        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> limitesEntradaInvalida() {
        return Stream.of(Arguments.of(110, "F61A11", 0),
                         Arguments.of(110, "F60A11", 3),
                         Arguments.of(0, "F01A21", 0),
                         Arguments.of(0, "F01A20", 3)
                         );
    }


    @ParameterizedTest
    @MethodSource
    void limiteNpassageiros(int assentosOcupados, String assento, int Res) {
        popularn(assentosOcupados);

        assertEquals(Res, barca.ocupaLugar(assento));
    }

    static Stream<Arguments> limiteNpassageiros() {
        return Stream.of(Arguments.of(99, "F01A01", 1),
                         Arguments.of(100, "F20A01", 2),
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
        int i = 0;
        int j = 0;
        while (n>0) {
            barca.ocupaLugarSemVerificacao(i, j);
            j++;
            n = n-1;
            if (j==20) {i++; j=0;}
        }
    }



}
