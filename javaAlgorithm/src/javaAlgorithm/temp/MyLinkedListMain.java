package javaalgorithm.temp;

public class MyLinkedListMain {
	public static void main(String[] args) {
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
		myLinkedList.add(10);		
		myLinkedList.add(20);
		myLinkedList.add(30);
		System.out.println(myLinkedList.get(0));
		System.out.println(myLinkedList.get(1));
		System.out.println(myLinkedList.get(2));
		myLinkedList.remove(1);
		System.out.println(myLinkedList.get(1));
		
		System.out.println("reverse");
		myLinkedList.reverse();
		System.out.println(myLinkedList.get(0));
		System.out.println(myLinkedList.get(1));
	}

}

class MyLinkedList<T> {
	public int size = 0;
	public Block firstBlock = null;
	public Block lastBlock = null;
	
	class Block {
		public Block previousBlock;
		public Block nextBlock;
		public T value;
	}
	
	
	public void add(T x) {
		Block block = new Block();
		block.value = x;
		if (size++ > 0) {
			lastBlock.nextBlock = block;
			block.previousBlock = lastBlock; 
		} else {
			firstBlock = block;
		}
		lastBlock = block;
	}
	
	public T get(int index) {
		Block block = firstBlock;
		for (int i = 0; i < index; i++) {
			block = block.nextBlock;
		}
		return block.value;
	}
	
	public void remove(int index) {
		Block block = firstBlock;
		for (int i = 0; i < index; i++) {
			block = block.nextBlock;
		}
		if (index > 0 && index < size - 1) {
			block.previousBlock.nextBlock = block.nextBlock;
			block.nextBlock.previousBlock = block.previousBlock;
		} else if (index == 0) {
			block.nextBlock.previousBlock = null;
		} else if (index == size - 1) {
			block.previousBlock.nextBlock = null;
		}
		--size;
	}
	
	public void reverse() {
		Block block = firstBlock;
		block.previousBlock = block.nextBlock;
		block.nextBlock = null;
		for (int i = 0; i < size - 2; i++) {
			block = block.previousBlock;
			Block temp = block.nextBlock;
			block.nextBlock = block.previousBlock;
			block.previousBlock = temp;
		}
		if (size > 1) {
			block = block.previousBlock;
			block.nextBlock = block.previousBlock;
			block.previousBlock = null;
		}
		Block temp = firstBlock;
		firstBlock = lastBlock;
		lastBlock = temp;
	}
}