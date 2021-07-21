//
//  ViewController.swift
//
//  Created by Kenny on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var imgArr = ["flower_01", "flower_02", "flower_03", "flower_04", "flower_05", "flower_06", ]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        imgView.image = UIImage(named: imgArr[0])
        pageControl.numberOfPages = imgArr.count
        pageControl.currentPage = 0
        pageControl.pageIndicatorTintColor = UIColor.green
        pageControl.currentPageIndicatorTintColor = UIColor.red
        
        makeSingleTouch()
    }
    
    @IBAction func pageChange(_ sender: UIPageControl) {
        imgView.image = UIImage(named: imgArr[pageControl.currentPage])
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
                imgView.image = UIImage(named: imgArr[pageControl.currentPage])
            case UISwipeGestureRecognizer.Direction.right:
                if pageControl.currentPage == imgArr.count - 1{
                    return
                }
                pageControl.currentPage += 1
                imgView.image = UIImage(named: imgArr[pageControl.currentPage])
            default:
                break
            }
        }
    }
}


