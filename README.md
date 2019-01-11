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

To ensure everything starts up error free we have setup `config-service-client` to use the root token.

Obviously this a huge security hole, so need to change this.  

During startup the vault-populator set up a policy specifically for the config-service-client.

1. $`docker-compose logs vault-populator`

Take the token value, locate `SPRING_CLOUD_CONFIG_TOKEN` within the environment section of `config-service-client` 
within the docker-compose file and replaces its value. 

Now:

1. $`docker-compose up -d config-service-client`
1. $`curl -X "GET" "http://localhost:8080/config" -w '\n'`

Note: This should return secret showing that the new token works correctly