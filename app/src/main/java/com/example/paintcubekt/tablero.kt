package com.example.paintcubekt

import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.OnTouchListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment


class tablero : Fragment() {

    private lateinit var detector: GestureDetectorCompat
    private lateinit var box: Array<TextView>
    private lateinit var cubo: Cube
    private var currentBox=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_tablero, container, false)

        detector = GestureDetectorCompat(requireContext(), GestureListener())
        view.setOnTouchListener { view, event ->
            detector.onTouchEvent(event)
            true
        }
        box = Array(20) { TextView(requireContext()) }

        box[0]=view.findViewById(R.id.mainCube);
        box[1]=view.findViewById(R.id.box1);
        box[2]=view.findViewById(R.id.box2);
        box[3]=view.findViewById(R.id.box3);
        box[4]=view.findViewById(R.id.box4);
        box[5]=view.findViewById(R.id.box5);
        box[6]=view.findViewById(R.id.box6);
        box[7]=view.findViewById(R.id.box7);
        box[8]=view.findViewById(R.id.box8);
        box[9]=view.findViewById(R.id.box9);
        box[10]=view.findViewById(R.id.box10);
        box[11]=view.findViewById(R.id.box11);
        box[12]=view.findViewById(R.id.box12);
        box[13]=view.findViewById(R.id.box13);
        box[14]=view.findViewById(R.id.box14);
        box[15]=view.findViewById(R.id.box15);
        box[16]=view.findViewById(R.id.box16);
        box[17]=view.findViewById(R.id.box17);
        box[18]=view.findViewById(R.id.box18);
        box[19]=view.findViewById(R.id.box19);


        val green = ContextCompat.getColor(requireContext(), R.color.green)
        val blue = ContextCompat.getColor(requireContext(), R.color.blue)
        val red = ContextCompat.getColor(requireContext(), R.color.red)
        val purple = ContextCompat.getColor(requireContext(), R.color.purple)
        val black = ContextCompat.getColor(requireContext(), R.color.black)
        val white = ContextCompat.getColor(requireContext(), R.color.white)
        val pink = ContextCompat.getColor(requireContext(), R.color.pink)
        val orange = ContextCompat.getColor(requireContext(), R.color.orange)
        val yellow = ContextCompat.getColor(requireContext(), R.color.yellow)



        var colores = intArrayOf(green, red, blue, orange, purple, yellow)
        cubo = Cube(colores)


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tablero().apply {

            }
    }

    fun paintBox(box_to_paint:Int, move:String, positive:Boolean):Boolean{
        if(move.equals("horizontal")){
            if(cubo.moveHorizontal(positive)){
                var color = cubo.getColor()
                box[box_to_paint].setBackgroundColor(color)
                return true
            }else{
                Toast.makeText(requireContext(), "No puedes moverte mas", Toast.LENGTH_LONG)
                Log.d("warning", "no puedes moverte mas")
                return false
            }
        }else{
            if(cubo.moveVertical(positive)){
                var color = cubo.getColor()
                box[box_to_paint].setBackgroundColor(color)
                return true
            }else{
                Toast.makeText(requireContext(), "No puedes moverte mas", Toast.LENGTH_LONG)
                Log.d("warning", "no puedes moverte mas")
                return false
            }
        }


    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        private val  SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onFling(
            downEvent: MotionEvent?,
            moveEvent: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var diffX = moveEvent?.x?.minus(downEvent!!.x) ?: 0.0F
            var diffY = moveEvent?.y?.minus(downEvent!!.y) ?: 0.0F

            return if (Math.abs(diffX) > Math.abs(diffY)) {
                // this is a left or right swipe
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0 ) {
                        // right swipe
                        Log.d("derecha", "derecha")
                        currentBox++
                        if(!paintBox(currentBox, "horizontal", true))currentBox--
                    } else {
                        Log.d("izquierda", "izquierda")
                        currentBox--
                        if(!paintBox(currentBox, "horizontal", false))currentBox++
                    }
                    true
                } else  {
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }
            } else {
                // this is either a bottom or top swipe.
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        Log.d("abajo", "abajo")
                        currentBox=currentBox+4
                        if(!paintBox(currentBox, "vertical", true))currentBox=currentBox-4
                    } else {
                        Log.d("arriba", "arriba")
                        currentBox=currentBox-4
                        if(!paintBox(currentBox, "vertical", false))currentBox=currentBox+4
                    }
                    true
                } else {
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)

                }
            }


        }
    }

}