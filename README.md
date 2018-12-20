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

Note: This should return secret as vault properties take precedence