package academia_cerebro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LerArquivoExcel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			String x = JOptionPane.showInputDialog("Ler Arquivo? Digite (S)im ou (N)ão.");
			if(("n".toUpperCase()).equals(x.toUpperCase())) {
				break;
			} if(("s".toUpperCase()).equals(x.toUpperCase())) {
				JEscolherArquivoExcel jea = new JEscolherArquivoExcel();
				jea.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			} else {
				JOptionPane.showMessageDialog(null, x + " Inválido. Informe (s)im ou (n)ão. ", "Opção Errada!!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		System.exit(0);
	}
}
