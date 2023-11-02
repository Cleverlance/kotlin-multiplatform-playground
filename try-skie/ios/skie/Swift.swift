import Multiplatform

func main() {
    
    KotlinKt.voidFunction()
    //    KotlinKt.kotlinOnlyFunction()
    
    KotlinKt.nothingFunction()
    //    KotlinKt.throwsFunction()
    
    KotlinKt.intFunction(a: 0, b: nil)
    
//    KotlinKt.listFunction().append("")
    KotlinKt.mutableListFunction().add("")
    
//    KotlinKt.readOnlyProperty = ""
    KotlinKt.readWriteProperty = ""
    
    Class()

    Object()
    Object.shared

    let city = City.newyork
    switch city {
    case .london:
        print("London")
    case .paris:
        print ("Paris")
    case .newyork:
        print ("New York")
//    default:
//        print("There are no guarantees")
    }

    let user = User(firstName: "First", lastName: "Last")
    user.doCopy(firstName: "First", lastName: "Last")

    let ultraUser = UltraUser(firstName: "First", lastName: "Last")
    ultraUser.doCopy(firstName: "First", lastName: "Last")
    ultraUser.doCopy(firstName: "First")
    ultraUser.doCopy(lastName: "Last")
    ultraUser.doCopy()

    let superUser = SuperUser(firstName: "First", lastName: "Last")
    superUser.doCopy(firstName: "First", lastName: "Last")
    superUser.doCopy(first: "First", last: "Last")
    superUser.doCopy(first: "First")
    superUser.doCopy(last: "Last")
    superUser.doCopy()

    let animal: Animal = AnimalDinosaur.shared
    switch onEnum(of: animal) {
    case .dog(let dog):
        print("Dog " + dog.lives.description)
    case .dinosaur:
        print("Dinosaur")
//    default:
//        print("There are no guarantees")
    }
    
    let interface: Interface = ImplementationOfInterface()
    interface.get()

    let abstractClass: AbstractClass = ImplementationOfAbstractClass()
    abstractClass.get()
    
    let login = LoginUseCase()
    login.invoke(input: user)
    login.callAsFunction(input: user)
    login(input: user)
        
    Task {
        try await KotlinKt.doSomethingAsync(input: "1")
    }
    
    let userFlow: SkieSwiftFlow<User> = UseCaseKt.observeUserFlow()
    Task {
        for await user in userFlow {
            print(user.description())
        }
    }
    
    let observeUser = ObserveUserUseCase()
    let observeUserFlow: SkieSwiftFlow<User> = observeUser(input: KotlinUnit())
    Task {
        for await user in observeUserFlow {
            print(user.description())
        }
    }
    
    Task {
        try await UseCaseKt.saveUser()
    }
    
    let saveUser = SaveUserUseCase()
    Task {
        try await skie(saveUser)(input:user) // skie() is a wrapper around generic class
    }
    
    KoinApplication.Companion.shared
}
