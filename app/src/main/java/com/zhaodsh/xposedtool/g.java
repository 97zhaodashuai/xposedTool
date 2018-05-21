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

    public byte[] encrypt(byte[] param) {
        return b(param, 0, param.length, d());
    }

    private int b() {
        return 5;
    }

    public byte[] encode(byte[] param){
        byte[] key = {0x6a, 0x69, 0x2a, 0x39, 0x5e, 0x26, 0x34,0x33, 0x55, 0x30, 0x58, 0x2d, 0x7e,0x2e,0x2f,0x28};
        return a(param, key);
    }


    public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        return b(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    }


    public byte[] b_jad(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        int i4;
        this.a = new byte[8];
        this.b = new byte[8];
        this.f = 1;
        this.g = 0;
        this.e = 0;
        this.d = 0;
        this.h = bArr2;
        this.i = true;
        this.f = (i2 + 10) % 8;
        if (this.f != 0) {
            this.f = 8 - this.f;
        }
        this.c = new byte[((this.f + i2) + 10)];
        this.a[0] = (byte) ((b() & 248) | this.f);
        for (i3 = 1; i3 <= this.f; i3++) {
            this.a[i3] = (byte) (b() & 255);
        }
        this.f++;
        for (i3 = 0; i3 < 8; i3++) {
            this.b[i3] = (byte) 0;
        }
        this.g = 1;
        while (this.g <= 2) {
            if (this.f < 8) {
                byte[] bArr3 = this.a;
                i4 = this.f;
                this.f = i4 + 1;
                bArr3[i4] = (byte) (b() & 255);
                this.g++;
            }
            if (this.f == 8) {
                a();
            }
        }
        i4 = i;
        int i5 = i2;
        while (i5 > 0) {
            if (this.f < 8) {
                byte[] bArr4 = this.a;
                int i6 = this.f;
                this.f = i6 + 1;
                i3 = i4 + 1;
                bArr4[i6] = bArr[i4];
                i4 = i5 - 1;
            } else {
                i3 = i4;
                i4 = i5;
            }
            if (this.f == 8) {
                a();
                i5 = i4;
                i4 = i3;
            } else {
                i5 = i4;
                i4 = i3;
            }
        }
        this.g = 1;
        while (this.g <= 7) {
            if (this.f < 8) {
                byte[] bArr3 = this.a;
                int i7 = this.f;
                this.f = i7 + 1;
                bArr3[i7] = (byte) 0;
                this.g++;
            }
            if (this.f == 8) {
                a();
            }
        }
        return this.c;
    }
<<<<<<< HEAD



=======
>>>>>>> 251908b036604b089ac66d7542e44ef8a990b986
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


//    private void a() {
//        int v7 = 8;
//        byte v6 = 0;
//        this.f = v6;
//        while ((this.f < v7)) {
//            if (!this.i) {
//                byte[] v0 = this.a;
//                int v1 = this.f;
//                v0[v1] = (byte) ((v0[v1] ^ this.c[(this.e + this.f)]));
//            } else {
//                byte[] v0 = this.a;
//                int v1 = this.f;
//                v0[v1] = (byte) ((v0[v1] ^ this.b[this.f]));
//            }
//            this.f = (this.f + 1);
//        }
//        System.arraycopy(this.a(this.a), v6, this.c, this.d, v7);
//        this.f = v6;
//        while ((this.f < 8)) {
//            byte[] v0 = this.c;
//            int v1 = (this.d + this.f);
//            v0[v1] = (byte) ((v0[v1] ^ this.b[this.f]));
//            this.f = (this.f + 1);
//        }
//        System.arraycopy(this.a, v6, this.b, v6, v7);
//        this.e = this.d;
//        this.d = (this.d + 8);
//        this.f = v6;
//        this.i = false;
//        return;
//    }


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

//
//    private byte[] a(byte[] paramArrayOfByte) {
//        int m = 16;
//        try {
//            long l1 = a(paramArrayOfByte, 0, 4);
//            long l2 = a(paramArrayOfByte, 4, 4);
//            long l3 = a(h, 0, 4);
//            long l4 = a(h, 4, 4);
//            long l5 = a(h, 8, 4);
//            long l6 = a(h, 12, 4);
//            long l7 = 0L;
//            while (m > 0) {
//                l7 = l7 + (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
//                l1 = l1 + ((l2 << 4) + l3 ^ l2 + l7 ^ (l2 >>> 5) + l4) & 0xFFFFFFFF;
//                l2 = l2 + ((l1 << 4) + l5 ^ l1 + l7 ^ (l1 >>> 5) + l6) & 0xFFFFFFFF;
//                m--;
//            }
//            ByteArrayOutputStream v1 = new ByteArrayOutputStream(8);
//            DataOutputStream v2 = new DataOutputStream(v1);
//            v2.writeInt((int) l1);
//            v2.writeInt((int) l2);
//            v2.close();
//            paramArrayOfByte = v1.toByteArray();
//            return paramArrayOfByte;
//        } catch (java.io.IOException e) {
//
//        }
//        return null;
//    }


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
        return a(param, 0, param.length, key);
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
                if ((bArr4[(this.e + i) + this.f] ^ this.b[this.f]) != 0) {
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

    private boolean b(byte[] bArr, int i, int i2) {
        this.f = 0;
        while (this.f < 8) {
            if (this.j + this.f >= i2) {
                return true;
            }
            byte[] bArr2 = this.b;
            int i3 = this.f;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.d + i) + this.f]);
            this.f++;
        }
        this.b = b(this.b);
        if (this.b == null) {
            return false;
        }
        this.j += 8;
        this.d += 8;
        this.f = 0;
        return true;
    }

    private byte[] b(byte[] bArr) {
        return a(bArr, 0);
    }

    private byte[] a(byte[] bArr, int i) {
        int i2 = 16;
        try {
            long a = a(bArr, i, 4);
            long a2 = a(bArr, i + 4, 4);
            long a3 = a(this.h, 0, 4);
            long a4 = a(this.h, 4, 4);
            long a5 = a(this.h, 8, 4);
            long a6 = a(this.h, 12, 4);
            long j = -478700656 & 4294967295L;
            long j2 = -1640531527 & 4294967295L;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    a2 = (a2 - ((((a << 4) + a5) ^ (a + j)) ^ ((a >>> 5) + a6))) & 4294967295L;
                    a = (a - ((((a2 << 4) + a3) ^ (a2 + j)) ^ ((a2 >>> 5) + a4))) & 4294967295L;
                    j = (j - j2) & 4294967295L;
                    i2 = i3;
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



}
