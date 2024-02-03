
FROM maven AS build


WORKDIR /app/myapp


COPY . .


RUN mvn clean package -DskipTests


FROM openjdk:17-alpine3.14



WORKDIR /app

EXPOSE 8080


COPY --from=build /app/myapp/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]