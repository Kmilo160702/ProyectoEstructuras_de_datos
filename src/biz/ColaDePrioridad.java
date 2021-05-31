package biz;

import java.util.ArrayList;

public class ColaDePrioridad {

    ArrayList<Tarea> tareas = new ArrayList<>();
    private Tarea[] monton;
    private int tamaño;
    private final int capacidad;

    public ColaDePrioridad(int capacidad) {
        this.capacidad = capacidad + 1;
        monton = new Tarea[this.capacidad];
        tamaño = 0;
    }

    public void limpiar() {
        monton = new Tarea[capacidad];
        tamaño = 0;
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public boolean isFull() {
        return tamaño == capacidad - 1;
    }

    public int size() {
        return tamaño;
    }

    public void insertar(String nombre, int prioridad) {

        Tarea oTarea = new Tarea(nombre, prioridad);

        monton[++tamaño] = oTarea;
        int pos = tamaño;
        while (pos != 1 && oTarea.getPrioridad() > monton[pos / 2].getPrioridad()) {
            monton[pos] = monton[pos / 2];
            pos /= 2;
        }
        monton[pos] = oTarea;
        tareas.add(oTarea);
    }

    public void mostar() {
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println("\tPersona:\t" + (i + 1));
            Tarea pTarea = tareas.get(i);
            System.out.println("Nombre: " + pTarea.getNombre());
            System.out.println("Prioridad: " + pTarea.getPrioridad());
        }

    }

    public Tarea borrar() {
        int padre;
        int hijo;
        Tarea item;
        Tarea temp;
        if (isEmpty()) {
            System.out.println("Vacio");
            return null;
        }
        item = monton[1];
        temp = monton[tamaño--];
        padre = 1;
        hijo = 2;
        while (hijo <= tamaño) {
            if (hijo < tamaño && monton[hijo].getPrioridad() < monton[hijo + 1].getPrioridad()) {
                hijo++;
            }
            if (temp.getPrioridad() >= monton[hijo].getPrioridad()) {
                break;
            }

            monton[padre] = monton[hijo];
            padre = hijo;
            hijo *= 2;
        }
        monton[padre] = temp;
        return item;
    }
}