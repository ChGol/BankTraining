####Hi,

####This is my training project with spring technology. It is a very simple bank simulation.

####There are some different branches to expose different tools and methods.





**_Branch xml_**:


  &ensp;&nbsp;Basic xml beans confogurations 
  
**_Branch annotations_**:


  &ensp;&nbsp;Basic annotation beans configuration

**_Branch javaconfig_**:


  &ensp;&nbsp;Basic configuration with javaconfig using aspectjweaver and jdbc. Requirements:
  
  
  &ensp;&ensp;&nbsp; MySQL server,
  
  
  &ensp;&ensp;&nbsp; You have to run initial MySQL comands from BankTraining/src/main/resources/MySQLimport file,
 
 
  &ensp;&ensp;&nbsp; There can by problem with setting session timezone for jdbc. To solve it, put this line in jdbc.properties:
  
 
  &ensp;&ensp;&nbsp; `_database.url=jdbc:mysql://localhost:3306/bankTraining?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC_`
  

  
  
    

