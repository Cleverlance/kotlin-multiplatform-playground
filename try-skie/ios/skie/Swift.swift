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
    default:
        print("There are no guarantees")
    }

    let user = User(firstName: "First", lastName: "Last")

    let animal: Animal = AnimalDinosaur.shared
    switch animal {
    case let dog as AnimalDog:
        print("Dog " + dog.lives.description)
    case is AnimalDinosaur:
        print("Dinosaur")
    default:
        print("There are no guarantees")
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
        try await KotlinKt.doSomethingAsync(input: "1") // Cancellation not propagated
    }
}
