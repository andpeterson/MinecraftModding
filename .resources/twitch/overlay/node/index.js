"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var express_1 = __importDefault(require("express"));
var express_graphql_1 = __importDefault(require("express-graphql"));
var graphql_1 = require("graphql");
var path_1 = __importDefault(require("path"));
var cors_1 = __importDefault(require("cors"));
var port = 3000;
var schema = graphql_1.buildSchema("\ntype Query {\n  task: String\n}");
var resolver = {
    task: function () {
        return 'Setup Graphql';
    }
};
var app = express_1.default();
app.use(cors_1.default());
app.use('/graphql', express_graphql_1.default({
    schema: schema,
    rootValue: resolver,
    graphiql: true
}));
app.get('/', function (req, res) { return res.send('Hello World!'); });
app.get('/obs-youtube-player.html', function (req, res) { return res.sendFile(path_1.default.join(__dirname, 'obs-youtube-player.html')); });
app.get('/styles.less', function (req, res) { return res.sendFile(path_1.default.join(__dirname, 'styles.less')); });
app.listen(port, function () { return console.log("Example app listening at http://localhost:" + port); });
