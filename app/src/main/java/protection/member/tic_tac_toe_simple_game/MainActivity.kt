package protection.member.tic_tac_toe_simple_game

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import protection.member.tic_tac_toe_simple_game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var soloPlayer: MaterialButton
    private lateinit var multiPlayer: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        soloPlayer = binding.solo
        multiPlayer = binding.multiplayer

        soloPlayer.setOnClickListener(this)
        multiPlayer.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.solo -> {
                Toast.makeText(this, "Solo player", Toast.LENGTH_LONG).show()
                val intent = Intent(this@MainActivity, SoloPlayerActivity::class.java)

                startActivity(intent)
            }

            R.id.multiplayer -> {
                Toast.makeText(this, "Multi Player", Toast.LENGTH_LONG).show()
                val intent = Intent(this@MainActivity, MultiPlayerActivity::class.java)

                startActivity(intent)
            }
        }
    }
}