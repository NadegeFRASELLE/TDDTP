package org.m1.tdd;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests sur la classe Addition")
public class ListesNumeriquesTest {

	@DisplayName("Le test qui ne sert à rien...")
    @Test
    public void dummyTest() {
        assertTrue(true);
    }

    @DisplayName("L'addition fonctionne")
    @Test
    public void ajouteNombresPositifs() throws Exception{
        List<Integer> nb1 = Arrays.asList(1, 4, 2);
        List<Integer> nb2 = Arrays.asList(1, 3);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(1, 5, 5), result);
    }

    @DisplayName("L'addition fonctionne avec des grands nombres positifs")
    @Test
    public void ajouteNombresPositifs2() throws Exception{
        List<Integer> nb1 = Arrays.asList(9,9,9,9);
        List<Integer> nb2 = Arrays.asList(9,9,9,9);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(1,9,9,9,8), result);
    }

    @DisplayName("L'addition fonctionne avec les nombres négatifs")
    @Test
    public void testAjouteNombresNegatifs() throws Exception {
        List<Integer> nb1 = Arrays.asList(-1, 4, 2);
        List<Integer> nb2 = Arrays.asList(-1, 3);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(-1, 5, 5), result);
    }

    @DisplayName("L'addition fonctionne avec des grands nombres négatifs")
    @Test
    public void testAjouteNombresNegatifs2() throws Exception {
        List<Integer> nb1 = Arrays.asList(-9, 9, 9, 9);
        List<Integer> nb2 = Arrays.asList(-9, 9, 9, 9);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(-1,9,9,9,8), result);
    }

    @DisplayName("L'addition fonctionne avec les deux types de nombres")
    @Test
    public void testAjouteNombrePositifEtNegatif() throws Exception {
        List<Integer> nb1 = Arrays.asList(1, 4, 2);
        List<Integer> nb2 = Arrays.asList(-1, 3);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(1,2,9), result);
    }

    @DisplayName("L'addition fonctionne avec les deux types de nombres et le plus gros en 2e")
    @Test
    public void testAjouteNombrePositifEtNegatif2() throws Exception {
        List<Integer> nb1 = Arrays.asList(-1, 4, 2);
        List<Integer> nb2 = Arrays.asList(5, 2, 3);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(3,8,1), result);
    }

    @DisplayName("L'addition fonctionne avec les deux types de nombres et le plus gros negatif en 2e")
    @Test
    public void testAjouteNombrePositifEtNegatif3() throws Exception {
        List<Integer> nb1 = Arrays.asList(1, 4, 2);
        List<Integer> nb2 = Arrays.asList(-5, 2, 3);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(-3,8,1), result);
    }

    @DisplayName("L'addition fonctionne avec les deux types de nombres et le plus gros positif")
    @Test
    public void testAjouteNombrePositifEtNegatif4() throws Exception {
        List<Integer> nb1 = Arrays.asList(5,2,3);
        List<Integer> nb2 = Arrays.asList(-1, 4, 2);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(3,8,1), result);
    }

    @DisplayName("L'addition fonctionne avec les deux types de nombres et des nombres proches")
    @Test
    public void testAjouteNombrePositifEtNegatif5() throws Exception {
        List<Integer> nb1 = Arrays.asList(1, 4, 2);
        List<Integer> nb2 = Arrays.asList(-1, 7, 0);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(-2,8), result);
    }

    @DisplayName("L'addition fonctionne avec les deux types de nombres et des nombres proches inversés")
    @Test
    public void testAjouteNombrePositifEtNegatif6() throws Exception {
        List<Integer> nb2 = Arrays.asList(1, 4, 2);
        List<Integer> nb1 = Arrays.asList(-1, 7, 3);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(-3,1), result);
    }

    @DisplayName("L'addition fonctionne avec les deux types de nombres et leurs valeurs absolues sont les mêmes")
    @Test
    public void testAjouteNombrePositifEtNegatif7() throws Exception {
        List<Integer> nb1 = Arrays.asList(-1, 4, 2);
        List<Integer> nb2 = Arrays.asList(1, 4, 2);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(0), result);
    }

    @DisplayName("L'addition fonctionne avec un premier nombre null")
    @Test
    public void testAjouteNombreNull() throws Exception {
        List<Integer> nb1 = Arrays.asList(1, 4, 2);
        List<Integer> nb2 = null;
        ListesNumeriques ln = new ListesNumeriques();
        List<Integer> result = ln.ajoute(nb1, nb2);
        assertTrue(result.isEmpty());
    }

    @DisplayName("L'addition fonctionne avec un deuxième nombre null")
    @Test
    public void testAjouteNombreNull2() throws Exception {
        List<Integer> nb2 = Arrays.asList(1, 4, 2);
        List<Integer> nb1 = null;
        ListesNumeriques ln = new ListesNumeriques();
        List<Integer> result = ln.ajoute(nb1, nb2);
        assertTrue(result.isEmpty());
    }

    @DisplayName("L'addition fonctionne avec un deuxième nombre null")
    @Test
    public void testAjouteNombreNull3() throws Exception {
        List<Integer> nb1 = null;
        List<Integer> nb2 = null;
        ListesNumeriques ln = new ListesNumeriques();
        List<Integer> result = ln.ajoute(nb1, nb2);
        assertTrue(result.isEmpty());
    }

    @DisplayName("L'addition fonctionne avec un premier nombre invalide")
    @Test()
    public void testAjouteNombreInvalide1() {
        List<Integer> nb1 = Arrays.asList(1, 4, 2, 10);
        List<Integer> nb2 = Arrays.asList(1, 3);
        ListesNumeriques ln = new ListesNumeriques();

        assertThatThrownBy(() -> ln.ajoute(nb1, nb2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("L'addition fonctionne avec un deuxième nombre invalide")
    @Test()
    public void testAjouteNombreInvalide2() {
        List<Integer> nb1 = Arrays.asList(1, 4);
        List<Integer> nb2 = Arrays.asList(1, 30);
        ListesNumeriques ln = new ListesNumeriques();

        assertThatThrownBy(() -> ln.ajoute(nb1, nb2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("L'addition fonctionne quand les deux nombres sont invalides.")
    @Test()
    public void testAjouteNombreInvalide3() {
        List<Integer> nb1 = Arrays.asList(-15, 4);
        List<Integer> nb2 = Arrays.asList(1, 30);
        ListesNumeriques ln = new ListesNumeriques();

        assertThatThrownBy(() -> ln.ajoute(nb1, nb2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("L'addition fonctionne quand la 1ere liste est vide")
    @Test()
    public void testAjouteListeVide() throws Exception {
        List<Integer> nb1 = List.of();
        List<Integer> nb2 = Arrays.asList(2,6,8);
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(2,6,8), result);
    }

    @DisplayName("L'addition fonctionne quand la 2e liste est vide")
    @Test()
    public void testAjouteListeVide2() throws Exception {
        List<Integer> nb1 = Arrays.asList(1, 4, 2);
        List<Integer> nb2 = List.of();
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertEquals(Arrays.asList(1,4,2), result);
    }

    @DisplayName("L'addition fonctionne quand les deux listes sont vides")
    @Test()
    public void testAjouteListeVide3() throws Exception {
        List<Integer> nb1 = List.of();
        List<Integer> nb2 = List.of();
        ListesNumeriques ln = new ListesNumeriques();

        List<Integer> result = ln.ajoute(nb1, nb2);
        assertTrue(result.isEmpty());
    }

    @DisplayName("L'addition fonctionne quand le premier nombre est trop long")
    @Test
    public void testArrayTooLong1() {
        List<Integer> nb1 = Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4,
                5, 6, 7, 8, 9, 8);
        List<Integer> nb2 = Arrays.asList(1,2,3);
        ListesNumeriques ln = new ListesNumeriques();
        assertThatThrownBy(() -> ln.ajoute(nb1,nb2))
                .isExactlyInstanceOf(Exception.class);
    }

    @DisplayName("L'addition fonctionne quand le deuxième nombre est trop long")
    @Test
    public void testArrayTooLong2() {
        List<Integer> nb2 = Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4,
                5, 6, 7, 8, 9, 8);
        List<Integer> nb1 = Arrays.asList(1,2,3);
        ListesNumeriques ln = new ListesNumeriques();
        assertThatThrownBy(() -> ln.ajoute(nb1,nb2))
                .isExactlyInstanceOf(Exception.class);
    }

    @DisplayName("L'addition fonctionne quand le premier nombre contient des chiffres négatifs")
    @Test
    public void testNombreNegatifMilieu1(){
        List<Integer> nb1 = Arrays.asList(1, -4, 2);
        List<Integer> nb2 = Arrays.asList(1, 4, 2);
        ListesNumeriques ln = new ListesNumeriques();
        assertThatThrownBy(() -> ln.ajoute(nb1,nb2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("L'addition fonctionne quand le deuxième nombre contient des chiffres négatifs")
    @Test
    public void testNombreNegatifMilieu2(){
        List<Integer> nb2 = Arrays.asList(1, -4, 2);
        List<Integer> nb1 = Arrays.asList(1, 4, 2);
        ListesNumeriques ln = new ListesNumeriques();
        assertThatThrownBy(() -> ln.ajoute(nb1,nb2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }


}


