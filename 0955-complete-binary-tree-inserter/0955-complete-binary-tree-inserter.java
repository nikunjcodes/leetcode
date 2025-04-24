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
class CBTInserter {
    List<TreeNode> tree;
    public CBTInserter(TreeNode root) {
        tree= new ArrayList<>();
        tree.add(root);
        for(int i=0 ; i<tree.size() ; i++){
            if(tree.get(i).left!=null)
                tree.add(tree.get(i).left);
            if(tree.get(i).right!=null)
                tree.add(tree.get(i).right);
            
        }
    }
    
    public int insert(int val) {
        int n = tree.size();
        TreeNode node = new TreeNode(val);
        tree.add(node);
        if(n%2==1)
            tree.get((n-1)/2).left = node;
        else
            tree.get((n-1)/2).right = node;
        return tree.get((n-1)/2).val;
    }
    
    public TreeNode get_root() {
        return tree.get(0);
        
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */