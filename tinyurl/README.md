##Notes
Very simple URL shortening service using Spring Boot. This is example code and uses an in-memory store of data to save original URLs and their shortened aliases. The intention is that no shortened URL has an expiration date (other than the data store getting wiped out), and original URL to shortened URL is 1:1 across all data.

Please note: many corners were cut in the interest of time. No unit tests, no java docs, no persistent database, etc.

##Usage Notes
Assumes Mac OS / Linux.
```
# open terminal and navigate to project directory root
cd {PATH_TO_PROJECT_ROOT/tinyurl}

# run the included Maven script to build the project. May need to set JAVA_HOME.
./mvnw clean package

# start the service.
./mvnw exec:java -Dexec.mainClass="com.danieloh.tinyurl.Application"

# open a new terminal session and call the API.
curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"originalUrl":"https://github.com/ostium-binarii/example-tiny-url-service"}' \
  http://localhost:8080/api/generate

# expected response below. 
{"tinyUrl":"http://localhost:8080/A"}

# call the API again with the same URL.
curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"originalUrl":"https://github.com/ostium-binarii/example-tiny-url-service"}' \
  http://localhost:8080/api/generate

# expected response below. Note a new URL is not created, instead, the previously associated 
# URL ID is returned. 
{"tinyUrl":"http://localhost:8080/A"}

# Note shortened URL IDs "increment" through every permutation of letters and numbers starting 
# from the shortest permutations in length.
# 1st URL ID "A"
# 2nd URL ID "B"
# 3rd URL ID "C"
# ...
# ?th URL ID "Aa"
# ?+1th URL ID "Ab"
# ...
# ...
# ?th URL ID "AB1d6"
curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{"originalUrl":"https://github.com/"}' \
  http://localhost:8080/api/generate

{"tinyUrl":"http://localhost:8080/B"}

# Open a web browser and navigate to "http://localhost:8080/B"
redirect should occur to https://github.com/

# Some manual tests:
1. curling '{asdfa()'
   result: "Your request may not have been formatted correctly."

2. curling '{"blah":"https://a.com "}'
   result: "Your request may have an invalid field."

3. curling '{"originalUrl":" "}'
   result: "Given URL is empty or blank."

4. curling '{"originalUrl":")(&*)&) "}'
   result: "Given URL input ")(&*)&) " is not in valid format!"

5. navigate to non-existent shortened url ID: "http://localhost:8080/AaB"
   result: page with message "Page not found!"
```

##Original Exercise Prompt
Design a URL Shortener REST API backend. Using Spring-Boot  &  Annotations (as opposed to xml configuration), create an application that contains:

- Rest Controller 
- Service
- Repository (spring-data)

NO UI needed, just use JSON.
Use Maven instead of Gradle

examples: 
- http://tinyurl.com/, 
- http://tiny.cc/

```
/**
* Design a URL Shortener REST API Backend Controller, Service, Repository
* Input: www.averylongurl.com/123/hello.com
* Output: myservice.com/id=2
* Once myservice.com/id=2 is opened it should redirect to  www.averylongurl.com/123/hello.com
* Use pseudocode first to design the application, then we can convert it to spring
*/
 
class Controller {
 
}
 
class Service {
 
}
 
class Repository {
 
}

```  