
Sub CombineFiles()
    
    Dim Path As String
    Dim FileName As String
    Dim SheetName As String
    Dim MasterSheet As Worksheet
    Dim SourceWorkbook As Workbook
    Dim TargetWorkbook As Workbook
    
    'Change the path to the folder that contains the files you want to combine
    Path = "C:\Users\UserName\Desktop\Files\"
    
    'Change the name of the master workbook to the name you want
    Set TargetWorkbook = Workbooks.Add
    TargetWorkbook.SaveAs Filename:="Combined.xlsx"
    Set MasterSheet = TargetWorkbook.Sheets(1)
    
    FileName = Dir(Path & "*.xlsx")
    
    Do While FileName <> ""
        Set SourceWorkbook = Workbooks.Open(Path & FileName)
        For Each Sheet In SourceWorkbook.Sheets
            Sheet.Copy After:=MasterSheet
            Set MasterSheet = ActiveSheet
        Next Sheet
        SourceWorkbook.Close False
        FileName = Dir()
    Loop
    
    'Save and close the target workbook
    TargetWorkbook.Save
    TargetWorkbook.Close
    
End Sub
