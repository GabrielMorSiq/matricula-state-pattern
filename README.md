# MatriculaState

Este repositório contém a implementação de um exemplo prático do padrão de projeto State, focado no contexto de uma academia esportiva. 

O sistema desenvolvido permite o cadastro de uma matrícula, com a capacidade de alterar dinamicamente seu comportamento durante a execução do programa. 

O padrão State é aplicado para facilitar a mudança de comportamento com base nos diferentes estados internos de uma matrícula: ativa, cancelada ou inativa.


## Resumo do Projeto:

A implementação envolve a classe Matricula que utiliza o padrão State para gerenciar os diferentes estados da matrícula (ativa, cancelada, inativa). 

A classe PlanoAcademia abstrai os diferentes pacotes de serviços oferecidos pela academia, com subclasses específicas representando planos concretos.

As classes PlanoSemServico, PlanoBasico, PlanoIntermediario, e PlanoAvancado representam diferentes tipos de planos oferecidos pela academia, com características específicas e métodos para cálculo de preços.

A classe Cliente representa a entidade cliente com atributos como nome e CPF, sendo parte integrante da classe Matricula. A interface MatriculaState define os estados possíveis da matrícula, enquanto as classes concretas (MatriculaAtivaState, MatriculaCanceladaState, MatriculaDesativadaState) implementam a lógica de transição entre esses estados.

![class-diagram](https://i.imgur.com/m5UfzAe.png)
