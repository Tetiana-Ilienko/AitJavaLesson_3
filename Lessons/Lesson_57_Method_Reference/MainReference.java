public class MainReference {

    /*
    Method Reference (ссылка на метод)
    ссылка на метод - это способ сослаться на метод не выполняя его.
    Ссылки на методы связаны с лямбда-выражениями т.к. им так же требуется совместимый функциональный интерфейс

    Ссылки на статические методы ( Method to static method)
    ClassName :: methodName

     */

    public static void main(String[] args) {

//*******************  Ссылки на статические методы ( Method to static method)
//    ClassName :: methodName
        numTest(OurPredicateClass :: isNegative, -1);
        numTest(OurPredicateClass ::isEven, 4);

//   *******************  Ссылки  не статические  методы ( Instance method reference) ************************
        OurInteger ourInteger = new OurInteger(9);
        OurInteger ourInteger1 = new OurInteger(10);

        IntPredicate intPredicate = ourInteger :: isFactor;



    }


//*******************  Ссылки на статические методы ( Method to static method)

    public static boolean numTest(IntPredicate p, int n){
        return p.test(n);
    }


}
