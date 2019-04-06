package com.lingb.mystudy.algorithm.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lingb on 2018-12-21
 */
    public class MedianHolder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });


    private void modifyTwoHeapsSize() {
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    public void addNumber(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }
            if (minHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        modifyTwoHeapsSize();
    }

    public Double getMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }
         Integer maxHeapHead = maxHeap.peek();
         Integer minHeapHead = minHeap.peek();
        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return Double.valueOf((maxHeapHead + minHeapHead) / 2);
        }
        return Double.valueOf(maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead);
    }


    class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        boolean err = false;
        int testTimes = 200000;
//        for (int i = 0; i != testTimes; i++) {
//            int len = 30;
//            int maxValue = 1000;
//            int[] arr = getRandomArray(len, maxValue);
            int[] arr = {5,2,3,4,1,6,7,0,8};
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;

                printArray(arr);
//                break;
            }
//        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}