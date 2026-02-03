# Sistema de Cadastro de Clientes e Produtos

Aplicação desktop em Java para cadastro e gerenciamento de clientes, produtos e vendas. O sistema oferece interface gráfica completa para inserir, consultar e visualizar registros, além de relacionar itens de venda aos respectivos clientes e produtos.

## Sobre o projeto
Projeto acadêmico desenvolvido no 2º período de Ciência da Computação com o objetivo de aplicar fundamentos de desenvolvimento de software, programação orientada a objetos e integração com banco de dados.

Este projeto foi criado no **NetBeans**. Apesar de não ser a IDE mais popular atualmente, ela foi excelente para construir uma interface do zero em Java, utilizando componentes como **JPanel**, **JOptionPane** e tabelas Swing.

## Tecnologias utilizadas
- Java (aplicação desktop)
- Swing (GUI: JFrame, JPanel, JTable, JOptionPane)
- PostgreSQL (banco de dados)
- JDBC (conexão e operações no banco)
- NetBeans (IDE de desenvolvimento)

## Como o projeto funciona
A aplicação está organizada em camadas simples:

- **Interface gráfica (Swing):** telas e formulários para cadastro e consulta.
- **Camada de modelo:** entidades como `Cliente`, `Produto`, `Venda` e `ItemVenda`.
- **DAO (Data Access Object):** operações de CRUD e consultas no banco via JDBC.
- **Tabela de vendas:** exibição de dados com `TableModel` personalizado para apresentar cliente, produto, quantidade, valor e total.

## Funcionalidades principais
- Cadastro e edição de clientes
- Cadastro e edição de produtos
- Registro de vendas com itens vinculados
- Listagens e consultas em tabelas
- Operações CRUD integradas ao PostgreSQL

## Conceitos aplicados
- Programação Orientada a Objetos (encapsulamento, herança, abstração, polimorfismo)
- Banco de dados relacional com PostgreSQL
- Estruturas de dados (listas e coleções em Java)

## Execução (visão geral)
1. Configure o PostgreSQL e crie o banco do projeto.
2. Ajuste as credenciais na classe de conexão JDBC.
3. Abra o projeto no NetBeans e execute a classe principal da interface.
