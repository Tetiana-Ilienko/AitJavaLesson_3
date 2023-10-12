package Strims_31;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Panda> pandas = List.of(
                new Panda("Po", 60_000),
                new Panda("Boo", 65_000),
                new Panda("Small", 40_000)

        );
        // хочу изменить исходные значения - мутировать
        // используем метод forEach

        pandas.forEach(Panda::eatBamboo);
        System.out.println(pandas);

        // reduce() - переводиться как сведение к чему-то

        double totalWeight = pandas.stream()
                .map(Panda::getWeight)
                .reduce(0.0, Double::sum);  //  без метода референс - .reduce(0.0,(a,b) -> a+b);

        // limit   - выводяться элементы до указоного
        List<String> animals = List.of(
                "Panda", "Lion", "Giraffe", "Monkey", "Rat","Monkey"
        );

        List<String> limitedAnimal = animals.stream().limit(2).collect(Collectors.toList());
        System.out.println(limitedAnimal); // [Panda, Lion]

        // skip  -  выводяться элементы поле заданного
        List<String> skippedAnimal = animals.stream().skip(2).collect(Collectors.toList());
        System.out.println(skippedAnimal);   // [Giraffe, Monkey, Rat, Monkey]

         // distinct - оставить только уникальные элементы
        List<String> distrinctAnimal = animals.stream().distinct().collect(Collectors.toList());
        System.out.println(distrinctAnimal); // [Panda, Lion, Giraffe, Monkey, Rat]

        // sorted

        // сортировка по количеству букв
        List<String> sortAnimals = animals.stream().sorted((a,b) -> Integer.compare(a.length(),b.length()))
                .collect(Collectors.toList());
        System.out.println(sortAnimals);

        // findAny


    }

    public static class Panda {

        private String title;
        private double weight;

        public void eatBamboo(){
            weight+=100;
        }

        public Panda(String title, double weight) {
            this.title = title;
            this.weight = weight;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Panda{" +
                    "title='" + title + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
