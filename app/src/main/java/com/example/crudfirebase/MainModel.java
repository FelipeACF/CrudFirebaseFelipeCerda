package com.example.crudfirebase;
    public class MainModel {
        String Nombre, Marca, Precio;
        public MainModel (){

        }


        public MainModel(String nombre, String marca, String precio) {
            Nombre = nombre;
            Marca = marca;
            Precio = precio;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

        public String getMarca() {
            return Marca;
        }

        public void setMarca(String marca) {
            Marca = marca;
        }

        public String getPrecio() {
            return Precio;
        }

        public void setPrecio(String precio) {
            Precio = precio;
        }
    }
