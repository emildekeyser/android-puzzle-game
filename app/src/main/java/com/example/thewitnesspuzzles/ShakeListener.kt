package com.example.thewitnesspuzzles

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.Toast

class ShakeListener(private val mContext: Context) : SensorEventListener {
    private var mSensorMgr: SensorManager? = null
    private var mLastX = -1.0f
    private var mLastY = -1.0f
    private var mLastZ = -1.0f
    private var mLastTime: Long = 0
    private var mShakeListener: OnShakeListener? = null
    private var mShakeCount = 0
    private var mLastShake: Long = 0
    private var mLastForce: Long = 0

    interface OnShakeListener {
        fun onShake()
    }

    fun setOnShakeListener(listener: OnShakeListener?) {
        mShakeListener = listener
    }

    private fun resume() {
        mSensorMgr =
            mContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if (mSensorMgr == null) {
            throw UnsupportedOperationException("Sensors not supported")
        }
        var supported = false
        try {
            supported = mSensorMgr!!.registerListener(
                this,
                mSensorMgr!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME
            )
        } catch (e: Exception) {
            Toast.makeText(mContext, "Shaking not supported", Toast.LENGTH_LONG).show()
        }
        if (!supported && mSensorMgr != null) mSensorMgr!!.unregisterListener(this)
    }

    fun pause() {
        if (mSensorMgr != null) {
            mSensorMgr!!.unregisterListener(this)
            mSensorMgr = null
        }
    }

    override fun onAccuracyChanged(
        sensor: Sensor,
        accuracy: Int
    ) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type != Sensor.TYPE_ACCELEROMETER) return
        val now = System.currentTimeMillis()
        if (now - mLastForce > SHAKE_TIMEOUT) {
            mShakeCount = 0
        }
        if (now - mLastTime > TIME_THRESHOLD) {
            val diff = now - mLastTime
            val speed =
                Math.abs(event.values[0] + event.values[1] + event.values[2] - mLastX - mLastY - mLastZ) / diff * 10000
            if (speed > FORCE_THRESHOLD) {
                if (++mShakeCount >= SHAKE_COUNT && now - mLastShake > SHAKE_DURATION) {
                    mLastShake = now
                    mShakeCount = 0
                    if (mShakeListener != null) {
                        mShakeListener!!.onShake()
                    }
                }
                mLastForce = now
            }
            mLastTime = now
            mLastX = event.values[0]
            mLastY = event.values[1]
            mLastZ = event.values[2]
        }
    }

    companion object {
        private const val FORCE_THRESHOLD = 700
        private const val TIME_THRESHOLD = 100
        private const val SHAKE_TIMEOUT = 500
        private const val SHAKE_DURATION = 1000
        private const val SHAKE_COUNT = 5
    }

    init {
        resume()
    }
}