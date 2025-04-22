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
    List<Integer> nodes;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        nodes= new ArrayList<>();
        helper(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int q : queries){
            if(q==nodes.get(0) || q==nodes.get(0))
                ans.add(Arrays.asList(q,q));
            else if (q<nodes.get(0))
                ans.add(Arrays.asList(-1 , nodes.get(0)));
            else if (q > nodes.get(nodes.size()-1))
                ans.add(Arrays.asList(nodes.get(nodes.size()-1) , -1));
            else{
                int low = 0;
                int high = nodes.size()-1;
                int flag = 0;
                while(low <= high){
                    int mid = low + (high-low)/2;
                    int midV = nodes.get(mid);
                    if(q==midV){
                        flag=1;
                        ans.add(Arrays.asList(q,q));
                        break;
                    }
                    else if (q > midV)
                        low=  mid+1;
                    else
                        high = mid-1;

                }
                if(flag==0){
                    ans.add(Arrays.asList(nodes.get(high) , nodes.get(low)));
                }
            }
            }
            return ans;
        }
    
    void helper(TreeNode root){
        if(root==null)
            return;
       
        helper(root.left);
         nodes.add(root.val);
         helper(root.right);

    }
    }
    
