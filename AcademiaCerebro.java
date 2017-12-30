package academia_cerebro;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import academia_cerebro.bean.*;
import academia_cerebro.dao.*;
import academia_cerebro.util.Util;

public class AcademiaCerebro {
	private static int contador_exames = -1;
	public AcademiaCerebro() {
		contador_exames++;
	}
	
	//public AcademiaCerebro() {}
	
	public void popularJogoIntelligenceBD(Map mapaParametros) throws SQLException {
		System.out.println("Estou no Jogo Intelligence!!!");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_jogo = new Integer(obj[0].toString());
		System.out.println("Id Jogo = " + id_jogo);
		JogoIntelligenceBean jib = new JogoIntelligenceBean();
		jib.setId_jogo(id_jogo);
		/*JogoIntelligenceDAO jid = new JogoIntelligenceDAO();
		jid.insert(jib);*/
		System.out.println("Gravado Jogo Intelligence!!!");
	}
	public void popularJogoMemoryBD(Map mapaParametros) throws SQLException {
		System.out.println("Estou no Jogo Memory!!!");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_jogo = new Integer(obj[0].toString());
		System.out.println("Id Jogo = " + id_jogo);
		JogoMemoryBean jmb = new JogoMemoryBean();
		jmb.setId_jogo(id_jogo);
		/*JogoMemoryDAO jmd = new JogoMemoryDAO();
		jmd.insert(jmb);*/
		System.out.println("Gravado Jogo Memory!!!");
	}
	public void popularJogoBrainSpeedBD(Map mapaParametros) throws SQLException {
		System.out.println("Estou no Jogo Brain Speed!!!");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_jogo = new Integer(obj[0].toString());
		System.out.println("Id Jogo = " + id_jogo);
		JogoBrainSpeedBean jbsb = new JogoBrainSpeedBean();
		jbsb.setId_jogo(id_jogo);
		/*JogoBrainSpeedDAO jbsd = new JogoBrainSpeedDAO();
		jbsd.insert(jbsb);*/
		System.out.println("Gravado Jogo Brain Speed!!!");
	}
	public void popularJogoNavigationBD(Map mapaParametros) throws SQLException {
		System.out.println("Estou no Jogo Navigation!!!");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_jogo = new Integer(obj[0].toString());
		System.out.println("Id Jogo = " + id_jogo);
		JogoNavigationBean jnb = new JogoNavigationBean();
		jnb.setId_jogo(id_jogo);
		/*JogoNavigationDAO jnd = new JogoNavigationDAO();
		jnd.insert(jnb);*/
		System.out.println("Gravado Jogo Navigation!!!");
	}
	public void popularJogoPeopleSkillBD(Map mapaParametros) throws SQLException {
		System.out.println("Estou no Jogo People Skills!!!");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_jogo = new Integer(obj[0].toString());
		System.out.println("Id Jogo = " + id_jogo);
		JogoPeopleSkillBean jpsb = new JogoPeopleSkillBean();
		jpsb.setId_jogo(id_jogo);
		/*JogoPeopleSkillDAO jpsd = new JogoPeopleSkillDAO();
		jpsd.insert(jpsb);*/
		System.out.println("Gravado Jogo People Skills!!!");
	}
	public void popularJogoAtencaoBD(Map mapaParametros) throws SQLException {
		System.out.println("Estou no Jogo Atenção!!!");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_jogo = new Integer(obj[0].toString());
		System.out.println("Id Jogo = " + id_jogo);
		JogoAtencaoBean jab = new JogoAtencaoBean();
		jab.setId_jogo(id_jogo);
		/*JogoAtencaoDAO jad = new JogoAtencaoDAO();
		jad.insert(jab);*/
		System.out.println("Gravado Jogo Atenção!!!");
	}
	public void popularJogoBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		if ( "Jogo".equals(nomePlanilha) ) {
			System.out.println("Estou no Jogo!!!");
			JogoBean jogoBean = new JogoBean();
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				System.out.println(entry.getKey() + " - " + entry.getValue());
				if("nome".equals(entry.getKey().toString())) {
					jogoBean.setNome(entry.getValue().toString());
					continue;
				}
				if("unidade_thresold".equals(entry.getKey().toString())) {
					jogoBean.setUnidade_thresold(entry.getValue().toString());
					continue;
				}
				if("termo_original".equals(entry.getKey().toString())) {
					jogoBean.setTermo_original(entry.getValue().toString());
					continue;
				}
				if("id_grupodejogo".equals(entry.getKey().toString())) {
					jogoBean.setId_grupodejogo(new Integer(entry.getValue().toString()));
					continue;
				}
			}
			JogoDAO jogoDAO = new JogoDAO();
			jogoDAO.insert(jogoBean);
			System.out.println("Gravado Jogo!!!");
		}	
	}
	public void popularPacienteBD(Map mapaParametros, String namePlanilha) throws SQLException {
		if ( "Paciente".equals(namePlanilha) ) {
			System.out.println("Vou Cadastrar Paciente");
			PacienteBean pacb = new PacienteBean();
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				System.out.println(entry.getKey() + "-" + entry.getValue());
				
				if("numero".equals(entry.getKey().toString())) {
					pacb.setNumero(new Integer(entry.getValue().toString()));
					continue;
				}
				if("nome".equals(entry.getKey().toString())) {
					pacb.setNome(entry.getValue().toString());
					continue;
				}	
				if("contato_previo".equals(entry.getKey().toString())) {
					pacb.setContato_previo(entry.getValue().toString());
					continue;
				}	
				if("genero".equals(entry.getKey().toString())) {
					//char charGenero = entry.getValue().toString().charAt(0);
					pacb.setGenero(entry.getValue().toString());
					continue;
				}	
				if("escolaridade_anos".equals(entry.getKey().toString())) {
					pacb.setEscolaridade_anos(new Integer(entry.getValue().toString()));
					continue;
				}	
				if("idade".equals(entry.getKey().toString())) {
					pacb.setIdade(new Integer(entry.getValue().toString()));
					continue;
				}	
				if("atividade_memoria".equals(entry.getKey().toString())) {
					pacb.setAtividade_memoria(entry.getValue().toString());
					continue;
				}	
				if("situacao".equals(entry.getKey().toString())) {
					pacb.setSituacao(entry.getValue().toString());
					continue;
				}	
				if("grupo".equals(entry.getKey().toString())) {
					pacb.setGrupo(entry.getValue().toString());
					continue;
				}
				if("altura".equals(entry.getKey().toString())) {
					pacb.setAltura(new Integer(entry.getValue().toString()));
					continue;
				}
				if("peso".equals(entry.getKey().toString())) {
					pacb.setPeso(new Integer(entry.getValue().toString()));
					continue;
				}
				if("imc".equals(entry.getKey().toString())) {
					pacb.setImc(new Integer(entry.getValue().toString()));
					continue;
				}
				if("qi".equals(entry.getKey().toString())) {
					pacb.setQi(entry.getValue().toString());
					continue;
				}
				if("dt_nasc".equals(entry.getKey().toString())) {
					String[] dt_nasc_formatada = (entry.getValue().toString()).split("'");
					System.out.println("dt_nasc_formatada[0] = " + dt_nasc_formatada[0]);
					pacb.setDt_nasc(dt_nasc_formatada[0]);
					continue;
				}
			}	
			PacienteDAO pacd = new PacienteDAO();
			pacd.insert(pacb);
			System.out.println("Gravado Paciente");
		}	
	}
	public void popularGrupoJogoBD(Map mapaParametros, String namePlanilha) throws SQLException {
		if ( "Grupo_de_Jogo".equals(namePlanilha) ) {
			System.out.println("Estou no Grupo de Jogo!!!");
			GrupoDeJogoBean gjb = new GrupoDeJogoBean();
			Object[] objNome = mapaParametros.values().toArray();
			String nome = objNome[0].toString();
			System.out.println(nome);
			gjb.setNome(nome);
			GrupoDeJogoDAO gjd = new GrupoDeJogoDAO();
			gjd.insert(gjb);
			System.out.println("Gravado Grupo de Jogo");
		}	
	}	
	public void popularSessaoJogoBD(Map mapaParametros, String namePlanilha) throws SQLException {
		//if ( "Sessao_Jogo".equals(namePlanilha) ) {
			String std = null;
			SessaoJogoBean sjb = new SessaoJogoBean();
			Set set = mapaParametros.entrySet();
	        Iterator it = set.iterator();
	        while(it.hasNext()) {
	        	Map.Entry entry = (Map.Entry)it.next();
	        	System.out.println(entry.getKey() + " - " + entry.getValue());
	        	
	        	if("id_paciente".equals(entry.getKey().toString())) {
	        		sjb.setId_paciente(new Integer(entry.getValue().toString()));
	        		continue;
	        	}
	        	
	        	if("id_jogo".equals(entry.getKey().toString())) {
	        		sjb.setId_jogo(new Integer(entry.getValue().toString()));
	        		continue;
	        	}
	        	
	        	if("data_local".equals(entry.getKey().toString())) {
	        		System.out.println("local_date = " + entry.getValue().toString());
	        		/* Tira as aspas, trocando por nada */
	        		std = (entry.getValue().toString()).replaceAll("\"", "");
	        		//System.out.println("STD - Date Formatada = " + std + "\n" + Util.converterData(std));
	        		sjb.setData_local(std);
	        		continue;
	        	} 
	        	if("tempo".equals(entry.getKey().toString())) {
	        		sjb.setTempo(entry.getValue().toString());
	        		continue;
	        	}
	        	if("z_score".equals(entry.getKey().toString())) {
	        		sjb.setZ_score(new Double(entry.getValue().toString()));
	        		continue;
	        	}
	        	if("hora".equals(entry.getKey().toString())) {
	        		if (entry.getValue() != null) {
	        			sjb.setHora(entry.getValue().toString());
	        		} else {
	        			sjb.setHora(null);
	        		}
	        		continue;
	        	}
	        	if("threshold".equals(entry.getKey().toString())) {
	        		//sjb.setThresold(new Integer(entry.getValue().toString()));
	        		//sjb.setThresold(new Long(entry.getValue().toString()));
	        		sjb.setThresold(new Double(entry.getValue().toString()));
	        		continue;
	        	} 
	        	if("stars_awarded".equals(entry.getKey().toString())) {
	        		sjb.setStars(new Integer(entry.getValue().toString()));
	        		continue;
	        	}
	        	
	        	if("id_avaliacao".equals(entry.getKey().toString())) {
	        		if (entry.getValue() != null) {
	        			sjb.setId_avaliacao(new Integer(entry.getValue().toString()));
	        		} else {
	        			sjb.setId_avaliacao(null);
	        		}
	        		continue;
	        	}
	        }
	        //Grava na Base através do Model DAO
	        SessaoJogoDAO SessaoJogoDAO = new SessaoJogoDAO();
	        SessaoJogoDAO.insert(sjb);
	        System.out.println("Gravado a Sessão do Jogo!!!");
		//}    
	}
	public void popularExameCognitivoBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		if ( "Cognitivo".equals(nomePlanilha) ) {
			System.out.println("Inicio Exame Cognitivo");
			ExameCognitivoBean excogb = new ExameCognitivoBean();
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if("nome".equals(entry.getKey().toString())) {
					excogb.setNome(entry.getValue().toString());
					continue;
				}
				
				if("objetivo".equals(entry.getKey().toString())) {
					excogb.setObjetivo(entry.getValue().toString());
					continue;
				}
				
				/*if("tipo".equals(entry.getKey().toString())) {
					excogb.setTipo(entry.getValue().toString());
					continue;
				}*/
			}
			ExameCognitivoDAO excogd = new ExameCognitivoDAO();
			excogd.insert(excogb);
			System.out.println("Gravado Exame Cognitivo");
		}	
	}	
	public void popularExameIpacBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame IPAC");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameIpacBean exib = new ExameIpacBean();
		exib.setId_exc(id_exc);
		ExameIpacDAO exid = new ExameIpacDAO();
		exid.insert(exib);
		System.out.println("Gravado Ipac");
	}
	public void popularExameGdsBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame GDS-15");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameGdsBean exgdb = new ExameGdsBean();
		exgdb.setId_exc(id_exc);
		ExameGdsDAO exgdd = new ExameGdsDAO();
		exgdd.insert(exgdb);
		System.out.println("Gravado GDS-15");
	}
	public void popularExameKatzBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Katz");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameKatzBean exkzb = new ExameKatzBean();
		exkzb.setId_exc(id_exc);
		ExameKatzDAO exkzd = new ExameKatzDAO();
		exkzd.insert(exkzb);
		System.out.println("Gravado Katz");
	}
	public void popularExameLawtonBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Lawton");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameLawtonBean exlwb = new ExameLawtonBean();
		exlwb.setId_exc(id_exc);
		ExameLawtonDAO exlwd = new ExameLawtonDAO();
		exlwd.insert(exlwb);
		System.out.println("Gravado Lawton");
	}
	public void popularExameQiBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame QI");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameQiBean exqib = new ExameQiBean();
		exqib.setId_exc(id_exc);
		ExameQiDAO exqid = new ExameQiDAO();
		exqid.insert(exqib);
		System.out.println("Gravado QI");
	}
	public void popularExameTiadlBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame TIADL");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameTiadlBean extdlb = new ExameTiadlBean();
		extdlb.setId_exc(id_exc);
		ExameTiadlDAO extdld = new ExameTiadlDAO();
		extdld.insert(extdlb);
		System.out.println("Gravado TIADL");
	}
	public void popularExameCogstateBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Cogstate");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameCogstateBean excgsb = new ExameCogstateBean();
		excgsb.setId_exc(id_exc);
		ExameCogstateDAO excgsd = new ExameCogstateDAO();
		excgsd.insert(excgsb);
		System.out.println("Gravado Cogstate");
	}
	public void popularExameMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Mini Mental");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameMiniMentalBean exmmb = new ExameMiniMentalBean();
		exmmb.setId_exc(id_exc);
		ExameMiniMentalDAO exmmd = new ExameMiniMentalDAO();
		exmmd.insert(exmmb);
		System.out.println("Gravado Mini Mental");
	}
	public void popularExameRavltBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Ravlt");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameRavltBean exrvtb = new ExameRavltBean();
		exrvtb.setId_exc(id_exc);
		ExameRavltDAO exrvtd = new ExameRavltDAO();
		exrvtd.insert(exrvtb);
		System.out.println("Gravado Ravlt");
	}
	public void popularExameCamcogBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Camcog");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameCamcogBean excagb = new ExameCamcogBean();
		excagb.setId_exc(id_exc);
		ExameCamcogDAO excagd = new ExameCamcogDAO();
		excagd.insert(excagb);
		System.out.println("Gravado Camcog");
	}
	public void popularExameTrailMakingBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Trail Making");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameTrailMakingBean extrmb = new ExameTrailMakingBean();
		extrmb.setId_exc(id_exc);
		ExameTrailMakingDAO extrmd = new ExameTrailMakingDAO();
		extrmd.insert(extrmb);
		System.out.println("Gravado Trail Making");
	}
	public void popularExameWhoqolBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Whoqol");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameWhoqolBean exwhob = new ExameWhoqolBean();
		exwhob.setId_exc(id_exc);
		ExameWhoqolDAO exwhod = new ExameWhoqolDAO();
		exwhod.insert(exwhob);
		System.out.println("Gravado Whoqol");
	}
	public void popularExameFluenciaBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Fluencia");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameFluenciaBean exflcb = new ExameFluenciaBean();
		exflcb.setId_exc(id_exc);
		ExameFluenciaDAO exflcd = new ExameFluenciaDAO();
		exflcd.insert(exflcb);
		System.out.println("Gravado Fluencia");
	}
	public void popularExameTugBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Tug");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameTugBean extugb = new ExameTugBean();
		extugb.setId_exc(id_exc);
		ExameTugDAO extugd = new ExameTugDAO();
		extugd.insert(extugb);
		System.out.println("Gravado Tug");
	}
	public void popularExameSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Exame Substancia");
		Object[] obj = mapaParametros.values().toArray();
		Integer id_exc = new Integer(obj[0].toString());
		System.out.println("id_exc = " + id_exc);
		ExameSubstanciaBean exsubstb = new ExameSubstanciaBean();
		exsubstb.setId_exc(id_exc);
		ExameSubstanciaDAO exsubstd = new ExameSubstanciaDAO();
		exsubstd.insert(exsubstb);
		System.out.println("Gravado Substancia");
	}
	public void popularDocumentoIpacBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento IPAC");
		
		DocumentoIpacBean docipc = new DocumentoIpacBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_ipac".equals(entry.getKey().toString())) {
				docipc.setId_exc_ipac(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docipc.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docipc.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoIpacDAO docipcd = new DocumentoIpacDAO();
		docipcd.insert(docipc);
		System.out.println("Gravado Documento IPAC");
	}
	public void popularDocumentoGdsBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento GDS-15");
		
		DocumentoGdsBean docgds = new DocumentoGdsBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_gds".equals(entry.getKey().toString())) {
				docgds.setId_exc_gds(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docgds.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docgds.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoGdsDAO docgdsd = new DocumentoGdsDAO();
		docgdsd.insert(docgds);
		System.out.println("Gravado Documento GDS-15");
	}
	public void popularDocumentoKatzBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Katz");
		
		DocumentoKatzBean dockatz = new DocumentoKatzBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_katz".equals(entry.getKey().toString())) {
				dockatz.setId_exc_katz(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				dockatz.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				dockatz.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoKatzDAO dockatzd = new DocumentoKatzDAO();
		dockatzd.insert(dockatz);
		System.out.println("Gravado Documento Katz");
	}
	public void popularDocumentoLawtonBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Lawton");
		
		DocumentoLawtonBean doclawton = new DocumentoLawtonBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_lawton".equals(entry.getKey().toString())) {
				doclawton.setId_exc_lawton(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				doclawton.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				doclawton.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoLawtonDAO doclawtond = new DocumentoLawtonDAO();
		doclawtond.insert(doclawton);
		System.out.println("Gravado Documento Lawton");
	}
	public void popularDocumentoQiBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento QI");
		
		DocumentoQiBean docqi = new DocumentoQiBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_qi".equals(entry.getKey().toString())) {
				docqi.setId_exc_qi(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docqi.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docqi.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoQiDAO docqid = new DocumentoQiDAO();
		docqid.insert(docqi);
		System.out.println("Gravado Documento QI");
	}
	public void popularDocumentoTiadlBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Tiadl");
		
		DocumentoTiadlBean doctiadl = new DocumentoTiadlBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_tiadl".equals(entry.getKey().toString())) {
				doctiadl.setId_exc_tiadl(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				doctiadl.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				doctiadl.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoTiadlDAO docqtiadl = new DocumentoTiadlDAO();
		docqtiadl.insert(doctiadl);
		System.out.println("Gravado Documento Tiadl");
	}
	public void popularDocumentoCogstateBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Cogstate");
		
		DocumentoCogstateBean doccogs = new DocumentoCogstateBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_cogstate".equals(entry.getKey().toString())) {
				doccogs.setId_exc_cogstate(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				doccogs.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				doccogs.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoCogstateDAO docqcogsd = new DocumentoCogstateDAO();
		docqcogsd.insert(doccogs);
		System.out.println("Gravado Documento Cogstate");
	}
	public void popularDocumentoMiniMentalBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Tiadl");
		
		DocumentoMiniMentalBean docmmb = new DocumentoMiniMentalBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_mini_mental".equals(entry.getKey().toString())) {
				docmmb.setId_exc_mini_mental(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docmmb.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docmmb.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoMiniMentalDAO docqmmd = new DocumentoMiniMentalDAO();
		docqmmd.insert(docmmb);
		System.out.println("Gravado Documento Mini Mental");
	}
	public void popularDocumentoRavltBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Ravlt");
		
		DocumentoRavltBean docravltb = new DocumentoRavltBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_ravlt".equals(entry.getKey().toString())) {
				docravltb.setId_exc_ravlt(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docravltb.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docravltb.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoRavltDAO docravltd = new DocumentoRavltDAO();
		docravltd.insert(docravltb);
		System.out.println("Gravado Documento Ravlt");
	}
	public void popularDocumentoCamcogBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Camcog");
		
		DocumentoCamcogBean doccamcogb = new DocumentoCamcogBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_camcog".equals(entry.getKey().toString())) {
				doccamcogb.setId_exc_camcog(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				doccamcogb.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				doccamcogb.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoCamcogDAO doccamcogd = new DocumentoCamcogDAO();
		doccamcogd.insert(doccamcogb);
		System.out.println("Gravado Documento Camcog");
	}
	public void popularDocumentoTrailMakingBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Trail Making");
		
		DocumentoTrailMakingBean doctmb = new DocumentoTrailMakingBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_trail_making".equals(entry.getKey().toString())) {
				doctmb.setId_exc_trail(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				doctmb.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				doctmb.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoTrailMakingDAO doctmd = new DocumentoTrailMakingDAO();
		doctmd.insert(doctmb);
		System.out.println("Gravado Documento Trail Making");
	}
	public void popularDocumentoWhoqolBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Whoqol");
		
		DocumentoWhoqolBean docwhob = new DocumentoWhoqolBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_whoqol".equals(entry.getKey().toString())) {
				docwhob.setId_exc_whoqol(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docwhob.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docwhob.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoWhoqolDAO docwhod = new DocumentoWhoqolDAO();
		docwhod.insert(docwhob);
		System.out.println("Gravado Documento Whoqol");
	}
	public void popularDocumentoFluenciaBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Fluencia");
		
		DocumentoFluenciaBean docfluenciab = new DocumentoFluenciaBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_fluencia".equals(entry.getKey().toString())) {
				docfluenciab.setId_exc_fluencia(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docfluenciab.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docfluenciab.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoFluenciaDAO docfluenciad = new DocumentoFluenciaDAO();
		docfluenciad.insert(docfluenciab);
		System.out.println("Gravado Documento Fluencia");
	}
	public void popularDocumentoTugBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Tug");
		
		DocumentoTugBean doctugb = new DocumentoTugBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_tug".equals(entry.getKey().toString())) {
				doctugb.setId_exc_tug(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				doctugb.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				doctugb.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoTugDAO docqtugd = new DocumentoTugDAO();
		docqtugd.insert(doctugb);
		System.out.println("Gravado Documento Tug");
	}
	public void popularDocumentoSubstanciaBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		System.out.println("Inicio Documento Substancia");
		
		DocumentoSubstanciaBean docsubstb = new DocumentoSubstanciaBean();
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if("id_exc_substancia".equals(entry.getKey().toString())) {
				docsubstb.setId_exc_substancia(new Integer(entry.getValue().toString()));
				continue;
			}
			if("responsavel".equals(entry.getKey().toString())) {
				docsubstb.setResponsavel(entry.getValue().toString());
				continue;
			}
			if("data_criacao".equals(entry.getKey().toString())) {
				docsubstb.setData_criacao(entry.getValue().toString());
				continue;
			}
		}
		DocumentoSubstanciaDAO docsubstd = new DocumentoSubstanciaDAO();
		docsubstd.insert(docsubstb);
		System.out.println("Gravado Documento Substancia");
	}
	public void popularSecaoExamesBD(Map mapaParametros, String nomePlanilha, Object[][] resultado) throws SQLException {
		//System.out.println("Inicio Seção Ipac");
		System.out.println("Inicio Seção dos Exames");
		String[] arrNomeExamesTxt = null;
		String lerMetodosExames = null;
		BufferedReader buffreader = Util.abrirArquivo();
		try {
			arrNomeExamesTxt = Util.lerNomeExamesTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//SecaoDocumentoIpacBean sdib = new SecaoDocumentoIpacBean();
		
		SecaoDocumentoExamesBean sdib = new SecaoDocumentoExamesBean();
		int linha = 0;
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if (arrNomeExamesTxt[contador_exames].equals(resultado[++linha][0]) && "exame".equals(entry.getKey().toString())) {
				if("id_doc".equals(entry.getKey().toString())) {
					sdib.setId_doc(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if("titulo".equals(entry.getKey().toString())) {
					sdib.setTitulo(entry.getValue().toString());
					continue;
				}
			}	
		}
		/* Java Reflection */
		
		AcademiaCerebroDAO acdcrbd = new AcademiaCerebroDAO();
		Class<?> cls = acdcrbd.getClass();
		
		//int index = 0;
		try {
			if ( (lerMetodosExames = buffreader.readLine()) != null ) {
				System.out.println("Metodo Lida = " + lerMetodosExames);
				Method inserirBD = cls.getMethod(lerMetodosExames, SecaoDocumentoExamesBean.class);
				inserirBD.invoke(acdcrbd, null);
				//index++;
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*SecaoDocumentoIpacDAO sdid = new SecaoDocumentoIpacDAO();
		sdid.insert(sdib);*/
		
		//System.out.println("Gravado Seção Ipac");
		System.out.println("Gravado Seção dos Exames");
	}
	
	public void popularSecaoGdsBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção GDS-15");
		
		SecaoDocumentoGdsBean sdgb = new SecaoDocumentoGdsBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_gds".equals(entry.getKey().toString())) {
				sdgb.setId_doc_gds(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdgb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoGdsDAO sdgd = new SecaoDocumentoGdsDAO();
		sdgd.insert(sdgb);
		
		System.out.println("Gravado Seção GDS-15");
	}
	public void popularSecaoKatzBD(Map mapaParametros) throws SQLException {
System.out.println("Inicio Seção Katz");
		
		SecaoDocumentoKatzBean sdkb = new SecaoDocumentoKatzBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_katz".equals(entry.getKey().toString())) {
				sdkb.setId_doc_katz(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdkb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoKatzDAO sdkd = new SecaoDocumentoKatzDAO();
		sdkd.insert(sdkb);
		
		System.out.println("Gravado Seção Katz");
	}
	public void popularSecaoLawtonBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Lawton");
		
		SecaoDocumentoLawtonBean sdlb = new SecaoDocumentoLawtonBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_lawton".equals(entry.getKey().toString())) {
				sdlb.setId_doc_lawton(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdlb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoLawtonDAO sdld = new SecaoDocumentoLawtonDAO();
		sdld.insert(sdlb);
		
		System.out.println("Gravado Seção Lawton");
	}
	public void popularSecaoQiBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção QI");
		
		SecaoDocumentoQiBean sdqb = new SecaoDocumentoQiBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_qi".equals(entry.getKey().toString())) {
				sdqb.setId_doc_qi(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdqb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoQiDAO sdqd = new SecaoDocumentoQiDAO();
		sdqd.insert(sdqb);
		
		System.out.println("Gravado Seção QI");
	}
	public void popularSecaoTiadlBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Tiadl");
		
		SecaoDocumentoTiadlBean sdtb = new SecaoDocumentoTiadlBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_tiadl".equals(entry.getKey().toString())) {
				sdtb.setId_doc_tiadl(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdtb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoTiadlDAO sdtd = new SecaoDocumentoTiadlDAO();
		sdtd.insert(sdtb);
		
		System.out.println("Gravado Seção Tiadl");
	}
	public void popularSecaoCogstateBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Cogstate");
		
		SecaoDocumentoCogstateBean sdcsb = new SecaoDocumentoCogstateBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_cogstate".equals(entry.getKey().toString())) {
				sdcsb.setId_doc_cogstate(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdcsb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoCogstateDAO sdcsd = new SecaoDocumentoCogstateDAO();
		sdcsd.insert(sdcsb);
		
		System.out.println("Gravado Seção Lawton");
	}
	public void popularSecaoMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Mini Mental");
		
		SecaoDocumentoMiniMentalBean sdmmb = new SecaoDocumentoMiniMentalBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_mini_mental".equals(entry.getKey().toString())) {
				sdmmb.setId_doc_mini_mental(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdmmb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoMiniMentalDAO sdmmd = new SecaoDocumentoMiniMentalDAO();
		sdmmd.insert(sdmmb);
		
		System.out.println("Gravado Seção Mini Mental");
	}
	public void popularListaRavltBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Lista Ravlt");
		
		ListaRavltBean sdrvb = new ListaRavltBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_ravlt".equals(entry.getKey().toString())) {
				sdrvb.setId_doc_ravlt(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdrvb.setNome(entry.getValue().toString());
				continue;
			}
		}
		
		ListaRavltDAO sdrvd = new ListaRavltDAO();
		sdrvd.insert(sdrvb);
		
		System.out.println("Gravado Lista Ravlt");
	}
	public void popularSecaoCamcogBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Camcog");
		
		SecaoDocumentoCamcogBean sdcgb = new SecaoDocumentoCamcogBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_camcog".equals(entry.getKey().toString())) {
				sdcgb.setId_doc_camcog(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdcgb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoCamcogDAO sdcgd = new SecaoDocumentoCamcogDAO();
		sdcgd.insert(sdcgb);
		
		System.out.println("Gravado Seção Camcog");
	}
	public void popularSecaoTrailMakingBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Trail Making");
		
		SecaoDocumentoTrailMakingBean sdtmkb = new SecaoDocumentoTrailMakingBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_trail".equals(entry.getKey().toString())) {
				sdtmkb.setId_doc_trail(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdtmkb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoTrailMakingDAO sdtmkd = new SecaoDocumentoTrailMakingDAO();
		sdtmkd.insert(sdtmkb);
		
		System.out.println("Gravado Seção Trail Making");
	}
	public void popularSecaoWhoqolBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Whoqol");
		
		SecaoDocumentoWhoqolBean sdwhob = new SecaoDocumentoWhoqolBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_whoqol".equals(entry.getKey().toString())) {
				sdwhob.setId_doc_whoqol(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdwhob.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoWhoqolDAO sdwhod = new SecaoDocumentoWhoqolDAO();
		sdwhod.insert(sdwhob);
		
		System.out.println("Gravado Seção Whoqol");
	}
	public void popularSecaoFluenciaBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Fluencia");
		
		SecaoDocumentoFluenciaBean sdflub = new SecaoDocumentoFluenciaBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_fluencia".equals(entry.getKey().toString())) {
				sdflub.setId_doc_fluencia(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdflub.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoFluenciaDAO sdflud = new SecaoDocumentoFluenciaDAO();
		sdflud.insert(sdflub);
		
		System.out.println("Gravado Seção Fluencia");
	}
	public void popularSecaoTugBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Seção Tug");
		
		SecaoDocumentoTugBean sdtugb = new SecaoDocumentoTugBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if("id_doc_tug".equals(entry.getKey().toString())) {
				sdtugb.setId_doc_tug(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if("titulo".equals(entry.getKey().toString())) {
				sdtugb.setTitulo(entry.getValue().toString());
				continue;
			}
		}
		
		SecaoDocumentoTugDAO sdtugd = new SecaoDocumentoTugDAO();
		sdtugd.insert(sdtugb);
		
		System.out.println("Gravado Seção Tug");
	}
	public void popularItemSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("Inicio Item Substancia");
		ItemSubstanciaBean itsb = new ItemSubstanciaBean();
		Object[] obj = mapaParametros.values().toArray();
		Integer id_doc_substancia = new Integer(obj[0].toString());
		System.out.println("id_doc_substancia = " + id_doc_substancia);
		itsb.setId_doc_substancia(id_doc_substancia);
		ItemSubstanciaDAO itsd = new ItemSubstanciaDAO();
		itsd.insert(itsb);
		System.out.println("Gravado Item Substancia");
	}
	public void popularQuestaoGdsBD(Map mapaParametros, String nome) throws SQLException {
		if("GDS".equals(nome)) {
			System.out.println("Iniciar Questão GDS-15");
			
			QuestaoGdsBean qgdsb = new QuestaoGdsBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_secao_gds".equals(entry.getKey().toString()) ) {
					qgdsb.setId_secao_gds(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "pergunta".equals(entry.getKey().toString()) ) {
					qgdsb.setPergunta(entry.getValue().toString());
					continue;
				}
			}
			// Classe de Persistência DAO
			QuestaoGdsDAO qgdsd = new QuestaoGdsDAO();
			qgdsd.insert(qgdsb);
			System.out.println("Gravado Questão GDS-15");
		}
	}
	public void popularAvaliacaoQuestaoGdsBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Questão GDS-15");
		
		AvaliacaoQuestaoGdsBean aqgdsb = new AvaliacaoQuestaoGdsBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aqgdsb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_questao_gds".equals(entry.getKey().toString()) ) {
				aqgdsb.setId_questao_gds(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aqgdsb.setResposta_questao_gds(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoQuestaoGdsDAO aqgdsd = new AvaliacaoQuestaoGdsDAO();
		aqgdsd.insert(aqgdsb);
		System.out.println("Gravado Avaliação Questão GDS-15");
	}
	public void popularQuestaoKatzBD(Map mapaParametros, String nome) throws SQLException {
		if ("KATZ".equals(nome)) {
			System.out.println("Iniciar Questão Katz");
			
			QuestaoKatzBean qkb = new QuestaoKatzBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_secao_katz".equals(entry.getKey().toString()) ) {
					qkb.setId_secao_katz(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "pergunta".equals(entry.getKey().toString()) ) {
					qkb.setPergunta(entry.getValue().toString());
					continue;
				}
			}
			// Classe de Persistência DAO
			QuestaoKatzDAO qkd = new QuestaoKatzDAO();
			qkd.insert(qkb);
			System.out.println("Gravado Questão Katz");
		}	
	}
	public void popularAvaliacaoQuestaoKatzBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Questão Katz");
		
		AvaliacaoQuestaoKatzBean aqkb = new AvaliacaoQuestaoKatzBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aqkb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_questao_katz".equals(entry.getKey().toString()) ) {
				aqkb.setId_questao_katz(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aqkb.setResposta_questao_katz(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoQuestaoKatzDAO aqkd = new AvaliacaoQuestaoKatzDAO();
		aqkd.insert(aqkb);
		System.out.println("Gravado Avaliação Questão Katz");
	}
	public void popularQuestaoLawtonBD(Map mapaParametros, String nome) throws SQLException {
		if ( "LAWTON".equals(nome) ) {
			System.out.println("Iniciar Questão Lawton");
			
			QuestaoLawtonBean qlwb = new QuestaoLawtonBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_secao_lawton".equals(entry.getKey().toString()) ) {
					qlwb.setId_secao_lawton(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "pergunta".equals(entry.getKey().toString()) ) {
					qlwb.setPergunta(entry.getValue().toString());
					continue;
				}
			}
			// Classe de Persistência DAO
			QuestaoLawtonDAO qlwd = new QuestaoLawtonDAO();
			qlwd.insert(qlwb);
			System.out.println("Gravado Questão Lawton");
		}
	
	}
	public void popularAvaliacaoQuestaoLawtonBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Questão Lawton");
		
		AvaliacaoQuestaoLawtonBean aqlwb = new AvaliacaoQuestaoLawtonBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aqlwb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_questao_lawton".equals(entry.getKey().toString()) ) {
				aqlwb.setId_questao_lawton(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aqlwb.setResposta_questao_lawton(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoQuestaoLawtonDAO aqlwd = new AvaliacaoQuestaoLawtonDAO();
		aqlwd.insert(aqlwb);
		System.out.println("Gravado Avaliação Questão Lawton");
	}
	public void popularQuestaoQiBD(Map mapaParametros, String nome) throws SQLException {
		if ("QI".equals(nome)) {
			System.out.println("Iniciar Questão QI");
			
			QuestaoQiBean qqib = new QuestaoQiBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_secao_qi".equals(entry.getKey().toString()) ) {
					qqib.setId_secao_qi(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "pergunta".equals(entry.getKey().toString()) ) {
					qqib.setPergunta(entry.getValue().toString());
					continue;
				}
			}
			// Classe de Persistência DAO
			QuestaoQiDAO qqid = new QuestaoQiDAO();
			qqid.insert(qqib);
			System.out.println("Gravado Questão QI");
		}
	
	}
	public void popularAvaliacaoQuestaoQiBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Questão QI");
		
		AvaliacaoQuestaoQiBean aqqib = new AvaliacaoQuestaoQiBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aqqib.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_questao_gds".equals(entry.getKey().toString()) ) {
				aqqib.setId_questao_qi(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aqqib.setResposta_questao_qi(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoQuestaoQiDAO aqqid = new AvaliacaoQuestaoQiDAO();
		aqqid.insert(aqqib);
		System.out.println("Gravado Avaliação Questão QI");
	}
	public void popularAcaoTiadlBD(Map mapaParametros, String nome) throws SQLException {
		if ( "ACAO_TIADL".equals(nome) ) {
			System.out.println("Iniciar Ação Tiadl");
			
			AcaoTiadlBean atdb = new AcaoTiadlBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_questao_tiadl".equals(entry.getKey().toString()) ) {
					atdb.setId_questao_tiadl(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "descricao_acao".equals(entry.getKey().toString()) ) {
					atdb.setDescricao_acao(entry.getValue().toString());
					continue;
				}
			}
			// Classe de Persistência DAO
			AcaoTiadlDAO atdd = new AcaoTiadlDAO();
			atdd.insert(atdb);
			System.out.println("Gravado Ação Tiadl");
		}
	}
	public void popularAvaliacaoAcaoTiadlBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Ação Tiadl");
		
		AvaliacaoAcaoTiadlBean aatdb = new AvaliacaoAcaoTiadlBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aatdb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_questao_gds".equals(entry.getKey().toString()) ) {
				aatdb.setId_acao_tiadl(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aatdb.setTempo_execucao_acao(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoAcaoTiadlDAO aatdd = new AvaliacaoAcaoTiadlDAO();
		aatdd.insert(aatdb);
		System.out.println("Gravado Avaliação Ação Tiadl");
	}
	public void popularQuestaoTiadlBD(Map mapaParametros, String nome) throws SQLException {
		if ("TIADL".equals(nome)) {
		
			System.out.println("Iniciar Questão Tiadl+Dafs");
			
			QuestaoTiadlBean qtdb = new QuestaoTiadlBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_secao_tiadl".equals(entry.getKey().toString()) ) {
					qtdb.setId_secao_tiadl(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "titulo".equals(entry.getKey().toString()) ) {
					qtdb.setTitulo(entry.getValue().toString());
					continue;
				}
			}
			// Classe de Persistência DAO
			QuestaoTiadlDAO qtdd = new QuestaoTiadlDAO();
			qtdd.insert(qtdb);
			System.out.println("Gravado Questão Tiadl+Dafs");
		}
	
	}
	public void popularQuestaoWhoqolBD(Map mapaParametros, String nome) throws SQLException {
		if("WHOQOL".equals(nome)) {
			System.out.println("Iniciar Questão Whoqol");
			
			QuestaoWhoqolBean qwlb = new QuestaoWhoqolBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_secao_whoqol".equals(entry.getKey().toString()) ) {
					qwlb.setId_secao_whoqol(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "pergunta".equals(entry.getKey().toString()) ) {
					qwlb.setPergunta(entry.getValue().toString());
					continue;
				}
			}
			// Classe de Persistência DAO
			QuestaoWhoqolDAO qwld = new QuestaoWhoqolDAO();
			qwld.insert(qwlb);
			System.out.println("Gravado Questão Whoqol");
		}
	}
	public void popularAvaliacaoQuestaoWhoqolBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Questão Whoqol");
		
		AvaliacaoQuestaoWhoqolBean aqwlb = new AvaliacaoQuestaoWhoqolBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aqwlb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_questao_whoqol".equals(entry.getKey().toString()) ) {
				aqwlb.setId_questao_whoqol(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aqwlb.setReposta_questao_whoqol(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoQuestaoWhoqolDAO aqwld = new AvaliacaoQuestaoWhoqolDAO();
		aqwld.insert(aqwlb);
		System.out.println("Gravado Avaliação Questão Whoqol");
	}
	public void popularItemMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Item Mini Mental");
		ItemMiniMentalBean itmmb = new ItemMiniMentalBean();
		Object[] obj = mapaParametros.values().toArray();
		Integer id_secao_mini_mental = new Integer(obj[0].toString());
		System.out.println("Id_secao_mini_mental = " + id_secao_mini_mental);
		itmmb.setId_secao_mini_mental(id_secao_mini_mental);
		// Classe de Persistência DAO
		ItemMiniMentalDAO itmmd = new ItemMiniMentalDAO();
		itmmd.insert(itmmb);
		System.out.println("Gravado Item Mini Mental");
	
	}
	public void popularAvaliacaoItemMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Item Mini Mental");
		
		AvaliacaoItemMiniMentalBean aitmmb = new AvaliacaoItemMiniMentalBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aitmmb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_item_mini_mental".equals(entry.getKey().toString()) ) {
				aitmmb.setId_item_mini_mental(new Integer(entry.getValue().toString()));
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoItemMiniMentalDAO aitmmd = new AvaliacaoItemMiniMentalDAO();
		aitmmd.insert(aitmmb);
		System.out.println("Gravado Avaliação Item Mini Mental");
	}
	public void popularQuestaoMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Questão Mini Mental");
		
		QuestaoMiniMentalBean qmmb = new QuestaoMiniMentalBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_item_mm".equals(entry.getKey().toString()) ) {
				qmmb.setId_item_mm(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "texto".equals(entry.getKey().toString()) ) {
				qmmb.setTexto(entry.getValue().toString());
				continue;
			}
			
			if ( "resp_esperado".equals(entry.getKey().toString()) ) {
				qmmb.setResp_esperado(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		QuestaoMiniMentalDAO qmmd = new QuestaoMiniMentalDAO();
		qmmd.insert(qmmb);
		System.out.println("Gravado Questão Mini Mental");
	}
	public void popularCalculoMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Calculo Mini Mental");
		
		CalculoMiniMentalBean cmmb = new CalculoMiniMentalBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_item_mm".equals(entry.getKey().toString()) ) {
				cmmb.setId_item_mm(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "instrucao".equals(entry.getKey().toString()) ) {
				cmmb.setInstrucao(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		CalculoMiniMentalDAO cmmd = new CalculoMiniMentalDAO();
		cmmd.insert(cmmb);
		System.out.println("Gravado Calculo Mini Mental");
	}
	public void popularEscolhaMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Escolha Mini Mental");
		
		EscolhaMiniMentalBean emmb = new EscolhaMiniMentalBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_item_mm".equals(entry.getKey().toString()) ) {
				emmb.setId_item_mm(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "texto".equals(entry.getKey().toString()) ) {
				emmb.setTexto(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		EscolhaMiniMentalDAO emmd = new EscolhaMiniMentalDAO();
		emmd.insert(emmb);
		System.out.println("Gravado Escolha Mini Mental");
	}
	public void popularIteracaoMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Iteração Mini Mental");
		
		IteracaoMiniMentalBean immb = new IteracaoMiniMentalBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_calc_mini_mental".equals(entry.getKey().toString()) ) {
				immb.setId_calc_mini_mental(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "valor_esperado".equals(entry.getKey().toString()) ) {
				immb.setValor_esperado(new Float(entry.getValue().toString()));
				continue;
			}
			
			if ( "pontuacao".equals(entry.getKey().toString()) ) {
				immb.setPontuacao(new Integer(entry.getValue().toString()));
				continue;
			}
		}
		// Classe de Persistência DAO
		IteracaoMiniMentalDAO immd = new IteracaoMiniMentalDAO();
		immd.insert(immb);
		System.out.println("Gravado Iteração Mini Mental");
	}
	public void popularOpcaoMiniMentalBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Opcao Mini Mental");
		
		OpcaoMiniMentalBean ommb = new OpcaoMiniMentalBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_esc_mini_mental".equals(entry.getKey().toString()) ) {
				ommb.setId_esc_mini_mental(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "is_correct".equals(entry.getKey().toString()) ) {
				ommb.setIs_correct(new Boolean(entry.getValue().toString()));
				continue;
			}
		}
		// Classe de Persistência DAO
		OpcaoMiniMentalDAO ommd = new OpcaoMiniMentalDAO();
		ommd.insert(ommb);
		System.out.println("Gravado Opção Mini Mental");
	}
	public void popularItemRavltBD(Map mapaParametros, String nome) throws SQLException {
		if ("ITEM_RAVLT".equals(nome)) {
			
			System.out.println("Iniciar Item Ravlt");
			
			ItemRavltBean itrlvb = new ItemRavltBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_lista_ravlt".equals(entry.getKey().toString()) ) {
					itrlvb.setId_lista_ravlt(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "titulo".equals(entry.getKey().toString()) ) {
					itrlvb.setTitulo(entry.getValue().toString());
					continue;
				}
				
			}
			// Classe de Persistência DAO
			ItemRavltDAO itrlvd = new ItemRavltDAO();
			itrlvd.insert(itrlvb);
			System.out.println("Gravado Item Ravlt");
		}
	}
	public void popularItemAprendizagemRavltBD(Map mapaParametros, String nome) throws SQLException {
		if ("ITEM_APRENDIZAGEM_RAVLT".equals(nome)) {
		
			System.out.println("Iniciar Item Aprendizagem Ravlt");
			
			ItemAprendizagemRavltBean itarlvb = new ItemAprendizagemRavltBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_item_ravlt".equals(entry.getKey().toString()) ) {
					itarlvb.setId_item_ravlt(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "descricao".equals(entry.getKey().toString()) ) {
					itarlvb.setDescricao(entry.getValue().toString());
					continue;
				}
				
			}
			// Classe de Persistência DAO
			ItemAprendizagemRavltDAO itarlvd = new ItemAprendizagemRavltDAO();
			itarlvd.insert(itarlvb);
			System.out.println("Gravado Item Aprendizagem Ravlt");
		}	
	}
	public void popularAvaliacaoItemAprendizagemRavltBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Item Aprendizagem Ravlt");
		
		AvaliacaoItemAprendizagemRavltBean aitarlvb = new AvaliacaoItemAprendizagemRavltBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aitarlvb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_item_aprendizagem".equals(entry.getKey().toString()) ) {
				aitarlvb.setId_item_aprendizagem_ravlt(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aitarlvb.setResposta(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoItemAprendizagemRavltDAO aitarlvd = new AvaliacaoItemAprendizagemRavltDAO();
		aitarlvd.insert(aitarlvb);
		System.out.println("Gravado Avaliação Item Aprendizagem Ravlt");
	}
	public void popularAtividadeCamcogBD(Map mapaParametros, String nome) throws SQLException {
		if ("ATIVIDADE_CAMCOG".equals(nome)) {
			System.out.println("Iniciar Atividade Camcog");
			
			AtividadeCamcogBean acgb = new AtividadeCamcogBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "id_secao_camcog".equals(entry.getKey().toString()) ) {
					acgb.setId_secao_camcog(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "descricao".equals(entry.getKey().toString()) ) {
					acgb.setDescricao(entry.getValue().toString());
					continue;
				}
				
			}
			// Classe de Persistência DAO
			AtividadeCamcogDAO acgd = new AtividadeCamcogDAO();
			acgd.insert(acgb);
			System.out.println("Gravado Atividade Camcog");
		}
	}
	public void popularAvaliacaoAtividadeCamcogBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Atividade Camcog");
		
		AvaliacaoAtividadeCamcogBean aacgb = new AvaliacaoAtividadeCamcogBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aacgb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_atividade_camcog".equals(entry.getKey().toString()) ) {
				aacgb.setId_atividade_camcog(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "resposta".equals(entry.getKey().toString()) ) {
				aacgb.setResposta(entry.getValue().toString());
				continue;
			}
			
			if ( "score".equals(entry.getKey().toString()) ) {
				aacgb.setScore(new Integer(entry.getValue().toString()));
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoAtividadeCamcogDAO aacgd = new AvaliacaoAtividadeCamcogDAO();
		aacgd.insert(aacgb);
		System.out.println("Gravado Avaliação Atividade Camcog");
	}
	public void popularAtividadeCogstateBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Atividade Cogstate");
		
		AtividadeCogstateBean acsb = new AtividadeCogstateBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_secao_cogstate".equals(entry.getKey().toString()) ) {
				acsb.setId_secao_cogstate(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "descricao_teste".equals(entry.getKey().toString()) ) {
				acsb.setDescricao_teste(entry.getValue().toString());
				continue;
			}
			
		}
		// Classe de Persistência DAO
		AtividadeCogstateDAO acsd = new AtividadeCogstateDAO();
		acsd.insert(acsb);
		System.out.println("Gravado Atividade Cogstate");
	}
	public void popularAvaliacaoAtividadeCogstateBD(Map mapaParametros) throws SQLException {
		System.out.println("Iniciar Avaliação Atividade Cogstate");
		
		AvaliacaoAtividadeCogstateBean aacsb = new AvaliacaoAtividadeCogstateBean();
		
		Set set = mapaParametros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			if ( "id_avaliacao".equals(entry.getKey().toString()) ) {
				aacsb.setId_avaliacao(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "id_atividade_cogstate".equals(entry.getKey().toString()) ) {
				aacsb.setId_atividade_cogstate(new Integer(entry.getValue().toString()));
				continue;
			}
			
			if ( "data_teste_realizado".equals(entry.getKey().toString()) ) {
				aacsb.setData_teste_realizado(entry.getValue().toString());
				continue;
			}
		}
		// Classe de Persistência DAO
		AvaliacaoAtividadeCogstateDAO aacsd = new AvaliacaoAtividadeCogstateDAO();
		aacsd.insert(aacsb);
		System.out.println("Gravado Avaliação Atividade Cogstate");
	}
	
	public void popularAvaliacaoPacienteBD(Map mapaParametros, String nomePlanilha) throws SQLException {
		if ( "AVALIACAO_PACIENTE".equals(nomePlanilha) ) {
			System.out.println("Iniciar processo de gravação da tabela Avaliacao_Paciente");
			
			//Trocar aspas("\") do nome do jogo na planilha excel(dataSet) com espaço (")
			String stdTrail_a_b = null;
			
			AvaliacaoPacienteBean avalPacBean = new AvaliacaoPacienteBean();
			
			Set set = mapaParametros.entrySet();
			Iterator it = set.iterator();
			while ( it.hasNext() ) {
				Map.Entry entry = (Map.Entry) it.next();
				
				if ( "trail_a".equals(entry.getKey().toString()) ) {
					avalPacBean.setTrail_a((entry.getValue().toString()).replaceAll("\"", ""));
					continue;
				}
				
				if ( "trail_a_segundos".equals(entry.getKey().toString()) ) {
					avalPacBean.setTrail_a_segundos(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "hits".equals(entry.getKey().toString()) ) {
					avalPacBean.setHits(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "cr".equals(entry.getKey().toString()) ) {
					avalPacBean.setCr(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "trail_b".equals(entry.getKey().toString()) ) {
					avalPacBean.setTrail_b((entry.getValue().toString()).replaceAll("\"", ""));
					continue;
				}
				
				if ( "trail_b_segundos".equals(entry.getKey().toString()) ) {
					avalPacBean.setTrail_b_segundos(new Integer(entry.getValue().toString()));
					continue;
				}
				
				if ( "fluencia".equals(entry.getKey().toString()) ) {
					avalPacBean.setFluencia(new Integer(entry.getValue().toString()));
					continue;
				}
			}
			
			AvaliacaoPacienteDAO avalPacienteDao = new AvaliacaoPacienteDAO();
			avalPacienteDao.insert(avalPacBean);
			
			System.out.println("Finalizar processo de gravação da tabela Avaliacao_Paciente");
		}
	}
	
	
	public void popularAtividadeFluenciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAvaliacaoAtividadeFluenciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAtividadeIpacBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAvaliacaoAtividadeIpacBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAtividadeTrailMakingBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAvaliacaoAtividadeTrailMakingBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAtividadeTugBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAvaliacaoAtividadeTugBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAvaliacaoDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularCafeinaDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularCrackDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularCigarroDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularCocainaDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAlcoolDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularHeroinaDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularMaconhaDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularLsdDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularExtaseDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularChaCogumeloDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAnfetaminaDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularColaDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularEstimulanteDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularGasolinaDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularTranquilizanteDrogaSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularMedicamentoSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularAvaliacaoMedicamentoSubstanciaBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularTipoAvaliacaoBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	public void popularTipoAvaliacaoPacienteBD(Map mapaParametros) throws SQLException {
		System.out.println("");
	}
	
}
