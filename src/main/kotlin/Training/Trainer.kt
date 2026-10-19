package Training

import Datasets.TrainingDataStructure
import NeuralNetworkArchitechture.NeuralNetwork

class Trainer(
    private val network: NeuralNetwork,
) {
    fun train(
        samples: List<TrainingDataStructure>,
        epochs: Int,
        errorFunction:ErrorFunction
    ) {
        repeat(epochs) {
            training(samples, errorFunction = errorFunction)
        }
    }


    fun training(sample: List<TrainingDataStructure>,errorFunction: ErrorFunction) {
        var loss = 0f
        for (data in sample) {
            val layers = network.layers
            val prediction = network.DynamicPredict(data.input)
            loss += network.loss(prediction[prediction.lastIndex].values[0], data.target.values[0])
            val delta = network.DynamicDelta(prediction, data.target,errorFunction)
            val learningRate = 0.1f

            val outputLayer = layers[layers.lastIndex]


            for ((outputNeuronIndex, outputNeuron) in outputLayer.neurons.withIndex()) {
                for ((outputNeuronWeightIndex, outputNeuronWeights) in outputNeuron.weights.values.withIndex()) {
                    val weightChange =
                        learningRate * delta[0].values[outputNeuronIndex] * prediction[prediction.lastIndex - 1].values[outputNeuronWeightIndex]
                    outputLayer.neurons[outputNeuronIndex].weights.values[outputNeuronWeightIndex] += weightChange
                }
                outputNeuron.bias += learningRate * delta[0].values[outputNeuronIndex]
            }


            for (hiddenLayersIndex in layers.lastIndex - 1 downTo 0) {
                val deltaIndex = layers.lastIndex - hiddenLayersIndex
                for ((hiddenLayerNeuronsIndex, hiddenLayerNeurons) in layers[hiddenLayersIndex].neurons.withIndex()) {
                    for ((hiddenWeightsIndex, hiddenWeights) in hiddenLayerNeurons.weights.values.withIndex()) {
                        val previousActivation =
                            if (hiddenLayersIndex == 0)
                                data.input
                            else
                                prediction[hiddenLayersIndex - 1]

                        val weightChange =
                            learningRate * delta[deltaIndex].values[hiddenLayerNeuronsIndex] * previousActivation.values[hiddenWeightsIndex]
                        layers[hiddenLayersIndex].neurons[hiddenLayerNeuronsIndex].weights.values[hiddenWeightsIndex] += weightChange
                    }
                    layers[hiddenLayersIndex].neurons[hiddenLayerNeuronsIndex].bias += learningRate * delta[deltaIndex].values[hiddenLayerNeuronsIndex]
                }
            }
        }
        println("Loss: " + loss)

    }
}