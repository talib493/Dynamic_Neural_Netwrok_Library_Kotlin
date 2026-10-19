package NeuralNetworkArchitechture

import Math.Vector
import Training.ActivationFunction

class Layer(
    noOfNeuron :Int,
    noOfInput :Int,
    val activationFunction:ActivationFunction
){
    val neurons = mutableListOf<Neuron>()
    init {
        for (i in 0 until noOfNeuron){
            neurons.add(Neuron(noOfInput, activationFunction = activationFunction))
        }
    }

    fun predict (input: Vector): Vector {

        val result =FloatArray(neurons.size)
        for (i in neurons.indices){
            result[i]=neurons[i].predict(input)

        }
        return Vector(result)
    }

}