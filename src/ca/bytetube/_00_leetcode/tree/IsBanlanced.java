package ca.bytetube._00_leetcode.tree;

class IsBalanced {

    //dto
    public static class ReturnData {
        public boolean isB;
        public int height;

        public ReturnData(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

    public  boolean isBalanced(TreeNode root) {
        return isB(root).isB;
    }

    private  ReturnData isB(TreeNode root) {
        if (root == null) return new ReturnData(true, 0);

        ReturnData leftData = isB(root.left);
        //左子树不平衡
        if (!leftData.isB) return new ReturnData(false, 0);

        ReturnData rightData = isB(root.right);
        //左子树不平衡
        if (!rightData.isB) return new ReturnData(false, 0);
        //左右子树虽然平衡，但是高度差大于1
        if (Math.abs((leftData.height - rightData.height)) > 1) return new ReturnData(false, 0);


        //代码能够走到这里，说明以root作为根节点的子树一定是平衡的
        return new ReturnData(true, Math.max(leftData.height, rightData.height) + 1);

    }



}
