# Aplicação Angular para Gerenciamento de Cursos e Aulas

Este é um projeto Angular que se integra com uma API externa desenvolvida em Spring Boot e Java. A aplicação permite o gerenciamento de cursos e suas respectivas aulas por meio de operações CRUD (Create, Read, Update e Delete). Você também pode listar todos os cursos disponíveis, ainda estou desenvolvendo essa parte, mas é uma das melhorias que irei fazer, tanto a paginação quanto ao testes unitários.

## Funcionalidades

- Cadastro, leitura, atualização e exclusão de cursos.
- Visualização da lista de cursos e seus detalhes.
- Integração com uma API externa desenvolvida em Spring Boot e Java.
- Integração com recursos futuros, como paginação e testes unitários (em desenvolvimento).

## Pré-requisitos

Certifique-se de ter o seguinte software instalado em sua máquina antes de executar a aplicação:

- [Node.js](https://nodejs.org/): O Angular requer o Node.js para funcionar.
- [Angular CLI](https://cli.angular.io/): Ferramenta de linha de comando Angular para criar, compilar e testar projetos Angular.
- [Git](https://git-scm.com/): Ferramenta de controle de versão para clonar este repositório.
- [Docker](https://www.docker.com/): O Docker é uma plataforma para desenvolver, enviar e executar aplicativos em contêineres. Você precisará dele para criar e executar contêineres Docker da aplicação.


## Como Executar a Aplicação Localmente

Siga as etapas abaixo para executar a aplicação localmente:

1. Clone o repositório do GitHub:

   ```bash
   git clone https://github.com/seu-usuario/seu-projeto-angular.git
   cd seu-projeto-angular
   ```
   
2. Instale as dependências do projeto:

	```bash
	npm install
	```
	
3. Inicie a aplicação:

	```bash
	ng serve
	```
	
4. Abra seu navegador e acesse a aplicação em http://localhost:4200.

## Como Executar a Aplicação com Docker
Se você preferir, também pode executar a aplicação usando Docker. Certifique-se de ter o Docker instalado em sua máquina.

1. Clone o repositório do GitHub:

	```bash
	git clone https://github.com/seu-usuario/seu-projeto-angular.git
	cd seu-projeto-angular
	```
	
2. Crie a imagem Docker a partir do Dockerfile fornecido:

	```bash
	docker build -t meu-projeto-angular
	```

3. Execute o contêiner Docker:

	```bash
	docker run -p 8080:80 meu-projeto-angular
	```

4. Abra seu navegador e acesse a aplicação em http://localhost:8080.


## Recursos Futuros
Estou trabalhando em melhorias contínuas para esta aplicação. Alguns dos recursos futuros planejados incluem:

- Paginação: Permitirá navegar facilmente por longas listas de cursos.
- Testes Unitários: Adição de testes automatizados para garantir a qualidade do código.


