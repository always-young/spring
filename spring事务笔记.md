### Spring事务的基本原理
Spring事务的本质其实就是数据库对事务的支持，没有数据库的事务支持，spring是无法提供事务功能的。对于纯JDBC操作数据库，想要用到事务，可以按照以下步骤进行：
1. 获取连接 Connection con = DriverManager.getConnection()
2. 开启事务con.setAutoCommit(true/false);
3. 执行CRUD
4. 提交事务/回滚事务 con.commit() / con.rollback();
5. 关闭连接 conn.close();
使用了spring事务过后 我们不用在书写第二步和第四步的代码
#### 如何开启spring事务
最常用的是在bean的类上或者方法上加@Transactional注解
spring会扫描加了这个注解的bean并生成代理类

### Spring如何管理事务
#### PlatformTransactionManager
使用了模板方法模式，提供了PlatformTransactionManager接口用于管理事务，对应的平台有如下几个实现
![事务](https://image.kevinproject.cn/uPic/mip6nV.png)

#### TransactionDefinition 类似BeanDefinition表明一个事务的属性 @Transactional注解会被解析为一个TransactionDefinition

#### TransactionAttributeSource 事务属性获取接口
其子类AnnotationTransactionAttributeSource用于从@Transactional注解中获取属性
并且依赖SpringTransactionAnnotationParser去解析注解