$baseDir = "src\main\java\folha_pagamento\tads"

function Move-And-Add-Package {
    param(
        [string]$File,
        [string]$SubDir,
        [string[]]$Imports
    )
    $source = $File
    $targetDir = "$baseDir\$($SubDir -replace '\.', '\')"
    $target = "$targetDir\$File"
    
    if (Test-Path $source) {
        $content = Get-Content $source -Raw
        $newContent = "package folha_pagamento.tads.$SubDir;`r`n`r`n"
        foreach ($imp in $Imports) {
            $newContent += "import folha_pagamento.tads.$imp;`r`n"
        }
        $newContent += "`r`n$content"
        Set-Content -Path $target -Value $newContent -Encoding UTF8
        Remove-Item $source
        Write-Host "Moved and updated $File to $target"
    } else {
        Write-Host "File $source not found."
    }
}

# Value Objects
Move-And-Add-Package "Dinheiro.java" "domain.valueobject" @()
Move-And-Add-Package "Horas.java" "domain.valueobject" @()
Move-And-Add-Package "Nome.java" "domain.valueobject" @()

# Domain Printer
Move-And-Add-Package "ImpressoraDeFolha.java" "domain.printer" @("domain.valueobject.*")

# Domain Services
Move-And-Add-Package "ContratoTrabalho.java" "domain.service" @("domain.valueobject.*", "domain.printer.*")
Move-And-Add-Package "RegraImposto.java" "domain.service" @("domain.valueobject.*")
Move-And-Add-Package "RegraHoraExtra.java" "domain.service" @("domain.valueobject.*")
Move-And-Add-Package "RegraDescontoHoras.java" "domain.service" @("domain.valueobject.*")

# Domain Entities
Move-And-Add-Package "Funcionario.java" "domain.entity" @("domain.valueobject.*", "domain.service.*", "domain.printer.*")
Move-And-Add-Package "Pagamento.java" "domain.entity" @("domain.valueobject.*", "domain.service.*", "domain.printer.*")

# Infrastructure Contrato
$infraContratoImports = @("domain.service.*", "domain.valueobject.*", "domain.printer.*")
Move-And-Add-Package "ContratoCLT.java" "infrastructure.contrato" $infraContratoImports
Move-And-Add-Package "ContratoEstagio.java" "infrastructure.contrato" $infraContratoImports
Move-And-Add-Package "ContratoPJ.java" "infrastructure.contrato" $infraContratoImports

# Infrastructure Tax
$infraTaxImports = @("domain.service.*", "domain.valueobject.*")
Move-And-Add-Package "ImpostoPadrao.java" "infrastructure.tax" $infraTaxImports
Move-And-Add-Package "ImpostoIsento.java" "infrastructure.tax" $infraTaxImports

# Infrastructure Rules
$infraRulesImports = @("domain.service.*", "domain.valueobject.*")
Move-And-Add-Package "HoraExtraPadrao.java" "infrastructure.rules" $infraRulesImports
Move-And-Add-Package "DescontoHorasPadrao.java" "infrastructure.rules" $infraRulesImports

# Infrastructure Printer
$infraPrinterImports = @("domain.printer.*", "domain.valueobject.*")
Move-And-Add-Package "ImprimirFolha.java" "infrastructure.printer" $infraPrinterImports

# Delete Principal.java
if (Test-Path "Principal.java") {
    Remove-Item "Principal.java"
    Write-Host "Deleted Principal.java"
}
