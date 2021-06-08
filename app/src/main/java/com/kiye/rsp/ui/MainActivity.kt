package com.kiye.rsp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiye.rsp.R
import com.kiye.rsp.databinding.ActivityMainBinding
import com.kiye.rsp.enum.GameRules
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedButton = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setWinnerEvent()
        resetGame()
    }

    private fun setGame(playerChoice: Int, compChoice: Int) {
        if (playerChoice.plus(1).mod(3) == compChoice)
            binding.ivVs.setImageResource(R.drawable.p1menang)
        else if (playerChoice == compChoice)
            binding.ivVs.setImageResource(R.drawable.p2menang)
        else
            binding.ivVs.setImageResource(R.drawable.draw)
        setComputerBg(compChoice)
    }
    private fun setWinnerEvent(){
        binding.flAction1.setOnClickListener {
            selectedButton = 1
            binding.flAction1.setBackgroundResource(R.drawable.bg_action)
            binding.flAction2.setBackgroundResource(0)
            binding.flAction3.setBackgroundResource(0)
            setGame(1, Random.nextInt(0,3))
        }
        binding.flAction2.setOnClickListener {
            selectedButton = 2
            binding.flAction1.setBackgroundResource(0)
            binding.flAction2.setBackgroundResource(R.drawable.bg_action)
            binding.flAction3.setBackgroundResource(0)
            setGame(2,Random.nextInt(0,3))
        }
        binding.flAction3.setOnClickListener {
            selectedButton =3
            binding.flAction1.setBackgroundResource(0)
            binding.flAction2.setBackgroundResource(0)
            binding.flAction3.setBackgroundResource(R.drawable.bg_action)
            setGame(3,Random.nextInt(0,3))
        }
        binding.ivRefresh.setOnClickListener{
            resetGame()
        }
    }
    private fun setComputerBg(compChoice: Int){
        when(GameRules.fromInt(compChoice)){
            GameRules.ROCK->{
                binding.flAction4.setBackgroundResource(R.drawable.bg_action)
                binding.flAction5.setBackgroundResource(0)
                binding.flAction6.setBackgroundResource(0)
            }
            GameRules.PAPER->{
                binding.flAction4.setBackgroundResource(0)
                binding.flAction5.setBackgroundResource(R.drawable.bg_action)
                binding.flAction6.setBackgroundResource(0)
            }
            GameRules.SCISSOR->{
                binding.flAction4.setBackgroundResource(0)
                binding.flAction5.setBackgroundResource(0)
                binding.flAction6.setBackgroundResource(R.drawable.bg_action)
            }
        }
    }
    private fun resetGame(){
        binding.flAction1.setBackgroundResource(0)
        binding.flAction2.setBackgroundResource(0)
        binding.flAction3.setBackgroundResource(0)
        binding.flAction4.setBackgroundResource(0)
        binding.flAction5.setBackgroundResource(0)
        binding.flAction6.setBackgroundResource(0)
        binding.ivVs.setImageResource(R.drawable.vs)
    }
}

