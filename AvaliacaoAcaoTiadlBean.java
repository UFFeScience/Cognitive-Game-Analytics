package academia_cerebro.bean;

public class AvaliacaoAcaoTiadlBean {
	private Integer id;
	private Integer id_acao_tiadl;
	private Integer id_avaliacao;
	private AcaoTiadlBean acaoTiadlBean = new AcaoTiadlBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String tempo_execucao_acao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_acao_tiadl() {
		return id_acao_tiadl;
	}
	public void setId_acao_tiadl(Integer id_acao_tiadl) {
		this.id_acao_tiadl = id_acao_tiadl;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public AcaoTiadlBean getAcaoTiadlBean() {
		return acaoTiadlBean;
	}
	public void setAcaoTiadlBean(AcaoTiadlBean acaoTiadlBean) {
		this.acaoTiadlBean = acaoTiadlBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getTempo_execucao_acao() {
		return tempo_execucao_acao;
	}
	public void setTempo_execucao_acao(String tempo_execucao_acao) {
		this.tempo_execucao_acao = tempo_execucao_acao;
	}
}
