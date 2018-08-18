/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.clases.documentos;

/**
 *
 * @author DiscoDurodeRoer
 */
public final class CIF extends Documento{
    
    //Atributos
    private char letraInicial;
    
    //Constantes
    private static char letrasCIF[]={'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','U','V','W'};
    private static boolean NUMERO_O_LETRAS[]={true,true,false,true,true,true,true,true,true,false,false,false,false,false,false,false,false,true,true,false}; //True = numero, false = letra
    private static char letrasCIFFINAL[]={'A','B','C','D','E','F','G','H','I','J'};

    /**
     * Constructor por defecto
     */
    public CIF(){
        this.generarCIF();
    }
    
    /**
     * Le pasamos el valordel CIF
     * @param CIF CIF
     */
    public CIF(String CIF){
        
        letraInicial=CIF.charAt(0);
        
        if(validarCIF(CIF)){
            
            int indice=0;
            boolean encontrado=false;
            for(int i=0;i<letrasCIF.length && !encontrado;i++){
                if(letrasCIF[i]==letraInicial){
                    indice=i;
                    encontrado=true;
                }
            }
            
            if(NUMERO_O_LETRAS[indice]){
                
                numero=Integer.parseInt(CIF.substring(1, CIF.length()-1));
                letra=' ';
            }else{
                numero=Integer.parseInt(CIF.substring(1, CIF.length()-2));
                letra=CIF.charAt(CIF.length()-1);
            }
            
            completarDocumento();
        }else{
            letraInicial=' ';
            numero=0;
            letra=' ';
            completarDocumento();
        }
        
    }
    
    /**
     * Completa el documento CIF
     */
    public void completarDocumento(){
        documentoCompleto=letraInicial + String.valueOf(numero) + letra;
    }
    
    /**
     * Genera un CIF aleatorio
     */
    private void generarCIF(){
        
        int indiceLetraInicial=generaNumeroAleatorio(0, letrasCIF.length-1);
        
        letraInicial=letrasCIF[indiceLetraInicial];
        
        String numerosProvincias[]=numerosProvincias();
        
        String digitoProvincia=numerosProvincias[generaNumeroAleatorio(0, numerosProvincias.length-1)];
        
        String restoNumeros=String.valueOf(generaNumeroAleatorio(10000,99999));
        
        String numeroCompleto=digitoProvincia+restoNumeros;
        
        int resultado=10-generarD(numeroCompleto);
        
        String digitoControl;
        
        if(NUMERO_O_LETRAS[indiceLetraInicial]){
            if(resultado==10){
                digitoControl="0";
            }else{
                digitoControl=String.valueOf(resultado);
            }
        }else{
            digitoControl=String.valueOf(letrasCIFFINAL[resultado-1]);
        }
        
        documentoCompleto =  letraInicial + numeroCompleto + digitoControl ;
        
    }
    
    /**
     * Genera un array con los codigos de provincias
     * @return Array con codigos de provincias
     */
    private String[] numerosProvincias(){
        
        String[] numerosProvincias=new String[89];
        
        for(int i=0,valorActual=1;i<numerosProvincias.length;i++, valorActual++){
            
            if((i+1)<10){
                numerosProvincias[i]="0"+valorActual;
            }else{
                
                if ( (valorActual==65) ){
                    
                    valorActual=70;
                    
                }
                
                if(valorActual==86){
                    valorActual=91;
                }
                
                numerosProvincias[i]=String.valueOf(valorActual);
                
            }
        }
        
        return numerosProvincias;
    }
    
    /**
     * Genera el valor D necesario para calcular el digito de control
     * @param numeroCompleto Número CIF
     * @return Valor de D
     */
    private int generarD(String numeroCompleto){
        
        int A=0;
        int B=0;
        int digitoActual;
        for(int i=0;i<numeroCompleto.length();i++){
            
            digitoActual=Integer.parseInt(String.valueOf(numeroCompleto.charAt(i)));
            
            if( (i+1)%2==0){
                A+=digitoActual;
            }else{
                B+=sumaArray(devuelveDigitos(digitoActual*2));
            }
            
        }
     
        int C=A+B;
        
        int D=Integer.parseInt(String.valueOf(String.valueOf(C).charAt(String.valueOf(C).length()-1)));
        
        return D;
        
    }
    
