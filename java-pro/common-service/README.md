# common-service 通用服务
## 集成swagger3

springfox已停止维护，高版本的spirngboot（如v2.6以上）会出现许多bug，spring官方推荐使用springdoc实现springboot集成swagger3

使用springdoc-openapi提供的工具实现  
步骤：  
1、引入springdoc依赖  
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>
```

2、编写配置类，注入`OpenAPI`对象，配置文档基本信息  
```java
@Bean
public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("SpringShop API")
        .description("Spring shop sample application")
        .version("v0.0.1")
        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .externalDocs(new ExternalDocumentation()
        .description("SpringShop Wiki Documentation")
        .url("https://springshop.wiki.github.org/docs"));
}
```

3、在application.yml文件中配置springdoc信息  
```yaml
# springdoc
springdoc:
  swagger-ui:
    # 修改Swagger UI路径
    path: /swagger-ui.html
    # 开启Swagger UI界面
    enabled: true
  api-docs:
    # 修改api-docs路径
    path: /v3/api-docs
    # 开启api-docs
    enabled: true
  # 配置需要生成接口文档的扫描包
  packages-to-scan: com.abot.common.controller
```

### swagger2与swagger3注解
用 swagger 3 注释替换 swagger 2 注释（它已经包含在springdoc-openapi-ui依赖项中）。swagger 3 注释的包是io.swagger.v3.oas.annotations.  

swagger2->swagger3  
@Api→@Tag

@ApiIgnore→@Parameter(hidden = true)或@Operation(hidden = true)或@Hidden

@ApiImplicitParam→@Parameter

@ApiImplicitParams→@Parameters

@ApiModel→@Schema

@ApiModelProperty(hidden = true)→@Schema(accessMode = READ_ONLY)

@ApiModelProperty→@Schema

@ApiOperation(value = "foo", notes = "bar")→@Operation(summary = "foo", description = "bar")

@ApiParam→@Parameter

@ApiResponse(code = 404, message = "foo")→@ApiResponse(responseCode = "404", description = "foo")

如果您使用一个对象来捕获多个请求查询参数，请注释该方法参数@ParameterObject

此步骤是可选的：仅当您有多个 Docketbeans 时才用GroupedOpenApibeans 替换它们。