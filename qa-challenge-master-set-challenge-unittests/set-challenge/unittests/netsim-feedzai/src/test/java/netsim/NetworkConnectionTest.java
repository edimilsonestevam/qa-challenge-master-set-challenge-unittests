package netsim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.feedzai.netsim.engine.NetworkConnection;
import com.feedzai.netsim.engine.NetworkPath;

// By Edimilson Estevam
public class NetworkConnectionTest{
	
	private NetworkPath resultPath = null;	
	NetworkConnection net = new NetworkConnection();

    
	@Test
	public void testNetworkConnectionPathCJ() {
		
    	net.interConnect("CJ");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[C,E,F,J]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathCI() {
		
    	net.interConnect("CI");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[C,E,G,I]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathCK() {
		
    	net.interConnect("CK");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[C,E,F,H,K]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathBJ() {
		
    	net.interConnect("BJ");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[B,D,F,J]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathBI() {
		
		net.interConnect("BI");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[B,D,F,G,I]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathBK() {
		
		net.interConnect("BK");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[B,D,F,H,K]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathAJ() {
		
		net.interConnect("AJ");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[A,D,F,J]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathAI() {
		
		net.interConnect("AI");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[A,D,F,G,I]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
	
	@Test
	public void testNetworkConnectionPathAK() {
		
		net.interConnect("AK");
    	NetworkPath actualMessage = net.getResultPath();
        
    	String expectedMessage = "[A,D,F,H,K]";
        assertEquals(expectedMessage, actualMessage.toString());
        
	}
}
