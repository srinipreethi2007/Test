Sub CopySheetsToMaster()
    Dim sourceFolder As String
    Dim masterFile As String
    Dim fileExt As String
    Dim sourceFile As String
    Dim wbMaster As Workbook
    Dim wbSource As Workbook
    Dim ws As Worksheet
    
    'Set the source folder, master file, and file extension
    sourceFolder = "C:\FolderName\"
    masterFile = "Master.xlsx"
    fileExt = "*.xlsx"
    
    'Open the master file and create a new sheet
    Set wbMaster = Workbooks.Open(sourceFolder & masterFile)
    wbMaster.Sheets.Add(After:=wbMaster.Sheets(wbMaster.Sheets.Count)).Name = "Combined"
    
    'Loop through all files in the source folder with the specified file extension
    sourceFile = Dir(sourceFolder & fileExt)
    Do While sourceFile <> ""
        'Open the source file and loop through all sheets
        Set wbSource = Workbooks.Open(sourceFolder & sourceFile)
        For Each ws In wbSource.Worksheets
            'Copy the sheet to the master file's Combined sheet
            ws.Copy after:=wbMaster.Sheets(wbMaster.Sheets.Count)
        Next ws
        wbSource.Close SaveChanges:=False
        sourceFile = Dir
    Loop
    
    'Save and close the master file
    wbMaster.SaveAs Filename:=sourceFolder & "Combined.xlsx"
    wbMaster.Close SaveChanges:=False
End Sub
