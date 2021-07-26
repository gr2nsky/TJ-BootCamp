//
//  ViewController.swift
//  IosLecture
//
//  Created by 윤재필 on 2021/07/23.
//
import UIKit
import Kanna

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        dataCrawling()
        }
    
    func dataCrawling(){
        let mainUrl = "https://www.rottentomatoes.com/top/bestofrt/?year=2019"
        guard let main = URL(string: mainUrl) else {
            print("Error : \(mainUrl) doesnt't seem to be a valid URL")
            return
        }
        do {
            // *[@id="top_movies_main"]/div/table/tobody/tr[1]/td[3]/a
            let htmlData = try String(contentsOf: main, encoding: .utf8)
            let doc = try HTML(html: htmlData, encoding: .utf8)
            var count = 1
            for title in doc.xpath("//*[@id='top_movies_main']/div/table/tr/td/a"){
                print(count, title.text!.trimmingCharacters(in: .whitespacesAndNewlines))
                count += 1
            }
            
        } catch let error {
            print("Error: \(error)")
        }
    }
    
}//ViewController
