package com.casos;

public class Barca {
    public Barca() {
    }

    // Método auxiliar projetado para facilitar testes (montagem de cenário)
    // Ocupa o lugar sem verificação: simplesmente ocupa o lugar sem validar nenhuma
    // das regras de ocupação
    public void ocupaLugarSemVerificacao(int fila, int assento) {
    }

    /*
     * Retorna:
     * 0 – Identificador de assento inválido
     * 1 – Assento ocupado
     * 2 – Assento bloqueado devido a distribuição de peso
     * 3 – Ok, assento atribuído ao passageiro.
     */
    public int ocupaLugar(String assentoInformado) {
        return -1;
    }
}