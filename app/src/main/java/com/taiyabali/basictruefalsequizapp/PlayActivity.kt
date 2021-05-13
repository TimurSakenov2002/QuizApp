package com.taiyabali.basictruefalsequizapp

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taiyabali.basictruefalsequizapp.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayBinding

    var updatedQuesNo: Int = 1
    var qIndex: Int = 0
    var correct: Int = 0
    var wrong: Int = 0
    var score: Int = 0

    lateinit var checkAnswer: String

    private var questions = arrayOf(
        "Q.1. Digital camera is input device used to take photographs",
        "Q.2. Octal number system contains digits from 0 - 7.",
        "Q.3. MS Word is a hardware.",
        "Q.4. CPU controls only input data of computer.",
        "Q.5. The Language that the computer can understand is called Machine Language.",
        "Q.6. Dot-matrix, Deskjet, Inkjet and Laser are all types of Printers.",
        "Q.7. Linux is a open source operating system.",
        "Q.8. Read-only memory is a high-speed buffer.",
        "Q.9. The “brain” of a computer is main memory.",
        "Q.10. Microcomputers have largely replaced minicomputers."
    )

    private var answer = arrayOf(
        "True",
        "True",
        "False",
        "False",
        "True",
        "True",
        "True",
        "False",
        "False",
        "True"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            tvQuestion.text = questions[0]

            btnNextButton.setOnClickListener {
                if (radioGroup.checkedRadioButtonId == -1) {
                    Toast.makeText(this@PlayActivity, "Please select an options", Toast.LENGTH_SHORT).show()
                } else {
                    showNextQuestion()
                }
            }
        }
    }

    private fun checkAnswer() {

        val radioButton_id = findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)

        checkAnswer = radioButton_id.text.toString()
        if (checkAnswer.equals(answer[qIndex])) {
            correct++
            score = correct
            binding.tvScore.text = ("Score : $score")
        } else {
            wrong++
        }

        qIndex++
    }


    private fun showNextQuestion() {

        checkAnswer()
        setNextQues()

    }

    private fun setNextQues() {

        if (updatedQuesNo < 10) {
            binding.tvNoOfQues.text = ("${updatedQuesNo + 1} /10")
            updatedQuesNo++
        }

        if (qIndex < questions.size) {
            binding.tvQuestion.text = (questions[qIndex])
        } else {



            val intent=Intent(this,ResultActivity::class.java).apply {
                putExtra("correctAns", "$score")

            }
            startActivity(intent)
            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show()
        }

        binding.radioGroup.clearCheck()
    }
}