//
//  JsonModel.swift
//  iosLec2
//
//  Created by 윤재필 on 2021/07/27.
//

import Foundation

protocol JsomModelProtocol{
    func itemDownloaded(items: NSMutableArray)
}

class JsonModel{
    var delegate: JsomModelProtocol!
    let urlPath = "http://192.168.2.4:8080/ios/student_query_ios.jsp"
    
    func downloadItems(){
        let url: URL = URL(string: urlPath)!
        let defualtSession = Foundation.URLSession(configuration: URLSessionConfiguration.default)
        let task = defualtSession.dataTask(with: url){(data, responds, error) in
            if error != nil{
                print("Failed to download data")
            } else {
                print("Data is download")
                self.parseJSON(data!)
            }
        }
        task.resume()
    }
    
    func parseJSON(_ data: Data){
        var jsonResult =  NSArray()
        do{
            jsonResult = try JSONSerialization.jsonObject(with: data, options: JSONSerialization.ReadingOptions.allowFragments) as! NSArray
        }catch let error as NSError{
            print(error)
        }
        
        var jsonElement = NSDictionary()
        let locations = NSMutableArray()
        
        for i in 0..<jsonResult.count{
            jsonElement = jsonResult[i] as! NSDictionary
            if let scode = jsonElement["code"] as? String,
               let sname = jsonElement["name"] as? String,
               let sdept = jsonElement["dept"] as? String,
               let sphone = jsonElement["phone"]  as? String{
                let query = DBModel(scode: scode, sname: sname, sdept: sdept, sphone: sphone)
                locations.add(query)
            }
        }
        DispatchQueue.main.async(execute: {() -> Void in
                    self.delegate.itemDownloaded(items: locations)
                })
    }
}
