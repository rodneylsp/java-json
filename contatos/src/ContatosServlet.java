

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Contatos
 */
@WebServlet("/contatos")
public class ContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //TODO Auto-generated method stub
		 //response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/plain");
		 //response.setCharacterEncoding("UTF-8");
		 //response.setStatus(200);
		 
		 //SOP - same origin policy (politica da mesma origem)
		 //necessario esse complemento do header para permitir acesso de origens diferentes
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setHeader("Access-Control-Allow-Methods", "GET");
		 response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		 		 
		 PrintWriter out = response.getWriter();
		 
		 
		 List<Contato> contatos = new ArrayList<>();
		 
		 contatos.add(new Contato("Maria", 
				 "9999-7777", 
				 null,
				 new Operadora(10, "Oi", "Fixo")));
		 
		 contatos.add(new Contato("Joao", 
				 "99999-8888", 
				 null,
				 new Operadora(20, "Tim", "Celular")));
		 
		 contatos.add(new Contato("Pedro", 
				 "98888-4444", 
				 null,
				 new Operadora(10, "Oi", "Fixo")));
		 
		 contatos.add(new Contato("Ana", 
				 "9741-1234", 
				 null,
				 new Operadora(30, "GVT", "Celular")));
				 
		 
		 ObjectMapper mapper = new ObjectMapper();
		 
		 String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(contatos);
		 out.print(jsonInString);
		 out.flush();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
