package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SelectProductServlet")
public class SelectProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String productNo = request.getParameter("product_no");
		int no = 0;
		String productName = null;
		if (productNo == null || productNo.isEmpty()) {
			productName = "商品番号が推定されていません。";
		} else {
			try {
				no = Integer.parseInt(productNo);
				switch (no) {
				case 100:
					productName="パソコン";
					break;
				case 101:
					productName="プリンタ";
					break;
				case 102:
					productName="デジタルカメラ";
					break;
				default:
					productName="不明な商品番号です。";
				}
			} catch (NumberFormatException e) {
				productName="商品番号が不正な形式です。";
			}
		}
		out.println("<html><head><title>SelectProduct</title></head><body>");
		out.println("<h1>選択された商品は「" + productName + "」です</h1>");
		out.println("</body></html>");
	}
}
