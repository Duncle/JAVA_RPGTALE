package Game.Trees;


import java.util.List;

public class Node {

    int id;
    Object value;
    String key;
    List<Node> nextNodes;


    public Node(int id, String key, Object value, List<Node> nextNodes) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.nextNodes = nextNodes;
    }

    public Node(int id, String key, Object value) {
        this.id = id;
        this.value = value;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<Node> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(List<Node> nextNodes) {
        this.nextNodes = nextNodes;
    }

    public static void insertNode(Node currentNode, Node... nodesToBeAdded) { // метод вставки нового элемента

        for (Node node : nodesToBeAdded) {
            currentNode.nextNodes.add(node);
        }


    }
}