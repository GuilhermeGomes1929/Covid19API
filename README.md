# Covid19API
Essa API cria estatísticas sobre a propagação do vírus da covid-19 na cidade.<br>

## Tecnologias usadas na API

<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" /> 
<img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" /><br>


## Descrição
Assim que alguém for diagnosticado com covid-19, uma pesquisa será feita. Dentro dessa pesquisa há perguntas como: "Qual bairro você mora?", "Algum parente seu testou positivo para covid?". Após feita a pesquisa, ela será armazenada no banco de dados. Com várias pesquisas feitas, a API consegue manipular os dados e retornar estatísticas essenciais para mapear onde a propagação do vírus é maior, bem como em que parte do cotidiano as pessoas estão negligenciando os cuidados para evitar a propagação da doença.<br>

## Categoria das perguntas

<table>
  <tr>
    <td>Id</td>
    <td>Categoria</td>
  </tr>
  
  <tr>
    <td>1</td>
    <td>Sobre você</td>
  </tr>
  
  <tr>
    <td>2</td>
    <td>Sobre o convívio em casa</td>
  </tr>
  
  <tr>
    <td>3</td>
    <td>Sobre o dia-a-dia fora de casa</td>
  </tr>
  
  <tr>
    <td>4</td>
    <td>Sobre higiene</td>
  </tr>
  
  <tr>
    <td>5</td>
    <td>Sobre o trabalho</td>
  </tr>
  
  <tr>
    <td>6</td>
    <td>Sobre o transporte</td>
  </tr>

</table>
<br>


## Pesquisa

<table>
  <tr>
    <td>Id</td>
    <td>Pergunta</td>
    <td>Categoria</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Qual bairro você mora?</td>
    <td>1</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Qual a sua profissão?</td>
    <td>1</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Quantas pessoas moram com você? (Responda 0 se mora sozinho)</td>
    <td>2</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Elas frequentaram o mesmo ambiente que você?</td>
    <td>2</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Elas frequentaram outros lugares que você não frequentou?</td>
    <td>2</td>
  </tr>
  <tr>
    <td>6</td>
    <td>Alguma delas testou positivo para covid-19?</td>
    <td>2</td>
  </tr>
  <tr>
    <td>7</td>
    <td>Você foi ao supermercado uma semana antes de apresentar sintomas para covid-19?</td>
    <td>3</td>
  </tr>
  <tr>
    <td>8</td>
    <td>Você foi a farmácia uma semana antes de apresentar sintomas para covid-19?</td>
    <td>3</td>
  </tr>
  <tr>
    <td>9</td>
    <td>Você foi ao hospital uma semana antes de apresentar sintomas para covid-19?</td>
    <td>3</td>
  </tr>
  <tr>
    <td>10</td>
    <td>Você foi a outros lugares considerados serviços essenciais?</td>
    <td>3</td>
  </tr>
  <tr>
    <td>11</td>
    <td>Você foi a outros lugares que não são considerados essenciais?</td>
    <td>3</td>
  </tr>
  <tr>
    <td>12</td>
    <td>Você higieniza as compras?</td>
    <td>4</td>
  </tr>
  <tr>
    <td>13</td>
    <td>Você consome serviços de delivery com frequência?</td>
    <td>1</td>
  </tr>
  <tr>
    <td>14</td>
    <td>Você trabalha na sua cidade?</td>
    <td>5</td>
  </tr>
  <tr>
    <td>15</td>
    <td>Seu trabalho possui políticas contra a disseminação do vírus?</td>
    <td>5</td>
  </tr>
  <tr>
    <td>16</td>
    <td>Elas são seguidas a risca?</td>
    <td>5</td>
  </tr>
  <tr>
    <td>17</td>
    <td>Você utiliza transporte público com frequência(de 3 a 7 dias por semana)?</td>
    <td>6</td>
  </tr>
  <tr>
    <td>18</td>
    <td>Você cumprimenta as pessoas na rua?</td>
    <td>4</td>
  </tr>
  <tr>
    <td>19</td>
    <td>Frequentou algum local com aglomeração(mercados lotados, festas, eventos)?</td>
    <td>3</td>
  </tr>

</table>
<br>


## O programa contém as entidades:
### Category
- id
- name
### Questions
- id 
- sentences
- category
### Research
- id
- p1
- p2
- p3
- p4
- p5
- p6
- p7
- p8
- p9
- p10
- p11
- p12
- p13
- p14
- p15
- p16
- p17
- p18
- p19
### District
- id
- name
### Occupation
- id
- name
### PriorityOrder (classe modelo, não é uma entidade do banco de dados)
- piority order
- research

