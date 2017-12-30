package academia_cerebro.bean;

public class AvaliacaoAtividadeTugBean {
	private Integer id;
	private Integer id_atividade_tug;
	private Integer id_avaliacao;
	private AtividadeTugBean atvTugBean = new AtividadeTugBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta;
	private Integer intervalo;
	private String tempo_real;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_atividade_tug() {
		return id_atividade_tug;
	}
	public void setId_atividade_tug(Integer id_atividade_tug) {
		this.id_atividade_tug = id_atividade_tug;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public AtividadeTugBean getAtvTugBean() {
		return atvTugBean;
	}
	public void setAtvTugBean(AtividadeTugBean atvTugBean) {
		this.atvTugBean = atvTugBean;
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
	public Integer getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	public String getTempo_real() {
		return tempo_real;
	}
	public void setTempo_real(String tempo_real) {
		this.tempo_real = tempo_real;
	}
}
