# Java 算法练习

## 排序算法

- 直接插入排序
- 直接插入（二分/折半）排序
- 冒泡排序
- 快速排序
- 选择排序
- 堆排序
- 归并排序

**TimSort**：是 `Arrays.sort` 排序「对象数组」的实现算法，它是「归并排序」和「插入排序」优化后的排序算法。和归并排序相比，TimSort 减少了归并次数，相对于插入排序，引入了二分排序概念。它的变化如下：

1. 归并排序的分段不再以单个元素开始，而是每次先查找「当前最大的排序好的数据片段 run」，然后对 run 进行扩展并利用二分排序，之后将 run 与其他已经排序好的 run 进行归并，产生排序好的大 run。
2. 引入「二分排序」，即 binarySort。即上面直接插入（折半）排序。

![](https://bucket-1255905387.cos.ap-shanghai.myqcloud.com/2019-02-22-14-43-05_r56.png)

其基本工作过程：
1. 扫描数组，确定其中的单调上升段和严格单调下降段，将严格下降段反转；
2. 定义最小基本片段长度，短于此的单调片段通过插入排序集中为长于此的段；
3. 反复归并一些相邻片段，过程中避免归并长度相差很大的片段，直至整个排序完成，所用分段选择策略可以保证O(n log n)时间复杂性。

可以看到，原则上TimSort是归并排序，但小片段的合并中用了插入排序。


> 看了下 jdk 1.8 源码，基本类型数组，是用「`DualPivotQuicksort`」（双轴快速排序）

内部排序算法的比较：

![](https://bucket-1255905387.cos.ap-shanghai.myqcloud.com/2021-06-26-20-20-40_r45.png)



## 树操作

TODO

## 图操作

TODO