<br>

## Caminhos

### /category
<table>
  <tr>
    <td>Caminho</td>
    <td>Método</td>
    <td>Função</td>
  </tr>
  <tr>
    <td>/</td>
    <td>GET</td>
    <td>Lista todas as categorias</td>
  </tr>
  <tr>
    <td>/{id}</td>
    <td>GET</td>
    <td>Retorna a categoria com id especificado</td>
  </tr>
</table>

### /questions
<table>
  <tr>
    <td>Caminho</td>
    <td>Método</td>
    <td>Função</td>
  </tr>
  <tr>
    <td>/</td>
    <td>GET</td>
    <td>Lista todas as perguntas</td>
  </tr>
  <tr>
    <td>/{id}</td>
    <td>GET</td>
    <td>Retorna a pergunta com id especificado</td>
  </tr>
</table>

### /district
<table>
  <tr>
    <td>Caminho</td>
    <td>Método</td>
    <td>Função</td>
  </tr>
  <tr>
    <td>/</td>
    <td>GET</td>
    <td>Lista todos os bairros</td>
  </tr>
  <tr>
    <td>/{id}</td>
    <td>GET</td>
    <td>Retorna o bairro com id especificado</td>
  </tr>
</table>

### /occupation
<table>
  <tr>
    <td>Caminho</td>
    <td>Método</td>
    <td>Função</td>
  </tr>
  <tr>
    <td>/</td>
    <td>GET</td>
    <td>Lista todas as profissões</td>
  </tr>
  <tr>
    <td>/{id}</td>
    <td>GET</td>
    <td>Retorna a profissão com id especificado</td>
  </tr>
</table>

### /research
<table>
  <tr>
    <td>Caminho</td>
    <td>Método</td>
    <td>Função</td>
  </tr>
  <tr>
    <td>/</td>
    <td>GET</td>
    <td>Lista todas as pesquisas</td>
  </tr>
  <tr>
    <td>/{id}</td>
    <td>GET</td>
    <td>Retorna a pesquisa com id especificado</td>
  </tr>
  <tr>
    <td>/register</td>
    <td>POST</td>
    <td>Registra a pesquisa no banco de dados</td>
  </tr>
  <tr>
    <td>/delete/{id}</td>
    <td>DELETE</td>
    <td>Deleta a pesquisa com id especificado</td>
  </tr>
  <tr>
    <td>/edit</td>
    <td>PUT</td>
    <td>Substitui a pesquisa do banco pela pesquisa mandada que tenha o id idêntico</td>
  </tr>
  <tr>
    <td>/filter/count</td>
    <td>GET</td>
    <td>Retorna o número de pesquisas no banco de dados que tem respostas iguais as da pesquisa enviada</td>
  </tr>
  <tr>
    <td>/filter/cascade</td>
    <td>GET</td>
    <td>Retorna o total de pesquisas do banco de dados, o número de pesquisas no banco de dados que tem a resposta para a primeira pergunta enviada igual a resposta da primeira pergunta enviada, depois retorna, dessa quantidade anterior, a quantidade de pesquisas que tem a resposta para a segunda pergunta enviada igual a reposta da segunda pergunta enviada, de acordo com a ordem de prioridade.<br> Exemplo:<br>Pesquisa enviada = { "p4": true, "p5": true }<br> A API irá retornar a quantidade de pesquisas que tem a pergunta "p4" registrada como true, depois dessa quantidade de pesquisas que tem "p4" = true, a API irá retornar a quantidade dessas pesquisas que possui "p5" registrado como true. <br> Uma possível resposta da API: {"total":10, "p4":8, "p5":2} </td>
  </tr>
  <tr>
    <td>/filter/research</td>
    <td>GET</td>
    <td>Retorna uma lista de pesquisas no banco de dados que tem respostas iguais as da pesquisa enviada</td>
  </tr>
  <tr>
    <td>/filter/percentage</td>
    <td>GET</td>
    <td>Retorna a porcentagem de pesquisas no banco de dados que tem respostas iguais as da pesquisa enviada</td>
  </tr>
  <tr>
    <td>/filter/cascade-percentage</td>
    <td>GET</td>
    <td>Funciona igual ao caminho /filter/cascade, porém em vez de retornar o número de pesquisas, retorna a porcentagem em cascata de acordo com a ordem de prioridade.</td>
  </tr>
</table>
