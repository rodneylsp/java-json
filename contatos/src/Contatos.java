

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
public class Contatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //TODO Auto-generated method stub
		 //response.getWriter().append("Served at: ").append(request.getContextPath());
		 //response.setContentType("application/json");
		 
		 PrintWriter out = response.getWriter();
		 
		 
		 List<Contato> contatos = new ArrayList<>();
		 
		 contatos.add(new Contato("Maria", 
				 "9999-7777", 
				 new Date(),
				 new Operadora("10", "Oi", "Fixo")));
		 
		 contatos.add(new Contato("Joao", 
				 "99999-8888", 
				 new Date(),
				 new Operadora("20", "Tim", "Celular")));
		 
		 contatos.add(new Contato("Pedro", 
				 "98888-4444", 
				 new Date(),
				 new Operadora("10", "Oi", "Fixo")));
		 
		 contatos.add(new Contato("Ana", 
				 "9741-1234", 
				 new Date(),
				 new Operadora("30", "GVT", "Celular")));
				 
		 
		 ObjectMapper mapper = new ObjectMapper();
		 
		 String jsonInString = mapper.writeValueAsString(contatos);
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
