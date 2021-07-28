//
//  TableViewController.swift
//  Created by 윤재필 on 2021/07/28.
//

import UIKit

class TableViewController: UITableViewController {

    @IBOutlet var listTableView: UITableView!
    var feedItem: NSArray = NSArray()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let jsonModel = JsonModel()
        jsonModel.delegate = self
        jsonModel.downloadItems()
        
        //cell 디자인을 custom을 사용하므로 cell 디자인 정의를 해주어야 한다
        listTableView.rowHeight = 124
        
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return feedItem.count
    }

    //as! TableViewCell로 우리가 커스텀한 TableViewCell 적용
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath) as! TableViewCell

        let item: DBModel = feedItem[indexPath.row] as! DBModel
        
        //기존 subtitle로 셀 생성했을때 쓴 부분
        //cell.textLabel?.text = "성명 : \(item.sname!)"
        //cell.detailTextLabel?.text = "학번 : \(item.scode!)"
        
        //커스텀셀을 쓰므로 그에 맞게 설정
        cell.lblCode.text = "학번 : \(item.scode!)"
        cell.lblName.text = "성명 : \(item.sname!)"
        cell.lblDept.text = "전공 : \(item.sdept!)"
        cell.lblPhone.text = "전화 : \(item.sphone!)"
        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}

extension TableViewController: JsomModelProtocol{
    func itemDownloaded(items: NSArray) {
        feedItem = items
        self.listTableView.reloadData()
    }
    
    

}
