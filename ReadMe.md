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
- SweetAlert2 (alertas bonitos)
- Thymeleaf (uso de fragments para importação de scripts e links css)

---
## 💡 Como rodar o projeto localmente?
### ✅ Pré-requisitos
- Java 17+
- Maven
- Git
- PostgreSQL
### ⚙️ Variáveis de Ambiente
| Variável              | Descrição                              | Valor padrão             | Exemplo                          |
|-----------------------|------------------------------------------|---------------------------|----------------------------------|
| `URL_BANCO`           | URL de conexão com o PostgreSQL         | `jdbc:postgresql://localhost:5432/banco_sangue` | `jdbc:postgresql://localhost:5432/teste` |
| `USER_BANCO`          | Usuário do banco                        | `postgres`                | `admin`                          |
| `SENHA_BANCO`         | Senha do banco                          | `123`                     | `suaSenhaSegura`                |
| `SPRING_PROFILE_ACTIVE` | Perfil ativo do Spring (`dev`, `prod`) | `dev`                     | `prod`                           |
---
### ℹ️ Passo a passo
#### 🔽 1. Definir variáveis de ambiente (substitua por suas respectivas credenciais/nomes)
🐧 Linux/macOS:
```
export URL_BANCO=jdbc:postgresql://localhost:5432/nomeseubanco
export USER_BANCO=seu-user
export SENHA_BANCO=sua-senha
export SPRING_PROFILE_ACTIVE=dev
```
🪟 Windows (PowerShell):
```
$env:URL_BANCO = "jdbc:postgresql://localhost:5432/nomeseubanco"
$env:USER_BANCO = "seu-user"
$env:SENHA_BANCO = "sua-senha"
$env:SPRING_PROFILE_ACTIVE = "dev"
```
---
#### 🔽 2. Clonar o repositório
```
git clone https://github.com/enzogl7/banco-de-sangue.git
cd banco-de-sangue
```
#### 🔽 3. Rodar a aplicação
```./mvnw spring-boot:run```

*A aplicação estará disponível em: localhost:8080/home


