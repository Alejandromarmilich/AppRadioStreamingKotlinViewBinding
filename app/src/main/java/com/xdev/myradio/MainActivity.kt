package com.xdev.myradio

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.xdev.myradio.databinding.ActivityMainBinding
import java.io.IOException
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var player:  MediaPlayer
    private lateinit var audioManager: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.play.visibility = View.GONE
        binding.pause.visibility = View.GONE
        init()
        binding.volumeControl.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        binding.volumeControl.progress = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        listener()
    }


    private fun init(){
        this.audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        this.player = MediaPlayer()
        this.player.setAudioAttributes(AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        )
        try {
            player.setDataSource(getString(R.string.url))
            player.prepareAsync()
            player.setOnPreparedListener {
                binding.play.performClick()
            }
        }catch (e: IllegalArgumentException){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }catch (e: IllegalStateException){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }catch (e: IOException){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun listener() {
        binding.play.setOnClickListener{
            player.start()
            binding.play.visibility = View.GONE
            binding.pause.visibility = View.VISIBLE
        }
        binding.pause.setOnClickListener {
            player.pause()
            binding.play.visibility = View.VISIBLE
            binding.pause.visibility = View.GONE
        }
        binding.volumeControl.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
    }
}

