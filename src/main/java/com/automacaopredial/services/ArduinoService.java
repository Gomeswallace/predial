package com.automacaopredial.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.automacaopredial.domain.Equipamento;

@Service
public class ArduinoService {
	
	public ArduinoService() {
		super();
	}
	
	public void sendGet(Equipamento obj) throws IOException {
		
		String ip = String.valueOf(obj.getAmbiente().getDispositivo().getIP());
		String porta = new String();
		String status = new String();
		if(obj.getPorta() != 0 && !obj.getStatus()) {
			porta = String.valueOf(obj.getPorta());
			status = String.valueOf(obj.getStatus());
		}
		
		//String url = "http://www.google.com/search?q=mkyong";
		String url = "http://" + ip + "?";//?L=1&M=1&N=0";
		String query;
	
		query = porta + "=" + status;
		url = url + query;
		
		URL conexao = new URL(url);
		HttpURLConnection con = (HttpURLConnection) conexao.openConnection();

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
