# Leilões TDSat

Sistema desktop para uma casa de leilões, desenvolvido em Java (Swing) para cadastrar e listar os produtos que serão leiloados.

## Sobre o projeto

O projeto é a base de um sistema informatizado de leilões. A aplicação possui telas para cadastro de produtos (`cadastroVIEW`) e listagem de produtos (`listagemVIEW`), uma classe de acesso a dados (`ProdutosDAO`), um objeto de transferência de dados (`ProdutosDTO`) e a classe de conexão com o banco (`conectaDAO`).

Cada produto possui: **id**, **nome**, **valor** e **status** (por exemplo, `A Venda` ou `Vendido`).

## Tecnologias utilizadas

- Java (interface gráfica com Swing)
- MySQL / MariaDB (banco de dados `uc11`, tabela `produtos`)
- JDBC (MySQL Connector/J)
- Apache NetBeans (IDE)
- Git e GitHub (versionamento)

## Como executar

1. Importe o arquivo `uc11.sql` no seu SGBD (por exemplo, pelo phpMyAdmin).
2. Abra o projeto no NetBeans.
3. Confira a conexão em `conectaDAO.java` (`jdbc:mysql://localhost/uc11`).
4. Execute o projeto.
