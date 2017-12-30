package academia_cerebro;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import academia_cerebro.util.NumericFileNameComparator;
import academia_cerebro.util.PropertiesFiles;

public class JEscolherArquivoExcel extends JFrame {

	private JTextArea outputArea;
	private JScrollPane scrollPane;
	
	//configurando o Gui
	public JEscolherArquivoExcel() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			analisePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Errou a configuração Java LAF: " + e);
		}
	}
	//private File getArqOuDiretorio() {
	private File[] getArqOuDiretorio() {		
		JFileChooser fileChooser = new JFileChooser();
		/* Abrir no diretório Default */
		fileChooser.setCurrentDirectory(new File(PropertiesFiles.getProp().getProperty("prop.path.datasets")));
		/* Abrir múltiplus arquivos - Linha acrescentada*/
		fileChooser.setMultiSelectionEnabled(true);
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		/* Mostra A caixa de exibição dos diretórios */
		int result = fileChooser.showOpenDialog(this);
		
		if(result == JFileChooser.CANCEL_OPTION) {
			System.exit(1);
		}
		
		//Obtem o Arquivo
		//File fileName = fileChooser.getSelectedFile();
		
		File[] fileName = fileChooser.getSelectedFiles();
		
		int index = 0;
		Arrays.sort(fileName, new NumericFileNameComparator());
		while(index < fileName.length) {
			System.out.println("Arquivos Selecionados: " + fileName[index]);
			//Exibe Erro se inválido
			if(fileName == null || fileName[index].getName().equals("")) {
				JOptionPane.showMessageDialog(this, "Nome Inválido", "Nome Inválido", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			index++;
		}
		
		return fileName;
		//return fileName;
	}
	
	public void analisePath() throws IOException {
		/* Mostra o arquivo Selecionado */
		File[] nomesArqs = getArqOuDiretorio();
		for ( int i = 0; i < nomesArqs.length; i++ ) {
			System.out.println(nomesArqs[i]);
			if(nomesArqs[i].exists()) {		
				//Listagem do Diretório de Saída
				if(nomesArqs[i].isDirectory()) {
					String[] diretorio = nomesArqs[i].list();
					outputArea.append("\n\nConteúdo do Diretório:\n");
					
					for( String NomeDiretorio : diretorio ) {
						System.out.println("NomeDiretorio: " + NomeDiretorio);
						outputArea.append(NomeDiretorio + "\n"); 
					}
				}
				
				ProcessarDadosExcel pdex = new ProcessarDadosExcel(nomesArqs[i]); 
				
			} else {
				JOptionPane.showMessageDialog(this,  nomesArqs[i] + "não existe. ", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* Código antigo funcional */
		//getArqOuDiretorio();
		/*System.out.println(nome);
		if(nome.exists()) {		
			//Listagem do Diretório de Saída
			if(nome.isDirectory()) {
				String[] diretorio = nome.list();
				outputArea.append("\n\nConteúdo do Diretório:\n");
				
				for( String NomeDiretorio : diretorio ) {
					System.out.println("NomeDiretorio: " + NomeDiretorio);
					outputArea.append(NomeDiretorio + "\n"); 
				}
			}
			
			ProcessarDadosExcel pdex = new ProcessarDadosExcel(nome); 
			
		} else {
			JOptionPane.showMessageDialog(this,  nome + "não existe. ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}*/
	}

}
