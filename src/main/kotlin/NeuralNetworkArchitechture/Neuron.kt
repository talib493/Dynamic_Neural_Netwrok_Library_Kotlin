package NeuralNetworkArchitechture

import Math.Vector
import Training.ActivationFunction
import kotlin.random.Random

class Neuron(
    inputSize: Int,
    val activationFunction: ActivationFunction
) {
    val weights = Vector(FloatArray(inputSize){
        Random.nextFloat() * 2f - 1f
    }
    )
    var bias  = Random.nextFloat() * 2f - 1f
    var weightedSum =0f
    var outputSum =0f

    fun predict(input: Vector): Float {

        require(input.values.size == weights.values.size) {
            "Input size and weight size must match"
        }

        weightedSum =
            input.dot(weights) + bias

        outputSum = activationFunction.activation(weightedSum)
        return outputSum
    }
}