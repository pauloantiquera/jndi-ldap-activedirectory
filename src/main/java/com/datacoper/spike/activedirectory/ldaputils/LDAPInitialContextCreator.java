package com.datacoper.spike.activedirectory.ldaputils;

import java.util.Hashtable;

import javax.naming.Context;

public class LDAPInitialContextCreator {

	public static Hashtable<String, String> createInitialContext(String providerUrl, String user, String password) {
		Hashtable<String, String> initialContext = new Hashtable<String, String>();
		
		initialContext.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		initialContext.put(Context.SECURITY_AUTHENTICATION, "simple");
		initialContext.put(Context.PROVIDER_URL, providerUrl);
		initialContext.put(Context.SECURITY_PRINCIPAL, user);
		initialContext.put(Context.SECURITY_CREDENTIALS, password);
			
		return initialContext;
	}
	
	

}
