package com.example.ffs;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class OpenHttpConnection {
private InputStream in;
	
	public OpenHttpConnection() {
		in = null;
	}
	public OpenHttpConnection(String strURL) {
		try{
			in = OpenHttpConnection(strURL);
		
		 }catch (IOException e1) {
        }
	}
	
	
	private InputStream OpenHttpConnection(String strURL) throws IOException{
		 InputStream inputStream = null;
		 URL url = new URL(strURL);
		 URLConnection conn = url.openConnection();

		 try{
		  HttpURLConnection httpConn = (HttpURLConnection)conn;
		  httpConn.setRequestMethod("GET");
		  httpConn.connect();

		  if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
		   inputStream = httpConn.getInputStream();
		  }
		 }
		 catch (Exception ex)
		 {
		 }
		 return inputStream;
		}
	
	public void close(){
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public InputStream sendWith() {
		// TODO Auto-generated method stub
		return in;
	}
	
}
