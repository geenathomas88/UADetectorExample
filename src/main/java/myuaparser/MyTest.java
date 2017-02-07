package myuaparser;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import net.sf.uadetector.*;
import net.sf.uadetector.service.UADetectorServiceFactory;


public class MyTest {

	public static UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();

	public static void main(String[] args) throws IOException {
		
		String csvFile = "src/main/resources/ConsoleBrowserUsage.csv";	
		CSVReader reader = new CSVReader(new FileReader(csvFile));
		
		String[] line;
		
		while ((line = reader.readNext()) != null) {
           // System.out.println( line[0]);
            String ua4 = line[0];
            printUa(parser.parse(ua4));                           
          }
		reader.close();
	}
	


	public static void printUa(ReadableUserAgent agent){
        System.out.println("- - - - - - - - - - - - - - - - -");
        // type
        System.out.println("Browser type: " + agent.getType().getName());
        System.out.println("Browser name: " + agent.getName());
        VersionNumber browserVersion = agent.getVersionNumber();
        System.out.println("Browser version: " + browserVersion.getMajor());
        
        
        
       // System.out.println("Browser version major: " + browserVersion.getMajor());
        //System.out.println("Browser version minor: " + browserVersion.getMinor());
        //System.out.println("Browser version bug fix: " + browserVersion.getBugfix());
        //System.out.println("Browser version extension: " + browserVersion.getExtension());
//        System.out.println("Browser producer: " + agent.getProducer());

//        // operating system
//        OperatingSystem os = agent.getOperatingSystem();
//        System.out.println("\nOS Name: " + os.getName());
//        System.out.println("OS Producer: " + os.getProducer());
//        VersionNumber osVersion = os.getVersionNumber();
//        System.out.println("OS version: " + osVersion.toVersionString());
//        //System.out.println("OS version major: " + osVersion.getMajor());
//        //System.out.println("OS version minor: " + osVersion.getMinor());
//        //System.out.println("OS version bug fix: " + osVersion.getBugfix());
//        System.out.println("OS version extension: " + osVersion.getExtension());

        // device category
        ReadableDeviceCategory device = agent.getDeviceCategory();
        System.out.println("\nDevice: " + device.getName());
    }
}
