package Training

interface ActivationFunction {
    fun activation(x:Float):Float
    fun derivative(output:Float):Float
}