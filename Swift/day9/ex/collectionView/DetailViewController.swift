//
//  DetailViewController.swift
//  IosLecture
//
//  Created by 윤재필 on 2021/07/26.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    
    var receiveItem: UIImage = UIImage(named: "flower_01")!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        imageView.image = receiveItem
    }
    
    func receiveItems(_ item: String){
        receiveItem = UIImage(named: item)!
    }
    
}
