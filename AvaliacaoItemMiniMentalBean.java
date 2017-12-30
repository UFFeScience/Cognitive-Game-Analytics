package academia_cerebro.bean;

public class AvaliacaoItemMiniMentalBean {
	private Integer id;
	private Integer id_item_mini_mental;
	private Integer id_avaliacao;
	private ItemMiniMentalBean itMiniMentalBean = new ItemMiniMentalBean();
	private AvaliacaoPacienteBean avPacienteBean = new AvaliacaoPacienteBean();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_item_mini_mental() {
		return id_item_mini_mental;
	}
	public void setId_item_mini_mental(Integer id_item_mini_mental) {
		this.id_item_mini_mental = id_item_mini_mental;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public ItemMiniMentalBean getItMiniMentalBean() {
		return itMiniMentalBean;
	}
	public void setItMiniMentalBean(ItemMiniMentalBean itMiniMentalBean) {
		this.itMiniMentalBean = itMiniMentalBean;
	}
	public AvaliacaoPacienteBean getAvPacienteBean() {
		return avPacienteBean;
	}
	public void setAvPacienteBean(AvaliacaoPacienteBean avPacienteBean) {
		this.avPacienteBean = avPacienteBean;
	}
}
