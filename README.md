# 数据结构与算法

## 数据结构与队列
```
package:
queue
```
## 数组模拟队列
```
package:
sparse(表示稀疏数组)
```
## 链表
```
pakage:
linked
```

## 栈
```
package:
stack
```

## 哈希表（散列）
```
hash是一种数据结构
value = hash(key)
哈希值 = 散列函数(关键字)



```

## 递归
```text
package:
recursion

简单的说: 递归就是方法自己调用自己,每次调用时传入不同的变量.递归有助于编程者解决复杂的问题,同时可以让代码变得简洁。
递归用于解决什么样的问题
1、各种数学问题如: 8皇后问题 , 汉诺塔, 阶乘问题, 迷宫问题, 球和篮子的问题(google编程大赛)
2、各种算法中也会使用到递归，比如快排，归并排序，二分查找，分治算法等.
3、将用栈解决的问题-->第归代码比较简洁

递归需要遵守的重要规则
1、执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
2、方法的局部变量是独立的，不会相互影响, 比如n变量
3、如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据.
4、递归必须向退出递归的条件逼近，否则就是无限递归,出现StackOverflowError，死龟了:)
5、当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。








```

## 排序
```
package:
sort

冒泡排序

选择排序

插入排序

希尔排序

快速排序
-- 快速排序是对冒泡排序的一种改进，**基本思想**是: 通过一趟排序将要排序的数据分割成独立的两部分，
-- 其中一部分的所有数据都比另一部分的所有数据都要小，然后再按此方法对两部分的数据分别进行快速排序，
-- 整个排序过程可以递归进行，以此达到整个数据变成有序序列

归并排序
采用分而治之的思想

基数排序
基数排序: 属于“分配式排序”， 又称“桶子法”，它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中， 
达到排序的作用。
基数排序法是属于稳定性的排序，基数排序法是效率高的稳定排序法
基数排序是桶排序的扩展
基数排序是1887年赫尔曼·何乐礼发明的。它是这样实现的:
将整数按位切分成不同的数字，然后按每个位数分别比较
基数排序基本思想:
1)、将所有待比较数值同一为同样的数位长度， 数位较短的数前面补零。然后，从高到低开始，依次进行依次排序。
这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
2)、


```

## 算法
```
数据结构与算法:

在Java中， 我们常用的查找有四种：
1、顺序（线性）查找
2、二分查找 / 折半查找
3、插值查找
4、斐波拉契查找

线性查找算法(使用遍历)

二分查找算法()
使用二分查找的前提是所查找的数组必须是有序的

插值查找
注意事项: 
1、对于数据量较大， 关键字分布比较均匀的查找表来说，采用插值查找，速度较快
2、关键字分布不均匀的清空下， 该方法不一定比折半查找要好


斐波拉契（黄金分割法）查找算法
1、黄金分割点是指把一条线段分割成两部分，其中一部分与全段长之比等于另一部分与这部分之比。
   取其前三位数字的近似值位0.618。优于按比例设计的造型十分美丽， 因此称为黄金分割， 也称为中外比
2、斐波拉契数列发现斐波拉契数列的两个相邻数的比例无限接近黄金分割值0.618
3、斐波拉契查找算法也是需要有序数列
```

## 树结构
```text

树结构基础部分
**二叉树**

二叉树-删除子节点
1）、如果删除的节点是叶子节点，则删除该节点
2）、如果删除的节点是非子节点、则删除该子树
3）、Demo
-- 删除节点的思路:
-- 1.因为二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除，而不能去判断当前这个节点是不是需要删除
-- 2.如果当前节点的左子节点不为空，并且左子节点就是需要删除的节点，就将this.left=null,并且就返回(结束递归删除)
-- 3.如果当前节点的右子节点不为空，并且右子节点就是需要删除的节点，就将this.right=null,并且就返回(结束递归删除)
-- 4.如果2.3.步骤都没有删除节点，那么我们就需要向左子树递归删除
-- 5.如果4.也没有删除，则向右子树进行递归删除
-- 6.如果树是空树root，如果只有一个root节点，则等价将二叉树置空（首先判断）

二叉树-顺序存储二叉树
从数据存储来看，数组存储方式和树的存储方式可以相互转换，即数组可以转换成树，树也可以转换成数组
特点:
1）、顺序二叉树通常只考虑完全二叉树
2）、第n个元素的左子节点为2 × n + 1
3）、第n个元素的右子节点为2 × n + 2
4)、第n个元素的父节点为（n - 1）/ 2
5)、n:表示二叉树的第几个元素（按0开始编号）。与数组保持一致

二叉树-线索化二叉树

树结构实际应用
堆排序


赫夫曼树
基本介绍:
1、给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度(wpl)达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree), 还有的书翻译为霍夫曼树。
2、赫夫曼树是带权路径长度最短的树，权值较大的结点离根较近。
3、树的带权路径长度：树的带权路径长度规定为所有叶子结点的带权路径长度之和，记为WPL(weighted path length) ,权值越大的结点离根结点越近的二叉树才是最优二叉树。
4、WPL最小的就是赫夫曼树

赫夫曼编码
基本介绍:
1、赫夫曼编码也翻译为哈夫曼编码(Huffman Coding)，又称霍夫曼编码，是一种编码方式, 属于一种程序算法
2、赫夫曼编码是赫哈夫曼树在电讯通信中的经典的应用之一。
3、赫夫曼编码广泛地用于数据文件压缩。其压缩率通常在20%～90%之间
4、赫夫曼码是可变字长编码(VLC)的一种。Huffman于1952年提出一种编码方法，称之为最佳编码
赫夫曼编码是无损处理方案
注意事项：
1、如果文件本身就是经过压缩处理的，那么使用赫夫曼编码再压缩效率不会有明显变化, 比如视频,ppt 等等文件  [举例压一个 .ppt]
2、赫夫曼编码是按字节来处理的，因此可以处理所有的文件(二进制文件、文本文件) [举例压一个.xml文件]
3、如果一个文件中的内容，重复的数据不多，压缩效果也不会很明显. 



树结构应用部分

```

