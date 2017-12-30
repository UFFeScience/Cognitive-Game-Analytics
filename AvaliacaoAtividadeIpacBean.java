package academia_cerebro.bean;

public class AvaliacaoAtividadeIpacBean {
	private Integer id;
	private Integer id_atividade_ipac;
	private Integer id_avaliacao;
	private AtividadeIpacBean atvIpacBean = new AtividadeIpacBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String valor_dia_semana;
	private String valor_minuto_dia;
	private Integer score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_atividade_ipac() {
		return id_atividade_ipac;
	}
	public void setId_atividade_ipac(Integer id_atividade_ipac) {
		this.id_atividade_ipac = id_atividade_ipac;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public AtividadeIpacBean getAtvIpacBean() {
		return atvIpacBean;
	}
	public void setAtvIpacBean(AtividadeIpacBean atvIpacBean) {
		this.atvIpacBean = atvIpacBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public String getValor_dia_semana() {
		return valor_dia_semana;
	}
	public void setValor_dia_semana(String valor_dia_semana) {
		this.valor_dia_semana = valor_dia_semana;
	}
	public String getValor_minuto_dia() {
		return valor_minuto_dia;
	}
	public void setValor_minuto_dia(String valor_minuto_dia) {
		this.valor_minuto_dia = valor_minuto_dia;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
