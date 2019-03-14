# 设置dopost得到数据的编码方式
```
request.setCharacterEncoding(“UTF-8”)；// 得到的中文数据设置成uft-8的方式 解决乱码(貌似无效)
```

# Java 解决 servlet 针对get请求 接收参数中文乱码问题
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

# 无限分类表结构设计示意图  
第一版  
![avatar](/img/无限分类表结构.jpg)  
优化版1  
![avatar](/img/无限分类表结构-优化.jpg)  
优化版3 建立关系表  
![avatar](/img/无限分类表结构-优化2.jpg)

