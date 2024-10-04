package com.krea;

public class Login {
    private String password;
    private boolean autenticacion;
    private String usuario;
    

        // Constructor with parameters
        public Login(String password, boolean autenticacion, String usuario) {
            this.password = password;
            this.autenticacion = autenticacion;
            this.usuario = usuario;
        }
    

        // Getters and Setters
        public String getpassword() {
            return password;
        }
    
        public void setpassword(String password) {
            this.password = password;
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
                    "password=" + password +
                    ", autenticacion='" + autenticacion + '\'' +
                    ", usuario=" + usuario +
                    '}';
        }
}

