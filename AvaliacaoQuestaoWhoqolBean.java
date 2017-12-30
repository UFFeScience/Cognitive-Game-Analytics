package academia_cerebro.bean;

public class AvaliacaoQuestaoWhoqolBean {
	private Integer id;
	private Integer id_questao_whoqol;
	private Integer id_avaliacao;
	private QuestaoWhoqolBean questaoWhoqolBean = new QuestaoWhoqolBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String reposta_questao_whoqol;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_questao_whoqol() {
		return id_questao_whoqol;
	}
	public void setId_questao_whoqol(Integer id_questao_whoqol) {
		this.id_questao_whoqol = id_questao_whoqol;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public QuestaoWhoqolBean getQuestaoWhoqolBean() {
		return questaoWhoqolBean;
	}
	public void setQuestaoWhoqolBean(QuestaoWhoqolBean questaoWhoqolBean) {
		this.questaoWhoqolBean = questaoWhoqolBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getReposta_questao_whoqol() {
		return reposta_questao_whoqol;
	}
	public void setReposta_questao_whoqol(String reposta_questao_whoqol) {
		this.reposta_questao_whoqol = reposta_questao_whoqol;
	}
}
