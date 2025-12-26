FROM openjdk:17-slim
WORKDIR /usr/local
ADD ./target/gateway-user-service.jar .
ENV NACOS_ADDR "nacos:8848"
CMD java -jar -Dspring.cloud.nacos.discovery.server-addr=$NACOS_ADDR gateway-user-service.jar
EXPOSE 80
