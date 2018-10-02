FROM gradle:4.4-jdk8-alpine
EXPOSE 8080
EXPOSE 8081
ADD . /home/gradle/project
USER root
WORKDIR /home/gradle/project
ENTRYPOINT ["gradle"]
CMD ["run"]
