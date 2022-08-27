package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ReadConfig {
	
	Properties props;
	public ReadConfig()  {
		try {
		File src = new File("./src/test/resources/runConfig.properties");
		
		FileInputStream fis = new FileInputStream(src);
        props = new Properties();
        props.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		return props.getProperty("baseUrl");
	}
	
	public String getBrowser() {
		return props.getProperty("browser");
	}
	
	public String getUserEmail() {
		return props.getProperty("userEmail");
	}
	
	public String getPassword() {
		return props.getProperty("password");
	}
	
	public String getChromePath() {
		return props.getProperty("chromepath");
	}
	
	public String getFirefoxPath() {
		return props.getProperty("firefoxpath");
	}
	
	public String getEdgePath() {
		return props.getProperty("edgepath");
	}
	
	public String getContactPerson() {
		return props.getProperty("contactPerson");
	}
	public String getOrganization() {
		return props.getProperty("organization");
	}
	public String getDealValue() {
		return props.getProperty("dealValue");
	}

	public String getCurrency() {
		return props.getProperty("currency");
	}
	public String getPhone() {
		return props.getProperty("phone");
	}
	public String getPhoneType() {
		return props.getProperty("phonetype");
	}
	public String getEmail() {
		return props.getProperty("email");
	}
	
	public String getEmailType() {
		return props.getProperty("emailtype");
	}
	
	public String getMeetingStartDate() {
		return props.getProperty("meetingStartDate");
	}
	
	public String getMeetingStartTime() {
		return props.getProperty("meetingStartTime");
	}
	
	public String getMeetingEndDate() {
		return props.getProperty("meetingEndDate");
	}
	
	public String getMeetingEndTime() {
		return props.getProperty("meetingEndTime");
	}
	
	public ArrayList<String> getMeetingGuests() {
		ArrayList<String> guestList= new ArrayList<String>(Arrays.asList(props.getProperty("meetingGuests").split(",")));
		return guestList;
	}
	
	public String getMeetingLocation() {
		return props.getProperty("meetingLocation");
	}
	
	public String getMeetingDescription() {
		return props.getProperty("meetingDescription");
	}
	
	public String getMeetingNotes() {
		return props.getProperty("meetingNotes");
	}
	
	public String getMeetingTitle() {
		return props.getProperty("meetingTitle");
	}
	
	public String getDealCloseDate() {
		return props.getProperty("dealCloseDate");
	}
	
	public String getChangeDealCloseDate() {
		return props.getProperty("changeDealCloseDate");
	}
}
