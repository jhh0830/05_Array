package com.kh.array;

import java.util.Arrays;

// �迭 ����
public class B_ArrayCopy {
	
	/*
	 * *�迭����
	 * �迭�� �����ϴ� ����
	 * - ���� ���� : �����ϴ� ô���ϴ� ��
	 * - ���� ���� : ����� ���� �ϴ� ��
	 * 
	 * 
	 */
	public void method1() {
		
		//�����迭
		int[] origin = {1,2,3,4,5};
		System.out.println("==���� �迭 ��� ==");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i]+" ");
		}
		//���纻�迭
		int[] copy = origin;
		System.out.println();
		System.out.println("===���纻 �迭 ���");
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i]+ " ");
		}
		// > �ܼ�â�� ��µ� ����δ� ���簡 �� �� �� ����
		copy[2] = 99;
		
		System.out.println();
		System.out.println("=== ���纻 �迭 ���� �� ===");
		System.out.println("== ���� �迭 ��� ==");
		for(int i = 0; i < origin.length; i++) {
			
			System.out.print(origin[i] + " ");
		}
		
		System.out.println();
		System.out.println("== ���纻 �迭 ��� ==");
		for(int i = 0; i <copy.length; i++) {
			System.out.print(copy[i]+ " ");
		}
		// > ���纻 �迭���� ������ ������ �ߴµ�
		// ���纻 �Ӹ� �ƴ϶� ���� �迭�� ���� ������ �� �� ����.
		// (��, ���� �迭�� ���� �Ѽ��� �Ǿ���)
		// > ���簡 ����� �ȵ� ��Ȳ��...
		
		
		
		// ���� ���� : �迭�� "�ּҰ�" �� ����Ǿ�
		// 			 ������ ���纻�� ���� ����!!
		// > ������ ���纻�� "�ּҰ�" �� ���� ���¸� ���� ������ ��
		
		// �ּҰ��� ���
		System.out.println();
		System.out.println("���� �ּҰ� : " + origin);
		System.out.println("���纻 �ּҰ� : " + copy);
		
		//��Ű�ڵ�� ���
		System.out.println("���� �ؽ��ڵ� : " + origin.hashCode());
		System.out.println("���纻 �ؽ��ڵ� "+  copy.hashCode());
		
		// ������ ���纻�� �ּҰ��� �����
		System.out.println(origin == copy);
		
		// > �迭 ���簡 ����� ����� Ȯ���ϰ��� �Ѵٸ�
		// for���� �̿��ؼ� ������ ������ ���� ���ķ� ����غ��� ������
		// �ܼ��� ������ ���纻�� �ּҰ��� ���ؼ��� Ȯ���� �� �ִ�.
		
		
	} // emthod1 �޼ҵ� ���� ��
	
	// ���� ���� - �� 4���� ���
	public void method2() {
		//1. for���� �̿��ϴ� ���
		// > ���ο� �迭�� ������ �� �� �ε��� �� ���� ����
		// for���� �̿��ؼ� ������ �����ϴ� ���
		
		// ���� �迭
		int[] origin = {1,2,3,4,5};
		
		// ���纻 �迭
		int[] copy = new int[origin.length];
		
		/*
		 * copy[0] = origin[0];
		 * copy[1] = origin[1];
		 * 
		 */
		//for(int i = 0; i < origin.length; i++)
		for(int i = 0; i < copy.length; i++) {
			copy[i] = origin[i];
			
		}
		//���� ���
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i]+" ");
			
		}
		System.out.println();
		System.out.println("===���纻 �迭 ���==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		// copy �迭 ����
		copy[2] = 99;
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i]+" ");
			
		}
		
		System.out.println();
		System.out.println("==== ���纻 �迭 ��� ==");
		
		for(int i = 0; i < origin.length; i++) {
			System.out.println(copy[i] + " ");
		}
		// > ���纻 �迭�� ������ �����ϴ���
		// ���� �迭�� ������ �����Ǵ� ���� �� �� �ִ�.
		// > ���� ���� : �ּҰ��� �����ϴ� ���� �ƴ�
		// 			   ���� �迭 ���� ��ü�� ���� �ߴ� ���
		
		// �ּҰ��� ���
		System.out.println();
		System.out.println("���� �ּҰ� : " + origin);
		System.out.println("���纻 �ּҰ� : " + copy);
		
		// �ؽ��ڵ� ���
		System.out.println("���� �ؽ��ڵ� : " + origin.hashCode());
		System.out.println("���纻 �ؽ��ڵ� : " + copy.hashCode());
	
		// �����
		System.out.println(origin == copy); //false
		
	} // method2 �޼ҵ� ���� ��
	
	public void method3() {
		
		// 2. ���ο� �迭�� ���� ��
		// System Ŭ�������� �����ϴ� arraycopy �޼ҵ带 �̿��ϴ� ���
		
		// ���� �迭
		int[] origin = {1,2,3,4,5};
		
		//���纻 �迭
		int [] copy = new int [10];
		// > �Ϻη� ���� �迭�� ũŰ���� �˳��ϰ� ����
		// 0 0 0 0 0 0 0 0 0 0 (�⺻��)
		
		// * System Ŭ������ arraycopy �޼ҵ�
		// �迭�� ���� ������ ���� ���ǵ� �޼ҵ�
		// [ ǥ���� ]
		// System.arraycopy(�����迭��, �����迭�Ǻ��縦�������ε��� ���纻�迭��,
		//                  ���纻�迭�� ����ɽ����ε���,�����Ұ���);
		
		System.arraycopy(origin, 0, copy, 0, 5);
		// 1 2 3 4 5 0 0 0 0 0
		
		//System.arraycopy(origin, 0, copy, 2, 5);
		// 0 0 1 2 3 4 5 0 0 0
		//System.arraycopy(origin, 0, copy, 1, 3);
		// 0 1 2 3 0 0 0 0 0 0 
		
		//System.arraycopy(origin, 0, copy, 9, 2);
		// 0 0 0 0 0 0 0 0 3 /4   (�ε��� ���� ���)
		// > ARrrayIndexOutOfBonudException �߻�
		// ���� �� �ٿ��ֱ� �������� �ε��� ������ ����� ������ �߻���
		
		
		// > ������ ���� �κ��� ������ ������ ��� ������ ��
		
		
		// ���纻 �迭�� ���
		for(int i = 0; i < copy.length; i++)
		{
			System.out.print(copy[i]+ " ");
		}
		
		// ���� ���簡 �� �Ǿ����� Ȯ��
		System.out.println();
		System.out.println("���� �ּҰ� : " + origin);
		System.out.println("���纻 �ּҰ� : " + copy);
		
		
		
	}// method3 �޼ҵ� ���� ��
	public void method4() {
		// 3. Arrays Ŭ�������� �����ϴ� copyOf ��� �޼ҵ带 �̿��ϴ� ���
	
		//���� �迭
		int[] origin = {1,2,3,4,5};
		
		// ���纻 �迭
		
		// * Arrays Ŭ������ copyOf �޼ҵ�
		// �������縦 ���ִ� �޼ҵ�
		// [ ǥ���� ]
		// ���纻 �迭�� = Arrays.copyOf(�����迭�� , �����Ұ���);
		
		//���纻 �迭
		int[] copy = Arrays.copyOf(origin, 7);
		
		//���纻 �迭�� ���
		
		for(int i = 0; i < copy.length; i++) {
			
			System.out.print(copy[i] + " ");
			
		}
		//���簡 �� �Ͼ���� Ȯ��
		System.out.println();
		System.out.println("���� �ؽ��ڵ� :" + origin.hashCode());
		System.out.println("���纻 �ؽ��ڵ� : " + copy.hashCode());
	
	} // method4 �޼ҵ� ���� ��
	
	public void method5() {
		
		// 4. clone �̶�� �޼ҵ带 �̿��ϴ� ���
		
		// ���� �迭
		int[] origin = {1,2,3,4,5};
		
		// * clone �޼ҵ�
		// �迭�� ���� ���縦 ���ִ� �޼ҵ�
		// [ ǥ���� ]
		// ���纻�迭�� = ���� �迭��.clone();
		
		//���纻 �迭
		int[] copy;
		copy = origin.clone();
		// > �ε��� �������� x, �����Ұ��� ���� x
		// ��, ���� �迭�� ������ �Ȱ��� ������ ���ڴ�.
		
		// ���纻 �迭�� ���
		/*
		for(int i = 0; i<copy.length; i++) {
			System.out.println(copy[i] + " ");
		
		}*/
		
		// > �迭�� ���빰�� ����ϰ� ������
		//  "[1,2,3,4,5]" �������� ���ڰ� ����ϰ� ����
		System.out.print("[");
		
		for(int i = 0; i < copy.length; i++) {
			
			if(i == copy.length-1) {
			// ������ �ε��� ��ȣ�� ���
			System.out.print(copy[i]);
			}else {
			// ������ �ε��� ��ȣ�� �ƴҰ��
			System.out.print(copy[i] + ", ");
			}
		}
		
		System.out.print("]");
		
		System.out.println();
		System.out.println(Arrays.toString(copy));
		// > Arrays.toString(����ϰ����ϴ¹迭��)
		// �հ� �ڿ� [], ���̿��� �ش� �迭�� �� �ε����� ��� ������
		// , �� �����ؼ� ����ָ鼭 �ϳ��� ���ڿ��� ��Ÿ���ִ� �޼ҵ�
		
		//���簡 �� �Ǿ����� Ȯ��
		System.out.println(origin==copy);
		
	}
	
	

}
