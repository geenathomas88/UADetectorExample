package myuaparser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

public class MyParser {

	public static UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
	
	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader(new FileReader("src/main/resources/ConsoleBrowserUsage.csv"),CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER,1);
		CSVWriter csvWriter = new CSVWriter(new FileWriter("src/main/resources/newResult.csv"));

		String[] line;
		Map<String, UA> UserAgentMap = new HashMap<String,UA>();
		while ((line = reader.readNext()) != null) {
			int newnoOfusers = 0;
			int newnoOforg = 0;
			int noOfusers = 0;
			int noOforg = 0;
			
			String uaString = line[0];
			
			noOfusers = Integer.parseInt(line[2]);
			noOforg = Integer.parseInt(line[3]);
			
			//parser.parse(uaString);
			String browser = parser.parse(uaString).getType().getName()+" "+parser.parse(uaString).getName()+" "+parser.parse(uaString).getVersionNumber().getMajor();
			if(UserAgentMap.containsKey(browser)){
				UA userAgentExisting = UserAgentMap.get(browser);
				
				newnoOfusers = userAgentExisting.getusers() + noOfusers;
				newnoOforg = userAgentExisting.getorg() + noOforg;
				UserAgentMap.remove(browser);
				UA userAgent = new UA(browser, newnoOfusers, newnoOforg);
				UserAgentMap.put(browser, userAgent);
			}else{
				UA userAgent = new UA(browser, noOfusers, noOforg);
				UserAgentMap.put(browser, userAgent);
			}						
		}
		
		List<String[]> data = toStringArray(UserAgentMap);
		csvWriter.writeAll(data);
		
		csvWriter.close();	
		reader.close();
		System.out.println("Done!!");
	}
	
	private static List<String[]> toStringArray(Map<String, UA> useragent) {
		List<String[]> records = new ArrayList<String[]>();
	
		// adding header record
				
		records.add(new String[] { "Browser","Users","Org"});
		Set set = useragent.entrySet();
		Iterator<UserAgent> it = set.iterator();
		
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
			UA user = (UA) me.getValue();
			
			records.add(new String[] {user.getBrowser(), String.valueOf(user.getusers()), String.valueOf(user.getorg())});
		}
		return records;
	}

}
