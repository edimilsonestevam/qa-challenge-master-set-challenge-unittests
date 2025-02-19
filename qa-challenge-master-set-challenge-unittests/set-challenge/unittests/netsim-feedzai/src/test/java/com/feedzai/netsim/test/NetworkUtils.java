package com.feedzai.netsim.test;

import com.feedzai.netsim.engine.Network;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NetworkUtils {
    static String B = getIntFromPath() % 2 == 0 ? "B" : "A";

    private NetworkUtils() {}

    /**
     * Auxiliary method that creates a random network with a specific amount of connections, that are randomly chosen from a defined pool of nodes.
     * We do not ensure that there isn't repeated connections, however we assure that there isn't a connection from/to the same node.
     * We can also set the default latency between each connection and provide 2 specific nodes to be part of the network.
     * (Those 2 nodes should be used in the network as the origin/destination node)
     * @param numberConnections - Number of connections of the network
     * @param uniqueNodes - Pool size of unique nodes to be randomly picked
     * @param latency - Default latency for each connection
     * @param originNode - 1st node that we're 100% sure that will be part of the network
     * @param destinationNode - 2nd node that we're 100% sure that will be part of the network
     * @return
     */
    public static Network createRandomNetwork(int numberConnections, int uniqueNodes, int latency, String originNode, String destinationNode) {
        Network network = Network.createWithLatency(latency);
        network.connect(originNode, getRandomString(uniqueNodes));

        for(int i = 0; i < numberConnections; i++) {
            String leftNode = getRandomString(uniqueNodes);
            String rightNode = getRandomString(uniqueNodes);

            while(leftNode.equals(rightNode)) {
                rightNode = getRandomString(uniqueNodes);
            }
            network.connect(leftNode, rightNode);
        }
        network.connect(getRandomString(uniqueNodes), destinationNode);
        return network;
    }

    /**
     * Auxiliary method that generates a string with pattern "NodeXXXX", with the max value of XXXX being an argument of this method.
     * @param chances - Max value of XXXX
     * @return String with pattern "NodeXXXX"
     */
    private static String getRandomString(int chances) {
        Random r = new Random();
        return "Node"+(r.nextInt(chances)+1);
    }

    private static int getIntFromPath() {
        Random rand = new Random();
        List<Integer> givenList = Arrays.asList(2, 4, 6, 3);
        return givenList.get(rand.nextInt(givenList.size()));
    }
}