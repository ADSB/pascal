import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MuPascal {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<List<Long>> triangle;

	public static void main(String[] args) {
		int rows;

		do {
			rows = getRows();
			triangle = new ArrayList<List<Long>>(rows);
			populateTriangle(rows);
			printTriangle();
		} while (rows > 0);
	}

	public static int getRows() {
		return scanner.nextInt();
	}

	public static void populateTriangle(int rows) {
		List<Long> last;
		List<Long> self;

		for (int i = 0; i < rows; i++) {
			self = new ArrayList<Long>(i + 1);
			triangle.add(self);
			self.add(1l);
			if (i > 0) {
				for (int j = 1; j < i; j++) {
					last = triangle.get(i - 1);
					triangle.get(i).add(last.get(j - 1) + last.get(j));
				}
				self.add(1l);
			}
		}
	}

	public static void printTriangle() {
		String buffer = "";
		String line;
		int size = triangle.size();

		for (int i = 0; i < size; i++) {
			line = "";
			for (int j = 0; j < size - i - 1; j++) {
				line += " ";
			}
			for (Long cell: triangle.get(i)) {
				line += cell + " ";
			}
			buffer += line.substring(0, line.length() - 1) + "\n";
		}

		System.out.print(buffer);
	}

}
