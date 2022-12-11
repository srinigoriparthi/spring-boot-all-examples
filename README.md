# Getting Started

Information about this Project:
------------------------------
1. How to Invoke  
https://localhost:9095/persons/1  
2. Swagger UI  
https://localhost:9095/swagger-ui.html#/person-controller

JKS Certificate Creation Steps:
------------------------------
1. Open Command prompt.  
2. Type the below command to create the certificate.  
keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass changeit -storepass changeit -keystore ssl-server.jks      
3. Type the below command to see the created certificate  
keytool -list -keystore ssl-server.jks  


### Reference Documentation shows here
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

Useful Resources:
-----------------
Spring Boot Data JPA Hibernate with Swagger 2 Example:  
https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg  
  
How to Create SSL Certificate and Converting Application into HTTPS:  
https://howtodoinjava.com/spring-boot/spring-boot-ssl-https-example/  

**CRUD Operations in Java Web Applications using jTable and jQuery Plugins**  
- https://www.programming-free.com/2013/08/ajax-based-crud-operations-in-java-web.html  
- http://www.jtable.org/Demo/PagingAndSorting  
- https://www.programming-free.com/2013/07/setup-load-data-jtable-jsp-servlet.html  
- http://www.jtable.org/  


  



