package com.kh.array;

import java.util.Arrays;

// 배열 복사
public class B_ArrayCopy {
	
	/*
	 * *배열복사
	 * 배열을 복사하는 과정
	 * - 얕은 복사 : 복사하는 척만하는 것
	 * - 깊은 복사 : 제대로 복사 하는 것
	 * 
	 * 
	 */
	public void method1() {
		
		//원본배열
		int[] origin = {1,2,3,4,5};
		System.out.println("==원본 배열 출력 ==");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i]+" ");
		}
		//복사본배열
		int[] copy = origin;
		System.out.println();
		System.out.println("===복사본 배열 출력");
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i]+ " ");
		}
		// > 콘솔창에 출력된 결과로는 복사가 잘 된 것 같음
		copy[2] = 99;
		
		System.out.println();
		System.out.println("=== 복사본 배열 수정 후 ===");
		System.out.println("== 원본 배열 출력 ==");
		for(int i = 0; i < origin.length; i++) {
			
			System.out.print(origin[i] + " ");
		}
		
		System.out.println();
		System.out.println("== 복사본 배열 출력 ==");
		for(int i = 0; i <copy.length; i++) {
			System.out.print(copy[i]+ " ");
		}
		// > 복사본 배열만을 가지고 수정을 했는데
		// 복사본 뿐만 아니라 원본 배열도 같이 수정이 된 것 같다.
		// (즉, 원본 배열의 값이 훼손이 되었다)
		// > 복사가 제대로 안된 상황임...
		
		
		
		// 얕은 복사 : 배열의 "주소값" 이 복사되어
		// 			 원본과 복사본이 같은 상태!!
		// > 원본과 복사본의 "주소값" 이 같은 상태를 얕은 복사라고 함
		
		// 주소값들 출력
		System.out.println();
		System.out.println("원본 주소값 : " + origin);
		System.out.println("복사본 주소값 : " + copy);
		
		//해키코드들 출력
		System.out.println("원본 해시코드 : " + origin.hashCode());
		System.out.println("복사본 해시코드 "+  copy.hashCode());
		
		// 원본과 복사본의 주소값을 동등비교
		System.out.println(origin == copy);
		
		// > 배열 복사가 제대로 됬는지 확인하고자 한다면
		// for문을 이용해서 내용을 일일히 수정 전후로 출력해봐도 되지만
		// 단순히 원본과 복사본의 주소값을 비교해서도 확인할 수 있다.
		
		
	} // emthod1 메소드 영역 끝
	
	// 깊은 복사 - 총 4가지 방법
	public void method2() {
		//1. for문을 이용하는 방법
		// > 새로운 배열을 생성한 후 각 인덱스 별 내부 값을
		// for문을 이용해서 일일이 대입하는 방법
		
		// 원본 배열
		int[] origin = {1,2,3,4,5};
		
		// 복사본 배열
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
		//각각 출력
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i]+" ");
			
		}
		System.out.println();
		System.out.println("===복사본 배열 출력==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		// copy 배열 수정
		copy[2] = 99;
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i]+" ");
			
		}
		
		System.out.println();
		System.out.println("==== 복사본 배열 출력 ==");
		
		for(int i = 0; i < origin.length; i++) {
			System.out.println(copy[i] + " ");
		}
		// > 복사본 배열의 내용을 수정하더라도
		// 원본 배열의 내용은 보존되는 것을 볼 수 있다.
		// > 깊은 복사 : 주소값을 복사하는 것이 아닌
		// 			   실제 배열 내용 자체를 복사 뜨는 방법
		
		// 주소값들 출력
		System.out.println();
		System.out.println("원본 주소값 : " + origin);
		System.out.println("복사본 주소값 : " + copy);
		
		// 해시코드 출력
		System.out.println("원본 해시코드 : " + origin.hashCode());
		System.out.println("복사본 해시코드 : " + copy.hashCode());
	
		// 동등비교
		System.out.println(origin == copy); //false
		
	} // method2 메소드 영역 끝
	
	public void method3() {
		
		// 2. 새로운 배열을 생성 후
		// System 클래스에서 제공하는 arraycopy 메소드를 이용하는 방법
		
		// 원본 배열
		int[] origin = {1,2,3,4,5};
		
		//복사본 배열
		int [] copy = new int [10];
		// > 일부러 원본 배열의 크키보다 넉넉하게 만듬
		// 0 0 0 0 0 0 0 0 0 0 (기본값)
		
		// * System 클래스의 arraycopy 메소드
		// 배열의 깊은 보가를 위해 정의된 메소드
		// [ 표현법 ]
		// System.arraycopy(원본배열명, 원본배열의복사를시작할인덱스 복사본배열명,
		//                  복사본배열의 복사될시작인덱스,복사할갯수);
		
		System.arraycopy(origin, 0, copy, 0, 5);
		// 1 2 3 4 5 0 0 0 0 0
		
		//System.arraycopy(origin, 0, copy, 2, 5);
		// 0 0 1 2 3 4 5 0 0 0
		//System.arraycopy(origin, 0, copy, 1, 3);
		// 0 1 2 3 0 0 0 0 0 0 
		
		//System.arraycopy(origin, 0, copy, 9, 2);
		// 0 0 0 0 0 0 0 0 3 /4   (인덱스 범위 벗어남)
		// > ARrrayIndexOutOfBonudException 발생
		// 복사 후 붙여넣기 과정에서 인덱스 범위를 벗어났기 때문에 발생함
		
		
		// > 복사후 남는 부분은 원래의 값으로 계속 유지가 됨
		
		
		// 복사본 배열만 출력
		for(int i = 0; i < copy.length; i++)
		{
			System.out.print(copy[i]+ " ");
		}
		
		// 깊은 복사가 잘 되었는지 확인
		System.out.println();
		System.out.println("원본 주소값 : " + origin);
		System.out.println("복사본 주소값 : " + copy);
		
		
		
	}// method3 메소드 영역 끝
	public void method4() {
		// 3. Arrays 클래스에서 제공하는 copyOf 라는 메소드를 이용하는 방법
	
		//원본 배열
		int[] origin = {1,2,3,4,5};
		
		// 복사본 배열
		
		// * Arrays 클래스의 copyOf 메소드
		// 깊은복사를 해주는 메소드
		// [ 표현법 ]
		// 복사본 배열명 = Arrays.copyOf(원본배열명 , 복사할갯수);
		
		//복사본 배열
		int[] copy = Arrays.copyOf(origin, 7);
		
		//복사본 배열만 출력
		
		for(int i = 0; i < copy.length; i++) {
			
			System.out.print(copy[i] + " ");
			
		}
		//복사가 잘 일어났는지 확인
		System.out.println();
		System.out.println("원본 해시코드 :" + origin.hashCode());
		System.out.println("복사본 해시코드 : " + copy.hashCode());
	
	} // method4 메소드 영역 끝
	
	public void method5() {
		
		// 4. clone 이라는 메소드를 이용하는 방법
		
		// 원본 배열
		int[] origin = {1,2,3,4,5};
		
		// * clone 메소드
		// 배열의 깊은 복사를 해주는 메소드
		// [ 표현법 ]
		// 복사본배열명 = 원본 배열명.clone();
		
		//복사본 배열
		int[] copy;
		copy = origin.clone();
		// > 인덱스 직접지정 x, 복사할갯수 지정 x
		// 즉, 원본 배열과 완전히 똑같이 복제해 오겠다.
		
		// 복사본 배열만 출력
		/*
		for(int i = 0; i<copy.length; i++) {
			System.out.println(copy[i] + " ");
		
		}*/
		
		// > 배열의 내용물을 출력하고 싶으나
		//  "[1,2,3,4,5]" 형식으로 예쁘게 출력하고 싶음
		System.out.print("[");
		
		for(int i = 0; i < copy.length; i++) {
			
			if(i == copy.length-1) {
			// 마지막 인덱스 번호일 경우
			System.out.print(copy[i]);
			}else {
			// 마지막 인덱스 번호가 아닐경우
			System.out.print(copy[i] + ", ");
			}
		}
		
		System.out.print("]");
		
		System.out.println();
		System.out.println(Arrays.toString(copy));
		// > Arrays.toString(출력하고자하는배열명)
		// 앞과 뒤에 [], 사이에는 해당 배열의 각 인덱스에 담긴 값들을
		// , 로 구분해서 찍어주면서 하나의 문자열로 나타내주는 메소드
		
		//복사가 잘 되었는지 확인
		System.out.println(origin==copy);
		
	}
	
	

}
