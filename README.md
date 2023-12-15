[![Language](https://img.shields.io/badge/Language-Russian-blue.svg)](README.ru-RU.md)
[![List Keep Front](https://img.shields.io/badge/List%20Keep-Front-informational.svg)](https://github.com/vanbv/list-keep-front)
[![List Keep Helm Chart](https://img.shields.io/badge/List%20Keep-Helm%20Chart-informational.svg)](https://github.com/vanbv/list-keep-chart)
[![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-green)](https://spring.io/projects/spring-boot)
[![Keycloak](https://img.shields.io/badge/-Keycloak-blue)](https://www.keycloak.org/)

# List Keep
The service for lists making.

## Getting Started
To start the service you have to start instance [Keycloak](https://www.keycloak.org/).
For development, you can use `docker-compose.yml`, which have all services you need.

After first run of [Keycloak](https://www.keycloak.org/) you need to execute `/keycloak/init.sh` for initialization
realm `list-keep` and for adding missing translation messages.

Before starting replace the `**********` values in file `realm-export.json` as follows:
* `smtpServer` is configured for gmail service, when you use other service, you need to change not only below fields,
  but other one's.
    * `password` - password from email
    * `from` and `user` - email address
* `identityProviders` is configured for `google` (`providerId` = `google`).
    * `clientId` - `Client ID` of application in google
    * `clientSecret` - `Client secret` of application in google

## Frontend
[List Keep Front](https://github.com/vanbv/list-keep-front)

## Helm chart
[List Keep Helm Chart](https://github.com/vanbv/list-keep-chart)
