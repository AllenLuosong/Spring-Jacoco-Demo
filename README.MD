# 基于Spring Boot框架演示Jacoco功能的demo
## 使用
1. 启动demo服务
~~~
java -javaagent:jacocoagent.jar=includes=*,output=tcpserver,port=8080,address=127.0.0.1 -jar target/demo-0.0.1-SNAPSHOT.jar
~~~
  注:上述命令 javaagent:jacocoagent.jar 表示启用jacoco代理， includes=* 表示启动时需要进行字节码插桩的包过滤，*代表所有的class文件加载都需要进行插桩。
  output=tcpserver表示以tcp的形式插桩。port=8080是jacoco开启的tcpserver的端口。address=127.0.0.1 对外开发的tcpserver的访问地址，配置为127.0.0.1的时候，dump数据只能在这台服务器上进行dump。配置为实际的ip地址的时候，就可以在任意一台机器上dump数据。target/demo-0.0.1-SNAPSHOT.jar表示运行target目录下需要测试覆盖率的jar包。

运行截图：
![Image](pic/1.png?raw=true "1.png")

2. 获取覆盖数据，生成 javaexc文件
~~~
java -jar jacococli.jar dump --address 127.0.0.1 --port 8080 --destfile ./jacoco.exec --reset
~~~

3. 生成jacoco覆盖率测试报告
~~~
Java -jar jacococli.jar report ./jacoco.exec --classfiles target/classes --sourcefiles src/main/java --encoding utf-8 --html jacoReport
~~~
执行成功后会在根目录下新增一个jacoReport的目录，里面有测试报告，如下图

![Image](pic/2.png?raw=true "2.png")

![Image](pic/3.pngr?aw=false "3.png")
