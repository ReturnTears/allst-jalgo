package com.allst.jvalgo.linked;

/**
 * 双向链表
 *
 * @author YiYa
 * @since 2020-02-18 下午 09:38
 */
public class DuplexLinkedList {

    public static void main(String[] args) {
        System.out.println("双向链表的测试~~~");
        HeroNode node1 = new HeroNode(1, "暗裔剑魔", "亚托克斯");
        HeroNode node2 = new HeroNode(2, "蒸汽机器人", "布里茨");
        HeroNode node3 = new HeroNode(3, "诺克萨斯之手", "德莱厄斯");
        HeroNode node4 = new HeroNode(4, "皎月女神", "黛安娜");
        HeroNode node5 = new HeroNode(5, "祖安狂人", "蒙多医生");
        HeroNode node6 = new HeroNode(6, "时间刺客", "艾克");
        HeroNode node7 = new HeroNode(7, "蜘蛛女皇", "伊莉丝");

        DoubleLinkedList linkedList = new DoubleLinkedList();
        // 添加
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);
        linkedList.add(node6);
        linkedList.add(node7);

        // 列表
        linkedList.list();

        // 修改
        HeroNode node8 = new HeroNode(7, "德玛西亚皇子", "嘉文四世");
        linkedList.update(node8);
        System.out.println("修改后~~~");
        linkedList.list();

        // 删除
        System.out.println("删除后~~~");
        linkedList.delete(2);
        linkedList.list();
    }

}

/**
 * 双向循环列表
 */
class DoubleLinkedList {
    // 初始化Head节点
    private HeroNode head = new HeroNode(0, "", "");

    // 返回头节点
    public HeroNode getHead() {
        return head;
    }

    // 遍历双向循环链表
    public void list() {
        if (head.next == null) {
            System.out.println("双向链表为空~~~");
            return;
        }
        // 通过辅助节点
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 双向链表添加节点（默认添加到最后）
     *
     * @param node 节点对象
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 双链表的第二种添加方式，按照编号顺序
     * 思路：
     * 按照单链表的顺序添加稍作修改即可
     * @param node  节点对象
     */
    public void addByNo(HeroNode node) {

    }

    /**
     * 双向链表修改节点
     *
     * @param node 节点对象
     */
    public void update(HeroNode node) {
        if (head.next == null) {
            System.out.println("双向链表为空，不能修改~~~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("未找到编号为%d的节点，不能修改~~~", node.no);
        }
    }

    /**
     * 双向链表删除节点
     * 对于双向链表可以找到待删除的节点，并且可以自我删除
     *
     * @param no 编号
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，不能删除~~~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;

            if (temp.next != null) {
                // 如果是最后一个节点，不需要指向下面语句
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("待删除节点%d不存在，不能删除~~~", no);
        }
    }


}

/**
 * 定义一个节点对象
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;       // 指向下一个节点，默认为null
    public HeroNode pre;        // 指向前一个节点，默认为null

    // 构造器
    public HeroNode(int no, String name, String nickName) {
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