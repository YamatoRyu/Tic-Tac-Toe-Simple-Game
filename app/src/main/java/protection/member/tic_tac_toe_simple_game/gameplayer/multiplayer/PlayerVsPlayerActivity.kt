package protection.member.tic_tac_toe_simple_game.gameplayer.multiplayer

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import protection.member.tic_tac_toe_simple_game.R
import protection.member.tic_tac_toe_simple_game.databinding.ActivityPlayerVsPlayerBinding

class PlayerVsPlayerActivity : AppCompatActivity() {
    private var _binding: ActivityPlayerVsPlayerBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val PLAYER1_TEXT = "O"
        const val PLAYER2_TEXT = "X"
    }

    private val arrayPlayer = mutableListOf<MaterialButton>()

    private var yourTurn = MultiPlayerTurn.CIRCLE

    private lateinit var player1: TextView
    private lateinit var player2: TextView

    private var player1Score = 0
    private var player2Score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPlayerVsPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        player1 = binding.player1Score
        player2 = binding.player2Score

        player1.text = player1Score.toString()
        player2.text = player2Score.toString()

        binding.whoTurn.text = "Turn $PLAYER1_TEXT"
        binding.whoTurn.setTextColor(ContextCompat.getColor(this, R.color.you_chan))

        addArrayButton()
    }

    override fun onSupportNavigateUp(): Boolean {
        onSupportNavigateUp()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }

        return false
    }

    private fun addArrayButton() {
        arrayPlayer.add(binding.button1)
        arrayPlayer.add(binding.button2)
        arrayPlayer.add(binding.button3)
        arrayPlayer.add(binding.button4)
        arrayPlayer.add(binding.button5)
        arrayPlayer.add(binding.button6)
        arrayPlayer.add(binding.button7)
        arrayPlayer.add(binding.button8)
        arrayPlayer.add(binding.button9)

        onClick()
    }

    private fun onClick() {
        arrayPlayer.forEach {
            it.setOnClickListener { view ->
                setAddBoar(it)

                if (getFullBoard()) restartBoard()
            }
        }
    }

    private fun getFullBoard(): Boolean {
        for (button in arrayPlayer) {
            if (button.text == "") return false
        }

        return true
    }

    private fun setAddBoar(materialButton: MaterialButton) {
        if (materialButton.text != "") return

        if (yourTurn == MultiPlayerTurn.CIRCLE) {
            materialButton.text = PLAYER1_TEXT
            materialButton.setTextColor(ContextCompat.getColor(this, R.color.you_chan))

            yourTurn = MultiPlayerTurn.CROSS
        }

        else if (yourTurn == MultiPlayerTurn.CROSS) {
            materialButton.text = PLAYER2_TEXT
            materialButton.setTextColor(Color.RED)

            yourTurn = MultiPlayerTurn.CIRCLE
        }

        setTurnBoard()
    }

    private fun restartBoard() {
        Toast.makeText(this, "Reset your again", Toast.LENGTH_LONG).show()

        for (button in arrayPlayer) button.text = ""
        yourTurn = MultiPlayerTurn.CIRCLE

        setTurnBoard()
    }

    private fun setTurnBoard() {
        var turnText = ""
        var turnColor = 0

        if (yourTurn == MultiPlayerTurn.CIRCLE) {
            turnText = "Turn $PLAYER1_TEXT"
            turnColor = R.color.you_chan
        }

        else if (yourTurn == MultiPlayerTurn.CROSS) {
            turnText = "Turn $PLAYER2_TEXT"
            turnColor = R.color.red
        }

        binding.whoTurn.text = turnText
        binding.whoTurn.setTextColor(ContextCompat.getColor(this, turnColor))
    }
}