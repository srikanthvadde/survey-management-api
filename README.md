**Survey Management Application:**

# Running The Application

To test the example application run the following commands.

* To create the example, package the application using [Apache Maven](https://maven.apache.org/) from the root dropwizard directory.

        git clone <url>
        mvn clean install
        mvn clean package
        java -jar survey-management-api.jar

* To setup the  Docker
        make sure docker running
        docker build -t survey-management-api .  (to build image)
        docker run -v ~/.oci:/root/.oci -p 8080:8080 survey-management-api  (to run as docker container)


* To hit the api  (hit refresh a few times).

	http://localhost:8080/surveys

* To post data into the application.

	curl -X POST http://localhost:8080/surveys \
  -H "Content-Type: application/json" \
  -d '{"age": 30, "gender": "male", "region": "US-East", "surveyID": "1234", "score": 4}'

* test application:
   use **test_script.py**  file for to post 10 requests and can test.  

