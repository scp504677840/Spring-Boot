package com.slab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 注解@ConfigurationProperties
 * 1.批量注入。
 * 2.支持数据校验。
 *
 * 注解@Value
 * 1.单个属性注入。
 * 2.从Spring配置文件中取值。
 * 3.从字面量中取值。
 * 4.支持SpEL表达式。
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    //@Value("${person.name}")
    private String name;

    //@Value("#{10-2}")
    private Integer age;

    //@Value("false")
    private Boolean boss;

    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Address address;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", address=" + address +
                '}';
    }
}
