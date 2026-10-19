package Training

interface ErrorFunction {
    fun error(prediction:Float, target: Float):Float
}