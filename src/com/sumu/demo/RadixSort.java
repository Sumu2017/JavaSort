package com.sumu.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
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
	 * 基数排序
	 * 核心思想:利用每个整数的都是由0~9的数字构成，通过获取每各位的数值，分配到对应数值的“桶”中，从而达到排序的目的
	 * 1.先获取数组里面最大的值，从而得到最大的位数，比如该数组最大为3546，则最大位数就是千位，也就是需要分配整理四次
	 * 2.先从个位开始，遍历数组，获取每个数的个位值，存放到对应数值的“桶”中
	 * 3.然后遍历“桶”,依次赋值到数组中
	 * 4.然后十位，重复2,3步骤，依次类推，直到最大位，排序完成
	 * 
	 * 最低位优先(Least Significant Digit first)法，简称LSD法：从低位往高位排序遍历，即从个位开始，
	 * 最高位优先(Most Significant Digit first)法，简称MSD法：从高位往低位排序遍历，与LSD相反.
	 * 
	 * LSD的基数排序适用于位数小的数列，如果位数多的话，使用MSD的效率会比较好。
	 * 
	 * 扩展:如果数组中有负数该如何？
	 * 先将数组分为两组，负数跟正数，然后分别进行基数排序，最后再将正数数组接在负数数组后面
	 * @param array
	 */
	private static void radixSort(int[] array) {
		// TODO Auto-generated method stub
		// 首先获取最大值，得到最大值的位数
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		int length = getNumberLength(max);// 得到最大数的位数

		List<List<Integer>> queue = new ArrayList<>();// 用来初始化0~9的桶，通过余数为几来决定数值存放在哪个桶里面
		for (int i = 0; i < 10; i++) {
			List<Integer> q = new ArrayList<>();
			queue.add(q);
		}

		for (int i = 0; i < length; i++) {
			// 获取对应的位的值（i为0是各位，1是10位，2是百位）
			for (int j = 0; j < array.length; j++) {
				int value = array[j];
				int residue = (int) (value / Math.pow(10, i) % 10);// 获取整数i位的值，从个位开始
				queue.get(residue).add(value);// 根据i位的值放到对应的桶子里面
			}
			sortFromQueue(array, queue);
		}
	}

	/**
	 * 将桶子里面的数重新整理到数组里面
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
