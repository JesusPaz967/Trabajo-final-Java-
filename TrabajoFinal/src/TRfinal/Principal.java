package TRfinal;

import java.util.ArrayList;

import java.util.Scanner;

public class Principal {

    public static Clientes cli1 = new Clientes();

    public static ArrayList<Clientes> client = new ArrayList();

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        int cl = -99;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(" ");
            System.out.println("==========MENÚ=========");
            System.out.println("--------CLIENTE--------");
            System.out.println(" (1) Nuevo cliente");
            System.out.println(" (2) Modificar cliente");
            System.out.println(" (3) Gestionar clientes");
            System.out.println(" (4) #Salir#");
            System.out.println("=======================");
            System.out.print("Ingresar una opcion -> ");
            try {
                cl = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Opcion invalida");
                sc.nextLine();
            }
            switch (cl) {
                case 1:
                    opcion1();
                    break;
                case 2:
                    opcion2();
                    break;
                case 3:
                    opcion3();
                    break;

                default:

                
            }
        } while (cl != 4);

    }

    public static void opcion1() {
        Scanner sc = new Scanner(System.in);
        Clientes cli1 = new Clientes("");
        int con=1;

        //--------------------------------------------------------------  
        do {
            System.out.println("");
            System.out.print("Ingresar nombre del cliente: ");
            try {
                cli1.setNombre(sc.nextLine());

            } catch (Exception ex) {
                System.out.println("Nombre incorrecto");
            }
        } while (!cli1.verificarNombre());
        //--------------------------------------------------------------  
        do {
            System.out.print("Ingresar DNI: ");
            try {
                cli1.setDNI(sc.nextLine());

            } catch (Exception ex) {
                System.out.println("DNI invalido");
            }
        } while (!cli1.verificarDNI());
        //--------------------------------------------------------------  
        do {
            System.out.print("Ingresar contrasenia: ");
           
            try {
                cli1.setContraseña((sc.nextLine()));
               

            } catch (Exception ex) {
                System.out.println("Contraseña invalida");
            }
            } while (!cli1.verificarDNI());
        client.add(cli1);
      
    }

    public static void opcion2() {
        Scanner sc = new Scanner(System.in);
        String val;
        int i = -99;
        System.out.println("");
        System.out.print("Ingresar nombre a modificar: ");
        val = sc.nextLine();
        for (Clientes cli1 : client) {
            if (cli1.getNombre().equals(val)) {
                i = client.indexOf(cli1);
                break;
            }
        }
        if (i == 99) {
            System.out.println("Nombre no encontrado");
        } else {
            while (true) {
                System.out.print("Ingresar nuevo nombre(" + client.get(i).getNombre() + "): ");
                try {
                    val = sc.nextLine();
                    client.get(i).setNombre(val);
                    System.out.println("========Modificado========");
                } catch (Exception e) {
                    System.out.println("Nombre incorrecto");
                }
                break;

            }
        }
        if (i == 99) {
            System.out.println("Contrasenia no encontrada");
        } else {
            while (true) {
                System.out.print("Ingresar nueva contrasenia(" + client.get(i).getContraseña() + "): ");
                try {
                    val = sc.nextLine();
                    client.get(i).setContraseña(val);
                    System.out.println("========Modificado========");
                } catch (Exception e) {
                    System.out.println("Nombre incorrecto");
                }
                break;

            }
        }
    }

    public static void opcion3() {

        Scanner sc = new Scanner(System.in);
        Clientes c = null;
        int i = -99;
        String li1 = "";
        String li2 = "";
        int oportuni = 0;
        System.out.println("");
        System.out.print("Ingresar nomnbre: ");
        li1 = sc.nextLine();
        for (Clientes cli1 : client) {
            if (cli1.getNombre().equals(li1)) {
                i = client.indexOf(cli1);
                c = cli1;
                break;
            }
        }
        if (i == 99) {
            System.out.println("Nombre no encontrado");
        } else {
            while (oportuni != 3) {

                System.out.print("Ingresar contrasenia: ");
                li2 = sc.nextLine();

                if (!c.getContraseña().equals(li2)) {
                    System.out.println("===Contrasenia invalida===");
                    oportuni = oportuni + 1;
                } else {
                    MenuDepo();
                }
            }

        }
    }

    public static void MenuDepo() {
        Scanner sc = new Scanner(System.in);
        int c2 = 0;
        do {
            System.out.println(" ");
            System.out.println("==============MENÚ=============");
            System.out.println("Elejir la operacion a realizar:");
            System.out.println(" (1) Deposito");
            System.out.println(" (2) Retiro");
            System.out.println(" (3) Consulta de saldo");
            System.out.println(" (4) <-Volver ");
            System.out.println("================================");
            System.out.print("Ingresar una opcion -> ");
            try {
                c2 = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Opcion invalida");
                sc.nextLine();
            }
            switch (c2) {
                case 1:
                    depo();
                    break;
                case 2:
                    reti();
                    break;
                case 3:
                    ConsulM();
                    break;
                case 4:
                    Volvermenu();
                    break;
            }
        } while (c2 != 5);

    }

    public static void depo() {
        Scanner sc = new Scanner(System.in);
        for (Clientes cli1 : client) {
            System.out.print("Ingresar dinero a depositar: ");
            cli1.Deposit(sc.nextDouble());
        }
    }

    public static void reti() {
        Scanner sc = new Scanner(System.in);
        for (Clientes cli1 : client) {
            System.out.print("Ingresar dinero a retirar: ");
            cli1.Ret(sc.nextDouble());
        }
    }

    public static void ConsulM() {
        for (Clientes cli1 : client) {
            System.out.print("Monto disponible " + cli1.getMon() + " S/.");
        }
    }

    public static void Volvermenu() {
        menu();
    }
}
