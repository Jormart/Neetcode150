
# 💸 Smart Expense Tracker – Microservices-Based

A modern, cloud-native **expense tracking system** built using **Spring Boot**, **Kafka**, **Docker**, **Kubernetes**, and **GCP**. This project demonstrates scalable microservices architecture with real-time event-driven capabilities.

---

## 🧩 Microservices Overview

| Service              | Description                                              |
|----------------------|----------------------------------------------------------|
| `auth-service`       | User registration, login, and JWT-based authentication.  |
| `expense-service`    | CRUD for daily expenses, categories, and Kafka producer. |
| `reporting-service`  | Aggregates and reports expenses (monthly, by category).  |
| `notification-service` | Kafka consumer, mock email/SMS alerts for large expenses. |
| `config-server`      | Centralized config management with Git backend.          |
| `eureka-server`      | Service registry and discovery via Netflix Eureka.       |
| `api-gateway`        | Routes requests to services, JWT validation and filtering. |

---

## 📦 Tech Stack

- **Java 17** + Spring Boot
- **Spring Cloud** (Eureka, Config, Gateway)
- **Spring Security** + JWT
- **Apache Kafka** (event-based communication)
- **PostgreSQL / MySQL** (per service DB)
- **Docker** + **Kubernetes** (via GKE)
- **Jenkins** (CI/CD pipeline)
- **Swagger/OpenAPI** (API documentation)
- **JUnit5 + Mockito** (unit & integration testing)
- **GCP**: GKE, Artifact Registry, Cloud SQL, Secret Manager

---

## ⚙️ Setup Instructions

### 🐳 Run with Docker (Local Development)

```bash
docker-compose up --build
````

> Requires Docker and Docker Compose installed.

---

### ☁️ Deploy to GKE (Google Kubernetes Engine)

1. Authenticate to GCP and configure kubectl:

   ```bash
   gcloud auth login
   gcloud container clusters get-credentials <your-cluster>
   ```

2. Build & Push Docker Images:

   ```bash
   docker build -t <gcp-repo>/auth-service ./auth-service
   docker push <gcp-repo>/auth-service
   ```

3. Apply Kubernetes manifests:

   ```bash
   kubectl apply -f k8s/manifests/
   ```

---

## 🔐 Authentication Flow

1. User registers or logs in via `auth-service`.
2. Receives a JWT token.
3. All further requests must include the JWT in `Authorization: Bearer <token>`.
4. API Gateway validates and routes to appropriate microservices.

---

## 🔁 Event Flow Example

1. User adds a large expense via `expense-service`.
2. An event is published to Kafka: `ExpenseAdded`.
3. `notification-service` consumes the event and sends a mock alert.
4. `reporting-service` updates its reports accordingly.

---

## 📊 Reporting API Examples

* `GET /api/reports/monthly`
* `GET /api/reports/category?month=04&year=2025`

---

## 🧪 Testing Strategy

* **Unit Tests**: With JUnit5 & Mockito.
* **Integration Tests**: With Spring Boot Test, TestContainers for DB/Kafka.
* **Contract Testing** (optional): With Pact or Spring Cloud Contract.

---

## 📁 Project Structure

```
smart-expense-tracker/
├── auth-service/
├── expense-service/
├── reporting-service/
├── notification-service/
├── config-server/
├── eureka-server/
├── api-gateway/
├── k8s/                 # Kubernetes manifests
├── jenkins/             # Jenkinsfile for CI/CD
└── docs/                # Swagger docs, diagrams, etc.
```

---

## 📄 License

[MIT License](LICENSE)

---

## 👨‍💻 Contributors

* [Your Name](https://github.com/yourusername) – Creator & Lead Developer

---

## 🌐 API Documentation

Each service exposes its Swagger UI:

```
http://localhost:<port>/swagger-ui.html
```

---

## ✅ Todo

* [ ] Add frontend dashboard (React/Angular)
* [ ] Enable real email/SMS integration (Twilio, SendGrid)
* [ ] Implement user budgets and notifications
* [ ] Add Prometheus + Grafana for monitoring

```

---

Would you like this README.md delivered as a downloadable file, or added to a GitHub repo?
```
