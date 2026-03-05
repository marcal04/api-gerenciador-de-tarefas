API REST desenvolvida com Spring Boot para gerenciamento de tarefas, permitindo operações completas de CRUD (Create, Read, Update, Delete).

Tecnologias Utilizadas
Java 21
Spring Boot 4
Spring Data JPA
Hibernate
PostgreSQL
Maven

Estrutura do Projeto
controller  → Camada responsável pelos endpoints REST
service     → Regras de negócio
repository  → Comunicação com o banco de dados
model       → Entidades e enums

Funcionalidades
✔ Criar tarefa
✔ Listar todas as tarefas
✔ Buscar tarefa por ID
✔ Atualizar tarefa
✔ Deletar tarefa

Endpoints da API
Criar tarefa
POST /tarefas

{
  "titulo": "Estudar Spring Boot",
  "descricao": "Aprender API REST",
  "status": "PENDENTE"
}
Listar todas
GET /tarefas

Buscar por ID
GET /tarefas/{id}

Atualizar tarefa
PUT /tarefas/{id}

{
  "titulo": "Atualizado",
  "descricao": "Nova descrição",
  "status": "CONCLUIDA"
}
Deletar tarefa
DELETE /tarefas/{id}

Retorno (200):

{
  "mensagem": "Tarefa deletada com sucesso"
}
🗄 Configuração do Banco
Crie um banco no PostgreSQL:

tarefas_db
Configure o application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/tarefas_db
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

👨‍💻 Autor
Desenvolvido por Guilherme Marçal 🚀
