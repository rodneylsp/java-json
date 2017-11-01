

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class OperadorasServlet
 */
@WebServlet("/operadoras")
public class OperadorasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Operadora> operadoras = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperadorasServlet() {
        super();
        
        operadoras.add(new Operadora(10, "Oi", "Fixo", 1));
        operadoras.add(new Operadora(20, "Tim", "Celular", 2));
        operadoras.add(new Operadora(30, "Vivo", "Celular", 3));
        operadoras.add(new Operadora(40, "Claro", "Celular", 4));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/plain");
		 
		 //SOP - same origin policy (politica da mesma origem)
		 //necessario esse complemento do header para permitir acesso de origens diferentes
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		 response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		 		 
		 PrintWriter out = response.getWriter();
		 
		 ObjectMapper mapper = new ObjectMapper();
		 
		 String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(operadoras);
		 out.print(jsonInString);
		 out.flush();
	}

}
