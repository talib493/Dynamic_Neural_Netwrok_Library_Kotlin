package Math

class Vector (val values:FloatArray){

    override fun toString(): String {
        return values.joinToString(
            prefix = "(",
            postfix = ")"
        )
    }

    fun times(other: Vector):Vector{
        require(values.size == other.values.size) {
            "Vector sizes must match."
        }

        var product = FloatArray(other.values.size)
        for(i in other.values.indices) {
            product[i]=(values[i]*other.values[i])
        }
        return Vector(product)
    }

    fun dot(other: Vector): Float{
        require(values.size == other.values.size) {
            "Vector sizes must match. Found ${values.size} and ${other.values.size}"
        }

        var sumOfP = 0f
        for (i  in values.indices){
            sumOfP += (values[i]*other.values[i])
        }
        return sumOfP
    }


    fun add(other: Vector): Vector {
        require(values.size == other.values.size) {
            "Vector sizes must match. Found ${values.size} and ${other.values.size}"
        }
        val sum = FloatArray(values.size)

        for (i in values.indices){
            sum[i]=values[i]+other.values[i]

        }
        return Vector(sum)
    }



    fun subtract(other: Vector): Vector {
        require(values.size == other.values.size) {
            "Vector sizes must match. Found ${values.size} and ${other.values.size}"
        }
        val subtraction = FloatArray(values.size)

        for (i in values.indices){
            subtraction[i]=values[i]-other.values[i]

        }
        return Vector(subtraction)
    }
    fun floatProductVector(other: Float):Vector{
        val product = FloatArray(values.size)
        for (i in values.indices){
            product[i]=values[i]*other
        }
        return Vector(product)
    }

    fun floatAddVector(other: Float):Vector{
        val addition = FloatArray(values.size)
        for (i in 0 until values.size){
            addition[i]=values[i]+other
        }
        return Vector(addition)
    }

    fun argmax(): Int {

        var maxIndex = 0

        for (i in 1 until values.size) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i
            }
        }

        return maxIndex
    }



}