## 二叉排序树 
```text
二叉排序树：BST（Binary Sort Tree）,对于二叉排序树的任何一个非叶子节点，要求左子节点的值比当前节点的值小， 右子节点的值比当前节点的值大

平衡二叉树（AVL数）


```

##
```text

多路查找树

2-3数

234数

B数

B+树

B*树


```

## 图
```text
当需要处理多对多的关系时， 需要使用到图。
图是一种数据结构，其中节点可以具有0个或多个相邻元素。两个节点之间的连接称为边。节点也可以称为顶点。
🍎 常用概念
   🍇 顶点(vertex)
   🍇 边(edge)
   🍇 路径
   🍇 无向图:顶点之间的连接没有方向
   🍇 有向图:顶点之间的连接由方向
   🍇 带权图:边是有权值， 也叫网
🍓 图的表示方式
   🍇 二维数组表示（邻接矩阵）、链表表示（邻接表）
   🍇 
🍌 图的深度优先遍历
   🍇 图的遍历即是对节点的访问， 一个图有那么多节点， 如何遍历这些节点， 需要特定策略， 一般有两种访问策略
   🥝 深度优先遍历（dfs）
   🥝 广度优先遍历
   深度优先搜索是一个递归的过程
   深度优先遍历算法步骤:
   🍒 访问初始节点v，并标记节点v为已访问
   🍑 查找节点v的第一个邻近节点w
   🍒 若w存在，则继续执行下一步，如果w不存在，则回到第一步，将从v的下一个节点继续
   🍑 若w未被访问，对w进行深度优先遍历(即把w当作另一个v，然后进行前三个步骤)
   🍒 查找节点v的w邻接节点的下一个邻接节点， 占到步骤3
   

```

## 算法
```text

常用10种算法

🍒 二分查找算法(非递归)
二分查找只适用于从有序的数列种进行查找(比如数字和字母)，将数列排序后再进行查找
二分查找算法的运行时间为对数时间O(log2n),即查找到需要的目标位置最多只需要log2n步,假设从[0,99]的队列(100个数，即n=100)中需找到目标数30，
则需要查找部署为log2100， 即最多需要查找(2^6 < 100 < 2^7)

🍒 分治算法
分治算法是一种很重要的算法， 字面上的解释是"分而治之"
就是把一个复杂的问题分成两个或更多的相同或相似的子问题， 再把子问题分成更小的子问题， 直到最后子问题可以简单的直接求解，
原问题的解即子问题解的合并。（这个技巧是很多高效算法的基础）
分子算法可以求解一些的经典问题
🍓 二分搜索
🍓 大整数乘法
🍓 棋盘覆盖
🍓 合并排序
🍓 快速排序
🍓 线性时间选择
🍓 最接近点对问题
🍓 循环赛日程表
🍓 汉诺塔

🍎 分支算法的基本步骤
分治法在每一层递归上都有三个步骤:
🍓 分解: 将原问题分解为若干个规模较小，相互独立， 与原问题形式相同的子问题
🍓 解决: 若子问题规模较小而容易被解决则直接解， 否则递归地解决各个子问题
🍓 合并: 降格子问题的解合并为原问题的解


🍒 动态规划算法
应用场景: 背包问题
算法介绍:
🍓 动态规划（Dynamic Programming）算法的核心思想是: 将大问题划分为小问题进行解决， 从而一步步获取最优解的处理算法
🍓 动态规划算法与分治算法类似， 基本思想也是将待求解分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解
🍓 与分子算法不同的是， 适合于用动态规划求解的问题，经分解得到子问题往往不是相互独立的。（即下一个子阶段的求解是建立在上一个子阶段的解的基础上，进行进一步的求解）
🍓 动态规划可以通过填表的方式来逐步推进， 得到最优解

01背包和无限背包

🍒 KMP算法
KMP - 字符串查找算法
暴力匹配(不推荐, 效率很低~~~)
KMP是一个解决模式在字符串是否出现过， 如果出现过， 最早出现的位置的经典算法
常用于在一个文本串S内查找一个模式串P的出现位置。
KMP算法就是利用之前判断过的信息， 通过一个next数组， 保存模式串中前后最长公共子序列的长度， 每次回溯时， 通过next数组找到， 前面匹配过的位置。 省去了大量的计算时间


```


## 备注
```text
1、IDEA格式化快捷键Ctrl+Alt+l

```

## 补充
```text
Java二进制源码、编码、补码、反码

TODO

```