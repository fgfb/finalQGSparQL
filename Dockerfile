#FROM openjdk
#VOLUME /tmp
#ADD target/question-generator-Mongo-1.0.jar usr/project/question-generatorDocker.jar
#WORKDIR usr/project/
#RUN sh -c 'touch question-generatorDocker.jar'
#ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongo-container/questiondb", "-jar","question-generatorDocker.jar"]

# setting the base image required to run your app
FROM java:8

# setting the work directory in docker container
WORKDIR usr/app

# copy / add contents from current dir to container
ADD ./target/question-generator-Mongo-1.0.jar /usr/app.jar

# printing what all are there inside /usr
RUN ls /usr

# Make port 8080 available to others
EXPOSE 8080

RUN bash -c 'touch /usr/app.jar'

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongocontainer/questiondb","-jar","/usr/app.jar"]
