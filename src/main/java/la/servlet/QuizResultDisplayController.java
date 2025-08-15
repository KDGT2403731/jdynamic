package la.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class QuizResultDisplayController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = (String) request.getAttribute("resultMessage");
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h2>結果</h2>");
		response.getWriter().println("<p>" + message + "</p>");
		response.getWriter().println("<a href='quizForm.html'>もう一度挑戦</a>");
		response.getWriter().println("</body></html>");
	}

}
