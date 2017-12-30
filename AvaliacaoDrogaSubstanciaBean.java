package academia_cerebro.bean;

public class AvaliacaoDrogaSubstanciaBean {
	private Integer id;
	private Integer id_droga_substancia;
	private Integer id_avaliacao;
	private DrogaSubstanciaBean drgSubstanciaBean = new DrogaSubstanciaBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta;
	private Integer quantidade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_droga_substancia() {
		return id_droga_substancia;
	}
	public void setId_droga_substancia(Integer id_droga_substancia) {
		this.id_droga_substancia = id_droga_substancia;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public DrogaSubstanciaBean getDrgSubstanciaBean() {
		return drgSubstanciaBean;
	}
	public void setDrgSubstanciaBean(DrogaSubstanciaBean drgSubstanciaBean) {
		this.drgSubstanciaBean = drgSubstanciaBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
