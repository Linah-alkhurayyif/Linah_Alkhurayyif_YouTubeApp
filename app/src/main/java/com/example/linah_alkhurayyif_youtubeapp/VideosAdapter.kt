package com.example.linah_alkhurayyif_youtubeapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import kotlinx.android.synthetic.main.videos_item.view.*

class VideosAdapter(private val videos: ArrayList<videoClass>,private val player: YouTubePlayer): RecyclerView.Adapter<VideosAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    val opendvideos: ArrayList<videoClass> = arrayListOf(videoClass("No-Bake Strawberry Cheesecake＊No egg, No oven｜HidaMari Cooking", "3DJILHsdOlw",   R.drawable.strawberry_cheesecake,false))
    private lateinit var MainActivity:MainActivity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.videos_item,
                parent,
                false ))}
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val video = videos[position]
        holder.itemView.apply {
          videwTitle.text = video.videoTitle
          video_image.setImageResource(video.videos_image)
            videoLayout.setOnClickListener {
                video.videos_opend = true
                player.loadVideo(video.videoLink, 0f)
                opendvideos.add(videoClass(video.videoTitle,video.videoLink,video.videos_image,false))
                deleteTask()

            }

        }
    }
    override fun getItemCount() = videos.size
    fun deleteTask(){
        videos.add(opendvideos[0])
        opendvideos.removeFirst()
        videos.removeAll{video -> video.videos_opend }
        notifyDataSetChanged()
    }
     }