# ����dopost�õ����ݵı��뷽ʽ
```
request.setCharacterEncoding(��UTF-8��)��// �õ��������������ó�uft-8�ķ�ʽ �������(ò����Ч)
```

# Java ��� servlet ���get���� ���ղ���������������
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

# ���޷����ṹ���ʾ��ͼ  
��һ��  
![avatar](/img/���޷����ṹ.jpg)  
�Ż���1  
![avatar](/img/���޷����ṹ-�Ż�.jpg)  
�Ż���3 ������ϵ��  
![avatar](/img/���޷����ṹ-�Ż�2.jpg)

