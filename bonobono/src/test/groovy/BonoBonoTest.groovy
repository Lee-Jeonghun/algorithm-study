import spock.lang.Specification

class BonoBonoTest extends Specification {
    def "GetMaxAnimal"() {
        given:
        BonoBono bonoBono = new BonoBono()
        bonoBono.setN(9)
        bonoBono.setCave([1, 2, 2, 1, 3, 1, 1, 2, 4] as int[])
        bonoBono.setAnimals(new Animal[9])

        Animal[] animals = bonoBono.getAnimals()
        for (int i = 0; i < 9; i++) {
            animals[i] = new Animal();
        }

        when:
        def result = bonoBono.getMaxAnimal()

        then:
        result == 3
    }
}
