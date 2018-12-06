# Spring Cloud Config With Vault

### Prerequisites 

- Java
- Maven
- Docker 

### Getting started

Open up a terminal within the root of the project

1. Unzip config-repo.zip into `~/config-repo` ensuring the `.git` is located within the root of that folder 
1. $`mvn clean install`
1. $`docker-compose up`
1. $`curl -X "GET" "http://localhost:8888/service-config/default" -H "X-Config-Token: roottoken"`

   Note: Only one property source will be available, now time to populate vault

1. $`docker-compose exec vault /bin/sh` This will open a shell within the vault container
1. $`vault kv put -address=http://127.0.0.1:8200 secret/service-config config.name=secret`
1. $`exit`
1. $`curl -X "GET" "http://localhost:8888/service-config/default" -H "X-Config-Token: roottoken"`

You should now see two property sources returned, the new one containing the secret just added
