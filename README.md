Hi,

This is my training project in spring technology based on Maven. It is a very simple bank simulation.

There are some different branches to expose different tools and methods.




**_Branch xml_**:

  &ensp;&nbsp;Basic xml beans confogurations 
  
**_Branch annotations_**:

  &ensp;&nbsp;Basic annotation for beans configuration

**_Branch javaconfig_**:

  &ensp;&nbsp;Basic configuration with javaconfig using aspectjweaver and jdbc.
  
**_Branch AOP_**:
  
  &ensp;&nbsp;Beans configuration in xml using aspect-oriented programming
  
**_Branch AOP-javaconfig_**:
  
  &ensp;&nbsp;Beans configuration by javaconfig using aspect-oriented programming
  
**_Branch xml-jdbc_**:
  
  &ensp;&nbsp;Beans and  AOP configuration in xml. Requirements:
  
**_Branch javaconfig-jdbc_**:
  
  &ensp;&nbsp;Beans and  AOP configuration with javaconfig.
  
**_Branch hibernate_**:

  &ensp;&nbsp;Hibernate, Beans, AOP configuration with xml. 
  
**_Requirements:_**:
**(javaconfig, xml-jdbc, Branch javaconfig-jdbc, )**
   
  
  &ensp;&ensp;&nbsp; MySQL 5.x server,
  
  
  &ensp;&ensp;&nbsp; You have to run initial MySQL comands from BankTraining/src/main/resources/MySQLimport file,
 
 
  &ensp;&ensp;&nbsp; There can be problem with setting session timezone for jdbc. To solve it, put this line in jdbc.properties:
  
 
  &ensp;&ensp;&nbsp; `database.url=jdbc:mysql://localhost:3306/bankTraining?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC`
  
  
  ![OcctoCat](http://octodex.github.com/images/foundingfather_v2.png?style=centerme) 


  
  
    

