package javastudy.temp.gc;

public class A {
	int n;

	A(int n) {
		System.out.println("allocate A - " + n);
		this.n = n;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize A - " + n);
	}

}
