//
//  ViewController.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/27.
//

import UIKit

class ViewController: UIViewController {
    
    var ivList: [UIImage] = []
    var count = 0

    @IBOutlet weak var imgView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadIV()
    }
    
    func loadIV(){
        for i in 1...6{
            let addr = "http://192.168.2.4:8080/ios/flower_0\(i).png"
            print(addr)
            let url = URL(string: addr)
            let data = try? Data(contentsOf: url!)
            let downIV = UIImage(data: data!)
            
            ivList.append(downIV!)
        }
        imgView.image = ivList[0]
    }
    
    @IBAction func btnBefore(_ sender: Any) {
        count == 0 ? (count = 5) : (count -= 1)
        imgView.image = ivList[count]
    }
    
    
    @IBAction func btnNext(_ sender: Any) {
        count == 5 ? (count = 0) : (count += 1)
        imgView.image = ivList[count]
    }
    

    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
}
