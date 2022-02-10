package Game.Actions;


import Game.Trees.Node;

public class Dialog extends Action {

    private Node rootNode; // корневой узел
    private Node currentNode; // текущий узел

    public Dialog(Node rootNode) {
        this.rootNode = rootNode;
        this.currentNode = rootNode;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

}