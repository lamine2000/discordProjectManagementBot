FROM openjdk:11
RUN mkdir -p /usr/src/discordProjectManagementBot
COPY discordProjectManagementBot.jar /usr/src/discordProjectManagementBot
WORKDIR /usr/src/discordProjectManagementBot
ARG TOKEN
ENV TOKEN $TOKEN
CMD ["java", "-jar", "discordProjectManagementBot.jar"]