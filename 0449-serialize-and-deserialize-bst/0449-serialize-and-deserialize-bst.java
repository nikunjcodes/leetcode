/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        if(root==null)
            return ans.toString();
        Queue<TreeNode> q  = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                ans.append("null ");
                continue;
            }
            ans.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] str = data.split(" ");
        int len = str.length;
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=1 ; i<len ; i++){
            TreeNode parent = queue.poll();
            if(!str[i].equals("null")){
                parent.left = new TreeNode(Integer.parseInt(str[i]));
                queue.add(parent.left);
                
            }
            i++;
            if(i<len && !str[i].equals("null")){
                parent.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;