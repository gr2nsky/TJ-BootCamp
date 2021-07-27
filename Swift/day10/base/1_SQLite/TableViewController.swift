//
//  TableViewController.swift
//  IosLecture
//
//  Created by 윤재필 on 2021/07/27.
//

import UIKit
import SQLite3 // << SQLite

class TableViewController: UITableViewController {
    
    @IBOutlet var tvListView: UITableView!
    
    var studentList: [Students] = []
    var db: OpaquePointer? //C언어의 pointer

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        //SQLite 생성하기
        let fileURL = try! FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: false).appendingPathComponent("StudentsData.sqlite")
        
        if sqlite3_open(fileURL.path, &db) != SQLITE_OK {
            print("error opening database")
        }
        
        if sqlite3_exec(db, "CREATE TABLE IF NOT EXISTS students(sid INTEGER PRIMARY KEY AUTOINCREMENT, sname TEXT, sdept TEXT, sphone TEXT)", nil, nil, nil) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db))
            print("error creating table \(errmsg)")
        }
        
        //Temporary Insert
        tempInsert()
        
        readValues()
        
    }
    
    override func viewWillAppear(_ animated: Bool) {
        let fileURL = try! FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: false).appendingPathComponent("StudentsData.sqlite")
        
        if sqlite3_open(fileURL.path, &db) != SQLITE_OK {
            print("error opening database")
        } else {
            readValues()
        }
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return studentList.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        let students: Students
        students = studentList[indexPath.row]
        
        cell.textLabel?.text = "학번 : \(students.id)"
        cell.detailTextLabel?.text = "성명 \(students.name!)" //subTitle
        
        return cell
    }
    
    func tempInsert(){
        var stmt: OpaquePointer?
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)//한글깨짐 방지, 한글 2바이트 영어 3바이트
        
        let queryString = "INSERT INTO students (sname, sdept, sphone) VALUES (?, ? ,?)"
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK {
            let errmsg = String(cString: sqlite3_errmsg(db))
            print("error prparing insert \(errmsg)")
            return
        }
        
        if sqlite3_bind_text(stmt, 1, "유비", -1, SQLITE_TRANSIENT) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db))
            print("error binding name \(errmsg)")
            return
            
        }
        
        if sqlite3_bind_text(stmt, 2, "컴퓨터공학과", -1, SQLITE_TRANSIENT) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db))
            print("error binding dept \(errmsg)")
            return
        }
        
        if sqlite3_bind_text(stmt, 3, "1234", -1, SQLITE_TRANSIENT) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db))
            print("error binding phone \(errmsg)")
            return
        }
        
        if sqlite3_step(stmt) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db))
            print("error inserting student \(errmsg)")
            return
        }
        
        print("Student saved succesfuly")

    }
    
    func readValues(){
        studentList.removeAll()
        
        let queryString = "SELECT * FROM students"
        
        var stmt: OpaquePointer?
        
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db))
            print("error preparing  select \(errmsg)")
            return
        }
        
        //한줄씩 가져오기
        while(sqlite3_step(stmt) == SQLITE_ROW){
            let id = sqlite3_column_int(stmt, 0)
            let name = String(cString: sqlite3_column_text(stmt, 1))
            let dept = String(cString: sqlite3_column_text(stmt, 2))
            let phone = String(cString: sqlite3_column_text(stmt, 3))
            
            print(id, name, dept, phone)
            
            studentList.append(Students(id: Int(id), name: String(name), dept: String(dept), phone: String(phone)))
        }
        
        self.tvListView.reloadData()
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
