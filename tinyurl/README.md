
##Exercise Prompt
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

##Notes
build fresh
./mvnw clean package

test
./mvnw something

Start Service
./mvnw exec:java -Dexec.mainClass="com.danieloh.tinyurl.Application"

call API
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"url":"blah"}' \
  http://localhost:8080/api/generate