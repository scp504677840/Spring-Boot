package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mybatis generator
 * 步骤：
 * 1.书写mbg.xml
 * 2.书写DbApplicationTests
 * try {
 *      List<String> warnings = new ArrayList<>();
 *      boolean overwrite = true;
 *      File configFile = new File("mbg.xml");
 *      ConfigurationParser cp = new ConfigurationParser(warnings);
 *      Configuration config = cp.parseConfiguration(configFile);
 *      DefaultShellCallback callback = new DefaultShellCallback(overwrite);
 *      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
 *      myBatisGenerator.generate(null);
 * } catch (IOException | SQLException | InterruptedException | XMLParserException | InvalidConfigurationException e) {
 * e.printStackTrace();
 * }
 * 3.运行测试方法
 */
@SpringBootApplication
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }
}
