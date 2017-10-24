
public class Operadora {
	
	private Integer codigo;
	private String nome;
	private String categoria;
	
	
	public Operadora(){}
	
	public Operadora(Integer codigo, String nome, String categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
