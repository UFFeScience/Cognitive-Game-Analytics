package academia_cerebro.bean;

public class AtividadeCogstateBean {
	private Integer id;
	private String descricao_teste;
	private Integer id_secao_cogstate;
	private SecaoDocumentoCogstateBean secaoDocCogstateBean = new SecaoDocumentoCogstateBean();
	public SecaoDocumentoCogstateBean getSecaoDocCogstateBean() {
		return secaoDocCogstateBean;
	}
	public void setSecaoDocCogstateBean(SecaoDocumentoCogstateBean secaoDocCogstateBean) {
		this.secaoDocCogstateBean = secaoDocCogstateBean;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao_teste() {
		return descricao_teste;
	}
	public void setDescricao_teste(String descricao_teste) {
		this.descricao_teste = descricao_teste;
	}
	public Integer getId_secao_cogstate() {
		return id_secao_cogstate;
	}
	public void setId_secao_cogstate(Integer id_secao_cogstate) {
		this.id_secao_cogstate = id_secao_cogstate;
	}
}
