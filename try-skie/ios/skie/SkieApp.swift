import SwiftUI
import Multiplatform

@main
struct SkieApp: App {
    var body: some Scene {
        WindowGroup {
            Text("Hello " + City.london.name)
        }
    }
}
