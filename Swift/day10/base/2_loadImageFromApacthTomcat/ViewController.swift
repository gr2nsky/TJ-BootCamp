//
//  ViewController.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/27.
//

import UIKit

class ViewController: UIViewController {
    
    let hostIP = "192.168.2.4"

    @IBOutlet weak var imgView: UIImageView!
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    //>>>>>>>>>>>>>>>>>>>옛날방식
    @IBAction func btnIV1(_ sender: UIButton) {
        let url:URL = URL(string: "http://192.168.2.4:8080/ios/flower_01.png")!
        let defualtSession = Foundation.URLSession(configuration: URLSessionConfiguration.default)
        let task = defualtSession.dataTask(with: url){ (data, response, error) in
            if error != nil{
                print("Failed to download data")
            } else {
                print("data is downloaded")
                DispatchQueue.main.async {
                    self.imgView.image = UIImage(data: data!)
                    if let image = UIImage(data: data!){
                        if let data = image.pngData(){
                            let filename = self.getDocumentDirectory().appendingPathComponent("copy.png")
                            try? data.write(to: filename)
                        }
                    }
                }
            }
        }
        task.resume()
    }
    func getDocumentDirectory() -> URL{
        let paths = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
        return paths[0]
    }
    
    
    //>>>>>>>>>>>>>>>>>>요즘방식
    @IBAction func btnIV2(_ sender: UIButton) {
        let url = URL(string: "http://192.168.2.4:8080/ios/flower_02.png")
        let data = try? Data(contentsOf: url!)
        imgView.image = UIImage(data: data!)
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
