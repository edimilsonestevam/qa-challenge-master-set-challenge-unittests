package com.feedzai.netsim.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.feedzai.netsim.engine.NetworkConnection;
import com.feedzai.netsim.engine.NetworkPath;

// By Edimilson Estevam
public class NetworkConnectionTest {
	
	NetworkConnection net = new NetworkConnection();

	@Test
	public void testNetworkConnectionPathCJ() {
		
		net.interConnect("CJ");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[C,E,F,J]";
        assertEquals("Workflow C --> J", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathCI() {
		
		net.interConnect("CI");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[C,E,G,I]";
        assertEquals("Workflow C --> I", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathCK() {
		
		net.interConnect("CK");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[C,E,F,H,K]";
        assertEquals("Workflow C --> K", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathBJ() {
		
		net.interConnect("BJ");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[B,D,F,J]";
        assertEquals("Workflow B --> J", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathBI() {
		
		net.interConnect("BI");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[B,D,F,G,I]";
        assertEquals("Workflow B --> I", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathBK() {
		
		net.interConnect("BK");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[B,D,F,H,K]";
        assertEquals("Workflow B --> K", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathAJ() {
		
		net.interConnect("AJ");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[A,D,F,J]";
        assertEquals("Workflow A--> J", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathAI() {
		
		net.interConnect("AI");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[A,D,F,G,I]";
        assertEquals("Workflow A --> I", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathAK() {
		
		net.interConnect("AK");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[A,D,F,H,K]";
        assertEquals("Workflow A --> K", expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathWrong() {
		
		net.interConnect("ED");
    	NetworkPath actualMessage = net.getResultPath();
        
    	assertNull("Wrong Workflow", actualMessage);
        
	}
}
