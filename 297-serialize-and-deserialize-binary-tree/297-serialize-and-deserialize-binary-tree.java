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
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        serializeHelper(sb, queue);
        return sb.toString();
    }
    
    // same as BFS
    private void serializeHelper(StringBuilder sb, Queue<TreeNode> queue) {
        if(queue.isEmpty()) return;
        
        TreeNode root = queue.poll();
        if(root != null) {
            sb.append(root.val);
            sb.append(" ");
            queue.add(root.left);
            queue.add(root.right);
        } else {
            sb.append("null ");
        }
        serializeHelper(sb, queue);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(" ", 0);
        int dataArrLen = dataArr.length;
        if(dataArr[0].equals("null") || dataArrLen == 0) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        
        while(!queue.isEmpty() && counter < dataArrLen) {
            TreeNode curr = queue.poll(), temp;
            
            if(curr == null) continue;
            
            if(counter < dataArrLen && !dataArr[counter].equals("null")) {
                temp = new TreeNode(Integer.parseInt(dataArr[counter]));
                queue.add(temp);
                curr.left = temp;
            } else {
                queue.add(null);
            }
            
            if(counter+1 < dataArrLen && !dataArr[++counter].equals("null")) {
                temp = new TreeNode(Integer.parseInt(dataArr[counter]));
                queue.add(temp);
                curr.right = temp;
            } else {
                queue.add(null);
            }
            
            counter++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));