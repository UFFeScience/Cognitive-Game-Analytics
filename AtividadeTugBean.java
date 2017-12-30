package academia_cerebro.bean;

public class AtividadeTugBean {
	private Integer id;
	private String descricao;
	private Integer id_secao_tug;
	private SecaoDocumentoTugBean secaoDocTugBean = new SecaoDocumentoTugBean();
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
	public Integer getId_secao_tug() {
		return id_secao_tug;
	}
	public void setId_secao_tug(Integer id_secao_tug) {
		this.id_secao_tug = id_secao_tug;
	}
	public SecaoDocumentoTugBean getSecaoDocTugBean() {
		return secaoDocTugBean;
	}
	public void setSecaoDocTugBean(SecaoDocumentoTugBean secaoDocTugBean) {
		this.secaoDocTugBean = secaoDocTugBean;
	}
}
