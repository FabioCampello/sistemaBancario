# sistemaBancario

### Tecnologias utilizadas

- Java 8
- Maven
- Spring Boot
- Spring Data Jpa
- TomCat
- MySql

### Urls

Todas as urls responderão no formato **JSON**.

#### Agencia

```
GET - http://localhost:8080/sistemaBancario/api/ag/findAll
GET - http://localhost:8080/sistemaBancario/api/agencia/findById/{id}
PUT - http://localhost:8080/sistemaBancario/api/agencia/updateSaveAgencia
PUT - http://localhost:8080/sistemaBancario/api/agencia/updateSaveAgencia/{id}
DELETE - http://localhost:8080/sistemaBancario/api/agencia/deleteById/{id}
GET - http://localhost:8080/sistemaBancario/api/agencia/findByCodigo/{id}
```

#### Cliente 

```
GET - http://localhost:8080/sistemaBancario/api/cliente/findAll
GET - http://localhost:8080/sistemaBancario/api/cliente/findById/{id}
PUT - http://localhost:8080/sistemaBancario/api/cliente/updateSaveCliente
PUT - http://localhost:8080/sistemaBancario/api/cliente/updateSaveCliente/{id}
DELETE - http://localhost:8080/sistemaBancario/api/cliente/deleteById/{id}
```

#### ContaCorrente 

```
GET - http://localhost:8080/sistemaBancario/api/cc/findAll
GET - http://localhost:8080/sistemaBancario/api/cc/findById/{id}
PUT - http://localhost:8080/sistemaBancario/api/cc/updateSaveContaCorrente
PUT - http://localhost:8080/sistemaBancario/api/cc/updateSaveContaCorrente/{id}
DELETE - http://localhost:8080/sistemaBancario/api/cc/deleteById/{id}
```

#### Endereco 

```
GET - http://localhost:8080/sistemaBancario/api/endereco/findAll
GET - http://localhost:8080/sistemaBancario/api/endereco/findById/{id}
PUT - http://localhost:8080/sistemaBancario/api/endereco/updateSaveEndereco
PUT - http://localhost:8080/sistemaBancario/api/endereco/updateSaveEndereco/{id}
DELETE - http://localhost:8080/sistemaBancario/api/endereco/deleteById/{id}
GET - http://localhost:8080/sistemaBancario/api/endereco/findByAgenciaId/{id}
```

#### Movimentacao 

```
GET - http://localhost:8080/sistemaBancario/api/movimentacao/findAll
GET - http://localhost:8080/sistemaBancario/api/movimentacao/findById/{id}
PUT - http://localhost:8080/sistemaBancario/api/movimentacao/updateSaveMovimentacao
PUT - http://localhost:8080/sistemaBancario/api/movimentacao/updateSaveMovimentacao/{id}
DELETE - http://localhost:8080/sistemaBancario/api/movimentacao/deleteById/{id}
```
