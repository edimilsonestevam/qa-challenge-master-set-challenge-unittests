package com.feedzai.netsim.test;

import static com.feedzai.netsim.test.NetworkUtils.B;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.feedzai.netsim.engine.Network;
import com.feedzai.netsim.engine.NetworkPath;

public class NetworkPathTest {
	private final static Logger LOGGER = Logger.getLogger(NetworkPathTest.class.getName());
	private Network net;
	private int defaultLatency = 1;

	/**
	 * Setup routine that is executed before each test case.
	 */
	@Before
	public void setUp() throws Exception {
		LOGGER.info("Prepare setup for my test {}.");
	}


	@Test
	public void testNetworkPathFastestRoute() {
		net = Network.createWithLatency(defaultLatency);
		net.connect("A", "B", 1);
		net.connect("B", "C", 1);
		net.connect("A", "C", 3);
		NetworkPath path = net.sendPacket("A", "C");
				
		assertEquals("Wrong expected latency between nodes - ", 2, path.getTime());
		assertEquals("Wrong path.", path.toString(), "[A,B,C]");
	}

	@Test
	public void testNetworkPathShortestPath() {
		net = Network.createWithLatency(defaultLatency);
		net.connect("A", "C", 2);
		net.connect("A", "B", 1);
		net.connect("B", "C", 1);
		NetworkPath path = net.sendPacket("A", "C");
	}

	@Test
	public void testNetworkPathTwoRoutesPossibleInCircle() {
		net = Network.createWithLatency(defaultLatency);
		net.connect("A", "B");
		net.connect("B", "C");
		net.connect("C", "D");
		net.connect("D", "A");
		NetworkPath path = net.sendPacket("A", "C");
		
		if(path.contains("B")) {
			assertEquals("Wrong path.", path.toString(), "[A,B,C]");
			assertFalse("Path contains wrong node", path.contains("D"));
		} else {
			assertEquals("Wrong path.", path.toString(), "[A,D,C]");
			assertFalse("Path contains wrong node", path.contains("B"));
		}
		assertEquals("Wrong expected latency between nodes - ", 2, path.getTime());
		
	}

	@Test
	public final void testSendPacketSameNodesOppositeDirection() {
		// Simple case that tests bidirectionality of connections.
		net = Network.createWithLatency(defaultLatency);
		net.connect("A", B);
		NetworkPath path = net.sendPacket("A", "B");
		NetworkPath path2 = net.sendPacket("B", "A");

		assertEquals("Wrong expected latency between nodes - ", defaultLatency, path.getTime());
		assertEquals("Wrong number of nodes in path", 2, path.size());
		assertEquals("Start node is not the origin node", path.peekFirst(), "A");
		assertEquals("Final node is not the destination node", path.peekLast(), "B");
		assertEquals("Wrong expected latency between nodes - ", defaultLatency, path2.getTime());
		assertEquals("Wrong number of nodes in path", 2, path2.size());
		assertEquals("Start node is not the origin node", path2.peekFirst(), "B");
		assertEquals("Final node is not the destination node", path2.peekLast(), "A");

	}

	@Test
	public final void testSendPacketSameNodesWithDiffLatencies() {
		// Corner case that tests bidirectionality of connections with different latencies.
		net = Network.createWithLatency(defaultLatency);
		int smallLatency = 2;
		int bigLatency = 3;
		net.connect("A", "B", smallLatency);
		net.connect("B", "A", bigLatency);
		NetworkPath path = net.sendPacket("A", "B");
		NetworkPath path2 = net.sendPacket("B", "A");

		assertEquals("Wrong expected latency between nodes - ", smallLatency, path.getTime());
		assertEquals("Wrong number of nodes in path", 2, path.size());
		assertEquals("Start node is not the origin node", path.peekFirst(), "A");
		assertEquals("Final node is not the destination node", path.peekLast(), "B");
		assertEquals("Wrong expected latency between nodes - ", smallLatency, path2.getTime());
		assertEquals("Wrong number of nodes in path", 2, path2.size());
		assertEquals("Start node is not the origin node", path2.peekFirst(), "B");
		assertEquals("Final node is not the destination node", path2.peekLast(), "A");
	}

	public void testNetworkPathRandomNetwork() {
		for(int i = 0; i < 100; i++) {
			Network net = NetworkUtils.createRandomNetwork(1000, 1000, defaultLatency, "NodeStart", "NodeFinish");
			NetworkPath path = net.sendPacket("NodeStart", "NodeFinish");

			if(path.getTime() > 0) {
				assertEquals("Start node is not the origin node", path.peekFirst(), "NodeStart");
				assertEquals("Final node is not the destination node", path.peekLast(), "NodeFinish");
				assertTrue(path.size()==path.getTime()+1);
				for(String node : path) {
					assertTrue(Collections.frequency(path, node)==1);
				}
			}
		}
	}
}
