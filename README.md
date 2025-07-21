
# 🛒 ShopVerse – Microservices-based E-Commerce Backend

ShopVerse is a Spring Boot-based **microservices architecture** for a modular, scalable, and production-ready e-commerce backend system. It includes complete support for authentication, product management, cart, orders, wishlist, and service discovery — all containerized using Docker.

---

## 🧩 Microservices Included

- ✅ **Account Service** – User registration, login, and profile management  
- 🛍️ **Product Service** – Add, view, and search products  
- 🛒 **Cart Service** – Add to cart, remove items, and manage quantities  
- 🎯 **Order Service** – Place, cancel, return, and manage orders with feedback  
- 💖 **Wishlist Service** – Add, retrieve, and delete wishlisted items  
- 🚀 **API Gateway** – Unified entry point using Spring Cloud Gateway  
- 🧭 **Eureka Server** – Microservices discovery with Netflix Eureka  
- 🐘 **PostgreSQL** – Persistent database for each microservice

---

## 🏗️ Tech Stack

- **Java 17**, **Spring Boot 3.5+**
- **Spring Cloud Gateway**, **Netflix Eureka**
- **Spring Data JPA + PostgreSQL**
- **OpenFeign** – For clean inter-service communication
- **Docker + Docker Compose** – Container orchestration

---

## 🚀 How to Run (Dockerized Setup)

```bash
# Clone the repository
git clone https://github.com/Anirudhamagdum/ShopVerse.git
cd ShopVerse

# Build and run all services
docker-compose up --build
```

> ⚠️ Make sure you have Docker Desktop running and ports `8080`, `8761`, and `8433` (custom PostgreSQL) are free.

---

## 📬 Postman Collection

👉 [Click here to view the Postman Collection](https://web.postman.co/workspace/My-Workspace~df37cf1f-d550-45e3-8502-f080defe608f/collection/39300276-93e59eac-5c7b-41fd-aac0-db1b3b1b747d?action=share&creator=39300276)

---

## 📖 ShopVerse Microservices API Endpoints

<details>
<summary><strong>Click to expand full list</strong></summary>

```http
GET    /api/account/checkuser
POST   /api/account/login
POST   /api/account/register

GET    /api/product/getallproducts
POST   /api/product/addproduct
GET    /api/product/searchproduct
GET    /api/product/getdetails

POST   /api/cart/addItem
GET    /api/cart/getcart
PUT    /api/cart/updatequantity
DELETE /api/cart/deleteitem
GET    /api/cart/gettotalprice

POST   /api/order/placeorder
POST   /api/order/placeorderfromcart
GET    /api/account/checkuser
GET    /api/order/getorderbystatus
PUT    /api/order/cancelorder
POST   /api/order/markasdelivered
POST   /api/order/addfeedback
PUT    /api/order/returnorder

POST   /api/wishlist/addtowishlist
GET    /api/wishlist/getwishlist
DELETE /api/wishlist/deletefromwishlist
```

</details>

---

## 👨‍💻 Developed By

**Anirudha Magdum**  
Backend Developer & Spring Boot Enthusiast  
📫 [LinkedIn Profile](https://www.linkedin.com/in/anirudha-magdum-738447229/)  
🚀 Passionate about building scalable backend systems with Microservices architecture.

---

## 🌐 License

This project is open-source under the MIT License.
