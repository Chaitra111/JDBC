package com.bridgelabz.JdbcPwdCheck;

import com.bridgelabz.jdbcfirst.Utility;

public class UserDetails {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		System.out.println("Enter usename");
		String username=Utility.getString();
		
		System.out.println("Enter password");		
        String s = Utility.getString();
        
        boolean res=ValidPwd.is_Valid_Password(s); 
        System.out.println(res);
	}
}