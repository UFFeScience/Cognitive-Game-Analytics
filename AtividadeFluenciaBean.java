package academia_cerebro.bean;

public class AtividadeFluenciaBean {
	private Integer id;
	private String descricao;
	private Integer id_secao_fluencia;
	private SecaoDocumentoFluenciaBean secaoDocFluenciaBean = new SecaoDocumentoFluenciaBean();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId_secao_fluencia() {
		return id_secao_fluencia;
	}
	public void setId_secao_fluencia(Integer id_secao_fluencia) {
		this.id_secao_fluencia = id_secao_fluencia;
	}
	public SecaoDocumentoFluenciaBean getSecaoDocFluenciaBean() {
		return secaoDocFluenciaBean;
	}
	public void setSecaoDocFluenciaBean(SecaoDocumentoFluenciaBean secaoDocFluenciaBean) {
		this.secaoDocFluenciaBean = secaoDocFluenciaBean;
	}
}
