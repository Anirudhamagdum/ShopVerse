# 🛒 ShopVerse – Microservices-based E-Commerce Backend

ShopVerse is a Spring Boot-based microservices architecture for an e-commerce platform, built with modularity, scalability, and containerization in mind.

---

## 🧩 Microservices Included

- ✅ **Account Service** – User registration, login, and profile management  
- 🛍️ **Product Service** – Add, view, and search products  
- 🛒 **Cart Service** – Add to cart, remove items, and manage quantities  
- 🎯 **Order Service** – Place and manage orders  
- 💖 **Wishlist Service** – Manage wishlist items  
- 🚀 **API Gateway** – Unified access point using Spring Cloud Gateway  
- 🧭 **Eureka Server** – Service Discovery  
- 🐘 **PostgreSQL** – Persistent backend database

---



## 🏗️ Tech Stack

- Java 17, Spring Boot
- Spring Cloud Gateway & Eureka
- Spring Data JPA + PostgreSQL
- Docker & Docker Compose
- OpenFeign for inter-service communication

---



## 🚀 How to Run (Dockerized Setup)

```bash
# Clone the repo
git clone https://github.com/Anirudhamagdum/ShopVerse.git
cd ShopVerse

# Build and start all containers
docker-compose up --build

---
# ShopVerse Microservices API Endpoints

This document outlines the API endpoints for the ShopVerse microservices application, accessible via the API Gateway running on `http://localhost:8080`.

**Note:** Ensure all Docker Compose services are up and running before testing these endpoints.

---

## Product Service Endpoints

Handles product information management.

### 1. Get All Products
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/product/getallproducts?userName=Anirudha`
    * **Query Parameter:** `userName` (e.g., `Anirudha`)

### 2. Add Product
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/product/addproduct`
* **Body (raw, JSON):**
    ```json
    {
        "productId": "PROD123",
        "productName": "Wireless Headphones",
        "description": "Noise-cancelling over-ear wireless headphones with 30-hour battery life.",
        "price": 2999.99,
        "discount": 10.5,
        "deliveryCharges": 49.0,
        "averageRating": 4,
        "sellerName": "Anirudha Electronics",
        "category": "Electronics"
    }
    ```

### 3. Search Product
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/product/searchproduct?prefix=iP`
    * **Query Parameter:** `prefix` (e.g., `iP` for "iPhone")

### 4. Get Product Details
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/product/getdetails?productName=iPhone 16&sellerName=AppleStore`
    * **Query Parameters:**
        * `productName` (e.g., `iPhone 16`)
        * `sellerName` (e.g., `AppleStore`)

---

## Cart Service Endpoints

Manages shopping cart operations.

### 1. Add Item to Cart
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/cart/addItem?userName=Raju&productName=Wireless Headphones&sellerName=Anirudha Electronics&quantity=2`
    * **Query Parameters:**
        * `userName` (e.g., `Raju`)
        * `productName` (e.g., `Wireless Headphones`)
        * `sellerName` (e.g., `Anirudha Electronics`)
        * `quantity` (e.g., `2`)

### 2. Get Cart
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/cart/getcart?userName=Raju`
    * **Query Parameter:** `userName` (e.g., `Raju`)

### 3. Update Item Quantity in Cart
* **Method:** `PUT`
* **URL:** `http://localhost:8080/api/cart/updatequantity?userName=Raju&productName=Wireless Headphones&sellerName=Anirudha Electronics&newQuantity=6`
    * **Query Parameters:**
        * `userName` (e.g., `Raju`)
        * `productName` (e.g., `Wireless Headphones`)
        * `sellerName` (e.g., `Anirudha Electronics`)
        * `newQuantity` (e.g., `6`)

### 4. Delete Item from Cart
* **Method:** `DELETE`
* **URL:** `http://localhost:8080/api/cart/deleteitem?userName=Raju&productName=Wireless Headphones&sellerName=Anirudha Electronics`
    * **Query Parameters:**
        * `userName` (e.g., `Raju`)
        * `productName` (e.g., `Wireless Headphones`)
        * `sellerName` (e.g., `Anirudha Electronics`)

### 5. Get Total Price in Cart
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/cart/gettotalprice?userName=Raju`
    * **Query Parameter:** `userName` (e.g., `Raju`)

---

## Order Service Endpoints

Manages user orders.

### 1. Place Order
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/order/placeorder`
* **Body (raw, JSON):**
    ```json
    {
      "userName": "Anirudha",
      "displayName": "Wireless Headphones",
      "sellerName": "Anirudha Electronics",
      "price": 2999.99,
      "quantity": 2
    }
    ```

