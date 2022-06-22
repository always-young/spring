/*
 * Copyright 2002-2020 the original author or authors.
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

package org.springframework.core;

//别名注册
public interface AliasRegistry {

	//注册别名
	void registerAlias(String name, String alias);

	//移出别名
	void removeAlias(String alias);

	//是否包含别名
	boolean isAlias(String name);

	//获取所有别名
	String[] getAliases(String name);

}
