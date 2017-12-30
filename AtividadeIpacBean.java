package academia_cerebro.bean;

public class AtividadeIpacBean {
	private Integer id;
	private String descricao_atividade;
	private Integer id_secao_ipac;
	private SecaoDocumentoIpacBean secaoDocIpacBean = new SecaoDocumentoIpacBean();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao_atividade() {
		return descricao_atividade;
	}
	public void setDescricao_atividade(String descricao_atividade) {
		this.descricao_atividade = descricao_atividade;
	}
	public Integer getId_secao_ipac() {
		return id_secao_ipac;
	}
	public void setId_secao_ipac(Integer id_secao_ipac) {
		this.id_secao_ipac = id_secao_ipac;
	}
	public SecaoDocumentoIpacBean getSecaoDocIpacBean() {
		return secaoDocIpacBean;
	}
	public void setSecaoDocIpacBean(SecaoDocumentoIpacBean secaoDocIpacBean) {
		this.secaoDocIpacBean = secaoDocIpacBean;
	}
}
