package academia_cerebro.bean;

public class AvaliacaoQuestaoKatzBean {
	private Integer id;
	private Integer id_questao_katz;
	private Integer id_avaliacao;
	private QuestaoKatzBean questaoKatzBean = new QuestaoKatzBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta_questao_katz;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_questao_katz() {
		return id_questao_katz;
	}
	public void setId_questao_katz(Integer id_questao_katz) {
		this.id_questao_katz = id_questao_katz;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public QuestaoKatzBean getQuestaoKatzBean() {
		return questaoKatzBean;
	}
	public void setQuestaoKatzBean(QuestaoKatzBean questaoKatzBean) {
		this.questaoKatzBean = questaoKatzBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getResposta_questao_katz() {
		return resposta_questao_katz;
	}
	public void setResposta_questao_katz(String resposta_questao_katz) {
		this.resposta_questao_katz = resposta_questao_katz;
	}
	
}
