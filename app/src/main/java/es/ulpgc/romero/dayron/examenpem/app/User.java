package es.ulpgc.romero.dayron.examenpem.app;

public class User {
  private String nombre, apellidos, dni, profesion, cv;
  private int edad, valoracion;

  public User(String nombre, String apellido, String dni, String profesion, String cv, int edad, int valoracion) {
    this.nombre = nombre;
    this.apellidos = apellido;
    this.dni = dni;
    this.profesion = profesion;
    this.cv = cv;
    this.edad = edad;
    this.valoracion = valoracion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getProfesion() {
    return profesion;
  }

  public void setProfesion(String profesion) {
    this.profesion = profesion;
  }

  public String getCv() {
    return cv;
  }

  public void setCv(String cv) {
    this.cv = cv;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public int getValoracion() {
    return valoracion;
  }

  public void setValoracion(int valoracion) {
    this.valoracion = valoracion;
  }
}
