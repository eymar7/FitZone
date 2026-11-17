
package mx.edu.tesoem.g7s12.a7s12;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txtCorreo, txtContrasena;
    Button btnIniciarSesion;
    TextView txtOlvidaste, txtRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });

        // Relacionar elementos del XML
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContrasena = findViewById(R.id.txtContrasena);
        // Forzar el color blanco del texto escrito
        txtCorreo.setTextColor(Color.BLACK);
        txtContrasena.setTextColor(Color.BLACK);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        txtOlvidaste = findViewById(R.id.txtOlvidaste);
        txtRegistrarse = findViewById(R.id.txtRegistrarse);

        // Botón iniciar sesión
        btnIniciarSesion.setOnClickListener(v -> iniciarSesion());

        // Recuperar contraseña
        txtOlvidaste.setOnClickListener(v ->
                Toast.makeText(this,
                        "Función de recuperación de contraseña",
                        Toast.LENGTH_SHORT).show());

        // Abrir pantalla de registro
        txtRegistrarse.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(intent);
        });
    }

    private void iniciarSesion() {

        String correo = txtCorreo.getText().toString().trim();
        String contrasena = txtContrasena.getText().toString().trim();

        if (correo.isEmpty()) {
            txtCorreo.setError("Ingresa tu correo electrónico");
            txtCorreo.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            txtCorreo.setError("Ingresa un correo válido");
            txtCorreo.requestFocus();
            return;
        }

        if (contrasena.isEmpty()) {
            txtContrasena.setError("Ingresa tu contraseña");
            txtContrasena.requestFocus();
            return;
        }

        if (contrasena.length() < 6) {
            txtContrasena.setError("Mínimo 6 caracteres");
            txtContrasena.requestFocus();
            return;
        }

        Toast.makeText(this,
                "¡Datos correctos! Bienvenido a FitZone",
                Toast.LENGTH_LONG).show();
    }
}
