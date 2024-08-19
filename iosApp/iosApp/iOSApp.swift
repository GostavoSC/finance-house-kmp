import SwiftUI
import Foundation
import UIKit
import ComposeApp

@main
struct iOSApp: App {
    
    init() {
          KoinModuleKt.doInitKoin { Koin_coreKoinApplication in}
      }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}