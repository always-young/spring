package org.springframework.beans.factory.config;

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.AttributeAccessor;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

/**
 * A BeanDefinition describes a bean instance, which has property values,
 * constructor argument values, and further information supplied by
 * concrete implementations.
 * 描述bean的元信息 属性信息 构造函数等信息
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	/**
	 * 单例/
	 */
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

	/**
	 * 原型
	 */
	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;


	/**
	 * bean角色定义为ROLE_APPLICATION(默认值)、ROLE_SUPPORT(辅助角色)、ROLE_INFRASTRUCTURE(后台角色，用户无感)
	 */
	int ROLE_APPLICATION = 0;

	int ROLE_SUPPORT = 1;

	int ROLE_INFRASTRUCTURE = 2;


	// Modifiable attributes

	/**
	 * 设置Parent Name
	 */
	void setParentName(@Nullable String parentName);

	/**
	 * get parent name
	 */
	@Nullable
	String getParentName();

	/**
	 * 设置beanClassName
	 * @param beanClassName
	 */
	void setBeanClassName(@Nullable String beanClassName);

	/**
	 * get bean class name
	 * @return
	 */
	@Nullable
	String getBeanClassName();

	/**
	 * 设置scope 单例bean或者原型bean
	 * @see #SCOPE_SINGLETON
	 * @see #SCOPE_PROTOTYPE
	 */
	void setScope(@Nullable String scope);

	/**
	 * get scope
	 * or {@code null} if not known yet.
	 */
	@Nullable
	String getScope();

	/**
	 * 设置是否延迟加载
	 * @param lazyInit
	 */
	void setLazyInit(boolean lazyInit);

	/**
	 * 判断是否延迟加载
	 * @return
	 */
	boolean isLazyInit();

	/**
	 * 设置dependenOn
	 * @param dependsOn
	 */
	void setDependsOn(@Nullable String... dependsOn);

	/**
	 * Return the bean names that this bean depends on.
	 * get dependsOn
	 */
	@Nullable
	String[] getDependsOn();

	/**
	 * 类似于primary 设置为false优先注入其他同类型的
	 */
	void setAutowireCandidate(boolean autowireCandidate);

	/**
	 * 判断是否自动注入
	 */
	boolean isAutowireCandidate();

	/**
	 * 设置是否优先
	 */
	void setPrimary(boolean primary);

	/**
	 * 判断是否优先
	 */
	boolean isPrimary();

	/**
	 * Specify the factory bean to use, if any.
	 * This the name of the bean to call the specified factory method on.
	 * @see #setFactoryMethodName
	 */
	/**
	 * 设置factoryBeanName
	 * @param factoryBeanName
	 */
	void setFactoryBeanName(@Nullable String factoryBeanName);

	/**
	 * Return the factory bean name, if any.
	 */
	@Nullable
	String getFactoryBeanName();

	/**
	 * Specify a factory method, if any. This method will be invoked with
	 * constructor arguments, or with no arguments if none are specified.
	 * The method will be invoked on the specified factory bean, if any,
	 * or otherwise as a static method on the local bean class.
	 * @see #setFactoryBeanName
	 * @see #setBeanClassName
	 */
	void setFactoryMethodName(@Nullable String factoryMethodName);

	/**
	 * Return a factory method, if any.
	 */
	@Nullable
	String getFactoryMethodName();

	/**
	 * 构造函数参数值
	 */
	ConstructorArgumentValues getConstructorArgumentValues();

	/**
	 * 判断构造函数是否有参数
	 * @since 5.0.2
	 */
	default boolean hasConstructorArgumentValues() {
		return !getConstructorArgumentValues().isEmpty();
	}

	/**
	 * 获取属性值
	 * @return
	 */
	MutablePropertyValues getPropertyValues();

	/**
	 * 是否有属性值
	 * @return
	 */
	default boolean hasPropertyValues() {
		return !getPropertyValues().isEmpty();
	}

	/**
	 * 设置初始化调用方法
	 * @param initMethodName
	 */
	void setInitMethodName(@Nullable String initMethodName);

	/**
	 * Return the name of the initializer method.
	 * @since 5.1
	 */
	@Nullable
	String getInitMethodName();

	/**
	 * 设置销毁前调用方法
	 * @param destroyMethodName
	 */
	void setDestroyMethodName(@Nullable String destroyMethodName);

	/**
	 * Return the name of the destroy method.
	 * @since 5.1
	 */
	@Nullable
	String getDestroyMethodName();

	/**
	 * 设置角色
	 * @param role
	 */
	void setRole(int role);


	int getRole();

	/**
	 * 设置描述
	 * @param description
	 */
	void setDescription(@Nullable String description);

	/**
	 * Return a human-readable description of this bean definition.
	 */
	@Nullable
	String getDescription();


	// Read-only attributes

	/**
	 * get ResolvableType
	 * @return
	 */
	ResolvableType getResolvableType();

	/**
	 * 是否单例
	 * @return
	 */
	boolean isSingleton();

	/**
	 * Return whether this a <b>Prototype</b>, with an independent instance
	 * returned for each call.
	 * @since 3.0
	 * @see #SCOPE_PROTOTYPE
	 */
	boolean isPrototype();

	/**
	 * 是否abstract
	 */
	boolean isAbstract();

	/**
	 * Return a description of the resource that this bean definition
	 * came from (for the purpose of showing context in case of errors).
	 */
	@Nullable
	String getResourceDescription();

	/**
	 * Return the originating BeanDefinition, or {@code null} if none.
	 * <p>Allows for retrieving the decorated bean definition, if any.
	 * <p>Note that this method returns the immediate originator. Iterate through the
	 * originator chain to find the original BeanDefinition as defined by the user.
	 */
	@Nullable
	BeanDefinition getOriginatingBeanDefinition();

}
