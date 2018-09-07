package com.samples;

import java.util.*;

/**
 * There is a list of node objects with structure Node[id,nextId,prevId]
 * the program should print the nodes in the right order of nodes(using nextId fields)
 *
 */
public class TraverseNode {
    public static void main(String args[]) {
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new Node("456","123", null));
        nodeList.add(new Node("def","abc", "123"));
        nodeList.add(new Node("123","def", "456"));
        nodeList.add(new Node("abc",null, "def"));

        sortNodes(nodeList);
    }

    static void sortNodes(List<Node> nodeList) {
        Node rootNode = null;
        Map<String,Node> nodeMap = new HashMap<>();
        for(Iterator<Node> itr = nodeList.iterator(); itr.hasNext();){
            Node temp = itr.next();
            if(null==temp.prevId){
                rootNode = temp;
            }
            nodeMap.put(temp.id,temp);
        }
        System.out.println(rootNode);
        String next = rootNode.nextId;
        Node nextNode = null;
        for(int i=0;i<nodeMap.size()-1;i++) {
            nextNode = nodeMap.get(next);
            System.out.println(nextNode);
            next = nextNode.nextId;
        }
    }
}

class Node {
    String id;
    String prevId;
    String nextId;

    public Node(String id, String prevId, String nextId) {
        this.id = id;
        this.prevId = prevId;
        this.nextId = nextId;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", prevId='" + prevId + '\'' +
                ", nextId='" + nextId + '\'' +
                '}';
    }
}