package itv.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GestorIO {
	private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

  private void eixir() {
    System.out.println("ERROR d'entrada/eixida");
    System.exit(0);
  }

  public String inString() {
    String entrada = null;

    try {
      entrada = b.readLine();
    } catch (Exception e) {
      this.eixir();
    }

    return entrada;
  }

  public int inInt() {
    int entrada = 0;

    try {
      entrada = Integer.parseInt(this.inString());
    } catch (Exception e) {
      this.eixir();
    }

    return entrada;
  }

  public float inFloat() {
    float entrada = 0;

    try {
      entrada = Float.parseFloat(this.inString());
    } catch (Exception e) {
      this.eixir();
    }

    return entrada;
  }

  public double inDouble() {
    double entrada = 0.0;

    try {
      entrada = Double.parseDouble(this.inString());
    } catch (Exception e) {
      this.eixir();
    }

    return entrada;
  }

  public long inLong() {
    long entrada = 0;

    try {
      entrada = Long.parseLong(this.inString());
    } catch (Exception e) {
      this.eixir();
    }

    return entrada;
  }

  public byte inByte() {
    byte entrada = 0;

    try {
      entrada = Byte.parseByte(this.inString());
    } catch (Exception e) {
      this.eixir();
    }

    return entrada;
  }

  public short inShort() {
    short entrada = 0;

    try {
      entrada = Short.parseShort(this.inString());
    } catch (Exception e) {
      this.eixir();
    }

    return entrada;
  }

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

  public void out(String eixida) {
    System.out.print(eixida);
  }

  public void out(int eixida) {
    System.out.print(eixida);
  }

  public void out(float eixida) {
    System.out.print(eixida);
  }

  public void out(double eixida) {
    System.out.print(eixida);
  }

  public void out(long eixida) {
    System.out.print(eixida);
  }

  public void out(byte eixida) {
    System.out.print(eixida);
  }

  public void out(short eixida) {
    System.out.print(eixida);
  }

  public void out(char eixida) {
    System.out.print(eixida);
  }

  public void out(boolean eixida) {
    System.out.print(eixida);
  }
  
  public void out(Object objecte) {
    System.out.print(objecte);
  }
}