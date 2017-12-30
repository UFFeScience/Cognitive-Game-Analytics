package academia_cerebro.bean;

public class AvaliacaoMedicamentoSubstanciaBean {
	private Integer id;
	private Integer id_medicamento_subst;
	private Integer id_avaliacao;
	private MedicamentoSubstanciaBean mdcSubstanciaBean = new MedicamentoSubstanciaBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	private Float dosagem;
	private String tempo_uso;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_medicamento_subst() {
		return id_medicamento_subst;
	}
	public void setId_medicamento_subst(Integer id_medicamento_subst) {
		this.id_medicamento_subst = id_medicamento_subst;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public MedicamentoSubstanciaBean getMdcSubstanciaBean() {
		return mdcSubstanciaBean;
	}
	public void setMdcSubstanciaBean(MedicamentoSubstanciaBean mdcSubstanciaBean) {
		this.mdcSubstanciaBean = mdcSubstanciaBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
	public Float getDosagem() {
		return dosagem;
	}
	public void setDosagem(Float dosagem) {
		this.dosagem = dosagem;
	}
	public String getTempo_uso() {
		return tempo_uso;
	}
	public void setTempo_uso(String tempo_uso) {
		this.tempo_uso = tempo_uso;
	}
}
