@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

import kotlinx.coroutines.flow.Flow

actual abstract class UseCase<in I : Any, out O : Any> {
    actual abstract operator fun invoke(input: I): O
    fun callAsFunction(input: I): O = invoke(input)
}

actual abstract class FlowUseCase<in I : Any, out O : Any> {
    actual abstract operator fun invoke(input: I): Flow<O>
    fun callAsFunction(input: I): Flow<O> = invoke(input)
}

actual abstract class SuspendUseCase<in I : Any, out O : Any> {
    actual abstract suspend operator fun invoke(input: I): O
    suspend fun callAsFunction(input: I): O = invoke(input)
}