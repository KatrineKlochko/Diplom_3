# **Автоматизация тестов для приложения Stellar Burgers**

**Задание 3. Автотесты для UI**

Этот проект содержит набор автотестов UI для приложения бургерной Stellar Burgers

Тесты написаны с использованием JUnit 4, REST Assured, Selenium и Allure

Используемые технологии:

| технология            | версия |
|-----------------------|--------|
| Java                  | 11     |
| Maven Surefire Plugin | 2.22.2 |
| REST Assured          | 5.5.6  |
| Allure Framework      | 2.15.0 |
| JUnit                 | 4.13.2 |
| WebDriverManager      | 5.6.2  |
| AspectJ Weaver        | 1.9.21 |
| Allure Maven Plugin   | 2.10.0 |
| Selenium              | 4.38.0 |
| ---                   | ---    |



Запустить все тесты можно с помощью команды: mvn clean test

Сформировать и открыть отчёт после запуска тестов: allure serve target/allure-results

Запуск для Яндекс браузера: mvn test -Dbrowser=yandex