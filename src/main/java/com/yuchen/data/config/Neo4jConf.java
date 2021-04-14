package com.yuchen.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.yuchen.data.mapper.neo4j", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class Neo4jConf {

    // 配置数据源
    @Bean(name = "test2DataSource")
    public DataSource testDataSource(DataSourceSecond testConfig) throws SQLException {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(testConfig.getUrl());
//        hikariConfig.setUsername(testConfig.getUsername());
//        hikariConfig.setPassword(testConfig.getPassword());
//        hikariConfig.setDriverClassName("org.neo4j.jdbc.bolt.BoltDriver");
//        hikariConfig.setDriverClassName("org.neo4j.jdbc.http.HttpDriver");
//        HikariDataSource dataSource = new HikariDataSource(hikariConfig);


        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDbType(testConfig.getDbType());
        druidDataSource.setDriverClassName(testConfig.getDriverClassName());
        druidDataSource.setUrl(testConfig.getUrl());
        druidDataSource.setUsername(testConfig.getUsername());
        druidDataSource.setPassword(testConfig.getPassword());


        return druidDataSource;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/neo4j/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
