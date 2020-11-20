package com.example.bigbraintrivia

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bigbraintrivia.data.DatabaseImpl
import com.example.bigbraintrivia.leaderboard.LeaderBoardActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val uiScope = CoroutineScope(Dispatchers.Default)
    private val database: IDatabase = DatabaseImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            val activity = this
            uiScope.launch {
                if (database.isLoginValid(txtUsuario.text.toString(), txtSenha.text.toString())) {

                    (getApplication() as BigBrainTrivia).usuario = txtUsuario.text.toString()
                    CoroutineScope(Dispatchers.Main).launch{ LeaderBoardActivity.open(activity) }
                } else {
                    CoroutineScope(Dispatchers.Main).launch{Toast.makeText(this@MainActivity, "Login inválido!!", Toast.LENGTH_SHORT).show()}
                }
            }
        }


        cadButton.setOnClickListener {
            val activity = this

            uiScope.launch {
                if ( database.userExists(txtUsuario.text.toString()) ) {
                    CoroutineScope(Dispatchers.Main).launch{Toast.makeText(this@MainActivity, "Usuário já cadastrado!!", Toast.LENGTH_SHORT).show()}
                } else {
                    if (txtSenha.text.toString() != ""){
                        database.registerPlayer(txtUsuario.text.toString(), txtSenha.text.toString())
                    }else{
                        CoroutineScope(Dispatchers.Main).launch{Toast.makeText(this@MainActivity, "Informe uma senha!!", Toast.LENGTH_SHORT).show()}
                    }
                }
            }
        }

    }
}
