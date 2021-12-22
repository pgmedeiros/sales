### sales - explicação do projeto

Para acessar vendas de determinado período, faça:

**POST** localhost:8080/sales

```
[
    {
        "date" : "2001-01-01"
    },
    {
        "date" : "2001-01-20"
    }
]

[
    {
        dataInicial
    },
    {
        dataFinal
    }
]


```

[](

Para acessar a média de vendas por vendedor, faça: 

**POST** localhost:8080/average 

```
[{
    "date" : "2001-01-01"
},
{
    "date" : "2001-01-20"
},
{
    "id": 1
}]

[
{
	datainicial
}, 
{
	datafinal
}, 
{
	idDoVendedor
}
]
```

