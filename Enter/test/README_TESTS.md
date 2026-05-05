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

## Ejecucion desde terminal

Compilar codigo fuente y pruebas:

```powershell
New-Item -ItemType Directory -Force -Path test-bin | Out-Null
& 'C:\Program Files\Apache NetBeans\jdk\bin\javac.exe' -cp 'C:\Program Files\Apache NetBeans\platform\modules\ext\junit-4.13.2.jar;C:\Program Files\Apache NetBeans\platform\modules\ext\hamcrest-core-1.3.jar' -d test-bin src\*.java test\*.java
```

Ejecutar pruebas:

```powershell
& 'C:\Program Files\Apache NetBeans\jdk\bin\java.exe' -cp 'test-bin;C:\Program Files\Apache NetBeans\platform\modules\ext\junit-4.13.2.jar;C:\Program Files\Apache NetBeans\platform\modules\ext\hamcrest-core-1.3.jar' org.junit.runner.JUnitCore EdificioTest CarroTest BicicletaTest AppFunctionalTest
```

Resultado esperado:

```text
OK (15 tests)
```
