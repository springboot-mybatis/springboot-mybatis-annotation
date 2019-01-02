# springboot-mybatis-annotation
springboot-mybatis-annotation

# 打包
mvn install

# 运行
java -jar springboot-mybatis-annotation-0.0.1-SNAPSHOT.jar


# 更新 2018-01-02 添加多环境配置文件、添加log4j2
多环境配置:
默认application-dev.properties,可通过application.properties中spring.profiles.active=dev修改，还可以通过jvm参数修改 如：java -jar springboot-mybatis-annotation-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --server.port=9999
日志配置:
通过properties文件指定具体日志配置文件. 如:logging.config=classpath:log4j2-dev.json
配置日志文件前缀、配置输出格式、配置日志输出位置




