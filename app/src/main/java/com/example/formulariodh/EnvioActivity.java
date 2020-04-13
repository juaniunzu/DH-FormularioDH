package com.example.formulariodh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EnvioActivity extends AppCompatActivity {

    private TextView envioActivityTextViewNombreRecibido;
    private TextView envioActivityTextViewApellidoRecibido;
    private TextView envioActivityTextViewEdadRecibida;
    private TextView envioActivityTextViewCarreraRecibida;
    private TextView envioActivityTextViewOpcionesRecibidas;

    private String opcionesSeleccionadas(Boolean torneos, Boolean meetups, Boolean asados){
        String opcionesSeleccionadas = "";
        if(torneos && meetups && asados){
            opcionesSeleccionadas = "Torneos, meetups, asados";
        } else if(torneos && !meetups && !asados){
            opcionesSeleccionadas = "Torneos";
        } else if(torneos && meetups && !asados){
            opcionesSeleccionadas = "Torneos, meetups";
        } else if(torneos && !meetups && asados){
            opcionesSeleccionadas = "Torneos, asados";
        } else if(!torneos && meetups && asados){
            opcionesSeleccionadas = "Meetups, asados";
        } else if(!torneos && !meetups && !asados){
            opcionesSeleccionadas = "No deseo recibir informacion adicional";
        } else if(!torneos && !meetups && asados){
            opcionesSeleccionadas = "Asados";
        } else if(!torneos && meetups && !asados){
            opcionesSeleccionadas = "Meetups";
        }
        return opcionesSeleccionadas;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);

        this.envioActivityTextViewNombreRecibido = findViewById(R.id.EnvioActivityTextViewNombreRecibido);
        this.envioActivityTextViewApellidoRecibido = findViewById(R.id.EnvioActivityTextViewApellidoRecibido);
        this.envioActivityTextViewEdadRecibida = findViewById(R.id.EnvioActivityTextViewEdadRecibida);
        this.envioActivityTextViewCarreraRecibida = findViewById(R.id.EnvioActivityTextViewCarreraRecibida);
        this.envioActivityTextViewOpcionesRecibidas = findViewById(R.id.EnvioActivityTextViewOpcionesRecibidas);

        Intent desdeFormulario = getIntent();
        Bundle bundleDesdeFormulario = desdeFormulario.getExtras();

        String nombreRecibido = bundleDesdeFormulario.getString("nombre");
        String apellidoRecibido = bundleDesdeFormulario.getString("apellido");
        String edadRecibida = bundleDesdeFormulario.getString("edad");
        String carreraRecibida = bundleDesdeFormulario.getString("carrera");
        Boolean opcionTorneos = bundleDesdeFormulario.getBoolean("torneos");
        Boolean opcionMeetups = bundleDesdeFormulario.getBoolean("meetups");
        Boolean opcionAsados = bundleDesdeFormulario.getBoolean("asados");


        this.envioActivityTextViewNombreRecibido.setText(nombreRecibido + " ");
        this.envioActivityTextViewApellidoRecibido.setText(apellidoRecibido);
        this.envioActivityTextViewEdadRecibida.setText(edadRecibida);
        this.envioActivityTextViewCarreraRecibida.setText(carreraRecibida);

        String opcionesSeleccionadas = opcionesSeleccionadas(opcionTorneos, opcionMeetups, opcionAsados);

        this.envioActivityTextViewOpcionesRecibidas.setText(opcionesSeleccionadas);








    }
}
