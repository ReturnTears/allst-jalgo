package com.allst.jvalgo.binTree;

/**
 * 二叉排序树
 *
 * @author YiYa
 * @since 2020-03-02 下午 09:24
 */
public class BinarySortTree {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinSortTree tree = new BinSortTree();
        // 循环添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        // 中序遍历二叉排序树
        tree.infixOrder();

        // 删除叶子节点
        /*tree.deleteNode(2);
        tree.deleteNode(1);
        tree.deleteNode(5);
        System.out.println("删除叶子节点后~~~");
        tree.infixOrder();*/

        // 删除一颗子树的节点
        /*tree.deleteNode(1);
        System.out.println("删除只有一颗子树的节点后~~~");
        tree.infixOrder();*/

        // 删除有两颗子树的节点
        tree.deleteNode(3);
        System.out.println("删除右两颗子树的节点后~~~");
        tree.infixOrder();

        // 随便颠倒删除节点的顺序都可以
        /*tree.deleteNode(2);
        tree.deleteNode(1);
        tree.deleteNode(5);
        System.out.println("删除节点后~~~");
        tree.infixOrder();*/
    }

}

/**
 * 创建二叉排序树
 */
class BinSortTree {
    private Node root;

    /**
     * 添加节点方法
     * @param node  节点
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空, 不能遍历~~~");
        }
    }

    /**
     * 查找要删除的节点
     * @param value     节点值
     * @return          节点
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找要删除节点的父节点
     * @param value     节点值
     * @return          父节点
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除二叉排序树中右子树最小值节点
     * @param node      节点(当作二叉排序树的根节点)
     * @return          返回以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        // 循环查找左子节点就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    /**
     * 删除叶子节点
     * @param value     节点值
     */
    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            // 找到待删除的节点
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            // 只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // 找到待删除节点的父节点
            Node parent = searchParent(value);
            // 叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断targetNode是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {    // 左子节点
                    parent.left = null;
                }
                if (parent.right != null && parent.right.value == value) {  // 右子节点
                    parent.right = null;
                }
                // 删除有两颗子树的节点
            } else if (targetNode.left != null && targetNode.right != null) {
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;

                // TODO 换一种思路: 从左子树找到最大的节点，
            } else {    // 删除只有一颗子树的节点
                // 如果要删除的节点有左子节点
                if (targetNode.left != null) {
                    if (parent != null) {
                        // 如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            // 如果targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {    // 如果要删除的节点有右子节点
                    if (parent != null) {
                        if (parent.left.value == value) {
                            // 如果targetNode是parent的左子节点
                            parent.left = targetNode.right;
                        } else {
                            // 如果targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }

            }
        }
    }


}

/**
 * Node节点
 */
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 递归添加节点， 注意需要满足二叉排序树的要求
     *
     * @param node 节点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 比较添加节点的值与根节点的关系
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归向右子树添加
                this.right.add(node);
            }
        }

    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找要删除的节点
     * @param value     节点值
     * @return          节点
     */
    public Node search(int value) {
        if (value == this.value) {  // 找到当前值
            return this;
        } else if (value < this.value) {    // 值小于当前值， 向左子树递归查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {        // 值大于当前值， 向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除节点的父节点
     * @param value     节点值
     * @return          父节点
     */
    public Node searchParent(int value) {
        // 如果当前节点就是要删除的节点的父节点，就返回
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果查找的值小于当前节点的值， 并且当前节点的左节点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;    // 没有父节点
            }
        }
    }
}