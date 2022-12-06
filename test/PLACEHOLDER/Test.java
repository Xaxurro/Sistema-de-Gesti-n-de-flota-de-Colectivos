package PLACEHOLDER;

import java.util.Arrays;

public class Test {
    public static String[] campos = new String[] {"RutConductor", "Compra", "Seguro", "RevisionTecnica", "KilometrajeActual", "Marca", "Vin", "Motor"};
    public static Object[] datos = new Object[] {1,2,3,4,5,6,7,8,9};
    
    public static String asignarUpdate(int length){
        String sql = "";
        for (int i = 0; i < length; i++) {
            sql += campos[i] + " = ?";
            if (i != length-1) {
                sql += ", ";
            }
        }
        return sql;
    }
    
    public static void main(String[] args) {
        String sql = "UPDATE Colectivo SET " + asignarUpdate(datos.length-1) + " WHERE Matricula = ?";
        System.out.println(sql);
    }
    
}
