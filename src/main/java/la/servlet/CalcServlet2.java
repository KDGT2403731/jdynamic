package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalcServlet2")
public class CalcServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String num1 = request.getParameter("number1");
		String num2 = request.getParameter("number2");
		
		if (num1 == null || num1.isEmpty() || 
			num2 == null || num2.isEmpty()) {
			out.println("<h1>入力が不足しています。</h1>");
			return;
		}
		try {
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			int result = n1 + n2;
			out.println("<h1>計算結果: " + result + "</h1>");
		} catch (NumberFormatException e) {
			out.println("<h1>数字を入力してください。</h1>");
		}
	}

}
