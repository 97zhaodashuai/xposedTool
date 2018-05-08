package com.zhaodsh.xposedtool;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

public class g {
    private byte[] a;
    private byte[] b;
    private byte[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private byte[] h;
    private boolean i = true;
    private int j;
    private Random k = new Random();


    private int b() {
        return k.nextInt();
    }


    public byte[] b(byte[] p0, int p1, int p2, byte[] p3) {

        byte v1 = 1;
        byte v4 = 0;
        int v7 = 8;
        this.a = new byte[v7];
        this.b = new byte[v7];
        this.f = v1;
        this.g = v4;
        this.e = v4;
        this.d = v4;
        this.h = p3;
        this.i = true;
        this.f = ((p2 + 10) % 8);
        if (this.f != 0) {
            this.f = (this.f - 8);
        }

        this.c = new byte[((this.f + p2) + 10)];
        this.a[0] = (byte) (((this.b() & 0xF8) | this.f));


        int i = 1;
        while ((i <= this.f)) {
            this.a[i] = (byte) ((this.b() & 0xff));
            i++;
        }

        this.f = (this.f + 1);

        i = 0;
        while ((i < 8)) {
            this.b[i] = 0;
            i++;
        }


        this.g = 1;

        while ((this.g <= 2)) {
            if (this.f < 8) {
                int v2 = this.f;
                this.f = (v2 + 1);
                this.a[v2] = (byte) ((this.b() & 0xff));
                this.g = (this.g + 1);
            }
            if (this.f != 8) {
                continue;
            } else {
                this.a();
            }
        }

        int v0 = 0;
        int v2 = p1;
        int v3 = p2;

        while ((v3 > 0)) {
            if (this.f >= 8) {
                v0 = v2;
                v2 = v3;
            } else {
                int v6 = this.f;
                this.f = (v6 + 1);
                v0 = (v2 + 1);
                this.a[v6] = p0[v2];
                v2 = (v3 - 1);
            }
            if (this.f != 0) {
                v3 = v2;
                v2 = v0;
            } else {
                this.a();
                v3 = v2;
                v2 = v0;
                continue;
            }
        }
        this.g = 1;
        while ((this.g <= 7)) {
            if (this.f < 8) {
                int tmp = this.f;
                this.f = (tmp + 1);
                this.a[tmp] = v4;
                this.g = (this.g + 1);
            }
            if (this.f != 8) {
                continue;
            } else {
                this.a();
            }
        }
        return this.c;
    }


    private void a() {
        int v7 = 8;
        byte v6 = 0;
        this.f = v6;
        while ((this.f < v7)) {
            if (!this.i) {
                byte[] v0 = this.a;
                int v1 = this.f;
                v0[v1] = (byte) ((v0[v1] ^ this.c[(this.e + this.f)]));
            } else {
                byte[] v0 = this.a;
                int v1 = this.f;
                v0[v1] = (byte) ((v0[v1] ^ this.b[this.f]));
            }
            this.f = (this.f + 1);
        }
        System.arraycopy(this.a(this.a), v6, this.c, this.d, v7);
        this.f = v6;
        while ((this.f < 8)) {
            byte[] v0 = this.c;
            int v1 = (this.d + this.f);
            v0[v1] = (byte) ((v0[v1] ^ this.b[this.f]));
            this.f = (this.f + 1);
        }
        System.arraycopy(this.a, v6, this.b, v6, v7);
        this.e = this.d;
        this.d = (this.d + 8);
        this.f = v6;
        this.i = false;
        return;
    }

    private byte[] a(byte[] paramArrayOfByte) {
        int m = 16;
        try {
            long l1 = a(paramArrayOfByte, 0, 4);
            long l2 = a(paramArrayOfByte, 4, 4);
            long l3 = a(h, 0, 4);
            long l4 = a(h, 4, 4);
            long l5 = a(h, 8, 4);
            long l6 = a(h, 12, 4);
            long l7 = 0L;
            while (m > 0) {
                l7 = l7 + (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
                l1 = l1 + ((l2 << 4) + l3 ^ l2 + l7 ^ (l2 >>> 5) + l4) & 0xFFFFFFFF;
                l2 = l2 + ((l1 << 4) + l5 ^ l1 + l7 ^ (l1 >>> 5) + l6) & 0xFFFFFFFF;
                m--;
            }
            ByteArrayOutputStream v1 = new ByteArrayOutputStream(8);
            DataOutputStream v2 = new DataOutputStream(v1);
            v2.writeInt((int) l1);
            v2.writeInt((int) l2);
            v2.close();
            paramArrayOfByte = v1.toByteArray();
            return paramArrayOfByte;
        } catch (java.io.IOException e) {

        }
        return null;
    }


    static public long a(byte[] p0, int p1, int p2) {
        int v5 = 8;
        long v1 = 0;
        int v0 = 0;
        int v7 = 0;
        if (p2 <= 8) {
            v0 = (p1 + p2);
        } else {
            v0 = (p1 + 8);
        }
        while ((p1 < v0)) {
            v1 = ((v1 << v5) | (long) ((p0[p1] & 255)));
            v7 = (p1 + 1);
        }
        return ((v1 >> 32) | (0xFFFFFFFF & v1));
    }


}
