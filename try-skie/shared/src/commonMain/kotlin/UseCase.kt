import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

expect abstract class UseCase<in I : Any, out O : Any> constructor() {
    abstract operator fun invoke(input: I): O
}

class LoginUseCase : UseCase<User, Boolean>() {
    override fun invoke(input: User): Boolean {
        return true
    }
}

fun observeUserFlow(): Flow<User> {
    return emptyFlow()
}

expect abstract class FlowUseCase<in I : Any, out O : Any> constructor() {
    abstract operator fun invoke(input: I): Flow<O>
}

class ObserveUserUseCase : FlowUseCase<Unit, User>() {
    override fun invoke(input: Unit): Flow<User> {
        return emptyFlow()
    }
}

suspend fun saveUser() {
}

expect abstract class SuspendUseCase<in I : Any, out O : Any> constructor() {
    abstract suspend operator fun invoke(input: I): O
}

class SaveUserUseCase : SuspendUseCase<User, Unit>() {
    override suspend fun invoke(input: User) {
    }
}