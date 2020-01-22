call runcrud.bat
if %ERRORLEVEL% == 0 goto runbrowser
echo.
echo There were errors while compiling runcrud.bat - breaking work
goto fail

:runbrowser
start microsoft-edge:http://localhost:8080/crud/v1/task/getTasks
timeout 30
if %ERRORLEVEL% == 0 goto end
echo.
echo There were problems with running browser
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.