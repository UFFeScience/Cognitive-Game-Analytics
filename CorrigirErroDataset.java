package academia_cerebro;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import academia_cerebro.util.PropertiesFiles;
import academia_cerebro.util.Util;

import java.util.Scanner;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CorrigirErroDataset {
	private transient Workbook wbLookXLS;
	private Sheet st;
	private String[] ext;
	public String corrigirErroDataSetBrainHq(String pathCSV) throws Exception {
		
	    Scanner arqErradoCSV = new Scanner(new File(pathCSV));
	
	    //String path = "/Volumes/Seagate_Expansion_3TB_5_1_4/01 - Mestrado UFF/01-PostgreSQL e Java/Desenv/Java/01-Materiais para Popular as Tabelas/DataSets/dados/relacao_jogos_corretos.xls";
	    String path = PropertiesFiles.getProp().getProperty("prop.path.datasets.dados") + "relacao_jogos_corretos.xls";
	    
	    // \\W+ -> uma ou mais ocorrências (+) de tudo que não seja um caractere de palavra. Por exemplo: "\", "-", "espaço"etc.
 		String std = pathCSV.replaceAll("\\W+", "#");
 		System.out.println("STD = " + std);
 		ext = std.split("#");
 		System.out.println("Extensão do Arquivo Lida = " + ext.length + "\t Num Paciente = " + ext[ext.length - 2]); // Retornando 2 passos para pegar, do caminho do arquivo, o num do paciente
	    
		try {
			wbLookXLS = Workbook.getWorkbook(new File(path));
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        st = wbLookXLS.getSheet(0);
        
        String pathArqCorreto = criarCorrigirArqCsv(ext[ext.length - 2]);
        File arqCorrCsv = new File(pathArqCorreto);
	    arqCorrCsv.createNewFile();
	    FileWriter gerarArqCorreto = new FileWriter(arqCorrCsv);
	    
	    Map<Object, Object> olharPalavrasXLS = lerNomeJogosMapCorretamente(wbLookXLS, st);
	    StringBuilder construtor = new StringBuilder();
	    int linhaLida = 0;
	    while (arqErradoCSV.hasNext()) {
	        String[] lerLinhasArqErradoCSV = arqErradoCSV.nextLine().split(",");
	        int i = 0;
	        if (!("exercise_name".equals(lerLinhasArqErradoCSV[0]))) {
				i = i + 1;
	        	//continue;
			}
	        boolean achouJogoCorr = false;
	        String stdNomeJogoErradoLidoCsv = (lerLinhasArqErradoCSV[0]).replaceAll("\"", "");
	        String palavraCorreta = null;
	        Set<Entry<Object, Object>> set = olharPalavrasXLS.entrySet();
	        Iterator<Entry<Object, Object>> it = set.iterator();
	        while(it.hasNext()) {
	        	//Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>)it.next();
	        	Map.Entry<Object, Object> entry = it.next();
	        	System.out.println(entry.getKey() + " - " + entry.getValue());
	        	if ( stdNomeJogoErradoLidoCsv.equals(entry.getKey().toString()) ) {
					/* Subscreve na Posição Lida do nome do jogo errado encontrado com o nome do jogo correto */
					/* Escrever no CSV o valor do Jogo Correto */
	        		palavraCorreta = stdNomeJogoErradoLidoCsv.replaceAll(stdNomeJogoErradoLidoCsv, entry.getValue().toString());
	        		System.out.println("PalavraErrada: " + entry.getKey().toString() + "\t PalavraCorreta: " + palavraCorreta);
	        		construtor.append(palavraCorreta).append(",");
	        		achouJogoCorr = true;
	        		break;
				}
	        	
			}
	        
	        if (!achouJogoCorr && linhaLida != 0) {
        		construtor.append("erro-jogo nao mapeado - ").append(stdNomeJogoErradoLidoCsv).append(",");
        	}
	        
	        for(int index = i; index < lerLinhasArqErradoCSV.length; index++) {	
	        	construtor.append(lerLinhasArqErradoCSV[index]).append(",");
	        }
	        /* Deletando a última vírgula. */
	        construtor.deleteCharAt(construtor.lastIndexOf(","));
	        construtor.append("\n");
	        
	        linhaLida++;
	    }
	    arqErradoCSV.close();
	    gerarArqCorreto.write(construtor.toString());
	    gerarArqCorreto.close();
	    
	    return pathArqCorreto;
	} 
	
	
	public String criarCorrigirArqCsv(String numPaciente) throws Exception {
		String pathCorreto = null;
		System.out.println("ext[ext.length - 4]" + ext[ext.length - 4]);
		if ("Schedule1".equals(ext[ext.length - 4]) || "Schedule2".equals(ext[ext.length - 4])) {
			//pathCorreto = "/Volumes/Seagate_Expansion_3TB_5_1_4/01 - Mestrado UFF/01-PostgreSQL e Java/Desenv/Java/01-Materiais para Popular as Tabelas/DataSets/PT-" + ext[ext.length - 4] + "/Participantes_CSV/corretos/" + numPaciente + ".csv";
			pathCorreto = PropertiesFiles.getProp().getProperty("prop.path.datasets.pt") + ext[ext.length - 4] + PropertiesFiles.getProp().getProperty("prop.dir.datasets.participantes.corretos") + numPaciente + ".csv";
		}
	    return pathCorreto;
	}
	
	
	public Map<Object, Object> lerNomeJogosMapCorretamente(Workbook wbLookXLS, Sheet st) throws Exception {
	    Map<Object, Object> olharPalavrasMapeadasArqXls = new HashMap<Object, Object>();
	    olharPalavrasMapeadasArqXls = Util.lerConteudoArquivoExcel(wbLookXLS, st, st.getName());
	    return olharPalavrasMapeadasArqXls;
	}
}
