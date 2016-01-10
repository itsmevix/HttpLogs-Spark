# HttpLogs-Spark
Versão do challenge de Big Data usando Spark ao invés de Hadoop com HDFS e Scala ao invés de Java.

- O arquivo .scala com o código fonte está no diretório src/main/scala.
- httpBalanced.txt é arquivo texto com os registros não ordenados e está inserido de maneira fixa no código.
- OutputLogs é o diretório com todos os arquivos de output gerados (1 arquivo para cada UUID) e o caminho também está fixo no código.
- HttpLogs.sbt é o arquivo para configurar a build com o sbt, incluindo dependências.
- O resto dos arquivos e diretórios foram gerados quando o sbt/scalac compilou o código.
