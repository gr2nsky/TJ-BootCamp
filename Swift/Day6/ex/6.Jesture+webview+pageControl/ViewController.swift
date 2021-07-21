//
//  ViewController.swift
//
//  Created by Kenny on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    @IBOutlet weak var pageControl: UIPageControl!
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var indicator: UIActivityIndicatorView!
    
    let urls = ["www.naver.com", "www.nate.com", "www.daum.net", "www.google.com", "www.cnn.com", "www.youtube.com", "www.cbs.com", "www.github.com"]
    var maxArrayNum  = 0

    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        maxArrayNum = urls.count
        loadWebPage(url: "http://www.naver.com")
        webView.navigationDelegate = self
        pageControl.pageIndicatorTintColor = UIColor.green
        pageControl.currentPageIndicatorTintColor = UIColor.red
        pageControl.numberOfPages = urls.count
        pageControl.currentPage = 0
        makeSingleTouch()
    }
    
    func loadWebPage(url: String){
        let myUrl = URL(string: url)
        let myRequest = URLRequest(url: myUrl!)
        webView.load(myRequest)
    }
    
    @IBAction func pageChange(_ sender: Any) {
        let crn = pageControl.currentPage
        let url = urls[crn]
        
        loadWebPage(url: "http://" + url)
    }
    
    func makeSingleTouch(){
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeLeft.direction = UISwipeGestureRecognizer.Direction.left
        self.view.addGestureRecognizer(swipeLeft)
        
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeRight.direction = UISwipeGestureRecognizer.Direction.right
        self.view.addGestureRecognizer(swipeRight)
    }
    
    @objc func respondToSwipeGesture(_ gesture: UIGestureRecognizer){
        if let swipeGesture = gesture as? UISwipeGestureRecognizer{
            
            switch swipeGesture.direction {
            case UISwipeGestureRecognizer.Direction.left:
                if pageControl.currentPage == 0 {
                    return
                }
                pageControl.currentPage -= 1
                loadWebPage(url: urls[pageControl.currentPage])
            case UISwipeGestureRecognizer.Direction.right:
                if pageControl.currentPage == maxArrayNum - 1{
                    return
                }
                pageControl.currentPage += 1
                loadWebPage(url: urls[pageControl.currentPage])
            default:
                break
            }
        }
    }
}

extension ViewController: WKNavigationDelegate{
    //Indicator 시작
    func webView(_ webView: WKWebView, didCommit navigation: WKNavigation!) {
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
