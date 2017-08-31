package jin.edu.serv;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jin.edu.dao.ShainInfoDao;
import jin.edu.dto.ShainInfoDto;

/**
 * Servlet implementation class Lesson16Serv
 */
@WebServlet("/Lesson01Serv")
public class Lesson01Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String URL_INDEX = "/index.jsp";

	private final static int COL_SEARCH = 1;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lesson01Serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc	= getServletContext();
		// 応答時のエンコード指定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 処理番号を取得する。
		String procNo = request.getParameter("procNo");

		// 社員番号を取得する。
		String shainNo = request.getParameter("shainNo");

		// 社員情報取得DAOを生成する。
		ShainInfoDao shainInfoDao = new ShainInfoDao();

		// 社員情報取得領域を生成する。
		ShainInfoDto shainInfoDto = new ShainInfoDto();

		// 結果判定を設定する。
		String resultDisp = null;

		if (Integer.parseInt(procNo) == COL_SEARCH) {

			// 社員番号が入力された場合は社員情報取得処理を呼び出し、結果を取得する。
			if (shainNo != null) {
				shainInfoDto = shainInfoDao.select(shainNo);

				// 社員名(漢字)が設定されている場合は結果判定に1を設定する。
				if (shainInfoDto.getShainNameKj() != null) {
					resultDisp = "1";
				}
			}

			// requestに結果を設定する
			request.setAttribute("shainInfoDto",shainInfoDto);
			request.setAttribute("resultDisp",resultDisp);

			// 次画面を表示する
			sc.getRequestDispatcher(URL_INDEX).forward(request, response);

		}


	}
}