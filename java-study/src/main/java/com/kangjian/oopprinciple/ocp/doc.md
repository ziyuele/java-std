- 项目上线，课程正常销售，但是我们产品需要做些活动来促进销售，比如：打折。那么问题来了：打折这一动作就是一个变化，而我们要做的就是拥抱变化，现在开始考虑如何解决这个问题，可以考虑下面三种方案：
## 修改接口
在之前的课程接口中添加一个方法 getSalePrice() 专门用来获取打折后的价格； 如果这样修改就会产生两个问题，所以此方案否定
- ICourse 接口不应该被经常修改，否则接口作为契约的作用就失去了
- 并不是所有的课程都需要打折，加入还有语文课，数学课等都实现了这一接口，但是只有英语课打折，与实际业务不符

## 修改实现类
在接口实现里直接修改 getPrice()方法，此方法会导致获取原价出问题；或添加获取打折的接口 getSalePrice()，这样就会导致获取价格的方法存在两个，所以这个方案也否定。

##  通过扩展实现变化

直接添加一个子类 SaleEnglishCourse ,重写 getPrice()方法，这个方案对源代码没有影响，符合开闭原则，所以是可执行的方案


综上所述，如果采用第三种，即开闭原则，以后再来个语文课程，数学课程等等的价格变动都可以采用此方案，维护性极高而且也很灵活。