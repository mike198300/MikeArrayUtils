package com.mike;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MikeArrayUtilsTest {

    @Test
    public void arrayCopy() {
        byte[] a = {1,2,3,4,5,6,7,8,9};
        byte[] b = new byte[20];
        MikeArrayUtils.arrayCopy(a,2,b,4,6);
        System.err.print(1);
    }

    @Test
    public void indexOfSeq() {
        byte[] a = {1,2,3,2,3,4,5,7,6,3,2,3,6,7,8,9,2,3};
        byte[] b = {2,3};
        ArrayList<Integer> c = new ArrayList<Integer>();
        c = MikeArrayUtils.indexOfSeq(a,b);
        System.out.print(c.toString());

    }

    @Test
    public void arraySplit() {
        byte[] a = {2,3,2,3,4,5,7,6,3,2,3,6,7,8,9,2,3};
        byte[] b = {2,3};
        ArrayList<byte[]> c = new ArrayList<byte[]>();
        c = MikeArrayUtils.arraySplit(a,b);
        System.out.print(c.toString());
    }
}