# 🚀 Task Manager API

## 📌 Descripción

API REST para gestión de tareas con autenticación JWT.

---

## 🛠️ Tecnologías

* Java 17
* Spring Boot 3
* PostgreSQL
* Spring Security + JWT
* SpringDoc-OpenApi
* JUnit + Mockito

---

## 🔐 Autenticación

Basada en JWT.

---

## 📦 Endpoints

### Auth

* POST /auth/register
* POST /auth/login

### Users

* GET /users

### Tasks

* GET /tasks
* POST /tasks
* PUT /tasks/{id}
* DELETE /tasks/{id}

---

## ▶️ Ejecución local

http://localhost:8080/swagger-ui/index.html#/

---

## 🧪 Testing

mvn test
