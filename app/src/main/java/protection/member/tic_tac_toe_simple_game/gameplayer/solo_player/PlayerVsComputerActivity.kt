package protection.member.tic_tac_toe_simple_game.gameplayer.solo_player

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import protection.member.tic_tac_toe_simple_game.R
import protection.member.tic_tac_toe_simple_game.databinding.ActivityPlayerVsComputerBinding

class PlayerVsComputerActivity : AppCompatActivity() {
    private var _binding: ActivityPlayerVsComputerBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val PLAYER = "O"
        const val COMPUTER = "X"
    }

    private val array = mutableListOf<MaterialButton>()

    private val firstTurn = SoloPlayerTurn.PLAYER_CIRCLE
    private val drawFirstTurn = SoloPlayerTurn.PLAYER_CIRCLE

    private lateinit var player: TextView
    private lateinit var computer: TextView

    private var playerScore = 0
    private var computerScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPlayerVsComputerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onSupportNavigateUp()
        return true
    }
}