# 🚀 Task Manager API

## 📌 Descripción

API REST para gestión de tareas con autenticación JWT.

---

## 🛠️ Tecnologías

* Java 17
* Spring Boot 3
* PostgreSQL
* Spring Security + JWT
* Docker
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

mvn clean package
docker build -t taskmanager-api .
docker run -p 8080:8080 taskmanager-api

---

## 🐳 Docker Compose

docker-compose up --build

---

## 🌐 Deploy

👉 https://tu-api.onrender.com

---

## 🧪 Testing

mvn test
