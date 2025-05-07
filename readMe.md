# Banco de Sangue - teste de conhecimento técnico

Aplicação web desenvolvida com o objetivo de consumir um JSON e extrair dele os seguintes resultados:

-  Quantos candidatos em cada estado do Brasil;
-  IMC médio em cada faixa de idade de dez em dez anos;
-  Percentual de obesos entre os homens e entre as mulheres;
-  Média de idade para cada tipo sanguíneo;
-  Quantidade de possíveis doadores para cada tipo sanguíneo receptor.

---

## Tecnologias Utilizadas
### 🔧 Backend
- Java 17
- Spring Boot
- PostgreSQL
- JPA
- FlywayDB
- Jackson (para manipulação JSON)
- Maven

### 🎨 Frontend
- HTML5 + CSS3
- Bootstrap 4.6
- JavaScript + jQuery
- Chart.js (gráficos)
- SweetAlert2 (alertas)
- Thymeleaf (uso de fragments para importação de scripts e links css)

---
## Acesso ao Projeto

O projeto está hospedado no Render e pode ser acessado através do seguinte link:

[https://banco-de-sangue.onrender.com/home](https://banco-de-sangue.onrender.com/home)

*OBS.: Por estar hospedado em um servidor gratuito do Render, a aplicação pode apresentar um pouco de lentidão e/ou loading ao entrar no link, mas basta aguardar alguns segundos ;).

---
---
## 📥 Download do Arquivo JSON

Você pode baixar o arquivo de dados JSON utilizado no projeto diretamente pelo link abaixo:

[📄 Clique aqui para baixar o arquivo `dados.json`](https://github.com/enzogl7/banco-de-sangue/raw/main/dados.json)

---
## 💡 Como rodar o projeto localmente?
### ✅ Pré-requisitos
- Java JDK 17+
- Maven
- Git
- PostgreSQL
### ⚙️ Variáveis de Ambiente
| Variável              | Descrição                              | Valor padrão             | Exemplo                          |
|-----------------------|------------------------------------------|---------------------------|----------------------------------|
| `URL_BANCO`           | URL de conexão com o PostgreSQL         | `jdbc:postgresql://localhost:5432/banco_sangue` | `jdbc:postgresql://localhost:5432/teste` |
| `USER_BANCO`          | Usuário do banco                        | `postgres`                | `admin`                          |
| `SENHA_BANCO`         | Senha do banco                          | `123`                     | `suaSenhaSegura`                |
---
### ℹ️ Passo a passo
#### 🔽 1. Criar a database no Postgres
Certifique-se de criar uma database no PgAdmin com o nome de sua preferência antes de tentar subir o projeto.

- Instale o PostgreSQL - https://www.postgresql.org/download/
- No menu iniciar, procure por PgAdmin
- Clique em servers > botão direito em PostgreSQL > Create > Database
- Crie a database com seu nome de preferência

*Certifique de lembrar-se do nome de usuário e senha cadastrados no usuário do PostgreSQL na instalação, será necessário declarar nas variáveis de ambiente

---
#### 🔽 2. Definir variáveis de ambiente (substitua por suas respectivas credenciais/nomes)
🪟 Windows PowerShell:
```
[Environment]::SetEnvironmentVariable("URL_BANCO", "jdbc:postgresql://localhost:5432/nome_banco", "User")
[Environment]::SetEnvironmentVariable("USER_BANCO", "user-postgres", "User")
[Environment]::SetEnvironmentVariable("SENHA_BANCO", "senha-postgres", "User")
```
---
#### 🔽 3. Clonar o repositório e rodar a aplicação
💻 CMD:
```
git clone https://github.com/enzogl7/banco-de-sangue.git
cd banco-de-sangue
mvn spring-boot:run
```

##### *A aplicação estará disponível em: localhost:8080/home
##### *Caso enfrente problemas para subir o projeto, a aplicação está disponível em: [https://banco-de-sangue.onrender.com/home](https://banco-de-sangue.onrender.com/home)

---
##### ✉️ enzolima527@gmail.com

