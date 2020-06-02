import express from 'express';
import graphqlHTTP from 'express-graphql';
import {buildSchema} from 'graphql';
import path from 'path';
import cors from 'cors';

const port = 3000;

const schema = buildSchema(`
type Query {
  task: String
}`);

const resolver = {
  task: () => {
    return 'Setup Graphql';
  }
}

const app = express();

app.use(cors());

app.use('/graphql', graphqlHTTP({
  schema: schema,
  rootValue: resolver,
  graphiql: true
}));

app.get('/', (req, res) => res.send('Hello World!'));

app.get('/obs-youtube-player.html', (req, res) => res.sendFile(path.join(__dirname, 'obs-youtube-player.html')));
app.get('/styles.less', (req, res) => res.sendFile(path.join(__dirname, 'styles.less')));

app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`));