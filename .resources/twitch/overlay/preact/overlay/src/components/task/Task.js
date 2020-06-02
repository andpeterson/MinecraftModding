import {useState} from 'preact/hooks';
import {useQuery} from '@apollo/react-hooks';
import { gql } from 'apollo-boost';

/*
const TASK_QUERY = gql`
query {
  rockets(limit: 1) {
    name
  }
}
`*/
const TASK_QUERY = gql`
query {
  task
}
`

const Task = (props) => {
  const [task, setTask] = useState("undefined");

  const {data, loading, error} = useQuery(TASK_QUERY);
  return data ? <div id='text'>{`Task: ${data.task}`}</div> : null
}

export default Task;