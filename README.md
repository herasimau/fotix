# FOTIX PROJECT

## PROJECT DESCRIPTION:

Fotix PET PROJECT Spring Boot application with Angular 2.
Node and npm are installed as part of maven build. Also webpack build and karma tests runs with maven.
It also uses Spring Cloud microservices and Spring Security with Oauth2 JWT tokens.


## FEATURES:
* Build and testing process integrated with maven
* Spring cloud microservices with Zull and Eureka
* Spring security Oauth2 integration
* Spring Boot application in development mode use resources from webpack dev server
* Scss support
* Angular material integration
* Font-awesome integration
* Lazy loaded routes

## PRODUCTION USAGE:

To use production mode you need to use production maven profile as well as production spring profile (both activated as default)

Install parent and common libraries:
```
cd fotix-parent/
mvn install

cd fotix-common/
mvn install
```

Then build and run discovery server:
```
cd fotix-discovery/
mvn clean package
java -jar ./target/fotix-discovery-1.9.0.jar
```

Then build and run api server:
```
cd fotix-api/
mvn clean package
java -jar ./target/fotix-api-1.9.0.jar
```

Then build and run auth server:
```
cd fotix-auth/
mvn clean package
java -jar ./target/fotix-auth-1.9.0.jar
```

Then build and run ui server:
```
cd fotix-api/
mvn clean package
java -jar ./target/fotix-ui-1.9.0.jar
```


## DEVELOPMENT USAGE:

To use development mode you need also webpack development server running in background.

Install all dependencies at first
Install parent and common libraries:
```
cd fotix-parent/
mvn install

cd fotix-common/
mvn install
```

Run discovery server in development mode:
```
cd fotix-discovery
mvn spring-boot:run -P dev -Dspring.profiles.active=dev
```

Run api server in development mode:
```
cd fotix-api
mvn spring-boot:run -P dev -Dspring.profiles.active=dev
```

Run auth server in development mode:
```
cd fotix-auth
mvn spring-boot:run -P dev -Dspring.profiles.active=dev
```

Run ui server in development mode:
```
cd fotix-ui
mvn spring-boot:run -P dev -Dspring.profiles.active=dev
```

Run webpack development server:
```
cd fotix-ui
npm run server
```

## TESTING

Run unit tests:
```
cd fotix-ui
npm run test
```

Run e2e tests:
```
cd fotix-ui
npm run e2e
```

## CHANGELOG:

### 1.0.0 (02.10.2016)
* Initial Version


[show full changelog](CHANGELOG.md)
