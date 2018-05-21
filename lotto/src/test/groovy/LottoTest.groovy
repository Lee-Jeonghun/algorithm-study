import spock.lang.Specification

class LottoTest extends Specification {
    def target = new Lotto()

    def "로또 출력 테스트"() {
        expect:
        target.setK(7)
        target.setS([1, 2, 3, 4, 5, 6, 7] as Integer[])
        target.printLotto(0)
    }
}
