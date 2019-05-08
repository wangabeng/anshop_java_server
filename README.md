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

# 为什么输入 new Date()会提示错误  
在实例化对象的时候，如果用到时间，引用的jar包必须是import java.util.Date;而不能是import java.sql.Date;如果该段程序里面含有两个时间，分别为import java.util.Date和import java.sql.Date;那在写的时候就要把类型写完整

# 解析泛型最好的最深的  
https://www.cnblogs.com/coprince/p/8603492.html

# 一个泛型使用例子
```
import java.util.ArrayList;
import java.util.Date;

public class Haha {

	public static void main(String[] args) {
		/*
		 * ArrayList<Date> dates = new ArrayList<>(); dates.add(new Date());
		 * System.out.println(dates);
		 */
		
		//
		GenericStack<String> stringStack = new GenericStack<>();
		stringStack.push("122");
		stringStack.push("333");
		System.out.println(stringStack.get(0));

	}
}

class GenericStack<E> {
	private ArrayList<E> lists = new ArrayList<>();
	public int getSize () {
		return lists.size();
	}
	public void push (E o) {
		lists.add(o);
	}
	public E get (int index) {
		return lists.get(index);
	}
}
```

# 泛型方法例子
静态泛型方法 传递的参数类型不同 前缀也不同   方法定义public static <E> void print (E[] lists)  方法使用FanxingMethod.<Integer>print(integers);

```
package test.haha;

public class FanxingMethod {
	public static void main(String[] args) {
		Integer[] integers = {1,3, 4};
		String[] strings = {"1222","ben"};
		FanxingMethod.<Integer>print(integers);
		FanxingMethod.<String>print(strings);
	}
	public static <E> void print (E[] lists) {
		System.out.print(lists[1]);
	}
}
```

# 打开所在的文件夹 
在文件或项目上- 右键  show in - system explorer

# 秒懂java注解
https://blog.csdn.net/briblue/article/details/73824058

# 秒懂spring
http://www.cnblogs.com/wmyskxz/p/8820371.html

# java -cp
-cp 和 -classpath 一样，是指定类运行所依赖其他类的路径，通常是类库，jar包之类，需要全路径到jar包，window上分号“;”  

# maven快速上手
https://www.oracle.com/technetwork/cn/community/java/apache-maven-getting-started-1-406235-zhs.html

# 配置maven仓库地址 并在eclipse创建maven项目  
https://www.cnblogs.com/yaowen/p/8594876.html

# maven编译web项目显示“软件包 javax.servlet.http 不存在"
https://blog.csdn.net/tomcat_2014/article/details/50292411
maven项目编译报错：
```
软件包 javax.servlet 不存在
import javax.servlet.*;
```
明明tomcat下面的lib自带有这些包，却依然加载失败,

解决方法一：  

在pom.xml里面重新引入这个包
```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
    <scope>provided</scope>
</dependency>

```
但是这个方法容易会跟tomcat里面的包冲突，会报这个错误：
```
jar not loaded. See Servlet Spec 2.3, section 9.7.2. Offending class: javax/servlet/Servlet.class  
```
解决方法二：  
右键，buildPath，自己手动从tomcat目录下的lib包里添加外部jar包。  

# eclipse创建Maven项目没有src/main/java并不能新建的问题  
https://blog.csdn.net/lei133691/article/details/81103318  
eclipse里第一次创建Maven项目时，src/main/java与src/test/java目录都不会出现，这是因为eclipse里的一个默认配置。这两个目录是真实存在的，只是隐藏了。

这时候想要让这两个目录出现，就需要修改以下配置：右击项目-properties-Java Build Path-更改JRE System Library。这里默认的是Execution environment,修改成本地的jdk根目录（jdk/bin的上级目录）

# join()介绍
join() 定义在Thread.java中。
join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。这句话可能有点晦涩，我们还是通过例子去理解：
```
// 主线程
public class Father extends Thread {
    public void run() {
        Son s = new Son();
        s.start();
        s.join();
        ...
    }
}
// 子线程
public class Son extends Thread {
    public void run() {
        ...
    }
}
```  
说明：
上面的有两个类Father(主线程类)和Son(子线程类)。因为Son是在Father中创建并启动的，所以，Father是主线程类，Son是子线程类。
在Father主线程中，通过new Son()新建“子线程s”。接着通过s.start()启动“子线程s”，并且调用s.join()。在调用s.join()之后，Father主线程会一直等待，直到“子线程s”运行完毕；在“子线程s”运行完毕之后，Father主线程才能接着运行。 这也就是我们所说的“join()的作用，是让主线程会等待子线程结束之后才能继续运行”！