package com.example.formulariodh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText formularioActivityEditTextNombre;
    private EditText formularioActivityEditTextApellido;
    private EditText formularioActivityEditTextEdad;
    private EditText formularioActivityEditTextCarrera;
    private EditText formularioActivityEditTextEmail;
    private CheckBox formularioActivityCheckBoxTorneos;
    private CheckBox formularioActivityCheckBoxMeetups;
    private CheckBox formularioActivityCheckBoxAsados;
    private Button formularioActivityButtonEnviar;


    private Boolean campoVacio(String text) {
        return text.equals("");
    }

    private Boolean nombreApellidoCorrecto() {
        String nombre = this.formularioActivityEditTextNombre.getText().toString();
        String apellido = this.formularioActivityEditTextApellido.getText().toString();

        return (nombre.length() > 2 && apellido.length() > 2);
    }

    private Boolean edadCorrecta() {
        Integer edad = Integer.parseInt(this.formularioActivityEditTextEdad.getText().toString());
        return (edad > 7 && edad < 100);
    }

    private Boolean carreraCorrecta() {
        String carrera = this.formularioActivityEditTextCarrera.getText().toString();
        return carrera.length() > 5;
    }

    private Boolean emailCorrecto() {
        String email = this.formularioActivityEditTextEmail.getText().toString();
        return email.contains("@");
    }

    private Boolean comprobarCampos() {
        return nombreApellidoCorrecto() && edadCorrecta() && carreraCorrecta() && emailCorrecto();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.formularioActivityEditTextNombre = findViewById(R.id.FormularioActivityEditTextNombre);
        this.formularioActivityEditTextApellido = findViewById(R.id.FormularioActivityEditTextApellido);
        this.formularioActivityEditTextEdad = findViewById(R.id.FormularioActivityEditTextEdad);
        this.formularioActivityEditTextCarrera = findViewById(R.id.FormularioActivityEditTextCarrera);
        this.formularioActivityEditTextEmail = findViewById(R.id.FormularioActivityEditTextEmail);
        this.formularioActivityCheckBoxTorneos = findViewById(R.id.FormularioActivityCheckBoxTorneos);
        this.formularioActivityCheckBoxMeetups = findViewById(R.id.FormularioActivityCheckBoxMeetups);
        this.formularioActivityCheckBoxAsados = findViewById(R.id.FormularioActivityCheckBoxAsados);
        this.formularioActivityButtonEnviar = findViewById(R.id.FormularioActivityButtonEnviar);



        this.formularioActivityButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (comprobarCampos()) {

                    Intent formularioAEnvio = new Intent(FormularioActivity.this, EnvioActivity.class);

                    Bundle datosFormulario = new Bundle();
                    datosFormulario.putString("nombre", formularioActivityEditTextNombre.getText().toString());
                    datosFormulario.putString("apellido", formularioActivityEditTextApellido.getText().toString());
                    datosFormulario.putString("edad", formularioActivityEditTextEdad.getText().toString());
                    datosFormulario.putString("carrera", formularioActivityEditTextCarrera.getText().toString());
                    datosFormulario.putString("email", formularioActivityEditTextEmail.getText().toString());

                    if(formularioActivityCheckBoxAsados.isChecked()){
                        datosFormulario.putBoolean("asados", true);
                    } else {
                        datosFormulario.putBoolean("asados", false);
                    }

                    if(formularioActivityCheckBoxMeetups.isChecked()){
                        datosFormulario.putBoolean("meetups", true);
                    } else {
                        datosFormulario.putBoolean("meetups", false);
                    }

                    if(formularioActivityCheckBoxTorneos.isChecked()){
                        datosFormulario.putBoolean("torneos", true);
                    } else {
                        datosFormulario.putBoolean("torneos", false);
                    }

                    formularioAEnvio.putExtras(datosFormulario);

                    startActivity(formularioAEnvio);


                } else {
                    Toast.makeText(FormularioActivity.this, "Verificar los datos ingresados", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
