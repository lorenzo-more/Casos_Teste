package com.casos;

public class BarcaRight {
    private boolean[][] lugaresOcupados = new boolean[60][20];
    private int totalPassageiros = 0;

    public BarcaRight() {
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 20; j++) {
                lugaresOcupados[i][j] = false;
            }
        }
    }

    // Método auxiliar projetado para facilitar testes (montagem de cenário)
    // Ocupa o lugar sem verificação: simplesmente ocupa o lugar sem validar nenhuma das
    // regras de ocupação
    public void ocupaLugarSemVerificacao(int fila, int assento) {
            lugaresOcupados[fila][assento] = true;
            totalPassageiros++;
    }

    /*
     * * Retorna:
     * 0 – Identificador de assento inválido
     * 1 – Assento ocupado
     * 2 – Assento bloqueado devido a distribuição de peso
     * 3 – Ok, assento atribuído ao passageiro.
     */
    public int ocupaLugar(String assentoInformado) {
        if (!assentoInformado.matches("^F[0-6][0-9]A[0-2][0-9]$")) {
            return 0;
        }

        int fila = Integer.parseInt(assentoInformado.substring(1, 3));
        int assento = Integer.parseInt(assentoInformado.substring(4, 6));

        if (fila < 1 || fila > 60 || assento < 1 || assento > 20) {
            return 0;
        }

        if (lugaresOcupados[fila - 1][assento - 1]) {
            return 1;
        }

        if (totalPassageiros < 100) {
            if (fila <= 20) {
                lugaresOcupados[fila - 1][assento - 1] = true;
                totalPassageiros++;
                return 3;
            } else {
                return 2;
            }
        } else if (totalPassageiros < 200) {
            if (fila >= 40) {
                lugaresOcupados[fila - 1][assento - 1] = true;
                totalPassageiros++;
                return 3;
            } else {
                return 2;
            }
        } else {
            lugaresOcupados[fila - 1][assento - 1] = true;
            totalPassageiros++;
            return 3;
        }
    }
}
