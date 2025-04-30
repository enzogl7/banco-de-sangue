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
### ℹ️ Passo a passo (Opção 1)
#### 🔽 Clonar o repositório
```
git clone https://github.com/enzogl7/banco-de-sangue.git
cd banco-de-sangue
```
#### 🔽 Rodar a aplicação
```./mvnw spring-boot:run```

*A aplicação estará disponível em: localhost:8080/home


