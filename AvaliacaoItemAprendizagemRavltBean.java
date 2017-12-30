package academia_cerebro.bean;

public class AvaliacaoItemAprendizagemRavltBean {
	private Integer id;
	private Integer id_item_aprendizagem_ravlt;
	private Integer id_avaliacao;
	private ItemAprendizagemRavltBean itAprendizagemRavltBean = new ItemAprendizagemRavltBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_item_aprendizagem_ravlt() {
		return id_item_aprendizagem_ravlt;
	}
	public void setId_item_aprendizagem_ravlt(Integer id_item_aprendizagem_ravlt) {
		this.id_item_aprendizagem_ravlt = id_item_aprendizagem_ravlt;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public ItemAprendizagemRavltBean getItAprendizagemRavltBean() {
		return itAprendizagemRavltBean;
	}
	public void setItAprendizagemRavltBean(ItemAprendizagemRavltBean itAprendizagemRavltBean) {
		this.itAprendizagemRavltBean = itAprendizagemRavltBean;
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
}
