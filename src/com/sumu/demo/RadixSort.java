package com.sumu.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * 
 * @author sumu
 *
 */
public class RadixSort {
	public static void radixSort() {
		int[] array = new int[] { 2, 12, 42, 32, 3546, 1, 205, 3, 5, 64, 34, 67 };
		radixSort(array);
		System.out.print("radixSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	/**
	 * ��������
	 * ����˼��:����ÿ�������Ķ�����0~9�����ֹ��ɣ�ͨ����ȡÿ��λ����ֵ�����䵽��Ӧ��ֵ�ġ�Ͱ���У��Ӷ��ﵽ�����Ŀ��
	 * 1.�Ȼ�ȡ������������ֵ���Ӷ��õ�����λ����������������Ϊ3546�������λ������ǧλ��Ҳ������Ҫ���������Ĵ�
	 * 2.�ȴӸ�λ��ʼ���������飬��ȡÿ�����ĸ�λֵ����ŵ���Ӧ��ֵ�ġ�Ͱ����
	 * 3.Ȼ�������Ͱ��,���θ�ֵ��������
	 * 4.Ȼ��ʮλ���ظ�2,3���裬�������ƣ�ֱ�����λ���������
	 * 
	 * ���λ����(Least Significant Digit first)�������LSD�����ӵ�λ����λ������������Ӹ�λ��ʼ��
	 * ���λ����(Most Significant Digit first)�������MSD�����Ӹ�λ����λ�����������LSD�෴.
	 * 
	 * LSD�Ļ�������������λ��С�����У����λ����Ļ���ʹ��MSD��Ч�ʻ�ȽϺá�
	 * 
	 * ��չ:����������и�������Σ�
	 * �Ƚ������Ϊ���飬������������Ȼ��ֱ���л�����������ٽ�����������ڸ����������
	 * @param array
	 */
	private static void radixSort(int[] array) {
		// TODO Auto-generated method stub
		// ���Ȼ�ȡ���ֵ���õ����ֵ��λ��
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		int length = getNumberLength(max);// �õ��������λ��

		List<List<Integer>> queue = new ArrayList<>();// ������ʼ��0~9��Ͱ��ͨ������Ϊ����������ֵ������ĸ�Ͱ����
		for (int i = 0; i < 10; i++) {
			List<Integer> q = new ArrayList<>();
			queue.add(q);
		}

		for (int i = 0; i < length; i++) {
			// ��ȡ��Ӧ��λ��ֵ��iΪ0�Ǹ�λ��1��10λ��2�ǰ�λ��
			for (int j = 0; j < array.length; j++) {
				int value = array[j];
				int residue = (int) (value / Math.pow(10, i) % 10);// ��ȡ����iλ��ֵ���Ӹ�λ��ʼ
				queue.get(residue).add(value);// ����iλ��ֵ�ŵ���Ӧ��Ͱ������
			}
			sortFromQueue(array, queue);
		}
	}

	/**
	 * ��Ͱ�������������������������
	 * 
	 * @param array
	 * @param queue
	 */
	private static void sortFromQueue(int[] array, List<List<Integer>> queue) {
		int count = 0;
		for (int i = 0; i < queue.size(); i++) {
			while (queue.get(i).size() > 0) {
				array[count] = queue.get(i).remove(0);
				count++;
			}
		}
	}

	private static int getNumberLength(int number) {
		return String.valueOf(number).length();
	}

	public static void main(String[] args) {
		RadixSort.radixSort();
	}
}
