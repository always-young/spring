/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.lang.Nullable;

//可以自动注入的beanfactory
public interface AutowireCapableBeanFactory extends BeanFactory {

	//不自动注入
	int AUTOWIRE_NO = 0;

	//通过bean name自动注入
	int AUTOWIRE_BY_NAME = 1;

	//通过类型自动注入
	int AUTOWIRE_BY_TYPE = 2;

	//通过构造函数自动注入
	int AUTOWIRE_CONSTRUCTOR = 3;

	//自动选择
	@Deprecated
	int AUTOWIRE_AUTODETECT = 4;

	String ORIGINAL_INSTANCE_SUFFIX = ".ORIGINAL";


	//-------------------------------------------------------------------------
	// Typical methods for creating and populating external bean instances
	//-------------------------------------------------------------------------

	//创造一个bean
	<T> T createBean(Class<T> beanClass) throws BeansException;

	//自动注入一个bean
	void autowireBean(Object existingBean) throws BeansException;

	//配置一个bean
	Object configureBean(Object existingBean, String beanName) throws BeansException;


	//-------------------------------------------------------------------------
	// Specialized methods for fine-grained control over the bean lifecycle
	//-------------------------------------------------------------------------

	Object createBean(Class<?> beanClass, int autowireMode, boolean dependencyCheck) throws BeansException;

	//自动注入
	Object autowire(Class<?> beanClass, int autowireMode, boolean dependencyCheck) throws BeansException;

	//自动注入属性
	void autowireBeanProperties(Object existingBean, int autowireMode, boolean dependencyCheck)
			throws BeansException;


	void applyBeanPropertyValues(Object existingBean, String beanName) throws BeansException;

	//初始化一个bean
	Object initializeBean(Object existingBean, String beanName) throws BeansException;

	//运行前置构造器
	Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
			throws BeansException;

	//运行后置构造器
	Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
			throws BeansException;

	//摧毁一个bean
	void destroyBean(Object existingBean);


	//-------------------------------------------------------------------------
	// Delegate methods for resolving injection points
	//-------------------------------------------------------------------------

	//获取一个bean和bean name的holder
	<T> NamedBeanHolder<T> resolveNamedBean(Class<T> requiredType) throws BeansException;

	/**
	 * Resolve a bean instance for the given bean name, providing a dependency descriptor
	 * for exposure to target factory methods.
	 * <p>This is effectively a variant of {@link #getBean(String, Class)} which supports
	 * factory methods with an {@link org.springframework.beans.factory.InjectionPoint}
	 * argument.
	 * @param name the name of the bean to look up
	 * @param descriptor the dependency descriptor for the requesting injection point
	 * @return the corresponding bean instance
	 * @throws NoSuchBeanDefinitionException if there is no bean with the specified name
	 * @throws BeansException if the bean could not be created
	 * @since 5.1.5
	 * @see #getBean(String, Class)
	 */
	Object resolveBeanByName(String name, DependencyDescriptor descriptor) throws BeansException;

	//解决依赖
	@Nullable
	Object resolveDependency(DependencyDescriptor descriptor, @Nullable String requestingBeanName) throws BeansException;

	//解决依赖
	@Nullable
	Object resolveDependency(DependencyDescriptor descriptor, @Nullable String requestingBeanName,
			@Nullable Set<String> autowiredBeanNames, @Nullable TypeConverter typeConverter) throws BeansException;

}
