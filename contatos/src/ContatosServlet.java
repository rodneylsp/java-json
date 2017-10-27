

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
	
	private static List<Contato> listaContato = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContatosServlet() {
        super();
        
		 List<Contato> contatos = new ArrayList<>();
		 
		 contatos.add(new Contato("Maria", 
				 "9999-7777", 
				 new Date(),
				 new Operadora(10, "Oi", "Fixo", 1)));
		 
		 contatos.add(new Contato("Joao", 
				 "99999-8888", 
				 new Date(),
				 new Operadora(20, "Tim", "Celular", 2)));
		 
		 contatos.add(new Contato("Pedro", 
				 "98888-4444", 
				 new Date(),
				 new Operadora(10, "Oi", "Fixo", 1)));
		 
		 contatos.add(new Contato("Ana", 
				 "9741-1234", 
				 new Date(),
				 new Operadora(30, "GVT", "Celular", 3)));
		 
		 listaContato.addAll(contatos);
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
		 
		 String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listaContato);
		 out.print(jsonInString);
		 out.flush();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		 response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		
		 ObjectMapper mapper = new ObjectMapper();
		 Contato contato = mapper.readValue(request.getReader(), Contato.class);
		 
		 listaContato.add(contato);
		
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
	
	}

}
