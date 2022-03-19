package harvestingFields;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		//Class<RichSoilLand> clazz = RichSoilLand.class;

		String path = System.getProperty("user.dir") +
				"\\src\\harvestingFields" ;
		//Class<RichSoilLand> clazz2 = Class.forName("A");

		File dir = new File(path);
		File[] files = dir.listFiles();

		Class<?> clazz = RichSoilLand.class;

		List<Field> fields = Arrays.asList(clazz.getDeclaredFields());


		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		while (!input.equals("HARVEST")){

			String modifier = input;
			fields.stream()
					.filter(f -> Modifier.toString(f.getModifiers()).equals(modifier)
					|| modifier.equals("all"))
			.forEach(f -> System.out.printf("%s %s %s%n",
					Modifier.toString(f.getModifiers()),
					f.getType().getSimpleName(),
					f.getName()
			));

			input = scan.nextLine();
		}

	}
}
