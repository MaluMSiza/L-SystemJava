# Sistema L-System em Java

Este é um programa em Java que interpreta um sistema L-System e gera um arquivo SVG com base nas regras definidas.

- `axioma`: O axioma inicial do sistema L-System.
- `numeroDeLoops`: O número de iterações para aplicar as regras do sistema.
- `valorEmGraus`: O valor em graus para girar.
- `regras`: As regras do sistema L-System. Cada regra consiste em um caractere seguido por uma sequência de substituição.


- "F" = anda 9 pixels
- "+" = soma 72 graus
- "-" = subtrai 72 graus

- F-F-F-F-F//------->Axioma
- 4//--------------->numero de loops
- 72//-------------->valor em graus
- 1//--------------->numero de regras
- F=F-F-F++F+F-F//-->regra 1
