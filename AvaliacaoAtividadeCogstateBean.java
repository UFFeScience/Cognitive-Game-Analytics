package academia_cerebro.bean;

public class AvaliacaoAtividadeCogstateBean {
	private Integer id;
	private Integer id_atividade_cogstate;
	private Integer id_avaliacao;
	private AtividadeCogstateBean atvCogstateBean = new AtividadeCogstateBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private String data_teste_realizado;
	public String getData_teste_realizado() {
		return data_teste_realizado;
	}
	public void setData_teste_realizado(String data_teste_realizado) {
		this.data_teste_realizado = data_teste_realizado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_atividade_cogstate() {
		return id_atividade_cogstate;
	}
	public void setId_atividade_cogstate(Integer id_atividade_cogstate) {
		this.id_atividade_cogstate = id_atividade_cogstate;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public AtividadeCogstateBean getAtvCogstateBean() {
		return atvCogstateBean;
	}
	public void setAtvCogstateBean(AtividadeCogstateBean atvCogstateBean) {
		this.atvCogstateBean = atvCogstateBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
}
