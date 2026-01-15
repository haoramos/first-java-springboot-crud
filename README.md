# Primeiro CRUD com Spring Boot

Este é um projeto simples de CRUD (Create, Read, Update, Delete) desenvolvido com Java e Spring Boot. O objetivo é demonstrar o gerenciamento de usuários com operações básicas de banco de dados.

## Tecnologias Utilizadas

*   **Java 21**: Linguagem de programação principal.
*   **Spring Boot**: Framework para facilitar a configuração e criação da aplicação.
*   **Spring Data JPA**: Abstração para persistência de dados.
*   **H2 Database**: Banco de dados em memória para testes rápidos e desenvolvimento.
*   **Lombok**: Biblioteca para reduzir a verbosidade do código Java (geração automática de Getters, Setters, etc.).
*   **Maven**: Gerenciador de dependências e build.

## Estrutura do Projeto

O código fonte está localizado em `src/main/java/com/haoramoss/primeiro_crud`.
As camadas principais são:

*   **Controller**: (`UsuarioController`) Responsável por expor os endpoints da API REST.
*   **Service**: (`UsuarioService`) Contém a lógica de negócio da aplicação.
*   **Repository**: (`UsuarioRepository`) Interface para comunicação com o banco de dados.
*   **Entity**: (`Usuario`) Representa a tabela do banco de dados.

## Como Executar

Para executar o projeto, você precisa ter o Java instalado em sua máquina.

1.  Clone o repositório ou baixe o código fonte.
2.  Abra um terminal na raiz do projeto.
3.  Execute o comando abaixo para rodar a aplicação usando o Maven Wrapper:

    **Linux/macOS:**
    ```bash
    ./mvnw spring-boot:run
    ```

    **Windows:**
    ```bash
    mvnw.cmd spring-boot:run
    ```

A aplicação iniciará na porta padrão `8080`.

## Endpoints da API

Você pode testar os endpoints utilizando ferramentas como Postman ou Insomnia, ou via `curl`.

*   **Criação (POST)**: `/usuario`
*   **Busca (GET)**: `/usuario?email=seu@email.com`
*   **Atualização (PUT)**: `/usuario?id={id}`
*   **Remoção (DELETE)**: `/usuario?email=seu@email.com`

---
Desenvolvido por Haoramos
