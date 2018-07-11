package com.db.repository;

import static com.db.repository.BookInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.db.entities.BookInfo;
import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import javax.annotation.processing.Generated;

@Mapper
public interface BookInfoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.931777+08:00", comments="Source Table: book_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.932871+08:00", comments="Source Table: book_info")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.933429+08:00", comments="Source Table: book_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=BigInteger.class)
    int insert(InsertStatementProvider<BookInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.935149+08:00", comments="Source Table: book_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookInfoResult")
    BookInfo selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.93611+08:00", comments="Source Table: book_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookInfoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<BookInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.937619+08:00", comments="Source Table: book_info")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.938358+08:00", comments="Source Table: book_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(bookInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.93913+08:00", comments="Source Table: book_info")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.940043+08:00", comments="Source Table: book_info")
    default int deleteByPrimaryKey(BigInteger id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookInfo)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.941053+08:00", comments="Source Table: book_info")
    default int insert(BookInfo record) {
        return insert(SqlBuilder.insert(record)
                .into(bookInfo)
                .map(gmtCreate).toProperty("gmtCreate")
                .map(gmtModified).toProperty("gmtModified")
                .map(name).toProperty("name")
                .map(price).toProperty("price")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.942418+08:00", comments="Source Table: book_info")
    default int insertSelective(BookInfo record) {
        return insert(SqlBuilder.insert(record)
                .into(bookInfo)
                .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
                .map(gmtModified).toPropertyWhenPresent("gmtModified", record::getGmtModified)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(price).toPropertyWhenPresent("price", record::getPrice)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.94346+08:00", comments="Source Table: book_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookInfo>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, gmtCreate, gmtModified, name, price)
                .from(bookInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.944552+08:00", comments="Source Table: book_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookInfo>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, gmtCreate, gmtModified, name, price)
                .from(bookInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.945277+08:00", comments="Source Table: book_info")
    default BookInfo selectByPrimaryKey(BigInteger id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, gmtCreate, gmtModified, name, price)
                .from(bookInfo)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.945955+08:00", comments="Source Table: book_info")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookInfo record) {
        return UpdateDSL.updateWithMapper(this::update, bookInfo)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModified).equalTo(record::getGmtModified)
                .set(name).equalTo(record::getName)
                .set(price).equalTo(record::getPrice);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.947075+08:00", comments="Source Table: book_info")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookInfo record) {
        return UpdateDSL.updateWithMapper(this::update, bookInfo)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(record::getGmtModified)
                .set(name).equalToWhenPresent(record::getName)
                .set(price).equalToWhenPresent(record::getPrice);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.948081+08:00", comments="Source Table: book_info")
    default int updateByPrimaryKey(BookInfo record) {
        return UpdateDSL.updateWithMapper(this::update, bookInfo)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModified).equalTo(record::getGmtModified)
                .set(name).equalTo(record::getName)
                .set(price).equalTo(record::getPrice)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.949023+08:00", comments="Source Table: book_info")
    default int updateByPrimaryKeySelective(BookInfo record) {
        return UpdateDSL.updateWithMapper(this::update, bookInfo)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(record::getGmtModified)
                .set(name).equalToWhenPresent(record::getName)
                .set(price).equalToWhenPresent(record::getPrice)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}