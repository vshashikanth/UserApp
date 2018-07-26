package com.dm_02_tbdapp.dao;

import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.dm_02_tbdapp.dao.RegisterNewUserDAO;


@Repository
public class RegisterNewUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public JSONObject register(JSONObject credentials) {
	// code to register or save into the database.
		
	ApplicationContext appContextObj=new ClassPathXmlApplicationContext("src/main/resources/application.xml");
	RegisterNewUserDAO RegNewUserObj=(RegisterNewUserDAO) appContextObj.getBean("DAO");
	
	
	JSONObject userCredentialsObj=new JSONObject(credentials);
	
	System.out.println("in RegisterNewUserDAO class, UserProfile object is: "+userCredentialsObj.toString());
	String userName= (String) userCredentialsObj.get("firstName");
	String pwd= (String) userCredentialsObj.get("password");
	String lastName=(String) userCredentialsObj.get("lastName");
	String emailId=(String) userCredentialsObj.get("emailid");
    String mobileNumber=(String)userCredentialsObj.get("mobileNumber");
	


	System.out.println("username is: "+userName+"and password is: "+pwd);
	System.out.println("lastname is: "+ lastName);
	System.out.println("emailId is: "+ emailId);
	System.out.println("mobileNumber is: "+ mobileNumber);

	JSONObject userObj=new JSONObject();
	userObj.put("firstName",userName);
	userObj.put("password",pwd);
	userObj.put("lastName",lastName);
	userObj.put("emailId",emailId);
	userObj.put("mobileNumber",mobileNumber);
	
	
	
	return userObj;
}

 public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

public void addEmployee(RegisterNewUserDAO user) {
	System.out.println("SessionFactory is: "+sessionFactory);
	this.sessionFactory.getCurrentSession().save(user);
}

}
