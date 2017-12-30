package academia_cerebro.bean;

public class AvaliacaoAtividadeCamcogBean {
	private Integer id;
	private Integer id_atividade_camcog;
	private Integer id_avaliacao;
	private AtividadeCamcogBean atvCamcogBean = new AtividadeCamcogBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String resposta;
	private Integer score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_atividade_camcog() {
		return id_atividade_camcog;
	}
	public void setId_atividade_camcog(Integer id_atividade_camcog) {
		this.id_atividade_camcog = id_atividade_camcog;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public AtividadeCamcogBean getAtvCamcogBean() {
		return atvCamcogBean;
	}
	public void setAtvCamcogBean(AtividadeCamcogBean atvCamcogBean) {
		this.atvCamcogBean = atvCamcogBean;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
