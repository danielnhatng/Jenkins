# Use an OpenJDK base image with version 11
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /pet-clinic

# Copy the compiled JAR file into the container
COPY ./target/spring-petclinic-3.1.0-SNAPSHOT.jar pet-clinic.jar
ARG ROAD="main"
ENV ROAD=${ROAD}
# Set the command to run the application when the container starts
CMD ["sh", "-c", "java -jar  pet-clinic.jar --server.servlet.context-path=/${ROAD} >> pet-clinic.log " ]