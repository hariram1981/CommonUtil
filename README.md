CommonUtil
==========

Common utility functions
- Util.enumToList - converts list of enum values to list of strings
- Util.getBundle - gets bundle from path and with filename
- Util.getProperties - gets all property values from property file
- Util.getPropery - gets the propery value from property file
- invokeMethodOfClassInJar - invoke a method of a class in a jar

Classes
----------
###1. com.hariram.common.util.Util
  - Utility class for common functionalities.
 
####Static methods in the class are as below:

1. List<String> enumToList(List<Object> enumList)
  - Converts List<Object> in an enum to List<String.
 
2. ResourceBundle getBundle(String filePath, String fileName)
  - Converts List<Object> in an enum to List<String.
 
3. Map<String, String> getProperties(String filePath, String fileName)
  - Fetches map of all key-values from a property file at filePath and with fileName.
 
4. String getProperty(String filePath, String fileName, String key)
  - Fetches value of the key from a pr###1. com.hariram.common.util.Util
  - Utility class for common functionalities.
 
####Static methods in the class are as below:
  Property file at filePath with fileName.

5. Object invokeMethodOfClassInJar(String jarPath, String className, String methodName, Object[] methodArgs)
  - invoke methodName of ClassName in jar in jarPath and with methodArgs.

Interfaces
----------
   
###1. com.hariram.common.util.DynamicToString
 - Class overriding toString method and dynamically lists the values of variables.
 
####Methods in the class are as below:

1. String printString()
  - Lists the variables and values of the implementing class
   
Usage
----------
- Usage can be checked in the JUnit test case that has been written for it but below are samples:

1. enum TYPES {A, B, C, D} 
List<String> list = Util.enumToList(Arrays.asList(TYPES.values()));
   //Converts the enum to list of string

2. ResourceBundle bundle = Util.getBundle("/opt/","log4j"); 
   //Fetches log4j.properties from /opt.
   
3. Map<String, String> propertiesMap = Util.getProperties("/opt","log4j");
   //Loads all the key-values in /opt/log4j.properties to propertiesMap

4. String propertyValue = Util.getProperty("/opt", "log4j", "log4j.rootLogger");
   //Gets the value of the key log4j.rootLogger from /opt/log4j.properties
   
5. Object obj = Util.invokeMethodOfClassInJar("/opt/myjar.jar","com.test.MyClass","mymethod", null);
   //Invokes com.test.MyClass.mymethod() from /opt/myjar.jar

License
==========
Copyright (c) 2014 GitHub, Inc. See the LICENSE file for license rights and limitations (GNU GPL v2.0)