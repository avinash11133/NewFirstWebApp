package com.am.servers;

import com.am.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.chainsaw.Main;

public class LoginJavaClass 
{
	public static String genHash(String param) throws NoSuchAlgorithmException
	{	
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(param.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		return encoded;
	}
	
	public int ipValidation(String id,String pwd) throws NoSuchAlgorithmException
	{
		int flag=0;
		LoginDAO ldao=new LoginDAO();
		String encodedPwd=genHash(pwd);
		flag=ldao.validate(id, encodedPwd);
		return flag;
	}
	
	ArrayList<Item> getItemList()
	{
		ItemDAO idao=new ItemDAO();
		ArrayList<Item> itemList=idao.itemList();
		return itemList;
	}
	
	static void insert(String id,String pwd) throws NoSuchAlgorithmException
	{
		LoginDAO ldao=new LoginDAO();
		String encodedPwd=genHash(pwd);
		ldao.insert(id,encodedPwd);
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException 
	{
		insert("id1","pwd1");
		insert("id2","pwd2");
		insert("id3","pwd3");
		insert("id4","pwd4");
		insert("id5","pwd5");
	}
}