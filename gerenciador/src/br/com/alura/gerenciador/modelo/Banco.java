package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		List<Empresa> empresas = new ArrayList<Empresa>(Banco.lista);
		return empresas;
	}

	public void removeEmpresa(Integer id) {
//		for (Empresa empresa : lista) {
//			if (empresa.getId() == id) {
//				lista.remove(empresa);
//			}
//		}

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId() == id) {
				it.remove();
			}
		}

	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId()==id) {
				return empresa;
			}
		}
		return null;
	}
}