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
	
	public UserAgent(String browserName,String browserType,String browserVersion,String browserProducer,String osName,String osProducer,String osVersion,String osVersionExtension){
		this.browserName=browserName;
		this.browserType=browserType;
		this.browserVersion=browserVersion;
		this.browserProducer=browserProducer;
		this.osName=osName;
		this.osProducer=osProducer;
		this.osVersion=osVersion;
		this.osVersionExtension=osVersionExtension;
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
}
