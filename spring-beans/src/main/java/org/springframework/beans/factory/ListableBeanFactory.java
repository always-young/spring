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

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

public interface ListableBeanFactory extends BeanFactory {

	//是否包含次beanName的beanDefinition
	boolean containsBeanDefinition(String beanName);

	//获取beanBefinition数量
	int getBeanDefinitionCount();

	//获取所有bean name
	String[] getBeanDefinitionNames();


	<T> ObjectProvider<T> getBeanProvider(Class<T> requiredType, boolean allowEagerInit);

	<T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType, boolean allowEagerInit);


	//获取这个类型的有多少beanName
	String[] getBeanNamesForType(ResolvableType type);

	String[] getBeanNamesForType(ResolvableType type, boolean includeNonSingletons, boolean allowEagerInit);

	String[] getBeanNamesForType(@Nullable Class<?> type);


	String[] getBeanNamesForType(@Nullable Class<?> type, boolean includeNonSingletons, boolean allowEagerInit);


	//获取beanName bean的map
	<T> Map<String, T> getBeansOfType(@Nullable Class<T> type) throws BeansException;

	<T> Map<String, T> getBeansOfType(@Nullable Class<T> type, boolean includeNonSingletons, boolean allowEagerInit)
			throws BeansException;


	String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType);


	Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException;

	//查找bean上的指定注解 也可能从父类上找
	@Nullable
	<A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType)
			throws NoSuchBeanDefinitionException;

	@Nullable
	<A extends Annotation> A findAnnotationOnBean(
			String beanName, Class<A> annotationType, boolean allowFactoryBeanInit)
			throws NoSuchBeanDefinitionException;

}
