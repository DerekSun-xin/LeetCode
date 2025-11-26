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
        if (root == null){
            return "#"; 
        }
        String serialTree = ""; 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); 
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (curNode != null){
                serialTree += String.valueOf(curNode.val); 
                queue.add(curNode.left);
                queue.add(curNode.right);
            }else{
                serialTree += "#"; 
            }
        }
        System.out.println(serialTree); 
        return serialTree; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")){
            return null; 
        }
        int idx = 0; 
        String[] dataArray = data.split(""); 
        Queue<TreeNode> queue = new LinkedList<>(); 
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0])); 
        queue.add(root); 
        idx++; 

        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (idx < dataArray.length && !dataArray[idx].equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(dataArray[idx])); 
                curNode.left = leftNode; 
                queue.add(leftNode); 
            }
            idx++; 
            if (idx < dataArray.length && !dataArray[idx].equals("#")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(dataArray[idx])); 
                curNode.right = rightNode; 
                queue.add(rightNode); 
            }
            idx++; 
        }
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));