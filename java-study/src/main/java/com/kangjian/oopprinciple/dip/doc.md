目前张三正在学习 Java 和 C++ 教程, 最初的实现可能是这样
```java
public class ZhangSan {
    public void studyJava() {
        System.out.println("张三正在学习Java教程");
    }
    public void studyCplus() {
        System.out.println("张三正在学习C++教程");
    }
}
  
```
```java
public class Dingceng {
  public static void main(String[] args) {
      ZhangSan zhangSan = new ZhangSan();
      zhangSan.studyJava();
      zhangSan.studyCplus();
  }
}

```
随着学习兴趣的暴涨，张三还想学习 Python 教程。这时就需要业务扩展，代码需要从底层开始修改，即：在 ZhangSan 类中添加 studyPython() 的方法，在高层（这里指的是 main() 方法）也要追加调用该方法。这样发布系统，实际上是非常不稳定的，在修改代码的同时会带来意想不到的风险。

