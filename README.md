# Sistema de Gestão de Recursos Humanos (SGRH)

## Descrição do Projeto
O **SGRH** é um sistema de gestão de recursos humanos desenvolvido em **Java**, utilizando **Spring Boot**, **JPA/Hibernate** e **PostgreSQL**.  
O projeto foi desenvolvido como parte do currículo académico, mas seguindo boas práticas de desenvolvimento profissional, visando servir também como **projeto de portfólio**.

Ele contempla o gerenciamento de:
- **Colaboradores**: cadastro, atualização, desativação, consulta de dados;
- **Cargos**: associação a departamentos, ativação/desativação;
- **Departamentos**: gerenciamento de nomes, descrições e registros ativos;
- **Ausências**: registro de ausências com validação de sobreposição e status (pendente, aprovada, rejeitada, cancelada).

O projeto está preparado para futura integração com **Spring Security**, permitindo controle de acesso baseado em perfis (ADMIN/RH), embora esta funcionalidade ainda não esteja ativa.

---

## Tecnologias e Ferramentas

- **Linguagem:** Java 17  
- **Framework:** Spring Boot 3.x  
- **Persistência:** Spring Data JPA / Hibernate  
- **Banco de Dados:** PostgreSQL  
- **Gerenciamento de Dependências:** Maven  
- **Mapeamento DTO:** MapStruct  
- **Controle de Versionamento:** Git / GitHub  
- **Documentação e Logs:** SLF4J / Lombok
- **Testes:** JUnit

---

## Estrutura do Projeto

O sistema está organizado em camadas:

Aplicação Cliente (Web, Postman, etc.)
│
Camada de Controller (REST endpoints)
│
Camada de Serviço (Regra de Negócio)
│
Camada de Domínio (Entidades JPA)
│
Camada de Persistência (Repositories)


**Exemplos de entidades principais:**
- `Colaborador` → FK para `Cargo`, lista de `Ausencias`
- `Cargo` → FK para `Departamento`, atributo `ativo`
- `Departamento` → nome único e ativo
- `Ausencia` → vinculo com `Colaborador`, status e datas

---

## Regras de Negócio

1. **Colaborador**
   - Não pode existir dois colaboradores com mesmo email ou NIF;
   - Colaboradores podem ser ativos ou desativados;
   - Não é permitido associar cargo inativo a um colaborador.

2. **Cargo**
   - Nome único por cargo;
   - Deve estar vinculado a um departamento ativo;
   - Somente cargos ativos são atribuíveis.

3. **Departamento**
   - Nome único;
   - Cadastro e listagem de departamentos ativos.

4. **Ausência**
   - Valida datas de início e fim;
   - Não permite sobreposição de ausências ativas ou pendentes;
   - Status: PENDENTE → (APROVADA | REJEITADA), APROVADA → CANCELADA;
   - Colaborador inativo não pode registrar ausência.

5. **Erros e Exceções**
   - Todos os erros de negócio são tratados por `BusinessException`;
   - Exemplo de estrutura de resposta para erros:

```json
{
  "errorCode": "COLAB_EMAIL_DUPLICADO",
  "message": "Email já cadastrado",
  "timestamp": "2026-02-03T10:15:30",
  "status": 400
}
```
---

## Endpoints Principais (exemplos)
# Colaborador
 - `POST /api/colaboradores` → criar colaborador
 - `GET /api/colaboradores` → listar todos
 - `GET /api/colaboradores/{id}` → buscar por id
 - `PUT /api/colaboradores/{id}` → atualizar
 - `PATCH /api/colaboradores/{id}/desativar` → desativar

# Cargo
 - `POST /api/cargos` → criar cargo
 - `GET /api/cargos` → listar todos
 - `GET /api/cargos/departamento/{id}` → listar por departamento

# Departamento
 - `POST /api/departamentos` → criar departamento
 - `GET /api/departamentos` → listar todos

# Ausência
 - `POST /api/ausencias` → criar ausência
 - `GET /api/ausencias` → listar todas
 - `GET /api/ausencias/colaborador/{id}` → listar por colaborador
 - `PATCH /api/ausencias/{id}/status` → atualizar status
 - `PATCH /api/ausencias/{id}/cancelar` → cancelar ausência

# Como Rodar o Projeto
 - Configure o PostgreSQL e crie o banco sgrh.
 - Ajuste o application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/sgrh
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
 - Compile e execute
```
mvn clean install
mvn spring-boot:run
```
 - Teste os endpoints via Postman, Insomnia ou outro cliente HTTP.

---
## Autor
 - Valdemar Andrade
 - [GitHub](https://github.com/Valdemar-Andrade): GitHub
 - [LinkedIn](https://www.linkedin.com/in/valdemar-andrade-8b0b45189): LinkedIn
