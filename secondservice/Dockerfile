FROM tomcat:9.0.63-jre11-temurin
ADD target/secondservice.war /usr/local/tomcat/webapps
EXPOSE 8080
ENTRYPOINT ["catalina.sh","run"]
