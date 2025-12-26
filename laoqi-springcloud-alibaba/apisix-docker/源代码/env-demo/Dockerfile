#docker run -d -e MY_DATABASE_IP=8.8.8.8:3306 -p 80:80 env-demo:1.0
FROM openjdk:17-slim
WORKDIR /usr/local
ADD ./target/env-demo.jar .
#CASE:1 替换配置文件
#ADD ./target/classes/application.properties .
#ENV MY_DATABASE_IP="default-db:3306"
#RUN sed -i 's/^my\.database\.ip=.*/my.database.ip=$MY_DATABASE_IP/g' application.properties
#CMD java -jar env-demo.jar

#CASE:2 基于Java命令行
CMD java -jar -Dmy.database.ip=$MY_DATABASE_IP env-demo.jar
EXPOSE 80