## JVM原理解析

####1.Java运行时类何时被加载？
通过参数：`-XX:+TraceClassLoading` 可以验证类的加载是交给虚拟机自由实现的，`按需加载`,在需要用到这个类的时候加载这个类；

###2.JVM一个类的加载过程
生命周期经过七个阶段：
1）加载
2）验证
3）准备
4）解析
5）初始化
6）适用
7）卸载