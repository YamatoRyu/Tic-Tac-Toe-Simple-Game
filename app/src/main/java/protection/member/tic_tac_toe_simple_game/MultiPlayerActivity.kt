package protection.member.tic_tac_toe_simple_game

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import protection.member.tic_tac_toe_simple_game.databinding.ActivityMultiPlayerBinding

class MultiPlayerActivity : AppCompatActivity() {
    enum class Turn {
        NOUGHT,
        CROSS
    }

    companion object {
        const val FIRST_PLAYER = "O"
        val FIRST_PLAYER_COLOR = R.color.you_chan
        const val SECOND_PLAYER = "X"
        val SECOND_PLAYER_COLOR = R.color.red
    }

    private var finishTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS
    private val boardList = mutableListOf<MaterialButton>()

    private lateinit var binding: ActivityMultiPlayerBinding

    private lateinit var scorePlayer1: TextView
    private lateinit var scorePlayer2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playGame()
        scorePlayer1 = binding.player1Score
        scorePlayer2 = binding.player2Score
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

    private fun playGame() {
        boardList.add(binding.button1)
        boardList.add(binding.button2)
        boardList.add(binding.button3)
        boardList.add(binding.button4)
        boardList.add(binding.button5)
        boardList.add(binding.button6)
        boardList.add(binding.button7)
        boardList.add(binding.button8)
        boardList.add(binding.button9)
    }

    fun onClickButton(view: View) {
        if (view !is MaterialButton) return

        addToBoard(view)
    }

    private fun addToBoard(materialButton: MaterialButton) {
        if (materialButton.text != "") return

        if (currentTurn == Turn.NOUGHT) {
            materialButton.text = FIRST_PLAYER
            materialButton.setTextColor(FIRST_PLAYER_COLOR)
            currentTurn = Turn.CROSS
        }

        else if (currentTurn == Turn.CROSS) {
            materialButton.text = SECOND_PLAYER
            materialButton.setTextColor(SECOND_PLAYER_COLOR)
            currentTurn = Turn.NOUGHT
        }

        setTurnLabel()
    }

    @SuppressLint("ResourceAsColor")
    private fun setTurnLabel() {
        var turnText = ""
        var turnColor = 0

        if (currentTurn == Turn.CROSS) {
            turnText = "Turn $SECOND_PLAYER"
            turnColor = R.color.you_chan
        }

        else if (currentTurn == Turn.NOUGHT) {
            turnText = "Turn $FIRST_PLAYER"
            turnColor = R.color.red
        }

        binding.turn.text = turnText
        binding.turn.setTextColor(turnColor)
    }
}