package com.feedzai.netsim.example;

import com.feedzai.netsim.engine.NetworkConnection;

/**
 * Simple demonstration application for the network simulator.
 */
public class Main {
    public static void main(String[] args) {
        
    	// User should choose a network path option
    	NetworkConnection net = new NetworkConnection();
    	net.interConnect("BJ");
    	
    }
}