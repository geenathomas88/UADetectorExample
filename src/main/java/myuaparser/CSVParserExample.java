package myuaparser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import net.sf.uadetector.OperatingSystem;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.VersionNumber;
import net.sf.uadetector.service.UADetectorServiceFactory;

public class CSVParserExample {

	public static UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
	
	public static void main(String[] args) throws IOException {
			
		CSVReader reader = new CSVReader(new FileReader("src/main/resources/ConsoleBrowserUsage.csv"),CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER,1);
		CSVWriter csvWriter = new CSVWriter(new FileWriter("src/main/resources/Result.csv"));

		List<UserAgent> userAgents = new ArrayList<UserAgent>();
		
		
		String[] line;
		while ((line = reader.readNext()) != null) {
			String uaString = line[0];
			int noOfhits = Integer.parseInt(line[1]);
			int noOfusers = Integer.parseInt(line[2]);
			int noOforg = Integer.parseInt(line[3]);
			UserAgent ua = getUserAgent(parser.parse(uaString),noOfhits,noOfusers,noOforg);
			userAgents.add(ua);
		}
		List<String[]> data = toStringArray(userAgents);
		csvWriter.writeAll(data);
		
		csvWriter.close();	
		reader.close();
		System.out.println("Done!!");
	}

	public static UserAgent getUserAgent(ReadableUserAgent agent,int hits,int users,int org){
		VersionNumber browserVersionNumber = agent.getVersionNumber();
		OperatingSystem os = agent.getOperatingSystem();
		VersionNumber osVersionNumber = os.getVersionNumber();
		
		String browserName = agent.getType().getName();
		String browserType = agent.getName();
		String browserVersion = browserVersionNumber.toVersionString();	
		String browserProducer = agent.getProducer();
		String osName = os.getName();
		String osProducer = os.getProducer();
		String osVersion = osVersionNumber.toVersionString();
		String osVersionExtension = osVersionNumber.getExtension();
		UserAgent userAgent = new UserAgent(browserName, browserType, browserVersion, browserProducer, osName, osProducer, osVersion, osVersionExtension,hits,users,org);
		return userAgent;
	}


	private static List<String[]> toStringArray(List<UserAgent> useragent) {
		List<String[]> records = new ArrayList<String[]>();
	
		// adding header record
		//records.add(new String[] { "Browser Type", "Browser Name", "Browser Version", "Browser Producer", "OS Name", "OS Producer", "OS Version" });
		
		records.add(new String[] { "Browser","Users","Org"});
		Iterator<UserAgent> it = useragent.iterator();
		while (it.hasNext()) {
			UserAgent ua = it.next();
			//records.add(new String[] { ua.getBrowserName(),ua.getbrowserType(),ua.getbrowserVersion(),ua.getbrowserProducer(),ua.getosName(),ua.getosProducer(),ua.getosVersion() });
			records.add(new String[] { ua.getbrowserType()+" " +ua.getbrowserVersion(),ua.getusers(),ua.getorg() });
		}
		return records;
	}
}
