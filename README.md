# Java-Lambda

This project is a basic Java project that will be packaged and deployed into a AWS Lambda function.

## Package

Run the following command:

```
mvn clean package -f java-lambda/pom.xml
```

## Publish

Take the jar file that was produced from the above package step and upload it into AWS Lambda through the AWS Console

## Usage

### Database Service
GetItem from a table with a given key. 

Projection Expression can be added to limit the fields that are returns. 

Projection Expression is a quote-delmited comma separated list of fields to return.