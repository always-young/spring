/*
 * Copyright 2002-2017 the original author or authors.
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

import java.util.Iterator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.lang.Nullable;

//可配置可枚举可自动注入的的beanfactory
public interface ConfigurableListableBeanFactory
		extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

	//忽略指定类型的依赖注入
	void ignoreDependencyType(Class<?> type);

	//忽略指定的接口
	void ignoreDependencyInterface(Class<?> ifc);

	//指定类型的注入指定类型
	void registerResolvableDependency(Class<?> dependencyType, @Nullable Object autowiredValue);

	//当前bean在作为其他的依赖注入对象是否候选
	boolean isAutowireCandidate(String beanName, DependencyDescriptor descriptor)
			throws NoSuchBeanDefinitionException;

	//根据beanName获取beanDefinition
	BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;

	//清理元数据
	void clearMetadataCache();


	void freezeConfiguration();

	/**
	 * Return whether this factory's bean definitions are frozen,
	 * i.e. are not supposed to be modified or post-processed any further.
	 * @return {@code true} if the factory's configuration is considered frozen
	 */
	boolean isConfigurationFrozen();

	/**
	 * Ensure that all non-lazy-init singletons are instantiated, also considering
	 * {@link org.springframework.beans.factory.FactoryBean FactoryBeans}.
	 * Typically invoked at the end of factory setup, if desired.
	 * @throws BeansException if one of the singleton beans could not be created.
	 * Note: This may have left the factory with some beans already initialized!
	 * Call {@link #destroySingletons()} for full cleanup in this case.
	 * @see #destroySingletons()
	 */
	void preInstantiateSingletons() throws BeansException;

}
