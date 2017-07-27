### Hi,

### This is my training project in spring technology based on Maven. It is a very simple bank simulation.

### There are some different branches to expose different tools and methods.



**_1. Branch: xml_**:

&ensp;&nbsp;Basic xml beans confogurations 
  
**_2. Branch: annotations_**:

&ensp;&nbsp;Basic annotation for beans configuration

**_3. Branch: javaconfig_**:

&ensp;&nbsp;Basic configuration with javaconfig using aspectjweaver and jdbc.
  
**_4. Branch: AOP_**:
  
&ensp;&nbsp;Beans configuration in xml using aspect-oriented programming
  
**_5. Branch: AOP-javaconfig_**:
  
&ensp;&nbsp;Beans configuration by javaconfig using aspect-oriented programming
  
**_6. Branch: xml-jdbc_**:
  
&ensp;&nbsp;Beans and  AOP configuration in xml.
  
**_7. Branch: javaconfig-jdbc_**:
  
&ensp;&nbsp;Beans and  AOP configuration with javaconfig. 
 
**_8. Branch: Hibernate_**:
  
&ensp;&nbsp;Hibernate, Beans and  AOP configuration with xml.

**_9. Branch: Hibernate-javaconfig_**:
  
&ensp;&nbsp;Hibernate, Beans and  AOP configuration with javaconfig.

**_10. Branch: jpa-xml_**:
  
&ensp;&nbsp;JPA, Hibernate, Beans and  AOP configuration with xml.

**_11. Branch: jpa-javaconfig_**:
  
&ensp;&nbsp;JPA, Hibernate, Beans and  AOP configuration with javaconfig.

**_12. Branch: spring-data-xml_**:

&ensp;&nbsp;Spring Data, Beans and  AOP configuration with xml.

**_13. Branch: spring-data-javaconfig_**:

&ensp;&nbsp;Spring Data, Beans and  AOP configuration with javaconfig.

**_14. Branch: spring-mvc-xml_**:

&ensp;&nbsp;Spring MVC, Spring Data, Beans and  AOP configuration with xml.

**_15. Branch: spring-mvc-javaconfig_**:

&ensp;&nbsp;Spring MVC, Spring Data, Beans and  AOP configuration with javaconfig.

**_16. Branch: spring-mvc-rest_**:

&ensp;&nbsp;Foundations for REST bank simulation. Spring MVC, Spring Data, Beans and  AOP configuration with javaconfig. 

**_17. Branch: springboot_**:

&ensp;&nbsp;Foundations for REST bank simulation with Springboot. 

**_18. Branch: javaconfig-mvc-jsp_**:

&ensp;&nbsp;REST bank simulation created with jsp.

**_Requirements(except branch xml and annoatations)_**:  

&ensp;&ensp;&nbsp; MySQL 5.x server,

&ensp;&ensp;&nbsp; You have to run initial MySQL comands from BankTraining/src/main/resources/MySQLimport file,
 
&ensp;&ensp;&nbsp; There can be problem with setting session timezone for jdbc. To solve it, put this line in jdbc.properties:
  
&ensp;&ensp;&nbsp; `database.url=jdbc:mysql://localhost:3306/bankTraining?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC`

&ensp;&ensp;&nbsp; while working with hibernate, set db dialect equals to your server e.g. org.hibernate.dialect.MySQL57Dialect
(see repisitory.xml for branch hibernate or hibernate.properties for barnch hibernate-javaconfig)
  

**_Extra Requirements for branch spring-mvc-xml, spring-mvc-javaconfig, spring-mvc-rest__**: 

&ensp;&ensp;&nbsp; To compile app use maven command: mvn compile war:war

&ensp;&ensp;&nbsp; TomCat 8 or higher for web application archive deployment


**_REST API Description for branch spring-mvc-rest and springboot_**:

&ensp;&ensp;&nbsp; empty POST request on http://localhost:8080/api/accounts   --> next account creation

&ensp;&ensp;&nbsp; GET request on http://localhost:8080/api/accounts  --> list all accounts

&ensp;&ensp;&nbsp; GET request on http://localhost:8080/api/accounts/{id} --> get account with given id

&ensp;&ensp;&nbsp; deposit operation example:

&ensp;&ensp;&nbsp; POST request on http://localhost:8080/api/operations with body:

&ensp;&ensp;&nbsp;JSON: {"name":"depositOperation", "sourceAccountNumber":"00000000000000000000000001", "funds":100 }

&ensp;&ensp;&nbsp;Header: "content-type", "application/json"

&ensp;&ensp;&nbsp; withdraw operation example:

&ensp;&ensp;&nbsp; POST request on http://localhost:8080/api/operations with body:

&ensp;&ensp;&nbsp;JSON: {"name":"withdrawOperation", "sourceAccountNumber":"00000000000000000000000001", "funds":50 }

&ensp;&ensp;&nbsp;Header: "content-type", "application/json"

&ensp;&ensp;&nbsp; transfer operation example:

&ensp;&ensp;&nbsp; POST request on http://localhost:8080/api/operations with body:

&ensp;&ensp;&nbsp;JSON: {"name":"transferOperation", "sourceAccountNumber":"00000000000000000000000001", "destinationAccountNumber":"00000000000000000000000002", "funds":90 }

&ensp;&ensp;&nbsp;Header: "content-type", "application/json"


  
![OcctoCat](http://octodex.github.com/images/foundingfather_v2.png?style=centerme) 


  
  
    

