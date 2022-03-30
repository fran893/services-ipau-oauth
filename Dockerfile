FROM openjdk:8
VOLUME /tmp
EXPOSE 9100
ADD ./target/services-ipau-oauth-0.0.1-SNAPSHOT.jar services-ipau-oauth.jar
ENTRYPOINT ["java","-jar","/services-ipau-oauth.jar"]