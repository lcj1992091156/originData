package com.yuchen.data.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 描述:DataSource1Config
 * @author: myx
 * @date: 2019/5/31
 * Copyright © 2019-grape. All rights reserved.
 */
@Configuration
@MapperScan(basePackages = "com.yuchen.data.mapper.mysql", sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSource1Config {

//    @Bean(name = "test1DataSource")
//    public DataSource testDataSource(DataSourcePrimary testConfig) throws SQLException {
//        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
//        mysqlXaDataSource.setUrl(testConfig.getUrl());
//        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
//        mysqlXaDataSource.setPassword(testConfig.getPassword());
//        mysqlXaDataSource.setUser(testConfig.getUsername());
//        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
//        // 将本地事务注册到创 Atomikos全局事务
//
//        com.atomikos.jdbc.AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
//        xaDataSource.setXaDataSource(mysqlXaDataSource);
//        xaDataSource.setUniqueResourceName("test1DataSource");
//        xaDataSource.setMinPoolSize(testConfig.getMinPoolSize());
//        xaDataSource.setMaxPoolSize(testConfig.getMaxPoolSize());
//        xaDataSource.setMaxLifetime(testConfig.getMaxLifetime());
//        xaDataSource.setBorrowConnectionTimeout(testConfig.getBorrowConnectionTimeout());
//        xaDataSource.setLoginTimeout(testConfig.getLoginTimeout());
//        xaDataSource.setMaintenanceInterval(testConfig.getMaintenanceInterval());
//        xaDataSource.setMaxIdleTime(testConfig.getMaxIdleTime());
//        xaDataSource.setTestQuery(testConfig.getTestQuery());
//        return xaDataSource;
//    }

    // 配置数据源
    @Bean(name = "test1DataSource")
    public DataSource testDataSource(DataSourcePrimary testConfig) throws SQLException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(testConfig.getUrl());
        hikariConfig.setUsername(testConfig.getUsername());
        hikariConfig.setPassword(testConfig.getPassword());
//        hikariConfig.setDriverClassName("org.neo4j.jdbc.bolt.BoltDriver");
//        hikariConfig.setDriverClassName("org.neo4j.jdbc.http.HttpDriver");
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }


    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/mysql/*.xml"));
        return bean.getObject();
    }



    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager1")
    public DataSourceTransactionManager transactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }



}
