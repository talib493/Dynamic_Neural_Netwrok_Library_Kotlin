package Training

import kotlin.math.exp

object Sigmoid:ActivationFunction {
    override fun activation(x: Float): Float {
        return (1f / (1f + exp(-x.toDouble()))).toFloat()
    }

    override fun derivative(output: Float): Float {
        return output * (1f - output)
    }

}