package com.db;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * 与spring整合之后，该配置文件中只需要必要配置，其余的交给spring
 * <settings>
 * 开启全局二级缓存
 * <setting name="cacheEnabled" value="true"/>
 * SESSION：默认值，启用一级缓存。STATEMENT：禁用一级缓存。
 * //<setting name="localCacheScope" value="SESSION"/>
 * 设置驱动程序等待数据库响应的秒数
 * <setting name="defaultStatementTimeout" value="30"/>
 * 启用从经典数据库列名A_COLUMN到驼峰式经典Java属性名称aColumn的自动映射
 * <setting name="mapUnderscoreToCamelCase" value="true"/>
 * 允许JDBC支持生成的主键。 需要兼容的驱动程序。如果设置为true，此设置会强制使用生成的键
 * <setting name="useGeneratedKeys" value="true"/>
 * 当没有为参数提供特定的 JDBC 类型时，为空值指定 JDBC 类型。
 * <setting name="jdbcTypeForNull" value="NULL"/>
 * DeBug
 * <setting name="logImpl" value="STDOUT_LOGGING"/>
 * 延迟加载
 * //<setting name="lazyLoadingEnabled" value="true"/>
 * 当开启时，任何方法的调用都会加载该对象的所有属性。否则，每个属性会按需加载
 * //<setting name="aggressiveLazyLoading" value="false"/>
 * </settings>
 * <p>
 * 说明：
 * ConfigurationCustomizer是mybatis的扩展配置接口。
 * 实现mybatis的扩展配置有两种方式：
 * 1.实现ConfigurationCustomizer接口。
 * 2.注解@Bean，提供ConfigurationCustomizer接口的实现。
 * <p>
 * 注意：如果有配置文件，则将下面customize方法里面的配置信息配置在xxx.xml配置文件中，方法中无需配置。
 */
@Configuration
@MapperScan(value = {"com.db.mapper", "com.db.repository"})
public class MybatisConfig implements ConfigurationCustomizer {

    /**
     * mybatis扩展配置
     * <p>
     * 注意：如果有配置文件，则将下面customize方法里面的配置信息配置在xxx.xml配置文件中，方法中无需配置。
     *
     * @param configuration
     */
    @Override
    public void customize(org.apache.ibatis.session.Configuration configuration) {
        /*//开启全局二级缓存
        configuration.setCacheEnabled(true);

        //SESSION：默认值，启用一级缓存。STATEMENT：禁用一级缓存。
        //configuration.setLocalCacheScope(LocalCacheScope.SESSION);

        //设置驱动程序等待数据库响应的秒数
        configuration.setDefaultStatementTimeout(30);

        //启用从经典数据库列名A_COLUMN到驼峰式经典Java属性名称aColumn的自动映射
        configuration.setMapUnderscoreToCamelCase(true);

        //允许JDBC支持生成的主键。 需要兼容的驱动程序。如果设置为true，此设置会强制使用生成的键
        configuration.setUseGeneratedKeys(true);

        //当没有为参数提供特定的 JDBC 类型时，为空值指定 JDBC 类型。
        configuration.setJdbcTypeForNull(JdbcType.NULL);

        //DeBug
        configuration.setLogImpl(StdOutImpl.class);

        //延迟加载
        //configuration.setLazyLoadingEnabled(true);

        //当开启时，任何方法的调用都会加载该对象的所有属性。否则，每个属性会按需加载
        //configuration.setAggressiveLazyLoading(false);*/
    }
}
