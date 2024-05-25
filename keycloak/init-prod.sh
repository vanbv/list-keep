#!/bin/bash

export KEYCLOAK_URL=https://list-keep-keycloak-https-vanbv-1-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com
export KEYCLOAK_USERNAME=user
export KEYCLOAK_PASSWORD=CtD4.YA8tMLFgrc

DIRECT_GRANT_RESPONSE=$(curl -i -k --request POST $KEYCLOAK_URL/realms/master/protocol/openid-connect/token --header "Accept: application/json" --header "Content-Type: application/x-www-form-urlencoded" --data "grant_type=password&username=$KEYCLOAK_USERNAME&password=$KEYCLOAK_PASSWORD&client_id=admin-cli");
export DIRECT_GRANT_RESPONSE

ACCESS_TOKEN=$(echo $DIRECT_GRANT_RESPONSE | grep "access_token" | sed 's/.*\"access_token\":\"\([^\"]*\)\".*/\1/g');
export ACCESS_TOKEN

curl -i -k --request POST $KEYCLOAK_URL/admin/realms -d "@realm-export-prod.json" --header "Content-Type: application/json" --header "Authorization: Bearer $ACCESS_TOKEN";

