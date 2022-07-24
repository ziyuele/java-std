介绍如何使用单一职责原则解决问题。

例如，在一个blog网站中，用户分为普通用户和VIP用户。普通用户不能阅读学习收费文章，VIP用户可以任意反复阅读，功能职责不一样。

首先创建user类

```java
public class User {
    public void study(String userType) {
        if ("common".equals(userType)) {
            System.out.println("不能阅读收费文章");
        } else {
            System.out.println("可以任意反复阅读收费文章");
        }
    }
}
```
客户端测试代码
```java
class Main  {
    public static void main(String[] args) {
        User user = new User();
        user.study("common");
        user.study("vip");
    }
}
```
从上面代码看，User 类承担了两种处理逻辑。假如现在对用户进行加密，那么普通用户和VIP会员的加密逻辑是不一样的，必须修改代码。而修改代码逻辑势必会相互影响，容易带来不可控的风险。

正确的做法， 应该对普通用户和vip用户解耦, 拆分为CommonUser(普通用户)， 和VipUser(Vip用户)

## 不要应为感觉代码少， 就认为可以不用将代码拆分开了。