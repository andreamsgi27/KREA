package com.krea;

public class Login {
    private String contraseña;
    private boolean autenticacion;
    private String usuario;
    

        // Constructor with parameters
        public Login(String contraseña, boolean autenticacion, String usuario) {
            this.contraseña = contraseña;
            this.autenticacion = autenticacion;
            this.usuario = usuario;
        }
    

        // Getters and Setters
        public String getcontraseña() {
            return contraseña;
        }
    
        public void setcontraseña(String contraseña) {
            this.contraseña = contraseña;
        }
    
        public boolean getautenticacion() {
            return autenticacion;
        }
    
        public void setautenticacion(boolean autenticacion) {
            this.autenticacion = autenticacion;
        }
    
        public String getusuario() {
            return usuario;
        }
    
        public void setusuario(String usuario) {
            this.usuario = usuario;
        }
    

        // Para que el HTTP API pueda mostrar en un GET una lista de los logins, en este formato
        @Override
        public String toString() {
            return "Login{" +
                    "contraseña=" + contraseña +
                    ", autenticacion='" + autenticacion + '\'' +
                    ", usuario=" + usuario +
                    '}';
        }
}

