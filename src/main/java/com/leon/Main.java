package com.leon;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Arrays;

/**
 * 旧版本 mybatis plus 代码生成案例，
 * 以下代码生成数据库中所有表对应代码
 */
public class Main {
    public static void main(String[] args) {
        generateCode();
//        getSystemProperty(null);

    }

    private static void generateCode() {

        // 创建数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder(
                "jdbc:mysql://localhost:3306/leon?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "root")
                .build();

        // 创建 generate 对象
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .outputDir(System.getProperty("user.dir") + "\\" + "src\\main\\java")
//                .outputDir("E://mybatis-plus-code-generator/")
                .openDir(false)
                .author("OceanLeonAI")
                .build();
        autoGenerator.global(globalConfig);

        // 包信息
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.leon")
                .moduleName("generator")
                .controller("controller")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("Mapper")
                .entity("entity")
                .build();
        autoGenerator.packageInfo(packageConfig);

        // 策略信息
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .entityBuilder()
                .enableLombok()
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .build();
        autoGenerator.strategy(strategyConfig);

        // 执行代码生成
        autoGenerator.execute();
    }

    public static void getSystemProperty(String[] args) {
        if (null != args && args.length > 0) {
            Arrays.stream(args).forEach(arg -> {
                System.out.println(System.getProperty("user." + arg));
            });
        } else {
            System.out.println(System.getProperty("user.dir"));
        }
    }
}
