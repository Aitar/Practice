package Entity;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    private static int idx = 0;

    public TreeNode() { }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }



    /**
     * 先序序列化二叉树
     * @return 序列化结果
     */
    public String serilaizePreOrder() {
        StringBuilder serie = new StringBuilder();
        createSerie(this, serie);
        serie.deleteCharAt(0);
        return serie.toString();
    }

    private void createSerie(TreeNode node, StringBuilder serie) {
        if(node == null) {
            serie.append(",#");
            return;
        }
        serie.append(",").append(node.val);
        createSerie(node.left, serie);
        createSerie(node.right, serie);
    }

    /**
     * 将先序序列化的二叉树反序列化
     * @param preOrder 先序序列化，空节点以"#"代替，节点间用","分割
     * @return 反序列化的二叉树
     */
    public static TreeNode unserializePreOrder(String preOrder) {
        if(!isValidSerialization(preOrder)){
            System.out.println("输入序列不和规范");
            return null;
        }
        String[] nodes = preOrder.split(",");
        TreeNode tree = createTree(nodes);
        idx = 0;
        return tree;
    }

    public static TreeNode createTree(String[] nodes) {
        if("#".equals(nodes[idx])) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx]));
        idx++;
        node.left = createTree(nodes);
        idx++;
        node.right = createTree(nodes);
        return node;
    }

    public static boolean isValidSerialization(String preorder) {
        if("#".equals(preorder)) return true;
        Stack<String> stack = new Stack<>();
        String[] nodes = preorder.split(",");
        for(String str: nodes) {
            if(stack.size() == 1 && stack.peek().equals("#")) return false;
            while("#".equals(str) && !stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();
                stack.pop();
            }
            stack.push(str);
        }
        while(!stack.isEmpty()) {
            if(!"#".equals(stack.pop()))
                return false;
        }
        return true;
    }

    public List<TreeNode> preOrder() {
        LinkedList<TreeNode> serie = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = this;

        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                serie.addLast(p);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }

        return serie;
    }

    public List<TreeNode> postOrder() {
        LinkedList<TreeNode> serie = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = this, r = null;

        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if(p.right != null && p.right != r) {
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                } else {
                    p = stack.pop();
                    serie.addLast(p);
                    r = p;
                    p = null;
                }
            }
        }

        return serie;
    }
}