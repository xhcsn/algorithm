//import java.util.HashMap;
//
///**
// * @Description: 公用常量
// * @Date: 2021/1/4 19:41
// * @Pacakge: PACKAGE_NAME
// * @ClassName: Solution3
// * @Version: v1.0.0
// * @Author: ccc
// */
//public class Solution3 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int length = preorder.length;
//        //为中序遍历构建映射
//        Map<Integer, Integer> inorder_map = new HashMap<>();
//        for(int i = 0; i < inorder.length; i++){
//            inorder_map.put(inorder[i], i);
//        }
//        //构建递归方法，以获得返回值类型为TreeNode的root
//        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, inorder_map);
//        return root;
//    }
//    //                              前序遍历数组   前序遍历数组开始值   前序遍历数组结束值  中序遍历数组  中序遍历数组开始值  中序遍历数组结束值                 中序遍历数组映射
//    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> inorder_map){
//        if (preorderStart > preorderEnd) {
//            return null;
//        }
//        int rootValue = preorder[preorderStart];
//        TreeNode root = new TreeNode(rootValue);
//        if(preorderStart == preorderEnd){
//            return root;
//        }else{
//            //找到rootValue在中序遍历数组中的位置
//            int rootIndex = inorder_map.get(rootValue);
//            //获得左子树以及右子树的前序遍历数组和中序遍历数组的长度
//            int leftNodes = rootIndex - inorderStart;
//            int rightNodes = inorderEnd - rootIndex;
//
//            //                                     前序遍历数组
//            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, inorder_map);
//            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, inorder_map);
//            root.left = leftSubtree;
//            root.right = rightSubtree;
//            return root;
//        }
//    }
//}