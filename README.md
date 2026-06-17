# 🖥️ account-ui

> A Spring Boot web UI for account management — part of the **Askie Solutions** microservices ecosystem.

---

## 📖 Overview

`account-ui` is a server-rendered frontend service built with **Spring Boot 4** and **Thymeleaf**. It sits at the edge of the platform, delivering account-related views to end users while communicating with backend services via a REST client. The service is containerised, health-checked, and wired into a shared Docker bridge network alongside the rest of the stack.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 4.1 |
| Templating | Thymeleaf |
| HTTP Client | Spring RestClient |
| Observability | Spring Actuator |
| Build | Maven Wrapper |
| Container | Docker / Docker Compose |
| CI/CD | GitHub Actions |

---

## 🚀 Getting Started

### Prerequisites

- Java 25+
- Docker & Docker Compose (for containerised run)

### Run locally

```bash
./mvnw spring-boot:run
```

The app will be available at `http://localhost:8080/accounts`.

### Run with Docker Compose

```bash
docker compose up --build
```

The container exposes port `8080` and joins the `askie-solutions-network` bridge network.

Health endpoint: `http://localhost:8080/accounts/actuator/health`

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/org/askiesolutions/accountui/
    │   ├── AccountUiApplication.java   # Entry point
    │   └── view/
    │       └── WelcomeView.java        # Controller
    └── resources/
        ├── templates/
        │   ├── layout/base.html        # Base layout
        │   ├── fragments/              # Header, footer, sidebar, right-panel
        │   └── pages/welcome.html      # Welcome page
        ├── static/
        │   ├── css/                    # base, layout, components stylesheets
        │   └── images/logo.jpg
        └── application.yaml
```

---

## ⚙️ CI / CD

The project uses a fully automated **three-stage pipeline**:

| Workflow | Trigger | Description |
|---|---|---|
| 🧪 **Test** | Push / PR to `master` | Runs unit tests, then integration tests sequentially |
| 📦 **Publish** | After successful Test | Publishes JAR to GitHub Packages and pushes Docker image to GHCR (tagged `latest` + `sha-*`) |
| 🚢 **Deploy** | After successful Publish | SSH deploys the Docker image to a VPS |

> Manual dispatch is available on all three workflows for on-demand runs.

---

## 🔧 Configuration

| Property | Default | Description |
|---|---|---|
| `server.servlet.context-path` | `/accounts` | Base path for all endpoints |
| `spring.application.name` | `account-ui` | Service name |

---

## 📄 License

[MIT](https://opensource.org/licenses/MIT) — © Adam Pawłowski ([@Askie01](https://github.com/Askie01))
