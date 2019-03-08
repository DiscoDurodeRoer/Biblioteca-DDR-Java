package es.discoduroderoer.swing;

import es.discoduroderoer.expresiones_regulares.ExpresionesRegulares;
import javax.swing.JComboBox;

public class ErroresFormulario {

    private StringBuilder errores;

    public ErroresFormulario() {
        this.errores = new StringBuilder();
    }

    public boolean hasError() {
        return !this.errores.toString().isEmpty();
    }

    public String getErrores() {
        return errores.toString();
    }

    public void validarNumeroEntero(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero entero\n");
        }
    }

    public void validarNumeroEntero(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNumeroReal(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    public void validarNumeroReal(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNumeroReal(String textoValidar, int decimales) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar, decimales)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    public void validarNumeroReal(String textoValidar, int decimales, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar, decimales)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNumeroRealPositivo(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    public void validarNumeroRealPositivo(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNumeroRealPositivo(String textoValidar, int decimales) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar, decimales)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    public void validarNumeroRealPositivo(String textoValidar, int decimales, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroRealPositivo_Exp(textoValidar, decimales)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarVacio(String textoValidar) {
        if (textoValidar.isEmpty()) {
            this.errores.append("- El texto no puede estar vacio\n");
        }
    }

    public void validarVacio(String textoValidar, String mensajeError) {
        if (textoValidar.isEmpty()) {
            this.errores.append(mensajeError);
        }
    }

    public void validarOpcionSeleccionadaCMB(JComboBox cmb) {
        if (cmb.getSelectedIndex() == 0) {
            this.errores.append("- Debes una opcion del combo\n");
        }
    }

    public void validarOpcionSeleccionadaCMB(JComboBox cmb, String mensajeError) {
        if (cmb.getSelectedIndex() == 0) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNulo(Object o) {
        if (o == null) {
            this.errores.append("- El objecto es nulo\n");
        }
    }

    public void validarNulo(Object o, String mensajeError) {
        if (o == null) {
            this.errores.append(mensajeError);
        }
    }

    public void validarDistintoCero(int valor) {
        if (valor == 0) {
            this.errores.append("- El valor no puede ser cero");
        }
    }

    public void validarDistintoCero(int valor, String mensajeError) {
        if (valor == 0) {
            this.errores.append(mensajeError);
        }
    }

    public void validarDistintoCero(double valor) {
        if (valor == 0) {
            this.errores.append("- El valor no puede ser cero");
        }
    }

    public void validarDistintoCero(double valor, String mensajeError) {
        if (valor == 0) {
            this.errores.append(mensajeError);
        }
    }

    public void validarMayorQue(int valor1, int valor2) {
        if (valor1 > valor2) {
            this.errores.append("- El valor1 no puede ser mayor que el valor 2");
        }
    }

    public void validarMayorQue(int valor1, int valor2, String mensajeError) {
        if (valor1 > valor2) {
            this.errores.append(mensajeError);
        }
    }

    public void validarEmail(String email) {
        if (!email.isEmpty() && !ExpresionesRegulares.validar_Mail_Exp(email)) {
            this.errores.append("- El email no tiene el formato correcto \n");
        }
    }

    public void validarEmail(String email, String mensajeError) {
        if (!email.isEmpty() && !ExpresionesRegulares.validar_Mail_Exp(email)) {
            this.errores.append("- El email no tiene el formato correcto \n");
        }
    }

    public void validarPatron(String textoValidar, String patron) {
        if (!textoValidar.isEmpty() && !patron.matches(patron)) {
            this.errores.append("- El texto no cumple patron indicado \n");
        }
    }

    public void validarPatron(String textoValidar, String patron, String errores) {
        if (!textoValidar.isEmpty() && !patron.matches(patron)) {
            this.errores.append(errores);
        }
    }

}
