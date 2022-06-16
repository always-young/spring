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

package org.springframework.transaction;

import org.springframework.lang.Nullable;

/**
 * 事务定义接口
 */
public interface TransactionDefinition {

	/**
	 * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	 */
	int PROPAGATION_REQUIRED = 0;

	/**
	 * 支持当前事务，如果当前没有事务，就以非事务方式执行。
	 */
	int PROPAGATION_SUPPORTS = 1;

	/**
	 * 使用当前的事务，如果当前没有事务，就抛出异常。
	 */
	int PROPAGATION_MANDATORY = 2;

	/**
	 * 新建事务，如果当前存在事务，把当前事务挂起。
	 */
	int PROPAGATION_REQUIRES_NEW = 3;

	/**
	 * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
	 */
	int PROPAGATION_NOT_SUPPORTED = 4;

	/**
	 * 以非事务方式执行，如果当前存在事务，则抛出异常。
	 */
	int PROPAGATION_NEVER = 5;

	/**
	 * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
	 * 必须jdbc3.0 并且实现者需要支持保存点事务机制
	 */
	int PROPAGATION_NESTED = 6;


	/**
	 * 使用后端数据库默认的隔离级别
	 */
	int ISOLATION_DEFAULT = -1;

	/**
	 *  读未提交
	 */
	int ISOLATION_READ_UNCOMMITTED = 1;  // same as java.sql.Connection.TRANSACTION_READ_UNCOMMITTED;

	/**
	 * 读已提交
	 */
	int ISOLATION_READ_COMMITTED = 2;  // same as java.sql.Connection.TRANSACTION_READ_COMMITTED;

	/**
	 * 可重复读
	 */
	int ISOLATION_REPEATABLE_READ = 4;  // same as java.sql.Connection.TRANSACTION_REPEATABLE_READ;

	/**
	 * 串行化
	 */
	int ISOLATION_SERIALIZABLE = 8;  // same as java.sql.Connection.TRANSACTION_SERIALIZABLE;


	/**
	 * Use the default timeout of the underlying transaction system,
	 * or none if timeouts are not supported.
	 */
	int TIMEOUT_DEFAULT = -1;


	/**
	 * 事务传播级别 默认PROPAGATION_REQUIRED
	 * @return
	 */
	default int getPropagationBehavior() {
		return PROPAGATION_REQUIRED;
	}

	/**
	 * 获取事务隔离级别 默认使用数据库自带
	 * @return
	 */
	default int getIsolationLevel() {
		return ISOLATION_DEFAULT;
	}

	/**
	 * 获取事务超时时间 默认-1
	 * @return
	 */
	default int getTimeout() {
		return TIMEOUT_DEFAULT;
	}

	/**
	 * 判断是否只读事务
	 * @return
	 */
	default boolean isReadOnly() {
		return false;
	}

	/**
	 * 获取事务名
	 * @return
	 */
	@Nullable
	default String getName() {
		return null;
	}


	// Static builder methods

	/**
	 * 获取默认TransactionDefinition
	 * @return
	 */
	static TransactionDefinition withDefaults() {
		return StaticTransactionDefinition.INSTANCE;
	}

}
