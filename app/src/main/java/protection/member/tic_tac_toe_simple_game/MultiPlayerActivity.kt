package protection.member.tic_tac_toe_simple_game

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import protection.member.tic_tac_toe_simple_game.databinding.ActivityMultiPlayerBinding

class MultiPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMultiPlayerBinding

    private var firstPlayer = 0
    private var secondPlayer = 0

    enum class Turn {
        NOUGHT,
        CROSS
    }

    companion object {
        const val FIRST_PLAYER_TEXT = "O"
        const val SECOND_PLAYER_TEXT = "X"

        val FIRST_PLAYER_COLOR = R.color.you_chan
        val SECOND_PLAYER_COLOR = R.color.red
    }

    private var finishTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS
    private val arrayButtonTable = mutableListOf<MaterialButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.player1Score.text = firstPlayer.toString()
        binding.player2Score.text = secondPlayer.toString()

        materialButtonAdd()
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

    private fun materialButtonAdd() {
        arrayButtonTable.add(binding.button1)
        arrayButtonTable.add(binding.button2)
        arrayButtonTable.add(binding.button3)
        arrayButtonTable.add(binding.button4)
        arrayButtonTable.add(binding.button5)
        arrayButtonTable.add(binding.button6)
        arrayButtonTable.add(binding.button7)
        arrayButtonTable.add(binding.button8)
        arrayButtonTable.add(binding.button9)
    }

    @SuppressLint("ResourceAsColor")
    private fun addMaterialButton(materialButton: MaterialButton) {
        if (materialButton.text != "") return

        if (currentTurn == Turn.CROSS) {
            materialButton.text = "O"
            materialButton.setTextColor(ContextCompat.getColor(this, R.color.you_chan))

            currentTurn = Turn.NOUGHT
        }

        else if (currentTurn == Turn.NOUGHT) {
            materialButton.text = "X"
            materialButton.setTextColor(Color.RED)

            currentTurn = Turn.CROSS
        }

        getTurn()
    }

    private fun getTurn() {
        var turnText = ""
        var turnColor = 0

        if (currentTurn == Turn.CROSS) {
            turnText = "Turn $FIRST_PLAYER_TEXT"
            turnColor = FIRST_PLAYER_COLOR
        }

        else if (currentTurn == Turn.NOUGHT) {
            turnText = "Turn $SECOND_PLAYER_TEXT"
            turnColor = SECOND_PLAYER_COLOR
        }

        binding.turn.text = turnText
        binding.turn.setTextColor(ContextCompat.getColor(this, turnColor))
    }

    fun onClickButton(view: View) {
        if (view !is MaterialButton) return

        addMaterialButton(view)
    }
}