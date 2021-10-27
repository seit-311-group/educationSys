package cn.sysu.educationSys.utils;


public class TreeNodeFunction {
    private String val;
    private TreeNodeFunction leftNode;
    private TreeNodeFunction rightNode;

    public TreeNodeFunction(String val, TreeNodeFunction leftNode, TreeNodeFunction rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public TreeNodeFunction(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public TreeNodeFunction getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNodeFunction leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNodeFunction getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNodeFunction rightNode) {
        this.rightNode = rightNode;
    }
}

