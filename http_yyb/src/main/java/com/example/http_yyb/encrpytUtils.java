package com.example.http_yyb;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

public class encrpytUtils {
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
//    private Random k = 5;

    private int k = 5;
    private int b() {
        return k;
    }

    public  byte[] encode(byte[] param){

        byte[] key = {0x6a, 0x69, 0x2a, 0x39, 0x5e, 0x26, 0x34,0x33, 0x55, 0x30, 0x58, 0x2d, 0x7e,0x2e,0x2f,0x28};
        return a(param, key);
    }


    public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        return b(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
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
            this.f = (8- this.f);
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
            if (this.f != 8) {
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
        this.f = 0;
        byte[] bArr;
        while (this.f < 8) {
            int i;
            if (this.i) {
                bArr = this.a;
                i = this.f;
                bArr[i] = (byte) (bArr[i] ^ this.b[this.f]);
            } else {
                bArr = this.a;
                i = this.f;
                bArr[i] = (byte) (bArr[i] ^ this.c[this.e + this.f]);
            }
            this.f++;
        }
        System.arraycopy(a(this.a), 0, this.c, this.d, 8);
        this.f = 0;
        while (this.f < 8) {
            bArr = this.c;
            int i = this.d + this.f;
            bArr[i] = (byte) (bArr[i] ^ this.b[this.f]);
            this.f++;
        }
        System.arraycopy(this.a, 0, this.b, 0, 8);
        this.e = this.d;
        this.d += 8;
        this.f = 0;
        this.i = false;
    }



    private byte[] a(byte[] bArr) {
        int i = 16;
        try {
            long a = a(bArr, 0, 4);
            long a2 = a(bArr, 4, 4);
            long a3 = a(this.h, 0, 4);
            long a4 = a(this.h, 4, 4);
            long a5 = a(this.h, 8, 4);
            long a6 = a(this.h, 12, 4);
            long j = 0;
            long j2 = -1640531527 & 4294967295L;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    j = (j + j2) & 4294967295L;
                    a = (a + ((((a2 << 4) + a3) ^ (a2 + j)) ^ ((a2 >>> 5) + a4))) & 4294967295L;
                    a2 = (a2 + ((((a << 4) + a5) ^ (a + j)) ^ ((a >>> 5) + a6))) & 4294967295L;
                    i = i2;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) a);
                    dataOutputStream.writeInt((int) a2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception e) {
            return null;
        }
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
            p1++;
        }
        return ((v1 >> 32) | (0xFFFFFFFF & v1));
    }

    protected byte[] d() {
        return "ji*9^&43U0X-~./(".getBytes();
    }


    ////////////////////////////////////////////////////////////////////////////
    //doecode

    public byte[] decode(byte[] param){
        byte[] key = {0x6a, 0x69, 0x2a, 0x39, 0x5e, 0x26, 0x34,0x33, 0x55, 0x30, 0x58, 0x2d, 0x7e,0x2e,0x2f,0x28};
        return aa(param, 0, param.length, key);
    }


    public byte[] aa(byte[] p0, int p1, int p2, byte[] p3)    //method@509c
    {
        byte v9 = 1;
        byte v2 = 0;
        byte v3 = 0;
        int v8 = 8;
        this.e = v2;
        this.d = v2;
        this.h = p3;
        byte[] v1 = new byte[(p1 + 8)];
        if (p2 % 8 == 0 &&  p2 >= 16) {
            this.b = this.a(p0, p1);
            if (this.b != null) {
                this.f = (this.b[v2] & 7);
                int v4 = ((p2 - this.f) - 10);
                if (v4 >= 0) {  //?
                    int a = p1;
                    while ((a < v1.length)) {
                        v1[a] = v2;
                        a++;
                    }
                    byte[] v0 = new byte[v4];
                    this.c = v0;
                    this.e = v2;
                    this.d = v8;
                    this.j = v8;
                    this.f = (this.f + 1);
                    this.g = v9;
                    v0 = v1;
                    while ((this.g <= 2)) {
                        if (this.f < v8) {
                            this.f = (this.f + 1);
                            this.g = (this.g + 1);
                        }
                        if (this.f ==v8){
                            if (!this.b(p0, p1, p2)) {
                                return null;
                            }else{
                                v0 = p0;
                            }
                        }
                    }
                    int a1 = v4;
                    int a2 = v2;
                    byte[] b5 = v0;
                    while ((a1 != 0)) {
                        if (this.f < v8) {
                            this.c[a2] = (byte) (b5[((this.e + p1) + this.f)] ^ this.b[this.f]);
                            a2++;
                            a1--;
                            this.f = (this.f + 1);
                        }
                        if (this.f == v8) {
                            this.e = (this.d - 8);
                            if (!this.b(p0, p1, p2)) {
                                return null;
                            }else{
                                b5 = p0;
                            }
                        }
                    }
//                    this.g = v9;
//                    byte[] b8 = b5;
//                    while ((this.g < v8)) {
//                        if (this.f < v8) {
//                            if ((b8[((this.e + p1) + this.f)] ^ this.b[this.f]) == 0) {
//                                return null;
//                            }
//                            this.f = this.f + 1;
//                        }
//                        if (this.f == v8) {
//                            this.e = this.d;
//                            if (!this.b(p0, p1, p2)) {
//                                return null;
//                            }
//                            b8 = p0;
//                            this.g = (this.g + 1);
//                        }
//                    }
                    v0 = this.c;
                    return v0;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }




    public byte[] a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.e = 0;
        this.d = 0;
        this.h = bArr2;
        byte[] bArr3 = new byte[(i + 8)];
        if (i2 % 8 != 0 || i2 < 16) {
            return null;
        }
        this.b = a(bArr, i);
        if (this.b == null) {
            return null;
        }
        this.f = this.b[0] & 7;
        int i3 = (i2 - this.f) - 10;
        if (i3 < 0) {
            return null;
        }
        int i4;
        for (i4 = i; i4 < bArr3.length; i4++) {
            bArr3[i4] = (byte) 0;
        }
        this.c = new byte[i3];
        this.e = 0;
        this.d = 8;
        this.j = 8;
        this.f++;
        this.g = 1;
        byte[] bArr4 = bArr3;
        while (this.g <= 2) {
            if (this.f < 8) {
                this.f++;
                this.g++;
            }
            if (this.f == 8) {
                if (!b(bArr, i, i2)) {
                    return null;
                }
                bArr4 = bArr;
            }
        }
        int i5 = i3;
        byte[] bArr5 = bArr4;
        i4 = 0;
        byte[] bArr6 = bArr5;
        while (i5 != 0) {
            if (this.f < 8) {
                this.c[i4] = (byte) (bArr6[(this.e + i) + this.f] ^ this.b[this.f]);
                i4++;
                i5--;
                this.f++;
            }
            if (this.f == 8) {
                this.e = this.d - 8;
                if (!b(bArr, i, i2)) {
                    return null;
                }
                bArr6 = bArr;
            }
        }
        this.g = 1;
        bArr4 = bArr6;
        while (this.g < 8) {
            if (this.f < 8) {
                if ((bArr4[(this.e + i) + this.f] ^ this.b[this.f]) == 0) {
                    return null;
                }
                this.f++;
            }
            if (this.f == 8) {
                this.e = this.d;
                if (!b(bArr, i, i2)) {
                    return null;
                }
                bArr4 = bArr;
            }
            this.g++;
        }
        return this.c;
    }
//
//    private boolean b(byte[] bArr, int i, int i2) {
//        this.f = 0;
//        while (this.f < 8) {
//            if (this.j + this.f >= i2) {
//                return true;
//            }
//            byte[] bArr2 = this.b;
//            int i3 = this.f;
//            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.d + i) + this.f]);
//            this.f++;
//        }
//        this.b = b(this.b);
//        if (this.b == null) {
//            return false;
//        }
//        this.j += 8;
//        this.d += 8;
//        this.f = 0;
//        return true;
//    }

    private boolean b(byte[] p0, int p1, int p2)    //method@50a0
    {
        byte v1 = 0;
        this.f = v1;
        while ((this.f < 8)) {
            if ((this.j + this.f) >= p2) {
                return true;
            }
            byte[] v2 = this.b;
            int v3 = this.f;
            v2[v3] = (byte) ((v2[v3] ^ p0[((this.d + p1) + this.f)]));
            this.f = (this.f + 1);
        }
        this.b = this.b(this.b);
        if (this.b != null) {
            this.j = (this.j + 8);
            this.d = (this.d + 8);
            this.f = v1;
            return true;
        } else {
            return false;
        }
    }



    private byte[] b(byte[] bArr) {
        return a(bArr, 0);
    }


    public byte[] a(byte[] p0, int p1)    //method@509b
    {
        this.e = 0;
        this.d = 0;

        int v8 = 16;
        long v6 = a(p0, p1, 4);
        long v4 = a(p0, (p1 + 4), 4);
        long v10 = a(this.h, 0, 4);
        long v12 = a(this.h, 4, 4);
        long v14 = a(this.h, 8, 4);
        long v16 = a(this.h, 12, 4);
        long v2 = (-0x1c886470L & 0xffffffffL);
        long v18 = (-0x61c88647L & 0xffffffffL);
        int v9 = (v8 - 1);
        while ((v8 > 0)) {


            v4 = (v4 -  ((((v6 << 4) + v14) ^ (v6 + v2)) ^((v6 >>> 5) + v16))) & 0xffffffffL;
            v6 = (v6 - ((((v4 << 4) + v10) ^(v4 + v2)) ^((v4 >>> 5) + v12))) & 0xffffffffL;
            v2 = ((v2 - v18) & 0xffffffff);
            v8 = v9;
            v9 = (v8 - 1);
        }
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt((int) v6);
            dataOutputStream.writeInt((int) v4);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
