package posco;

public class Test01_14 {

	public static void main(String[] args) {
		int[][] input = { { 78, 20 }, { 42, 33 }, { 5, 1 }, { 99, 55 }, { 56, 10 }, { 5, 5 } };

		int day = 0;
		int mask = 0;

		for (int i = 0; i < input.length; i++) {
			if (day == 3) {
				day = 0;
			}

			if (day == 0 && input[i][0] <= 55 && input[i][1] <= 25) {
				continue;
			} else if (input[i][0] > 91 && input[i][1] > 41) {
				mask++;
				day = 0;
			} else if (day == 0 && (input[i][0] > 55 || input[i][1] > 25)) {
				mask++;
				day++;
			}

			else
				day++;

//			System.out.println("i " + i);
//			System.out.println("day " + day);
//			System.out.println("mask " + mask);

		}
		System.out.println(mask);

	}

}
