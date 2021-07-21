//
//  ViewController.swift
//
//  Created by Kenny on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    @IBOutlet weak var prickerView: UIPickerView!
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var indicatorView: UIActivityIndicatorView!
    
    let urls = [("www.naver.com", "네이버"), ("www.nate.com", "네이트"), ("www.daum.net", "다음"), ("www.google.com", "구글"), ("www.cnn.com", "CNN"), ("www.youtube.com", "유튜브"), ("www.cbs.com", "CBS"), ("www.github.com", "깃허브")]
    let viewColumn = 1
    var maxArrayNum  = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        maxArrayNum = urls.count
        
        loadWebPage(url: "http://www.naver.com")
        webView.navigationDelegate = self
        prickerView.dataSource = self
        prickerView.delegate = self
    }
    
    //page load
    func loadWebPage(url: String){
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }
}
//WKNavigationDelegate
extension ViewController: WKNavigationDelegate{
    //Indicator 시작
    func webView(_ webView: WKWebView, didCommit navigation: WKNavigation!) {
        indicatorView.isHidden = false
    }
    
    //Indicator 종료
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        indicatorView.stopAnimating()
        indicatorView.isHidden = true
    }
    
    //Error 발생시
    func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
        indicatorView.isHidden = true
    }
}

//PickerView
extension ViewController: UIPickerViewDataSource{
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumn
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
    
    
}

extension ViewController: UIPickerViewDelegate{
    //title 입력
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return urls[row].1
    }
    
    //webView 출력
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        loadWebPage(url: "http://" + urls[row].0)
    }
}
