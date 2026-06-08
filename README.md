# 🐾 BE Veterinária

Bem-vindo ao repositório backend da **Veterinária**! Este projeto contém toda a infraestrutura e lógica de negócio para gerenciar uma clínica veterinária moderna, incluindo agendamentos, pacientes animais, histórico médico e mais.

## 🎯 Objetivo

Fornecer uma solução completa e escalável para gerenciar operações de uma clínica veterinária, incluindo gestão de pacientes, agendamentos, consultas, medicamentos e histórico clínico dos animais.

## 🛠️ Tecnologias Utilizadas

- **Backend**: Node.js / Express (ou conforme configurado)
- **Banco de Dados**: PostgreSQL / MongoDB (conforme implementação)
- **Autenticação**: JWT
- **Deploy**: Docker / Kubernetes
- **API REST**: RESTful com documentação Swagger

## 📁 Estrutura do Projeto

```
.
├── src/
│   ├── controllers/     # 🎮 Controladores de rotas
│   ├── services/        # 🔧 Lógica de negócio
│   ├── models/          # 📊 Modelos de dados (Pacientes, Consultas, etc)
│   ├── routes/          # 🛣️ Definição de rotas
│   ├── middleware/      # 🚪 Middlewares personalizados
│   └── utils/           # 🛠️ Funções utilitárias
├── tests/               # ✅ Testes unitários e integração
├── config/              # ⚙️ Configurações da aplicação
└── docs/                # 📚 Documentação e Swagger
```

## 🚀 Como Começar

### Pré-requisitos

- Node.js v16+ instalado
- npm ou yarn
- Banco de dados configurado

### Instalação

1. **Clone o repositório:**
```bash
git clone https://github.com/leandroFilipy/BE-veterinaria.git
cd BE-veterinaria
```

2. **Instale as dependências:**
```bash
npm install
```

3. **Configure variáveis de ambiente:**
```bash
cp .env.example .env
```

4. **Inicie o servidor:**
```bash
npm start
```

## 📝 Variáveis de Ambiente

Configure no arquivo `.env`:

```env
PORT=3000
NODE_ENV=development
DATABASE_URL=postgresql://user:password@localhost:5432/veterinaria
JWT_SECRET=sua_chave_secreta_aqui
API_URL=http://localhost:3000
```

## 🔌 API Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/health` | ✅ Verificar status da API |
| GET | `/api/pacientes` | 🐶 Listar todos os pacientes (animais) |
| POST | `/api/pacientes` | ➕ Registrar novo paciente |
| GET | `/api/pacientes/:id` | 🔍 Detalhes de um paciente |
| PUT | `/api/pacientes/:id` | ✏️ Atualizar dados do paciente |
| DELETE | `/api/pacientes/:id` | 🗑️ Remover paciente |
| POST | `/api/agendamentos` | 📅 Agendar consulta |
| GET | `/api/agendamentos` | 📋 Listar agendamentos |
| PUT | `/api/agendamentos/:id` | ✏️ Atualizar agendamento |
| DELETE | `/api/agendamentos/:id` | ❌ Cancelar agendamento |
| POST | `/api/consultas` | 📝 Registrar consulta |
| GET | `/api/consultas/:pacienteId` | 📚 Histórico de consultas |
| POST | `/api/medicamentos` | 💊 Adicionar prescrição |
| GET | `/api/usuarios` | 👥 Listar usuários (veterinários) |

## 📊 Modelos de Dados Principais

### 🐾 Paciente (Animal)
```json
{
  "id": "uuid",
  "nome": "Rex",
  "especie": "Cachorro",
  "raca": "Labrador",
  "idade": 3,
  "peso": 28.5,
  "proprietario": "João Silva",
  "telefone": "(11) 99999-9999",
  "dataNascimento": "2023-01-15",
  "historico": []
}
```

### 📅 Agendamento
```json
{
  "id": "uuid",
  "pacienteId": "uuid",
  "veterinarioId": "uuid",
  "dataHora": "2026-06-15T14:30:00",
  "motivo": "Vacinação",
  "status": "confirmado"
}
```

### 📝 Consulta
```json
{
  "id": "uuid",
  "pacienteId": "uuid",
  "veterinarioId": "uuid",
  "agendamentoId": "uuid",
  "dataConsulta": "2026-06-15T14:30:00",
  "diagnostico": "Inflamação no ouvido",
  "prescricao": ["Medicamento A", "Medicamento B"],
  "observacoes": "Trazer animal em jejum na próxima consulta"
}
```

## ✅ Testes

Execute os testes com:

```bash
npm test
```

Para testes com cobertura:

```bash
npm run test:coverage
```

## 🐳 Docker

Para rodar a aplicação em container:

```bash
docker build -t veterinaria-api .
docker run -p 3000:3000 veterinaria-api
```

Com Docker Compose:

```bash
docker-compose up -d
```

## 📚 Documentação

Para mais informações, consulte a [documentação completa](./docs) do projeto.

A documentação da API Swagger estará disponível em:
```
http://localhost:3000/api-docs
```

## 🤝 Contribuindo

1. 🍴 Faça um fork do projeto
2. 🌱 Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. 💾 Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. 📤 Push para a branch (`git push origin feature/AmazingFeature`)
5. 📬 Abra um Pull Request

## 📋 Código de Conduta

Por favor, leia nosso [Código de Conduta](./CODE_OF_CONDUCT.md) para entender os padrões de comportamento esperados.

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.

## 👤 Autor

**Leandro Veterinária**
- 📧 Email: contato@leandrofab.com.br
- 🔗 Website: [www.leandroveterinaria.com.br](https://www.leandroveterinaria.com.br)

## ⚠️ Disclaimer

Este software é destinado exclusivamente para uso em clínicas e consultórios veterinários. Certifique-se de estar em conformidade com todas as leis e regulamentações locais de proteção de dados de saúde animal.

## 🙏 Agradecimentos

Agradecemos a todos os contribuidores e membros da equipe pelo apoio e dedicação! 🎉

---

⭐ Se este projeto foi útil, considere deixar uma estrela!

🐾 **Cuidando da saúde dos seus pets com tecnologia!** 🐾
