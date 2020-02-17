package com.allst.jvalgo.linked;

/**
 * 单链表
 * @author YiYa
 * @since 2020-02-17 下午 10:23
 */
public class IndividualLinkedList {

    public static void main(String[] args) {
        // 创建节点
        PersonNode node1 = new PersonNode(1, "张三", "Zs");
        PersonNode node2 = new PersonNode(2, "李四", "Ls");
        PersonNode node3 = new PersonNode(3, "王五", "Ww");
        PersonNode node4 = new PersonNode(4, "马六", "Ml");

        // 创建链表
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(node1);
        linkedList.add(node4);
        linkedList.add(node3);
        linkedList.add(node2);

        // 显示
        linkedList.list();
    }

}

/**
 * 定义SingleLinkedList管理我们的Person数据
 */
class SingleLinkedList {
    // 初始化头节点， 头节点不要修改，他不存放任何数据
    private PersonNode head = new PersonNode(0, "", "");

    /**
     * 添加节点到单链表
     * 思路：
     * 1、找到当前链表的最后节点
     * 2、将最后这个节点的next指向新的节点
     * @param personNode    对象
     */
    public void add (PersonNode personNode) {
        // 因为head节点不能修改，我们需要一个辅助变量temp
        PersonNode temp = head;
        while (true) {
            if (temp.next == null) {    // 链表最后
                break;
            }
            // 将temp后移
            temp = temp.next;
        }
        // 退出while循环时，temp指向链表最后, 将最后这个节点的next指向新的节点即完成的添加
        temp.next = personNode;
    }

    /**
     * 显示链表
     * 遍历
     */
    public void list () {
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }
        // 因为头节点不能动，因此我们需要一个辅助变量来遍历
        PersonNode temp = head.next;
        while (true) {
            if (temp == null) {     // 判断是否链表最后
                break;
            }
            // 输出信息
            System.out.println(temp);
            // 将temp后移(不后移就是一个死循环)
            temp = temp.next;
        }
    }
}

/**
 * 定义Node, 每个Node对象就是一个节点
 */
class PersonNode {
    public int no;
    public String name;
    public String nickName;
    public PersonNode next;     // 指向下一个节点
    // 构造器
    public PersonNode (int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    // toString
    @Override
    public String toString() {
        return "PersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}