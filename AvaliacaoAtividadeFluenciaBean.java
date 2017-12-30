package academia_cerebro.bean;

public class AvaliacaoAtividadeFluenciaBean {
	private Integer id;
	private Integer id_atividade_fluencia;
	private Integer id_avaliacao;
	private AtividadeFluenciaBean atvFluenciaBean = new AtividadeFluenciaBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String data_realizacao_teste;
	private Integer score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_atividade_fluencia() {
		return id_atividade_fluencia;
	}
	public void setId_atividade_fluencia(Integer id_atividade_fluencia) {
		this.id_atividade_fluencia = id_atividade_fluencia;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public AtividadeFluenciaBean getAtvFluenciaBean() {
		return atvFluenciaBean;
	}
	public void setAtvFluenciaBean(AtividadeFluenciaBean atvFluenciaBean) {
		this.atvFluenciaBean = atvFluenciaBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getData_realizacao_teste() {
		return data_realizacao_teste;
	}
	public void setData_realizacao_teste(String data_realizacao_teste) {
		this.data_realizacao_teste = data_realizacao_teste;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
