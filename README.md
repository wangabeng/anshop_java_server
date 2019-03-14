# 1 设置发送来的中文数据乱码的问题 必须在tomcat端和servlet代码内设置编码方式
1 servelt端设置

```
request.setCharacterEncoding("UTF-8"); // 解决post乱码 最好都加上
response.setHeader("Content-Type", "text/html;charset=UTF-8");
```

# 2 Java 解决 servlet 请求 接收参数中文乱码问题
方法1 接收到的参数进行如下操作【不建议】  
```
String formUserName = request.getParameter("userName");
formUserName = new String(formUserName.getBytes("iso8859-1"),"utf-8");
```

方法2 tomcat 配置文件设置URIEncoding="utf-8"  

```
<Connector connectionTimeout="20000" port="8087" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
```
在server.xml中修改 tomcat安装目录及ecliose server中的server.xml 都要修改  

```
   <Connector port="3000" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" URIEncoding="UTF-8" />
```

# 设置可以跨域访问
```
response.setHeader("Access-Control-Allow-Origin", "*");  // 跨域请求
```

# 无限分类表结构设计示意图  
第一版  
![avatar](/img/无限分类表结构.jpg)  
优化版1  
![avatar](/img/无限分类表结构-优化.jpg)  
优化版3 建立关系表  
![avatar](/img/无限分类表结构-优化2.jpg)

