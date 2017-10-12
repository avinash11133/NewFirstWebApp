package com.am.servers;

import java.util.HashMap;
import com.am.*;

public class ItemDescription 
{
	int id;
	String description;
	
	private ItemDescription()
	{
		
	}
	
	private static ItemDescription obj=new ItemDescription();

	public static ItemDescription getInstance()
	{
		ItemDescriptionDAO id=new ItemDescriptionDAO();
		HashMap<Integer,String> itemMap=id.getDescription();
		return obj;
	}
}