FROM openjdk:17
EXPOSE 8080
ADD target/ijb_api-0.0.1-SNAPSHOT.jar ijb_api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ijb_api-0.0.1-SNAPSHOT.jar"]