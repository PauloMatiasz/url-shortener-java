🔗 URL Shortener API (Java)

Uma API REST para encurtamento de URLs desenvolvida em Java, com foco em desempenho, escalabilidade e boas práticas de arquitetura.

🚀 Funcionalidades
🔗 Encurtar URLs longas
📥 Redirecionamento automático para a URL original
📊 (Opcional) Contagem de acessos
⏳ (Opcional) Expiração de links
🧩 Arquitetura modular e escalável
🛠️ Tecnologias utilizadas
☕ Java
🌱 Spring Boot
🍃 MongoDB
🐳 Docker 
📂 Estrutura do projeto
src/
 ├── application/       # Regras de negócio
 ├── domain/            # Entidades e modelos
 ├── infrastructure/    # Banco de dados e integrações
 └── interface/         # Controllers (API REST)
⚙️ Como rodar o projeto
🔧 Pré-requisitos
Java 17+
Maven
MongoDB rodando localmente
▶️ Executando
# Clonar repositório
git clone https://github.com/PauloMatiasz/url-shortener-java.git

# Entrar na pasta
cd url-shortener-java

# Rodar aplicação
./mvnw spring-boot:run
📌 Endpoints principais
🔹 Encurtar URL
POST /shorten

Request:

{
  "url": "https://exemplo.com"
}

Response:

{
  "shortUrl": "http://localhost:8080/abc123"
}
🔹 Redirecionar
GET /{code}

👉 Redireciona para a URL original

🧠 Conceitos aplicados
Clean Architecture

Separação de responsabilidades

API RESTful

Boas práticas com Spring Boot

Integração com banco NoSQL

🔥 Possíveis melhorias

🔐 Autenticação com JWT

📈 Dashboard de métricas

🌍 Deploy em nuvem (AWS, Azure, etc.)

⚡ Cache com Redis

📊 Rate limiting

🤝 Contribuição

👨‍💻 Autor

Desenvolvido por Paulo Matias

Se quiser, posso deixar esse README ainda mais forte:
