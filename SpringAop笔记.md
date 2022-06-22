## Aop
### 基础概念
#### advice
拦截后具体要执行的方法,分为before,around,afterReturn,Throw，分别定义了集中advice
+ 方法执行前拦截 实现接口MethodBeforeAdvice
+ 方法执行后拦截 实现接口AfterReturningAdvice
+ 抛异常拦截    实现接口ThrowsAdvice
+ 方法环绕拦截 权限最大 可以自己选择如何拦截 实现接口MethodInterceptor
前面三种都是用的最后一种实现的 具体可见AdvisorAdapter
#### pointcut
用来判断具体切的位置，里面有ClassFilter判断类是否需要拦截 MethodMatcher判断方法是否需要拦截
#### advisor
真正用于执行aop，内部具有持有PointCut，也持有一个advice

#### AdvisorSupport
advisor的配置支持类，不管是jdk动态代理或者Cglib动态代理都是靠这个实现代理

#### ProxyFactoryBean
让一个bean变为被代理的bean

#### AbstractAutoProxyCreator
AOP核心类 实现了SmartInstantiationAwareBeanPostProcessor接口 参与了Bean的生命周期的改造 
在postProcessAfterInitialization中通过wrapIfNecessary方法来判断是否需要代理
使用getAdvicesAndAdvisorsForBean(beanClass,beanName)来获取到支持该bean的Advisor
BeanNameAutoProxyCreator通过beanName来判断




