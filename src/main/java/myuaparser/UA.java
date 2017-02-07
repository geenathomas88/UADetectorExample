package myuaparser;

public class UA {

	private String browser;
	private int users;
	private int org;
	
	public UA(String browser,int users,int org){
		this.browser = browser;
		this.users = users;
		this.org = org;
	}
	public String getBrowser(){
		return browser;
	}
	public int getusers(){
		return users;
	}
	public int getorg(){
		return org;
	}
}
