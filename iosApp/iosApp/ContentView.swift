import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {

 func makeUIViewController(context: Context) -> UIViewController {
        let viewController = MainViewControllerKt.MainViewController()
        viewController.additionalSafeAreaInsets = UIEdgeInsets(top: -6, left: 0, bottom: 0, right: 0)
        // Definir a cor da Status Bar
        if let window = UIApplication.shared.windows.first {
            let statusBarHeight = window.windowScene?.statusBarManager?.statusBarFrame.height ?? 0
//            let statusBarHeight: CGFloat = 65

            let statusBarView = UIView(frame: CGRect(x: 0, y: 0, width: UIScreen.main.bounds.width, height: statusBarHeight))
            statusBarView.backgroundColor =  UIColor(red: 6.0/255.0, green: 64.0/255.0, blue: 106.0/255.0, alpha: 1.0) // Definir a cor desejada (azul)

            window.addSubview(statusBarView)
        }

        return viewController
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .edgesIgnoringSafeArea(.all)
    }
}
