package com.allst.jvalgo.hashtab;

import java.util.Scanner;

/**
 * 哈希表
 *
 * @author YiYa
 * @since 2020-02-22 下午 03:15
 */
public class HashTabDemo {

    public static void main(String[] args) {
        // 创建一个hash表
        HashTab tab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 遍历雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id:");
                    int id = scanner.nextInt();
                    System.out.println("输入name:");
                    String name = scanner.next();
                    System.out.println("输入age:");
                    int age = scanner.nextInt();
                    // 创建Emp对象
                    Emp emp = new Emp(id, name, age);
                    tab.add(emp);
                    break;
                case "list":
                    tab.list();
                    break;
                case "exit":
                    System.out.println("已退出~~~");
                    scanner.close();
                    System.exit(0);
                default:
                    break;
           }
        }
    }

}

/**
 * 创建哈希表
 */
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        // 初始化链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     * @param emp   参数
     */
    public void add(Emp emp) {
        int empNo = hashFunc(emp.id);
        empLinkedListArray[empNo].add(emp);
    }

    /**
     * 遍历hash表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }

    /**
     * 自定义散列函数
     * @return  散列值
     */
    private int hashFunc(int id) {
        return id % size;
    }
}


/**
 * 链表类
 */
class EmpLinkedList {
    private Emp head;

    // 添加
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp currEmp = emp;
        while (true) {
            if (currEmp.next == null) {
                break;
            }
            currEmp = currEmp.next;
        }
        currEmp.next = emp;
    }

    // 遍历
    public void list() {
        if (head == null) {
            System.out.println("链表为空，不能遍历~~~");
            return;
        }
        Emp currEmp = head;
        while (true) {
            System.out.println(head.toString());
            if (currEmp.next == null) {
                break;
            }
            currEmp = currEmp.next;
        }
    }
}

/**
 * 雇员类
 */
class Emp {
    public int id;
    public String name;
    public int age;
    public Emp next;
    // 构造器
    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

