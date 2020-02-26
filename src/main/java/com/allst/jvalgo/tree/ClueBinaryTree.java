package com.allst.jvalgo.tree;

/**
 * 线索二叉树
 *
 * @author YiYa
 * @since 2020-02-26 上午 01:21
 */
public class ClueBinaryTree {

    public static void main(String[] args) {
        HeroesNode root = new HeroesNode(1, "法师");
        HeroesNode node2 = new HeroesNode(3, "火男");
        HeroesNode node3 = new HeroesNode(6, "妖姬");
        HeroesNode node4 = new HeroesNode(8, "凤凰");
        HeroesNode node5 = new HeroesNode(10, "狐狸");
        HeroesNode node6 = new HeroesNode(14, "小法");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        CLueBinTree tree = new CLueBinTree();
        tree.setRoot(root);
        tree.clueNotes();

        // 测试
        HeroesNode leftNode = node5.getLeft();
        HeroesNode rightNode =node5.getRight();
        System.out.println("10号结点的前驱结点: "  + leftNode); //3
        System.out.println("10号结点的后继结点: "  + rightNode); //1
    }


}

/**
 * 线索二叉树
 */
class CLueBinTree {
    private HeroesNode root;

    public void setRoot(HeroesNode root) {
        this.root = root;
    }

    // 为了实现线索化，需要创建要指向当前结点的前驱结点的指针，在递归进行线索化时，pre 总是保留前一个结点
    private HeroesNode pre = null;

    /**
     * 对二叉树进行中序检索化的方法
     * @param node      节点
     */
    public void clueNotes(HeroesNode node) {
        // 如果node==null, 不能线索化
        if (node == null) {
            return;
        }
        // 先线索化左子树
        clueNotes(node.getLeft());
        // 线索化当前节点[有难度]
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 处理后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        // 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        // 线索化右子树
        clueNotes(node.getRight());
    }

    // 重载
    public void clueNotes() {
        this.clueNotes(root);
    }
}

/**
 * 节点
 */
class HeroesNode {
    // 编号
    private int no;
    // 名称
    private String name;
    // 左节点，默认null
    private HeroesNode left;
    // 右节点，默认null
    private HeroesNode right;
    // 说明: 0表示指向的是左子树, 1表示指向的是前驱节点
    private int leftType;
    // 说明: 0表示指向的是右子树, 1表示指向的是后继节点
    private int rightType;

    public HeroesNode(int no, String name) {
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

    public HeroesNode getLeft() {
        return left;
    }

    public void setLeft(HeroesNode left) {
        this.left = left;
    }

    public HeroesNode getRight() {
        return right;
    }

    public void setRight(HeroesNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroesNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}