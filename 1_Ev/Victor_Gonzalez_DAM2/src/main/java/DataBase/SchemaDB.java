package DataBase;

public interface SchemaDB {
    //nombre base de datos
    String DB_NAME = "proyectos_dam";

    //Nombre tabla alumnos
    String TABLE_NAME_AL = "alumnos";

    //Columnas tabla alumnos
    String COL_NOMBRE = "nombre";
    String COL_APE = "apellido";
    String COL_DNI = "dni";

    //Nombre tabla profesores
    String TABLE_NAME_P = "profesores";

    //Columnas tabla profesores
    String COL_DNIP = "dni_p";
    String COL_NOMBREP = "nombre_p";
    String COL_APEP = "apellido_p";
    String COL_ASIG = "asignatura";

    //Nombre tabla proyecto
    String TABLE_NAMEPRO = "proyectos";

    //Columnas tabla proyecto

    String COL_TITULO = "titulo";
    String COL_DESC = "descripcion";
    String COL_CONTENIDO = "contenido";

}
