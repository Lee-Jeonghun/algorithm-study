import spock.lang.Specification

class CoinCalculatorTest extends Specification {
    def target = new CoinCalculator()

    def "분할 정복 테스트"() {
        given:
        target.setCoins([10, 50, 100, 120, 200] as int[])

        when:
        def result = target.getCoinNumByDC(260)

        then:
        result == 3
    }

    def "DP 테스트"() {
        given:
        target.setCoins([10, 50, 100, 120, 200] as int[])

        when:
        def result = target.getCoinNumByDP(260)

        then:
        result == 3
    }
}
