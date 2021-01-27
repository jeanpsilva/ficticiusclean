# Ficticius Clean API
>Api para previsão de gastos com veículos.

## Requisitos 
- Eclipse com Spring Tools 4
- Git
- Maven
- PostgreSQL 
- JDK 11
- Insomnia 

## Instalação
- Baixar o projeto
- Importar na IDE
- Criar um banco de dados no PostgreSQL com o nome ficticiusclean (Pode ser alterado no application.properties)
- Configurar conexão no banco de dados no arquivo application.properties (usuário, senha e string de conexão)
- Subir aplicação

## Utilizando a API

Na reaiz do projeto está disponível o arquivo [insomnia.json](https://github.com/jeanpsilva/ficticiusclean/blob/master/Insomnia.json) que deverá ser importado no insomnia para testes da API.

A API disponibiliza os seguintes endpoints:

**@GET /veiculos** - retorna uma lista de veículos cadastrados.
```
Response:
 [
  {
    "nome": "Ka",
    "marca": "Ford",
    "modelo": "gli",
    "dataFabricacao": "2020-03-17",
    "consumoMedioCidade": 10.3,
    "consumoMedioRodovia": 16.4,
    "id": 2
  }
]
```

**@GET /veiculos/{id}** - retorna o veículo com o Id informado.
```
Response:
{
  "nome": "Uno",
  "marca": "Fiat",
  "modelo": "Fire flex",
  "dataFabricacao": "2011-06-30",
  "consumoMedioCidade": 13.1,
  "consumoMedioRodovia": 18.84,
  "id": 1
}
```

**@GET /veiculos/find/{nome}** - retorna uma lista de veículos que possuem o nome informado.
```
Response:
[
  {
    "nome": "Uno",
    "marca": "Fiat",
    "modelo": "Fire flex",
    "dataFabricacao": "2011-06-30",
    "consumoMedioCidade": 13.1,
    "consumoMedioRodovia": 18.84,
    "id": 1
  }
]
```
**@GET /veiculos/previsaoGastos** - retorna uma lista de veiculos com a informação de gastos totais ordenados por menor valor.
```
Request:
{
	"preco" : "5.3958",
	"kmPercorridoCidade" : "150",
	"kmPercorridoRodovia" : "350"
}

Response:
[
  {
    "nome": "Uno",
    "marca": "Fiat",
    "modelo": "Fire flex",
    "ano": 2011,
    "quantidateCombustivelGasto": 30.02,
    "valorTotalGastoCombustivel": 162.02
  },
  {
    "nome": "Ka",
    "marca": "Ford",
    "modelo": "gli",
    "ano": 2020,
    "quantidateCombustivelGasto": 35.90,
    "valorTotalGastoCombustivel": 193.73
  }
]
```
**@POST /veiculos** - Realiza o cadastro de um novo veículo.
```
Request:
{
	"nome":"Fusca",
	"marca" : "VolksWagen", 
	"modelo" : "1300 L",
	"dataFabricacao" : "1975-09-14",
	"consumoMedioCidade" : "8.1",
	"consumoMedioRodovia" : "9.84"
}

Response:
{
  "nome": "Fusca",
  "marca": "VolksWagen",
  "modelo": "1300 L",
  "dataFabricacao": "1975-09-13",
  "consumoMedioCidade": 8.1,
  "consumoMedioRodovia": 9.84,
  "id": 6
}
```
**@PUT /veiculos/{id}** - Atualiza um veículo já cadastrado.
```
Request:
{
	"nome":"Uno",
	"marca" : "Fiat", 
	"modelo" : "Fire flex",
	"dataFabricacao" : "2011-07-01",
	"consumoMedioCidade" : "13.1",
	"consumoMedioRodovia" : "18.84"
}

```
**@DEL /veiculos/{id}** - Exclui um veículo.


## Contato

Jean Pierre – jeanpsilva@gmail.com

[https://github.com/jeanpsilva](https://github.com/jeanpsilva/)


