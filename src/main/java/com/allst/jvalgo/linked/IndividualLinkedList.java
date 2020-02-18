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
        /*linkedList.add(node1);
        linkedList.add(node4);
        linkedList.add(node3);
        linkedList.add(node2);*/

        // 测试按顺序添加
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);

        // 显示
        linkedList.list();

        // 修改
        PersonNode node5 = new PersonNode(2, "李四修改", "Lsxg");
        linkedList.update(node5);
        System.out.println("修改后~~~");
        linkedList.list();

        // 删除
        linkedList.delete(1);
        linkedList.delete(4);
        System.out.println("删除后~~~");
        linkedList.list();

        // 有效节点数
        System.out.printf("单链表中有效节点个数为: %d\n", getEffectivityNodeSize(linkedList.getHead()));

        // 倒数第index个节点
        PersonNode node = getNodeLastIndex(linkedList.getHead(), 1);
        System.out.println("倒数第1个节点为: " + node);
    }

    /**
     * 获取有效节点数，如果是带头节点的链表统计时，不需要统计头节点
     * @param node      节点对象
     * @return 节点数
     */
    public static int getEffectivityNodeSize(PersonNode node) {
        if (node.next == null) {
            System.out.println("链表为空~~~~");
            return 0;
        }
        // 定义一个temp变量
        PersonNode temp = node.next;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;   // 遍历
        }
        return size;
    }

    /**
     * 获取链表中倒数第index个节点
     * 思路：
     * 1、遍历节点有效个数size， 可以直接调用方法: getEffectivityNodeSize
     * 2、size - index表示所求节点
     *
     * @param head      head节点
     * @param index     倒数第index
     * @return          节点对象
     */
    public static PersonNode getNodeLastIndex(PersonNode head, int index) {
        if (head.next == null) {
            System.out.println("连接为空~~~");
            return null;
        }
        // 获取节点有效数
        int size = getEffectivityNodeSize(head);
        // 校验index
        if (index <= 0 || index > size) {
            System.out.printf("传递的参数%d不合理\n", index);
            return null;
        }
        // 定义辅助变量
        PersonNode temp = head.next;
        // for循环定位倒数的节点
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

}

/**
 * 定义SingleLinkedList管理我们的Person数据
 */
class SingleLinkedList {
    // 初始化头节点， 头节点不要修改，他不存放任何数据
    private PersonNode head = new PersonNode(0, "", "");

    public PersonNode getHead() {
        return head;
    }

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
     * 有序添加节点到单链表
     * 如果有这个排名则添加失败并给出提示
     * @param personNode 对象
     */
    public void addByOrder (PersonNode personNode) {
        // head节点不能动， 我们需要通过一个辅助变量来帮助找到添加的位置
        // 因为单链表， 我们找的temp时需要位于添加位置的前一个节点， 否则插入不了
        PersonNode temp = head;
        boolean flag = false;   // 标识添加的编号是否存在， 默认false
        while (true) {
            if (temp.next == null) {    // temp在链表最后
                break;
            }
            if (temp.next.no > personNode.no) { // 插入位置找到了， 就在temp的后面插入
                break;
            } else if (temp.next.no == personNode.no) { // 说明希望添加的Node节点的编号已存在
                flag = true;    // 编号存在
                break;
            }
            // 都不符合条件时，后移
            temp = temp.next;
        }
        // 判断flag的值
        if (flag) {
            System.out.printf("待插入Node的编号: %d 已存在， 不能添加\n", personNode.no);
        } else {
            //插入到链表中， temp的后面
            personNode.next = temp.next;
            temp.next = personNode;
        }
    }

    /**
     * 修改节点，根据no来修改
     * @param personNode    对象
     */
    public void update (PersonNode personNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // head节点不能动， 需要通过一个辅助变量
        PersonNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {    // 表示遍历完链表
                break;
            }
            if (temp.no == personNode.no) {
                flag = true;    // 找到该节点
                break;
            }
            temp = temp.next;
        }
        // 判断是否找到对应的节点
        if (flag) {
            temp.name = personNode.name;
            temp.nickName = personNode.nickName;
        } else {
            System.out.printf("待修改的no = %d 未找到， 不能修改~~~\n", personNode.no);
        }
    }

    /**
     * 删除Node
     * @param no    通过no删除Node
     */
    public void delete (int no) {
        if (head.next == null) {
            System.out.printf("链表为空， 不能删除节点 %d", no);
            return;
        }
        PersonNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) { // 遍历完链表
                break;
            }
            if (temp.next.no == no) {   // 找到当前待删除Node的上一节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断是否找到对应的节点
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("待删除的no = %d 不存在， 不能删除~~\n", no);
        }
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