    /**
     * Valida si el CIF es correcto
     * @param CIF CIF
     * @return True = es valido
     */
    private boolean validarCIF(String CIF){
    
        if(CIF.length()<=9){
           try{
                int resultado;
                int indice=0;
                String digitoControl;
                String cif;
                
                boolean encontrado=false;
                
                
                for(int i=0;i<letrasCIF.length && !encontrado;i++){
                    if(letrasCIF[i]==letraInicial){
                        indice=i;
                        encontrado=true;
                    }
                }
                
                if(encontrado){
                    
                    cif=CIF.substring(1, CIF.length()-1);
                    
                    resultado=10-generarD(cif);
    
                    if(NUMERO_O_LETRAS[indice]){

                        if(resultado==10){
                            digitoControl="0";
                        }else{
                            digitoControl=String.valueOf(resultado);
                        }

                    }else{
                        digitoControl=String.valueOf(letrasCIFFINAL[resultado-1]);
                    }
               
                }else{
                    return false;
                }
                
                return CIF.trim().equals((letrasCIF[indice] + String.valueOf(cif) + digitoControl).trim());
                
        }catch(NumberFormatException e){
            return false;
        }
       }else{
           return false;
       }
        
    }
    
    /**
     * Genera un CIF aleatorio
     * @return Documento CIF válido
     */
    public static String generarCIFAleatorio(){
        
        int indiceLetraInicial=generaNumeroAleatorio(0, letrasCIF.length-1);
        
        char letraInicial=letrasCIF[indiceLetraInicial];
        
        String numerosProvincias[]=new String[89];
        
        for(int i=0,valorActual=1;i<numerosProvincias.length;i++, valorActual++){
            
            if((i+1)<10){
                numerosProvincias[i]="0"+valorActual;
            }else{
                
                if ( (valorActual==65) ){
                    
                    valorActual=70;
                    
                }
                
                if(valorActual==86){
                    valorActual=91;
                }
                
                numerosProvincias[i]=String.valueOf(valorActual);
                
            }
            
        }
        
        String digitoProvincia=numerosProvincias[generaNumeroAleatorio(0, numerosProvincias.length-1)];
        
        String restoNumeros=String.valueOf(generaNumeroAleatorio(10000,99999));
        
        String numeroCompleto=digitoProvincia+restoNumeros;
        
        int A=0;
        int B=0;
        int digitoActual;
        for(int i=0;i<numeroCompleto.length();i++){
            
            digitoActual=Integer.parseInt(String.valueOf(numeroCompleto.charAt(i)));
            
            if( (i+1)%2==0){
                A+=digitoActual;
            }else{
                B+=sumaArray(devuelveDigitos(digitoActual*2));
            }
            
        }
     
        int C=A+B;
        
        int D=Integer.parseInt(String.valueOf(String.valueOf(C).charAt(String.valueOf(C).length()-1)));
        
        int resultado=10-D;
        
        String digitoControl;
        
        if(NUMERO_O_LETRAS[indiceLetraInicial]){
            if(resultado==10){
                digitoControl=String.valueOf(0);
            }else{
                digitoControl=String.valueOf(resultado);
            }
        }else{
            digitoControl=String.valueOf(letrasCIFFINAL[resultado-1]);
        }
        
        return letraInicial + numeroCompleto + digitoControl ;
        
    }
    
    /**
     * Genera una serie de CIFs aleatorios
     * @param numeroCIFs Número de CIFs generados
     * @return Array de documentos CIFs
     */
    public static String[] generaCIFsAletorios(int numeroCIFs){
        
        String CIFs[]=new String[numeroCIFs];
        
        String cif;
        
        for(int i=0;i<CIFs.length;i++){
        
            do{
                
                cif=generarCIFAleatorio();
                
            }while(existeDocumento(CIFs,cif));
            
            CIFs[i]=cif;
            
        }
        
        return CIFs;
        
    }
    
    /**
     * Devuelve los digitos de un números
     * @param numeroInicial Número 
     * @return Array con los digitos
     */
    private static int[] devuelveDigitos (int numeroInicial){
        
        int numero=numeroInicial;
        
        int digitos[]=new int[cuentaCifras(numeroInicial)];
        int numero_solo;
        
        for(int i=0;numeroInicial>0;i++){
            numero/=10;
            numero_solo=numeroInicial-(numero*10);
            digitos[i]=numero_solo;
            numeroInicial=numero;
        }
        return invertirArray(digitos);
        
    }
    
    /**
     * Suma un array de int
     * @param array Array con los valores a sumar
     * @return Suma del array de int
     */
    private static int sumaArray(int array[]){
        
        int suma=0;
        for(int i=0;i<array.length;i++){
           suma+=array[i];
        }
        
        return suma;
    }
    
    /**
     * Invierte un array
     * @param array Array de int
     * @return Array ya invertido
     */
    private static int[] invertirArray(int array[]){
        
        int temp[]=new int[array.length];
        
        for(int i=temp.length-1, j=0;i>=0;i--, j++){
            temp[i]=array[j];
        }
        
        return temp;
    }
    
}
