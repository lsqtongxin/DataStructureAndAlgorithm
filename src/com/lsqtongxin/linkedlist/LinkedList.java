package com.lsqtongxin.linkedlist;

public class LinkedList<E> {
	
	private class Node{
		public E e;
		public Node next;
		public Node(E e,Node next){
			this.e=e;
			this.next=next;
		}
		public Node(E e){
			this(e,null);
		}
		public Node(){
			this(null,null);
		}
		@Override
		public String toString() {
			return e.toString();	
		}
	}
	
	private int size;
	private Node dummyNode;
	
	public LinkedList(){
		dummyNode = new Node();
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int getSize() {
		return size;
	}
	
	
	

}
