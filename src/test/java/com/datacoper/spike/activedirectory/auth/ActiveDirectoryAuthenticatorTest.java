package com.datacoper.spike.activedirectory.auth;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ActiveDirectoryAuthenticatorTest {

	@Test
	public void defaultConstructorShouldCreateAnInstanceWithADefaultSetOfDataIfNoDataIsProvided() {
		ActiveDirectoryAuthenticator activeDirectoryAuthenticator = new ActiveDirectoryAuthenticator();
		
		assertThat(activeDirectoryAuthenticator.getDomain(), equalTo(ActiveDirectoryAuthenticator.DEFAULT_LDAP_DOMAIN));
		assertThat(activeDirectoryAuthenticator.getLdapHost(), equalTo(ActiveDirectoryAuthenticator.DEFAULT_LDAP_HOST));
		assertThat(activeDirectoryAuthenticator.getSearchBase(), equalTo(ActiveDirectoryAuthenticator.DEFAULT_SEARCH_BASE));
	}
	
	@Test
	public void constructorShouldCreateAnInstanceWithTheGivenSetOfData() {
		String domain = "anydomain.com";
		String ldapHost = "ldap://anyhost:989";
		String searchBase = "dc=any, dc=searchbase";
		
		ActiveDirectoryAuthenticator activeDirectoryAuthenticator = new ActiveDirectoryAuthenticator(domain, ldapHost, searchBase);
		
		assertThat(activeDirectoryAuthenticator.getDomain(), equalTo(domain));
		assertThat(activeDirectoryAuthenticator.getLdapHost(), equalTo(ldapHost));
		assertThat(activeDirectoryAuthenticator.getSearchBase(), equalTo(searchBase));
	}
	
	@Test
	public void shouldReturnTrueForUserAdmin() {
		ActiveDirectoryAuthenticator activeDirectoryAuthenticator = new ActiveDirectoryAuthenticator();
		
		String user = "elenilton";
		String password = "!q2w3e4r%t";
		
		Boolean result = activeDirectoryAuthenticator.authenticate(user, password);
		
		assertThat(result, org.hamcrest.CoreMatchers.is(true));
	}

}
