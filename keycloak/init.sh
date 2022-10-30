#!/bin/bash

export KEYCLOAK_URL=http://localhost:8080/auth
export KEYCLOAK_USERNAME=admin
export KEYCLOAK_PASSWORD=admin

DIRECT_GRANT_RESPONSE=$(curl -i -k --request POST $KEYCLOAK_URL/realms/master/protocol/openid-connect/token --header "Accept: application/json" --header "Content-Type: application/x-www-form-urlencoded" --data "grant_type=password&username=$KEYCLOAK_USERNAME&password=$KEYCLOAK_PASSWORD&client_id=admin-cli");
export DIRECT_GRANT_RESPONSE

ACCESS_TOKEN=$(echo $DIRECT_GRANT_RESPONSE | grep "access_token" | sed 's/.*\"access_token\":\"\([^\"]*\)\".*/\1/g');
export ACCESS_TOKEN

curl -i -k --request POST $KEYCLOAK_URL/admin/realms -d "@realm-export.json" --header "Content-Type: application/json" --header "Authorization: Bearer $ACCESS_TOKEN";

curl -i -k --request POST $KEYCLOAK_URL/admin/realms/list-keep/localization/ru -F "file=@ru.json" --header "Content-Type: multipart/form-data" --header "Authorization: Bearer $ACCESS_TOKEN";
