package academia_cerebro.bean;

public class AvaliacaoPacienteBean {
	private Integer id;
	private String trail_a;
	private Integer trail_a_segundos;
	private Integer hits;
	private Integer cr;
	private String trail_b;
	private Integer trail_b_segundos;
	public Integer getTrail_a_segundos() {
		return trail_a_segundos;
	}
	public void setTrail_a_segundos(Integer trail_a_segundos) {
		this.trail_a_segundos = trail_a_segundos;
	}
	public Integer getTrail_b_segundos() {
		return trail_b_segundos;
	}
	public void setTrail_b_segundos(Integer trail_b_segundos) {
		this.trail_b_segundos = trail_b_segundos;
	}
	private Integer fluencia;
	//private Integer id_sessao_jogo;
	private SessaoJogoBean sessaoJogoBean = new SessaoJogoBean();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrail_a() {
		return trail_a;
	}
	public void setTrail_a(String trail_a) {
		this.trail_a = trail_a;
	}
	public String getTrail_b() {
		return trail_b;
	}
	public void setTrail_b(String trail_b) {
		this.trail_b = trail_b;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getCr() {
		return cr;
	}
	public void setCr(Integer cr) {
		this.cr = cr;
	}
	public Integer getFluencia() {
		return fluencia;
	}
	public void setFluencia(Integer fluencia) {
		this.fluencia = fluencia;
	}
	/*public Integer getId_sessao_jogo() {
		return id_sessao_jogo;
	}
	public void setId_sessao_jogo(Integer id_sessao_jogo) {
		this.id_sessao_jogo = id_sessao_jogo;
	}*/
	public SessaoJogoBean getSessaoJogoBean() {
		return sessaoJogoBean;
	}
	public void setSessaoJogoBean(SessaoJogoBean sessaoJogoBean) {
		this.sessaoJogoBean = sessaoJogoBean;
	}
}
