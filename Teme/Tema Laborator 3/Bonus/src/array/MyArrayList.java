package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList {
    private float[] array;
    private int maxCapacity;
    private int indexArray;

    public MyArrayList() {
        this.array = new float[10];
        this.maxCapacity = 10;
        this.indexArray = 0;
    }

    public MyArrayList(int dimention) {
        this.array = new float[dimention];
        this.indexArray = 0;
        this.maxCapacity = dimention;
    }

    public void add(float value) {
        if (indexArray >= maxCapacity) {
            float[] auxArray = new float[maxCapacity];
            for (int i = 0; i < maxCapacity; i++)
                auxArray[i] = this.array[i];
            maxCapacity = 2 * maxCapacity;
            this.array = new float[maxCapacity];
            for (int i = 0; i < maxCapacity / 2; i++)
                this.array[i] = auxArray[i];
        }
        this.array[indexArray] = value;
        this.indexArray++;
    }

    public boolean contains(float value) {
        for (int i = 0; i < indexArray; i++) {
            if (this.array[i] == value)
                return true;
        }
        return false;
    }

    public void remove(int index) {
        if (index >= indexArray || index < 0)
            System.out.println("Invalid index");
        else {
            for (int i = index; i < indexArray; i++) {
                array[i] = array[i + 1];
            }
            this.indexArray--;
        }
    }

    public float get(int index) {
        if (index >= indexArray || index < 0) {
            throw new RuntimeException("Invalid index");
        } else {
            return array[index];
        }
    }

    public int size() {
        return indexArray;
    }

    @Override
    public String toString() {
        String display = "";
        for (int i = 0; i < indexArray; i++)
            display += array[i] + " ";
        return display;
    }

    public int getIndexArray() {
        return indexArray;
    }
}

