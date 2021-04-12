package Solution;

import Entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 路径总和
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int pathSum = 0;
        TreeNode p = root, r = null;
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> ans = new LinkedList<>();

        while(p != null || !stack.isEmpty()) {
            System.out.println(pathSum);
            if(p != null) {
                stack.push(p);
                pathSum += p.val;
                p = p.left;
            } else {
                p = stack.peek();
                if(p.right != null && p.right != r) {
                    p = p.right;
                    stack.push(p);
                    pathSum += p.val;
                    p = p.left;
                }else {
                    if(pathSum == targetSum && p.left == null && p.right == null) {
                        List<Integer> temp = new LinkedList<>();
                        for(TreeNode node: stack) {
                            temp.add(node.val);
                        }
                        ans.add(temp);
                    }
                    p = stack.pop();
                    pathSum -= p.val;
                    r = p;
                    p = null;
                }
            }
        }

        return ans;
    }
}


