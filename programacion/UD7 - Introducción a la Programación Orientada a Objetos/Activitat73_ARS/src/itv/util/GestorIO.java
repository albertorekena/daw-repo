package itv.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GestorIO {

    /**
     * Llig un string introduït per teclat
     *
     * @return
     */
    public String inString() {
        String entrada = null;
        try {
            entrada = b.readLine();
        } catch (Exception e) {
            this.eixir();
        }
        return entrada;
    }

    /**
     * Llig un enter introduït per teclat
     *
     * @return
     */
    public int inInt() {
        int entrada = 0;
        try {
            entrada = Integer.parseInt(this.inString());
        } catch (Exception e) {
            this.eixir();
        }
        return entrada;
    }

    /**
     * Llig un real de baixa precisió introduït per teclat
     *
     * @return
     */
    public float inFloat() {
        float entrada = 0;
        try {
            entrada = Float.parseFloat(this.inString());
        } catch (Exception e) {
            this.eixir();
        }
        return entrada;
    }

    /**
     * Llig un real d'alta precisió introduït per teclat
     *
     * @return
     */
    public double inDouble() {
        double entrada = 0.0;
        try {
            entrada = Double.parseDouble(this.inString());
        } catch (Exception e) {
            this.eixir();
        }
        return entrada;
    }

    /**
     * Llig un enter llarg introduït per teclat
     *
     * @return
     */
    public long inLong() {
        long entrada = 0;
        try {
            entrada = Long.parseLong(this.inString());
        } catch (Exception e) {
            this.eixir();
        }
        return entrada;
    }

    /**
     * Llig un enter byte introduït per teclat
     *
     * @return
     */
    public byte inByte() {
        byte entrada = 0;
        try {
            entrada = Byte.parseByte(this.inString());
        } catch (Exception e) {
            this.eixir();
        }
        return entrada;
    }

    /**
     * Llig un enter curt introduït per teclat
     *
     * @return
     */
    public short inShort() {
        short entrada = 0;
        try {
            entrada = Short.parseShort(this.inString());
        } catch (Exception e) {
            this.eixir();
        }
        return entrada;
    }

    /**
     * Llig un caràcter introduït per teclat
     *
     * @return
     */
    public char inChar() {
        char caracter = ' ';
        String entrada = this.inString();
        if (entrada.length() > 1) {
            this.eixir();
        } else {
            caracter = entrada.charAt(0);
        }
        return caracter;
    }

    /**
     * Llig un booleà introduït per teclat
     *
     * @return
     */
    public boolean inBoolean() {
        boolean entradaLogica = true;
        String entrada = this.inString();
        if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false")) {
            entradaLogica = Boolean.valueOf(entrada).booleanValue();
        } else {
            this.eixir();
        }
        return entradaLogica;
    }

    /**
     * Imprimix un string
     *
     * @param eixida
     */
    public void out(String eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un enter
     *
     * @param eixida
     */
    public void out(int eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un real de baixa precisió
     *
     * @param eixida
     */
    public void out(float eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un real d'alta precisió
     *
     * @param eixida
     */
    public void out(double eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un enter llarg
     *
     * @param eixida
     */
    public void out(long eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un enter byte
     *
     * @param eixida
     */
    public void out(byte eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un enter curt
     *
     * @param eixida
     */
    public void out(short eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un caràcter
     *
     * @param eixida
     */
    public void out(char eixida) {
        System.out.print(eixida);
    }

    /**
     * Imprimix un booleà
     *
     * @param eixida
     */
    public void out(boolean eixida) {
        System.out.print(eixida);
    }
    
    public void out(Object objecte) {
        System.out.print(objecte);
    }

    private void eixir() {
        System.out.println("ERROR d'entrada/eixida");
        System.exit(0);
    }

    private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

 
}
