# Microservice + JPA

#Run Unit Test
mvn test

#Run via Maven
mvn wildfly-swarm:run


#For Integration RUN UBER-JAR
jvn package -Puberjar

java -jar target/microservice-swarm.jar -Dswarm.http.port=8081