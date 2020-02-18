package com.allst.jvalgo.linked;

/**
 * 约瑟夫问题，采用单向环形链表解决
 *
 * @author YiYa
 * @since 2020-02-18 下午 11:27
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        // 添加
        linkedList.addCar(5);
        // 遍历
        linkedList.showCar();

        // 出圈
        linkedList.delCar(1, 2, 5);

    }

}

/**
 * 创建一个单向环形链表
 */
class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Car first = null;

    // 添加Car节点， 构建一个环形链表
    public void addCar(int nums) {
        // 数据校验
        if (nums < 1) {
            System.out.printf("添加节点编号%d无效~~~\n", nums);
            return;
        }
        Car currCar = null;     // 辅助指针，帮助构建环形链表
        // 使用佛如循环创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建Car节点
            Car car = new Car(i);
            if (i == 1) {       // 如果是第一个Car
                first = car;
                first.setNext(first);     // 构成环形
                currCar = first;    // 让currCar指向第一个Car， 因为first是不能动， 就有currCar来构建环形
            } else {
                currCar.setNext(car);
                car.setNext(first);
                currCar = car;
            }
        }
    }

    /**
     * 遍历单向环形链表
     */
    public void showCar() {
        if (first == null) {
            System.out.println("单向环形链表为空");
            return;
        }
        // first不能动， 通过辅助指针来完成遍历
        Car temp = first;
        while (true) {
            System.out.printf("当前Car的编号为: %d\n", temp.getNo());
            if (temp.getNext() == first) {      // 遍历完
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 删除链表
     * 根据用户的输入，计算出Car出圈的顺序
     *
     * @param startNo 表示从第几个Car开始数数
     * @param count   表示数几下
     * @param nums    表示最初有多少Car在环形链表中
     */
    public void delCar(int startNo, int count, int nums) {
        // 校验数据
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输出有误，从新输入~~~");
            return;
        }
        // 因为first不能动， 通过临时节点来帮助Car出圈
        Car helper = first;
        // 首先让创建的helper变量指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // Car报数前，先让first和helper移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当Car报数时，让first和helper指针同时移动m-1次，然后出圈， 这是一个循环的过程，直到圈中只有一个节点
        while (true) {
            // 链表中节点只有一个
            if (helper == first) {
                break;
            }
            for (int i = 0; i < count -1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("Car编号为%d出圈\n", first.getNo());
            // 做出圈操作
            first = first.getNext();
            helper.setNext(first);
        }
        // 将最后的哪一个节点返回
        System.out.printf("最后圈中编号为%d的Car出圈\n", first.getNo()); // 使用first和helper一样
    }
}

/**
 * 创建一个Car,表示一个节点
 */
class Car {
    private int no;     // 编号
    private Car next;   // 指向下一个节点，默认是null

    public Car(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Car getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Car next) {
        this.next = next;
    }
}