package com.sumu.demo;

public class InsertSort {
	/**
	 * ֱ�Ӳ�������
	 * ����˼��:�ӵڶ�������ʼ��������ǰ��������жԱȣ��Ӻ���ǰ����
	 * ������ľͽ����������һλ��ֱ������С�ģ���ôС�ĺ���һ��λ�þ��Ǹ�ֵ��λ��
	 */
	public static void directInsertSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		for (int i = 1; i < array.length; i++) {
			int value = array[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				// ��������С�ıȣ��Ӻ���ǰ
				if (value < array[j]) {
					// ��ǰ��������Ľ��жԱȣ����С���򽫸�ֵ������һλ��
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = value;
		}
		System.out.print("DirectInsertSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	/**
	 * ���ַ���������
	 * ����˼��:˼���ֱ�Ӳ����������һ�£�ֻ��Ѱ�Ҳ����λ�õķ�ʽ��ͬ��
	 * ֱ�Ӳ��������Ǹ�ǰ������������Ӵ�Сһ��һ���Ľ��жԱȣ�ֱ���ҵ���valueС��
	 * �����ַ��������������в���λ�ã��ȸ��������������м��ֵ���жԱȣ������value��
	 * ��˵��λ�����м�ֵ����ߣ��������м�ֵ���ұߣ��Դ�ѭ����ֱ���ҵ���ȷindex��Ȼ��index�����ֵ�������һλ��
	 * �ó�λ�ã�Ȼ�����
	 */
	public static void binaryInsertSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		for (int i = 0; i < array.length; i++) {
			int value = array[i];// �������ֵ
			int left = 0;// ����������ߵ��±�
			int right = i - 1;// ���������ұߵ��±�
			int mid = 0;
			while (left <= right) {
				// ���ַ����ң��Ȼ�ȡ�м��ֵ��Ȼ�����ǰֵ�Աȣ�
				// ������Сleft-right������ֱ���ҵ����ʵ�λ��
				mid = (left + right) / 2;
				if (array[mid] > value) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				// ��left�ұߵ�ֵȫ������ƣ��ó�λ�õ�value�Ĳ���
				array[j + 1] = array[j];
			}
			if (left != i) {
				// �������Ҫ�����λ���������ֵ��λ����ͬ������Ҫ�ٽ��н���
				array[left] = value;
			}
		}
		System.out.print("BinaryInsertSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	/**
	 * ϣ������(���ȶ�����) �����ֱ�Ӳ�������Ԫ��֮��Ľ�����������
	 * ����˼�룺ѡ��һ������(һ��ѡȡ���鳤�ȵ�һ��)��Ȼ�����������������ֳɺü��飬�ٽ�ÿ��ֱ����ֱ�Ӳ�������
	 * Ȼ�������ݼ��ظ����飬����ֱ������Ϊ0����
	 */
	public static void shellSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		int d = array.length;//����
		while (true) {
			d = d / 2;
			System.out.println("����="+d);
			for (int i = 0; i < d; i++) {
				//������������Ϊd��,Ȼ���ٶ�ÿ�����ֱ�Ӳ�������
				//����dΪ5��ʱ��5��Ϊ{5,10},{6},{7},{8},{9}����������Ϊ�±�
				System.out.print("��"+i+"��  ==");
				
				//��ÿ���������ֱ�Ӳ�������
				for (int j = i+d; j < array.length; j=j+d) {
					System.out.print(j+" ");
					int temp=array[j];
					int k=0;
					for (k = j-d;k>=i&&temp<array[k]; k=k-d) {
						array[k+d]=array[k];
					}
					array[k+d]=temp;
				}
				System.out.println("");
			}
			if (d == 1) {
				break;
			}
		}

		System.out.print("\nshellSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	

	public static void main(String[] args) {
		InsertSort.directInsertSort();
		InsertSort.binaryInsertSort();
		InsertSort.shellSort();
	}
}
