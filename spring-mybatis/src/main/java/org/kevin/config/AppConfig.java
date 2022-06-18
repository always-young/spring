package org.kevin.config;

import lombok.val;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Kevin Liu
 * @date 2020/6/12 4:42 下午
 */
@Configuration
@MapperScan(value = "org.kevin.dao")
@PropertySource("classpath:jdbc.properties")
@ComponentScan("org.kevin")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AppConfig {

  @Value("${driverClass}")
  private String driver;

  @Value("${connectUrl}")
  private String url;

  @Value("${username}")
  private String username;

  @Value("${password}")
  private String password;

  @Bean
  public DataSource dataSource() {
    val dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Bean
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
    val sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("org.kevin.entity");
    val propertiesLoaderSupport = new PathMatchingResourcePatternResolver();
    sqlSessionFactoryBean.setMapperLocations(propertiesLoaderSupport.getResources("classpath:mapper/*Mapper.xml"));
    return sqlSessionFactoryBean;
  }
}
