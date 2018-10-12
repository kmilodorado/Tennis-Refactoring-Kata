
public class TennisGame1 implements TennisGame {
    
    private int mejor_puntaje1 = 0;
    private int mejor_puntaje2 = 0;
    private String nombre_Jugador1;
    private String nombre_Jugador2;

    public TennisGame1(String nombreJugador1, String nombreJugador2) {
        this.nombre_Jugador1 = nombreJugador1;
        this.nombre_Jugador2 = nombreJugador2;
    }

    public void ganoPunto(String nombreJugador) {
        if (nombreJugador.equals("jugador1"))
            mejor_puntaje1 += 1;
        else
            mejor_puntaje2 += 1;
    }

    public String PuntoResultado(int punto, String jugadorGanador) {
    	 switch (punto)
         {
             case 0:
                 return "Amor"+jugadorGanador;
             case 1:
            	 return "Quince"+jugadorGanador;
             case 2:
            	 return "Treinta"+jugadorGanador;
             default:
            	 if(punto==3&&jugadorGanador!="-Todos") {
            		 return "Cuarenta"; 
            	 }
            	 return "Deuce";
         }
    }
    
    public String mejorJugador(int minusResult) {
    	switch(minusResult) {
    	case 1:
    		return "Ventaja jugador1";
    	case -1:
    		return "Ventaja jugador2";
    	 default:
    		 if (minusResult>=2)
    			 return "Gana jugador1";
             else  
            	 return "Gana jugador2";
    	}
    }
    
    public String getPuntaje() {
        String puntaje = "";
        int tempPuntaje=0;
        if (mejor_puntaje1 == mejor_puntaje2)
        {
        	puntaje=PuntoResultado(mejor_puntaje1,"-Todos");
        }
        else if (mejor_puntaje1 >=4 || mejor_puntaje2 >=4)
        {
        	puntaje=mejorJugador(mejor_puntaje1 - mejor_puntaje2);
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempPuntaje = mejor_puntaje1;
                else { puntaje+="-"; tempPuntaje = mejor_puntaje2;}
                puntaje+=PuntoResultado(tempPuntaje,"");
            }
        }
        return puntaje;
    }
}
