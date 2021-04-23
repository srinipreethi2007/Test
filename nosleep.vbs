set wsc = CreateObject("WScript.Shell")
Do
    'Five minutes
    WScript.Sleep(2*60*1000)
    wsc.SendKeys("{F13}")
Loop