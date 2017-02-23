package org.lichess.clockencoder;

public class LinearEstimator {

    public static void encode(int[] dest, int startTime, int endTime) {
        encode(dest, -1, startTime, dest.length, endTime);
    }

    public static void decode(int[] dest, int startTime, int endTime) {
        decode(dest, -1, startTime, dest.length, endTime);
    }

    private static void encode(int[] dest, int startIdx, int start,
                               int endIdx, int end) {
        int midIdx = (startIdx + endIdx) >> 1;
        if (startIdx == midIdx) return;

        int mid = dest[midIdx];

        dest[midIdx] -= (start + end) >> 1;

        encode(dest, startIdx, start, midIdx, mid);
        encode(dest, midIdx, mid, endIdx, end);
    }

    private static void decode(int[] dest, int startIdx, int start,
                               int endIdx, int end) {
        int midIdx = (startIdx + endIdx) >> 1;
        if (startIdx == midIdx) return;

        dest[midIdx] += (start + end) >> 1;

        int mid = dest[midIdx];

        decode(dest, startIdx, start, midIdx, mid);
        decode(dest, midIdx, mid, endIdx, end);
    }
}
