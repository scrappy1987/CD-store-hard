package com.qa.cdstore.service;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;
import com.qa.cdstore.util.Print;

@ApplicationScoped
public class CDServices
{
	private static Logger logger = Logger.getLogger(CDServices.class);
	private Map<Integer, CD> data = new HashMap<Integer, CD>();
	private int id = 1;
	private final boolean verbose;
	
	@Inject
	private JSONUtil converter;

	public CDServices(boolean generate, boolean verbose)
	{
		
		this.verbose= verbose;
		converter = new JSONUtil();
		if(generate)
			generateDummyData();
		// Replace this with an interface that chooses between live data or dummy data
	}

	public String getCDs()
	{
		String s = converter.getJSONFfromEntity(data);
		log(s);
		return s;
	}

	public String addCD(String Json)
	{
		log("Creating CD");
		CD newCD = converter.getEntityFromJSON(Json, CD.class);
		data.put(id++, newCD);
		log("CD Created");
		return Json;
	}

	public String updateCD(Integer idToChange, String update)
	{
		log("Replacing CD");
		CD newCD = converter.getEntityFromJSON(update, CD.class);
		data.put(idToChange, newCD);
		log("CD Replaced");
		return update;
	}

	public String deleteCD(Integer idToDelete)
	{
		log("Removing CD");
		data.remove(idToDelete);
		log("CD removed");
		return "{\"message\": \"CD removed\"}";
	}

	// Replace this with an interface that chooses between live data or dummy data
	private void generateDummyData()
	{
		log("Generating Data");
		data.put(id++, new CD("Nightwish","Nemo","Metal"));
		data.put(id++, new CD("Alestorm","Wenches and Mead","Pirate Metal"));
		data.put(id++, new CD("Angerfist","Spook","Hardstyle"));
		data.put(id++, new CD("Kamelot","March of Mephisto","Metal"));
		
		log("Data Generation Complete");
		printDataState();
	}
	
	private void printDataState()
	{
		if(verbose)
			System.out.println("Data Map Size:"+ data.size());	
		
		if(verbose)
			System.out.println(Print.header("Data",65));
				
		if(verbose)
			for(Map.Entry<Integer, CD> entry : data.entrySet())
				System.out.println(
						Print.fixedString("|Artist:" + entry.getValue().getArtist(),20)
					+	Print.fixedString("|Song:" + entry.getValue().getSong(),25)
					+	Print.fixedString("|Genre:" + entry.getValue().getGenre(),20)
					+	"|");
		
		if(verbose)
			System.out.println(Print.header("",65));		
	}
	
	private void log(String input)
	{
		// The logger is not currently working. Some sort of apache error that I don't know about
		// And judging from the comments on line, its pretty award to fix
		// I'll come back to this if I get a chance
		if(verbose)
			System.out.println(input);
		
		logger.info(input);
	}
}
