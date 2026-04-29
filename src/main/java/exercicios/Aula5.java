package exercicios;

import exercicios.base.Aula;

import java.util.stream.Stream;

public class Aula5 extends Aula {
    public Aula5() {
        double menorNota = estudantes.stream()
                .filter(Estudante::isHomem)
                .filter(Estudante::hasNota)
                .mapToDouble(Estudante::getNota)
                .map(nota -> nota*100)
                .min()
                .orElse(0);

        System.out.println(menorNota);

//        long totalEstados = estudantes.stream()
//                .map(e -> e.getCidade())
//                .map(cidade -> cidade.getEstado())
//                .map(estado -> estado.getNome())
//                .distinct()
//                .count();
//
//        System.out.println(totalEstados);
    }

    static void main() {
        new  Aula5();
    }
}
