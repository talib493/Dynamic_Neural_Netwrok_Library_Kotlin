package Training

object MeansSquaredError:ErrorFunction {
    override fun error(prediction: Float, target: Float): Float {
        return target - prediction
    }
}