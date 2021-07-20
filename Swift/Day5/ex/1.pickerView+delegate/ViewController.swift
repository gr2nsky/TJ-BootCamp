//
//  ViewController.swift
//  Quiz02
//
//  Created by Kenny on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var pickerView: UIPickerView!
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var lblName: UILabel!
    
    var imageFileNames = ["w1.jpg", "w2.jpg", "w3.jpg", "w4.jpg", "w5.jpg", "w6.jpg", "w7.jpg", "w8.jpg", "w9.jpg", "w10.jpg"]
    var imageArray = [UIImage?]()
    var maxArrayNum = 0
    let viewColumnn = 1

    override func viewDidLoad() {
        super.viewDidLoad()
        maxArrayNum = imageFileNames.count
        
        for i in 0..<maxArrayNum{
            let image = UIImage(named: imageFileNames[i])
            imageArray.append(image)
        }
        
        lblName.text = imageFileNames[0]
        imageView.image = imageArray[0]
        
        pickerView.dataSource = self
        pickerView.delegate = self
    }
    
} // ViewController


extension ViewController: UIPickerViewDataSource{
    // 피커뷰 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumnn
    }
    // 출력할 이미지 파일 갯수
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
}

extension ViewController: UIPickerViewDelegate{
    //피커뷰에 title 입히기
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return imageFileNames[row]
    }
    
    //피커뷰 이미지 선택
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        lblName.text = imageFileNames[row]
        imageView.image = imageArray[row]
    }
}
