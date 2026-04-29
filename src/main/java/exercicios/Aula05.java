package exercicios;

import exercicios.base.Aula;

import java.util.stream.Stream;

public class Aula05 extends Aula {
    public Aula05() {
        double menorNota = estudantes.stream()
                .filter(Estudante::isHomem)
                .filter(Estudante::hasNota)
                .mapToDouble(Estudante::getNota)
                .map(nota -> nota*100)
                .min()
                .orElse(0);

        System.out.println(menorNota);
    }

    static void main() {
        new  Aula05();
    }
}
