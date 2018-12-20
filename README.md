# Spring Cloud Config With Vault

### Prerequisites 

- Java
- Maven
- Docker 

### Getting started

Open up a terminal within the root of the project

1. $`unzip config-repo.zip -d ~/` 
1. $`mvn clean install`
1. $`docker-compose up`
1. $`curl -X "GET" "http://localhost:8080/config"`

   Note: This should return git to indicate property has been acquired from the git repo

1. $`docker-compose exec vault /bin/sh` This will open a shell within the vault container
1. $`vault kv put -address=http://127.0.0.1:8200 secret/config-service-client config.name=secret`
1. $`exit`
1. $`docker-compose restart config-service-client`
1. $`curl -X "GET" "http://localhost:8080/config"`

You should now see secret returned, indicating property has been acquired from vault
