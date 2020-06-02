import { h, Component } from 'preact';
import { ApolloProvider } from '@apollo/react-hooks';
import ApolloClient from 'apollo-boost';
import { gql } from 'apollo-boost';

const client = new ApolloClient({
	//uri: 'https://api.spacex.land/graphql/',
	uri: 'http://localhost:3000/graphql/',
	onError: console.error
});

import Music from './music/Music';
import Task from './task/Task';
import Popup from './popup/Popup';

export default class App extends Component {
	
	render() {
		return (
			<ApolloProvider client={client}>
				<div id="app">
					<div id="music"><Music /></div>
					<div id="task"><Task /></div>
					<div id="popup"><Popup /></div>
				</div>
			</ApolloProvider>
		);
	}
}
