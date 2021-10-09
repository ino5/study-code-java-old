package javaalgorithm.string.setform;

public class SetFormOfString2 {
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		String[] arr= s.replaceAll("[{]", " ")
						.replaceAll("[}]", " ")
						.trim()
						.split(" , ");
		for (String val : arr) {
			System.out.println(val);
		}
	}
}
