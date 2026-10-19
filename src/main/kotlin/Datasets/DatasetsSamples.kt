package Datasets

import Math.Vector

class DatasetsSamples {
    val xorData = listOf(
        TrainingDataStructure(
            input = Vector(floatArrayOf(0f, 0f)),
            target = Vector(floatArrayOf(0f))
        ),

        TrainingDataStructure(
            input = Vector(floatArrayOf(0f, 1f)),
            target = Vector(floatArrayOf(1f))
        ),

        TrainingDataStructure(
            input = Vector(floatArrayOf(1f, 0f)),
            target = Vector(floatArrayOf(1f))
        ),

        TrainingDataStructure(
            input = Vector(floatArrayOf(1f, 1f)),
            target = Vector(floatArrayOf(0f))
        )
    )


}