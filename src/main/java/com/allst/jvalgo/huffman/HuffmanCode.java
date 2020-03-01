package com.allst.jvalgo.huffman;

import java.util.*;

/**
 * 赫夫曼编码
 * contraction: 压缩
 * @author YiYa
 * @since 2020-03-01 上午 12:09
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] contentBytes = str.getBytes();
        List<Node> list = getNodes(contentBytes);
        // System.out.println(list);
        Node nodes = createHufmTree(list);
        nodes.preOrder();
        // System.out.println(nodes);
        Map<Byte, String> map = getHuffmanCodes(nodes);
        // System.out.println(map);
        byte[] result = encodeHuffm(contentBytes, map);
        System.out.println(Arrays.toString(result));
        /*StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(b);
        }
        System.out.println(sb.toString());*/

        // 调用封装的方法
        // byte[] result2 = huffmanZip(contentBytes);

        byte[] encodeResult = decodeHuffm(map, result);
        System.out.println("result0 : " + new String(encodeResult));
        // System.out.println("result2 : " + Arrays.toString(encodeResult));
    }

    /**
     * 将字符数组转换为节点集合
     *
     * @param bytes     数组
     * @return          结果
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            // counts.merge(b, 1, (a, b1) -> a + b1);
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        // 将键值对转到为Node对象
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 创建赫夫曼树
     * @param nodes     节点集合
     * @return          结果
     */
    private static Node createHufmTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            // 获取权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // 组成新的节点
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            // 将已经处理的两颗二叉树删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将新生成的二叉树加入到nodes
            nodes.add(parent);
        }
        // nodes最后的节点九四赫夫曼的根节点
        return nodes.get(0);
    }

    /**
     * 重写前序遍历
     * @param root      节点
     */
    private static void preOrder(Node root){
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空~~~");
        }
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder resultSb = new StringBuilder();
    /**
     * 获取Node的所有叶子节点的赫夫曼编码
     *
     * @param node      树Node
     * @param code      路径编码:左边节点为0, 右边节点1
     * @param sb        用于拼接
     */
    private static void getHuffmCodes(Node node, String code, StringBuilder sb) {
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(code);
        if (node != null) {
            // 非叶子节点
            if (node.data == null) {
                // 向左递归
                getHuffmCodes(node.left, "0", stringBuilder);
                // 向右递归
                getHuffmCodes(node.right, "1", stringBuilder);
            } else {// 找到子节点
                huffmanCodes.put(node.data, stringBuilder.toString());
            }
        }
    }

    /**
     * 重载getHuffmanCodes
     * @param root      树节点
     * @return          结果
     */
    private static Map<Byte, String> getHuffmanCodes(Node root) {
        if (root == null) {
            return null;
        }
        // 处理左子树
        getHuffmCodes(root.left, "0", resultSb);
        // 处理右子树
        getHuffmCodes(root.right, "1", resultSb);
        return huffmanCodes;
    }

    /**
     * 将字符串数组通过赫夫曼编码表进行编码
     * @param bytes         字符串数组
     * @param huffmanCodes  赫夫曼编码表
     * @return              结果
     */
    private static byte[] encodeHuffm(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCodes.get(b));
        }
        // 将二进制码转换十进制存储(相当于压缩数据)
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        byte[] huffmEncode = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {  // 8位对应一个byte
            String strByte;
            // 不够8位
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            // 将strByte转成一个byte
            huffmEncode[index] = (byte)Integer.parseInt(strByte, 2);
            index++;
        }

        return huffmEncode;
    }

    /**
     * 封装方法
     * @param bytes     原始字符串对应的字节数组
     * @return          是经过赫夫曼编码处理后的字节数组(压缩后数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmRoot = createHufmTree(nodes);
        Map<Byte, String> huffmCodes = getHuffmanCodes(huffmRoot);
        return encodeHuffm(bytes, huffmCodes);
    }

    /**
     * 将byte转换成二进制字符串
     * @param flag      标志是否需要补高位，true / false， 如果是最后一个字节无需补高位
     * @param b         传入的byte
     * @return          结果
     */
    private static String byte2BitString(boolean flag, byte b) {
        int temp = b;
        // 如果是正数还存在补高位问题
        if (flag) {
            temp |= 256;    // 运算后的temp是对应二进制的补码
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8); // 取后8位
        } else {
            return str;
        }
    }

    /**
     * 对经过赫夫曼编码后的数据进行解码
     * @param huffmanCodes      赫夫曼编码表
     * @param huffmanBytes      赫夫曼编码后的字节数组
     * @return                  结果
     */
    private static byte[] decodeHuffm(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder sb = new StringBuilder();
        // 将byte数组转换位二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            // 判断是否最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            sb.append(byte2BitString(!flag, b));
        }
        // System.out.println("sb~~~ : " + sb.toString());
        // 把字符串按照指定的赫夫曼编码进行解码
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {    // i相当于一个索引， 不断扫描二进制字符串
            // 计数器
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                // 递增取出key, i不动让count移动，指定匹配到一个字符
                String key = sb.substring(i, i + count);
                b = map.get(key);
                // 没有匹配上
                if (b == null) {
                    count++;
                } else {        // 匹配到就退出
                    flag = false;
                }
            }
            list.add(b);
            i += count;     // 直接移动到count处所在的字符
        }
        // for循环结束后， list中存放的就是解码后的原字符串
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }
}

/**
 * Node,
 */
class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}