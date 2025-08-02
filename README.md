# 🛒 Microservices E-commerce Application

A distributed, microservices-based e-commerce platform built with Spring Boot and Spring Cloud technologies. The application is divided into three core services: Wallet, Shop, and Inventory.

## 🧩 Microservices Overview

### 1. 💳 Wallet Service
- User registration and login
- Wallet creation and balance management
- Deposit and withdrawal operations
- Transaction history endpoints

### 2. 🏬 Shop Service
- Product creation and listing
- Shopping cart management
- Order creation and payment processing
- Interacts with both Wallet and Inventory services

### 3. 📦 Inventory Service
- Product inventory management
- Real-time stock updates
- Communicates with Shop service

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Cloud (Eureka, Config Server, Gateway, Feign Client)
- Spring Data JPA
- postgeSQL
- Resilience4j (Circuit Breaker)
- Maven

---

## 🔌 Service Integration Features

- ✅ **Service Discovery** via **Eureka Server**
- 🔄 **Inter-service Communication** using **Feign Client**
- 💥 **Circuit Breaker Pattern** with **Resilience4j**
- 🛡️ **API Gateway** for routing and filtering
- ⚙️ **Spring Config Server** for centralized configuration

---

## 📐 Project Structure
<pre> <code> 
ecommerceApp/
├── EER/
├── api-gateway/
├── git-localconfig-repo/
├── naming-server/
├── spring-cloud-config-server/
├── inventory-service-first/
├── shop-service-first/
├── shop-service-second/
├── wallet-service-first/
├── wallet-service-second/
├── ports.txt 
</code> </pre>
