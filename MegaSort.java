/**
* Mega Sort
* @author Eli Gruzman
* 
*/

import java.util.*;
import java.io.*;

public class MegaSort
{
    public static void sort(int [] arr)
    {
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int [] arr, int left, int right) 
    { 
        if (left < right) 
        { 
            int middle = (left+right)/2;

            //Sort 1st half
            sort(arr, left, middle);
            //Sort 2nd half
            sort(arr , middle+1, right); 
            //Merge sorted halves
            merge(arr, left, middle, right); 
        } 
    }

    public static void merge(int [] arr, int left, int middle, int right) 
    { 
        //Size left array
        int arr1Size = middle - left + 1; 
        //Size right array
        int arr2Size = right - middle;

        //Temporary arrays for storing
        int leftTemp[] = new int [arr1Size]; 
        int rightTemp[] = new int [arr2Size]; 

        for (int i = 0; i < arr1Size; i++)  
            leftTemp[i] = arr[left+i];

        for (int j = 0; j < arr2Size; j++) 
            rightTemp[j] = arr[middle+j+1]; 
        
        int i = 0;
        int j = 0;
        int k = left;

        while (i < arr1Size && j < arr2Size) 
        { 
            if (leftTemp[i] <= rightTemp[j]) 
            { 
                arr[k] = leftTemp[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = rightTemp[j]; 
                j++; 
            } 
            k++; 
        } 
  
        //Copy remaining left subarray elements
        while (i < arr1Size) 
        { 
            arr[k] = leftTemp[i]; 
            i++; 
            k++; 
        } 
  
        //Copy remaining right subarray elements
        while (j < arr2Size) 
        { 
            arr[k] = rightTemp[j]; 
            j++; 
            k++; 
        } 
    }  

    public static void main(String [] args) throws IOException
    {
        try
        {
            File file = new File(args[0]);
            Scanner scan = new Scanner(file);
            int i = 0;
            while (scan.hasNextInt())
            {
                i++;
                scan.nextInt();
            }

            int [] arr = new int[i];
            Scanner newScan = new Scanner(file);

            for (int j = 0; j < arr.length; j++)
            {
                arr[j] = newScan.nextInt();
                System.out.println(arr[j]);
            }

            sort(arr);
            System.out.println("\n\n\n\n\nNOW FOR THE SORTED PART");
            for (int j = 0; j < arr.length; j++)
                System.out.println(arr[j]);
        }
        
        catch(IOException e)
        {
            System.out.println("Error! File not found.");
        }   
    }
}