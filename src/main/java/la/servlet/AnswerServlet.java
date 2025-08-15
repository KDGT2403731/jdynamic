package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String answer = request.getParameter("answer");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>あなたの答えは" + answer + "</h1>");
		
		if ("James Gosling".equals(answer)) {
			out.println("<h2>正解!</h2>");
		} else {
			out.println("<h2>不正解!</h2>");
		}
		
		out.println("<p><a href=\"/jdynamic/question.html\">もう一度挑戦する</a></p>");
		out.println("</body><html>");
	}

}
