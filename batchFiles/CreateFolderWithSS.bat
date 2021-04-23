@echo off    
set temp=%DATE:/=%
set dirname="%temp:~8,4%%temp:~6,2%%temp:~4,2%"
mkdir %dirname%
copy P:\6.BatchFiles\Req_Res.docx %dirname%\Req_Res.docx
