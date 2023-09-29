# Project-CRUD-Angular-Spring (Backend)

Este é o backend de uma aplicação de exemplo para gerenciamento de cursos e suas respectivas aulas. Foi desenvolvido com Spring Boot (Java) e utiliza o PostgreSQL como banco de dados. A aplicação oferece funcionalidades de CRUD para cursos e aulas, além de recursos de paginação e testes unitários para a camada de serviço.

## Funcionalidades

- Cadastro, atualização e exclusão de cursos.
- Visualização da lista de cursos e seus detalhes.
- Cadastro, atualização e exclusão de aulas.
- Visualização da lista de aulas associadas a um curso.
- Paginação para listar cursos.
- Testes unitários para a camada de serviço.

## Tecnologias Utilizadas

- **Spring Boot (Java)**: Framework Java para desenvolvimento de aplicativos web.
- **PostgreSQL**: Banco de dados relacional para armazenar informações de cursos e aulas.
- **DBeaver**: Uma ferramenta de gerenciamento de banco de dados que oferece uma interface gráfica para visualizar, editar e administrar bancos de dados PostgreSQL e outras bases de dados. O DBeaver é utilizado para facilitar o gerenciamento e a interação com o banco de dados PostgreSQL, tornando mais fácil a administração e visualização dos dados da aplicação.
- **JUnit e Mockito**: Frameworks de teste para testes unitários na camada de serviço.
- **Docker**: Utilizado para criar containers isolados para o banco de dados PostgreSQL.

## Como Executar o Projeto Localmente

Siga as etapas abaixo para executar o projeto localmente:

1. Clone o repositório do GitHub:

   ```bash
   git clone https://github.com/seu-usuario/seu-projeto-backend.git
   cd seu-projeto-backend
   ```
   
2. Certifique-se de ter o Java JDK 11 instalado.

3. Certifique-se de ter o Docker instalado.

4. Inicialize o Banco de Dados PostgreSQL usando Docker:

5. Navegue até o diretório database-docker no projeto backend e execute o seguinte comando:

	```bash
	cd database-docker
	docker-compose up -d
	```
	
- Isso iniciará um container Docker com o PostgreSQL e o DBeaver (uma ferramenta de gerenciamento de banco de dados) para facilitar a visualização dos dados.

6. Acesse o DBeaver para gerenciar o banco de dados:

- Abra o DBeaver e crie uma nova conexão PostgreSQL para o servidor localhost na porta 5432. As credenciais padrão são geralmente postgres como usuário e senha.

7. Inicialize o projeto Spring Boot:

- Execute a aplicação Spring Boot. O servidor estará disponível em http://localhost:8080.

## Como Executar a Aplicação com Docker
Se você preferir, também pode executar a aplicação usando Docker. Certifique-se de ter o Docker instalado em sua máquina.

1. Clone o repositório do GitHub:

	```bash
	git clone https://github.com/seu-usuario/seu-projeto-backend.git
	cd seu-projeto-backend
	```

- Certifique-se de ter o Docker instalado.

2. Crie a imagem Docker usando o Dockerfile personalizado:

- Navegue até o diretório raiz do projeto backend (onde o Dockerfile está localizado) e execute o seguinte comando:

	```bash
	docker build -t meu-projeto-backend
	```
	
- Execute o contêiner Docker:

	```bash
	docker run -p 8080:8080 meu-projeto-backend
	```
	
- O servidor estará disponível em http://localhost:8080.

## Testes Unitários

- A camada de serviço do projeto contém testes unitários. Para executá-los, basta rodar os testes do projeto em sua IDE de desenvolvimento ou usando o Maven:

	```bash
	mvn test
	```
	
- Certifique-se de que o banco de dados Docker esteja em execução ao executar os testes unitários.

- Observação: Lembre-se de substituir "seu-usuario/seu-projeto-backend" pelo caminho real do seu repositório no GitHub. Este README fornece um guia básico para iniciar o backend da aplicação, configurar o banco de dados PostgreSQL e rodar a aplicação localmente ou via Docker.
