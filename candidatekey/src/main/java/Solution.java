import java.util.HashSet;
import java.util.Set;

/**
 * @author JeongHun, Lee
 */
public class Solution {
	public int solution(String[][] relation) {
		Set<Integer> candidateKey = new HashSet<>();
		int max = (int)Math.pow(2, relation[0].length);

		for (int i = 1; i < max; i++) {
			int targetKey = i;
			int finalTargetKey = targetKey;
			if (candidateKey.stream().anyMatch(integer -> (integer & finalTargetKey) == integer)) {
				continue;
			}

			String[] values = new String[relation.length];
			for (int index = 0; targetKey > 0; targetKey >>= 1, index++) {
				if ((targetKey & 1) == 1) {
					for (int row = 0; row < relation.length; row++) {
						values[row] += relation[row][index];
					}
				}
			}

			Set<String> valueSet = new HashSet<>();
			boolean unique = true;
			for (String value : values) {
				if (!valueSet.add(value)) {
					unique = false;
					break;
				}
			}

			if (unique) {
				candidateKey.add(i);
			}
		}
		return candidateKey.size();
	}
}
