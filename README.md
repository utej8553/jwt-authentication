# jwt-authentication
## 📂 Endpoints

| Method | Endpoint        | Description                | Auth Required |
|--------|----------------|----------------------------|--------------|
| POST   | `/auth/signup` | Register a new user        | ❌ No         |
| POST   | `/auth/login`  | Login and get JWT token    | ❌ No         |
| GET    | `/api/secure`  | Protected test endpoint    | ✅ Yes        |

---

## ⚙️ How It Works

### **Step 1: User Signs Up**
- **Endpoint:** `POST /auth/signup`
- You send a **username** and **password** in JSON.
- The password is encrypted using **BCrypt** before storing.
- *(In this demo, it’s stored in an in-memory Map, but in real apps you’d use a database.)*

---

### **Step 2: User Logs In**
- **Endpoint:** `POST /auth/login`
- You send your **username** and **password**.
- The server verifies your password by comparing the encrypted version.
- If correct, the server generates a **JWT token**:
  - Contains the **username** in its payload.
  - Has an **expiration time** (e.g., 1 hour).
  - Is **signed** using a secret key so it can’t be tampered with.

---
### **Step 3: Accessing Protected APIs**
- **Endpoint:** `GET /api/secure`
- You must send:

---
## 🧪 Testing with Postman

### 1. Signup (No JWT needed)
POST http://localhost:8080/auth/signup  
Content-Type: application/json  

Body:
{
  "username": "john",
  "password": "mypassword"
}

✅ Expected Response:
User registered successfully!

---

### 2. Login (Get JWT token)
POST http://localhost:8080/auth/login  
Content-Type: application/json  

Body:
{
  "username": "john",
  "password": "mypassword"
}

✅ Expected Response:
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huIiwiaWF0Ijox...  
(Copy this token)

---

### 3. Access Secure Endpoint (JWT required)
GET http://localhost:8080/api/secure  
Authorization: Bearer <your_token_here>  

✅ Expected Response:
✅ This is a secure endpoint. You are authenticated!

---

### 4. Unauthorized Test
Remove the Authorization header and call /api/secure again.  

❌ Expected Response:
401 Unauthorized

### **Step 3: Accessing Protected APIs**
- **Endpoint:** `GET /api/secure`
- You must send:
