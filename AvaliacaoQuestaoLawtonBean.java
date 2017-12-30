package academia_cerebro.bean;

public class AvaliacaoQuestaoLawtonBean {
	private Integer id;
	private Integer id_questao_lawton;
	private Integer id_avaliacao;
	private QuestaoLawtonBean questaoLawtonBean = new QuestaoLawtonBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta_questao_lawton;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_questao_lawton() {
		return id_questao_lawton;
	}
	public void setId_questao_lawton(Integer id_questao_lawton) {
		this.id_questao_lawton = id_questao_lawton;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public QuestaoLawtonBean getQuestaoLawtonBean() {
		return questaoLawtonBean;
	}
	public void setQuestaoLawtonBean(QuestaoLawtonBean questaoLawtonBean) {
		this.questaoLawtonBean = questaoLawtonBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getResposta_questao_lawton() {
		return resposta_questao_lawton;
	}
	public void setResposta_questao_lawton(String resposta_questao_lawton) {
		this.resposta_questao_lawton = resposta_questao_lawton;
	}
}
