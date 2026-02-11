# 

# 🚀 Java10X-Desafio-Tecnico-Itau
> Projeto apresentado como desáfio do curso Java10X.

---

## 📋 Índice
- [Sobre](#-sobre)
- [Tecnologias](#-tecnologias)
- [Instalação](#-instalação)
- [Como Executar](#-como-executar)
- [Como Rodar Container Docker](#-como-rodar-container-docker)
- [Como Rodar Aplicação com Observabilida via Docker](#-como-rodar-aplicação-com-observabilida-via-docker)
- [Rotas da Aplicação](#rotas-da-aplicação)
- [Rotas de Observabilidade](#rotas-de-observabilidade)
- [Documentação da API com Swagger](#-documentação-da-api-com-swagger)

## 💻 Sobre
API para criar transações e trazer estatísticas calculadas com base em um limite de segundos. <br><br>

Os dados foram armazenados em memória. <br> 
A estrutura de dados usada para armazenar as transações foi a implementação da `Lista`, o `ArrayList`


## 🛠 Tecnologias
As principais ferramentas utilizadas no desenvolvimento:
- [JDK21 - (Java Development Kit 21)](https://www.oracle.com/br/java/technologies/downloads/#java21)
- [Spring-Boot: 4.0.2](https://spring.io/projects/spring-boot) (Starter Web, Actuator, Validation)
- [Maven: 3.9.X](https://maven.apache.org/download.cgi)
- [SpringDoc OpenAPI (Swagger) 2.8.4](https://springdoc.org)
- [Micrometer Prometheus](https://micrometer.io) (Observabilidade)

## ⬇️ Instalação
Siga os passos abaixo para instalar o projeto em sua máquina local:

1. **Baixe e instale o JDK21 e o Maven na versão 3.9.X.**

2. **Clone o repositório:**
   ```bash
   git clone git@github.com:Joao-Pedro-J/java10x-desafio-tecnico-itau.git
    ```
3. **Entrar no diretório:**
    ```bash
   cd java10x-desafio-tecnico-itau
    ```

## 🚀 Como Executar
Siga os passos abaixo para rodar o projeto em sua máquina local:


1. **Baixar dependências:**
    ```bash
   mvn clean install
    ```

2. **Rodar a aplicação:**
    ```bash
   mvn spring-boot:run
   ```

## 🐳 Como Rodar Container Docker

1. **Instalar docker:**
    [Instalar](https://www.docker.com/)

2. **Criar imagem da aplicação:** *obs (têm que estar na raiz do projeto)*
    ```bash
   docker build -f infra/Dockerfile -t desafio-itau .
   ```

3. **Rodar container com a imagem criada**
    ```bash
   docker run -p 8080:8080 -d desafio-itau
   ```
   
## 🐳 Como Rodar Aplicação com Observabilida via Docker

1. **Instalar docker:**
   [Instalar](https://www.docker.com/)

2. **Subir containers:** *obs (têm que estar na raiz do projeto)*
    ```bash
   docker compose -f infra/compose.yml up -d
   ```

## Rotas da Aplicação:

| Método | URL                        | URI        | DESCRIÇÃO               |
|:-------|:---------------------------|:-----------|:------------------------|
| POST   | `http://localhost/transacao` | `/transacao` | Cria uma nova transação |
| DELETE | `http://localhost/transacao` | `/delete` | Deleta todas as transações armazenadas |
| GET    | `http://localhost/estatistica` | `/estatistica` | Calcula todas as transações com base em um limite de segundos e retorna alguns valores. |

### 📦 Exemplos de Payload (JSON)

**RequestBody da requisição `/transacao` com método POST:**
```json
  {
    "valor": 123.45,
    "dataHora": "2024-05-20T10:30:00.000Z"
  }
```

**ResponseBody da requisição `/estatistica` com método GET:**
```json
  {
      "count": 10,
      "sum": 1234.50,
      "avg": 123.45,
      "min": 10.00,
      "max": 500.00
  }
```

## Rotas de Observabilidade
**Obs.: essas rotas só estarão disponíveis se rodar a [aplicação com observabilidade via docker](#-como-rodar-aplicação-com-observabilida-via-docker).**

### 🔥 Prometheus

**URL da dashboard:**
```http
http://localhost:9090
```

**URL do prometheus na docker network:**
```http
http://prometheus:9090
```

### 📈 Grafana

**URL da dashboard:**
```http
http://localhost:3000
```


## 🖹 Documentação da API com Swagger

**Documentação no endpoint:**
```http
http://localhost:8080/swagger-ui/index.html
```