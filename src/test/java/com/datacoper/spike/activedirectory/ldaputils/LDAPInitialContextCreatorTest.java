package com.datacoper.spike.activedirectory.ldaputils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;

import org.junit.Test;

public class LDAPInitialContextCreatorTest {

	@Test
	public void shouldCreateAInitialContextWithMinimalData() {
		String providerUrl = "ldap://localhost:389";
		String user = "user";
		String password = "password";
		
		Hashtable<String, String> initialContext =  LDAPInitialContextCreator.createInitialContext(providerUrl, user, password);
		
		assertThat(initialContext.get(Context.INITIAL_CONTEXT_FACTORY), equalTo("com.sun.jndi.ldap.LdapCtxFactory"));
		assertThat(initialContext.get(Context.SECURITY_AUTHENTICATION),	equalTo("simple"));
		assertThat(initialContext.get(Context.PROVIDER_URL), equalTo(providerUrl));
		assertThat(initialContext.get(Context.SECURITY_PRINCIPAL), equalTo(user));
		assertThat(initialContext.get(Context.SECURITY_CREDENTIALS), equalTo(password));
	}
}
