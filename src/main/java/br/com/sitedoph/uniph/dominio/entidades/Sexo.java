package br.com.sitedoph.uniph.dominio.entidades;

/*
 * Enum Sexo
 */

public enum Sexo {

	/*
	 * Masculino
	 */
	MASCULINO(1, "Masculino"),

	/*
	 * Feminino
	 */
	FEMININO(2, "Feminino");

	private final Integer id;

	private final String descricao;
	
	/**
	 * Instancia um novo sexo.
	 *
	 * @param chave a chave
	 * @param valor o valor
	 */

	Sexo(final Integer chave, final String valor){
		id = chave;
		descricao = valor;
	}
	
	/*
	 * Obtém a descricao
	 * 
	 * @return a descricao
	 */
	
	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
