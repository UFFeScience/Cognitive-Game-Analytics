package academia_cerebro.bean;

public class AvaliacaoAtividadeTrailMakingBean {
	private Integer id;
	private Integer id_atividade_trail;
	private Integer id_avaliacao;
	private AtividadeTrailMakingBean atvBean = new AtividadeTrailMakingBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String data_avaliacao;
	private String tempo_score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_atividade_trail() {
		return id_atividade_trail;
	}
	public void setId_atividade_trail(Integer id_atividade_trail) {
		this.id_atividade_trail = id_atividade_trail;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public AtividadeTrailMakingBean getAtvBean() {
		return atvBean;
	}
	public void setAtvBean(AtividadeTrailMakingBean atvBean) {
		this.atvBean = atvBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getData_avaliacao() {
		return data_avaliacao;
	}
	public void setData_avaliacao(String data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}
	public String getTempo_score() {
		return tempo_score;
	}
	public void setTempo_score(String tempo_score) {
		this.tempo_score = tempo_score;
	}
}
