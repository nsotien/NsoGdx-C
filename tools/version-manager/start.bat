@echo off
title CuongNSO Version Manager
chcp 65001 >nul
echo ============================================
echo   CuongNSO Version Manager - Khoi dong...
echo ============================================
echo.

:: Kiem tra Python
python --version >nul 2>&1
if %errorlevel% neq 0 (
    echo [LOI] Khong tim thay Python!
    echo.
    echo Vui long cai dat Python 3.8+ tai: https://www.python.org/downloads/
    echo Chon "Add python.exe to PATH" khi cai dat.
    echo.
    pause
    exit /b 1
)

echo [OK] Tim thay Python:
python --version
echo.

:: Kiem tra + cai dependencies
echo [*] Kiem tra thu vien Python...
python -c "import webview, PIL" >nul 2>&1
if %errorlevel% neq 0 (
    echo [*] Dang cai thu vien pywebview, Pillow...
    cd /d "%~dp0"
    python -m pip install --disable-pip-version-check pywebview Pillow
    if %errorlevel% neq 0 (
        echo [LOI] Khong cai duoc thu vien!
        echo        Chay thu cong: python -m pip install pywebview Pillow
        pause
        exit /b 1
    )
    echo [OK] Da cai dat thanh cong!
) else (
    echo [OK] Thu vien san sang.
)
echo.
echo [*] Dang mo cua so CuongNSO Version Manager (native window)...
echo.

cd /d "%~dp0"
python launch.py

echo.
echo [*] Tool da dong.
pause
