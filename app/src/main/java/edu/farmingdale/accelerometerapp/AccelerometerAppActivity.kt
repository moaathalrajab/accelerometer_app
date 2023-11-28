package edu.farmingdale.accelerometerapp

import android.app.Activity
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.TextView


class AccelerometerAppActivity : Activity(), SensorEventListener {
    var xAxisView: TextView? = null
    var yAxisView: TextView? = null
    var zAxisView: TextView? = null
    var sensorManager: SensorManager? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer_app)
        xAxisView = findViewById<View>(R.id.xaxisview) as TextView
        yAxisView = findViewById<View>(R.id.yaxisview) as TextView
        zAxisView = findViewById<View>(R.id.zaxisview) as TextView
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager!!.registerListener(
            this,
            sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            xAxisView!!.text = "X: $x"
            yAxisView!!.text = "Y: $y"
            zAxisView!!.text = "Z: $z"
        }
    }
}