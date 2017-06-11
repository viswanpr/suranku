# users-service
http://localhost:8080/api/swagger.json for swagger.json

http://localhost:8080/api/ping for testing the api end point


#Tutorial

install lombak pliugin
Enable annotation processing

#Build and run

./gradlew build
./gradlew bootRun

#Docker

To build images:

./gradlew buildDocker

running:

docker run -p 8080:8080 suranku




