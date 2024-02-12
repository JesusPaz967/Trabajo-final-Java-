
package TRfinal;

public class Clientes {

    private String Nombre = new String();
    private String DNI = new String();
    private String contraseña = new String();
    private double mon;

    //-------------------------------------------------------
    public double getMon() {
        return mon;
    }

    public void setMon(double mon) {
        this.mon = mon;
    }

    //-------------------------------------------------------
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) throws Exception {
        this.Nombre = Nombre;
        if (!this.verificarNombre()) {
            throw new Exception();
        }
    }

    //-------------------------------------------------------
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dni1) throws Exception {
        this.DNI = dni1;
        if (!this.verificarDNI()) {
            throw new Exception();
        }
    }

    //-------------------------------------------------------
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) throws Exception {
        this.contraseña = contraseña;
        if (!this.verificarNombre()) {
            throw new Exception();
        }
    }

    //-------------------------------------------------------
    public Clientes() {
        this("");
    }

    public Clientes(String pnombre) {
        this.Nombre = pnombre;
    }

    //-------------------------------------------------------
    public boolean verificarNombre() {
        boolean x;
        if (Nombre.matches("[A-Za-z]+")) {

            x = true;
        } else {
            x = false;
        }
        return x;
    }

    public boolean verificarDNI() {
        boolean x;
        if (DNI.matches("[0-9]+")) {

            x = true;
        } else {
            x = false;
        }
        return x;
    }
    //-------------------------------------------------------

    public void Deposit(double din) {
        {
            mon += din;
            System.out.println("Muchas gracias por su deposito");
        }
    }

    public void Ret(double din) {
        mon -= din;
        System.out.println("Muchas gracias por su retiro");

    }

}
