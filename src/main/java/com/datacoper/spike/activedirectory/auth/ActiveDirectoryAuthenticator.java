package com.datacoper.spike.activedirectory.auth;

import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.datacoper.spike.activedirectory.ldaputils.LDAPInitialContextCreator;

public class ActiveDirectoryAuthenticator {
	
	public static final String DEFAULT_SEARCH_BASE = "dc=dominio,dc=local";
	public static final String DEFAULT_LDAP_HOST = "ldap://192.168.56.2:389";
	public static final String DEFAULT_LDAP_DOMAIN = "dominio.local";
	
	private String domain;
	private String ldapHost;
	private String searchBase;

	public ActiveDirectoryAuthenticator() {
		this(DEFAULT_LDAP_DOMAIN, DEFAULT_LDAP_HOST, DEFAULT_SEARCH_BASE);
	}

	public ActiveDirectoryAuthenticator(String domain, String ldapHost, String searchBase) {
		this.domain = domain;
		this.ldapHost = ldapHost;
		this.searchBase = searchBase;
	}

	public String getDomain() {
		return domain;
	}

	public String getLdapHost() {
		return ldapHost;
	}

	public String getSearchBase() {
		return searchBase;
	}

	public Boolean authenticate(String user, String password) {
		DirContext initialDirContext = generateInitialDirContext(user + "@" + getDomain(), password);
		
		return initialDirContext != null;
	}

	private DirContext generateInitialDirContext(String user, String password) {
		Hashtable<String,String> initialContextConfig = LDAPInitialContextCreator.createInitialContext(getLdapHost(), user, password);
		
		try {
			return new InitialDirContext(initialContextConfig);
		} catch (NamingException namingException) {
			namingException.printStackTrace();
			return null;
		}
		
	}
}
