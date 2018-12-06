# Spring Cloud With Vault

##  Set up

1. Unzip config-repo.zip into `~/config-repo` ensuring the `.git` is located within the root of that folder 
1. Run `mvn clean install`
1. Run `docker-compose up`
1. Run `curl http://localhost:8888/service-config/default/`

You should see properties returned from the file within the unzipped config-repo
