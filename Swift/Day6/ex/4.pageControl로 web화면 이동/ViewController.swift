//
//  ViewController.swift
//
//  Created by Kenny on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lblUrl: UILabel!
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var indicator: UIActivityIndicatorView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    let urls = ["www.naver.com", "www.nate.com", "www.daum.net", "www.google.com", "www.cnn.com", "www.youtube.com", "www.cbs.com", "www.github.com"]
    var maxArrayNum  = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lblUrl.text = urls[0]
        maxArrayNum = urls.count
        loadWebPage(url: "http://www.naver.com")
        webView.navigationDelegate = self
        pageControl.pageIndicatorTintColor = UIColor.green
        pageControl.currentPageIndicatorTintColor = UIColor.red
        pageControl.numberOfPages = urls.count
        pageControl.currentPage = 0
    }
    
    @IBAction func pageChange(_ sender: UIPageControl) {
        let crn = pageControl.currentPage
        let url = urls[crn]
        
        lblUrl.text = urls[crn]
        loadWebPage(url: "http://" + url)
    }
    
    func loadWebPage(url: String){
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }
}

extension ViewController: WKNavigationDelegate{
    //Indicator 시작
    func webView(_ webView: WKWebView, didCommit navigation: WKNavigation!) {ㅌ₩
        indicator.isHidden = false
    }
    
    //Indicator 종료
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        indicator.stopAnimating()
        indicator.isHidden = true
    }
    
    //Error 발생시
    func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
        indicator.isHidden = true
    }
}
