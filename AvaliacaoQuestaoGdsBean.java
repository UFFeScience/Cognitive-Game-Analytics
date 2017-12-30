package academia_cerebro.bean;

public class AvaliacaoQuestaoGdsBean {
	private Integer id;
	private Integer id_questao_gds;
	private Integer id_avaliacao;
	private QuestaoGdsBean questaoGdsBean = new QuestaoGdsBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta_questao_gds;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_questao_gds() {
		return id_questao_gds;
	}
	public void setId_questao_gds(Integer id_questao_gds) {
		this.id_questao_gds = id_questao_gds;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public QuestaoGdsBean getQuestaoGdsBean() {
		return questaoGdsBean;
	}
	public void setQuestaoGdsBean(QuestaoGdsBean questaoGdsBean) {
		this.questaoGdsBean = questaoGdsBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getResposta_questao_gds() {
		return resposta_questao_gds;
	}
	public void setResposta_questao_gds(String resposta_questao_gds) {
		this.resposta_questao_gds = resposta_questao_gds;
	}
}
