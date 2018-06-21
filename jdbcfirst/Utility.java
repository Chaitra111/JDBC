package com.bridgelabz.jdbcfirst;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Chaitra Ankolekar 
 * Date : 18/05/2018 
 * Purpose : Two Strings are Anagram or not
 */
public class Utility {
	// Method to get string value
	public static String getString() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter the input string");
		return scanner.nextLine();
	}

	// Method to get double value
	public static double getDouble() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter the double");
		return scanner.nextDouble();
	}
	public static Long getlong() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the long");
		return scanner.nextLong();
		}
		// Method to get integer value
	public static int getInteger() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter the integer");
		return scanner.nextInt();
	}

	// Method to check leap year or not
	public static void leapyear(int year, int digits) {
		if (digits == 4) {
			if ((year % 4 == 0 || year % 400 == 0) && (year % 100 != 0)) {
				System.out.println("Leap year");
			} else {
				System.out.println("Not a Leap year");
			}
		}
	}

	// Method to find number of digits
	public static int noOfDigits(int integer) {
		int count = 0;
		while (integer != 0) {
			integer = integer / 10;
			count++;
		}
		return count;
	}

	// Method to find prime factor
	public void toFindPrime(int number) {
		int i = 2;
		while (number > 1 && i * i <= number) {
			if (number % i == 0) {
				number = number / i;
				System.out.println(+i);
			} else {
				i++;
			}
		}
	}

	// Method to find tables of power of 2
	public static int findPower(int power) {
		int out = 1;
		for (int i = 1; i < power; i++) {
			out = (2 * out);
			System.out.println(out);
		}
		return out;
	}

	// Method to find the harmonic value
	public static float harmonicvalue(int number) {
		float out = 1;
		if (number != 0) {
			for (float i = 2; i <= number; i++) {
				out = out + 1 / i;
			}
		}
		return out;
	}

	// Method to find power of 2
	public static int power(int pwr) {
		int out = 1;
		for (int i = 1; i <= pwr; i++) {
			out = (2 * out);
		}
		return out;
	}

	// Method to find prime number
	public void prime() {
		for (int i = 2; i < 1000; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.println(i);
				//palindrome(i);
				}
		}
	}

	// Method to swap characters
	public static void swap(char[] chars, int start, int end) {
		{
			char temp = chars[start];
			chars[end] = chars[start];
			chars[start] = temp;
		}
	}

	// Method to check given string is anagram
	public static boolean anag(String s1,String s2)
    {    
        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();
        Arrays.sort(ch1);//sort string1
        Arrays.sort(ch2);//sort string2
        boolean res=Arrays.equals(ch1,ch2);
        if(res)
        {
            return true;
        }
        else
        return false;
    }
	
	// Method to find palindrome
	public void palindrome(int number) {
		int rev = 0;
		for (int i = 2; i < 1000; i++) {
			i = number;
			while (number != 0) {
				int rem = number % 10;
				rev = rem * 10 + rev;
				number /= 10;
			}
			if (rev == i) {
				System.out.println(rev);
			}
		}
	}

	// Method to find temperature
	public void tempConvert(double celcius, double fahrenhit) {
		System.out.println("Temperature conversion from celcius to fahrenhit:" + ((celcius * 9.0) / 5.0) + 32);
		System.out.println("Temperature conversion from fahrenhit to celcius:" + ((fahrenhit - 32.0) * 5.0) / 9.0);
	}

	// BubbleSort method for integer
	static int[] array;

	public int[] bubblesortInteger(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	// BubbleSort method for String
	public static String[] bubblesortString(String[] string) {
		for (int i = 0; i < string.length; i++) {
			for (int j = i + 1; j < string.length; j++) {
				if (string[i].compareTo(string[j]) > 0) {
					String temp = string[i];
					string[i] = string[j];
					string[j] = temp;
				}
			}
		}
		return string;
	}

	// InsertionSort method for integer
	public int[] insertionSortInteger(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && (arr[j] > key)) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

	// InsertionSort method for String
	public String[] insertionsortStr(String[] str) {
		for (int i = 1; i < str.length; i++) {
			String key = str[i];
			int j = i - 1;
			while (j >= 0 && str[j].compareTo(key) > 0) {
				str[j + 1] = str[j];
				j--;
			}
			str[j + 1] = key;
		}
		return str;
	}

	// BinarySearch method for integer
	public void binarySearch(int arr[], int first, int last, int key) {
		int mid = (first + last) / 2;
		while (first <= last) {
			if (arr[mid] < key) {
				first = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("Element is found at index: " + mid);
				break;
			} else {
				last = mid - 1;
			}
		}
		if (first > last) {
			System.out.println("Element is not found!");
		}
	}

	// BinarySearch method for String
	public void binarySearchString(String[] str1, String key, int first, int last) {
		int mid = (first + last) / 2;
		while (first <= last) {
			{
				if (str1[mid].compareTo(key) < 0) {
					first = mid + 1;
				}
				if (str1[mid].equals(key)) {
					System.out.println("Element is found at index: " + mid);
					break;
				} else {
					last = mid - 1;
				}
				if (first > last) {
					System.out.println("Element is not found!");
				}
			}
		}
	}

	// Method to calculate elapsed time
	public long startTime = 0;
	public long stopTime = 0;
	public long elapsed;
	// to start timer
	public void start() {
		startTime = System.currentTimeMillis();
		System.out.println("Start Time is: " + startTime);
	}

	// to stop timer
	public void stop() {
		stopTime = System.currentTimeMillis();
		System.out.println("Stop Time is: " + stopTime);
	}

	public long getElapsedTime() {
		elapsed = stopTime - startTime;
		return elapsed;
	}

	public <T extends Comparable> void binarySearchG(T[] array2, int first, int last, T key) {
		int mid = (first + last) / 2;
		while (first <= last) {
			if (array2[mid].compareTo(key) < 0) {
				first = mid + 1;
			} else if (array2[mid].equals(key)) {
				System.out.println("Element is found at index: " + mid);
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Element is not found!");
		}
	}
	public static void mergeSort(String[] array) {
		if (array.length >= 2) {
			String[] left = new String[array.length / 2];
			String[] right = new String[array.length - array.length / 2];

			for (int i = 0; i < left.length; i++) {
				left[i] = array[i];
			}

			for (int i = 0; i < right.length; i++) {
				right[i] = array[i + array.length / 2];
			}

			mergeSort(left);
			mergeSort(right);
			merge(array, left, right);
		}
	}

	public static void merge(String[] array, String[] left, String[] right) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i].compareTo(right[j]) < 0) {
				array[k] = left[i];
				i++;
				k++;
			} else {
				array[k] = right[j];
				j++;
				k++;
			}
		}
		while (i < left.length) {
			array[k] = left[i];
			k++;
			i++;
		}
		while (j < right.length) {
			array[k] = right[j];
			k++;
			j++;
		}

		return;
	}

	// BubbleSort method for integer
	public <T extends Comparable> T[] bubblesort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	public <T extends Comparable> T[] insertionsortG(T[] str) {
		for (int i = 1; i < str.length; i++) {
			T key = str[i];
			int j = i - 1;
			while (j >= 0 && str[j].compareTo(key) > 0) {
				str[j + 1] = str[j];
				j--;
			}
			str[j + 1] = key;
		}
		return str;
	}

	
	public static  int day(int day,int month,int year)
	{
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		int y = year - (14 - month) / 12;
		int x = y + y / 4 - y / 100 + y / 400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31 * m) / 12) % 7;
		return d;
	}
		
	public static boolean dateValidator(int day, int month, int year) {
        boolean b = false;
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            b = false;
        } else if (month == 2) {
            if (year % 100 == 0) {
                if ((year % 400 != 0) && day > 28) {
                    b = false;
                } else if ((year % 400 == 0) && day > 29) {
                    b = false;
                } else
                    b = true;
            }
        }
        if (year % 100 != 0) {
            if ((year % 4 != 0) && day > 28) {
                b = true;
            } else if ((year % 4 == 0) && day > 29) {
                b = false;
            } else {
                b = true;
            }
        }
        if (day > 31) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }
	public static boolean findPrime(int number) {
		if (number == 0 || number == 1) {
			return false;
		}
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
}

	public static int scanner(int value) {
		return value;
	}
	public static Date printDate(String date) throws java.text.ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		return sdf.parse(date);
}

	
}
