//
//  ViewController.swift
//
//  Created by Kenny on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    @IBOutlet weak var pageController: UIPageControl!
    @IBOutlet weak var lblNum: UILabel!
    let numArray:[Int] = Array(1...11)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblNum.text = "1"
        lblNum.textColor = UIColor.red
        pageController.numberOfPages = numArray.count
        pageController.currentPage = 0
        pageController.pageIndicatorTintColor = UIColor.green
        pageController.currentPageIndicatorTintColor = UIColor.red
    }
    
    @IBAction func pageChange(_ sender: UIPageControl) {
        let crn = pageController.currentPage
        
        lblNum.text = String(crn)
        if(crn % 2 == 0) {
            lblNum.textColor = UIColor.blue
        } else {
            lblNum.textColor = UIColor.red
        }
    }
}
