# ATIVIDADE

Empresa de Distribuição de Energia COELHO: COmpalhia ELétrica de Hoje e Ontem Ltda

É a concessionária de energia de um estado fictício que fica na costa do Atlântico, Região Nordeste, de um país fictício que fica na América do Sul.

## Clientes e Imóveis

Os clientes possuem Imóveis, que são localizados em algum endereço conhecido da COELHO. Nos imóveis há um aparelho (os "relógios") que registra o valor de consumo atual (em KWh), de forma que a última leitura e a atual permite se verificar quanto foi consumido no período. 

É necessário se implementar um menu com gestão de clientes (Incluir, Consultar, Listar, Excluir e Alterar) e de Imóveis (Incluir, Consultar, Listar, Excluir e Alterar). Note que os valores da última e penúltima leitura serão usados para geração das faturas de consumo, como veremos adiante.

## Diagrama do sistema (sem métodos) até aqui?

### Você já deverá ter dois Menus implementados: o de gestão de clientes e o de gestão de Imóveis.

## Faturas

Crie um Menu Faturas

Quando se faz a leitura de consumo de um imóvel, procede-se à geração de uma fatura. Para isto é necessário que o imóvel seja identificado (matrícula) e o valor da leitura atual seja apresentado ao sistema.

Neste momento, o valor que estava como "Última Leitura" no imóvel é passado para "Penúltima Leitura". E o valor da leitura atual é registrado como "Última Leitura".

Além disso, cria-se uma instância de objeto do tipo Fatura, onde se registra os dados das duas últimas leituras, a data de emissão da Fatura (que é a data atual do sistema), o valor calculado (a fórmula de cálculo será apresentada oportunamente. Por enquanto admita que é calculado ao custo de 10 reais por KWh) e um flag, inicialmente setado como False, para indicar se a fatura já está completamente quitada.

### O Menu Fatura deve permitir a criação de uma fatura, mas jamais sua exclusão (note que isto forçaria a recuperar o Penúltimo valor que foi apagado). Também deve permitir a listagem de todas as faturas, ou apenas das faturas em aberto (não pagas).

## Diagrama até aqui

![imagem1](link_para_imagem1.png)

## Pagamentos

Crie o Menu Pagamentos.

Normalmente os clientes pagam a fatura integralmente. Mas isto não é obrigatório.

Ao se incluir um pagamento no sistema, é necessário se registrar o valor e a data (considere a data atual do sistema). O nosso programa não trata de pagamentos em atraso. Apenas os registra como qualquer outro.

Pode ocorrer, porém, de o cliente não pagar integralmente a fatura de uma única vez; neste caso, mais de um pagamento pode ser registrado para uma mesma fatura, até que seu valor esteja integralmente cumprido.

Quando a soma dos pagamentos associados a uma fatura completar seu valor, a fatura é marcada como "Quitado" (o flag vai para True).

O sistema não aceita pagamento de faturas já quitadas.

Mas pode acontecer de um pagamento superar, sozinho ou com a soma de outros, o valor da fatura. Neste caso o sistema gera um Reembolso, com o valor pago a mais, e registrado na data atual do sistema, no momento do pagamento.

### O Menu Pagamento, portanto, deve permitir a Inclusão de pagamentos, mas jamais sua alteração ou exclusão. Se o pagamento gerar um reembolso, isto deve ser mostrado na tela imediatamente.

### Deve permitir a listagem de todos os pagamentos, ou de todos os pagamentos de uma dada fatura.

### O mesmo com os reembolsos.

## Diagrama até aqui:

![imagem2](link_para_imagem2.png)

## Falhas

O sistema de distribuição de energia pode ter falhas, e estas costumam ser reportadas pelos clientes.

As falhas, apesar de informadas pelos clientes, são registradas em associação com algum imóvel, cuja matrícula o cliente deve fornecer. A COELHO simplesmente ignora qualquer cliente que não tenha a matrícula do imóvel para fazer a reclamação. Esta medida ajudou a reduzir muito a quantidade de reclamações feitas.

Existem falhas que não são reportadas por nenhum cliente, mas também precisam serem incluídas no sistema.

Há dois tipos de falhas. As falhas de Geração, em que a geração de energia foi interrompida, e a COELHO não tem como resolver até que a geração se restabeleça.

Há também as falhas de Distribuição, em que a responsabilidade é da COELHO (se ela não conseguir inventar uma boa desculpa) e este tipo de falha vai demandar um Reparo na rede.

Este reparo tem uma descrição da atividade que será desenvolvida (precisa ser digitada), uma previsão inicial, uma data de início e de fim, e um flag para identificar se este reparo resolveu a falha ou não. Caso o reparo não tenha resolvido a falha encontrada, então outro processo de reparo mais avançado é iniciado, e assim sucessivamente.

### O Menu de Falha, portanto, deve oferecer as opções de Incluir Falhas, e estas podem ser originadas de uma reclamação (e neste caso é associada a algum imóvel) ou não.

### No momento em que uma falha é incluída, em se tratando de uma falha de geração, ela fica apenas registrada até que seja resolvida pela empresa geradora de energia.

### Se a falha for de distribuição, então automaticamente é solicitada a criação de um Reparo, com uma descrição da atividade de reparo que será necessária, que é registrado com a data de início sendo a data do sistema.

### É necessário criar um submenu de Reparos.

### No submenu de reparos é possível se listar todos os reparos em aberto, com as respectivas falhas a eles associadas.

### Também é possível se encerrar um reparo, o que registra a data de Finalização do mesmo. Todavia, é necessário identificar se a falha foi resolvida. Em caso negativo é gerado, automaticamente, um novo reparo para a mesma falha, e a descrição deste novo reparo é solicitada.

## Diagrama final do sistema:

![imagem3](link_para_imagem3.png)

Segue uma pequena descrição dos menus:

- Menu Principal
  - Gestão de Clientes
    - Incluir, Consultar, Listar, Excluir, Alterar
  - Gestão de Imóveis
    - Incluir, Consultar, Listar, Excluir, Alterar
  - Gestão de Faturas
    - Registro de Consumo
    - Listar Faturas (abertas, todas)
  - Gestão de Pagamentos
    - Inclusão de Pagamentos
    - Listar Pagamentos (todos, por fatura)
    - Listar Reembolsos (todos, por fatura)
  - Gestão de Falhas
    - Incluir Falhas (com ou sem matrícula)
    - Gestão de Reparos
      - Listar reparos em aberto
      - Encerrar reparo (possivelmente criar outro)
