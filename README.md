# PwC_Code_Java

## Tecnologias usadas:
linguagem: Java
Testes: JUnit
Interface: Swing
Convertor para .exe: Eclipse

## Funções Principais

### simpleAddress(String)
Esta função principal separa casos simples de endereços como "Miritiba 339", caso não seja simple ele redireciona para outro metodo realizar a separação e retornar uma lista. No fim ele retorna uma String com o nome e numero separado

##### Parâmetros:
address (str): Uma string contendo informações de endereço.
##### Retorno:
String: Uma string formatada com o nome e o número separados, encapsulados por chaves.

## Funções Auxiliares
### biggeraddress(List<String>)
Extrai o nome e o número de um endereço mais complexo como "Quirino dos Santos 23 b".

##### Parâmetros:
listOfWords (list): Uma lista de palavras representando as informações de endereço.
##### Retorno:
list: Uma lista contendo o nome e o número separados.

### foreignerAddress(List<String>, num)
Extrai o nome e o número de um endereço estrangeiro como "4, Rue de la République". e usa o numero para selecionar o caso correto

##### Parâmetros:
listOfWords (list), num (int): Uma lista de palavras representando as informações de endereço e um numero para cada caso.
##### Retorno:
list: Uma lista contendo o nome e o número separados.

### isForeignerAddress(List<String>)
Verifica se o endereço é estrangeiro com base em determinados critérios.

##### Parâmetros:
listOfWords (list): Uma lista de palavras representando as informações de endereço.
##### Retorno:
num: um numero entre 1 e 4 se o endereço for considerado estrangeiro, 0 caso contrário.

### has_number(String)
Verifica se uma palavra contém um dígito numérico.

##### Parâmetros:
str (str): Uma string representando uma palavra.
##### Retorno:
bool: True se a palavra contiver um dígito numérico, False caso contrário.

## Como rodar:

#### Primeira forma:
Baixe o exe e clique no Address_Splitter.jar

#### Segunda forma:
Baixe os arquivos, escolha uma IDE para rodar, baixe Java, rode o Address_Splitter.java


## Resultado

![Resultado](img/result.jpg)
