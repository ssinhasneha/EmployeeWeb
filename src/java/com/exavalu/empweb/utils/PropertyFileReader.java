/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.empweb.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author sinha
 */
class PropertyFileReader {
    
    public static PropertyFileReader propertyFileReader = null;

	 

	// in this class we will have static methods to get the connection params

	 

	public String getPropertyValue(String param) {

	 

	String value = null;

	 

	// input = getClass().getResourceAsStream("settings.properties"); // Property

	// file path in classpath

	 

	try {

	 

	String path = PropertyFileReader.class.getClassLoader().getResource("settings.properties").getPath();

	 

	BufferedReader input = new BufferedReader(new FileReader(path));

	 

	Properties prop = new Properties();   

	 

	prop.load(input);    //this will pass the file and will create a hashmap in memory

	 

	value = prop.getProperty(param);    //this will use the param as key and will the corresponding values

	 

	} catch (IOException e) {

	// TODO Auto-generated catch block

	e.printStackTrace();

	}

	 

	return value;

	}

	 

	private PropertyFileReader() {

	// Private constructor

	}

	 

	public static PropertyFileReader getInstance() {

	if (propertyFileReader == null) {

	propertyFileReader = new PropertyFileReader();

	}

	return propertyFileReader;

	}
        public static void main (String args[])

	{

		PropertyFileReader util = PropertyFileReader.getInstance();

	 String user = util.getPropertyValue("user");

	 System.out.println("Got user = "+user);

	 }
}
