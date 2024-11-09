## Sorteador - Aplicativo Android

## Descrição
O Sorteador é um aplicativo Android desenvolvido para sortear números inteiros dentro de um intervalo pré-definido. 
Ele utiliza os padrões de design Strategy e Singleton para definir a lógica principal do aplicativo.

## Objetivos do Projeto
- Praticar o uso do padrão Strategy, permitindo que o algoritmo de sorteio possa ser alterado dinamicamente sem modificar a estrutura do código principal.
- Aplicar o padrão Singleton para garantir que a instância do sorteador padrão seja única e gerenciada centralizadamente.
- Explorar o conceito de LinearLayout para organização e design da interface de usuário.

## Tecnologias Utilizadas
- Kotlin: Linguagem de programação utilizada para o desenvolvimento.
- Android SDK: Para a criação do aplicativo Android.
- LinearLayout: Usado para a organização da interface do usuário.
- ListView: Para exibir os números sorteados.
- Singleton: Para garantir uma única instância da classe que realiza os sorteios.
- Strategy: Para permitir a troca flexível da lógica de sorteio sem modificar o código principal.

## Funcionalidades
- Definir um intervalo de números.
- Sortear um número aleatório dentro desse intervalo.
- Exibir os números sorteados em um ListView.
- Modificar a lógica do sorteio sem alterar o código base, utilizando o padrão Strategy.
