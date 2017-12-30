package academia_cerebro.bean;

public class AvaliacaoQuestaoQiBean {
	private Integer id;
	private Integer id_questao_qi;
	private Integer id_avaliacao;
	private QuestaoQiBean questaoQiBean = new QuestaoQiBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta_questao_qi;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_questao_qi() {
		return id_questao_qi;
	}
	public void setId_questao_qi(Integer id_questao_qi) {
		this.id_questao_qi = id_questao_qi;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public QuestaoQiBean getQuestaoQiBean() {
		return questaoQiBean;
	}
	public void setQuestaoQiBean(QuestaoQiBean questaoQiBean) {
		this.questaoQiBean = questaoQiBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getResposta_questao_qi() {
		return resposta_questao_qi;
	}
	public void setResposta_questao_qi(String resposta_questao_qi) {
		this.resposta_questao_qi = resposta_questao_qi;
	}
}
