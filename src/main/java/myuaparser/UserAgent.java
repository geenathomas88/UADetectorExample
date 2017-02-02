package myuaparser;

public class UserAgent {

	private String browserName;
	private String browserType;
	private String browserVersion;
	private String browserProducer;
	private String osName;
	private String osProducer;
	private String osVersion;
	private String osVersionExtension;
	private int hits;
	private int users;
	private int org;
	
	public UserAgent(String browserName,String browserType,String browserVersion,String browserProducer,String osName,String osProducer,String osVersion,String osVersionExtension,int hits,int users,int org){
		this.browserName=browserName;
		this.browserType=browserType;
		this.browserVersion=browserVersion;
		this.browserProducer=browserProducer;
		this.osName=osName;
		this.osProducer=osProducer;
		this.osVersion=osVersion;
		this.osVersionExtension=osVersionExtension;
		this.hits = hits;
		this.users = users;
		this.org = org;
	}
	public UserAgent() {
		// TODO Auto-generated constructor stub
	}


	
	public String getBrowserName(){
		return browserName;
	}
	public String getbrowserType(){
		return browserType;
	}
	public String getbrowserVersion(){
		return browserVersion;
	}
	public String getbrowserProducer(){
		return browserProducer;
	}
	public String getosName(){
		return osName;
	}
	public String getosProducer(){
		return osProducer;
	}
	public String getosVersion(){
		return osVersion;
	}
	public String getosVersionExtension(){
		return osVersionExtension;
	}
	public String gethits(){
		return Integer.toString(hits);
	}
	public String getusers(){
		return Integer.toString(users);
	}
	public String getorg(){
		return Integer.toString(org);
	}
}
