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

---
#### 🔽 2. Definir variáveis de ambiente (substitua por suas respectivas credenciais/nomes)
🪟 Windows PowerShell:
```
[Environment]::SetEnvironmentVariable("URL_BANCO", "jdbc:postgresql://localhost:5432/nome_banco", "User")
[Environment]::SetEnvironmentVariable("USER_BANCO", "user-postgres", "User")
[Environment]::SetEnvironmentVariable("SENHA_BANCO", "senha-postgres", "User")
```
---
#### 🔽 3. Clonar o repositório
```
git clone https://github.com/enzogl7/banco-de-sangue.git
cd banco-de-sangue
```
---
#### 🔽 4. Rodar a aplicação
```mvn spring-boot:run```

##### *A aplicação estará disponível em: localhost:8080/home

---
###### enzolima527@gmail.com

