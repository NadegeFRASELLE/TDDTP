package org.m1.tdd;

import java.util.Collections;
import java.util.List;

/**
 * La classe ListesNumeriques permet d'ajouter 2 entiers (positifs ou négatifs) représentés en
 * utilisant des listes de chiffres. On ne passera pas par un type <code>Long</code> ou 
 * <code>BigInteger</code>.
 * 
 */
public class ListesNumeriques {

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
     * @param nb1  liste qui contient le premier entier. Si <code>nb1</code> est une liste vide, cela 
	 * correspond à 0. Si <code>nb1</code> est <code>null</code>, le résultat est une liste vide
     * @param nb2  liste qui contient le deuxième entier. Si <code>nb2</code> est une liste vide, cela 
	 * correspond à 0. Si <code>nb2</code> est <code>null</code>, le résultat est une liste vide
     * @return la somme de <code>nb1</code> et <code>nb2</code> représentée comme une liste de chiffres
     */
    public List<Integer> ajoute(List<Integer> nb1, List<Integer> nb2) {

        return Collections.emptyList();

    }


}