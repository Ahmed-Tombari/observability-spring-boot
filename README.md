# 📊 Observability in Spring Boot Applications  

## 🚀 Project Overview  
This project demonstrates how to implement observability in a Spring Boot application using modern tools for metrics, logs, and distributed tracing. The setup is containerized using Docker Compose for easy deployment and scalability.

---
![observability Springboot](https://github.com/user-attachments/assets/9f148375-d03f-4435-8603-1fc54858084b)

---

## 🛠️ Tech Stack & Tools  
- **Spring Boot**: Backend application.  
- **Prometheus**: Metrics collection and monitoring.  
- **Grafana**: Visualization of metrics, logs, and traces.  
- **Tempo**: Distributed tracing.  
- **Loki**: Log aggregation and querying.  
- **Postgres**: Relational database.  
- **pgAdmin**: Database management GUI.  

---

## 📦 Features  
- Centralized monitoring with Prometheus.  
- Comprehensive dashboards with Grafana.  
- Distributed tracing with Tempo for better performance diagnostics.  
- Log aggregation with Loki for easier debugging.  
- Persistent database storage with Postgres and management via pgAdmin.  

---

## 🏗️ Deployment Instructions  

### Prerequisites  
- Docker and Docker Compose installed on your system.  
- Port availability for the services (check the port mappings below).  

### Steps  
1. Clone the repository:  
   ```bash
   git clone # 📊 Observability in Spring Boot Applications  

## 🚀 Project Overview  
This project demonstrates how to implement observability in a Spring Boot application using modern tools for metrics, logs, and distributed tracing. The setup is containerized using Docker Compose for easy deployment and scalability.

---

## 🛠️ Tech Stack & Tools  
- **Spring Boot**: Backend application.  
- **Prometheus**: Metrics collection and monitoring.  
- **Grafana**: Visualization of metrics, logs, and traces.  
- **Tempo**: Distributed tracing.  
- **Loki**: Log aggregation and querying.  
- **Postgres**: Relational database.  
- **pgAdmin**: Database management GUI.  

---

## 📦 Features  
- Centralized monitoring with Prometheus.  
- Comprehensive dashboards with Grafana.  
- Distributed tracing with Tempo for better performance diagnostics.  
- Log aggregation with Loki for easier debugging.  
- Persistent database storage with Postgres and management via pgAdmin.  

---

## 🏗️ Deployment Instructions  

### Prerequisites  
- Docker and Docker Compose installed on your system.  
- Port availability for the services (check the port mappings below).  

### Steps  
1. Clone the repository:  
   ```bash
   git clone https://github.com/your-username/observability-spring-boot.git
   cd observability-spring-boot
2. Access the services in your browser:

Prometheus: http://localhost:9090
Grafana: http://localhost:3000
Tempo: http://localhost:3200
Loki: No UI, integrates with Grafana.
Spring Boot App: http://localhost:8082
pgAdmin: http://localhost:5100

## 🛠️ Key services:
**Prometheus** : Configured to collect metrics from the Spring Boot application.
**Tempo** : Captures distributed traces and integrates with Grafana.
**Loki** : Manages log aggregation for querying in Grafana.
**Grafana** : Connects to Prometheus, Tempo, and Loki for visualization.
**Postgres** : Database for the application.
**pgAdmin** : GUI for managing the Postgres database.


