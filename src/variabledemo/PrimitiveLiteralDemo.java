package variabledemo;

public class PrimitiveLiteralDemo {
    // The number 26, in decimal
    int decVal = 26;
    //  The number 26, in hexadecimal
    int hexVal = 0x1a;
    // The number 26, in binary
    int binVal = 0b11010;

    double d1 = 123.4;
    // same value as d1, but in scientific notation
    double d2 = 1.234e3;
    float f1  = 123.4f;

    long creditCardNumber = 1234_5678_9012_3456L;
    long socialSecurityNumber = 999_99_9999L;
    float pi =  3.14_15F;
    long hexBytes = 0xFF_EC_DE_5E;
    long hexWords = 0xCAFE_BABE;
    long maxLong = 0x7fff_ffff_ffff_ffffL;
    byte nybbles = 0b0010_0101;
    long bytes = 0b11010010_01101001_10010100_10010010;

    int phone = 974_366_781;

    // OK (decimal literal)
    int x1 = 5_2;
    int x3 = 5_______2;

    // OK (hexadecimal literal)
    int x6 = 0x5_2;


    @Override
    public String toString() {
        return "PrimitiveLiteralDemo{" +
                "decVal=" + decVal +
                ", hexVal=" + hexVal +
                ", binVal=" + binVal +
                ", d1=" + d1 +
                ", d2=" + d2 +
                ", f1=" + f1 +
                ", creditCardNumber=" + creditCardNumber +
                ", socialSecurityNumber=" + socialSecurityNumber +
                ", pi=" + pi +
                ", hexBytes=" + hexBytes +
                ", hexWords=" + hexWords +
                ", maxLong=" + maxLong +
                ", nybbles=" + nybbles +
                ", bytes=" + bytes +
                ", x1=" + x1 +
                ", x3=" + x3 +
                ", x6=" + x6 +
                '}';
    }
}
