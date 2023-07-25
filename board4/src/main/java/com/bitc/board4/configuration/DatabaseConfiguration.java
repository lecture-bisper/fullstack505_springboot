package com.bitc.board4.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@RequiredArgsConstructor
@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

  private final ApplicationContext appCtx;

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() throws Exception {
    DataSource ds = new HikariDataSource(hikariConfig());
    System.out.println(ds.toString());
    return ds;

  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
    SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
    ssfb.setDataSource(ds);
    ssfb.setMapperLocations(appCtx.getResources("classpath:/sql/sql-*.xml"));
    ssfb.setConfiguration(mybatisConfig());

    return ssfb.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory ssf) throws Exception {
    return new SqlSessionTemplate(ssf);
  }

  @Bean
  @ConfigurationProperties(prefix = "mybatis.configuration")
  public org.apache.ibatis.session.Configuration mybatisConfig() {
    return new org.apache.ibatis.session.Configuration();
  }

//  jpa 사용 설정 추가
  @Bean
  @ConfigurationProperties(prefix = "spring.jpa")
  public Properties hibernateConfig() {
    return new Properties();
  }
}












