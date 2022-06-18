/*
 * Copyright 2002-2021 the original author or authors.
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

package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

/**
 * 最抽象的bean factory
 * @author Kevin Liu
 */
@SuppressWarnings("all")
public interface BeanFactory {

	/**
	 * factoryBean beanName前缀
	 */
	String FACTORY_BEAN_PREFIX = "&";


	//根据bean name 获取bean
	Object getBean(String name) throws BeansException;

	//根据beanName和类的类型获取bean
	<T> T getBean(String name, Class<T> requiredType) throws BeansException;

	Object getBean(String name, Object... args) throws BeansException;

	//根据类型获取bean
	<T> T getBean(Class<T> requiredType) throws BeansException;


	<T> T getBean(Class<T> requiredType, Object... args) throws BeansException;


	<T> ObjectProvider<T> getBeanProvider(Class<T> requiredType);


	<T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType);

	//是否存在该bean name
	boolean containsBean(String name);

	//是否单例Bean
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

	//类型匹配
	boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;


	boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException;


	@Nullable
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;


	@Nullable
	Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException;

	//获取别名
	String[] getAliases(String name);

}
