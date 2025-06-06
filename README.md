# BobApp – CI/CD Automation Project

Welcome to the BobApp project, a full-stack application designed to demonstrate a modern CI/CD pipeline and DevOps best practices.

## 🚀 Overview

BobApp is an application composed of a Java Spring Boot backend and an Angular frontend.
This project implements a complete CI/CD pipeline:

- Automatic execution of tests and code quality analysis on each push and pull request
- Generation and publication of Docker images to Docker Hub
- Measurement and tracking of code coverage and Quality Gates

## 🛠️ Implemented CI/CD Workflows

The project contains **two separate CI/CD pipelines** (one for the backend, one for the frontend), each triggered on every push or pull request. Both pipelines follow the same strict sequence of steps:

- **Build** the project (compilation for the backend, bundling for the frontend)
- **Run automated tests** and **publish test results** in GitHub Actions
- **Generate code coverage reports** (Jacoco for backend, Angular coverage for frontend)
- **Analyze code quality** using SonarCloud (consumes coverage reports)
- **Build a Docker image**
- **Push the Docker image to Docker Hub**

Each step will only execute if the previous step was successful.
The Docker image is only pushed to Docker Hub if all prior steps (build, tests, test results, coverage, quality analysis) have completed successfully.

Backend and frontend pipelines run in parallel but are fully independent.

## 📈 KPIs and Quality Gates

This project uses the **default "SonarWay" Quality Gate** from SonarCloud, which enforces:

- **No new blocker issues, bugs, or vulnerabilities** on new code
- **Coverage on new code** ≥ 80%
- **Duplication on new code** < 3%
- **No unreviewed Security Hotspots**

*(Global values are available on SonarCloud: for example, backend coverage: 38.8%, frontend: 83.3%)*

## ✅ Prerequisites

- **Java 11** (required for backend)
- **Maven 3.6+** (for backend build and tests)
- **Node.js 16+** (required for frontend)
- **npm 8+** (for frontend dependencies and scripts)
- **Docker** (for building and running containers; optional if you use only local setup)

## 📝 How to Use This Repository

1. **Clone the project**

   ```bash
   git clone https://github.com/maximedrouault/bobapp.git
   cd bobapp
   ```

2. **CI/CD workflows are triggered automatically on each push or PR**

    - Access results on the [Actions](https://github.com/maximedrouault/bobapp/actions) tab of the repository

3. **Check the generated Docker images**

    - [bobapp-back on Docker Hub](https://hub.docker.com/r/maximedrouault/bobapp-back)
    - [bobapp-front on Docker Hub](https://hub.docker.com/r/maximedrouault/bobapp-front)

4. **Check code quality and coverage**

    - [SonarCloud Backend Dashboard](https://sonarcloud.io/project/overview?id=maximedrouault_bobapp-back)
    - [SonarCloud Frontend Dashboard](https://sonarcloud.io/project/overview?id=maximedrouault_bobapp-front)

## 📂 Repository Structure

- `/back`: Spring Boot backend
- `/front`: Angular frontend

## ⚙️ Manual Setup & Usage

### Frontend

1. Go to the frontend folder:
   ```bash
   cd front
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the frontend app:
   ```bash
   npm run start
   ```
4. To build and run the Docker container:
   ```bash
   docker build -t bobapp-front .
   docker run -p 8080:8080 --name bobapp-front -d bobapp-front
   ```

#### Alternatively, you can run the latest Docker image from Docker Hub without building it locally:
   ```bash
   docker run -p 8080:8080 --name bobapp-front -d maximedrouault/bobapp-front:latest
   ```

### Backend

1. Go to the backend folder:
   ```bash
   cd back
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Start the backend app:
   ```bash
   mvn spring-boot:run
   ```
4. Run the tests:
   ```bash
   mvn clean verify
   ```
5. To build and run the Docker container:
   ```bash
   docker build -t bobapp-back .
   docker run -p 8080:8080 --name bobapp-back -d bobapp-back
   ```

#### Alternatively, you can run the latest Docker image from Docker Hub without building it locally:
   ```bash
   docker run -p 8080:8080 --name bobapp-back -d maximedrouault/bobapp-back:latest
   ```
