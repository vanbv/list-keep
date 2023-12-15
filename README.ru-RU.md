[![Language](https://img.shields.io/badge/Language-English-blue.svg)](README.md)
[![List Keep Front](https://img.shields.io/badge/List%20Keep-Front-informational.svg)](https://github.com/vanbv/list-keep-front)
[![List Keep Helm Chart](https://img.shields.io/badge/List%20Keep-Helm%20Chart-informational.svg)](https://github.com/vanbv/list-keep-chart)
[![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-green)](https://spring.io/projects/spring-boot)
[![Keycloak](https://img.shields.io/badge/-Keycloak-blue)](https://www.keycloak.org/)

# List Keep
Сервис для составления списков.

## Быстрый старт
Для запуска сервиса требуется запущенный экземпляр [Keycloak](https://www.keycloak.org/).
Для разработки можно использовать `docker-compose.yml`, в котором есть все требуемые для запуска сервисы.

После первого запуска [Keycloak](https://www.keycloak.org/) нужно выполнить `/keycloak/init.sh` для инициализации realm
`list-keep`, а так же для добавления отсутствующих переводов текстовок.

Перед запуском в файле `realm-export.json` значения `**********` заменить следующим образом:
* `smtpServer` сконфигурирован для почты gmail, при использовании другой почты необходимо поменять не только поля,
  приведенные ниже, но и другие.
  * `password` - пароль от почты
  * `from` и `user` - адрес почты
* `identityProviders` сконфигурированный для `google` (`providerId` = `google`).
  * `clientId` - `Client ID` приложения в google
  * `clientSecret` - `Client secret` приложения в google

## Клиентская часть
[List Keep Front](https://github.com/vanbv/list-keep-front)

## Helm chart
[List Keep Helm Chart](https://github.com/vanbv/list-keep-chart)
