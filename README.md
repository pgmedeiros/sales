### sales - explicação do projeto

##### Para fazer uma nova venda, faça:

**POST** localhost:8080/newsale

```
{
    "value" : 210.00,
    "date" : "2001-01-01",
    "salesPerson" : {
        "id" : 1
    }
}

É necessário informar valor, data e o objeto salesPerson onde seu único atributo é o id, referente a qual vendedor realizou tal venda.
```

##### Para fazer a busca de dados, faça: 

**POST** localhost:8080/data

```
[
    {
        "date" : "2001-01-01", 
    }, 
    {
    	"date" : "2001-01-20"
    }
]

Apenas as datas são informadas.
```

