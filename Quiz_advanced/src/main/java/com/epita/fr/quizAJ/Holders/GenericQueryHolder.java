package com.epita.fr.quizAJ.Holders;

import java.util.LinkedHashMap;
import java.util.Map;

public class GenericQueryHolder<T> 
{
	private String queryString;
	private Class<T> className;
	
	
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public Class<T> getClassName() {
		return className;
	}
	public void setClassName(Class<T> className) {
		this.className = className;
	}
	
	//This is used to hold collections MAP
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	private Map<String, Object> map;


	public void putParameter(String string, Object value) {
		if(map == null) {
			map =  new LinkedHashMap<String,Object>();
		}
		map.put(string, value);
		
	}
}
