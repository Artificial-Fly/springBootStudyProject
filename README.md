# Spring Boot Study Project - Учебный REST API проект

## 📋 Описание проекта

Этот репозиторий представляет собой учебный проект для изучения создания RESTful API с использованием **Java 17** и **Spring Boot 3.2.0**. Проект демонстрирует базовую реализацию CRUD-операций для управления пользователями с использованием современных технологий Java-экосистемы.

## 🎯 Основные цели проекта

- Освоение основ Spring Boot 3.x
- Реализация REST API с поддержкой всех CRUD операций
- Интеграция с базой данных PostgreSQL через Spring Data JPA
- Изучение работы с Maven Wrapper для управления зависимостями
- Практика работы с современным стеком технологий Java

## 🏗️ Архитектура проекта

Проект реализован с использованием классической трехслойной архитектуры:

1. **Controller слой** (`UserController`) - обработка HTTP запросов
2. **Service слой** (`UserService`) - бизнес-логика приложения  
3. **Repository слой** (`UserRepository`) - взаимодействие с базой данных

```
springBootStudyProject/
├── src/main/java/com/springboot/demo/
│ ├── ProjectExampleApplication.java # Главный класс приложения
│ ├── controller/
│ │ └── UserController.java # REST контроллер
│ ├── service/
│ │ └── UserService.java # Сервисный слой с бизнес-логикой
│ └── repository/
│ ├── User.java # Entity-класс
│ └── UserRepository.java # JPA репозиторий
├── src/test/java/com/springboot/demo/
│ └── ProjectExampleApplicationTests.java # Тесты
├── src/main/resources/
│ └── application.properties # Конфигурация приложения
├── pom.xml # Конфигурация Maven
├── mvnw # Maven wrapper для Unix
├── mvnw.cmd # Maven wrapper для Windows
└── .mvn/wrapper/
└── maven-wrapper.properties # Конфигурация Maven wrapper
```

## 🛠️ Технологии и зависимости

### Основной стек
- **Java 17** - язык программирования
- **Spring Boot 3.2.0** - фреймворк для создания приложений
- **Maven 3.9.12** - система сборки (через Maven Wrapper)

### Зависимости в `pom.xml`
- `spring-boot-starter-web` - для создания веб-приложений
- `spring-boot-starter-data-jpa` - для работы с базами данных
- `postgresql` - драйвер PostgreSQL
- `jackson-datatype-jsr310` - поддержка работы с датами в JSON
- `spring-boot-starter-validation` - валидация данных
- `spring-boot-devtools` - горячая перезагрузка для разработки
- `spring-boot-starter-test` - тестирование

## 🗄️ Модель данных

Сущность `User` содержит следующие поля:

| Поле | Тип | Описание |
|------|-----|----------|
| `id` | `Long` | Уникальный идентификатор (автоинкремент) |
| `name` | `String` | Имя пользователя |
| `email` | `String` | Email пользователя (уникальный) |
| `birth` | `LocalDate` | Дата рождения |
| `age` | `Integer` | Возраст (автоматически рассчитывается) |

Таблица в базе данных: `users`

## 🚀 REST API Endpoints

### Базовый URL: `http://localhost:8080/api/users`

| Метод | Endpoint | Описание | Пример тела запроса |
|-------|----------|----------|---------------------|
| **GET** | `/` | Получить всех пользователей | - |
| **POST** | `/` | Создать нового пользователя | `{"name":"Иван", "email":"ivan@mail.com", "birth":"1990-01-01"}` |
| **PUT** | `/{id}` | Обновить пользователя | Параметры: `email`, `name` |
| **DELETE** | `/{id}` | Удалить пользователя по ID | - |

## ⚙️ Настройка и запуск

### **Предварительные требования**
- Java 17 или выше
- PostgreSQL
- Maven

### **Шаги для запуска:**

1. **Клонировать репозиторий**
   ```bash
   git clone https://github.com/Artificial-Fly/springBootStudyProject.git
   cd springBootStudyProject
   ```

2. **Настроить базу данных PostgreSQL**
   - Создать базу данных: `SpringBootStudyProject`
   - Проверить/обновить параметры в `application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/SpringBootStudyProject
     spring.datasource.username=postgres
     spring.datasource.password=postgres
     ```

3. **Запустить приложение**
   ```bash
   mvn spring-boot:run
   ```

4. **Проверить работу приложения**
   ```
   Открыть в браузере: [http://localhost:8080/api/users](http://localhost:8080/api/users)
