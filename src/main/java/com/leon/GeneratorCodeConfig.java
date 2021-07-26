package com.leon;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Scanner;

/**
 * mybatis-plus 代码生成
 * https://blog.csdn.net/zyy_2018/article/details/118177638
 */
public class GeneratorCodeConfig {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help);
        if (scanner.hasNext()) {
            String ipt = scanner.nextLine();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        DataSourceConfig dsc = new DataSourceConfig
                .Builder("jdbc:mysql://localhost:3306/leon?useUnicode=true&characterEncoding=UTF-8", "root", "root")
                .build();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dsc);

        String moduleName = scanner("请输入模块名");
        String projectPath = System.getProperty("user.dir");

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig
                .Builder()
                .outputDir(projectPath + "/" + moduleName + "/src/main/java")
                .author("OceanLeonAI")
                .openDir(false)
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig
                .Builder()
                .parent("com.leon")
                .moduleName(moduleName)
                .build();

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig
                .Builder()
                .mapperXml(null)
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig
                .Builder()
//                .addInclude(scanner("表名，多个英文逗号分割").split(","))
                .addInclude(scanner("表名，多个英文逗号分割").split(","))
                .entityBuilder().naming(NamingStrategy.underline_to_camel)
                .build();

        mpg.global(globalConfig);
        mpg.packageInfo(packageConfig);
        mpg.template(templateConfig);
        mpg.strategy(strategyConfig);
        mpg.execute(new FreemarkerTemplateEngine());
    }
}