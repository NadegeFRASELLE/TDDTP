package org.m1.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * La classe ListesNumeriques permet d'ajouter 2 entiers (positifs ou négatifs) représentés en
 * utilisant des listes de chiffres. On ne passera pas par un type <code>Long</code> ou
 * <code>BigInteger</code>.
 *
 */
public class ListesNumeriques {

	/**
	 * La taille maximum de liste qu'on veut accepter.
	 */
	final static int SIZE_MAX = 30;
    /**
     * <p>La méthode considère 2 entiers qui sont représentés en utilisant des listes de
     * chiffres, respectivement <code>nb1</code> et <code>nb2</code>. Cela permet de pouvoir
	 * manipuler des très grands nombres sans utiliser un type borné tel que <code>Long</code>
	 * par exemple.
     * La méthode ajoute ces 2 nombres et renvoie le résultat comme une liste de chiffres.
     * </p>
     * <p>Par exemple, si on veut ajouter les nombres 142 et 13, on doit créer une liste
     * (nb1) avec trois éléments [1,4,2] et une liste (nb2) avec deux éléments [1,3].
     * Comme 142+13 = 155, le programme doit donc produire une liste avec trois éléments [1,5,5]
     * </p>
     * [1,4,2] + [1,3] = [1,5,5]
     * <p>
     * Chaque élément des listes nb1 et nb2 doit être compris entre 0 et 9, excepté le premier
	 * élément de chaque liste qui peut être compris entre -9 et 0 pour pouvoir représenter un nombre
	 * négatif.
     * Une exception <code>IllegalArgumentException</code> est levée si cette condition préalable n'est
     * pas remplie.
     * </p>
     *
     * @param nombre1  liste qui contient le premier entier. Si <code>nb1</code> est une liste vide, cela
	 * correspond à 0. Si <code>nb1</code> est <code>null</code>, le résultat est une liste vide
     * @param nombre2  liste qui contient le deuxième entier. Si <code>nb2</code> est une liste vide, cela
	 * correspond à 0. Si <code>nb2</code> est <code>null</code>, le résultat est une liste vide
     * @return la somme de <code>nb1</code> et <code>nb2</code> représentée comme une liste de chiffres
     */
    public List<Integer> ajoute(List<Integer> nombre1, List<Integer> nombre2) throws Exception {
   		// vérifications
		if (nombre1 == null || nombre2 == null || (nombre1.isEmpty() && nombre2.isEmpty())) {
			return Collections.emptyList();
		}
		if (nombre1.isEmpty()){
			return nombre2;
		}
		if (nombre2.isEmpty()){
			return nombre1;
		}
		checkListSize(nombre1, nombre2);
		checkNumbers(nombre1);
		checkNumbers(nombre2);

		//si tout est bon, création de listes modifiables avec la valeur absolue des nombres et renversement des listes.
		List<Integer> nb1 = new ArrayList<>(getNumAbsValue(nombre1).reversed());
		List<Integer> nb2 = new ArrayList<>(getNumAbsValue(nombre2).reversed());
		List<Integer> result;
		int retenue = 0;

		//si les nombres sont tous deux positifs ou négatifs, on procède à une simple addition avec retenue.
		if((isNegative(nombre1) && isNegative(nombre2)) || (!isNegative(nombre1) && !isNegative(nombre2))) {
			result = additionNombres(nb1, nb2, isNegative(nombre1));
		} else {
			//sinon, on regarde quel nombre est le plus grand, s'il est négatif pour le signe de la réponse et on lui
			//soustrait le plus petit.
			if(getMaxNum(nb1,nb2) == 1) {
				result = soustractionNombres(nb1, nb2, isNegative(nombre1));
			} else {
				result = soustractionNombres(nb2, nb1, isNegative(nombre2));
			}
		}
		return result;
    }

	/**
	 * Cette méthode est utilisée dans le cadre de l'addition entre un nombre positif et un nombre négatif,
	 * qui correspond à une soustraction.
	 *
	 * @param nb1 le premier nombre, celui auquel on soustrait la valeur de l'autre nombre.
	 * @param nb2 le deuxième nombre.
	 * @param nbneg true si le premier nombre, qui est forcément le plus grand, est négatif.
	 * @return la liste qui contient le résultat de l'opération.
	 */
	protected List<Integer> soustractionNombres(List<Integer> nb1, List<Integer> nb2, boolean nbneg) {
		int retenue = 0;
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < Math.max(nb1.size(), nb2.size()); i++) {
			int num1 = i < nb1.size() ? nb1.get(i) : 0;
			int num2 = i < nb2.size() ? nb2.get(i) : 0;
			result.addFirst((num1 < num2 + retenue ? num1 + 10 : num1) - (num2 + retenue));
			retenue = num1 < (num2 + retenue) ? 1 : 0;
		}
		cleanResult(result);

