package academia_cerebro.bean;

public class AtividadeTrailMakingBean {
	private Integer id;
	private String descricao;
	private Integer id_secao_trail;
	private SecaoDocumentoTrailMakingBean secaoDocTrailMakingBean = new SecaoDocumentoTrailMakingBean();
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
	public Integer getId_secao_trail() {
		return id_secao_trail;
	}
	public void setId_secao_trail(Integer id_secao_trail) {
		this.id_secao_trail = id_secao_trail;
	}
	public SecaoDocumentoTrailMakingBean getSecaoDocTrailMakingBean() {
		return secaoDocTrailMakingBean;
	}
	public void setSecaoDocTrailMakingBean(SecaoDocumentoTrailMakingBean secaoDocTrailMakingBean) {
		this.secaoDocTrailMakingBean = secaoDocTrailMakingBean;
	}
}
