# Pruebas del sistema HuellaCarbono

Este proyecto usa pruebas con JUnit 4.13.2.

## Alcance

- Pruebas unitarias:
  - `EdificioTest`
  - `CarroTest`
  - `BicicletaTest`
- Pruebas funcionales:
  - `AppFunctionalTest`

## Casos cubiertos

- Calculo de huella de carbono para edificios.
- Calculo de intensidad energetica de edificios.
- Calculo de huella de carbono para carros.
- Calculo de costo anual de combustible.
- Calculo de huella de carbono para bicicletas electricas y no electricas.
- Calculo de calorias quemadas en bicicleta.
- Validaciones de datos invalidos.
- Generacion funcional del archivo de reporte.

## Ejecucion desde PowerShell

Estos comandos estan pensados para ejecutarse desde la carpeta raiz del repositorio:

```text
C:\Users\ADAN\OneDrive\Documentos\3-Universidad\3 cer semestre\Lenguaje de programación\Taller 5\HuellaCarbono
```

Compilar codigo fuente y pruebas:

```powershell
$ProjectRoot = Join-Path (Get-Location) 'Enter'
$JdkBin = 'C:\Program Files\Apache NetBeans\jdk\bin'
$JUnitJar = 'C:\Program Files\Apache NetBeans\platform\modules\ext\junit-4.13.2.jar'
$HamcrestJar = 'C:\Program Files\Apache NetBeans\platform\modules\ext\hamcrest-core-1.3.jar'
$Classpath = "$JUnitJar;$HamcrestJar"

New-Item -ItemType Directory -Force -Path "$ProjectRoot\test-bin" | Out-Null

$JavaFiles = @(
    Get-ChildItem -Path "$ProjectRoot\src" -Filter '*.java'
    Get-ChildItem -Path "$ProjectRoot\test" -Filter '*.java'
) | ForEach-Object { $_.FullName }

& "$JdkBin\javac.exe" -cp $Classpath -d "$ProjectRoot\test-bin" $JavaFiles
```

Ejecutar pruebas:

```powershell
$ProjectRoot = Join-Path (Get-Location) 'Enter'
$JdkBin = 'C:\Program Files\Apache NetBeans\jdk\bin'
$JUnitJar = 'C:\Program Files\Apache NetBeans\platform\modules\ext\junit-4.13.2.jar'
$HamcrestJar = 'C:\Program Files\Apache NetBeans\platform\modules\ext\hamcrest-core-1.3.jar'
$Classpath = "$ProjectRoot\test-bin;$JUnitJar;$HamcrestJar"

& "$JdkBin\java.exe" -cp $Classpath org.junit.runner.JUnitCore EdificioTest CarroTest BicicletaTest AppFunctionalTest
```

Resultado esperado:

```text
OK (15 tests)
```

Si ya estas ubicado dentro de la carpeta `Enter`, cambia la primera linea por:

```powershell
$ProjectRoot = Get-Location
```