		if (nbneg) {
			result.set(0, -result.getFirst());
		}
		return result;
	}

	/**
	 * Cette méthode est utilisée dans le cadre de l'addition entre deux nombres positifs ou deux nombres négatifs.
	 *
	 * @param nb1 le premier nombre.
	 * @param nb2 le deuxième nombre.
	 * @param nbneg true si on a une addition de nombres négatifs.
	 * @return la liste qui contient le résultat de l'opération.
	 */
	protected List<Integer> additionNombres(List<Integer> nb1, List<Integer> nb2, boolean nbneg) {
		int retenue = 0;
		List<Integer> result = new ArrayList<>();

		for(int i = 0 ; i < Math.max(nb1.size(),nb2.size()); i++){
			int num1 = i < nb1.size() ? nb1.get(i) : 0;
			int num2 = i < nb2.size() ? nb2.get(i) : 0;

			result.addFirst((num1 + num2 + retenue) > 10 ? (num1 + num2 + retenue - 10) : (num1 + num2 + retenue));
			retenue = (num1 + num2 + retenue) / 10;
		}
		if (retenue != 0) {
			result.addFirst(retenue);
		}
		cleanResult(result);
		if (nbneg) {
			result.set(0, -result.getFirst());
		}
		return result;
	}

	/**
	 * Permet de savoir si un nombre est négatif ou non.
	 *
	 * @param nombre le nombre à vérifier.
	 * @return true si le nombre est négatif, false sinon.
	 */
	private boolean isNegative(List<Integer> nombre){
		return nombre.getFirst() < 0;
	}

	/**
	 * Permet de récupérer la valeur absolue d'un nombre qui est sous forme d'une liste d'Integers.
	 * @param nombre le nombre dont on veut récupérer la valeur absolue.
	 * @return la liste contenant la valeur absolue qu'on veut.
	 */
	private List<Integer> getNumAbsValue(List<Integer> nombre) {
		List<Integer> ln = new ArrayList<>(nombre);
		ln.set(0, Math.abs(ln.getFirst()));
		return ln;
	}

	/**
	 * Permet de vérifier si les nombres respectent les contraintes imposées.
	 * @param nb le nombre à vérifier.
	 * @throws IllegalArgumentException si le nombre ne respecte pas les contraintes.
	 */
	private void checkNumbers(List<Integer> nb) throws IllegalArgumentException {
		List<Integer> newNb = new ArrayList<>(nb);
		if(newNb.getFirst() < -9 || (newNb.getFirst() > 9)){
			throw new IllegalArgumentException("Attention, tous les chiffres doivent être compris entre -9 et 9.");
		}
		newNb.removeFirst();

		if (!newNb.stream().allMatch(chiffre -> chiffre >= 0 && chiffre <= 9)) {
			throw new IllegalArgumentException("Attention, tous les chiffres doivent être compris entre 0 et 9.");
		}
	}

	/**
	 * Méthode utilisée pour savoir quel nombre a la valeur absolue la plus grande pour la soustraction.
	 *
	 * @param nb1 le premier nombre à comparer.
	 * @param nb2 le deuxième nombre à comparer.
	 * @return l'indice du nombre le plus grand. Retourne 1 si les nombres sont identiques.
	 */
	private int getMaxNum(List<Integer> nb1, List<Integer> nb2){
		if(nb1.size() != nb2.size()){
			return nb1.size() > nb2.size() ? 1 : 2;
		}
		for(int i = nb1.size()-1; i > 0 ; i--){
			if(!Objects.equals(nb1.get(i), nb2.get(i))){
				return Objects.equals(Math.max(nb1.get(i), nb2.get(i)),nb1.get(i)) ? 1 : 2;
			}
		}
		return 1;

	}

	/**
	 * Méthode utilisée pour vérifier que les listes de nombres ne sont pas trop longues.
	 *
	 * @param nombre1 le premier nombre dont on veut vérifier la longueur.
	 * @param nombre2 le deuxième nombre dont on veut vérifier la longueur
	 * @throws Exception si un des nombres est trop long, ou si les deux sont trop longs.
	 */
	private void checkListSize(List<Integer> nombre1, List<Integer> nombre2) throws Exception {
		if(nombre1.size() > SIZE_MAX || nombre2.size() > SIZE_MAX){
			throw new Exception("Les listes ne peuvent pas contenir plus de " + SIZE_MAX + " éléments respectivement.");
		}
	}

	/**
	 * Méthode qui permet de nettoyer les résultats en retirant tous les zéros superflus en début de liste.
	 *
	 * @param result le nombre à nettoyer.
	 */
	private void cleanResult(List<Integer> result){
		if (result.size() <= 1) {
			return;
		}
		while (result.getFirst() == 0 && result.size() > 1){
			result.removeFirst();
		}
	}
}