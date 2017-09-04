<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="jin.edu.dto.ShainInfoDto" %>
<%
    ShainInfoDto shainInfoDto = (ShainInfoDto)request.getAttribute("shainInfoDto");    //社員情報を設定する
    String resultDisp = (String)request.getAttribute("resultDisp");        //検索結果表判定を設定する
    String backgroundColor = (String)request.getAttribute("resultBackgroundColor");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lesson01</title>
</head>
<body style="background-color:<%=backgroundColor%>">
    <form name="lesson31Form" action="Lesson01Serv" method="post">
        <table border="0" align="center">
            <tr><td align="right">社員番号：</td><td><input type="text"  name="shainNo" maxlength=4 size=4 ></td>
            <td align="right"><button type="submit" name="procNo" value="1">検索</button></td><td>&nbsp;</td></tr>
            <tr>
                <td align="right">背景色：</td>
                <td colspan="2">
                    <select name="backgroundColor">
                    <option value="1">赤</option>
                    <option value="2">緑</option>
                    <option value="3">青</option>
                    </select>
                </td>
            </tr>
        </table>
<%
    if (resultDisp == "1") {
%>
        <table border="0" align="center">
            <td>
                <table border="0" align="left">
                    <td align="right"><検索結果></td>
                </table>
            </td>
            <tr><td>
                <table border="1" align="left">
                    <tr>
                        <td align="center" bgcolor="#c0ffc0">No</td>
                        <td align="center" bgcolor="#c0ffc0">社員番号</td>
                        <td align="center" bgcolor="#c0ffc0">社員名</td>
                        <td align="center" bgcolor="#c0ffc0">部署番号</td>
                        <td align="center" bgcolor="#c0ffc0">部署名</td>
                    </tr>
                    <tr>
                        <td width="30" align="right">1</td>
                        <td width="80" align="center"><%=shainInfoDto.getShainNo()%></td>
                        <td width="150" align="center"><%=shainInfoDto.getShainNameKj()%></td>
                        <td width="80" align="center"><%=shainInfoDto.getBushoNo()%></td>
                        <td width="150" align="center"><%=shainInfoDto.getBushoNameKj()%></td>
                    </tr>
                </table>
            </td></tr>
        </table>
<%
    }
%>
    </form>
</body>
</html>
