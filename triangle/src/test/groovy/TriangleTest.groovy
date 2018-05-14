import spock.lang.Specification

class TriangleTest extends Specification {
    def target = new Triangle()

    def setup() {
        int[] triangle = [7, 3, 8, 8, 1, 0, 2, 7, 4, 4, 4, 5, 2, 6, 5]
        int[] dp = new int[5 * 6 / 2]
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE
        }

        target.setTriangle(triangle)
        target.setDp(dp)
        target.setDepth(5)
    }

    def "합이 최대가 되는 경로에 있는 수의 합"() {
        expect:
        target.getMaxSum() == 30
    }
}
