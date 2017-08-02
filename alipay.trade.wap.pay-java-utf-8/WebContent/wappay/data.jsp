<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.alipay.config.AlipayConfig" %>
<%@ page import="com.alipay.config.TestAliPay"%>

<% 
String body = TestAliPay.getData();
response.setContentType("application/json;charset=" + AlipayConfig.CHARSET); 
response.getWriter().write(body);//直接将完整的表单html输出到页面 
response.getWriter().flush(); 
response.getWriter().close();
%>