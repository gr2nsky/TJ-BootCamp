//
//  DetailViewController.swift
//  IosLecture
//
//  Created by 윤재필 on 2021/07/26.
//
import WebKit
import UIKit

class DetailViewController: UIViewController {
    
    @IBOutlet weak var myWebView: WKWebView!
    @IBOutlet weak var myActivityIndicator: UIActivityIndicatorView!
    var inputedUrl: String = ""
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        loadWebPage()
    }
    
    func inputUrl(url: String){
        inputedUrl = url;
    }
    
    func loadWebPage(){
        let myUrl = URL(string: inputedUrl)
        let myRequest = URLRequest(url: myUrl!)
        myWebView.load(myRequest)
    }
    

} // ViewController

extension DetailViewController: WKNavigationDelegate{
    
    // Indicator 시작
    func webView(_ webView: WKWebView, didCommit navigation: WKNavigation!) {
        myActivityIndicator.startAnimating()
        myActivityIndicator.isHidden = false
    }
    
    // Indicator 종료
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        myActivityIndicator.stopAnimating()
        myActivityIndicator.isHidden = true
    }
    
    // Error 발생시
    func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
        myActivityIndicator.isHidden = true
    }
}
