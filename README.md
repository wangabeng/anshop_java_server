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