package com.vikas.movieBooking.dto;

public class User {

	private String loginId;
	  
	  private String userName;
	  
	  private String email;
	  
	  private String password;
	  
	  private String confirmPassword;
	  
	  private String roles;
	  
	  private String secretQuestion;
	  
	  private String answer;
	  
	  public String getRoles() {
	    return this.roles;
	  }
	  
	  public void setRoles(String roles) {
	    this.roles = roles;
	  }
	  
	  public String getSecretQuestion() {
	    return this.secretQuestion;
	  }
	  
	  public void setSecretQuestion(String secretQuestion) {
	    this.secretQuestion = secretQuestion;
	  }
	  
	  public String getAnswer() {
	    return this.answer;
	  }
	  
	  public void setAnswer(String answer) {
	    this.answer = answer;
	  }
	  
	  public String getLoginId() {
	    return this.loginId;
	  }
	  
	  public String setLoginId(String loginId) {
	    this.loginId = loginId;
	    return loginId;
	  }
	  
	  public String getUserName() {
	    return this.userName;
	  }
	  
	  public String setUserName(String userName) {
	    this.userName = userName;
	    return userName;
	  }
	  
	  public String getEmail() {
	    return this.email;
	  }
	  
	  public String setEmail(String email) {
	    this.email = email;
	    return email;
	  }
	  
	  public String getPassword() {
	    return this.password;
	  }
	  
	  public String setPassword(String password) {
	    this.password = password;
	    return password;
	  }
	  
	  public String getConfirmPassword() {
	    return this.confirmPassword;
	  }
	  
	  public String setConfirmPassword(String confirmPassword) {
	    this.confirmPassword = confirmPassword;
	    return confirmPassword;
	  }
	  
}
