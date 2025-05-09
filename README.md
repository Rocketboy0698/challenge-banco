
# 💳 Challenge Bancario – Proyecto Java Spring Boot

Este proyecto consiste en el desarrollo de un microservicio bancario que expone una API REST para gestionar clientes, cuentas y movimientos. Incluye funcionalidades básicas como creación, lectura, actualización y eliminación (CRUD), además de validaciones de saldo, despliegue en Docker y exposición en la nube mediante Render y Azure API Management (APIM).

---

## 🛠️ Tecnologías Utilizadas

- Java 17 (Amazon Corretto)
- Spring Boot
- H2 Database (en memoria)
- JPA (Java Persistence API)
- Docker
- Postman
- Azure API Management
- Render.com
- Visual Studio Code

---

## 📁 Estructura del Proyecto

```bash
├── model/               # Entidades: Cliente, Cuenta, Movimiento, Persona
├── controller/          # Controladores REST
├── repository/          # Interfaces JPA para persistencia
├── BancoApplication.java# Main class
├── dockerfile           # Para contenedorización
├── BaseDatos.sql        # Script con esquema de la base de datos
├── postman_collection.json # Exportación de pruebas de Postman
```

---

## 📌 Funcionalidades Implementadas

| Código | Descripción                                                                 |
|--------|------------------------------------------------------------------------------|
| F1     | CRUD completo para Cliente, Cuenta y Movimiento                              |
| F2     | Registro de movimientos con actualización automática del saldo              |
| F3     | Validación de saldo insuficiente para retiros                               |
| F7     | Despliegue en contenedor Docker                                             |
| F8     | Documentación automática con Swagger / OpenAPI                              |
| F9     | Publicación de la API en Render.com                                         |
| F10-11 | Proyecto de Azure APIM y carga de documentación con OpenAPI                 |
| F12    | Autenticación por clave (suscripción) en Azure API Management               |
| F13    | (Intentado) Eliminación de campo en el request via políticas de Azure       |
| F14    | (Intentado) Personalización de errores 400, 401, 403, 404 vía Azure Policies|

---

## 🚀 Despliegue del Proyecto

### 🔹 Local con Docker

```bash
docker build -t banco-app .
docker run -p 8085:8080 banco-app
```

Accede a la API en: `http://localhost:8085`

### 🔹 Render.com

- URL base: https://challenge-banco.onrender.com
- No requiere autenticación.
- Puede dormirse si no recibe tráfico en algunos minutos.

### 🔹 Azure API Management

- URL base: http://api-banco-andres.azure-api.net
- Requiere Header: `Ocp-Apim-Subscription-Key: 681d8d783984aa0063070001`

---

## 🧪 Pruebas con Postman

- Se incluyen pruebas para:
  - Crear cliente
  - Obtener clientes
  - Crear movimiento
  - Validación de saldo insuficiente
- Archivo: [`postman_collection.json`](./postman_collection.json)

---

## 🧾 Script Base de Datos

Archivo: [`BaseDatos.sql`](./BaseDatos.sql)

Contiene la estructura de tablas para Persona, Cliente, Cuenta y Movimiento, útil para entornos productivos fuera de H2.

---

## 📤 Ejemplo de Pruebas en Postman

### ✅ Vía Azure API Management (requiere suscripción)

Base URL:  
http://api-banco-andres.azure-api.net/clientes

#### 🟢 GET – Listar Clientes (Azure)
- Método: GET  
- URL: `http://api-banco-andres.azure-api.net/clientes`  
- Headers:  
  `Ocp-Apim-Subscription-Key: 681d8d783984aa0063070001`

#### 🟢 POST – Crear Cliente (Azure)
- Método: POST  
- URL: `http://api-banco-andres.azure-api.net/clientes`  
- Headers:  
  - Content-Type: application/json  
  - Ocp-Apim-Subscription-Key: 681d8d783984aa0063070001  
- Body:
```json
{
  "identificacion": 123456789,
  "nombre": "Juan Pérez",
  "genero": "masculino",
  "edad": 30,
  "direccion": "Quito",
  "telefono": "0999999999",
  "contrasena": "clave123",
  "estado": true
}
```

### 🌐 Vía Render (no requiere autenticación)

Base URL:  
https://challenge-banco.onrender.com/clientes

#### 🟢 GET – Listar Clientes (Render)
- Método: GET  
- URL: `https://challenge-banco.onrender.com/clientes`

#### 🟢 POST – Crear Cliente (Render)
- Método: POST  
- URL: `https://challenge-banco.onrender.com/clientes`  
- Headers:  
  - Content-Type: application/json  
- Body:
```json
{
  "identificacion": 987654321,
  "nombre": "Ana García",
  "genero": "femenino",
  "edad": 28,
  "direccion": "Guayaquil",
  "telefono": "0987654321",
  "contrasena": "clave456",
  "estado": true
}
```

---

## ✍️ Autor

**Andrés Escobar**  
[LinkedIn](https://www.linkedin.com/in/andreslec14) – [GitHub](https://github.com/Rocketboy0698)

---

## 📧 Entrega

Este proyecto se presenta como parte de una prueba técnica para desarrollador backend (nivel Junior), usando arquitectura de microservicios y herramientas modernas de despliegue y documentación.