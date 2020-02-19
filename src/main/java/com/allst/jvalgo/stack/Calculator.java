package com.allst.jvalgo.stack;

/**
 * 栈实现综合计算器
 *
 * @author YiYa
 * @since 2020-02-19 下午 08:51
 */
public class Calculator {

    public static void main(String[] args) {
        // 中缀表达式
        String expression = "13+5*6-7";
        // 创建两个栈: 数栈， 符号栈
        Array2Stack numsStack = new Array2Stack(10);
        Array2Stack operStack = new Array2Stack(10);
        // 定义相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  // 将每次扫描得到的字符保存到ch中
        String keepNum = "";
        // 开始循环扫描表达式
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                // 不为空作比较
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numsStack.pop();
                        num2 = numsStack.pop();
                        oper = operStack.pop();
                        res = numsStack.calc(num1, num2, oper);
                        // 把运算结果入栈
                        numsStack.push(res);
                        // 将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {// ch是存放的ASCII码值
                // numsStack.push(ch - 48); // (只适合个位数的四则运算)
                // 多位数时的处理
                keepNum += ch;
                // 判断ch是否时表达式的最后一位
                if (index == expression.length() - 1) {
                    numsStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
                        numsStack.push(Integer.parseInt(keepNum));
                        // 注意: 需要情况keepNum
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        // 当表达式扫描完成， 就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            // 符号栈为空时表示，已经计算出了最后的结果，数栈中只有一个数字
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numsStack.pop();
            num2 = numsStack.pop();
            oper = operStack.pop();
            res = numsStack.calc(num1, num2, oper);
            // 把运算结果入栈
            numsStack.push(res);
        }
        System.out.printf("表达式: %s 的计算结果为:%d", expression, numsStack.pop());
    }
}

/**
 * 创建一个栈,数组实现一个栈
 */
class Array2Stack {
    // 数组最大值
    private int maxSize;
    // 数组，存放数据
    private int[] stack;
    // 栈顶，默认初始化为-1
    private int top = -1;

    /**
     * 构造器
     *
     * @param maxSize 参数
     */
    public Array2Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈满
     *
     * @return true / false
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     *
     * @return -1表示栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈push
     *
     * @param value 参数
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满， 不能入栈~~~\n");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈pop
     *
     * @return 取出的数据
     */
    public int pop() {
        if (isEmpty()) {
            // System.out.println("栈空， 不能出栈~~~\n");
            throw new RuntimeException("栈空， 不能出栈~~~\n");
        }
        int res = stack[top];
        top--;
        return res;
    }

    /**
     * 只是返回栈顶的值， 并不真正pop操作
     *
     * @return 结果
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 遍历栈中数据
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空， 不能遍历~~~\n");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈中数据为: stack[%d] = %d", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级由程序员自己决定，用数字代替，数字越大优先级越高
     * 假定表达式中只包含了+ - * / 四种运算
     *
     * @return 优先级
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否操作符
     *
     * @param val 参数
     * @return 结果
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     *
     * @return 结果
     */
    public int calc(int n1, int n2, int oper) {
        int res = 0;    // 用于存放计算结果
        switch (oper) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n2 - n1;
                break;
            case '*':
                res = n1 * n2;
                break;
            case '/':
                res = n2 / n1;
                break;
            default:
                break;
        }
        return res;
    }
}