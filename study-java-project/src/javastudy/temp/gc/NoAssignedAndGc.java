package javastudy.temp.gc;

public class NoAssignedAndGc {
	public static void main(String[] args) {
		final int N = 1000000;
		int cnt = N;
		while (cnt-- > 0) {
			new A(N-cnt);
		}
	}
}
