# Camunda Loan Flow
:gear: Repo for Camunda Loan Flow 

This is an implementation of `Camunda Orchestration` for `Microservices` whit `Java`. 

0️⃣ - The first flow is the main flow where define a Loan contraction exemple. :point_down:

![The Main Flow](/img/CamundaMainFlow.png)

1️⃣ - The first sub-flow is the flow where the data of Automobiles :blue_car: and Real Estate :house: declared by the customer for the loan evaluation are searched. :point_down:

![SubFlowConsultaBens](/img/SubFlowConsultaBens.png)

2️⃣ - The second sub-flow is the flow where the data of name restrictions are searched :mag_right: . :point_down:

![SubFlowConsultaRestricoesCliente](/img/SubFlowConsultaRestricoesCliente.png)

3️⃣ - The third sub-flow and the last one for this first implementation is the flow where the data of name restrictions are registered for future avaliations :clock4: . :point_down:

![SubFlowCadastroRiscoCliente](/img/SubFlowCadastroRiscoCliente.png)
