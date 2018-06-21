# JSF CLIENT

#Run Unit Test
mvn verify

#Run via Maven
mvn wildfly-swarm:run


#For Integration RUN UBER-JAR
jvn package -Puberjar

java -jar target/jsf-swarm