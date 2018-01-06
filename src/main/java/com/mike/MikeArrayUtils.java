package com.mike;

import java.util.ArrayList;

public class MikeArrayUtils {
    public static boolean arrayCopy(byte[] src, int srcStart, byte[] dst, int dstSart, int length ){
        if ((src.length < srcStart)
                | (dst.length < dstSart)
                | ((src.length - srcStart) < length)
                | ((dst.length - dstSart) < length)
                ){
            return false;
        }
        System.arraycopy(src, srcStart, dst, dstSart,length);
        return true;
    }

    public static ArrayList<byte[]> arraySplit(byte[] src, byte[] separator){
        ArrayList<byte[]> retArrayList = new ArrayList<byte[]>();
        ArrayList<Integer> indexArrayList = MikeArrayUtils.indexOfSeq(src,separator);
        if (indexArrayList.size() == 0){
            retArrayList.add(src);
        } else {
            retArrayList.add(MikeArrayUtils.getPart(src,0,indexArrayList.get(0)-1));
            for (int i = 0 ; i < (indexArrayList.size() - 1); i++){
                retArrayList.add(
                        MikeArrayUtils.getPart(
                                src,
                                indexArrayList.get(i) + separator.length,
                                indexArrayList.get(i+1)-1
                        )
                );
            }
            retArrayList.add(
                    MikeArrayUtils.getPart(
                            src,
                            indexArrayList.get(indexArrayList.size() - 1) + separator.length,
                            src.length - 1
                    )
            );
        }
        return retArrayList;
    }

    public static ArrayList<Integer> indexOfSeq(byte[] src, byte[] sec){
        ArrayList<Integer> retArrayList = new ArrayList<Integer>();
        if (sec.length <= src.length){
            for (int i = 0; i < (src.length - sec.length  + 1); i++){
                boolean mark = true;
                for (int j = 0 ; j < sec.length ; j++){
                    if (src[i + j] != sec[j]){
                        mark = false;
                        break;
                    }
                }
                if (mark){
                    retArrayList.add(i);
                }
            }
        }
        return retArrayList;
    }

    public static byte[] getPart(byte[] src, int start, int end){
        int count = end - start + 1;
        byte[] bs = new byte[count];
        System.arraycopy(src, start, bs, 0, count);
        return bs;
    }
}
