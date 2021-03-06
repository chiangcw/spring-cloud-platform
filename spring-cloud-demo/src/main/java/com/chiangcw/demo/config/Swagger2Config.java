package com.chiangcw.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Title: Swagger设置类
 * @Package com.lovnx.charge 
 * @author yezhiyuan   
 * @date 2017年5月10日 上午9:45:55 
 * @version V1.0
 
swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。

@Api：修饰整个类，描述Controller的作用
@ApiOperation：描述一个类的一个方法，或者说一个接口
@ApiParam：单个参数描述
@ApiModel：用对象来接收参数
@ApiProperty：用对象接收参数时，描述对象的一个字段
@ApiResponse：HTTP响应其中1个描述
@ApiResponses：HTTP响应整体描述
@ApiIgnore：使用该注解忽略这个API
@ApiError ：发生错误返回的信息
@ApiImplicitParam：一个请求参数
@ApiImplicitParams：多个请求参数
*/
@Configuration  
@ComponentScan(basePackages = { "org.sample.admin.controller.*" })//配置controller路径
@EnableSwagger2
@SuppressWarnings({"unchecked","deprecation"})
public class Swagger2Config {  

    @Bean  
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.sample.admin.controller"))
                .paths(PathSelectors.any()
                        
//                        Predicates.or(
//                //这里添加你需要展示的接口
//                        PathSelectors.ant("/account/**"),
//                        PathSelectors.ant("/xxx/**"),
//                        PathSelectors.ant("/qqq/**"),
//                        PathSelectors.ant("/eee/**")
                                    )
                        
                .build();  
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()  
                .title("API平台名字")
                .description("说明RESTful APIs")
                .contact("xxx@qq.com") 
                .version("1.0")
                .build();  
    }
}  