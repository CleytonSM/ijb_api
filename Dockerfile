# Usando a imagem do OpenJDK 17
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copia o JAR compilado para o diretório do container
COPY target/ijb_api-0.0.1-SNAPSHOT.jar app.jar

# Copia o script wait-for-it.sh para o container
COPY wait-for-it.sh /wait-for-it.sh

# Dá permissão de execução ao script
RUN chmod +x /wait-for-it.sh

# Expõe a porta 8080
EXPOSE 8080

# Comando para executar a aplicação usando o wait-for-it.sh
ENTRYPOINT ["/wait-for-it.sh", "db:3306", "-t", "0", "--", "java", "-jar", "/app/app.jar"]