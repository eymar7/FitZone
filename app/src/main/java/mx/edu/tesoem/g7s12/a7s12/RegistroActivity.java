package mx.edu.tesoem.g7s12.a7s12;

import android.os.Bundle;
import android.util.Patterns;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegistroActivity extends AppCompatActivity {

    TextInputEditText txtNombre, txtCorreoRegistro;
    TextInputEditText txtContrasenaRegistro, txtConfirmarContrasena;
    MaterialButton btnRegistrar;
    TextView txtVolverLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Relacionar elementos del XML
        txtNombre = findViewById(R.id.txtNombre);
        txtCorreoRegistro = findViewById(R.id.txtCorreoRegistro);
        txtContrasenaRegistro = findViewById(R.id.txtContrasenaRegistro);
        txtConfirmarContrasena = findViewById(R.id.txtConfirmarContrasena);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtVolverLogin = findViewById(R.id.txtVolverLogin);

        // Color de las letras
        txtNombre.setTextColor(Color.BLACK);
        txtCorreoRegistro.setTextColor(Color.BLACK);
        txtContrasenaRegistro.setTextColor(Color.BLACK);
        txtConfirmarContrasena.setTextColor(Color.BLACK);

        // Botón registrar
        btnRegistrar.setOnClickListener(v -> registrarUsuario());

        // Regresar al Login
        txtVolverLogin.setOnClickListener(v -> finish());
    }

    private void registrarUsuario() {

        String nombre = txtNombre.getText().toString().trim();
        String correo = txtCorreoRegistro.getText().toString().trim();
        String contrasena = txtContrasenaRegistro.getText().toString().trim();
        String confirmar = txtConfirmarContrasena.getText().toString().trim();

        if (nombre.isEmpty()) {
            txtNombre.setError("Ingresa tu nombre");
            txtNombre.requestFocus();
            return;
        }

        if (correo.isEmpty()) {
            txtCorreoRegistro.setError("Ingresa tu correo");
            txtCorreoRegistro.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            txtCorreoRegistro.setError("Ingresa un correo válido");
            txtCorreoRegistro.requestFocus();
            return;
        }

        if (contrasena.isEmpty()) {
            txtContrasenaRegistro.setError("Ingresa una contraseña");
            txtContrasenaRegistro.requestFocus();
            return;
        }

        if (contrasena.length() < 6) {
            txtContrasenaRegistro.setError("Mínimo 6 caracteres");
            txtContrasenaRegistro.requestFocus();
            return;
        }

        if (confirmar.isEmpty()) {
            txtConfirmarContrasena.setError("Confirma tu contraseña");
            txtConfirmarContrasena.requestFocus();
            return;
        }

        if (!contrasena.equals(confirmar)) {
            txtConfirmarContrasena.setError("Las contraseñas no coinciden");
            txtConfirmarContrasena.requestFocus();
            return;
        }

        Toast.makeText(this,
                "¡Registro validado correctamente!",
                Toast.LENGTH_LONG).show();
    }
}
