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
1. com.hariram.common.util.Util
 - Utility class for common functionalities.

List<String> enumToList(List<Object> enumList)
 - Converts List<Object> in an enum to List<String.
 
ResourceBundle getBundle(String filePath, String fileName)
 - Converts List<Object> in an enum to List<String.
 
Map<String, String> getProperties(String filePath, String fileName)
 - Fetches map of all key-values from a property file at filePath and with fileName.
 
String getProperty(String filePath, String fileName, String key)
 - Fetches value of the key from a property file at filePath with fileName.

Object invokeMethodOfClassInJar(String jarPath, String className, String methodName, Object[] methodArgs)
 - invoke methodName of ClassName in jar in jarPath and with methodArgs.

License
==========
Copyright (c) 2014 GitHub, Inc. See the LICENSE file for license rights and limitations (GNU GPL v2.0)