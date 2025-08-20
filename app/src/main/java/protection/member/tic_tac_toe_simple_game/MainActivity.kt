package protection.member.tic_tac_toe_simple_game

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import protection.member.tic_tac_toe_simple_game.databinding.ActivityMainBinding
import protection.member.tic_tac_toe_simple_game.gameplayer.multiplayer.PlayerVsPlayerActivity
import protection.member.tic_tac_toe_simple_game.gameplayer.solo_player.PlayerVsComputerActivity

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        binding.soloPlayer.setOnClickListener {
            Toast.makeText(this, "Player vs Computer", Toast.LENGTH_LONG).show()

            val intent = Intent(this@MainActivity, PlayerVsComputerActivity::class.java)
            startActivity(intent)
        }

        binding.multiplayer.setOnClickListener {
            Toast.makeText(this, "Player vs Player", Toast.LENGTH_LONG).show()

            val intent = Intent(this@MainActivity, PlayerVsPlayerActivity::class.java)
            startActivity(intent)
        }
    }
}