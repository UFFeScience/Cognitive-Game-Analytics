package academia_cerebro.bean;

public class AtividadeCamcogBean {
	private Integer id;
	private String descricao;
	private Integer id_secao_camcog;
	private SecaoDocumentoCamcogBean secaoDocCamcogBean = new SecaoDocumentoCamcogBean();
	public SecaoDocumentoCamcogBean getSecaoDocCamcogBean() {
		return secaoDocCamcogBean;
	}
	public void setSecaoDocCamcogBean(SecaoDocumentoCamcogBean secaoDocCamcogBean) {
		this.secaoDocCamcogBean = secaoDocCamcogBean;
	}
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
	public Integer getId_secao_camcog() {
		return id_secao_camcog;
	}
	public void setId_secao_camcog(Integer id_secao_camcog) {
		this.id_secao_camcog = id_secao_camcog;
	}
}
