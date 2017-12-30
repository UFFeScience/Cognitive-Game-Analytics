package academia_cerebro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import academia_cerebro.util.ExportaCSV;
import academia_cerebro.util.PropertiesFiles;
import academia_cerebro.util.Util;
import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ProcessarDadosExcel {
	
	private transient Workbook wb;
	private Sheet st;
	private transient Object[][] resultado;
	// Criar um contador de InstÃ¢ncia
	private static int countObj = 0;
	private String[] ext;
	private InputStream isPath;
	private InputStream isPathCorrigido;
	private Connection conn;
		
	public ProcessarDadosExcel(File path) throws IOException {
		countObj++;
		String[] numDatasetsComErr = obterNumDatasetsErr();
		String caminhoDoArqCorrigido = null;
		File pathArqCorrigido = null;
		File pathAtual = new File(path.toString());
		System.out.println("countObj = " + countObj + "\n" + path + "\n" + path.toString() + "\n" + pathAtual);
		// \\W+ -> uma ou mais ocorrÃªncias (+) de tudo que nÃ£o seja um caractere de palavra. Por exemplo: "\", "-", "espaÃ§o"etc.
		String std = path.toString().replaceAll("\\W+", "#");
		System.out.println("STD = " + std);
		ext = std.split("#");
		System.out.println("ExtensÃ£o do Arquivo Lida = " + ext.length + "\t ext: " + ext[ext.length - 4]);
		if("csv".equals(ext[ext.length - 1])) {
			// Chama mÃ©todo que converte CSV para Excel(xls)
			try {
				isPath = new FileInputStream(pathAtual);
				/* ext[ext.length - 2] -> Numero do Paciente */
				/* Comentar esse bloco de cÃ³digo provisoriamente, jÃ¡ que o nome dos jogos jÃ¡ foram corrigidos */
				/* Verifico a ReferÃªncia (Apontador) da variÃ¡vel de referÃªncia numDatasetsComErr que se apontar para um Ã¡rea de memÃ³ria diferente de null, executa o bloco for. */
				for(int index = 0; index < numDatasetsComErr.length; index++) {
					if (numDatasetsComErr[index].equals(ext[ext.length - 2])) {
						System.out.println("Path : " + path.toString());
						caminhoDoArqCorrigido = corrigirNomeJogo(path.toString(), ext[ext.length - 2]);
						pathArqCorrigido = new File(caminhoDoArqCorrigido);
						isPathCorrigido = new FileInputStream(pathArqCorrigido);
						// O objeto isPath passa a apontar(Referenciar) para onde o objeto isPathCorrigido aponta(Referencia na memoria). 
						isPath = isPathCorrigido;
					}
				}
				ler_csv_escreve_xls(isPath, ext[ext.length - 2]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null,  pathAtual.toString(), null, JOptionPane.PLAIN_MESSAGE);
			//inicio_xls(pathAtual);
		}	
	}
	
	public String[] obterNumDatasetsErr() {
		String[] numDatasetsComErr = {"41","46","54","62","64","70","84","24","28","37","38","51","55","58","71","74","76"};
		return numDatasetsComErr;
	}
	
	public String corrigirNomeJogo(String isPath, String numParticipante) throws IOException {
		CorrigirErroDataset corrErrDts = new CorrigirErroDataset();
		String caminhoDoArqCorrigido;
		try {
			caminhoDoArqCorrigido = corrErrDts.corrigirErroDataSetBrainHq(isPath);
			return caminhoDoArqCorrigido;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void ler_csv_escreve_xls(InputStream isPath, String numParticipante) throws Exception {
		String lerLinhaArqCsv;
		String path = null;
		BufferedReader bfrPath = new BufferedReader(new InputStreamReader(isPath));
		ArrayList<String> cadaItemLidoArqCsv = null;
		ArrayList<ArrayList<String>> todosItensLidosArqCsv = null;		
		todosItensLidosArqCsv = new ArrayList<ArrayList<String>>();
		
		while((lerLinhaArqCsv = bfrPath.readLine()) != null) {
			cadaItemLidoArqCsv = new ArrayList<String>();
			String[] strItemCsv = lerLinhaArqCsv.split(","); //Gera 15 colunas
			int indexInterno = 0;
			while(indexInterno < strItemCsv.length) {
				cadaItemLidoArqCsv.add(strItemCsv[indexInterno]);
				indexInterno++;
			}
			//Como se fosse uma matriz
			todosItensLidosArqCsv.add(cadaItemLidoArqCsv);
		}
		
		/* INÃ�CIO DA LEITURA DA PLANILHA EXCEL */
		HSSFWorkbook hwbk = new HSSFWorkbook();
		HSSFSheet sht = hwbk.createSheet(numParticipante);
		String[] arrNomeJogosTxt = lerNomeJogosTxt();
		String std = null;
		// Linha
		for(int k=0; k < todosItensLidosArqCsv.size(); k++) {
			ArrayList<String> dadosCsv = (ArrayList<String>) todosItensLidosArqCsv.get(k);
			System.out.println("Tam DadosCSV = " + dadosCsv.size());
			HSSFRow rowXls = sht.createRow((short) 0 + k);
			
			HSSFCell celulaNovaId_PacienteXls = null;
			HSSFCell celulaNovaId_JogoXls = null;
			HSSFCell celulaNovaHoraXls = null;
			HSSFCell celulaNovaId_AvaliacaoXls = null;
			/* A cada linha k, criarei as cÃ©lulas(Colunas) de nÃºmero 15 e 16 e irei populando com valores. */
			celulaNovaId_PacienteXls = rowXls.createCell(15);
			celulaNovaId_JogoXls = rowXls.createCell(16);
			celulaNovaHoraXls = rowXls.createCell(17);
			celulaNovaId_AvaliacaoXls = rowXls.createCell(18);
			/* Inserindo Dados na nova cÃ©lula */
			if (k == 0) {
				celulaNovaId_PacienteXls.setCellValue("id_paciente");
				celulaNovaId_JogoXls.setCellValue("id_jogo");
				celulaNovaHoraXls.setCellValue("hora");
				celulaNovaId_AvaliacaoXls.setCellValue("id_avaliacao");
			}
			
			/* Preencher Dinamicamente os Campos id_paciente & id_jogo - InclusÃ£o no fim da lista-planilha*/
			if ( k > 0 && k < todosItensLidosArqCsv.size() ) {
				celulaNovaId_PacienteXls.setCellValue(numParticipante);
				//Trocar aspas("\") do nome do jogo na planilha excel(dataSet) com espaÃ§o (")
				String stdNomeJogo = (dadosCsv.get(0).toString()).replaceAll("\"", "");
				System.out.println("stdNomeJogo = " + stdNomeJogo);
				for(int i = 0; i < arrNomeJogosTxt.length; i++) {	
					if ( arrNomeJogosTxt[i].trim().equals(stdNomeJogo.trim()) ) {	
						System.out.println("arrNomeJogosTxt = " + arrNomeJogosTxt[i]);
						// Escreve em cada nova cÃ©lula criada do excel o id do jogo, considerando os 29 jogos existentes. 
						celulaNovaId_JogoXls.setCellValue(++i);
						break;
					}
				}
				/* Preencher Dinamicamente o Campo Hora - InclusÃ£o no fim da lista-planilha*/
				Workbook wbLookXLS = null;
				Sheet st;
				String stdDataSemAspasXLS = null;
				/* Pegar o Valor do campo Hora */
				String stdDataSemAspasCSV = (dadosCsv.get(9).toString()).replaceAll("\"", "");
				System.out.println("stdDataSemAspasCSV: " + stdDataSemAspasCSV);
				//String pathHora = "/Volumes/Seagate_Expansion_3TB_5_1_4/01 - Mestrado UFF/01-PostgreSQL e Java/Desenv/Java/01-Materiais para Popular as Tabelas/DataSets/dados/pacientes/hora/" + numParticipante + ".xls";
				String pathHora = PropertiesFiles.getProp().getProperty("prop.path.datasets.dados.pacientes.hora") + numParticipante + ".xls";
				try {
					wbLookXLS = Workbook.getWorkbook(new File(pathHora));
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        st = wbLookXLS.getSheet(0);
		        Map<Object, Object> olharHoraXLS = lerNomeHoraMapCorretamente(wbLookXLS, st);
		        Set<Entry<Object, Object>> set = olharHoraXLS.entrySet();
		        Iterator<Entry<Object, Object>> it = set.iterator();
		        while(it.hasNext()) {
		        	Map.Entry<Object, Object> entry = it.next();
		        	stdDataSemAspasXLS = (entry.getKey().toString()).replace('\'', ' '); //.replaceAll("\"", "");
		        	System.out.println("stdDataSemAspasXLS: " + stdDataSemAspasXLS);
		        	if (stdDataSemAspasCSV.equals(stdDataSemAspasXLS.trim())) {
		        		if ( entry.getValue() != null ) { 
		        			celulaNovaHoraXls.setCellValue(entry.getValue().toString());
		        		} else {
		        			String valorHora = null;
		        			celulaNovaHoraXls.setCellValue(valorHora);
		        		}
		        		break;
		        	}
		        }
		        /* Preencher Dinamicamente o Campo id_avaliacao - InclusÃ£o no fim da lista-planilha*/
				wbLookXLS = null;
				st = null;
				stdDataSemAspasXLS = null;
				System.out.println("stdDataSemAspasCSV: " + stdDataSemAspasCSV);
				//String pathIdAvaliacao = "/Volumes/Seagate_Expansion_3TB_5_1_4/01 - Mestrado UFF/01-PostgreSQL e Java/Desenv/Java/01-Materiais para Popular as Tabelas/DataSets/dados/pacientes/idavaliacao/" + numParticipante + ".xls";
				String pathIdAvaliacao = PropertiesFiles.getProp().getProperty("prop.path.datasets.dados.pacientes.idavaliacao") + numParticipante + ".xls";
				try {
					wbLookXLS = Workbook.getWorkbook(new File(pathIdAvaliacao));
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        st = wbLookXLS.getSheet(0);
		        Map<Object, Object> olharIdAvaliacaoXls = lerNomeIdAvaliacaoMapCorretamente(wbLookXLS, st);
		        Set<Entry<Object, Object>> setOlharIdAvaliacaoXls = olharIdAvaliacaoXls.entrySet();
		        Iterator<Entry<Object, Object>> itOlharIdAvaliacaoXls = setOlharIdAvaliacaoXls.iterator();
		        while(itOlharIdAvaliacaoXls.hasNext()) {
		        	Map.Entry<Object, Object> entry = itOlharIdAvaliacaoXls.next();
		        	stdDataSemAspasXLS = (entry.getKey().toString()).replace('\'', ' '); //.replaceAll("\"", "");
		        	System.out.println("stdDataSemAspasXLS: " + stdDataSemAspasXLS);
		        	if (stdDataSemAspasCSV.equals(stdDataSemAspasXLS.trim())) {
		        		if ( entry.getValue() != null ) { 
		        			celulaNovaId_AvaliacaoXls.setCellValue(entry.getValue().toString());
		        		} else {
		        			String valorIdAvaliacao = null;
		        			celulaNovaId_AvaliacaoXls.setCellValue(valorIdAvaliacao);
		        		}
		        		break;
		        	}
		        }
			}	
			
			// CÃ©lula Linha ArrayList[0] => Colunas(CÃ©lulas) ArrayList[0,1,2,...,l] -> Simula uma Matriz DinÃ¢mica, usando estrutura de dados ArrayList
			for(int l=0; l < dadosCsv.size();l++) {
				System.out.println("DadosCSV = " + dadosCsv.get(l));
				/* Criando Novas CÃ©lulas -> IrÃ¡ Preencher a partir da 2Âª CÃ©lula */
				HSSFCell celulaXls = rowXls.createCell((short) l);
				if ( "local_date".equals(dadosCsv.get(l).toString()) ) {
					std = dadosCsv.get(l).toString().replace("local_date", "data_local");
					celulaXls.setCellValue(std);
					continue;
				}
				if ( "timestamp".equals(dadosCsv.get(l).toString()) ) {
					std = dadosCsv.get(l).toString().replace("timestamp", "tempo");
					celulaXls.setCellValue(std);
					continue;
				}
				// Atribuo valores do tipo String, para cada valor lido da posiÃ§Ã£o X da Lista(dadosCsv), em cada cÃ©lula da planilha 	
				celulaXls.setCellValue(dadosCsv.get(l).toString());
			}
		}
		System.out.println("ext[" + (ext.length - 2) + "] = " + ext[ext.length - 2]);
		
		if("Schedule1".equals(ext[ext.length - 4]) || "Schedule2".equals(ext[ext.length - 4])) {
			//path = "/Volumes/Seagate_Expansion_3TB_5_1_4/01 - Mestrado UFF/01-PostgreSQL e Java/Desenv/Java/01-Materiais para Popular as Tabelas/DataSets/PT-" + ext[ext.length - 4] + "/Participantes_XLS/" + ext[ext.length - 2] + ".xls";
			path = PropertiesFiles.getProp().getProperty("prop.path.datasets.pt") + ext[ext.length - 4] + PropertiesFiles.getProp().getProperty("prop.dir.datasets.participantes") + ext[ext.length - 2] + ".xls";
		}
		
		FileOutputStream fosOut = new FileOutputStream(path);
		hwbk.write(fosOut);
		hwbk.close();
		fosOut.close();
		System.out.println("Seu Arquivo Excel (XLS) foi Gerado com Sucesso!!!");
	}
	
	public Map<Object, Object> lerNomeHoraMapCorretamente(Workbook wbLookXLS, Sheet st) throws Exception {
	    Map<Object, Object> olharPalavrasMapeadasArqXls = new HashMap<Object, Object>();
	    olharPalavrasMapeadasArqXls = Util.lerConteudoArquivoExcel(wbLookXLS, st, st.getName());
	    return olharPalavrasMapeadasArqXls;
	}
	
	public Map<Object, Object> lerNomeIdAvaliacaoMapCorretamente(Workbook wbLookXLS, Sheet st) throws Exception {
	    Map<Object, Object> olharPalavrasIdAvaliacaoMapArqXls = new HashMap<Object, Object>();
	    olharPalavrasIdAvaliacaoMapArqXls = Util.lerConteudoArquivoExcel(wbLookXLS, st, st.getName());
	    return olharPalavrasIdAvaliacaoMapArqXls;
	}
	
	/* Ler arquivo TXT */
	private String[] lerNomeJogosTxt() throws IOException {
		// TODO Auto-generated method stub
		String lerLinhaArqTxt = null;
		//String paths = "/Volumes/Seagate_Expansion_3TB_5_1_4/01 - Mestrado UFF/01-PostgreSQL e Java/Desenv/Java/01-Materiais para Popular as Tabelas/KeyWords/KeyWords_id_Paciente_id_jogo.txt";
		String paths =  PropertiesFiles.getProp().getProperty("prop.path.keywords") + "KeyWords_id_Paciente_id_jogo.txt";
		File pathAtual = new File(paths);
		InputStream isPath = new FileInputStream(pathAtual); 
		BufferedReader bfrPath = new BufferedReader(new InputStreamReader(isPath));
		
		//Ler cada registro do Nome do Jogo
		String[] arrNomeJogo = new String[29];
		//String[] arrNomeJogo = new String[30];
		int index = 0;
		while((lerLinhaArqTxt = bfrPath.readLine()) != null) {
			arrNomeJogo[index] = lerLinhaArqTxt;
			System.out.println("Nome do Jogo Lido = " + arrNomeJogo[index] +  "\n" + lerLinhaArqTxt + "\n" + index);
			index++;
		}
		System.out.println("Nome do Jogo Lido = " + index);
		bfrPath.close();
		
		return arrNomeJogo;
	}
	
	
	public void inicio_xls(File path) {
		try {
			System.out.println("PATH = " + path);
			wb = Workbook.getWorkbook(path);
            st = wb.getSheet(0);
            System.out.println("ST_Nome_Planilha = " + st.getName());
            long tempoInicial = System.currentTimeMillis();
            lerConteudoArquivoExcel(st.getName());
            long tempoFinal = System.currentTimeMillis(); 
        	System.out.println("Tempo Total = " + (tempoFinal - tempoInicial) + "ms");
            finalizarArquivoExcel();   
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na Leitura do Arquivo!!!");
        } catch (BiffException e) {
            e.printStackTrace();
            System.out.println("Erro no ConteÃºdo do Arquivo Excel!!!");
        }
	}
	

	public void lerConteudoArquivoExcel(String namePlanilha) {
		Cell celula;
        Cell primCelula;
        
        try {
            int numLinha  = st.getRows();
            System.out.println("QTD Linhas: " + numLinha);
            int numColuna = st.getColumns();
            System.out.println("QTD Colunas: " + numColuna);
            resultado = new Object[numLinha][numColuna]; 
            for(int linha=1; linha < numLinha; linha++) {
                Map<Object, Object> mapaParametros = new LinkedHashMap<Object, Object>();
                for(int coluna=0; coluna < numColuna; coluna++) {
                    celula = st.getCell(coluna,linha);
                    System.out.println("Celula.getType = " + celula.getType());
                    primCelula = st.getCell(coluna,0);
                    if (celula.getType() == CellType.NUMBER) {
                        NumberCell numCelula = (NumberCell) celula;
                        resultado[linha][coluna] = new Long((long)numCelula.getValue());
                    }
         
                    if (celula.getType() == CellType.LABEL) {
                        LabelCell labelCelula     = (LabelCell) celula;
                        resultado[linha][coluna] = labelCelula.getString();
                        
                    } 
                    if (celula.getType() == CellType.EMPTY) {}    
    
                    LabelCell labelPrimCelula = (LabelCell) primCelula;
                    resultado[0][coluna]      = labelPrimCelula.getString();
                    mapaParametros.put(resultado[0][coluna],resultado[linha][coluna]);
                       
                    System.out.println("Resultado da Celula: " + resultado[0][coluna] + " <- " + resultado[linha][coluna]);
                }
                
                gravarBD(mapaParametros, linha, namePlanilha, resultado);          
            }
    	} catch (IllegalAccessException e) {
    		e.printStackTrace();
    		System.out.println("Acesso Ilegal ao Invocar o MÃ©todo!!!");
    	} catch (NoSuchMethodException e) {
    		e.printStackTrace();
    		System.out.println("Nenhum mÃ©todo foi encontrado!!!");
    	} catch (IOException e) {
    		e.printStackTrace();
    		System.out.println("Erro ao abrir o arquivo TXT!!!");
        } catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("Erro Geral!!!");
        }
	}
	
	// IrÃ¡ gravar na BD
	private void gravarBD(Map<Object, Object> mapaParametros, int linha, String name, Object[][] resultado) throws SQLException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//csv(mapaParametros, "retorno");
		// Popula as Classes
		// Contar a qtd de objetos = tabelas
		String lerLinhaArqTxt = null;
		//String paths = "/Volumes/Seagate_Expansion_3TB_5_1_4/01 - Mestrado UFF/01-PostgreSQL e Java/Desenv/Java/01-Materiais para Popular as Tabelas/KeyWords/KeyWords.txt";
		String paths = PropertiesFiles.getProp().getProperty("prop.path.keywords") + "KeyWords.txt";
		File pathAtual = new File(paths);
		InputStream isPath = new FileInputStream(pathAtual); 
		BufferedReader bfrPath = new BufferedReader(new InputStreamReader(isPath));
		
		//Java Reflection
		AcademiaCerebro acdcrb = new AcademiaCerebro();
		Class<?> cls = acdcrb.getClass();
		while((lerLinhaArqTxt = bfrPath.readLine()) != null) {
			System.out.println("Palavra Lida = " + lerLinhaArqTxt);
			Method popularBD = cls.getMethod(lerLinhaArqTxt, Map.class, String.class);
			/* acdcrb -> Nome do Objeto com o nome do Método, Nome do Atributo -> mapaParametros e outro Nome de Parâmetro -> name */
			popularBD.invoke(acdcrb, mapaParametros, name);
		}
		// Fim do Java Reflection
		
		bfrPath.close();
	}
	
	/*private void csv(Map<Object, Object> mapaRetorno, String nomeArquivo) throws IllegalStateException {
        //String nomeArquivo = ("academia do cerebro-" + Util.dateFormatterMascara((new CalendarioImpl()).getDataHora(),"yyyyMMdd-HH:mm:ss"));
        ExportaCSV.getInstance().writeToFileCSV(mapaRetorno, nomeArquivo);
    }*/

	private void finalizarArquivoExcel() {
		// TODO Auto-generated method stub
		wb.close();
	}
}
