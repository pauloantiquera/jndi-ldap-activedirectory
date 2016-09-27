package com.datacoper.spike.activedirectory.auth;

public class AuthClient {
	
	private ActiveDirectoryAuthenticator activeDirectoryAuthenticator;
	
	public AuthClient(String domain, String ldapHost, String searchBase) {
		this.activeDirectoryAuthenticator = new ActiveDirectoryAuthenticator(domain, ldapHost, searchBase);		
	}
	
	public String doAuth(String userName, String password) {
		if (activeDirectoryAuthenticator.authenticate(userName, password)) {
			return "Auth successful";
		}
		
		return "Auth error";
	}
	
	
	public static void main(String[] args) {
		String domain = args[0];
		String ldapHost = args[1];
		String searchBase = args[2];
		String userName = args[3];
		String password = args[4];
		
		System.out.println("Trying auth for: " 
				+ domain 
				+ " | " + ldapHost
				+ " | " + searchBase
				+ " | " + userName
				+ " | " + password
		);		
		
		AuthClient authClient = new AuthClient(domain, ldapHost, searchBase);
		
		System.out.println(authClient.doAuth(userName, password));
	}
}
