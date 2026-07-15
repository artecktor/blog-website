# درنگ (Derang) — Blog Website

<div align="center">

A modern full-stack blog platform built with Java Spring Boot and a custom Persian (RTL) frontend.

Designed for reading, writing, and discussing ideas without noise.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![HTML](https://img.shields.io/badge/HTML5-E34F26)
![CSS](https://img.shields.io/badge/CSS3-1572B6)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E)
![License](https://img.shields.io/badge/License-MIT-blue)

</div>

---

## Overview

درنگ (Derang) is a full-stack blogging platform focused on clean design, readability, and user interaction.

The project combines a Java Spring Boot backend with a handcrafted frontend built using HTML, CSS, and vanilla JavaScript.

Users can browse articles, read full blog posts, leave ratings and comments, and explore related content in an elegant Persian RTL interface.

The goal of this project was not only to build a functional blog system, but also to create an experience that feels calm, minimal, and visually intentional.

---

## Features

### Blog System

- View all published blog posts
- Read complete articles
- Dynamic loading of blog content
- Estimated reading time calculation
- Related posts suggestions

### Comments & Reviews

- Leave comments on articles
- 1–5 star rating system
- Comments sorted dynamically
- Comment timestamps
- User validation before posting

### User Handling

- User identification using username/password
- Backend user lookup
- Comment ownership support

### Frontend

- Fully responsive layout
- RTL (Right-to-left) Persian interface
- Custom handcrafted design
- Smooth transitions and hover effects
- Dynamic content loading via Fetch API

### Backend

- REST API architecture
- DTO-based request handling
- Service layer structure
- Spring MVC controllers
- Database integration

---

## Screenshots

### Homepage

<img width="100%" src="screenshots/homepage.png">

### Blog Page

<img width="100%" src="screenshots/blog-page.png">

### Comment Section

<img width="100%" src="screenshots/comments.png">

> Replace these images with actual screenshots from your project.

---

# Tech Stack

## Backend

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- REST API

## Frontend

- HTML5
- CSS3
- Vanilla JavaScript
- Fetch API

## Database

- MySQL *(or whichever database you used)*

---

# Project Structure

```bash
blog-website/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controllers/
│   │   │   ├── services/
│   │   │   ├── repositories/
│   │   │   ├── models/
│   │   │   ├── dto/
│   │   │   └── config/
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── style.css
│   │       │   ├── scripts/
│   │       │   └── images/
│   │       │
│   │       └── templates/
│   │
│   └── test/
│
├── screenshots/
├── pom.xml
└── README.md
```

---

# Installation

Clone the repository:

```bash
git clone https://github.com/artecktor/blog-website.git
```

Move into the project:

```bash
cd blog-website
```

Run the project:

```bash
#./mvnw spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

Application starts at:

```bash
http://localhost:8080
```

---

# Database Setup

Configure your database connection in:

```properties
application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# API Endpoints

## Blogs

### Get all blogs

```http
GET /blogs
```

### Get blog by ID

```http
GET /blogs/{id}
```

---

## Comments

### Get comments for a blog

```http
GET /comments/blog/{id}
```

### Get sorted comments

```http
GET /comments/blog/{id}/sorted
```

### Save a comment

```http
POST /comments/save
```

Body:

```json
{
    "userId":1,
    "blogId":3,
    "rating":5,
    "text":"Great article!"
}
```

---

## Users

### Get all users

```http
GET /users
```

### Get user by ID

```http
GET /users/{id}
```

---

# Frontend Logic

The frontend uses JavaScript Fetch API for communication with the backend.

Example:

```javascript
fetch("http://localhost:8080/blogs")
    .then(response => response.json())
    .then(data => {
        console.log(data);
    });
```

---

# Design Philosophy

The interface is intentionally designed around:

- Simplicity
- Readability
- Minimal distractions
- Persian typography
- Comfortable spacing
- Calm visual hierarchy

Instead of building a noisy content feed, the project aims to feel closer to reading a journal.

---

# Future Improvements

Planned features:

- User authentication with Spring Security
- JWT authentication
- User profiles
- Rich text editor
- Blog categories
- Search functionality
- Like system
- Bookmarking posts
- Admin dashboard
- Image uploads
- Pagination
- Dark mode

---

# Contributing

Contributions, ideas, and suggestions are welcome.

1. Fork the repository
2. Create a feature branch

```bash
git checkout -b feature/new-feature
```

3. Commit changes

```bash
git commit -m "Add new feature"
```

4. Push branch

```bash
git push origin feature/new-feature
```

5. Open a Pull Request

---

# License

This project is licensed under the MIT License.

---

<div align="center">

Built with ☕ and probably too many late-night debugging sessions.

</div>