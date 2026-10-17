/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp=root;
        //need traversal as here we need to fina a value(node)
        while(temp!=null){
            //if both values are bigger then right, and if both small, then left
            if(p.val>temp.val && q.val>temp.val){
                temp=temp.right;
            }
            else if(p.val<temp.val && q.val<temp.val){
                temp=temp.left;
            }
            //both edge cases:
            //1. if one is small, one is big, means split so this is the answer
            //2. if one is small/bigger and other is equal, then also, this is answer
            else{
                return temp;
            }
        }
        return temp;
    }
}
