package NeuralNetworkArchitechture

import Math.Vector
import Training.ErrorFunction

class NeuralNetwork(
    val layers:List<Layer>
) {
    fun loss(prediction: Float, target: Float): Float {
        val error = target - prediction
        return 0.5f * error * error
    }

    fun DynamicPredict(input: Vector): List<Vector> {
        var predictlist = mutableListOf<Vector>()
        var current = input
        for (layer in layers) {
            current = layer.predict(current)
            predictlist.add(current)
        }
        return predictlist
    }

    fun DynamicDelta(list: List<Vector>, target: Vector, errorFunction:ErrorFunction): List<Vector> {
        val deltaList = mutableListOf<Vector>()
        val outputDelta = FloatArray(target.values.size)
        for (i in target.values.indices) {
            val error = errorFunction.error(list.get(list.lastIndex).values[i], target.values[i])
            val derivative = layers.last().activationFunction.derivative(list.get(list.lastIndex).values[i])
            outputDelta[i] = error * derivative
        }
        deltaList.add(Vector(outputDelta))

        for (layer in layers.lastIndex downTo 1) {
            val deltaIndex = layers.lastIndex - layer
            val hiddenDelta = FloatArray(layers[layer - 1].neurons.size)
            for (hiddenNeurons in 0 until layers[layer - 1].neurons.size) {
                var sum = 0f
                for (nextlayerNeuron in 0 until layers[layer].neurons.size) {
                    val weight =
                        layers[layer].neurons[nextlayerNeuron]
                            .weights
                            .values[hiddenNeurons]

                    val nextDelta =
                        deltaList[deltaIndex]
                            .values[nextlayerNeuron]

                    sum += weight * nextDelta
                }
                val activation = list[layer - 1].values[hiddenNeurons]
                val weightedSum = layers[layer-1].neurons[hiddenNeurons].weightedSum

                val delta = sum * layers[layer-1].activationFunction.derivative(activation)
                hiddenDelta[hiddenNeurons] = delta
            }
            deltaList.add(Vector(hiddenDelta))
        }


        return deltaList
    }
}