package com.feedzai.netsim.engine;

public class NetworkConnection {


	public void interConnect(String networkPathOriginDestination) {
		
		// Create a network with a default latency of 1 ms between nodes
        Network net = Network.createWithLatency(1);

        // Interconnect network elements
        net.connect("A", "D");                // Uses default network latency
        net.connect("B", "D");
        net.connect("C", "E");
        net.connect("I", "G");
        net.connect("J", "F");
        net.connect("K", "H", 10);            // Connect K computer to H router with a 10ms latency
        net.connect("D", "E", 3);             // D to E has a 3ms latency
        net.connect("D", "F", 2);             // D to F has a 2ms latency
        net.connect("E", "F", 4);             // E to F has a 4ms latency
        net.connect("E", "G", 5);             // E to G has a 5ms latency
        net.connect("G", "F", 3);             // G to F has a 3ms latency
        net.connect("F", "H", 5);             // F to H has a 5ms latency

        // Print out the network
        System.out.println("Network representation (as an adjacency list)");
        System.out.println(net);

      
        // By Edimilson Estevam
        // Variables internal used to parameter
        String chosenNetworkPathInternalVariableCJ = "CJ";
        String chosenNetworkPathInternalVariableCI = "CI";
        String chosenNetworkPathInternalVariableCK = "CK";
        String chosenNetworkPathInternalVariableBJ = "BJ";
        String chosenNetworkPathInternalVariableBI = "BI";
        String chosenNetworkPathInternalVariableBK = "BK";
        String chosenNetworkPathInternalVariableAJ = "AJ";
        String chosenNetworkPathInternalVariableAI = "AI";
        String chosenNetworkPathInternalVariableAK = "AK";
        
        // Verify chosen network path
        if(chosenNetworkPathInternalVariableCJ.equalsIgnoreCase(networkPathOriginDestination)){
        	
            // Simulate sending a packet from "C" to "J"
            NetworkPath pathCJ = net.sendPacket("C", "J");
            
            // Print out the network path and how much time it took to send the packet
            System.out.println("Sending a packet from 'C' to 'J':");
            System.out.println( pathCJ );
            System.out.println("Time it took (msec):");
            System.out.println( pathCJ.getTime() );
            
        }else if(chosenNetworkPathInternalVariableCI.equalsIgnoreCase(networkPathOriginDestination)){
            NetworkPath pathCI = net.sendPacket("C","I");
            
            System.out.println("Sending a packet from 'C' to 'I':");
            System.out.println( pathCI );
            System.out.println("Time it took (msec):");
            System.out.println( pathCI.getTime() );
            
        }else if(chosenNetworkPathInternalVariableCK.equalsIgnoreCase(networkPathOriginDestination)){
        	
        	NetworkPath pathCK = net.sendPacket("C","K");
        	
            System.out.println("Sending a packet from 'C' to 'K':");
            System.out.println( pathCK );
            System.out.println("Time it took (msec):");
            System.out.println( pathCK.getTime() );
            
        }else if(chosenNetworkPathInternalVariableBJ.equalsIgnoreCase(networkPathOriginDestination)){
        	
        	NetworkPath pathBJ = net.sendPacket("B","J");
        	
            System.out.println("Sending a packet from 'B' to 'J':");
            System.out.println( pathBJ );
            System.out.println("Time it took (msec):");
            System.out.println( pathBJ.getTime() );
            
        }else if(chosenNetworkPathInternalVariableBI.equalsIgnoreCase(networkPathOriginDestination)){
        	
        	NetworkPath pathBI = net.sendPacket("B","I");
        	
            System.out.println("Sending a packet from 'B' to 'I':");
            System.out.println( pathBI );
            System.out.println("Time it took (msec):");
            System.out.println( pathBI.getTime() );
            
        	
        }else if(chosenNetworkPathInternalVariableBK.equalsIgnoreCase(networkPathOriginDestination)){
        	
        	NetworkPath pathBK = net.sendPacket("B","K");
        	
            System.out.println("Sending a packet from 'B' to 'K':");
            System.out.println( pathBK );
            System.out.println("Time it took (msec):");
            System.out.println( pathBK.getTime() );
            
        }else if (chosenNetworkPathInternalVariableAJ.equalsIgnoreCase(networkPathOriginDestination)){
        	
        	NetworkPath pathAJ = net.sendPacket("A","J");
        	
            System.out.println("Sending a packet from 'A' to 'J':");
            System.out.println( pathAJ );
            System.out.println("Time it took (msec):");
            System.out.println( pathAJ.getTime() );
            
        }else if(chosenNetworkPathInternalVariableAI.equalsIgnoreCase(networkPathOriginDestination)) {
        	
        	NetworkPath pathAI = net.sendPacket("A","I");
        	
            System.out.println("Sending a packet from 'A' to 'I':");
            System.out.println( pathAI );
            System.out.println("Time it took (msec):");
            System.out.println( pathAI.getTime() );
            
        }else if(chosenNetworkPathInternalVariableAK.equalsIgnoreCase(networkPathOriginDestination)){
        	
        	NetworkPath pathAK = net.sendPacket("A","K");
        	
            System.out.println("Sending a packet from 'A' to 'K':");
            System.out.println( pathAK );
            System.out.println("Time it took (msec):");
            System.out.println( pathAK.getTime() );
            
        }else {
        	
        	System.out.println("You did not choose correct option! Try again...");
        	System.out.println(
        			"Examples: \"CJ\", "
        			+ "\"CI\", "
        			+ "\"CK\", "
        			+ "\"BJ\", "
        			+ "\"BI\", "
        			+ "\"BK\", "
        			+ "\"AJ\", "
        			+ "\"AI\" or "
        			+ "\"AK\")");

        }
	}
}
