package com.allst.jvalgo.tree;

/**
 * 二叉树
 * 前序
 * 中序
 * 后序
 * @author YiYa
 * @since 2020-02-23 上午 12:23
 */
public class BinTree {

    public static void main(String[] args) {
        // 创建一个二叉树
        BinaryTree tree = new BinaryTree();
        HerosNode root = new HerosNode(1, "吸血鬼");
        HerosNode node2 = new HerosNode(2, "火男");
        HerosNode node3 = new HerosNode(3, "妖姬");
        HerosNode node4 = new HerosNode(4, "凤凰");
        HerosNode node5 = new HerosNode(5, "狐狸");
        HerosNode node6 = new HerosNode(6, "亚索");
        HerosNode node7 = new HerosNode(7, "剑圣");

        // 二叉树应该是递归创建的

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node5);
        node2.setRight(node4);
        node3.setLeft(node6);
        node3.setRight(node7);
        tree.setRoot(root);

        System.out.println("前序遍历: ");
        tree.preOrder();

        System.out.println("中序遍历: ");
        tree.midOrder();

        System.out.println("后序遍历: ");
        tree.postOrder();

        System.out.println("前序遍历查找: ");
        HerosNode resNode = tree.preOrder(5);
        if (resNode != null) {
            System.out.println("找到~~~: " + resNode);
        } else {
            System.out.println("没找到~~~:");
        }

        System.out.println("中序遍历查找: ");
        HerosNode resNode2 = tree.midOrder(5);
        if (resNode2 != null) {
            System.out.println("找到~~~:: " + resNode);
        } else {
            System.out.println("没找到~~~::");
        }

        System.out.println("后序遍历查找: ");
        HerosNode resNode3 = tree.postOrder(5);
        if (resNode3 != null) {
            System.out.println("找到~~~::: " + resNode);
        } else {
            System.out.println("没找到~~~:::");
        }

        // 删除节点
        System.out.println("删除节点前~~~~");
        tree.preOrder();
        tree.delNode(3);
        System.out.println("删除节点前后~~~");
        tree.preOrder();
    }

}

/**
 * 定义二叉树
 */
class BinaryTree {

    private HerosNode root;

    public void setRoot(HerosNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，不能遍历~~~");
        }
    }

    // 中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空，不能遍历~~~");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，不能遍历~~~");
        }
    }

    // 前序遍历
    public HerosNode preOrder(int no) {
        if (this.root != null) {
            return this.root.preOrder(no);
        } else {
            return null;
        }
    }

    public HerosNode midOrder(int no) {
        if (this.root != null) {
            return this.root.midOrder(no);
        } else {
            return null;
        }
    }

    public HerosNode postOrder(int no) {
        if (this.root != null) {
            return this.root.postOrder(no);
        } else {
            return null;
        }
    }

    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                // 递归删除
                root.deleteNode(no);
            }
        } else {
            System.out.println("空树，不能删除~~~");
        }
    }
}

/**
 * 创建Node节点
 */
class HerosNode {
    private int no;
    private String name;
    private HerosNode left;
    private HerosNode right;

    public HerosNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HerosNode getLeft() {
        return left;
    }

    public void setLeft(HerosNode left) {
        this.left = left;
    }

    public HerosNode getRight() {
        return right;
    }

    public void setRight(HerosNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HerosNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        // 先输出父节点
        System.out.println(this);
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void midOrder() {
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        // 输出父节点
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     * @param no    no
     * @return      结果
     */
    public HerosNode preOrder(int no) {
        System.out.println("进入前序遍历查找方法~~~");
        // 判断当前节点是否待查找节点
        if (this.no == no) {
            return this;
        }
        // 判断当前节点的左子节点是否为空, 如果不为空, 则向左递归前序查询
        HerosNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrder(no);
        }
        // 如果resNode不为空说明找到了
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrder(no);
        }
        // 到这一步不管又没有找到都必须返回了
        return  resNode;
    }

    /**
     * 中序遍历查找
     * @param no    no
     * @return      结果
     */
    public HerosNode midOrder(int no) {
        HerosNode resNode = null;
        if (this.left != null) {
            resNode = this.left.midOrder(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序遍历查找方法~~~");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.midOrder(no);
        }
        return resNode;
    }

    /**
     * 后序遍历查找
     * @param no    no
     * @return      结果
     */
    public HerosNode postOrder(int no) {
        HerosNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrder(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrder(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序遍历查找方法~~~");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 遍历删除节点
     * @param no    编号
     */
    public void deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }
}