package com.roobo.demo.jms;

/**
  java通过ActiveMQ实现JMS的消息队列实例 
 下载安装http://apache.fayea.com/activemq/ 
 启动命令：bin\win64\activemq.bat 
 http://www.cnblogs.com/phoebus0501/archive/2011/02/24/1964228.html 
 */  
public class MyActiveMQDemo {
  
    public static void main(String[] args) {  
        String url = "tcp://localhost:61616";  
        String user = "xxx";  
        String password = "xxx";  
        String query = "MyQueue";  
        new Thread(new MessageReceiver(query,url,user,password), "Name-Receiver").start();  
        new Thread(new MessageSender(query,url,user,password), "Name-Sender").start();  
    }  
}  