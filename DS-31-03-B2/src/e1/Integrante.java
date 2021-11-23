package e1;

public abstract class Integrante {

    protected String nombre;
    protected String apellido;
    protected int edad;
    protected int horrocruxes;
    protected float recompensa;
    protected String informacion;

    public Integrante(String nombre, String apellido, int edad, int horrocruxes){
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setHorrocruxes(horrocruxes);
    }

    public float getRecompensa() {
        return recompensa;
    }

    public int getEdad() {
        return edad;
    }

    public int getHorrocruxes() {
        return horrocruxes;
    }

    public String getApellido() {
        return apellido;
    }

    public String getInformacion() {
        return informacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        if(edad >= 0) {
            this.edad = edad;
        }else throw new IllegalArgumentException("Edad no válida");
    }

    public void setHorrocruxes(int horrocruxes) {
        if(horrocruxes >= 0){
            this.horrocruxes = horrocruxes;
        }else throw new IllegalArgumentException("Horrocruxes no válidos");
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRecompensa(float recompensa) {
        this.recompensa = recompensa;
    }

    public float calculoRecompensa(Profesion profesion){
        float Galeones_horrocrux;
        if(profesion == Profesion.Docente){
            Galeones_horrocrux = 50.0f;
        }else if(profesion == Profesion.Conserje){
            Galeones_horrocrux = 65.0f;
        }else if(profesion == Profesion.Guardabosques) {
            Galeones_horrocrux = 75.0f;
        }else if(profesion == Profesion.Fantasma) {
            Galeones_horrocrux = 80.0f;
        }else if(profesion == Profesion.Estudiante) {
            Galeones_horrocrux = 90.0f;
        }else throw new IllegalArgumentException();
        return this.recompensa = Galeones_horrocrux * horrocruxes;
    }
}
