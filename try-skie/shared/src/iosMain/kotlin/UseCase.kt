actual abstract class UseCase<in I : Any, out O : Any> {
    actual abstract operator fun invoke(input: I): O
    fun callAsFunction(input: I): O = invoke(input)
}