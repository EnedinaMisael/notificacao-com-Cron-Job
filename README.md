# 📢 Sistema de Notificações com Spring Boot e Tarefas Agendadas

Este projeto tem como objetivo demonstrar a criação de um sistema de notificações utilizando **Java com Spring Boot**, incluindo funcionalidades como:

- Geração automática de notificações com uso de **@Scheduled (Cron Job)**
- Filtro de notificações por tipo
- Marcar notificações como lidas
- Listagem de notificações não lidas
- Integração com banco de dados via **JPA**

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- MySQL (ajustável)
- Maven

---

## 🧠 Funcionalidades

- `GET /notificacoes`: lista todas as notificações
- `POST /notificacoes`: cria uma nova notificação
- `GET /notificacoes/gerar-automaticas`: endpoint de teste que gera notificações manualmente com base em regras (ex: faturas vencendo)
- `GET /notificacoes/nao-lidas`: exibe apenas notificações não lidas
- `Patch /notificacoes/{id}/marcar-como-lida`: marca uma notificação como lida
- `GET /notificacoes/tipo/{tipo}`: filtra notificações por tipo

---

## 🕒 Tarefa Agendada (Cron)

O sistema executa automaticamente a verificação de faturas prestes a vencer e gera notificações para cada um, utilizando a anotação `@Scheduled` com expressão cron personalizada.

