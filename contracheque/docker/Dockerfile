FROM tomcat:7.0.90-jre8
VOLUME /tmp
ADD ./target/contracheque.war /usr/local/tomcat/webapps/contracheque.war

ENV JPDA_ADDRESS="5005"
ENV JPDA_TRANSPORT="dt_socket"

EXPOSE 8080 8080
EXPOSE 5005 5005
ENTRYPOINT ["catalina.sh", "jpda", "run"]