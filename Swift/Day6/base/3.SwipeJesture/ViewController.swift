//
//  ViewController.swift
//
//  Created by Kenny on 2021/07/21.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    @IBOutlet weak var imgViewUp: UIImageView!
    @IBOutlet weak var imgVIewDown: UIImageView!
    @IBOutlet weak var imgViewLeft: UIImageView!
    @IBOutlet weak var imgViewRight: UIImageView!
    
    var imageUp = [UIImage]()
    var imageDown = [UIImage]()
    var imageLeft = [UIImage]()
    var imageRight = [UIImage]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //image 초기설정
        makeImages()
        
        //초기 이미지
        imgViewUp.image = imageUp[0]
        imgVIewDown.image = imageDown[0]
        imgViewLeft.image = imageLeft[0]
        imgViewRight.image = imageRight[0]
        
        //한손가락 제스쳐 설정
        makeSingleTouch()
        
        //두손가락 제스쳐 설정
        makeDoubleTouch()
    }
    
    func makeImages(){
        imageUp.append(UIImage(named: "arrow-up-black.png")!)
        imageDown.append(UIImage(named: "arrow-down-black.png")!)
        imageLeft.append(UIImage(named: "arrow-left-black.png")!)
        imageRight.append(UIImage(named: "arrow-right-black.png")!)
        
        imageUp.append(UIImage(named: "arrow-up-red.png")!)
        imageDown.append(UIImage(named: "arrow-down-red.png")!)
        imageLeft.append(UIImage(named: "arrow-left-red.png")!)
        imageRight.append(UIImage(named: "arrow-right-red.png")!)
        
        imageUp.append(UIImage(named: "arrow-up-green.png")!)
        imageDown.append(UIImage(named: "arrow-down-green.png")!)
        imageLeft.append(UIImage(named: "arrow-left-green.png")!)
        imageRight.append(UIImage(named: "arrow-right-green.png")!)
        
        
    }
    
    func makeSingleTouch(){
        let swipeUp = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeUp.direction = UISwipeGestureRecognizer.Direction.up
        self.view.addGestureRecognizer(swipeUp)
        
        let swipeDown = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeDown.direction = UISwipeGestureRecognizer.Direction.down
        self.view.addGestureRecognizer(swipeDown)
        
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeLeft.direction = UISwipeGestureRecognizer.Direction.left
        self.view.addGestureRecognizer(swipeLeft)
        
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGesture(_:)))
        swipeRight.direction = UISwipeGestureRecognizer.Direction.right
        self.view.addGestureRecognizer(swipeRight)
        
    }
    
    @objc func respondToSwipeGesture(_ gesture: UIGestureRecognizer){
        if let swipeGesture = gesture as? UISwipeGestureRecognizer{
            imgViewUp.image = imageUp[0]
            imgVIewDown.image = imageDown[0]
            imgViewLeft.image = imageLeft[0]
            imgViewRight.image = imageRight[0]
            
            switch swipeGesture.direction {
            case UISwipeGestureRecognizer.Direction.up:
                imgViewUp.image = imageUp[1]
            case UISwipeGestureRecognizer.Direction.down:
                imgVIewDown.image = imageDown[1]
            case UISwipeGestureRecognizer.Direction.left:
                imgViewLeft.image = imageLeft[1]
            case UISwipeGestureRecognizer.Direction.right:
                imgViewRight.image = imageRight[1]
            default:
                break
            }
        }
    }
    
    @objc func respondToSwipeGestureMulti(_ gesture: UIGestureRecognizer){
        if let swipeGesture = gesture as? UISwipeGestureRecognizer{
            // 무조건 초기값 만들어 주고 나서
            imgViewUp.image = imageUp[0]
            imgVIewDown.image = imageDown[0]
            imgViewLeft.image = imageLeft[0]
            imgViewRight.image = imageRight[0]
            
            switch swipeGesture.direction {
            case UISwipeGestureRecognizer.Direction.up:
                imgViewUp.image = imageUp[2]
            case UISwipeGestureRecognizer.Direction.down:
                imgVIewDown.image = imageDown[2]
            case UISwipeGestureRecognizer.Direction.left:
                imgViewLeft.image = imageLeft[2]
            case UISwipeGestureRecognizer.Direction.right:
                imgViewRight.image = imageRight[2]
            default:
                break
            }
        }
    }
    
    func makeDoubleTouch(){
        let swipeUp = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGestureMulti(_:)))
        swipeUp.direction = UISwipeGestureRecognizer.Direction.up
        swipeUp.numberOfTouchesRequired = 2
        self.view.addGestureRecognizer(swipeUp)
        
        let swipeDown = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGestureMulti(_:)))
        swipeDown.direction = UISwipeGestureRecognizer.Direction.down
        swipeDown.numberOfTouchesRequired = 2
        self.view.addGestureRecognizer(swipeDown)
        
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGestureMulti(_:)))
        swipeLeft.direction = UISwipeGestureRecognizer.Direction.left
        swipeLeft.numberOfTouchesRequired = 2
        self.view.addGestureRecognizer(swipeLeft)
        
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondToSwipeGestureMulti(_:)))
        swipeRight.direction = UISwipeGestureRecognizer.Direction.right
        swipeRight.numberOfTouchesRequired = 2
        self.view.addGestureRecognizer(swipeRight)
    }
}
