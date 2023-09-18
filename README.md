# Casos_Teste
Explorando técnicas de geração de casos de teste

**Tarefas:**
a. Gerar um conjunto de casos de teste para o método “ocupaLugar” utilizando a
técnica de particionamento.
b. Usando o JUnit, implementar um driver de teste que exercite o método
“ocupaLugar” com os casos de teste definidos na letra “a”.
c. Solicitar para o professor a implementação da classe “Barca”, aplicar o driver de
teste sobre a mesma e relatar os defeitos encontrados (se houverem).

Parâmetros: String: "F[nro da fileira]A[nro do assento]". Sem []. Números com 2 dígitos, iniciando em 1
 
 0 – Identificador de assento inválido
 1 – Assento ocupado
 2 – Assento bloqueado devido a distribuição de peso
 3 – Ok, assento atribuído ao passageiro.

## Casos de Teste
Assento não existe - F[yy]A[xx] | xx < 01 V xx > 20
    Resultado esperado: 0 – Identificador de assento inválido

Fileira não existe - F[yy]A[xx] | yy < 01 V yy > 60
    Resultado esperado: 0 – Identificador de assento inválido

Entrada incorreta - A[xx]F[yy]
    Resultado esperado: 0 – Identificador de assento inválido

Entrada incorreta (sem 2 dígitos) - F[yy]A[x]
    Resultado esperado: 0 – Identificador de assento inválido

Entrada correta mas assento ocupado
    Resultado esperado: 1 – Assento ocupado

Entrada correta - primeiros 100 - F[yy]A[xx] | yy >= 01 && yy <= 20
    Resultado esperado: 3 – Ok, assento atribuído ao passageiro.

Entrada incorreta - primeiros 100 - viola distribuição de peso F[yy]A[xx] | yy > 20
    Resultado esperado: 2 – Assento bloqueado devido a distribuição de peso

Entrada correta - entre 100 e 200 passageiros - F[yy]A[xx] | yy >= 40 && yy <= 60
    Resultado esperado: 3 – Ok, assento atribuído ao passageiro.

Entrada incorreta - entre 100 e 200 passageiros - viola distribuição de peso F[yy]A[xx] | yy < 40
    Resultado esperado: 2 – Assento bloqueado devido a distribuição de peso  

Entrada correta - demais passageiros
    Resultado esperado: 3 – Ok, assento atribuído ao passageiro.  