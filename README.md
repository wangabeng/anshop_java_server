# 1 ���÷������������������������ ������tomcat�˺�servlet���������ñ��뷽ʽ
1 servelt������

```
request.setCharacterEncoding("UTF-8"); // ���post���� ��ö�����
response.setHeader("Content-Type", "text/html;charset=UTF-8");
```

# 2 Java ��� servlet ���� ���ղ���������������
����1 ���յ��Ĳ����������²����������顿  
```
String formUserName = request.getParameter("userName");
formUserName = new String(formUserName.getBytes("iso8859-1"),"utf-8");
```

����2 tomcat �����ļ�����URIEncoding="utf-8"  

```
<Connector connectionTimeout="20000" port="8087" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
```
��server.xml���޸� tomcat��װĿ¼��ecliose server�е�server.xml ��Ҫ�޸�  

```
   <Connector port="3000" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" URIEncoding="UTF-8" />
```

# ���ÿ��Կ������
```
response.setHeader("Access-Control-Allow-Origin", "*");  // ��������
```

# ���޷����ṹ���ʾ��ͼ  
��һ��  
![avatar](/img/���޷����ṹ.jpg)  
�Ż���1  
![avatar](/img/���޷����ṹ-�Ż�.jpg)  
�Ż���3 ������ϵ��  
![avatar](/img/���޷����ṹ-�Ż�2.jpg)

# Ϊʲô���� new Date()����ʾ����  
��ʵ���������ʱ������õ�ʱ�䣬���õ�jar��������import java.util.Date;��������import java.sql.Date;����öγ������溬������ʱ�䣬�ֱ�Ϊimport java.util.Date��import java.sql.Date;����д��ʱ���Ҫ������д����

# һ������ʹ������
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
