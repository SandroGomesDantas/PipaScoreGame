![](https://www.pipastudios.com/wp-content/uploads/thegem-logos/logo_760aef4edacac334666dc5afa61c92e9_1x.png)  
  
# PipaScoreGame  
API para controle de pontos de jogos  
  
  
### Objetivo:  
Disponibilizar uma API para controle do placar de pontuação de usuários  
  

## Operações disponíveis:

**GetHighScoreList:**

**URL:** {*baseURL*}/scoreControl?apiVersion=1  
**Método:** GET  
**Exemplo:** http://localhost:8081/scoreControl?apiVersion=1   
  
**AddUserScorePoints:**
  
**URL:** {*baseURL*}/scoreControl?apiVersion=1  
**Método:** POST  
**JSON:**  
{  
  "scorePoints": 0,  
  "userId": 0  
}   
**Exemplo:** http://localhost:8081/scoreControl?apiVersion=1  
{  
  "scorePoints": 1,  
  "userId": 1000  
}

**GetUserScore:**

**URL:** {*baseURL*}/scoreControl/{*userID*}?apiVersion=1  
**Método:** GET  
**Exemplo:** http://localhost:8081/scoreControl/1?apiVersion=1   


# Actuator
O Spring Actuator é uma ferramenta que disponibiliza endpoints para monitoração da saúde do ambiente.
**URL para acesso dos endpoints:** {*baseURL*}/actuator
**Exemplo:** http://localhost:8081/actuator

# JACOCO
O JACOCO fornece um relatório com informações sobre a cobertura dos testes unitários implementados no projeto.
O relatório é gerado pelo gradle utilizando a task ***jacocoTestCoverageVerification***, o relatório é gerado em HTML no seguinte caminho {*diretorio-base-projeto*}PipaScoreGame/build/reports/tests/test/index.html
**Exemplo:** file:///home/cin_sdantas/workspace/PipaScoreGame/build/reports/tests/test/index.html