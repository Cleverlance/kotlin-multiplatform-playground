expect abstract class UseCase<in I : Any, out O : Any> constructor() {
    abstract operator fun invoke(input: I): O
}

class LoginUseCase : UseCase<User, Boolean>() {
    override fun invoke(input: User): Boolean {
        return true
    }
}