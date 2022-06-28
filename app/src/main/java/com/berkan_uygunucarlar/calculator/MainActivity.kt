package com.berkan_uygunucarlar.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(1000)
        installSplashScreen()

        setContentView(R.layout.activity_main)
    }

    fun btnSayi(view : View){

        if (yeniOperator){
            ekran.setText("")
        }
        yeniOperator = false

        var secilenBtn = view as Button
        var btnTikDeger : String = ekran.text.toString()

        when(secilenBtn.id){

            btn0.id ->{
                btnTikDeger+= "0"
            }

            btn1.id ->{
                btnTikDeger+= "1"
            }

            btn2.id ->{
                btnTikDeger+= "2"
            }

            btn3.id ->{
                btnTikDeger+= "3"
            }

            btn4.id ->{
                btnTikDeger+= "4"
            }

            btn5.id ->{
                btnTikDeger+= "5"
            }

            btn6.id ->{
                btnTikDeger+= "6"
            }

            btn7.id ->{
                btnTikDeger+= "7"
            }

            btn8.id ->{
                btnTikDeger+= "8"
            }

            btn9.id ->{
                btnTikDeger+= "9"
            }

            btnnokta.id ->{
                btnTikDeger+= "."
            }

            btnvirgul.id ->{
                btnTikDeger+= ","
            }

            btnartieksi.id ->{
                btnTikDeger= "-"+btnTikDeger
            }
        }
        ekran.setText(btnTikDeger)
    }

    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true

    fun btnOp(view: View){
        var btnSec = view as Button

        when(btnSec.id){

            btnbolme.id->{
                operator="/"
            }

            btncarpma.id->{
                operator="*"
            }

            btntoplama.id->{
                operator="+"
            }

            btncikarma.id->{
                operator="-"
            }

            btnyuzde.id->{
                operator = "%"
            }

        }

        eskiSayi = ekran.text.toString()
        yeniOperator = true
    }

    fun btnEsittir(view: View){

        var yeniSayi: String? = null
        var sonuc : Double? = null

        yeniSayi = ekran.text.toString()

        if (yeniSayi!= null){
            when(operator){
                "/" ->{
                    sonuc = eskiSayi.toDouble()/yeniSayi.toDouble()
                }

                "+" ->{
                    sonuc = eskiSayi.toDouble()+yeniSayi.toDouble()
                }

                "*" ->{
                    sonuc = eskiSayi.toDouble()*yeniSayi.toDouble()
                }

                "-" ->{
                    sonuc = eskiSayi.toDouble()-yeniSayi.toDouble()
                }
                "%"-> {
                    sonuc = (eskiSayi.toDouble() * yeniSayi.toDouble() / 100)
                }
            }
        }

        else{
            ekran.setText(eskiSayi)
        }
        ekran.setText(sonuc.toString())
        yeniOperator = true
    }

    fun btnSifirla(view: View){
        ekran.setText("0")
        yeniOperator = true
    }

}