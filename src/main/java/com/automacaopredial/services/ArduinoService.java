package com.automacaopredial.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class ArduinoService {
	
	public ArduinoService() {
		super();
	}
	
	public void sendGet(String porta, String status) throws IOException {

		String url = "http://192.168.1.168?";//?L=1&M=1&N=0";
		String query;
		if(!porta.isEmpty() && !status.isEmpty()) {
			query = "L=1&M=1&N" + "=" + 1;
			url = url + query;
		}
						
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();

		//print result
		System.out.println(response.toString());
		
	}
}
