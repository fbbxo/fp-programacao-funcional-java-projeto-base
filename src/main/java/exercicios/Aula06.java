package exercicios;

import exercicios.base.Aula;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Aula06 extends Aula {

    private final Predicate<Estudante> mulheresAprovadas =
            ((Predicate<Estudante>) Estudante::isMulher)
                    .and(Estudante::hasCurso)
                    .and(Estudante::isAprovado);

    public Aula06() {
        System.out.println("Mulheres aprovadas:");
        getEstudantesMulheresAprovadas().forEach(System.out::println);

        System.out.println("\nOrdenadas por curso e nota:");
        getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota().forEach(System.out::println);

        System.out.println("\nCurso decrescente e nota crescente:");
        getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente().forEach(System.out::println);

        System.out.println("\nTotalmente decrescente:");
        getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente().forEach(System.out::println);

        System.out.println("\nCurso crescente e nota decrescente:");
        getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente().forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Aula06();
    }

    public List<Estudante> getEstudantesMulheresAprovadas() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .toList();
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(comparing(Estudante::getCurso)
                        .thenComparing(Estudante::getNota))
                .toList();
    }


    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(comparing(Estudante::getCurso).reversed()
                        .thenComparing(Estudante::getNota))
                .toList();
    }
    
    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        List<Estudante> collectMutavel = estudantes.stream()
                .filter(mulheresAprovadas)
                .collect(Collectors.toList());
        return collectMutavel;
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        Comparator.comparing(Estudante::getCurso)
                                .thenComparing(Estudante::getNota)
                                .reversed()
                )
                .toList();
    }
    
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
            return estudantes.stream()
                    .filter(mulheresAprovadas)
                    .sorted(
                            Comparator.comparing(Estudante::getCurso)
                                    .thenComparing(Comparator.comparingDouble(Estudante::getNota).reversed())
                    )
                    .toList();
    }
}
