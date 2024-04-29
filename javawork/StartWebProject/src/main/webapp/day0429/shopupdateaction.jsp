<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 엔코딩
	request.setCharacterEncoding("utf-8");

	//2. 6개의 상품데이타 읽기
	String sname=request.getParameter("sname");
	String scolor=request.getParameter("scolor");
	String sphoto=request.getParameter("sphoto");
	int sprice=Integer.parseInt(request.getParameter("sprice"));
	int scount=Integer.parseInt(request.getParameter("scount"));
	String shopidx=request.getParameter("shopidx");
	
		
	//3. dto 에 넣기 -setter로 넣기(총 6개)
	ShopDto dto=new ShopDto();
	dto.setSname(sname);
	dto.setSprice(sprice);
	dto.setScount(scount);
	dto.setScolor(scolor);
	dto.setSphoto(sphoto);
	dto.setShopidx(shopidx);
	
	//4. dao 선언
	ShopDao dao=new ShopDao();
	
	//5. update 메서드 호출
	dao.updateShop(dto);
	
	//6. shoplist.jsp 로 이동
	response.sendRedirect("shoplist.jsp");//이동,url 주소 바뀜
	
%>