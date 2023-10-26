import kotlinx.coroutines.flow.Flow

actual abstract class UseCase<in I : Any, out O : Any> {
    actual abstract operator fun invoke(input: I): O
    fun callAsFunction(input: I): O = invoke(input)
}

actual abstract class FlowUseCase<in I : Any, out O : Any> {
    actual abstract operator fun invoke(input: I): Flow<O>
    fun callAsFunction(input: I): Flow<O> = invoke(input)
}