#!/bin/bash

DIRECT_GRANT_RESPONSE=$(curl -i --request POST http://localhost:8080/auth/realms/master/protocol/openid-connect/token --header "Accept: application/json" --header "Content-Type: application/x-www-form-urlencoded" --data "grant_type=password&username=admin&password=admin&client_id=admin-cli");
export DIRECT_GRANT_RESPONSE

ACCESS_TOKEN=$(echo $DIRECT_GRANT_RESPONSE | grep "access_token" | sed 's/.*\"access_token\":\"\([^\"]*\)\".*/\1/g');
export ACCESS_TOKEN

curl -i --request POST http://localhost:8080/auth/admin/realms/list-keep/localization/ru -F "file=@ru.json" --header "Content-Type: multipart/form-data" --header "Authorization: Bearer $ACCESS_TOKEN";