### 2. Place Order from Cart
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/order/placeorderfromcart?userName=Raju&productName=Wireless Headphones&sellerName=Anirudha Electronics`
    * **Query Parameters:**
        * `userName` (e.g., `Raju`)
        * `productName` (e.g., `Wireless Headphones`)
        * `sellerName` (e.g., `Anirudha Electronics`)

### 3. Get All Orders (Note: URL points to Account Service)
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/account/checkuser?userName=Anirudha`
    * **Note:** The URL in your Postman collection for "getallorders" points to `/api/account/checkuser`. Please verify if this is the intended endpoint for retrieving all orders, or if it should be an order-specific endpoint.
    * **Query Parameter:** `userName` (e.g., `Anirudha`)

### 4. Get Orders by Status
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/order/getorderbystatus?userName=Raju&orderStatus=PLACED`
    * **Query Parameters:**
        * `userName` (e.g., `Raju`)
        * `orderStatus` (e.g., `PLACED`, `DELIVERED`, `CANCELLED`, `RETURNED`)

### 5. Cancel Order
* **Method:** `PUT`
* **URL:** `http://localhost:8080/api/order/cancelorder?orderId=67683&userName=Raju`
    * **Query Parameters:**
        * `orderId` (e.g., `67683` - **replace with actual ID**)
        * `userName` (e.g., `Raju`)

### 6. Mark as Delivered
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/order/markasdelivered?orderId=F648F&userName=Anirudha`
    * **Query Parameters:**
        * `orderId` (e.g., `F648F` - **replace with actual ID**)
        * `userName` (e.g., `Anirudha`)

### 7. Add Feedback
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/order/addfeedback`
* **Body (raw, JSON):**
    ```json
    {
      "userName": "Anirudha",
      "orderId": "6CC0A",
      "feedback": "Excellent quality and fast delivery!",
      "rating": 5
    }
    ```
    * **Note:** Replace `orderId` with an actual ID from a user's order.

### 8. Return Order
* **Method:** `PUT`
* **URL:** `http://localhost:8080/api/order/returnorder?orderId=6CC0A&userName=Anirudha`
    * **Query Parameters:**
        * `orderId` (e.g., `6CC0A` - **replace with actual ID**)
        * `userName` (e.g., `Anirudha`)

---

## Account Service Endpoints

Handles user account management.

### 1. Check User
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/account/checkuser?userName=Anirudha`
    * **Query Parameter:** `userName` (e.g., `Anirudha`)

### 2. Login
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/account/login?name=Anirudha&password=Anirudha@123`
    * **Query Parameters:**
        * `name` (e.g., `Anirudha`)
        * `password` (e.g., `Anirudha@123`)

### 3. Register
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/account/register`
* **Body (raw, JSON):**
    ```json
    {
        "name" : "sample user",
        "password":"Sample@123",
        "confirmPassword":"Sample@123",
        "email":"sample@gmail.com"
    }
    ```

---

## Wishlist Service Endpoints

Manages user wishlists.

### 1. Add to Wishlist
* **Method:** `POST`
* **URL:** `http://localhost:8080/api/wishlist/addtowishlist`
* **Body (raw, JSON):**
    ```json
    {
      "userName": "Anirudha",
      "displayName": "Wireless Headphones",
      "shortDesc": "Noise-cancelling over-ear Bluetooth headphones",
      "category": "Electronics"
    }
    ```

### 2. Get Wishlist
* **Method:** `GET`
* **URL:** `http://localhost:8080/api/wishlist/getwishlist?userName=Anirudha`
    * **Query Parameter:** `userName` (e.g., `Anirudha`)

### 3. Delete from Wishlist
* **Method:** `DELETE`
* **URL:** `http://localhost:8080/api/wishlist/deletefromwishlist?userName=Anirudha&wishlistId=C165E`
    * **Query Parameters:**
        * `userName` (e.g., `Anirudha`)
        * `wishlistId` (e.g., `C165E` - **replace with actual ID from a wishlist**)

---

## Developed By

👨‍💻 Anirudha Magdum  
🚀 Passionate about building scalable backend systems with Spring Boot and Microservices.

